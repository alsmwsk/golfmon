package org.apache.commons.httpclient.methods;

import org.apache.commons.httpclient.HttpMethodBase;

public class TraceMethod
  extends HttpMethodBase
{
  public TraceMethod(String paramString)
  {
    super(paramString);
    setFollowRedirects(false);
  }
  
  public String getName()
  {
    return "TRACE";
  }
  
  public void recycle()
  {
    super.recycle();
    setFollowRedirects(false);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.TraceMethod
 * JD-Core Version:    0.7.0.1
 */