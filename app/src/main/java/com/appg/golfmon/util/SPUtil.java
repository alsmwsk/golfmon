package com.appg.golfmon.util;

import android.content.Context;
import org.apache.commons.httpclient.Cookie;
import org.json.JSONException;
import org.json.JSONObject;

public class SPUtil
  extends SPUtilBase
{
  public static final String NAME_SYS = "spu.sys";
  public static final String NAME_USER = "spu.user";
  private static final String SPU_K_AD_URL = "SPU_K_AD_URL";
  private static final String SPU_K_CAFE_HEADER = "SPU_K_CAFE_HEADER";
  private static final String SPU_K_COOKIE = "SPU_K_COOKIE";
  private static final String SPU_K_Guide_VIEW = "SPU_K_Guide_VIEW";
  private static final String SPU_K_HOME = "SPU_K_HOME";
  private static final String SPU_K_IS_APP_ADMIN = "SPU_K_IS_APP_ADMIN";
  private static final String SPU_K_IS_EVENT_OFF = "SPU_K_IS_EVENT_OFF";
  private static final String SPU_K_IS_LOCATION = "SPU_K_IS_LOCATION";
  private static final String SPU_K_IS_LOGIN = "SPU_K_IS_LOGIN";
  private static final String SPU_K_IS_LOGIN_AUTO = "SPU_K_IS_LOGIN_AUTO";
  private static final String SPU_K_IS_POP = "SPU_K_IS_POP";
  private static final String SPU_K_IS_PUSH = "SPU_K_IS_PUSH";
  private static final String SPU_K_IS_SOUND = "SPU_K_IS_SOUND";
  private static final String SPU_K_IS_VIBRATOR = "SPU_K_IS_VIBRATOR";
  private static final String SPU_K_LOGIN_TYPE = "SPU_K_LOGIN_TYPE";
  private static final String SPU_K_MARKET_URL = "SPU_K_MARKET_URL";
  private static final String SPU_K_MARKET_URL_IOS = "SPU_K_MARKET_URL_IOS";
  private static final String SPU_K_NEW_COUNT = "SPU_K_NEW_COUNT";
  private static final String SPU_K_PUSH_TYPE = "SPU_K_PUSH_TYPE";
  private static final String SPU_K_REGISTKEY = "SPU_K_REGISTKEY";
  private static final String SPU_K_SERVER_VERSION = "SPU_K_SERVER_VERSION";
  private static final String SPU_K_USER_Address = "SPU_K_USER_Address";
  private static final String SPU_K_USER_FBID = "SPU_K_USER_FBID";
  private static final String SPU_K_USER_ID = "SPU_K_USER_ID";
  private static final String SPU_K_USER_INFO = "SPU_K_USER_INFO";
  private static final String SPU_K_USER_LimitID = "SPU_K_USER_LimitID";
  private static final String SPU_K_USER_Location = "SPU_K_USER_Location";
  private static final String SPU_K_USER_LoginTime = "SPU_K_USER_LoginTime";
  private static final String SPU_K_USER_NUMBER = "SPU_K_USER_NUMBER";
  private static final String SPU_K_USER_PW = "SPU_K_USER_PW";
  private static final String SPU_K_USER_TYPE = "SPU_K_USER_TYPE";
  private static final String TAG = "APPG_SPU";
  private static SPUtil helper = new SPUtil();
  private Cookie[] cookies = null;
  
  public static SPUtil getInstance()
  {
    if (helper == null) {
      helper = new SPUtil();
    }
    return helper;
  }
  
  public boolean getAdView(Context paramContext)
  {
    return readBoolean(paramContext, "spu.sys", "SPU_K_Guide_VIEW", false);
  }
  
  public boolean getAgreeLocation(Context paramContext)
  {
    return readBoolean(paramContext, "spu.sys", "SPU_K_IS_LOCATION", false);
  }
  
  public String getCafeHeader(Context paramContext)
  {
    return readString(paramContext, "spu.sys", "SPU_K_CAFE_HEADER", "안드로이드 앱 다운로드 >>> http://gil.cc/84Z3\n\n\n");
  }
  
  public Cookie[] getCookie(Context paramContext)
  {
    LogUtil.d("APPG_SPU", "COOKE READ============================================================================");
    String[] arrayOfString;
    Cookie[] arrayOfCookie;
    int i;
    if (this.cookies == null)
    {
      String str = readString(paramContext, "spu.sys", "SPU_K_COOKIE", "");
      if (FormatUtil.isNullorEmpty(str))
      {
        LogUtil.d("APPG_SPU", "COOKE READ 없음=======================================================================");
        return null;
      }
      arrayOfString = str.split("///");
      arrayOfCookie = new Cookie[arrayOfString.length];
      i = 0;
      if (i >= arrayOfString.length)
      {
        LogUtil.d("APPG_SPU", "COOKE READ FILE ======================================================================");
        this.cookies = arrayOfCookie;
      }
    }
    for (;;)
    {
      return this.cookies;
      JSONObject localJSONObject = JSONUtil.createObject(arrayOfString[i]);
      LogUtil.d("APPG_SPU", "i : " + i);
      LogUtil.d("APPG_SPU", "job.toString() : " + localJSONObject.toString());
      Cookie localCookie = new Cookie();
      localCookie.setDomain(JSONUtil.getString(localJSONObject, "cookieDomain"));
      localCookie.setName(JSONUtil.getString(localJSONObject, "cookieName"));
      localCookie.setPath(JSONUtil.getString(localJSONObject, "cookiePath"));
      localCookie.setValue(JSONUtil.getString(localJSONObject, "cookieValue"));
      arrayOfCookie[i] = localCookie;
      i++;
      break;
      LogUtil.d("APPG_SPU", "COOKE READ MEMORY ====================================================================");
    }
  }
  
  public int getHome(Context paramContext)
  {
    return readInt(paramContext, "spu.sys", "SPU_K_HOME", 100);
  }
  
  public boolean getIsAutoLogin(Context paramContext)
  {
    return readBoolean(paramContext, "spu.sys", "SPU_K_IS_LOGIN_AUTO", true);
  }
  
  public boolean getIsLogin(Context paramContext)
  {
    return readBoolean(paramContext, "spu.sys", "SPU_K_IS_LOGIN", false);
  }
  
  public int getIsOffEvent(Context paramContext)
  {
    return readInt(paramContext, "spu.sys", "SPU_K_IS_EVENT_OFF", 0);
  }
  
  public boolean getIsOnAppAdmin(Context paramContext)
  {
    return readBoolean(paramContext, "spu.sys", "SPU_K_IS_APP_ADMIN", false);
  }
  
  public boolean getIsOnPop(Context paramContext)
  {
    return readBoolean(paramContext, "spu.sys", "SPU_K_IS_POP", false);
  }
  
  public boolean getIsOnPush(Context paramContext)
  {
    return readBoolean(paramContext, "spu.sys", "SPU_K_IS_PUSH", true);
  }
  
  public boolean getIsOnSound(Context paramContext)
  {
    return readBoolean(paramContext, "spu.sys", "SPU_K_IS_SOUND", true);
  }
  
  public boolean getIsOnVib(Context paramContext)
  {
    return readBoolean(paramContext, "spu.sys", "SPU_K_IS_VIBRATOR", true);
  }
  
  public int getLocationType(Context paramContext)
  {
    return readInt(paramContext, "spu.user", "SPU_K_USER_Location", 0);
  }
  
  public String getMarketUrl(Context paramContext)
  {
    return readString(paramContext, "spu.sys", "SPU_K_MARKET_URL", "market://details?id=com.appg.golfmon");
  }
  
  public String getMarketUrlIOS(Context paramContext)
  {
    return readString(paramContext, "spu.sys", "SPU_K_MARKET_URL_IOS", "market://details?id=com.appg.golfmon");
  }
  
  public int getNewCount(Context paramContext)
  {
    return readInt(paramContext, "spu.sys", "SPU_K_NEW_COUNT", 0);
  }
  
  public int getPushType(Context paramContext)
  {
    return readInt(paramContext, "spu.sys", "SPU_K_PUSH_TYPE", 1);
  }
  
  public String getRegistPushKey(Context paramContext)
  {
    return readString(paramContext, "spu.sys", "SPU_K_REGISTKEY", "");
  }
  
  public String getServerVersion(Context paramContext)
  {
    return readString(paramContext, "spu.sys", "SPU_K_SERVER_VERSION", "");
  }
  
  public JSONObject getUserAddressInfo(Context paramContext)
  {
    return readJSONObject(paramContext, "spu.user", "SPU_K_USER_Address");
  }
  
  public String getUserFBID(Context paramContext)
  {
    return readString(paramContext, "spu.sys", "SPU_K_USER_FBID", "");
  }
  
  public String getUserID(Context paramContext)
  {
    return readString(paramContext, "spu.sys", "SPU_K_USER_ID", "");
  }
  
  public JSONObject getUserInfo(Context paramContext)
  {
    return readJSONObject(paramContext, "spu.user", "SPU_K_USER_INFO");
  }
  
  public String getUserLimitID(Context paramContext)
  {
    return readString(paramContext, "spu.user", "SPU_K_USER_LimitID", "");
  }
  
  public long getUserLoginTime(Context paramContext)
  {
    return readLong(paramContext, "spu.user", "SPU_K_USER_LoginTime");
  }
  
  public int getUserNumber(Context paramContext)
  {
    return readInt(paramContext, "spu.sys", "SPU_K_USER_NUMBER", 0);
  }
  
  public String getUserPW(Context paramContext)
  {
    return readString(paramContext, "spu.sys", "SPU_K_USER_PW", "");
  }
  
  public String getUserType(Context paramContext)
  {
    return readString(paramContext, "spu.user", "SPU_K_USER_TYPE", "1");
  }
  
  public void logOut(Context paramContext)
  {
    removeCookie(paramContext);
    removeUserInfo(paramContext);
    deleteData(paramContext, "spu.sys", "SPU_K_IS_LOGIN");
    deleteData(paramContext, "spu.sys", "SPU_K_NEW_COUNT");
  }
  
  public void removeCookie(Context paramContext)
  {
    LogUtil.d("APPG_SPU", "COOKE REMOVE==========================================================================");
    this.cookies = null;
    deleteData(paramContext, "spu.sys", "SPU_K_COOKIE");
  }
  
  public void removeUserInfo(Context paramContext)
  {
    deleteData(paramContext, "spu.user", "SPU_K_USER_INFO");
  }
  
  public void setAdView(Context paramContext, boolean paramBoolean)
  {
    writeBoolean(paramContext, "spu.sys", "SPU_K_Guide_VIEW", paramBoolean);
  }
  
  public void setAgreeLocation(Context paramContext, boolean paramBoolean)
  {
    writeBoolean(paramContext, "spu.sys", "SPU_K_IS_LOCATION", paramBoolean);
  }
  
  public void setCafeHeader(Context paramContext, String paramString)
  {
    writeString(paramContext, "spu.sys", "SPU_K_CAFE_HEADER", paramString);
  }
  
  public void setCookie(Context paramContext, Cookie[] paramArrayOfCookie)
  {
    Object localObject = "";
    LogUtil.d("APPG_SPU", "COOKE SAVE============================================================================");
    this.cookies = paramArrayOfCookie;
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfCookie.length)
      {
        writeString(paramContext, "spu.sys", "SPU_K_COOKIE", (String)localObject);
        LogUtil.d("APPG_SPU", "COOKE SAVE============================================================================");
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("cookieDomain", paramArrayOfCookie[i].getDomain());
        localJSONObject.put("cookieName", paramArrayOfCookie[i].getName());
        localJSONObject.put("cookiePath", paramArrayOfCookie[i].getPath());
        localJSONObject.put("cookieValue", paramArrayOfCookie[i].getValue());
        LogUtil.d("APPG_SPU", "i : " + i);
        LogUtil.d("APPG_SPU", "job.toString() : " + localJSONObject.toString());
        if (FormatUtil.isNullorEmpty((String)localObject))
        {
          localObject = localJSONObject.toString();
        }
        else
        {
          String str = localObject + "///" + localJSONObject.toString();
          localObject = str;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void setHome(Context paramContext, int paramInt)
  {
    writeInt(paramContext, "spu.sys", "SPU_K_HOME", paramInt);
  }
  
  public void setIsAutoLogin(Context paramContext, boolean paramBoolean)
  {
    writeBoolean(paramContext, "spu.sys", "SPU_K_IS_LOGIN_AUTO", paramBoolean);
  }
  
  public void setIsLogin(Context paramContext, boolean paramBoolean)
  {
    writeBoolean(paramContext, "spu.sys", "SPU_K_IS_LOGIN", paramBoolean);
  }
  
  public void setIsOffEvent(Context paramContext, int paramInt)
  {
    writeInt(paramContext, "spu.sys", "SPU_K_IS_EVENT_OFF", paramInt);
  }
  
  public void setIsOnAppAdmin(Context paramContext, boolean paramBoolean)
  {
    writeBoolean(paramContext, "spu.sys", "SPU_K_IS_APP_ADMIN", paramBoolean);
  }
  
  public void setIsOnPop(Context paramContext, boolean paramBoolean)
  {
    writeBoolean(paramContext, "spu.sys", "SPU_K_IS_POP", paramBoolean);
  }
  
  public void setIsOnPush(Context paramContext, boolean paramBoolean)
  {
    writeBoolean(paramContext, "spu.sys", "SPU_K_IS_PUSH", paramBoolean);
  }
  
  public void setIsOnSound(Context paramContext, boolean paramBoolean)
  {
    writeBoolean(paramContext, "spu.sys", "SPU_K_IS_SOUND", paramBoolean);
  }
  
  public void setIsOnVib(Context paramContext, boolean paramBoolean)
  {
    writeBoolean(paramContext, "spu.sys", "SPU_K_IS_VIBRATOR", paramBoolean);
  }
  
  public void setLocationType(Context paramContext, int paramInt)
  {
    writeInt(paramContext, "spu.user", "SPU_K_USER_Location", paramInt);
  }
  
  public void setMarketUrl(Context paramContext, String paramString)
  {
    writeString(paramContext, "spu.sys", "SPU_K_MARKET_URL", paramString);
  }
  
  public void setMarketUrlIOS(Context paramContext, String paramString)
  {
    writeString(paramContext, "spu.sys", "SPU_K_MARKET_URL_IOS", "");
  }
  
  public void setNewCount(Context paramContext, int paramInt)
  {
    writeInt(paramContext, "spu.sys", "SPU_K_NEW_COUNT", paramInt);
  }
  
  public void setPushType(Context paramContext, int paramInt)
  {
    writeInt(paramContext, "spu.sys", "SPU_K_PUSH_TYPE", paramInt);
  }
  
  public void setRegistPushKey(Context paramContext, String paramString)
  {
    writeString(paramContext, "spu.sys", "SPU_K_REGISTKEY", paramString);
  }
  
  public void setServerVersion(Context paramContext, String paramString)
  {
    writeString(paramContext, "spu.sys", "SPU_K_SERVER_VERSION", paramString);
  }
  
  public void setUserAddressInfo(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      writeString(paramContext, "spu.user", "SPU_K_USER_Address", paramJSONObject.toString());
    }
  }
  
  public void setUserFBID(Context paramContext, String paramString)
  {
    writeString(paramContext, "spu.sys", "SPU_K_USER_FBID", paramString);
  }
  
  public void setUserID(Context paramContext, String paramString)
  {
    writeString(paramContext, "spu.sys", "SPU_K_USER_ID", paramString);
  }
  
  public void setUserInfo(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      writeString(paramContext, "spu.user", "SPU_K_USER_INFO", paramJSONObject.toString());
    }
  }
  
  public void setUserLimitID(Context paramContext, String paramString)
  {
    writeString(paramContext, "spu.user", "SPU_K_USER_LimitID", paramString);
  }
  
  public void setUserLoginTime(Context paramContext, long paramLong)
  {
    writeLong(paramContext, "spu.user", "SPU_K_USER_LoginTime", paramLong);
  }
  
  public void setUserNumber(Context paramContext, int paramInt)
  {
    writeInt(paramContext, "spu.sys", "SPU_K_USER_NUMBER", paramInt);
  }
  
  public void setUserPW(Context paramContext, String paramString)
  {
    writeString(paramContext, "spu.sys", "SPU_K_USER_PW", paramString);
  }
  
  public void setUserType(Context paramContext, String paramString)
  {
    if (paramString != null) {
      writeString(paramContext, "spu.user", "SPU_K_USER_TYPE", paramString);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.SPUtil
 * JD-Core Version:    0.7.0.1
 */