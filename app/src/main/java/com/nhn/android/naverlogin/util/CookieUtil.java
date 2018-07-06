package com.nhn.android.naverlogin.util;

import android.util.Log;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class CookieUtil
{
  public static final String COOKIE_DOMAIN_NID = "https://nid.naver.com";
  private static final String TAG = "NaverLoginOAuth|CookieUtil";
  
  public static String getCookie(HttpResponse paramHttpResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Header[] arrayOfHeader = paramHttpResponse.getHeaders("Set-Cookie");
    localStringBuilder.setLength(0);
    if (arrayOfHeader != null) {}
    for (int i = 0;; i++)
    {
      if (i >= arrayOfHeader.length) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(arrayOfHeader[i].getValue());
      if (!localStringBuilder.toString().trim().endsWith(";")) {
        localStringBuilder.append(";");
      }
      if (OAuthLoginDefine.DEVELOPER_VERSION) {
        Log.d("NaverLoginOAuth|CookieUtil", "cookie:" + arrayOfHeader[i].getValue());
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.util.CookieUtil
 * JD-Core Version:    0.7.0.1
 */