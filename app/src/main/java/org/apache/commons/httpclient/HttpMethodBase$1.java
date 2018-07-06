package org.apache.commons.httpclient;

class HttpMethodBase$1
  implements ResponseConsumedWatcher
{
  private final HttpMethodBase this$0;
  
  HttpMethodBase$1(HttpMethodBase paramHttpMethodBase)
  {
    this.this$0 = paramHttpMethodBase;
  }
  
  public void responseConsumed()
  {
    this.this$0.responseBodyConsumed();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.HttpMethodBase.1
 * JD-Core Version:    0.7.0.1
 */