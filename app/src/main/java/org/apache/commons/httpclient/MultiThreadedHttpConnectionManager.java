package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.commons.httpclient.params.DefaultHttpParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.IdleConnectionHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MultiThreadedHttpConnectionManager
  implements HttpConnectionManager
{
  private static WeakHashMap ALL_CONNECTION_MANAGERS;
  public static final int DEFAULT_MAX_HOST_CONNECTIONS = 2;
  public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;
  private static final Log LOG;
  private static final ReferenceQueue REFERENCE_QUEUE;
  private static ReferenceQueueThread REFERENCE_QUEUE_THREAD;
  private static final Map REFERENCE_TO_CONNECTION_SOURCE;
  static Class class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager;
  private ConnectionPool connectionPool = new ConnectionPool(null);
  private HttpConnectionManagerParams params = new HttpConnectionManagerParams();
  private boolean shutdown = false;
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager == null)
    {
      localClass = class$("org.apache.commons.httpclient.MultiThreadedHttpConnectionManager");
      class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager = localClass;
    }
    for (;;)
    {
      LOG = LogFactory.getLog(localClass);
      REFERENCE_TO_CONNECTION_SOURCE = new HashMap();
      REFERENCE_QUEUE = new ReferenceQueue();
      ALL_CONNECTION_MANAGERS = new WeakHashMap();
      return;
      localClass = class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager;
    }
  }
  
  public MultiThreadedHttpConnectionManager()
  {
    synchronized (ALL_CONNECTION_MANAGERS)
    {
      ALL_CONNECTION_MANAGERS.put(this, null);
      return;
    }
  }
  
  static Class class$(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }
  
  private HostConfiguration configurationForConnection(HttpConnection paramHttpConnection)
  {
    HostConfiguration localHostConfiguration = new HostConfiguration();
    localHostConfiguration.setHost(paramHttpConnection.getHost(), paramHttpConnection.getPort(), paramHttpConnection.getProtocol());
    if (paramHttpConnection.getLocalAddress() != null) {
      localHostConfiguration.setLocalAddress(paramHttpConnection.getLocalAddress());
    }
    if (paramHttpConnection.getProxyHost() != null) {
      localHostConfiguration.setProxy(paramHttpConnection.getProxyHost(), paramHttpConnection.getProxyPort());
    }
    return localHostConfiguration;
  }
  
  /* Error */
  private HttpConnection doGetConnection(HostConfiguration paramHostConfiguration, long paramLong)
    throws ConnectionPoolTimeoutException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:params	Lorg/apache/commons/httpclient/params/HttpConnectionManagerParams;
    //   4: aload_1
    //   5: invokevirtual 180	org/apache/commons/httpclient/params/HttpConnectionManagerParams:getMaxConnectionsPerHost	(Lorg/apache/commons/httpclient/HostConfiguration;)I
    //   8: istore 4
    //   10: aload_0
    //   11: getfield 70	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:params	Lorg/apache/commons/httpclient/params/HttpConnectionManagerParams;
    //   14: invokevirtual 183	org/apache/commons/httpclient/params/HttpConnectionManagerParams:getMaxTotalConnections	()I
    //   17: istore 5
    //   19: aload_0
    //   20: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   23: astore 6
    //   25: aload 6
    //   27: monitorenter
    //   28: new 134	org/apache/commons/httpclient/HostConfiguration
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 186	org/apache/commons/httpclient/HostConfiguration:<init>	(Lorg/apache/commons/httpclient/HostConfiguration;)V
    //   36: astore 7
    //   38: aload_0
    //   39: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   42: aload 7
    //   44: invokevirtual 190	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:getHostPool	(Lorg/apache/commons/httpclient/HostConfiguration;)Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool;
    //   47: astore 9
    //   49: lload_2
    //   50: lconst_0
    //   51: lcmp
    //   52: ifle +425 -> 477
    //   55: iconst_1
    //   56: istore 10
    //   58: goto +404 -> 462
    //   61: aload 15
    //   63: ifnull +9 -> 72
    //   66: aload 6
    //   68: monitorexit
    //   69: aload 15
    //   71: areturn
    //   72: aload_0
    //   73: getfield 72	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:shutdown	Z
    //   76: ifeq +25 -> 101
    //   79: new 192	java/lang/IllegalStateException
    //   82: dup
    //   83: ldc 194
    //   85: invokespecial 195	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   88: astore 17
    //   90: aload 17
    //   92: athrow
    //   93: astore 8
    //   95: aload 6
    //   97: monitorexit
    //   98: aload 8
    //   100: athrow
    //   101: aload 9
    //   103: getfield 201	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool:freeConnections	Ljava/util/LinkedList;
    //   106: invokevirtual 206	java/util/LinkedList:size	()I
    //   109: ifle +17 -> 126
    //   112: aload_0
    //   113: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   116: aload 7
    //   118: invokevirtual 210	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:getFreeConnection	(Lorg/apache/commons/httpclient/HostConfiguration;)Lorg/apache/commons/httpclient/HttpConnection;
    //   121: astore 15
    //   123: goto -62 -> 61
    //   126: aload 9
    //   128: getfield 213	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool:numConnections	I
    //   131: iload 4
    //   133: if_icmpge +29 -> 162
    //   136: aload_0
    //   137: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   140: invokestatic 217	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:access$200	(Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;)I
    //   143: iload 5
    //   145: if_icmpge +17 -> 162
    //   148: aload_0
    //   149: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   152: aload 7
    //   154: invokevirtual 220	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:createConnection	(Lorg/apache/commons/httpclient/HostConfiguration;)Lorg/apache/commons/httpclient/HttpConnection;
    //   157: astore 15
    //   159: goto -98 -> 61
    //   162: aload 9
    //   164: getfield 213	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool:numConnections	I
    //   167: iload 4
    //   169: if_icmpge +41 -> 210
    //   172: aload_0
    //   173: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   176: invokestatic 224	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:access$300	(Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;)Ljava/util/LinkedList;
    //   179: invokevirtual 206	java/util/LinkedList:size	()I
    //   182: ifle +28 -> 210
    //   185: aload_0
    //   186: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   189: invokevirtual 227	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:deleteLeastUsedConnection	()V
    //   192: aload_0
    //   193: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   196: aload 7
    //   198: invokevirtual 220	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:createConnection	(Lorg/apache/commons/httpclient/HostConfiguration;)Lorg/apache/commons/httpclient/HttpConnection;
    //   201: astore 30
    //   203: aload 30
    //   205: astore 15
    //   207: goto -146 -> 61
    //   210: iload 10
    //   212: ifeq +57 -> 269
    //   215: lload 11
    //   217: lconst_0
    //   218: lcmp
    //   219: ifgt +50 -> 269
    //   222: new 174	org/apache/commons/httpclient/ConnectionPoolTimeoutException
    //   225: dup
    //   226: ldc 229
    //   228: invokespecial 230	org/apache/commons/httpclient/ConnectionPoolTimeoutException:<init>	(Ljava/lang/String;)V
    //   231: astore 29
    //   233: aload 29
    //   235: athrow
    //   236: astore 28
    //   238: aload 16
    //   240: astore 22
    //   242: iload 10
    //   244: ifeq +18 -> 262
    //   247: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   250: lstore 24
    //   252: lload 11
    //   254: lload 24
    //   256: lload 13
    //   258: lsub
    //   259: lsub
    //   260: lstore 11
    //   262: aload 22
    //   264: astore 16
    //   266: goto -205 -> 61
    //   269: getstatic 47	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:LOG	Lorg/apache/commons/logging/Log;
    //   272: invokeinterface 242 1 0
    //   277: ifeq +31 -> 308
    //   280: getstatic 47	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:LOG	Lorg/apache/commons/logging/Log;
    //   283: new 244	java/lang/StringBuffer
    //   286: dup
    //   287: invokespecial 245	java/lang/StringBuffer:<init>	()V
    //   290: ldc 247
    //   292: invokevirtual 251	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   295: aload 7
    //   297: invokevirtual 254	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   300: invokevirtual 257	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   303: invokeinterface 261 2 0
    //   308: aload 16
    //   310: ifnonnull +145 -> 455
    //   313: new 263	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$WaitingThread
    //   316: dup
    //   317: aconst_null
    //   318: invokespecial 266	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$WaitingThread:<init>	(Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$1;)V
    //   321: astore 22
    //   323: aload 22
    //   325: aload 9
    //   327: putfield 270	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$WaitingThread:hostConnectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool;
    //   330: aload 22
    //   332: invokestatic 276	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   335: putfield 280	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$WaitingThread:thread	Ljava/lang/Thread;
    //   338: iload 10
    //   340: ifeq +8 -> 348
    //   343: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   346: lstore 13
    //   348: aload 9
    //   350: getfield 283	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool:waitingThreads	Ljava/util/LinkedList;
    //   353: aload 22
    //   355: invokevirtual 286	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
    //   358: aload_0
    //   359: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   362: invokestatic 289	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:access$500	(Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;)Ljava/util/LinkedList;
    //   365: aload 22
    //   367: invokevirtual 286	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
    //   370: aload_0
    //   371: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   374: lload 11
    //   376: invokevirtual 293	java/lang/Object:wait	(J)V
    //   379: aload 9
    //   381: getfield 283	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool:waitingThreads	Ljava/util/LinkedList;
    //   384: aload 22
    //   386: invokevirtual 297	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   389: pop
    //   390: aload_0
    //   391: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   394: invokestatic 289	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:access$500	(Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;)Ljava/util/LinkedList;
    //   397: aload 22
    //   399: invokevirtual 297	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   402: pop
    //   403: iload 10
    //   405: ifeq +78 -> 483
    //   408: lload 11
    //   410: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   413: lload 13
    //   415: lsub
    //   416: lsub
    //   417: lstore 11
    //   419: goto +64 -> 483
    //   422: iload 10
    //   424: ifeq +13 -> 437
    //   427: lload 11
    //   429: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   432: lload 13
    //   434: lsub
    //   435: lsub
    //   436: pop2
    //   437: aload 18
    //   439: athrow
    //   440: astore 8
    //   442: goto -347 -> 95
    //   445: astore 18
    //   447: goto -25 -> 422
    //   450: astore 23
    //   452: goto -210 -> 242
    //   455: aload 16
    //   457: astore 22
    //   459: goto -121 -> 338
    //   462: lload_2
    //   463: lstore 11
    //   465: lconst_0
    //   466: lstore 13
    //   468: aconst_null
    //   469: astore 15
    //   471: aconst_null
    //   472: astore 16
    //   474: goto -413 -> 61
    //   477: iconst_0
    //   478: istore 10
    //   480: goto -18 -> 462
    //   483: aload 22
    //   485: astore 16
    //   487: goto -426 -> 61
    //   490: astore 18
    //   492: aload 16
    //   494: pop
    //   495: goto -73 -> 422
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	this	MultiThreadedHttpConnectionManager
    //   0	498	1	paramHostConfiguration	HostConfiguration
    //   0	498	2	paramLong	long
    //   8	162	4	i	int
    //   17	129	5	j	int
    //   23	73	6	localConnectionPool	ConnectionPool
    //   36	260	7	localHostConfiguration	HostConfiguration
    //   93	6	8	localObject1	Object
    //   440	1	8	localObject2	Object
    //   47	333	9	localHostConnectionPool	HostConnectionPool
    //   56	423	10	k	int
    //   215	38	11	localObject3	Object
    //   260	204	11	l1	long
    //   256	1	13	localObject4	Object
    //   346	121	13	l2	long
    //   61	409	15	localObject5	Object
    //   238	255	16	localObject6	Object
    //   88	3	17	localIllegalStateException	IllegalStateException
    //   437	1	18	localObject7	Object
    //   445	1	18	localObject8	Object
    //   490	1	18	localObject9	Object
    //   240	244	22	localObject10	Object
    //   450	1	23	localInterruptedException1	InterruptedException
    //   250	5	24	l3	long
    //   236	1	28	localInterruptedException2	InterruptedException
    //   231	3	29	localConnectionPoolTimeoutException	ConnectionPoolTimeoutException
    //   201	3	30	localHttpConnection	HttpConnection
    // Exception table:
    //   from	to	target	type
    //   38	49	93	finally
    //   66	69	93	finally
    //   72	93	93	finally
    //   101	123	93	finally
    //   126	159	93	finally
    //   162	203	93	finally
    //   247	252	93	finally
    //   408	419	93	finally
    //   427	437	93	finally
    //   437	440	93	finally
    //   222	236	236	java/lang/InterruptedException
    //   269	308	236	java/lang/InterruptedException
    //   313	323	236	java/lang/InterruptedException
    //   28	38	440	finally
    //   323	338	445	finally
    //   343	348	445	finally
    //   348	403	445	finally
    //   323	338	450	java/lang/InterruptedException
    //   343	348	450	java/lang/InterruptedException
    //   348	403	450	java/lang/InterruptedException
    //   222	236	490	finally
    //   269	308	490	finally
    //   313	323	490	finally
  }
  
  private static void removeReferenceToConnection(HttpConnectionWithReference paramHttpConnectionWithReference)
  {
    synchronized (REFERENCE_TO_CONNECTION_SOURCE)
    {
      REFERENCE_TO_CONNECTION_SOURCE.remove(paramHttpConnectionWithReference.reference);
      return;
    }
  }
  
  public static void shutdownAll()
  {
    synchronized (REFERENCE_TO_CONNECTION_SOURCE)
    {
      synchronized (ALL_CONNECTION_MANAGERS)
      {
        Iterator localIterator = ALL_CONNECTION_MANAGERS.keySet().iterator();
        if (!localIterator.hasNext())
        {
          if (REFERENCE_QUEUE_THREAD != null)
          {
            REFERENCE_QUEUE_THREAD.shutdown();
            REFERENCE_QUEUE_THREAD = null;
          }
          REFERENCE_TO_CONNECTION_SOURCE.clear();
          return;
        }
        MultiThreadedHttpConnectionManager localMultiThreadedHttpConnectionManager = (MultiThreadedHttpConnectionManager)localIterator.next();
        localIterator.remove();
        localMultiThreadedHttpConnectionManager.shutdown();
      }
    }
  }
  
  private static void shutdownCheckedOutConnections(ConnectionPool paramConnectionPool)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator2;
      synchronized (REFERENCE_TO_CONNECTION_SOURCE)
      {
        Iterator localIterator1 = REFERENCE_TO_CONNECTION_SOURCE.keySet().iterator();
        if (!localIterator1.hasNext())
        {
          localIterator2 = localArrayList.iterator();
          if (localIterator2.hasNext()) {}
        }
        else
        {
          Reference localReference = (Reference)localIterator1.next();
          if (((ConnectionSource)REFERENCE_TO_CONNECTION_SOURCE.get(localReference)).connectionPool != paramConnectionPool) {
            continue;
          }
          localIterator1.remove();
          HttpConnection localHttpConnection1 = (HttpConnection)localReference.get();
          if (localHttpConnection1 == null) {
            continue;
          }
          localArrayList.add(localHttpConnection1);
        }
      }
      HttpConnection localHttpConnection2 = (HttpConnection)localIterator2.next();
      localHttpConnection2.close();
      localHttpConnection2.setHttpConnectionManager(null);
      localHttpConnection2.releaseConnection();
    }
  }
  
  private static void storeReferenceToConnection(HttpConnectionWithReference paramHttpConnectionWithReference, HostConfiguration paramHostConfiguration, ConnectionPool paramConnectionPool)
  {
    ConnectionSource localConnectionSource = new ConnectionSource(null);
    localConnectionSource.connectionPool = paramConnectionPool;
    localConnectionSource.hostConfiguration = paramHostConfiguration;
    synchronized (REFERENCE_TO_CONNECTION_SOURCE)
    {
      if (REFERENCE_QUEUE_THREAD == null)
      {
        REFERENCE_QUEUE_THREAD = new ReferenceQueueThread();
        REFERENCE_QUEUE_THREAD.start();
      }
      REFERENCE_TO_CONNECTION_SOURCE.put(paramHttpConnectionWithReference.reference, localConnectionSource);
      return;
    }
  }
  
  public void closeIdleConnections(long paramLong)
  {
    this.connectionPool.closeIdleConnections(paramLong);
  }
  
  public void deleteClosedConnections()
  {
    this.connectionPool.deleteClosedConnections();
  }
  
  public HttpConnection getConnection(HostConfiguration paramHostConfiguration)
  {
    for (;;)
    {
      try
      {
        HttpConnection localHttpConnection = getConnectionWithTimeout(paramHostConfiguration, 0L);
        return localHttpConnection;
      }
      catch (ConnectionPoolTimeoutException localConnectionPoolTimeoutException)
      {
        LOG.debug("Unexpected exception while waiting for connection", localConnectionPoolTimeoutException);
      }
    }
  }
  
  public HttpConnection getConnection(HostConfiguration paramHostConfiguration, long paramLong)
    throws HttpException
  {
    LOG.trace("enter HttpConnectionManager.getConnection(HostConfiguration, long)");
    try
    {
      HttpConnection localHttpConnection = getConnectionWithTimeout(paramHostConfiguration, paramLong);
      return localHttpConnection;
    }
    catch (ConnectionPoolTimeoutException localConnectionPoolTimeoutException)
    {
      throw new HttpException(localConnectionPoolTimeoutException.getMessage());
    }
  }
  
  public HttpConnection getConnectionWithTimeout(HostConfiguration paramHostConfiguration, long paramLong)
    throws ConnectionPoolTimeoutException
  {
    LOG.trace("enter HttpConnectionManager.getConnectionWithTimeout(HostConfiguration, long)");
    if (paramHostConfiguration == null) {
      throw new IllegalArgumentException("hostConfiguration is null");
    }
    if (LOG.isDebugEnabled()) {
      LOG.debug("HttpConnectionManager.getConnection:  config = " + paramHostConfiguration + ", timeout = " + paramLong);
    }
    return new HttpConnectionAdapter(doGetConnection(paramHostConfiguration, paramLong));
  }
  
  public int getConnectionsInPool()
  {
    synchronized (this.connectionPool)
    {
      int i = this.connectionPool.numConnections;
      return i;
    }
  }
  
  public int getConnectionsInPool(HostConfiguration paramHostConfiguration)
  {
    synchronized (this.connectionPool)
    {
      int i = this.connectionPool.getHostPool(paramHostConfiguration).numConnections;
      return i;
    }
  }
  
  public int getConnectionsInUse()
  {
    return getConnectionsInPool();
  }
  
  public int getConnectionsInUse(HostConfiguration paramHostConfiguration)
  {
    return getConnectionsInPool(paramHostConfiguration);
  }
  
  public int getMaxConnectionsPerHost()
  {
    return this.params.getDefaultMaxConnectionsPerHost();
  }
  
  public int getMaxTotalConnections()
  {
    return this.params.getMaxTotalConnections();
  }
  
  public HttpConnectionManagerParams getParams()
  {
    return this.params;
  }
  
  public boolean isConnectionStaleCheckingEnabled()
  {
    return this.params.isStaleCheckingEnabled();
  }
  
  public void releaseConnection(HttpConnection paramHttpConnection)
  {
    LOG.trace("enter HttpConnectionManager.releaseConnection(HttpConnection)");
    if ((paramHttpConnection instanceof HttpConnectionAdapter)) {
      paramHttpConnection = ((HttpConnectionAdapter)paramHttpConnection).getWrappedConnection();
    }
    SimpleHttpConnectionManager.finishLastResponse(paramHttpConnection);
    this.connectionPool.freeConnection(paramHttpConnection);
  }
  
  public void setConnectionStaleCheckingEnabled(boolean paramBoolean)
  {
    this.params.setStaleCheckingEnabled(paramBoolean);
  }
  
  public void setMaxConnectionsPerHost(int paramInt)
  {
    this.params.setDefaultMaxConnectionsPerHost(paramInt);
  }
  
  public void setMaxTotalConnections(int paramInt)
  {
    this.params.setMaxTotalConnections(paramInt);
  }
  
  public void setParams(HttpConnectionManagerParams paramHttpConnectionManagerParams)
  {
    if (paramHttpConnectionManagerParams == null) {
      throw new IllegalArgumentException("Parameters may not be null");
    }
    this.params = paramHttpConnectionManagerParams;
  }
  
  /* Error */
  public void shutdown()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 72	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:shutdown	Z
    //   13: ifne +15 -> 28
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 72	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:shutdown	Z
    //   21: aload_0
    //   22: getfield 79	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:connectionPool	Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;
    //   25: invokevirtual 475	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:shutdown	()V
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_3
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_3
    //   37: athrow
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	MultiThreadedHttpConnectionManager
    //   38	4	1	localObject1	Object
    //   33	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	28	33	finally
    //   28	30	33	finally
    //   2	9	38	finally
    //   34	38	38	finally
  }
  
  private class ConnectionPool
  {
    private LinkedList freeConnections = new LinkedList();
    private IdleConnectionHandler idleConnectionHandler = new IdleConnectionHandler();
    private final Map mapHosts = new HashMap();
    private int numConnections = 0;
    private LinkedList waitingThreads = new LinkedList();
    
    private ConnectionPool() {}
    
    ConnectionPool(MultiThreadedHttpConnectionManager.1 param1)
    {
      this();
    }
    
    private void deleteConnection(HttpConnection paramHttpConnection)
    {
      try
      {
        HostConfiguration localHostConfiguration = MultiThreadedHttpConnectionManager.this.configurationForConnection(paramHttpConnection);
        if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
          MultiThreadedHttpConnectionManager.LOG.debug("Reclaiming connection, hostConfig=" + localHostConfiguration);
        }
        paramHttpConnection.close();
        MultiThreadedHttpConnectionManager.HostConnectionPool localHostConnectionPool = getHostPool(localHostConfiguration);
        localHostConnectionPool.freeConnections.remove(paramHttpConnection);
        localHostConnectionPool.numConnections = (-1 + localHostConnectionPool.numConnections);
        this.numConnections = (-1 + this.numConnections);
        this.idleConnectionHandler.remove(paramHttpConnection);
        return;
      }
      finally {}
    }
    
    public void closeIdleConnections(long paramLong)
    {
      try
      {
        this.idleConnectionHandler.closeIdleConnections(paramLong);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public HttpConnection createConnection(HostConfiguration paramHostConfiguration)
    {
      try
      {
        MultiThreadedHttpConnectionManager.HostConnectionPool localHostConnectionPool = getHostPool(paramHostConfiguration);
        if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
          MultiThreadedHttpConnectionManager.LOG.debug("Allocating new connection, hostConfig=" + paramHostConfiguration);
        }
        MultiThreadedHttpConnectionManager.HttpConnectionWithReference localHttpConnectionWithReference = new MultiThreadedHttpConnectionManager.HttpConnectionWithReference(paramHostConfiguration);
        localHttpConnectionWithReference.getParams().setDefaults(MultiThreadedHttpConnectionManager.this.params);
        localHttpConnectionWithReference.setHttpConnectionManager(MultiThreadedHttpConnectionManager.this);
        this.numConnections = (1 + this.numConnections);
        localHostConnectionPool.numConnections = (1 + localHostConnectionPool.numConnections);
        MultiThreadedHttpConnectionManager.storeReferenceToConnection(localHttpConnectionWithReference, paramHostConfiguration, this);
        return localHttpConnectionWithReference;
      }
      finally {}
    }
    
    /* Error */
    public void deleteClosedConnections()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 27	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:freeConnections	Ljava/util/LinkedList;
      //   6: invokevirtual 148	java/util/AbstractSequentialList:iterator	()Ljava/util/Iterator;
      //   9: astore_2
      //   10: aload_2
      //   11: invokeinterface 153 1 0
      //   16: istore_3
      //   17: iload_3
      //   18: ifne +6 -> 24
      //   21: aload_0
      //   22: monitorexit
      //   23: return
      //   24: aload_2
      //   25: invokeinterface 157 1 0
      //   30: checkcast 89	org/apache/commons/httpclient/HttpConnection
      //   33: astore 4
      //   35: aload 4
      //   37: invokevirtual 160	org/apache/commons/httpclient/HttpConnection:isOpen	()Z
      //   40: ifne -30 -> 10
      //   43: aload_2
      //   44: invokeinterface 162 1 0
      //   49: aload_0
      //   50: aload 4
      //   52: invokespecial 164	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:deleteConnection	(Lorg/apache/commons/httpclient/HttpConnection;)V
      //   55: goto -45 -> 10
      //   58: astore_1
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_1
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	ConnectionPool
      //   58	4	1	localObject	Object
      //   9	35	2	localIterator	Iterator
      //   16	2	3	bool	boolean
      //   33	18	4	localHttpConnection	HttpConnection
      // Exception table:
      //   from	to	target	type
      //   2	10	58	finally
      //   10	17	58	finally
      //   24	55	58	finally
    }
    
    /* Error */
    public void deleteLeastUsedConnection()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 27	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:freeConnections	Ljava/util/LinkedList;
      //   6: invokevirtual 168	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
      //   9: checkcast 89	org/apache/commons/httpclient/HttpConnection
      //   12: astore_2
      //   13: aload_2
      //   14: ifnull +11 -> 25
      //   17: aload_0
      //   18: aload_2
      //   19: invokespecial 164	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:deleteConnection	(Lorg/apache/commons/httpclient/HttpConnection;)V
      //   22: aload_0
      //   23: monitorexit
      //   24: return
      //   25: invokestatic 61	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:access$700	()Lorg/apache/commons/logging/Log;
      //   28: invokeinterface 67 1 0
      //   33: ifeq -11 -> 22
      //   36: invokestatic 61	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:access$700	()Lorg/apache/commons/logging/Log;
      //   39: ldc 170
      //   41: invokeinterface 87 2 0
      //   46: goto -24 -> 22
      //   49: astore_1
      //   50: aload_0
      //   51: monitorexit
      //   52: aload_1
      //   53: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	54	0	this	ConnectionPool
      //   49	4	1	localObject	Object
      //   12	7	2	localHttpConnection	HttpConnection
      // Exception table:
      //   from	to	target	type
      //   2	13	49	finally
      //   17	22	49	finally
      //   25	46	49	finally
    }
    
    public void freeConnection(HttpConnection paramHttpConnection)
    {
      HostConfiguration localHostConfiguration = MultiThreadedHttpConnectionManager.this.configurationForConnection(paramHttpConnection);
      if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
        MultiThreadedHttpConnectionManager.LOG.debug("Freeing connection, hostConfig=" + localHostConfiguration);
      }
      try
      {
        if (MultiThreadedHttpConnectionManager.this.shutdown)
        {
          paramHttpConnection.close();
          return;
        }
        MultiThreadedHttpConnectionManager.HostConnectionPool localHostConnectionPool = getHostPool(localHostConfiguration);
        localHostConnectionPool.freeConnections.add(paramHttpConnection);
        if (localHostConnectionPool.numConnections == 0)
        {
          MultiThreadedHttpConnectionManager.LOG.error("Host connection pool not found, hostConfig=" + localHostConfiguration);
          localHostConnectionPool.numConnections = 1;
        }
        this.freeConnections.add(paramHttpConnection);
        MultiThreadedHttpConnectionManager.removeReferenceToConnection((MultiThreadedHttpConnectionManager.HttpConnectionWithReference)paramHttpConnection);
        if (this.numConnections == 0)
        {
          MultiThreadedHttpConnectionManager.LOG.error("Host connection pool not found, hostConfig=" + localHostConfiguration);
          this.numConnections = 1;
        }
        this.idleConnectionHandler.add(paramHttpConnection);
        notifyWaitingThread(localHostConnectionPool);
        return;
      }
      finally {}
    }
    
    /* Error */
    public HttpConnection getFreeConnection(HostConfiguration paramHostConfiguration)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_1
      //   4: invokevirtual 96	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:getHostPool	(Lorg/apache/commons/httpclient/HostConfiguration;)Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool;
      //   7: astore_3
      //   8: aload_3
      //   9: getfield 99	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool:freeConnections	Ljava/util/LinkedList;
      //   12: invokevirtual 200	java/util/LinkedList:size	()I
      //   15: ifle +84 -> 99
      //   18: aload_3
      //   19: getfield 99	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HostConnectionPool:freeConnections	Ljava/util/LinkedList;
      //   22: invokevirtual 168	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
      //   25: checkcast 116	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HttpConnectionWithReference
      //   28: astore 5
      //   30: aload_0
      //   31: getfield 27	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:freeConnections	Ljava/util/LinkedList;
      //   34: aload 5
      //   36: invokevirtual 103	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
      //   39: pop
      //   40: aload 5
      //   42: aload_1
      //   43: aload_0
      //   44: invokestatic 141	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:access$900	(Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$HttpConnectionWithReference;Lorg/apache/commons/httpclient/HostConfiguration;Lorg/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool;)V
      //   47: invokestatic 61	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:access$700	()Lorg/apache/commons/logging/Log;
      //   50: invokeinterface 67 1 0
      //   55: ifeq +30 -> 85
      //   58: invokestatic 61	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:access$700	()Lorg/apache/commons/logging/Log;
      //   61: new 69	java/lang/StringBuffer
      //   64: dup
      //   65: invokespecial 70	java/lang/StringBuffer:<init>	()V
      //   68: ldc 202
      //   70: invokevirtual 76	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   73: aload_1
      //   74: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
      //   77: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   80: invokeinterface 87 2 0
      //   85: aload_0
      //   86: getfield 39	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager$ConnectionPool:idleConnectionHandler	Lorg/apache/commons/httpclient/util/IdleConnectionHandler;
      //   89: aload 5
      //   91: invokevirtual 106	org/apache/commons/httpclient/util/IdleConnectionHandler:remove	(Lorg/apache/commons/httpclient/HttpConnection;)V
      //   94: aload_0
      //   95: monitorexit
      //   96: aload 5
      //   98: areturn
      //   99: invokestatic 61	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:access$700	()Lorg/apache/commons/logging/Log;
      //   102: invokeinterface 67 1 0
      //   107: istore 4
      //   109: aconst_null
      //   110: astore 5
      //   112: iload 4
      //   114: ifeq -20 -> 94
      //   117: invokestatic 61	org/apache/commons/httpclient/MultiThreadedHttpConnectionManager:access$700	()Lorg/apache/commons/logging/Log;
      //   120: new 69	java/lang/StringBuffer
      //   123: dup
      //   124: invokespecial 70	java/lang/StringBuffer:<init>	()V
      //   127: ldc 204
      //   129: invokevirtual 76	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   132: aload_1
      //   133: invokevirtual 79	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
      //   136: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   139: invokeinterface 87 2 0
      //   144: aconst_null
      //   145: astore 5
      //   147: goto -53 -> 94
      //   150: astore_2
      //   151: aload_0
      //   152: monitorexit
      //   153: aload_2
      //   154: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	155	0	this	ConnectionPool
      //   0	155	1	paramHostConfiguration	HostConfiguration
      //   150	4	2	localObject	Object
      //   7	12	3	localHostConnectionPool	MultiThreadedHttpConnectionManager.HostConnectionPool
      //   107	6	4	bool	boolean
      //   28	118	5	localHttpConnectionWithReference	MultiThreadedHttpConnectionManager.HttpConnectionWithReference
      // Exception table:
      //   from	to	target	type
      //   2	85	150	finally
      //   85	94	150	finally
      //   99	109	150	finally
      //   117	144	150	finally
    }
    
    public MultiThreadedHttpConnectionManager.HostConnectionPool getHostPool(HostConfiguration paramHostConfiguration)
    {
      try
      {
        MultiThreadedHttpConnectionManager.LOG.trace("enter HttpConnectionManager.ConnectionPool.getHostPool(HostConfiguration)");
        MultiThreadedHttpConnectionManager.HostConnectionPool localHostConnectionPool = (MultiThreadedHttpConnectionManager.HostConnectionPool)this.mapHosts.get(paramHostConfiguration);
        if (localHostConnectionPool == null)
        {
          localHostConnectionPool = new MultiThreadedHttpConnectionManager.HostConnectionPool(null);
          localHostConnectionPool.hostConfiguration = paramHostConfiguration;
          this.mapHosts.put(paramHostConfiguration, localHostConnectionPool);
        }
        return localHostConnectionPool;
      }
      finally {}
    }
    
    public void handleLostConnection(HostConfiguration paramHostConfiguration)
    {
      try
      {
        MultiThreadedHttpConnectionManager.HostConnectionPool localHostConnectionPool = getHostPool(paramHostConfiguration);
        localHostConnectionPool.numConnections = (-1 + localHostConnectionPool.numConnections);
        this.numConnections = (-1 + this.numConnections);
        notifyWaitingThread(paramHostConfiguration);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void notifyWaitingThread(HostConfiguration paramHostConfiguration)
    {
      try
      {
        notifyWaitingThread(getHostPool(paramHostConfiguration));
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void notifyWaitingThread(MultiThreadedHttpConnectionManager.HostConnectionPool paramHostConnectionPool)
    {
      for (;;)
      {
        try
        {
          if (paramHostConnectionPool.waitingThreads.size() > 0)
          {
            if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
              MultiThreadedHttpConnectionManager.LOG.debug("Notifying thread waiting on host pool, hostConfig=" + paramHostConnectionPool.hostConfiguration);
            }
            localWaitingThread = (MultiThreadedHttpConnectionManager.WaitingThread)paramHostConnectionPool.waitingThreads.removeFirst();
            this.waitingThreads.remove(localWaitingThread);
            if (localWaitingThread != null) {
              localWaitingThread.thread.interrupt();
            }
            return;
          }
          if (this.waitingThreads.size() > 0)
          {
            if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
              MultiThreadedHttpConnectionManager.LOG.debug("No-one waiting on host pool, notifying next waiting thread.");
            }
            localWaitingThread = (MultiThreadedHttpConnectionManager.WaitingThread)this.waitingThreads.removeFirst();
            localWaitingThread.hostConnectionPool.waitingThreads.remove(localWaitingThread);
            continue;
          }
          bool = MultiThreadedHttpConnectionManager.LOG.isDebugEnabled();
        }
        finally {}
        boolean bool;
        MultiThreadedHttpConnectionManager.WaitingThread localWaitingThread = null;
        if (bool)
        {
          MultiThreadedHttpConnectionManager.LOG.debug("Notifying no-one, there are no waiting threads");
          localWaitingThread = null;
        }
      }
    }
    
    public void shutdown()
    {
      for (;;)
      {
        Iterator localIterator2;
        try
        {
          Iterator localIterator1 = this.freeConnections.iterator();
          if (!localIterator1.hasNext())
          {
            MultiThreadedHttpConnectionManager.shutdownCheckedOutConnections(this);
            localIterator2 = this.waitingThreads.iterator();
            if (!localIterator2.hasNext())
            {
              this.mapHosts.clear();
              this.idleConnectionHandler.removeAll();
            }
          }
          else
          {
            HttpConnection localHttpConnection = (HttpConnection)localIterator1.next();
            localIterator1.remove();
            localHttpConnection.close();
            continue;
          }
          localWaitingThread = (MultiThreadedHttpConnectionManager.WaitingThread)localIterator2.next();
        }
        finally {}
        MultiThreadedHttpConnectionManager.WaitingThread localWaitingThread;
        localIterator2.remove();
        localWaitingThread.thread.interrupt();
      }
    }
  }
  
  private static class ConnectionSource
  {
    public MultiThreadedHttpConnectionManager.ConnectionPool connectionPool;
    public HostConfiguration hostConfiguration;
    
    private ConnectionSource() {}
    
    ConnectionSource(MultiThreadedHttpConnectionManager.1 param1)
    {
      this();
    }
  }
  
  private static class HostConnectionPool
  {
    public LinkedList freeConnections = new LinkedList();
    public HostConfiguration hostConfiguration;
    public int numConnections = 0;
    public LinkedList waitingThreads = new LinkedList();
    
    private HostConnectionPool() {}
    
    HostConnectionPool(MultiThreadedHttpConnectionManager.1 param1)
    {
      this();
    }
  }
  
  private static class HttpConnectionAdapter
    extends HttpConnection
  {
    private HttpConnection wrappedConnection;
    
    public HttpConnectionAdapter(HttpConnection paramHttpConnection)
    {
      super(paramHttpConnection.getPort(), paramHttpConnection.getProtocol());
      this.wrappedConnection = paramHttpConnection;
    }
    
    public void close()
    {
      if (hasConnection()) {
        this.wrappedConnection.close();
      }
    }
    
    public boolean closeIfStale()
      throws IOException
    {
      if (hasConnection()) {
        return this.wrappedConnection.closeIfStale();
      }
      return false;
    }
    
    public void flushRequestOutputStream()
      throws IOException
    {
      if (hasConnection())
      {
        this.wrappedConnection.flushRequestOutputStream();
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public String getHost()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getHost();
      }
      return null;
    }
    
    public HttpConnectionManager getHttpConnectionManager()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getHttpConnectionManager();
      }
      return null;
    }
    
    public InputStream getLastResponseInputStream()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getLastResponseInputStream();
      }
      return null;
    }
    
    public InetAddress getLocalAddress()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getLocalAddress();
      }
      return null;
    }
    
    public HttpConnectionParams getParams()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getParams();
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public int getPort()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getPort();
      }
      return -1;
    }
    
    public Protocol getProtocol()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getProtocol();
      }
      return null;
    }
    
    public String getProxyHost()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getProxyHost();
      }
      return null;
    }
    
    public int getProxyPort()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getProxyPort();
      }
      return -1;
    }
    
    public OutputStream getRequestOutputStream()
      throws IOException, IllegalStateException
    {
      if (hasConnection()) {
        return this.wrappedConnection.getRequestOutputStream();
      }
      return null;
    }
    
    public InputStream getResponseInputStream()
      throws IOException, IllegalStateException
    {
      if (hasConnection()) {
        return this.wrappedConnection.getResponseInputStream();
      }
      return null;
    }
    
    public int getSendBufferSize()
      throws SocketException
    {
      if (hasConnection()) {
        return this.wrappedConnection.getSendBufferSize();
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public int getSoTimeout()
      throws SocketException
    {
      if (hasConnection()) {
        return this.wrappedConnection.getSoTimeout();
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public String getVirtualHost()
    {
      if (hasConnection()) {
        return this.wrappedConnection.getVirtualHost();
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    HttpConnection getWrappedConnection()
    {
      return this.wrappedConnection;
    }
    
    protected boolean hasConnection()
    {
      return this.wrappedConnection != null;
    }
    
    public boolean isOpen()
    {
      if (hasConnection()) {
        return this.wrappedConnection.isOpen();
      }
      return false;
    }
    
    public boolean isProxied()
    {
      if (hasConnection()) {
        return this.wrappedConnection.isProxied();
      }
      return false;
    }
    
    public boolean isResponseAvailable()
      throws IOException
    {
      if (hasConnection()) {
        return this.wrappedConnection.isResponseAvailable();
      }
      return false;
    }
    
    public boolean isResponseAvailable(int paramInt)
      throws IOException
    {
      if (hasConnection()) {
        return this.wrappedConnection.isResponseAvailable(paramInt);
      }
      return false;
    }
    
    public boolean isSecure()
    {
      if (hasConnection()) {
        return this.wrappedConnection.isSecure();
      }
      return false;
    }
    
    public boolean isStaleCheckingEnabled()
    {
      if (hasConnection()) {
        return this.wrappedConnection.isStaleCheckingEnabled();
      }
      return false;
    }
    
    public boolean isTransparent()
    {
      if (hasConnection()) {
        return this.wrappedConnection.isTransparent();
      }
      return false;
    }
    
    public void open()
      throws IOException
    {
      if (hasConnection())
      {
        this.wrappedConnection.open();
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void print(String paramString)
      throws IOException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.print(paramString);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void print(String paramString1, String paramString2)
      throws IOException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.print(paramString1, paramString2);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void printLine()
      throws IOException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.printLine();
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void printLine(String paramString)
      throws IOException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.printLine(paramString);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void printLine(String paramString1, String paramString2)
      throws IOException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.printLine(paramString1, paramString2);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public String readLine()
      throws IOException, IllegalStateException
    {
      if (hasConnection()) {
        return this.wrappedConnection.readLine();
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public String readLine(String paramString)
      throws IOException, IllegalStateException
    {
      if (hasConnection()) {
        return this.wrappedConnection.readLine(paramString);
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void releaseConnection()
    {
      if ((!isLocked()) && (hasConnection()))
      {
        HttpConnection localHttpConnection = this.wrappedConnection;
        this.wrappedConnection = null;
        localHttpConnection.releaseConnection();
      }
    }
    
    public void setConnectionTimeout(int paramInt)
    {
      if (hasConnection()) {
        this.wrappedConnection.setConnectionTimeout(paramInt);
      }
    }
    
    public void setHost(String paramString)
      throws IllegalStateException
    {
      if (hasConnection()) {
        this.wrappedConnection.setHost(paramString);
      }
    }
    
    public void setHttpConnectionManager(HttpConnectionManager paramHttpConnectionManager)
    {
      if (hasConnection()) {
        this.wrappedConnection.setHttpConnectionManager(paramHttpConnectionManager);
      }
    }
    
    public void setLastResponseInputStream(InputStream paramInputStream)
    {
      if (hasConnection()) {
        this.wrappedConnection.setLastResponseInputStream(paramInputStream);
      }
    }
    
    public void setLocalAddress(InetAddress paramInetAddress)
    {
      if (hasConnection())
      {
        this.wrappedConnection.setLocalAddress(paramInetAddress);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void setParams(HttpConnectionParams paramHttpConnectionParams)
    {
      if (hasConnection())
      {
        this.wrappedConnection.setParams(paramHttpConnectionParams);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void setPort(int paramInt)
      throws IllegalStateException
    {
      if (hasConnection()) {
        this.wrappedConnection.setPort(paramInt);
      }
    }
    
    public void setProtocol(Protocol paramProtocol)
    {
      if (hasConnection()) {
        this.wrappedConnection.setProtocol(paramProtocol);
      }
    }
    
    public void setProxyHost(String paramString)
      throws IllegalStateException
    {
      if (hasConnection()) {
        this.wrappedConnection.setProxyHost(paramString);
      }
    }
    
    public void setProxyPort(int paramInt)
      throws IllegalStateException
    {
      if (hasConnection()) {
        this.wrappedConnection.setProxyPort(paramInt);
      }
    }
    
    public void setSendBufferSize(int paramInt)
      throws SocketException
    {
      if (hasConnection())
      {
        this.wrappedConnection.setSendBufferSize(paramInt);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void setSoTimeout(int paramInt)
      throws SocketException, IllegalStateException
    {
      if (hasConnection()) {
        this.wrappedConnection.setSoTimeout(paramInt);
      }
    }
    
    public void setSocketTimeout(int paramInt)
      throws SocketException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.setSocketTimeout(paramInt);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void setStaleCheckingEnabled(boolean paramBoolean)
    {
      if (hasConnection())
      {
        this.wrappedConnection.setStaleCheckingEnabled(paramBoolean);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void setVirtualHost(String paramString)
      throws IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.setVirtualHost(paramString);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void shutdownOutput()
    {
      if (hasConnection()) {
        this.wrappedConnection.shutdownOutput();
      }
    }
    
    public void tunnelCreated()
      throws IllegalStateException, IOException
    {
      if (hasConnection()) {
        this.wrappedConnection.tunnelCreated();
      }
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.write(paramArrayOfByte);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.write(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void writeLine()
      throws IOException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.writeLine();
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
    
    public void writeLine(byte[] paramArrayOfByte)
      throws IOException, IllegalStateException
    {
      if (hasConnection())
      {
        this.wrappedConnection.writeLine(paramArrayOfByte);
        return;
      }
      throw new IllegalStateException("Connection has been released");
    }
  }
  
  private static class HttpConnectionWithReference
    extends HttpConnection
  {
    public WeakReference reference = new WeakReference(this, MultiThreadedHttpConnectionManager.REFERENCE_QUEUE);
    
    public HttpConnectionWithReference(HostConfiguration paramHostConfiguration)
    {
      super();
    }
  }
  
  private static class ReferenceQueueThread
    extends Thread
  {
    private boolean shutdown = false;
    
    public ReferenceQueueThread()
    {
      setDaemon(true);
      setName("MultiThreadedHttpConnectionManager cleanup");
    }
    
    private void handleReference(Reference paramReference)
    {
      synchronized (MultiThreadedHttpConnectionManager.REFERENCE_TO_CONNECTION_SOURCE)
      {
        MultiThreadedHttpConnectionManager.ConnectionSource localConnectionSource = (MultiThreadedHttpConnectionManager.ConnectionSource)MultiThreadedHttpConnectionManager.REFERENCE_TO_CONNECTION_SOURCE.remove(paramReference);
        if (localConnectionSource != null)
        {
          if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
            MultiThreadedHttpConnectionManager.LOG.debug("Connection reclaimed by garbage collector, hostConfig=" + localConnectionSource.hostConfiguration);
          }
          localConnectionSource.connectionPool.handleLostConnection(localConnectionSource.hostConfiguration);
        }
        return;
      }
    }
    
    public void run()
    {
      for (;;)
      {
        if (this.shutdown) {
          return;
        }
        try
        {
          Reference localReference = MultiThreadedHttpConnectionManager.REFERENCE_QUEUE.remove(1000L);
          if (localReference != null) {
            handleReference(localReference);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          MultiThreadedHttpConnectionManager.LOG.debug("ReferenceQueueThread interrupted", localInterruptedException);
        }
      }
    }
    
    public void shutdown()
    {
      this.shutdown = true;
    }
  }
  
  private static class WaitingThread
  {
    public MultiThreadedHttpConnectionManager.HostConnectionPool hostConnectionPool;
    public Thread thread;
    
    private WaitingThread() {}
    
    WaitingThread(MultiThreadedHttpConnectionManager.1 param1)
    {
      this();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.MultiThreadedHttpConnectionManager
 * JD-Core Version:    0.7.0.1
 */