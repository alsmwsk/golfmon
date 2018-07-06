package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

@ey
public final class cj
  implements cd
{
  private static int a(DisplayMetrics paramDisplayMetrics, Map<String, String> paramMap, String paramString, int paramInt)
  {
    String str = (String)paramMap.get(paramString);
    if (str != null) {}
    try
    {
      int i = gq.a(paramDisplayMetrics, Integer.parseInt(str));
      paramInt = i;
      return paramInt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      gr.W("Could not parse " + paramString + " in a video GMSG: " + str);
    }
    return paramInt;
  }
  
  public void a(gu paramgu, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("action");
    if (str1 == null)
    {
      gr.W("Action missing from video GMSG.");
      return;
    }
    dp localdp = paramgu.dC();
    if (localdp == null)
    {
      gr.W("Could not get ad overlay for a video GMSG.");
      return;
    }
    boolean bool1 = "new".equalsIgnoreCase(str1);
    boolean bool2 = "position".equalsIgnoreCase(str1);
    if ((bool1) || (bool2))
    {
      DisplayMetrics localDisplayMetrics1 = paramgu.getContext().getResources().getDisplayMetrics();
      int i = a(localDisplayMetrics1, paramMap, "x", 0);
      int j = a(localDisplayMetrics1, paramMap, "y", 0);
      int k = a(localDisplayMetrics1, paramMap, "w", -1);
      int m = a(localDisplayMetrics1, paramMap, "h", -1);
      if ((bool1) && (localdp.ce() == null))
      {
        localdp.c(i, j, k, m);
        return;
      }
      localdp.b(i, j, k, m);
      return;
    }
    dt localdt = localdp.ce();
    if (localdt == null)
    {
      dt.a(paramgu, "no_video_view", null);
      return;
    }
    if ("click".equalsIgnoreCase(str1))
    {
      DisplayMetrics localDisplayMetrics2 = paramgu.getContext().getResources().getDisplayMetrics();
      int n = a(localDisplayMetrics2, paramMap, "x", 0);
      int i1 = a(localDisplayMetrics2, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, n, i1, 0);
      localdt.b(localMotionEvent);
      localMotionEvent.recycle();
      return;
    }
    if ("controls".equalsIgnoreCase(str1))
    {
      String str3 = (String)paramMap.get("enabled");
      if (str3 == null)
      {
        gr.W("Enabled parameter missing from controls video GMSG.");
        return;
      }
      localdt.s(Boolean.parseBoolean(str3));
      return;
    }
    if ("currentTime".equalsIgnoreCase(str1))
    {
      String str2 = (String)paramMap.get("time");
      if (str2 == null)
      {
        gr.W("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        localdt.seekTo((int)(1000.0F * Float.parseFloat(str2)));
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        gr.W("Could not parse time parameter from currentTime video GMSG: " + str2);
        return;
      }
    }
    if ("hide".equalsIgnoreCase(str1))
    {
      localdt.setVisibility(4);
      return;
    }
    if ("load".equalsIgnoreCase(str1))
    {
      localdt.cq();
      return;
    }
    if ("pause".equalsIgnoreCase(str1))
    {
      localdt.pause();
      return;
    }
    if ("play".equalsIgnoreCase(str1))
    {
      localdt.play();
      return;
    }
    if ("show".equalsIgnoreCase(str1))
    {
      localdt.setVisibility(0);
      return;
    }
    if ("src".equalsIgnoreCase(str1))
    {
      localdt.C((String)paramMap.get("src"));
      return;
    }
    gr.W("Unknown video action: " + str1);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cj
 * JD-Core Version:    0.7.0.1
 */