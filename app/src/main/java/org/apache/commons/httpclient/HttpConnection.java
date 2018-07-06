package org.apache.commons.httpclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.httpclient.util.ExceptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpConnection
{
  private static final byte[] CRLF = { 13, 10 };
  private static final Log LOG;
  static Class class$org$apache$commons$httpclient$HttpConnection;
  private String hostName = null;
  private HttpConnectionManager httpConnectionManager;
  private InputStream inputStream = null;
  protected boolean isOpen = false;
  private InputStream lastResponseInputStream = null;
  private InetAddress localAddress;
  private boolean locked = false;
  private OutputStream outputStream = null;
  private HttpConnectionParams params = new HttpConnectionParams();
  private int portNumber = -1;
  private Protocol protocolInUse;
  private String proxyHostName = null;
  private int proxyPortNumber = -1;
  private Socket socket = null;
  private boolean tunnelEstablished = false;
  private boolean usingSecureSocket = false;
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$httpclient$HttpConnection == null)
    {
      localClass = class$("org.apache.commons.httpclient.HttpConnection");
      class$org$apache$commons$httpclient$HttpConnection = localClass;
    }
    for (;;)
    {
      LOG = LogFactory.getLog(localClass);
      return;
      localClass = class$org$apache$commons$httpclient$HttpConnection;
    }
  }
  
  public HttpConnection(String paramString, int paramInt)
  {
    this(null, -1, paramString, null, paramInt, Protocol.getProtocol("http"));
  }
  
  public HttpConnection(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this(paramString1, paramInt1, paramString2, null, paramInt2, Protocol.getProtocol("http"));
  }
  
  public HttpConnection(String paramString1, int paramInt1, String paramString2, int paramInt2, Protocol paramProtocol)
  {
    if (paramString2 == null) {
      throw new IllegalArgumentException("host parameter is null");
    }
    if (paramProtocol == null) {
      throw new IllegalArgumentException("protocol is null");
    }
    this.proxyHostName = paramString1;
    this.proxyPortNumber = paramInt1;
    this.hostName = paramString2;
    this.portNumber = paramProtocol.resolvePort(paramInt2);
    this.protocolInUse = paramProtocol;
  }
  
  public HttpConnection(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, Protocol paramProtocol)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramProtocol);
  }
  
  public HttpConnection(String paramString, int paramInt, Protocol paramProtocol)
  {
    this(null, -1, paramString, null, paramInt, paramProtocol);
  }
  
  public HttpConnection(String paramString1, String paramString2, int paramInt, Protocol paramProtocol)
  {
    this(null, -1, paramString1, paramString2, paramInt, paramProtocol);
  }
  
  public HttpConnection(HostConfiguration paramHostConfiguration)
  {
    this(paramHostConfiguration.getProxyHost(), paramHostConfiguration.getProxyPort(), paramHostConfiguration.getHost(), paramHostConfiguration.getPort(), paramHostConfiguration.getProtocol());
    this.localAddress = paramHostConfiguration.getLocalAddress();
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
  
  protected void assertNotOpen()
    throws IllegalStateException
  {
    if (this.isOpen) {
      throw new IllegalStateException("Connection is open");
    }
  }
  
  protected void assertOpen()
    throws IllegalStateException
  {
    if (!this.isOpen) {
      throw new IllegalStateException("Connection is not open");
    }
  }
  
  public void close()
  {
    LOG.trace("enter HttpConnection.close()");
    closeSocketAndStreams();
  }
  
  public boolean closeIfStale()
    throws IOException
  {
    if ((this.isOpen) && (isStale()))
    {
      LOG.debug("Connection is stale, closing...");
      close();
      return true;
    }
    return false;
  }
  
  protected void closeSocketAndStreams()
  {
    LOG.trace("enter HttpConnection.closeSockedAndStreams()");
    this.isOpen = false;
    this.lastResponseInputStream = null;
    OutputStream localOutputStream;
    if (this.outputStream != null)
    {
      localOutputStream = this.outputStream;
      this.outputStream = null;
    }
    try
    {
      localOutputStream.close();
      if (this.inputStream != null)
      {
        localInputStream = this.inputStream;
        this.inputStream = null;
      }
    }
    catch (Exception localException2)
    {
      try
      {
        InputStream localInputStream;
        localInputStream.close();
        if (this.socket != null)
        {
          localSocket = this.socket;
          this.socket = null;
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            Socket localSocket;
            localSocket.close();
            this.tunnelEstablished = false;
            this.usingSecureSocket = false;
            return;
            localException3 = localException3;
            LOG.debug("Exception caught when closing output", localException3);
          }
          localException2 = localException2;
          LOG.debug("Exception caught when closing input", localException2);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            LOG.debug("Exception caught when closing socket", localException1);
          }
        }
      }
    }
  }
  
  public void flushRequestOutputStream()
    throws IOException
  {
    LOG.trace("enter HttpConnection.flushRequestOutputStream()");
    assertOpen();
    this.outputStream.flush();
  }
  
  public String getHost()
  {
    return this.hostName;
  }
  
  public HttpConnectionManager getHttpConnectionManager()
  {
    return this.httpConnectionManager;
  }
  
  public InputStream getLastResponseInputStream()
  {
    return this.lastResponseInputStream;
  }
  
  public InetAddress getLocalAddress()
  {
    return this.localAddress;
  }
  
  public HttpConnectionParams getParams()
  {
    return this.params;
  }
  
  public int getPort()
  {
    if (this.portNumber < 0)
    {
      if (isSecure()) {
        return 443;
      }
      return 80;
    }
    return this.portNumber;
  }
  
  public Protocol getProtocol()
  {
    return this.protocolInUse;
  }
  
  public String getProxyHost()
  {
    return this.proxyHostName;
  }
  
  public int getProxyPort()
  {
    return this.proxyPortNumber;
  }
  
  public OutputStream getRequestOutputStream()
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.getRequestOutputStream()");
    assertOpen();
    Object localObject = this.outputStream;
    if (Wire.CONTENT_WIRE.enabled()) {
      localObject = new WireLogOutputStream((OutputStream)localObject, Wire.CONTENT_WIRE);
    }
    return localObject;
  }
  
  public InputStream getResponseInputStream()
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.getResponseInputStream()");
    assertOpen();
    return this.inputStream;
  }
  
  public int getSendBufferSize()
    throws SocketException
  {
    if (this.socket == null) {
      return -1;
    }
    return this.socket.getSendBufferSize();
  }
  
  public int getSoTimeout()
    throws SocketException
  {
    return this.params.getSoTimeout();
  }
  
  protected Socket getSocket()
  {
    return this.socket;
  }
  
  public String getVirtualHost()
  {
    return this.hostName;
  }
  
  protected boolean isLocked()
  {
    return this.locked;
  }
  
  public boolean isOpen()
  {
    return this.isOpen;
  }
  
  public boolean isProxied()
  {
    return (this.proxyHostName != null) && (this.proxyPortNumber > 0);
  }
  
  public boolean isResponseAvailable()
    throws IOException
  {
    LOG.trace("enter HttpConnection.isResponseAvailable()");
    boolean bool1 = this.isOpen;
    boolean bool2 = false;
    if (bool1)
    {
      int i = this.inputStream.available();
      bool2 = false;
      if (i > 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean isResponseAvailable(int paramInt)
    throws IOException
  {
    LOG.trace("enter HttpConnection.isResponseAvailable(int)");
    assertOpen();
    if (this.inputStream.available() > 0) {
      return true;
    }
    try
    {
      this.socket.setSoTimeout(paramInt);
      this.inputStream.mark(1);
      boolean bool;
      if (this.inputStream.read() != -1)
      {
        this.inputStream.reset();
        LOG.debug("Input data available");
        bool = true;
        try
        {
          this.socket.setSoTimeout(this.params.getSoTimeout());
          return bool;
        }
        catch (IOException localIOException3)
        {
          LOG.debug("An error ocurred while resetting soTimeout, we will assume that no response is available.", localIOException3);
        }
      }
      for (;;)
      {
        return false;
        LOG.debug("Input data not available");
        bool = false;
        break;
        try
        {
          this.socket.setSoTimeout(this.params.getSoTimeout());
          throw localObject;
          if (LOG.isDebugEnabled()) {
            LOG.debug("Input data not available after " + paramInt + " ms");
          }
          try
          {
            this.socket.setSoTimeout(this.params.getSoTimeout());
            return false;
          }
          catch (IOException localIOException2)
          {
            LOG.debug("An error ocurred while resetting soTimeout, we will assume that no response is available.", localIOException2);
          }
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            LOG.debug("An error ocurred while resetting soTimeout, we will assume that no response is available.", localIOException1);
          }
        }
      }
    }
    catch (InterruptedIOException localInterruptedIOException)
    {
      localInterruptedIOException = localInterruptedIOException;
      if (!ExceptionUtil.isSocketTimeoutException(localInterruptedIOException)) {
        throw localInterruptedIOException;
      }
    }
    finally {}
  }
  
  public boolean isSecure()
  {
    return this.protocolInUse.isSecure();
  }
  
  /* Error */
  protected boolean isStale()
    throws IOException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 93	org/apache/commons/httpclient/HttpConnection:isOpen	Z
    //   6: ifeq +68 -> 74
    //   9: iconst_0
    //   10: istore_1
    //   11: aload_0
    //   12: getfield 87	org/apache/commons/httpclient/HttpConnection:inputStream	Ljava/io/InputStream;
    //   15: invokevirtual 280	java/io/InputStream:available	()I
    //   18: istore 4
    //   20: iconst_0
    //   21: istore_1
    //   22: iload 4
    //   24: ifgt +50 -> 74
    //   27: aload_0
    //   28: getfield 85	org/apache/commons/httpclient/HttpConnection:socket	Ljava/net/Socket;
    //   31: iconst_1
    //   32: invokevirtual 289	java/net/Socket:setSoTimeout	(I)V
    //   35: aload_0
    //   36: getfield 87	org/apache/commons/httpclient/HttpConnection:inputStream	Ljava/io/InputStream;
    //   39: iconst_1
    //   40: invokevirtual 292	java/io/InputStream:mark	(I)V
    //   43: aload_0
    //   44: getfield 87	org/apache/commons/httpclient/HttpConnection:inputStream	Ljava/io/InputStream;
    //   47: invokevirtual 295	java/io/InputStream:read	()I
    //   50: istore 6
    //   52: iload 6
    //   54: iconst_m1
    //   55: if_icmpne +21 -> 76
    //   58: iconst_1
    //   59: istore_1
    //   60: aload_0
    //   61: getfield 85	org/apache/commons/httpclient/HttpConnection:socket	Ljava/net/Socket;
    //   64: aload_0
    //   65: getfield 98	org/apache/commons/httpclient/HttpConnection:params	Lorg/apache/commons/httpclient/params/HttpConnectionParams;
    //   68: invokevirtual 269	org/apache/commons/httpclient/params/HttpConnectionParams:getSoTimeout	()I
    //   71: invokevirtual 289	java/net/Socket:setSoTimeout	(I)V
    //   74: iload_1
    //   75: ireturn
    //   76: aload_0
    //   77: getfield 87	org/apache/commons/httpclient/HttpConnection:inputStream	Ljava/io/InputStream;
    //   80: invokevirtual 298	java/io/InputStream:reset	()V
    //   83: iconst_0
    //   84: istore_1
    //   85: goto -25 -> 60
    //   88: astore 5
    //   90: aload_0
    //   91: getfield 85	org/apache/commons/httpclient/HttpConnection:socket	Ljava/net/Socket;
    //   94: aload_0
    //   95: getfield 98	org/apache/commons/httpclient/HttpConnection:params	Lorg/apache/commons/httpclient/params/HttpConnectionParams;
    //   98: invokevirtual 269	org/apache/commons/httpclient/params/HttpConnectionParams:getSoTimeout	()I
    //   101: invokevirtual 289	java/net/Socket:setSoTimeout	(I)V
    //   104: aload 5
    //   106: athrow
    //   107: astore_3
    //   108: aload_3
    //   109: invokestatic 310	org/apache/commons/httpclient/util/ExceptionUtil:isSocketTimeoutException	(Ljava/io/InterruptedIOException;)Z
    //   112: ifne -38 -> 74
    //   115: aload_3
    //   116: athrow
    //   117: astore_2
    //   118: getstatic 58	org/apache/commons/httpclient/HttpConnection:LOG	Lorg/apache/commons/logging/Log;
    //   121: ldc_w 333
    //   124: aload_2
    //   125: invokeinterface 217 3 0
    //   130: iconst_1
    //   131: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	HttpConnection
    //   1	84	1	bool	boolean
    //   117	8	2	localIOException	IOException
    //   107	9	3	localInterruptedIOException	InterruptedIOException
    //   18	5	4	i	int
    //   88	17	5	localObject	Object
    //   50	6	6	j	int
    // Exception table:
    //   from	to	target	type
    //   27	52	88	finally
    //   76	83	88	finally
    //   11	20	107	java/io/InterruptedIOException
    //   60	74	107	java/io/InterruptedIOException
    //   90	107	107	java/io/InterruptedIOException
    //   11	20	117	java/io/IOException
    //   60	74	117	java/io/IOException
    //   90	107	117	java/io/IOException
  }
  
  public boolean isStaleCheckingEnabled()
  {
    return this.params.isStaleCheckingEnabled();
  }
  
  public boolean isTransparent()
  {
    return (!isProxied()) || (this.tunnelEstablished);
  }
  
  public void open()
    throws IOException
  {
    LOG.trace("enter HttpConnection.open()");
    String str;
    int i;
    if (this.proxyHostName == null)
    {
      str = this.hostName;
      if (this.proxyHostName != null) {
        break label379;
      }
      i = this.portNumber;
      label35:
      assertNotOpen();
      if (LOG.isDebugEnabled()) {
        LOG.debug("Open connection to " + str + ":" + i);
      }
    }
    for (;;)
    {
      try
      {
        if (this.socket == null)
        {
          if ((isSecure()) && (!isProxied()))
          {
            bool2 = true;
            this.usingSecureSocket = bool2;
            if ((!isSecure()) || (!isProxied())) {
              continue;
            }
            localObject = Protocol.getProtocol("http").getSocketFactory();
            this.socket = ((ProtocolSocketFactory)localObject).createSocket(str, i, this.localAddress, 0, this.params);
          }
        }
        else
        {
          this.socket.setTcpNoDelay(this.params.getTcpNoDelay());
          this.socket.setSoTimeout(this.params.getSoTimeout());
          int j = this.params.getLinger();
          if (j >= 0)
          {
            Socket localSocket = this.socket;
            if (j <= 0) {
              continue;
            }
            bool1 = true;
            localSocket.setSoLinger(bool1, j);
          }
          int k = this.params.getSendBufferSize();
          if (k >= 0) {
            this.socket.setSendBufferSize(k);
          }
          int m = this.params.getReceiveBufferSize();
          if (m >= 0) {
            this.socket.setReceiveBufferSize(m);
          }
          n = this.socket.getSendBufferSize();
          if ((n > 2048) || (n <= 0)) {
            break label422;
          }
          i1 = this.socket.getReceiveBufferSize();
          if ((i1 > 2048) || (i1 <= 0)) {
            break label430;
          }
          this.inputStream = new BufferedInputStream(this.socket.getInputStream(), i1);
          this.outputStream = new BufferedOutputStream(this.socket.getOutputStream(), n);
          this.isOpen = true;
          return;
          str = this.proxyHostName;
          break;
          label379:
          i = this.proxyPortNumber;
          break label35;
        }
        boolean bool2 = false;
        continue;
        ProtocolSocketFactory localProtocolSocketFactory = this.protocolInUse.getSocketFactory();
        Object localObject = localProtocolSocketFactory;
        continue;
        boolean bool1 = false;
        continue;
        int n = 2048;
      }
      catch (IOException localIOException)
      {
        closeSocketAndStreams();
        throw localIOException;
      }
      label422:
      continue;
      label430:
      int i1 = 2048;
    }
  }
  
  public void print(String paramString)
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.print(String)");
    write(EncodingUtil.getBytes(paramString, "ISO-8859-1"));
  }
  
  public void print(String paramString1, String paramString2)
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.print(String)");
    write(EncodingUtil.getBytes(paramString1, paramString2));
  }
  
  public void printLine()
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.printLine()");
    writeLine();
  }
  
  public void printLine(String paramString)
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.printLine(String)");
    writeLine(EncodingUtil.getBytes(paramString, "ISO-8859-1"));
  }
  
  public void printLine(String paramString1, String paramString2)
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.printLine(String)");
    writeLine(EncodingUtil.getBytes(paramString1, paramString2));
  }
  
  public String readLine()
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.readLine()");
    assertOpen();
    return HttpParser.readLine(this.inputStream);
  }
  
  public String readLine(String paramString)
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.readLine()");
    assertOpen();
    return HttpParser.readLine(this.inputStream, paramString);
  }
  
  public void releaseConnection()
  {
    LOG.trace("enter HttpConnection.releaseConnection()");
    if (this.locked)
    {
      LOG.debug("Connection is locked.  Call to releaseConnection() ignored.");
      return;
    }
    if (this.httpConnectionManager != null)
    {
      LOG.debug("Releasing connection back to connection manager.");
      this.httpConnectionManager.releaseConnection(this);
      return;
    }
    LOG.warn("HttpConnectionManager is null.  Connection cannot be released.");
  }
  
  public void setConnectionTimeout(int paramInt)
  {
    this.params.setConnectionTimeout(paramInt);
  }
  
  public void setHost(String paramString)
    throws IllegalStateException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("host parameter is null");
    }
    assertNotOpen();
    this.hostName = paramString;
  }
  
  public void setHttpConnectionManager(HttpConnectionManager paramHttpConnectionManager)
  {
    this.httpConnectionManager = paramHttpConnectionManager;
  }
  
  public void setLastResponseInputStream(InputStream paramInputStream)
  {
    this.lastResponseInputStream = paramInputStream;
  }
  
  public void setLocalAddress(InetAddress paramInetAddress)
  {
    assertNotOpen();
    this.localAddress = paramInetAddress;
  }
  
  protected void setLocked(boolean paramBoolean)
  {
    this.locked = paramBoolean;
  }
  
  public void setParams(HttpConnectionParams paramHttpConnectionParams)
  {
    if (paramHttpConnectionParams == null) {
      throw new IllegalArgumentException("Parameters may not be null");
    }
    this.params = paramHttpConnectionParams;
  }
  
  public void setPort(int paramInt)
    throws IllegalStateException
  {
    assertNotOpen();
    this.portNumber = paramInt;
  }
  
  public void setProtocol(Protocol paramProtocol)
  {
    assertNotOpen();
    if (paramProtocol == null) {
      throw new IllegalArgumentException("protocol is null");
    }
    this.protocolInUse = paramProtocol;
  }
  
  public void setProxyHost(String paramString)
    throws IllegalStateException
  {
    assertNotOpen();
    this.proxyHostName = paramString;
  }
  
  public void setProxyPort(int paramInt)
    throws IllegalStateException
  {
    assertNotOpen();
    this.proxyPortNumber = paramInt;
  }
  
  public void setSendBufferSize(int paramInt)
    throws SocketException
  {
    this.params.setSendBufferSize(paramInt);
  }
  
  public void setSoTimeout(int paramInt)
    throws SocketException, IllegalStateException
  {
    this.params.setSoTimeout(paramInt);
    if (this.socket != null) {
      this.socket.setSoTimeout(paramInt);
    }
  }
  
  public void setSocketTimeout(int paramInt)
    throws SocketException, IllegalStateException
  {
    assertOpen();
    if (this.socket != null) {
      this.socket.setSoTimeout(paramInt);
    }
  }
  
  public void setStaleCheckingEnabled(boolean paramBoolean)
  {
    this.params.setStaleCheckingEnabled(paramBoolean);
  }
  
  public void setVirtualHost(String paramString)
    throws IllegalStateException
  {
    assertNotOpen();
  }
  
  public void shutdownOutput()
  {
    LOG.trace("enter HttpConnection.shutdownOutput()");
    try
    {
      Class[] arrayOfClass = new Class[0];
      Method localMethod = this.socket.getClass().getMethod("shutdownOutput", arrayOfClass);
      Object[] arrayOfObject = new Object[0];
      localMethod.invoke(this.socket, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      LOG.debug("Unexpected Exception caught", localException);
    }
  }
  
  public void tunnelCreated()
    throws IllegalStateException, IOException
  {
    LOG.trace("enter HttpConnection.tunnelCreated()");
    if ((!isSecure()) || (!isProxied())) {
      throw new IllegalStateException("Connection must be secure and proxied to use this feature");
    }
    if (this.usingSecureSocket) {
      throw new IllegalStateException("Already using a secure socket");
    }
    if (LOG.isDebugEnabled()) {
      LOG.debug("Secure tunnel to " + this.hostName + ":" + this.portNumber);
    }
    this.socket = ((SecureProtocolSocketFactory)this.protocolInUse.getSocketFactory()).createSocket(this.socket, this.hostName, this.portNumber, true);
    int i = this.params.getSendBufferSize();
    if (i >= 0) {
      this.socket.setSendBufferSize(i);
    }
    int j = this.params.getReceiveBufferSize();
    if (j >= 0) {
      this.socket.setReceiveBufferSize(j);
    }
    int k = this.socket.getSendBufferSize();
    if (k > 2048) {
      k = 2048;
    }
    int m = this.socket.getReceiveBufferSize();
    if (m > 2048) {
      m = 2048;
    }
    this.inputStream = new BufferedInputStream(this.socket.getInputStream(), m);
    this.outputStream = new BufferedOutputStream(this.socket.getOutputStream(), k);
    this.usingSecureSocket = true;
    this.tunnelEstablished = true;
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.write(byte[])");
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.write(byte[], int, int)");
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Array offset may not be negative");
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Array length may not be negative");
    }
    if (paramInt1 + paramInt2 > paramArrayOfByte.length) {
      throw new IllegalArgumentException("Given offset and length exceed the array length");
    }
    assertOpen();
    this.outputStream.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeLine()
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.writeLine()");
    write(CRLF);
  }
  
  public void writeLine(byte[] paramArrayOfByte)
    throws IOException, IllegalStateException
  {
    LOG.trace("enter HttpConnection.writeLine(byte[])");
    write(paramArrayOfByte);
    writeLine();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.HttpConnection
 * JD-Core Version:    0.7.0.1
 */