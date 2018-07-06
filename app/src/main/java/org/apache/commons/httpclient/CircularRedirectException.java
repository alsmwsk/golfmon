package org.apache.commons.httpclient;

public class CircularRedirectException
  extends RedirectException
{
  public CircularRedirectException() {}
  
  public CircularRedirectException(String paramString)
  {
    super(paramString);
  }
  
  public CircularRedirectException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.CircularRedirectException
 * JD-Core Version:    0.7.0.1
 */