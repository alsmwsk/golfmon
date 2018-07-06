package ra.genius.net.http.codec;

import org.apache.commons.httpclient.Cookie;
import ra.genius.net.GBean;

public abstract interface IHttpDecoder
{
  public abstract GBean decode(String paramString, Cookie[] paramArrayOfCookie);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     ra.genius.net.http.codec.IHttpDecoder
 * JD-Core Version:    0.7.0.1
 */