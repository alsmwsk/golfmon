package com.kakao;

import com.kakao.internal.Action;
import com.kakao.internal.AppActionInfo;
import java.util.HashSet;
import java.util.Set;

public class AppActionBuilder
{
  private final Set<AppActionInfo> appActionInfos = new HashSet();
  private String url;
  
  public AppActionBuilder addActionInfo(AppActionInfo paramAppActionInfo)
  {
    this.appActionInfos.add(paramAppActionInfo);
    return this;
  }
  
  public Action build()
    throws KakaoParameterException
  {
    return Action.newActionApp(this.url, (AppActionInfo[])this.appActionInfos.toArray(new AppActionInfo[this.appActionInfos.size()]));
  }
  
  @Deprecated
  public AppActionBuilder setAndroidExecuteURLParam(String paramString)
  {
    return setAndroidExecuteURLParam(paramString, null);
  }
  
  @Deprecated
  public AppActionBuilder setAndroidExecuteURLParam(String paramString, DEVICE_TYPE paramDEVICE_TYPE)
  {
    AppActionInfo localAppActionInfo = AppActionInfo.createAndroidActionInfo(paramDEVICE_TYPE, paramString, null);
    this.appActionInfos.add(localAppActionInfo);
    return this;
  }
  
  @Deprecated
  public AppActionBuilder setIOSExecuteURLParam(String paramString)
  {
    AppActionInfo localAppActionInfo = AppActionInfo.createIOSActionInfo(null, paramString, null);
    this.appActionInfos.add(localAppActionInfo);
    return this;
  }
  
  @Deprecated
  public AppActionBuilder setIOSExecuteURLParam(String paramString, DEVICE_TYPE paramDEVICE_TYPE)
  {
    AppActionInfo localAppActionInfo = AppActionInfo.createIOSActionInfo(paramDEVICE_TYPE, paramString, null);
    this.appActionInfos.add(localAppActionInfo);
    return this;
  }
  
  public AppActionBuilder setUrl(String paramString)
  {
    this.url = paramString;
    return this;
  }
  
  public static enum DEVICE_TYPE
  {
    PAD("pad"),  PHONE("phone");
    
    private final String value;
    
    private DEVICE_TYPE(String paramString)
    {
      this.value = paramString;
    }
    
    public String getValue()
    {
      return this.value;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.AppActionBuilder
 * JD-Core Version:    0.7.0.1
 */