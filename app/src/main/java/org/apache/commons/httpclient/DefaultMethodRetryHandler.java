package org.apache.commons.httpclient;

public class DefaultMethodRetryHandler
  implements MethodRetryHandler
{
  private boolean requestSentRetryEnabled = false;
  private int retryCount = 3;
  
  public int getRetryCount()
  {
    return this.retryCount;
  }
  
  public boolean isRequestSentRetryEnabled()
  {
    return this.requestSentRetryEnabled;
  }
  
  public boolean retryMethod(HttpMethod paramHttpMethod, HttpConnection paramHttpConnection, HttpRecoverableException paramHttpRecoverableException, int paramInt, boolean paramBoolean)
  {
    return ((!paramBoolean) || (this.requestSentRetryEnabled)) && (paramInt <= this.retryCount);
  }
  
  public void setRequestSentRetryEnabled(boolean paramBoolean)
  {
    this.requestSentRetryEnabled = paramBoolean;
  }
  
  public void setRetryCount(int paramInt)
  {
    this.retryCount = paramInt;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.DefaultMethodRetryHandler
 * JD-Core Version:    0.7.0.1
 */