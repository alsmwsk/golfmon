package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cw
{
  public static List<String> a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList(localJSONArray.length());
      for (int i = 0; i < localJSONArray.length(); i++) {
        localArrayList.add(localJSONArray.getString(i));
      }
      return Collections.unmodifiableList(localArrayList);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, fy paramfy, String paramString2, boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", paramfy.vE.qz).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", ga.vY).replaceAll("@gw_seqnum@", paramfy.tO);
        if (paramfy.qP != null) {
          str2 = str2.replaceAll("@gw_adnetid@", paramfy.qP.qo).replaceAll("@gw_allocid@", paramfy.qP.qq);
        }
        new gp(paramContext, paramString1, str2).start();
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cw
 * JD-Core Version:    0.7.0.1
 */