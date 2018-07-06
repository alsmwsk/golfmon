package com.nhn.android.naverlogin.connection.gen;

import java.util.HashMap;
import java.util.Map;

public class OAuthQueryGenerator
  extends CommonLoginQuery
{
  private static final String OAUTH_REQUEST_ACCESS_TOKEN_URL = "https://nid.naver.com/oauth2.0/token?";
  private static final String OAUTH_REQUEST_AUTH_URL = "https://nid.naver.com/oauth2.0/authorize?";
  private static final String TAG = "NaverLoginOAuth|OAuthQueryGenerator";
  
  public String generateRequestAccessTokenUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("client_id", paramString1);
    localHashMap.put("client_secret", paramString2);
    localHashMap.put("grant_type", "authorization_code");
    localHashMap.put("state", paramString3);
    localHashMap.put("code", paramString4);
    localHashMap.put("oauth_os", "android");
    localHashMap.put("locale", paramString5);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "https://nid.naver.com/oauth2.0/token?";
    arrayOfObject[1] = getQueryParameter(localHashMap);
    return String.format("%s%s", arrayOfObject);
  }
  
  public String generateRequestDeleteAccessTokenUrl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("client_id", paramString1);
    localHashMap.put("client_secret", paramString2);
    localHashMap.put("grant_type", "delete");
    localHashMap.put("access_token", paramString3);
    localHashMap.put("service_provider", "NAVER");
    localHashMap.put("oauth_os", "android");
    localHashMap.put("locale", paramString4);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "https://nid.naver.com/oauth2.0/token?";
    arrayOfObject[1] = getQueryParameter(localHashMap);
    return String.format("%s%s", arrayOfObject);
  }
  
  public String generateRequestInitUrl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return generateRequestInitUrl(paramString1, paramString2, paramString3, paramString4, null);
  }
  
  public String generateRequestInitUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("client_id", paramString1);
    localHashMap.put("response_type", "code");
    localHashMap.put("inapp_view", "true");
    localHashMap.put("oauth_os", "android");
    localHashMap.put("locale", paramString4);
    if (paramString5 != null) {
      localHashMap.put("network", paramString5);
    }
    localHashMap.put("redirect_uri", paramString3);
    localHashMap.put("state", paramString2);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "https://nid.naver.com/oauth2.0/authorize?";
    arrayOfObject[1] = getQueryParameter(localHashMap);
    return String.format("%s%s", arrayOfObject);
  }
  
  public String generateRequestRefreshAccessTokenUrl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("client_id", paramString1);
    localHashMap.put("client_secret", paramString2);
    localHashMap.put("grant_type", "refresh_token");
    localHashMap.put("refresh_token", paramString3);
    localHashMap.put("oauth_os", "android");
    localHashMap.put("locale", paramString4);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "https://nid.naver.com/oauth2.0/token?";
    arrayOfObject[1] = getQueryParameter(localHashMap);
    return String.format("%s%s", arrayOfObject);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.connection.gen.OAuthQueryGenerator
 * JD-Core Version:    0.7.0.1
 */