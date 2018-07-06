package org.apache.commons.httpclient;

import java.io.IOException;
import org.apache.commons.httpclient.util.ExceptionUtil;

public class NoHttpResponseException
  extends IOException
{
  public NoHttpResponseException() {}
  
  public NoHttpResponseException(String paramString)
  {
    super(paramString);
  }
  
  public NoHttpResponseException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    ExceptionUtil.initCause(this, paramThrowable);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.NoHttpResponseException
 * JD-Core Version:    0.7.0.1
 */