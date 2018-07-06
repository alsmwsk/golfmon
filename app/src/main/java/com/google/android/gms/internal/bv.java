package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@ey
public class bv
{
  private u pM;
  private ah pN;
  private JSONObject pO;
  
  public bv(u paramu, ah paramah, JSONObject paramJSONObject)
  {
    this.pM = paramu;
    this.pN = paramah;
    this.pO = paramJSONObject;
  }
  
  public void aw()
  {
    this.pM.an();
  }
  
  public void b(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("asset", paramInt);
      localJSONObject1.put("template", paramString);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("ad", this.pO);
      localJSONObject2.put("click", localJSONObject1);
      this.pN.a("google.afma.nativeAds.handleClick", localJSONObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      gr.b("Unable to create click JSON.", localJSONException);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(bv parambv);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bv
 * JD-Core Version:    0.7.0.1
 */