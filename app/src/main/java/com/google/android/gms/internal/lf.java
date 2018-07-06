package com.google.android.gms.internal;

import android.os.SystemClock;

public final class lf
  implements ld
{
  private static lf Of;
  
  public static ld jdMethod_if()
  {
    try
    {
      if (Of == null) {
        Of = new lf();
      }
      lf locallf = Of;
      return locallf;
    }
    finally {}
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lf
 * JD-Core Version:    0.7.0.1
 */