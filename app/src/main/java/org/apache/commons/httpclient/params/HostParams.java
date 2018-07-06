package org.apache.commons.httpclient.params;

public class HostParams
  extends DefaultHttpParams
{
  public static final String DEFAULT_HEADERS = "http.default-headers";
  
  public HostParams() {}
  
  public HostParams(HttpParams paramHttpParams)
  {
    super(paramHttpParams);
  }
  
  public String getVirtualHost()
  {
    return (String)getParameter("http.virtual-host");
  }
  
  public void setVirtualHost(String paramString)
  {
    setParameter("http.virtual-host", paramString);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.params.HostParams
 * JD-Core Version:    0.7.0.1
 */