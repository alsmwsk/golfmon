package org.apache.commons.httpclient.methods;

import org.apache.commons.httpclient.HttpMethodBase;

public class DeleteMethod
  extends HttpMethodBase
{
  public DeleteMethod() {}
  
  public DeleteMethod(String paramString)
  {
    super(paramString);
  }
  
  public String getName()
  {
    return "DELETE";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.DeleteMethod
 * JD-Core Version:    0.7.0.1
 */