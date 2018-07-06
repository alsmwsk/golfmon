package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class ai
  implements q
{
  private static ai Cc;
  private static Object xO = new Object();
  private final Context mContext;
  
  protected ai(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static ai fl()
  {
    synchronized (xO)
    {
      ai localai = Cc;
      return localai;
    }
  }
  
  public static void y(Context paramContext)
  {
    synchronized (xO)
    {
      if (Cc == null) {
        Cc = new ai(paramContext);
      }
      return;
    }
  }
  
  public boolean ac(String paramString)
  {
    return "&sr".equals(paramString);
  }
  
  protected String fm()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }
  
  public String getValue(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.equals("&sr")) {
      return null;
    }
    return fm();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ai
 * JD-Core Version:    0.7.0.1
 */