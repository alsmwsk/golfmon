package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class fr
{
  private static final SimpleDateFormat uD = new SimpleDateFormat("yyyyMMdd");
  
  public static fj a(Context paramContext, fh paramfh, String paramString)
  {
    JSONObject localJSONObject;
    String str1;
    String str3;
    String str4;
    long l1;
    String str5;
    long l2;
    int i;
    fj localfj3;
    label206:
    Object localObject1;
    label244:
    int m;
    label340:
    Object localObject3;
    label378:
    int k;
    label419:
    Object localObject5;
    label457:
    int j;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        str1 = localJSONObject.optString("ad_base_url", null);
        String str2 = localJSONObject.optString("ad_url", null);
        str3 = localJSONObject.optString("ad_size", null);
        str4 = localJSONObject.optString("ad_html", null);
        l1 = -1L;
        str5 = localJSONObject.optString("debug_dialog", null);
        if (!localJSONObject.has("interstitial_timeout")) {
          break label649;
        }
        l2 = (1000.0D * localJSONObject.getDouble("interstitial_timeout"));
        String str6 = localJSONObject.optString("orientation", null);
        i = -1;
        if ("portrait".equals(str6))
        {
          i = gi.dv();
          if (!TextUtils.isEmpty(str4))
          {
            if (!TextUtils.isEmpty(str1)) {
              break label643;
            }
            gr.W("Could not parse the mediation config: Missing required ad_base_url field");
            return new fj(0);
          }
        }
        else
        {
          if (!"landscape".equals(str6)) {
            continue;
          }
          i = gi.du();
          continue;
        }
        if (!TextUtils.isEmpty(str2))
        {
          fj localfj2 = fq.a(paramContext, paramfh.lO.wS, str2, null, null);
          str1 = localfj2.sg;
          str4 = localfj2.tU;
          l1 = localfj2.ua;
          localfj3 = localfj2;
          JSONArray localJSONArray1 = localJSONObject.optJSONArray("click_urls");
          if (localfj3 == null)
          {
            localObject1 = null;
            if (localJSONArray1 == null) {
              break;
            }
            if (localObject1 != null) {
              break label657;
            }
            localObject1 = new LinkedList();
            break label657;
            if (m >= localJSONArray1.length()) {
              break label663;
            }
            ((List)localObject1).add(localJSONArray1.getString(m));
            m++;
            continue;
          }
        }
        else
        {
          gr.W("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          fj localfj1 = new fj(0);
          return localfj1;
        }
      }
      catch (JSONException localJSONException)
      {
        gr.W("Could not parse the mediation config: " + localJSONException.getMessage());
        return new fj(0);
      }
      localObject1 = localfj3.qw;
      continue;
      JSONArray localJSONArray2 = localJSONObject.optJSONArray("impression_urls");
      if (localfj3 == null) {
        localObject3 = null;
      }
      while (localJSONArray2 != null)
      {
        if (localObject3 != null) {
          break label670;
        }
        localObject3 = new LinkedList();
        break label670;
        while (k < localJSONArray2.length())
        {
          ((List)localObject3).add(localJSONArray2.getString(k));
          k++;
        }
        localObject3 = localfj3.qx;
        continue;
        JSONArray localJSONArray3 = localJSONObject.optJSONArray("manual_impression_urls");
        if (localfj3 == null) {}
        for (localObject5 = null; localJSONArray3 != null; localObject5 = localfj3.tY)
        {
          if (localObject5 != null) {
            break label683;
          }
          localObject5 = new LinkedList();
          break label683;
          while (j < localJSONArray3.length())
          {
            ((List)localObject5).add(localJSONArray3.getString(j));
            j++;
          }
        }
      }
    }
    for (;;)
    {
      if (localfj3 != null)
      {
        if (localfj3.orientation != -1) {
          i = localfj3.orientation;
        }
        if (localfj3.tV > 0L) {
          l2 = localfj3.tV;
        }
      }
      String str7 = localJSONObject.optString("active_view");
      boolean bool = localJSONObject.optBoolean("ad_is_javascript", false);
      String str8 = null;
      if (bool) {
        str8 = localJSONObject.optString("ad_passback_url", null);
      }
      fj localfj4 = new fj(str1, str4, (List)localObject2, (List)localObject4, l2, false, -1L, (List)localObject6, -1L, i, str3, l1, str5, bool, str8, str7, false, false, paramfh.tT, false);
      return localfj4;
      Object localObject6 = localObject5;
      continue;
      Object localObject4 = localObject3;
      break label419;
      Object localObject2 = localObject1;
      break label340;
      label643:
      localfj3 = null;
      break label206;
      label649:
      l2 = -1L;
      break;
      label657:
      m = 0;
      break label244;
      label663:
      localObject2 = localObject1;
      break label340;
      label670:
      k = 0;
      break label378;
      localObject4 = localObject3;
      break label419;
      label683:
      j = 0;
      break label457;
      localObject6 = localObject5;
    }
  }
  
  public static String a(fh paramfh, fv paramfv, Location paramLocation, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString1)) {
        localArrayList.add(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localArrayList.add(paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localArrayList.add(paramString3);
      }
      if (localArrayList.size() > 0) {
        localHashMap.put("eid", TextUtils.join(",", localArrayList));
      }
      if (paramfh.tK != null) {
        localHashMap.put("ad_pos", paramfh.tK);
      }
      a(localHashMap, paramfh.tL);
      localHashMap.put("format", paramfh.lS.op);
      if (paramfh.lS.width == -1) {
        localHashMap.put("smart_w", "full");
      }
      if (paramfh.lS.height == -2) {
        localHashMap.put("smart_h", "auto");
      }
      if (paramfh.lS.or != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        ay[] arrayOfay = paramfh.lS.or;
        int i = arrayOfay.length;
        int j = 0;
        if (j < i)
        {
          ay localay = arrayOfay[j];
          if (localStringBuilder.length() != 0) {
            localStringBuilder.append("|");
          }
          int k;
          if (localay.width == -1)
          {
            k = (int)(localay.widthPixels / paramfv.vw);
            label273:
            localStringBuilder.append(k);
            localStringBuilder.append("x");
            if (localay.height != -2) {
              break label338;
            }
          }
          label338:
          for (int m = (int)(localay.heightPixels / paramfv.vw);; m = localay.height)
          {
            localStringBuilder.append(m);
            j++;
            break;
            k = localay.width;
            break label273;
          }
        }
        localHashMap.put("sz", localStringBuilder);
      }
      if (paramfh.tR != 0)
      {
        localHashMap.put("native_version", Integer.valueOf(paramfh.tR));
        localHashMap.put("native_templates", paramfh.mc);
      }
      localHashMap.put("slotname", paramfh.lL);
      localHashMap.put("pn", paramfh.applicationInfo.packageName);
      if (paramfh.tM != null) {
        localHashMap.put("vc", Integer.valueOf(paramfh.tM.versionCode));
      }
      localHashMap.put("ms", paramfh.tN);
      localHashMap.put("seq_num", paramfh.tO);
      localHashMap.put("session_id", paramfh.tP);
      localHashMap.put("js", paramfh.lO.wS);
      a(localHashMap, paramfv);
      if ((paramfh.tL.versionCode >= 2) && (paramfh.tL.ol != null)) {
        a(localHashMap, paramfh.tL.ol);
      }
      if (paramfh.versionCode >= 2) {
        localHashMap.put("quality_signals", paramfh.tQ);
      }
      if ((paramfh.versionCode >= 4) && (paramfh.tT)) {
        localHashMap.put("forceHttps", Boolean.valueOf(paramfh.tT));
      }
      if ((paramfh.versionCode >= 3) && (paramfh.tS != null)) {
        localHashMap.put("content_info", paramfh.tS);
      }
      if (gr.v(2))
      {
        String str2 = gi.t(localHashMap).toString(2);
        gr.V("Ad Request JSON: " + str2);
      }
      String str1 = gi.t(localHashMap).toString();
      return str1;
    }
    catch (JSONException localJSONException)
    {
      gr.W("Problem serializing ad request to JSON: " + localJSONException.getMessage());
    }
    return null;
  }
  
  private static void a(HashMap<String, Object> paramHashMap, Location paramLocation)
  {
    HashMap localHashMap = new HashMap();
    Float localFloat = Float.valueOf(1000.0F * paramLocation.getAccuracy());
    Long localLong1 = Long.valueOf(1000L * paramLocation.getTime());
    Long localLong2 = Long.valueOf((10000000.0D * paramLocation.getLatitude()));
    Long localLong3 = Long.valueOf((10000000.0D * paramLocation.getLongitude()));
    localHashMap.put("radius", localFloat);
    localHashMap.put("lat", localLong2);
    localHashMap.put("long", localLong3);
    localHashMap.put("time", localLong1);
    paramHashMap.put("uule", localHashMap);
  }
  
  private static void a(HashMap<String, Object> paramHashMap, av paramav)
  {
    String str = ge.dr();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramav.od != -1L) {
      paramHashMap.put("cust_age", uD.format(new Date(paramav.od)));
    }
    if (paramav.extras != null) {
      paramHashMap.put("extras", paramav.extras);
    }
    if (paramav.oe != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramav.oe));
    }
    if (paramav.of != null) {
      paramHashMap.put("kw", paramav.of);
    }
    if (paramav.oh != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramav.oh));
    }
    if (paramav.og) {
      paramHashMap.put("adtest", "on");
    }
    if (paramav.versionCode >= 2)
    {
      if (paramav.oi) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramav.oj)) {
        paramHashMap.put("ppid", paramav.oj);
      }
      if (paramav.ok != null) {
        a(paramHashMap, paramav.ok);
      }
    }
    if ((paramav.versionCode >= 3) && (paramav.om != null)) {
      paramHashMap.put("url", paramav.om);
    }
  }
  
  private static void a(HashMap<String, Object> paramHashMap, bj parambj)
  {
    if (Color.alpha(parambj.oQ) != 0) {
      paramHashMap.put("acolor", u(parambj.oQ));
    }
    if (Color.alpha(parambj.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", u(parambj.backgroundColor));
    }
    if ((Color.alpha(parambj.oR) != 0) && (Color.alpha(parambj.oS) != 0))
    {
      paramHashMap.put("gradientto", u(parambj.oR));
      paramHashMap.put("gradientfrom", u(parambj.oS));
    }
    if (Color.alpha(parambj.oT) != 0) {
      paramHashMap.put("bcolor", u(parambj.oT));
    }
    paramHashMap.put("bthick", Integer.toString(parambj.oU));
    Object localObject1;
    Object localObject2;
    switch (parambj.oV)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      int i = parambj.oW;
      localObject2 = null;
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      if (localObject2 != null) {
        paramHashMap.put("callbuttoncolor", localObject2);
      }
      if (parambj.oX != null) {
        paramHashMap.put("channel", parambj.oX);
      }
      if (Color.alpha(parambj.oY) != 0) {
        paramHashMap.put("dcolor", u(parambj.oY));
      }
      if (parambj.oZ != null) {
        paramHashMap.put("font", parambj.oZ);
      }
      if (Color.alpha(parambj.pa) != 0) {
        paramHashMap.put("hcolor", u(parambj.pa));
      }
      paramHashMap.put("headersize", Integer.toString(parambj.pb));
      if (parambj.pc != null) {
        paramHashMap.put("q", parambj.pc);
      }
      return;
      localObject1 = "none";
      break;
      localObject1 = "dashed";
      break;
      localObject1 = "dotted";
      break;
      localObject1 = "solid";
      break;
      localObject2 = "dark";
      continue;
      localObject2 = "light";
      continue;
      localObject2 = "medium";
    }
  }
  
  private static void a(HashMap<String, Object> paramHashMap, fv paramfv)
  {
    paramHashMap.put("am", Integer.valueOf(paramfv.vg));
    paramHashMap.put("cog", u(paramfv.vh));
    paramHashMap.put("coh", u(paramfv.vi));
    if (!TextUtils.isEmpty(paramfv.vj)) {
      paramHashMap.put("carrier", paramfv.vj);
    }
    paramHashMap.put("gl", paramfv.vk);
    if (paramfv.vl) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    paramHashMap.put("ma", u(paramfv.vm));
    paramHashMap.put("sp", u(paramfv.vn));
    paramHashMap.put("hl", paramfv.vo);
    if (!TextUtils.isEmpty(paramfv.vp)) {
      paramHashMap.put("mv", paramfv.vp);
    }
    paramHashMap.put("muv", Integer.valueOf(paramfv.vq));
    if (paramfv.vr != -2) {
      paramHashMap.put("cnt", Integer.valueOf(paramfv.vr));
    }
    paramHashMap.put("gnt", Integer.valueOf(paramfv.vs));
    paramHashMap.put("pt", Integer.valueOf(paramfv.vt));
    paramHashMap.put("rm", Integer.valueOf(paramfv.vu));
    paramHashMap.put("riv", Integer.valueOf(paramfv.vv));
    paramHashMap.put("u_sd", Float.valueOf(paramfv.vw));
    paramHashMap.put("sh", Integer.valueOf(paramfv.vy));
    paramHashMap.put("sw", Integer.valueOf(paramfv.vx));
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("active_network_state", paramfv.vC);
    localBundle1.putBoolean("active_network_metered", paramfv.vB);
    paramHashMap.put("connectivity", localBundle1);
    Bundle localBundle2 = new Bundle();
    localBundle2.putBoolean("is_charging", paramfv.vA);
    localBundle2.putDouble("battery_level", paramfv.vz);
    paramHashMap.put("battery", localBundle2);
  }
  
  private static Integer u(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
  
  private static String u(int paramInt)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0xFFFFFF & paramInt);
    return String.format(localLocale, "#%06x", arrayOfObject);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fr
 * JD-Core Version:    0.7.0.1
 */