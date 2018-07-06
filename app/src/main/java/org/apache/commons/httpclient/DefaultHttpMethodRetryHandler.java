package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

public class DefaultHttpMethodRetryHandler
  implements HttpMethodRetryHandler
{
  private static Class SSL_HANDSHAKE_EXCEPTION = null;
  private boolean requestSentRetryEnabled;
  private int retryCount;
  
  static
  {
    try
    {
      SSL_HANDSHAKE_EXCEPTION = Class.forName("javax.net.ssl.SSLHandshakeException");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  public DefaultHttpMethodRetryHandler()
  {
    this(3, false);
  }
  
  public DefaultHttpMethodRetryHandler(int paramInt, boolean paramBoolean)
  {
    this.retryCount = paramInt;
    this.requestSentRetryEnabled = paramBoolean;
  }
  
  public int getRetryCount()
  {
    return this.retryCount;
  }
  
  public boolean isRequestSentRetryEnabled()
  {
    return this.requestSentRetryEnabled;
  }
  
  public boolean retryMethod(HttpMethod paramHttpMethod, IOException paramIOException, int paramInt)
  {
    if (paramHttpMethod == null) {
      throw new IllegalArgumentException("HTTP method may not be null");
    }
    if (paramIOException == null) {
      throw new IllegalArgumentException("Exception parameter may not be null");
    }
    if (((paramHttpMethod instanceof HttpMethodBase)) && (((HttpMethodBase)paramHttpMethod).isAborted())) {
      return false;
    }
    if (paramInt > this.retryCount) {
      return false;
    }
    if ((paramIOException instanceof NoHttpResponseException)) {
      return true;
    }
    if ((paramIOException instanceof InterruptedIOException)) {
      return false;
    }
    if ((paramIOException instanceof UnknownHostException)) {
      return false;
    }
    if ((paramIOException instanceof NoRouteToHostException)) {
      return false;
    }
    if ((SSL_HANDSHAKE_EXCEPTION != null) && (SSL_HANDSHAKE_EXCEPTION.isInstance(paramIOException))) {
      return false;
    }
    return (!paramHttpMethod.isRequestSent()) || (this.requestSentRetryEnabled);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.DefaultHttpMethodRetryHandler
 * JD-Core Version:    0.7.0.1
 */