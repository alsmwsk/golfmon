package com.google.android.gms.games.internal;

import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.lg;

public abstract class GamesDowngradeableSafeParcel
  extends ji
{
  protected static boolean c(Integer paramInteger)
  {
    if (paramInteger == null) {
      return false;
    }
    return lg.aV(paramInteger.intValue());
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.GamesDowngradeableSafeParcel
 * JD-Core Version:    0.7.0.1
 */