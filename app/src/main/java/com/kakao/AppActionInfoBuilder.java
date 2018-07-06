package com.kakao;

import com.kakao.internal.AppActionInfo;
import com.kakao.internal.AppActionInfo.ACTION_INFO_OS;

public class AppActionInfoBuilder
{
  private final AppActionBuilder.DEVICE_TYPE deviceType;
  private String executeParam;
  private String marketParam;
  private final AppActionInfo.ACTION_INFO_OS os;
  
  private AppActionInfoBuilder(AppActionInfo.ACTION_INFO_OS paramACTION_INFO_OS, AppActionBuilder.DEVICE_TYPE paramDEVICE_TYPE)
  {
    this.os = paramACTION_INFO_OS;
    this.deviceType = paramDEVICE_TYPE;
  }
  
  public static AppActionInfoBuilder createAndroidActionInfoBuilder()
  {
    return new AppActionInfoBuilder(AppActionInfo.ACTION_INFO_OS.ANDROID, null);
  }
  
  public static AppActionInfoBuilder createAndroidActionInfoBuilder(AppActionBuilder.DEVICE_TYPE paramDEVICE_TYPE)
  {
    return new AppActionInfoBuilder(AppActionInfo.ACTION_INFO_OS.ANDROID, paramDEVICE_TYPE);
  }
  
  public static AppActionInfoBuilder createiOSActionInfoBuilder()
  {
    return new AppActionInfoBuilder(AppActionInfo.ACTION_INFO_OS.IOS, null);
  }
  
  public static AppActionInfoBuilder createiOSActionInfoBuilder(AppActionBuilder.DEVICE_TYPE paramDEVICE_TYPE)
  {
    return new AppActionInfoBuilder(AppActionInfo.ACTION_INFO_OS.IOS, paramDEVICE_TYPE);
  }
  
  public AppActionInfo build()
  {
    return new AppActionInfo(this.os, this.deviceType, this.executeParam, this.marketParam);
  }
  
  public AppActionInfoBuilder setExecuteParam(String paramString)
  {
    this.executeParam = paramString;
    return this;
  }
  
  public AppActionInfoBuilder setMarketParam(String paramString)
  {
    this.marketParam = paramString;
    return this;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.AppActionInfoBuilder
 * JD-Core Version:    0.7.0.1
 */