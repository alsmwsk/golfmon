package com.appg.golfmon.net.http;

import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.http.handler.IHttpHandler;

public abstract class GResultHandler
  implements IHttpHandler
{
  public GBean handle(GBean paramGBean)
  {
    if (paramGBean == null) {
      return result(null, null, -9999, null, null);
    }
    int i = ((Integer)paramGBean.get("returnCode")).intValue();
    String str = (String)paramGBean.get("returnMessage");
    return result(paramGBean, paramGBean.get("entity"), i, str, (JSONObject)paramGBean.get("responseData"));
  }
  
  public abstract GBean result(GBean paramGBean, Object paramObject, int paramInt, String paramString, JSONObject paramJSONObject);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.net.http.GResultHandler
 * JD-Core Version:    0.7.0.1
 */