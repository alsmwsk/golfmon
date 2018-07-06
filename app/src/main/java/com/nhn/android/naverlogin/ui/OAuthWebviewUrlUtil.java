package com.nhn.android.naverlogin.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import com.nhn.android.naverlogin.data.OAuthErrorCode;
import com.nhn.android.naverlogin.data.OAuthLoginData;
import com.nhn.android.naverlogin.data.OAuthLoginPreferenceManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class OAuthWebviewUrlUtil
{
  private static final String TAG = "NaverLoginOAuth|OAuthWebvewUrlUtil";
  
  private static String getDecodedString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label21:
    do
    {
      return paramString;
      Object localObject = "";
      try
      {
        String str = URLDecoder.decode(paramString, "UTF-8");
        localObject = str;
      }
      catch (Exception localException)
      {
        break label21;
      }
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equalsIgnoreCase(paramString)));
    return localObject;
  }
  
  private static Map<String, String> getQueryMap(String paramString)
  {
    if (paramString == null)
    {
      localObject = null;
      return localObject;
    }
    String[] arrayOfString1 = paramString.split("&");
    Object localObject = new HashMap();
    int i = arrayOfString1.length;
    int j = 0;
    label29:
    String[] arrayOfString2;
    if (j < i)
    {
      arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length != 2) {
        break label74;
      }
      ((Map)localObject).put(arrayOfString2[0], arrayOfString2[1]);
    }
    for (;;)
    {
      j++;
      break label29;
      break;
      label74:
      if (arrayOfString2.length == 1) {
        ((Map)localObject).put(arrayOfString2[0], "");
      }
    }
  }
  
  private static Map<String, String> getQueryMapFromUrl(String paramString)
  {
    if (paramString.contains("?")) {
      paramString = paramString.split("\\?")[1];
    }
    return getQueryMap(paramString);
  }
  
  public static boolean isErrorResultNaverTokenInvalid(Context paramContext, String paramString1, String paramString2, OAuthLoginData paramOAuthLoginData)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.startsWith("https://nid.naver.com/"))) {
        if (OAuthLoginDefine.DEVELOPER_VERSION) {
          Log.d("NaverLoginOAuth|OAuthWebvewUrlUtil", "isErrorResultNaverTokenInvalid - pre url is not naver.com");
        }
      }
      do
      {
        return false;
        try
        {
          Map localMap2 = getQueryMap(new URL(paramString2).getQuery());
          localObject = localMap2;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Map localMap1 = getQueryMapFromUrl(paramString2);
            Object localObject = localMap1;
          }
        }
      } while ((localObject == null) || (!((Map)localObject).containsKey("error")) || (!((Map)localObject).containsKey("error_description")) || (!((String)((Map)localObject).get("error")).equalsIgnoreCase("invalid_request")) || (!((String)((Map)localObject).get("error_description")).contains("token")) || (!((String)((Map)localObject).get("error_description")).contains("invalid")));
      return true;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
    }
  }
  
  public static boolean isFinalUrl(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    do
    {
      return false;
      if ((paramString2.equalsIgnoreCase("http://m.naver.com/")) || (paramString2.equalsIgnoreCase("http://m.naver.com"))) {
        return true;
      }
      if ((paramBoolean) && (paramString2.startsWith("https://nid.naver.com/nidlogin.login?svctype=262144"))) {
        return true;
      }
    } while ((paramBoolean) || (((!paramString1.startsWith("https://nid.naver.com/mobile/user/help/sleepId.nhn?m=viewSleepId&token_help=")) || (!paramString2.startsWith("https://nid.naver.com/nidlogin.login?svctype=262144"))) && ((!paramString1.startsWith("https://nid.naver.com/mobile/user/global/idSafetyRelease.nhn?")) || (!paramString2.startsWith("https://nid.naver.com/nidlogin.login?svctype=262144"))) && ((!paramString1.startsWith("https://nid.naver.com/mobile/user/help/idSafetyRelease.nhn?")) || (!paramString2.startsWith("https://nid.naver.com/nidlogin.login?svctype=262144")))));
    return true;
  }
  
  public static void processCallbackUrl(Context paramContext, String paramString, OAuthLoginData paramOAuthLoginData)
    throws MalformedURLException
  {
    try
    {
      Map localMap2 = getQueryMap(new URL(paramString).getQuery());
      localMap1 = localMap2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Map localMap1 = getQueryMapFromUrl(paramString);
      }
    }
    paramOAuthLoginData.setMiddleResult((String)localMap1.get("code"), (String)localMap1.get("state"), (String)localMap1.get("error"), getDecodedString((String)localMap1.get("error_description")));
  }
  
  public static boolean returnWhenAuthorizationDone(Context paramContext, String paramString1, String paramString2, OAuthLoginData paramOAuthLoginData)
  {
    bool1 = false;
    if (paramOAuthLoginData == null) {
      paramOAuthLoginData = new OAuthLoginData("", "", "");
    }
    try
    {
      if ((TextUtils.isEmpty(paramString1)) || (paramString1.startsWith("https://nid.naver.com/"))) {
        break label165;
      }
      boolean bool5 = paramString1.startsWith("https://nid.naver.com/");
      bool1 = false;
      if (bool5) {
        break label165;
      }
      boolean bool6 = OAuthLoginDefine.DEVELOPER_VERSION;
      bool1 = false;
      if (bool6) {
        Log.d("NaverLoginOAuth|OAuthWebvewUrlUtil", "returnWhenAuthorizationDone - pre url is not naver.com");
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          processCallbackUrl(paramContext, paramString2, paramOAuthLoginData);
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("oauth_code", paramOAuthLoginData.getCode());
          localIntent2.putExtra("oauth_state", paramOAuthLoginData.getInitState());
          localIntent2.putExtra("oauth_error_code", paramOAuthLoginData.getErrorCode().getCode());
          localIntent2.putExtra("oauth_error_desc", paramOAuthLoginData.getErrorDesc());
          ((Activity)paramContext).setResult(-1, localIntent2);
          ((Activity)paramContext).finish();
          return bool1;
          if ((paramString2.startsWith("https://nid.naver.com/login/noauth/logout.nhn")) || (paramString2.startsWith("http://nid.naver.com/nidlogin.logout")))
          {
            Intent localIntent3 = new Intent();
            localIntent3.putExtra("oauth_error_code", OAuthErrorCode.CLIENT_USER_CANCEL.getCode());
            localIntent3.putExtra("oauth_error_desc", OAuthErrorCode.CLIENT_USER_CANCEL.getDesc());
            ((Activity)paramContext).setResult(-1, localIntent3);
            ((Activity)paramContext).finish();
            return true;
          }
          Map localMap1;
          try
          {
            Map localMap2 = getQueryMap(new URL(paramString2).getQuery());
            localMap1 = localMap2;
          }
          catch (Exception localException2)
          {
            boolean bool4;
            localMap1 = getQueryMapFromUrl(paramString2);
            continue;
            if (localMap1 == null) {
              continue;
            }
          }
          if ((localMap1 != null) && (localMap1.containsKey("code")))
          {
            bool4 = localMap1.containsKey("state");
            bool1 = false;
            if (bool4)
            {
              if (!OAuthLoginDefine.DEVELOPER_VERSION) {
                continue;
              }
              Log.d("NaverLoginOAuth|OAuthWebvewUrlUtil", "query map contain code and state");
              continue;
            }
          }
          if (localMap1.containsKey("error"))
          {
            boolean bool3 = localMap1.containsKey("error_description");
            bool1 = false;
            if (bool3)
            {
              if (OAuthLoginDefine.DEVELOPER_VERSION) {
                Log.d("NaverLoginOAuth|OAuthWebvewUrlUtil", "query map contain error, url : " + paramString2);
              }
              bool1 = true;
              OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(paramContext);
              localOAuthLoginPreferenceManager.setLastErrorCode(OAuthErrorCode.fromString((String)localMap1.get("error")));
              localOAuthLoginPreferenceManager.setLastErrorDesc(getDecodedString((String)localMap1.get("error_description")));
              continue;
              localException1 = localException1;
              localException1.printStackTrace();
              continue;
            }
          }
          boolean bool2 = OAuthLoginDefine.DEVELOPER_VERSION;
          bool1 = false;
          if (bool2)
          {
            Log.d("NaverLoginOAuth|OAuthWebvewUrlUtil", "query map does not contain code and state, url:" + paramString2);
            bool1 = false;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          Intent localIntent1 = new Intent();
          localIntent1.putExtra("oauth_error_code", OAuthErrorCode.CLIENT_ERROR_PARSING_FAIL.getCode());
          localIntent1.putExtra("oauth_error_desc", OAuthErrorCode.CLIENT_ERROR_PARSING_FAIL.getDesc());
          ((Activity)paramContext).setResult(0, localIntent1);
          continue;
          bool1 = true;
        }
      }
    }
    if (!bool1) {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.ui.OAuthWebviewUrlUtil
 * JD-Core Version:    0.7.0.1
 */