package com.kakao.internal;

import android.text.TextUtils;
import com.kakao.AppActionBuilder.DEVICE_TYPE;
import org.json.JSONException;
import org.json.JSONObject;

public class AppActionInfo
{
  private final AppActionBuilder.DEVICE_TYPE deviceType;
  private final String executeParam;
  private final String marketParam;
  private final ACTION_INFO_OS os;
  
  public AppActionInfo(ACTION_INFO_OS paramACTION_INFO_OS, AppActionBuilder.DEVICE_TYPE paramDEVICE_TYPE, String paramString1, String paramString2)
  {
    this.os = paramACTION_INFO_OS;
    this.executeParam = paramString1;
    this.marketParam = paramString2;
    this.deviceType = paramDEVICE_TYPE;
  }
  
  @Deprecated
  public static AppActionInfo createAndroidActionInfo(AppActionBuilder.DEVICE_TYPE paramDEVICE_TYPE, String paramString1, String paramString2)
  {
    return new AppActionInfo(ACTION_INFO_OS.ANDROID, paramDEVICE_TYPE, paramString1, paramString2);
  }
  
  @Deprecated
  public static AppActionInfo createIOSActionInfo(AppActionBuilder.DEVICE_TYPE paramDEVICE_TYPE, String paramString1, String paramString2)
  {
    return new AppActionInfo(ACTION_INFO_OS.IOS, paramDEVICE_TYPE, paramString1, paramString2);
  }
  
  public JSONObject createJSONObject()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("os", this.os.value);
    if (this.deviceType != null) {
      localJSONObject.put("devicetype", this.deviceType.getValue());
    }
    if (!TextUtils.isEmpty(this.executeParam)) {
      localJSONObject.put("execparam", this.executeParam);
    }
    if (!TextUtils.isEmpty(this.marketParam)) {
      localJSONObject.put("marketparam", this.marketParam);
    }
    return localJSONObject;
  }
  
  public static enum ACTION_INFO_OS
  {
    IOS("ios"),  ANDROID("android");
    
    private final String value;
    
    private ACTION_INFO_OS(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.internal.AppActionInfo
 * JD-Core Version:    0.7.0.1
 */