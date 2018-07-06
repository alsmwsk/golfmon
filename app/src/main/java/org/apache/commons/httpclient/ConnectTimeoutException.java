package org.apache.commons.httpclient;

import java.io.InterruptedIOException;
import org.apache.commons.httpclient.util.ExceptionUtil;

public class ConnectTimeoutException
  extends InterruptedIOException
{
  public ConnectTimeoutException() {}
  
  public ConnectTimeoutException(String paramString)
  {
    super(paramString);
  }
  
  public ConnectTimeoutException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    ExceptionUtil.initCause(this, paramThrowable);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.ConnectTimeoutException
 * JD-Core Version:    0.7.0.1
 */