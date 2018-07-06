package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cr
{
  public final long qA;
  public int qB;
  public int qC;
  public final List<cq> qu;
  public final long qv;
  public final List<String> qw;
  public final List<String> qx;
  public final List<String> qy;
  public final String qz;
  
  public cr(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject(paramString);
    if (gr.v(2)) {
      gr.V("Mediation Response JSON: " + localJSONObject1.toString(2));
    }
    JSONArray localJSONArray = localJSONObject1.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int i = -1;
    for (int j = 0; j < localJSONArray.length(); j++)
    {
      cq localcq = new cq(localJSONArray.getJSONObject(j));
      localArrayList.add(localcq);
      if ((i < 0) && (a(localcq))) {
        i = j;
      }
    }
    this.qB = i;
    this.qC = localJSONArray.length();
    this.qu = Collections.unmodifiableList(localArrayList);
    this.qz = localJSONObject1.getString("qdata");
    JSONObject localJSONObject2 = localJSONObject1.optJSONObject("settings");
    if (localJSONObject2 != null)
    {
      this.qv = localJSONObject2.optLong("ad_network_timeout_millis", -1L);
      this.qw = cw.a(localJSONObject2, "click_urls");
      this.qx = cw.a(localJSONObject2, "imp_urls");
      this.qy = cw.a(localJSONObject2, "nofill_urls");
      long l1 = localJSONObject2.optLong("refresh", -1L);
      if (l1 > 0L) {}
      for (long l2 = l1 * 1000L;; l2 = -1L)
      {
        this.qA = l2;
        return;
      }
    }
    this.qv = -1L;
    this.qw = null;
    this.qx = null;
    this.qy = null;
    this.qA = -1L;
  }
  
  private boolean a(cq paramcq)
  {
    Iterator localIterator = paramcq.qp.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cr
 * JD-Core Version:    0.7.0.1
 */