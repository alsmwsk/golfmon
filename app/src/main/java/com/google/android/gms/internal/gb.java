package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;

@ey
public class gb
{
  private final Object mH = new Object();
  private final String vZ;
  private int wm = 0;
  private long wn = -1L;
  private long wo = -1L;
  private int wp = 0;
  private int wq = -1;
  
  public gb(String paramString)
  {
    this.vZ = paramString;
  }
  
  public static boolean m(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0)
    {
      gr.U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (i == paramContext.getPackageManager().getActivityInfo(localComponentName, 0).theme) {
        return true;
      }
      gr.U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      gr.W("Fail to fetch AdActivity theme");
      gr.U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    return false;
  }
  
  public Bundle b(Context paramContext, String paramString)
  {
    synchronized (this.mH)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.vZ);
      localBundle.putLong("basets", this.wo);
      localBundle.putLong("currts", this.wn);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.wq);
      localBundle.putInt("pclick", this.wm);
      localBundle.putInt("pimp", this.wp);
      localBundle.putBoolean("support_transparent_background", m(paramContext));
      return localBundle;
    }
  }
  
  public void b(av paramav, long paramLong)
  {
    synchronized (this.mH)
    {
      if (this.wo == -1L)
      {
        this.wo = paramLong;
        this.wn = this.wo;
        if ((paramav.extras == null) || (paramav.extras.getInt("gw", 2) != 1)) {}
      }
      else
      {
        this.wn = paramLong;
      }
    }
    this.wq = (1 + this.wq);
  }
  
  public void cW()
  {
    synchronized (this.mH)
    {
      this.wp = (1 + this.wp);
      return;
    }
  }
  
  public void cX()
  {
    synchronized (this.mH)
    {
      this.wm = (1 + this.wm);
      return;
    }
  }
  
  public long dq()
  {
    return this.wo;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gb
 * JD-Core Version:    0.7.0.1
 */