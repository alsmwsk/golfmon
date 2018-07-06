package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class g
  implements q
{
  private static Object xO = new Object();
  private static g ye;
  protected String ya;
  protected String yb;
  protected String yc;
  protected String yd;
  
  protected g() {}
  
  private g(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.yc = paramContext.getPackageName();
    this.yd = localPackageManager.getInstallerPackageName(this.yc);
    str1 = this.yc;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      str2 = null;
      if (localPackageInfo != null)
      {
        str1 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        str2 = localPackageInfo.versionName;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        ae.T("Error retrieving package info: appName set to " + str1);
        String str2 = null;
      }
    }
    this.ya = str1;
    this.yb = str2;
  }
  
  public static g dZ()
  {
    return ye;
  }
  
  public static void y(Context paramContext)
  {
    synchronized (xO)
    {
      if (ye == null) {
        ye = new g(paramContext);
      }
      return;
    }
  }
  
  public boolean ac(String paramString)
  {
    return ("&an".equals(paramString)) || ("&av".equals(paramString)) || ("&aid".equals(paramString)) || ("&aiid".equals(paramString));
  }
  
  public String getValue(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      if (paramString.equals("&an")) {
        return this.ya;
      }
      if (paramString.equals("&av")) {
        return this.yb;
      }
      if (paramString.equals("&aid")) {
        return this.yc;
      }
    } while (!paramString.equals("&aiid"));
    return this.yd;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.g
 * JD-Core Version:    0.7.0.1
 */