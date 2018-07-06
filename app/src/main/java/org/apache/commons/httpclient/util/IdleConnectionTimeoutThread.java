package org.apache.commons.httpclient.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpConnectionManager;

public class IdleConnectionTimeoutThread
  extends Thread
{
  private List connectionManagers = new ArrayList();
  private long connectionTimeout = 3000L;
  private boolean shutdown = false;
  private long timeoutInterval = 1000L;
  
  public IdleConnectionTimeoutThread()
  {
    setDaemon(true);
  }
  
  public void addConnectionManager(HttpConnectionManager paramHttpConnectionManager)
  {
    try
    {
      if (this.shutdown) {
        throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
      }
    }
    finally {}
    this.connectionManagers.add(paramHttpConnectionManager);
  }
  
  public void removeConnectionManager(HttpConnectionManager paramHttpConnectionManager)
  {
    try
    {
      if (this.shutdown) {
        throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
      }
    }
    finally {}
    this.connectionManagers.remove(paramHttpConnectionManager);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	org/apache/commons/httpclient/util/IdleConnectionTimeoutThread:shutdown	Z
    //   6: ifeq +15 -> 21
    //   9: aload_0
    //   10: getfield 20	org/apache/commons/httpclient/util/IdleConnectionTimeoutThread:connectionManagers	Ljava/util/List;
    //   13: invokeinterface 59 1 0
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 20	org/apache/commons/httpclient/util/IdleConnectionTimeoutThread:connectionManagers	Ljava/util/List;
    //   25: invokeinterface 63 1 0
    //   30: astore_2
    //   31: aload_2
    //   32: invokeinterface 69 1 0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +19 -> 58
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 26	org/apache/commons/httpclient/util/IdleConnectionTimeoutThread:timeoutInterval	J
    //   47: invokevirtual 75	java/lang/Object:wait	(J)V
    //   50: goto -48 -> 2
    //   53: astore 4
    //   55: goto -53 -> 2
    //   58: aload_2
    //   59: invokeinterface 79 1 0
    //   64: checkcast 81	org/apache/commons/httpclient/HttpConnectionManager
    //   67: aload_0
    //   68: getfield 30	org/apache/commons/httpclient/util/IdleConnectionTimeoutThread:connectionTimeout	J
    //   71: invokeinterface 84 3 0
    //   76: goto -45 -> 31
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	IdleConnectionTimeoutThread
    //   79	4	1	localObject	Object
    //   30	29	2	localIterator	java.util.Iterator
    //   37	2	3	bool	boolean
    //   53	1	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   42	50	53	java/lang/InterruptedException
    //   2	18	79	finally
    //   21	31	79	finally
    //   31	38	79	finally
    //   42	50	79	finally
    //   58	76	79	finally
  }
  
  public void setConnectionTimeout(long paramLong)
  {
    try
    {
      if (this.shutdown) {
        throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
      }
    }
    finally {}
    this.connectionTimeout = paramLong;
  }
  
  public void setTimeoutInterval(long paramLong)
  {
    try
    {
      if (this.shutdown) {
        throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
      }
    }
    finally {}
    this.timeoutInterval = paramLong;
  }
  
  public void shutdown()
  {
    try
    {
      this.shutdown = true;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.util.IdleConnectionTimeoutThread
 * JD-Core Version:    0.7.0.1
 */