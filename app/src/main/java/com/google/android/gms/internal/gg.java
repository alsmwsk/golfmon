package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@ey
public final class gg
{
  public static void a(Context paramContext, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = n(paramContext).edit();
    localEditor.putBoolean("use_https", paramBoolean);
    localEditor.commit();
  }
  
  private static SharedPreferences n(Context paramContext)
  {
    return paramContext.getSharedPreferences("admob", 0);
  }
  
  public static boolean o(Context paramContext)
  {
    return n(paramContext).getBoolean("use_https", true);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gg
 * JD-Core Version:    0.7.0.1
 */