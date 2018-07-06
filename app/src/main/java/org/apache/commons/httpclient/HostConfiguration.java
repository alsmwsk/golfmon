package org.apache.commons.httpclient;

import java.net.InetAddress;
import org.apache.commons.httpclient.params.DefaultHttpParams;
import org.apache.commons.httpclient.params.HostParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.LangUtils;

public class HostConfiguration
  implements Cloneable
{
  public static final HostConfiguration ANY_HOST_CONFIGURATION = new HostConfiguration();
  private HttpHost host = null;
  private InetAddress localAddress = null;
  private HostParams params = new HostParams();
  private ProxyHost proxyHost = null;
  
  public HostConfiguration() {}
  
  public HostConfiguration(HostConfiguration paramHostConfiguration)
  {
    for (;;)
    {
      try
      {
        if (paramHostConfiguration.host != null)
        {
          this.host = ((HttpHost)paramHostConfiguration.host.clone());
          if (paramHostConfiguration.proxyHost != null)
          {
            this.proxyHost = ((ProxyHost)paramHostConfiguration.proxyHost.clone());
            this.localAddress = paramHostConfiguration.getLocalAddress();
            this.params = ((HostParams)paramHostConfiguration.getParams().clone());
          }
        }
        else
        {
          this.host = null;
          continue;
        }
        this.proxyHost = null;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new IllegalArgumentException("Host configuration could not be cloned");
      }
      finally {}
    }
  }
  
  public Object clone()
  {
    return new HostConfiguration(this);
  }
  
  /* Error */
  public boolean equals(Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: instanceof 2
    //   8: istore 4
    //   10: iload 4
    //   12: ifeq +72 -> 84
    //   15: aload_1
    //   16: aload_0
    //   17: if_acmpne +7 -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: aload_1
    //   25: checkcast 2	org/apache/commons/httpclient/HostConfiguration
    //   28: astore 5
    //   30: aload_0
    //   31: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   34: aload 5
    //   36: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   39: invokestatic 74	org/apache/commons/httpclient/util/LangUtils:equals	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   42: ifeq +37 -> 79
    //   45: aload_0
    //   46: getfield 28	org/apache/commons/httpclient/HostConfiguration:proxyHost	Lorg/apache/commons/httpclient/ProxyHost;
    //   49: aload 5
    //   51: getfield 28	org/apache/commons/httpclient/HostConfiguration:proxyHost	Lorg/apache/commons/httpclient/ProxyHost;
    //   54: invokestatic 74	org/apache/commons/httpclient/util/LangUtils:equals	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   57: ifeq +22 -> 79
    //   60: aload_0
    //   61: getfield 30	org/apache/commons/httpclient/HostConfiguration:localAddress	Ljava/net/InetAddress;
    //   64: aload 5
    //   66: getfield 30	org/apache/commons/httpclient/HostConfiguration:localAddress	Ljava/net/InetAddress;
    //   69: invokestatic 74	org/apache/commons/httpclient/util/LangUtils:equals	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   72: istore 6
    //   74: iload 6
    //   76: ifne -56 -> 20
    //   79: iconst_0
    //   80: istore_2
    //   81: goto -61 -> 20
    //   84: iconst_0
    //   85: istore_2
    //   86: goto -66 -> 20
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	HostConfiguration
    //   0	94	1	paramObject	Object
    //   1	85	2	bool1	boolean
    //   89	4	3	localObject	Object
    //   8	3	4	bool2	boolean
    //   28	37	5	localHostConfiguration	HostConfiguration
    //   72	3	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	89	finally
    //   24	74	89	finally
  }
  
  /* Error */
  public String getHost()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   13: invokevirtual 79	org/apache/commons/httpclient/HttpHost:getHostName	()Ljava/lang/String;
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: aconst_null
    //   24: astore_2
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	HostConfiguration
    //   28	4	1	localObject	Object
    //   18	7	2	str1	String
    //   16	2	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	17	28	finally
  }
  
  public String getHostURL()
  {
    try
    {
      if (this.host == null) {
        throw new IllegalStateException("Host must be set to create a host URL");
      }
    }
    finally {}
    String str = this.host.toURI();
    return str;
  }
  
  public InetAddress getLocalAddress()
  {
    try
    {
      InetAddress localInetAddress = this.localAddress;
      return localInetAddress;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public HostParams getParams()
  {
    return this.params;
  }
  
  /* Error */
  public int getPort()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   13: invokevirtual 92	org/apache/commons/httpclient/HttpHost:getPort	()I
    //   16: istore_3
    //   17: iload_3
    //   18: istore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: iconst_m1
    //   24: istore_2
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	HostConfiguration
    //   28	4	1	localObject	Object
    //   18	7	2	i	int
    //   16	2	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	17	28	finally
  }
  
  /* Error */
  public Protocol getProtocol()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   13: invokevirtual 96	org/apache/commons/httpclient/HttpHost:getProtocol	()Lorg/apache/commons/httpclient/protocol/Protocol;
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: aconst_null
    //   24: astore_2
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	HostConfiguration
    //   28	4	1	localObject	Object
    //   18	7	2	localProtocol1	Protocol
    //   16	2	3	localProtocol2	Protocol
    // Exception table:
    //   from	to	target	type
    //   2	17	28	finally
  }
  
  /* Error */
  public String getProxyHost()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	org/apache/commons/httpclient/HostConfiguration:proxyHost	Lorg/apache/commons/httpclient/ProxyHost;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 28	org/apache/commons/httpclient/HostConfiguration:proxyHost	Lorg/apache/commons/httpclient/ProxyHost;
    //   13: invokevirtual 79	org/apache/commons/httpclient/HttpHost:getHostName	()Ljava/lang/String;
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: aconst_null
    //   24: astore_2
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	HostConfiguration
    //   28	4	1	localObject	Object
    //   18	7	2	str1	String
    //   16	2	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	17	28	finally
  }
  
  /* Error */
  public int getProxyPort()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	org/apache/commons/httpclient/HostConfiguration:proxyHost	Lorg/apache/commons/httpclient/ProxyHost;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 28	org/apache/commons/httpclient/HostConfiguration:proxyHost	Lorg/apache/commons/httpclient/ProxyHost;
    //   13: invokevirtual 92	org/apache/commons/httpclient/HttpHost:getPort	()I
    //   16: istore_3
    //   17: iload_3
    //   18: istore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: iconst_m1
    //   24: istore_2
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	HostConfiguration
    //   28	4	1	localObject	Object
    //   18	7	2	i	int
    //   16	2	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	17	28	finally
  }
  
  public String getVirtualHost()
  {
    try
    {
      String str = this.params.getVirtualHost();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.host), this.proxyHost), this.localAddress);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean hostEquals(HttpConnection paramHttpConnection)
  {
    if (paramHttpConnection == null) {
      try
      {
        throw new IllegalArgumentException("Connection may not be null");
      }
      finally {}
    }
    HttpHost localHttpHost = this.host;
    boolean bool1 = false;
    if (localHttpHost != null)
    {
      boolean bool2 = this.host.getHostName().equalsIgnoreCase(paramHttpConnection.getHost());
      bool1 = false;
      if (bool2) {
        break label61;
      }
    }
    for (;;)
    {
      return bool1;
      label61:
      int i = this.host.getPort();
      int j = paramHttpConnection.getPort();
      bool1 = false;
      if (i == j)
      {
        boolean bool3 = this.host.getProtocol().equals(paramHttpConnection.getProtocol());
        bool1 = false;
        if (bool3)
        {
          if (this.localAddress != null)
          {
            boolean bool4 = this.localAddress.equals(paramHttpConnection.getLocalAddress());
            bool1 = false;
            if (!bool4) {
              continue;
            }
          }
          else
          {
            InetAddress localInetAddress = paramHttpConnection.getLocalAddress();
            if (localInetAddress != null)
            {
              bool1 = false;
              continue;
            }
          }
          bool1 = true;
        }
      }
    }
  }
  
  /* Error */
  public boolean isHostSet()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_3
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	HostConfiguration
    //   22	4	1	localObject	Object
    //   6	2	2	localHttpHost	HttpHost
    //   12	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  /* Error */
  public boolean isProxySet()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	org/apache/commons/httpclient/HostConfiguration:proxyHost	Lorg/apache/commons/httpclient/ProxyHost;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_3
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	HostConfiguration
    //   22	4	1	localObject	Object
    //   6	2	2	localProxyHost	ProxyHost
    //   12	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public boolean proxyEquals(HttpConnection paramHttpConnection)
  {
    boolean bool = true;
    if (paramHttpConnection == null) {
      try
      {
        throw new IllegalArgumentException("Connection may not be null");
      }
      finally {}
    }
    if (this.proxyHost != null) {
      if (this.proxyHost.getHostName().equalsIgnoreCase(paramHttpConnection.getProxyHost()))
      {
        int i = this.proxyHost.getPort();
        int j = paramHttpConnection.getProxyPort();
        if (i != j) {}
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      String str = paramHttpConnection.getProxyHost();
      if (str != null) {
        bool = false;
      }
    }
  }
  
  public void setHost(String paramString)
  {
    try
    {
      Protocol localProtocol = Protocol.getProtocol("http");
      setHost(paramString, localProtocol.getDefaultPort(), localProtocol);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setHost(String paramString, int paramInt)
  {
    try
    {
      setHost(paramString, paramInt, Protocol.getProtocol("http"));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setHost(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      this.host = new HttpHost(paramString1, paramInt, Protocol.getProtocol(paramString2));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setHost(String paramString, int paramInt, Protocol paramProtocol)
  {
    if (paramString == null) {
      try
      {
        throw new IllegalArgumentException("host must not be null");
      }
      finally {}
    }
    if (paramProtocol == null) {
      throw new IllegalArgumentException("protocol must not be null");
    }
    this.host = new HttpHost(paramString, paramInt, paramProtocol);
  }
  
  public void setHost(String paramString1, String paramString2, int paramInt, Protocol paramProtocol)
  {
    try
    {
      setHost(paramString1, paramInt, paramProtocol);
      this.params.setVirtualHost(paramString2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setHost(HttpHost paramHttpHost)
  {
    try
    {
      this.host = paramHttpHost;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setHost(URI paramURI)
  {
    try
    {
      setHost(paramURI.getHost(), paramURI.getPort(), paramURI.getScheme());
      return;
    }
    catch (URIException localURIException)
    {
      throw new IllegalArgumentException(localURIException.toString());
    }
    finally {}
  }
  
  public void setLocalAddress(InetAddress paramInetAddress)
  {
    try
    {
      this.localAddress = paramInetAddress;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setParams(HostParams paramHostParams)
  {
    if (paramHostParams == null) {
      throw new IllegalArgumentException("Parameters may not be null");
    }
    this.params = paramHostParams;
  }
  
  public void setProxy(String paramString, int paramInt)
  {
    try
    {
      this.proxyHost = new ProxyHost(paramString, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setProxyHost(ProxyHost paramProxyHost)
  {
    try
    {
      this.proxyHost = paramProxyHost;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 192	java/lang/StringBuffer
    //   5: dup
    //   6: bipush 50
    //   8: invokespecial 195	java/lang/StringBuffer:<init>	(I)V
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 197
    //   15: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   18: pop
    //   19: aload_0
    //   20: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   23: astore 4
    //   25: iconst_0
    //   26: istore 5
    //   28: aload 4
    //   30: ifnull +20 -> 50
    //   33: iconst_1
    //   34: istore 5
    //   36: aload_1
    //   37: ldc 203
    //   39: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   42: aload_0
    //   43: getfield 26	org/apache/commons/httpclient/HostConfiguration:host	Lorg/apache/commons/httpclient/HttpHost;
    //   46: invokevirtual 206	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   49: pop
    //   50: aload_0
    //   51: getfield 28	org/apache/commons/httpclient/HostConfiguration:proxyHost	Lorg/apache/commons/httpclient/ProxyHost;
    //   54: ifnull +29 -> 83
    //   57: iload 5
    //   59: ifeq +101 -> 160
    //   62: aload_1
    //   63: ldc 208
    //   65: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   68: pop
    //   69: aload_1
    //   70: ldc 210
    //   72: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   75: aload_0
    //   76: getfield 28	org/apache/commons/httpclient/HostConfiguration:proxyHost	Lorg/apache/commons/httpclient/ProxyHost;
    //   79: invokevirtual 206	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   82: pop
    //   83: aload_0
    //   84: getfield 30	org/apache/commons/httpclient/HostConfiguration:localAddress	Ljava/net/InetAddress;
    //   87: ifnull +55 -> 142
    //   90: iload 5
    //   92: ifeq +74 -> 166
    //   95: aload_1
    //   96: ldc 208
    //   98: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   101: pop
    //   102: aload_1
    //   103: ldc 212
    //   105: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   108: aload_0
    //   109: getfield 30	org/apache/commons/httpclient/HostConfiguration:localAddress	Ljava/net/InetAddress;
    //   112: invokevirtual 206	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   115: pop
    //   116: iload 5
    //   118: ifeq +54 -> 172
    //   121: aload_1
    //   122: ldc 208
    //   124: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   127: pop
    //   128: aload_1
    //   129: ldc 214
    //   131: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   134: aload_0
    //   135: getfield 35	org/apache/commons/httpclient/HostConfiguration:params	Lorg/apache/commons/httpclient/params/HostParams;
    //   138: invokevirtual 206	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   141: pop
    //   142: aload_1
    //   143: ldc 216
    //   145: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   148: pop
    //   149: aload_1
    //   150: invokevirtual 217	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   153: astore 13
    //   155: aload_0
    //   156: monitorexit
    //   157: aload 13
    //   159: areturn
    //   160: iconst_1
    //   161: istore 5
    //   163: goto -94 -> 69
    //   166: iconst_1
    //   167: istore 5
    //   169: goto -67 -> 102
    //   172: goto -44 -> 128
    //   175: astore_2
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_2
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	HostConfiguration
    //   11	139	1	localStringBuffer	java.lang.StringBuffer
    //   175	4	2	localObject	Object
    //   23	6	4	localHttpHost	HttpHost
    //   26	142	5	i	int
    //   153	5	13	str	String
    // Exception table:
    //   from	to	target	type
    //   2	25	175	finally
    //   36	50	175	finally
    //   50	57	175	finally
    //   62	69	175	finally
    //   69	83	175	finally
    //   83	90	175	finally
    //   95	102	175	finally
    //   102	116	175	finally
    //   121	128	175	finally
    //   128	142	175	finally
    //   142	155	175	finally
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.HostConfiguration
 * JD-Core Version:    0.7.0.1
 */