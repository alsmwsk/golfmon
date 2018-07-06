package com.nhn.android.naverlogin.connection;

import android.content.Context;
import android.util.Log;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import com.nhn.android.naverlogin.connection.gen.OAuthQueryGenerator;
import com.nhn.android.naverlogin.data.OAuthErrorCode;
import com.nhn.android.naverlogin.data.OAuthResponse;
import com.nhn.android.naverlogin.util.DeviceAppInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OAuthLoginConnection
  extends CommonConnection
{
  private static final String TAG = "NaverLoginOAuth|OAuthLoginConnection";
  
  public static OAuthResponse deleteToken(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    String str = DeviceAppInfo.getBaseInstance().getLocaleString(paramContext);
    return request(paramContext, new OAuthQueryGenerator().generateRequestDeleteAccessTokenUrl(paramString1, paramString2, paramString3, str));
  }
  
  private static OAuthResponse request(Context paramContext, String paramString)
  {
    ResponseData localResponseData = CommonConnection.request(paramContext, paramString, null, null);
    if (!localResponseData.mStat.equals(ResponseData.ResponseDataStat.SUCCESS))
    {
      if (localResponseData.mStatusCode == 503) {
        return new OAuthResponse(OAuthErrorCode.SERVER_ERROR_TEMPORARILY_UNAVAILABLE);
      }
      if (localResponseData.mStatusCode == 500) {
        return new OAuthResponse(OAuthErrorCode.SERVER_ERROR_SERVER_ERROR);
      }
      if ((localResponseData.mStat.equals(ResponseData.ResponseDataStat.CONNECTION_TIMEOUT)) || (localResponseData.mStat.equals(ResponseData.ResponseDataStat.CONNECTION_FAIL))) {
        return new OAuthResponse(OAuthErrorCode.CLIENT_ERROR_CONNECTION_ERROR);
      }
      if (localResponseData.mStat.equals(ResponseData.ResponseDataStat.NO_PEER_CERTIFICATE)) {
        return new OAuthResponse(OAuthErrorCode.CLIENT_ERROR_CERTIFICATION_ERROR);
      }
      return new OAuthResponse(OAuthErrorCode.ERROR_NO_CATAGORIZED);
    }
    for (;;)
    {
      JSONObject localJSONObject;
      Iterator localIterator;
      HashMap localHashMap;
      try
      {
        localJSONObject = new JSONObject(localResponseData.mContent);
        if (OAuthLoginDefine.DEVELOPER_VERSION)
        {
          Log.d("NaverLoginOAuth|OAuthLoginConnection", "len :" + localJSONObject.length());
          Log.d("NaverLoginOAuth|OAuthLoginConnection", "str :" + localJSONObject.toString());
        }
        localIterator = localJSONObject.keys();
        localHashMap = new HashMap();
        if (!localIterator.hasNext())
        {
          OAuthResponse localOAuthResponse = new OAuthResponse(localHashMap);
          return localOAuthResponse;
        }
      }
      catch (JSONException localJSONException)
      {
        if ((OAuthLoginDefine.DEVELOPER_VERSION) && (localResponseData != null)) {
          Log.d("NaverLoginOAuth|OAuthLoginConnection", "content:" + localResponseData.mContent);
        }
        localJSONException.printStackTrace();
        return new OAuthResponse(OAuthErrorCode.CLIENT_ERROR_PARSING_FAIL);
      }
      String str1 = (String)localIterator.next();
      String str2 = localJSONObject.getString(str1);
      localHashMap.put(str1, str2);
      if (OAuthLoginDefine.DEVELOPER_VERSION) {
        Log.d("NaverLoginOAuth|OAuthLoginConnection", "key:" + str1 + ",value:" + str2);
      }
    }
  }
  
  public static OAuthResponse requestAccessToken(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = DeviceAppInfo.getBaseInstance().getLocaleString(paramContext);
    return request(paramContext, new OAuthQueryGenerator().generateRequestAccessTokenUrl(paramString1, paramString2, paramString3, paramString4, str));
  }
  
  public static OAuthResponse requestRefreshToken(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    String str = DeviceAppInfo.getBaseInstance().getLocaleString(paramContext);
    return request(paramContext, new OAuthQueryGenerator().generateRequestRefreshAccessTokenUrl(paramString1, paramString2, paramString3, str));
  }
  
  public static ResponseData requestWithOAuthHeader(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return CommonConnection.request(paramContext, paramString1, null, null, paramString4, false);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.connection.OAuthLoginConnection
 * JD-Core Version:    0.7.0.1
 */