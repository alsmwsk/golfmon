package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cq
{
  public final String qn;
  public final String qo;
  public final List<String> qp;
  public final String qq;
  public final String qr;
  public final List<String> qs;
  public final String qt;
  
  public cq(JSONObject paramJSONObject)
    throws JSONException
  {
    this.qo = paramJSONObject.getString("id");
    JSONArray localJSONArray = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    for (int i = 0; i < localJSONArray.length(); i++) {
      localArrayList.add(localJSONArray.getString(i));
    }
    this.qp = Collections.unmodifiableList(localArrayList);
    this.qq = paramJSONObject.optString("allocation_id", null);
    this.qs = cw.a(paramJSONObject, "imp_urls");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("ad");
    String str1;
    JSONObject localJSONObject2;
    if (localJSONObject1 != null)
    {
      str1 = localJSONObject1.toString();
      this.qn = str1;
      localJSONObject2 = paramJSONObject.optJSONObject("data");
      if (localJSONObject2 == null) {
        break label175;
      }
    }
    label175:
    for (String str2 = localJSONObject2.toString();; str2 = null)
    {
      this.qt = str2;
      String str3 = null;
      if (localJSONObject2 != null) {
        str3 = localJSONObject2.optString("class_name");
      }
      this.qr = str3;
      return;
      str1 = null;
      break;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cq
 * JD-Core Version:    0.7.0.1
 */