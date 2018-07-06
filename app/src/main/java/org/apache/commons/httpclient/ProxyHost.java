package org.apache.commons.httpclient;

import org.apache.commons.httpclient.protocol.Protocol;

public class ProxyHost
  extends HttpHost
{
  public ProxyHost(String paramString)
  {
    this(paramString, -1);
  }
  
  public ProxyHost(String paramString, int paramInt)
  {
    super(paramString, paramInt, Protocol.getProtocol("http"));
  }
  
  public ProxyHost(ProxyHost paramProxyHost)
  {
    super(paramProxyHost);
  }
  
  public Object clone()
  {
    return new ProxyHost(this);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.ProxyHost
 * JD-Core Version:    0.7.0.1
 */