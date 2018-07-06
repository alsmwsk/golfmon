package org.apache.commons.httpclient;

import java.io.IOException;

public abstract interface HttpMethodRetryHandler
{
  public abstract boolean retryMethod(HttpMethod paramHttpMethod, IOException paramIOException, int paramInt);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.HttpMethodRetryHandler
 * JD-Core Version:    0.7.0.1
 */