package com.appg.golfmon.net.http;

import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import org.apache.commons.httpclient.Cookie;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.http.codec.IHttpDecoder;

public class GJSONDecoder
  implements IHttpDecoder
{
  private int mJsonType = 1;
  
  public GJSONDecoder(int paramInt)
  {
    this.mJsonType = paramInt;
  }
  
  public GBean decode(String paramString, Cookie[] paramArrayOfCookie)
  {
    LogUtil.d("GHTTP file 원본", paramString);
    GBean localGBean = new GBean();
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject(paramString);
        localGBean.put("responseData", localJSONObject);
        localGBean.put("returnCode", Integer.valueOf(JSONUtil.getInteger(localJSONObject, "returnCode", -99999)));
        localGBean.put("returnMessage", JSONUtil.getString(localJSONObject, "returnMessage", ""));
        switch (this.mJsonType)
        {
        default: 
          LogUtil.e("GHTTP file 가공", localJSONObject.toString());
          localGBean.put("cookies", paramArrayOfCookie);
          return localGBean;
        }
      }
      catch (Exception localException)
      {
        localGBean.putException(localException);
        localGBean.put("error", paramString);
        return localGBean;
      }
      localGBean.put("entity", JSONUtil.getJSONObject(localJSONObject, "entity"));
      continue;
      localGBean.put("entity", JSONUtil.getJSONArray(localJSONObject, "entity"));
      localGBean.put("totalCount", Integer.valueOf(JSONUtil.getInteger(localJSONObject, "totalCount", -9999)));
      continue;
      localGBean.put("entity", JSONUtil.getString(localJSONObject, "entity", ""));
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.net.http.GJSONDecoder
 * JD-Core Version:    0.7.0.1
 */