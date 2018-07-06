package org.apache.commons.httpclient.methods;

public class PutMethod
  extends EntityEnclosingMethod
{
  public PutMethod() {}
  
  public PutMethod(String paramString)
  {
    super(paramString);
  }
  
  public String getName()
  {
    return "PUT";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.PutMethod
 * JD-Core Version:    0.7.0.1
 */