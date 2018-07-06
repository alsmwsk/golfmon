package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

@ey
public final class fv
{
  public final boolean vA;
  public final boolean vB;
  public final int vC;
  public final int vg;
  public final boolean vh;
  public final boolean vi;
  public final String vj;
  public final String vk;
  public final boolean vl;
  public final boolean vm;
  public final boolean vn;
  public final String vo;
  public final String vp;
  public final int vq;
  public final int vr;
  public final int vs;
  public final int vt;
  public final int vu;
  public final int vv;
  public final float vw;
  public final int vx;
  public final int vy;
  public final double vz;
  
  public fv(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    Locale localLocale = Locale.getDefault();
    PackageManager localPackageManager = paramContext.getPackageManager();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    this.vg = localAudioManager.getMode();
    boolean bool2;
    boolean bool3;
    if (a(localPackageManager, "geo:0,0?q=donuts") != null)
    {
      bool2 = bool1;
      this.vh = bool2;
      if (a(localPackageManager, "http://www.google.com") == null) {
        break label373;
      }
      bool3 = bool1;
      label114:
      this.vi = bool3;
      this.vj = localTelephonyManager.getNetworkOperator();
      this.vk = localLocale.getCountry();
      this.vl = gq.dA();
      this.vm = localAudioManager.isMusicActive();
      this.vn = localAudioManager.isSpeakerphoneOn();
      this.vo = localLocale.getLanguage();
      this.vp = a(localPackageManager);
      this.vq = localAudioManager.getStreamVolume(3);
      this.vr = a(paramContext, localConnectivityManager, localPackageManager);
      this.vs = localTelephonyManager.getNetworkType();
      this.vt = localTelephonyManager.getPhoneType();
      this.vu = localAudioManager.getRingerMode();
      this.vv = localAudioManager.getStreamVolume(2);
      this.vw = localDisplayMetrics.density;
      this.vx = localDisplayMetrics.widthPixels;
      this.vy = localDisplayMetrics.heightPixels;
      if (localIntent == null) {
        break label384;
      }
      int i = localIntent.getIntExtra("status", -1);
      int j = localIntent.getIntExtra("level", -1);
      int k = localIntent.getIntExtra("scale", -1);
      this.vz = (j / k);
      if ((i != 2) && (i != 5)) {
        break label379;
      }
      label321:
      this.vA = bool1;
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.vB = localConnectivityManager.isActiveNetworkMetered();
        if (localConnectivityManager.getActiveNetworkInfo() != null)
        {
          this.vC = localConnectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
          return;
          bool2 = false;
          break;
          label373:
          bool3 = false;
          break label114;
          label379:
          bool1 = false;
          break label321;
          label384:
          this.vz = -1.0D;
          this.vA = false;
          continue;
        }
        this.vC = -1;
        return;
      }
    }
    this.vB = false;
    this.vC = -1;
  }
  
  private static int a(Context paramContext, ConnectivityManager paramConnectivityManager, PackageManager paramPackageManager)
  {
    int i = -2;
    if (gi.a(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
    {
      NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo != null) {
        i = localNetworkInfo.getType();
      }
    }
    else
    {
      return i;
    }
    return -1;
  }
  
  private static ResolveInfo a(PackageManager paramPackageManager, String paramString)
  {
    return paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
  }
  
  private static String a(PackageManager paramPackageManager)
  {
    ResolveInfo localResolveInfo = a(paramPackageManager, "market://details?id=com.google.android.gms.ads");
    if (localResolveInfo == null) {}
    for (;;)
    {
      return null;
      ActivityInfo localActivityInfo = localResolveInfo.activityInfo;
      if (localActivityInfo != null) {
        try
        {
          PackageInfo localPackageInfo = paramPackageManager.getPackageInfo(localActivityInfo.packageName, 0);
          if (localPackageInfo != null)
          {
            String str = localPackageInfo.versionCode + "." + localActivityInfo.packageName;
            return str;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      }
    }
    return null;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fv
 * JD-Core Version:    0.7.0.1
 */