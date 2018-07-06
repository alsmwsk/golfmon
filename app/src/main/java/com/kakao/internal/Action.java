package com.kakao.internal;

import com.kakao.KakaoParameterException;
import com.kakao.KakaoParameterException.ERROR_CODE;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Action
{
  private AppActionInfo[] appActionInfos;
  private ACTION_TYPE type;
  private String url;
  
  private Action(ACTION_TYPE paramACTION_TYPE, String paramString, AppActionInfo[] paramArrayOfAppActionInfo)
    throws KakaoParameterException
  {
    if (paramACTION_TYPE == null) {
      throw new KakaoParameterException(KakaoParameterException.ERROR_CODE.CORE_PARAMETER_MISSING, "action needs type.");
    }
    this.type = paramACTION_TYPE;
    this.url = paramString;
    this.appActionInfos = paramArrayOfAppActionInfo;
  }
  
  public static Action newActionApp(String paramString, AppActionInfo[] paramArrayOfAppActionInfo)
    throws KakaoParameterException
  {
    return new Action(ACTION_TYPE.APP, paramString, paramArrayOfAppActionInfo);
  }
  
  public static Action newActionWeb(String paramString)
    throws KakaoParameterException
  {
    return new Action(ACTION_TYPE.WEB, paramString, null);
  }
  
  public JSONObject createJSONObject()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", this.type.value);
    if (this.url != null) {
      localJSONObject.put("url", this.url);
    }
    JSONArray localJSONArray;
    AppActionInfo[] arrayOfAppActionInfo;
    int i;
    if (this.appActionInfos != null)
    {
      localJSONArray = new JSONArray();
      arrayOfAppActionInfo = this.appActionInfos;
      i = arrayOfAppActionInfo.length;
    }
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        localJSONObject.put("actioninfo", localJSONArray);
        return localJSONObject;
      }
      localJSONArray.put(arrayOfAppActionInfo[j].createJSONObject());
    }
  }
  
  public static enum ACTION_TYPE
  {
    APP("app"),  WEB("web");
    
    private final String value;
    
    private ACTION_TYPE(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.internal.Action
 * JD-Core Version:    0.7.0.1
 */