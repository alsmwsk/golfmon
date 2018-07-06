package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras
  implements NetworkExtras
{
  private final Bundle mExtras;
  
  public AdMobExtras(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (Bundle localBundle = new Bundle(paramBundle);; localBundle = null)
    {
      this.mExtras = localBundle;
      return;
    }
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.admob.AdMobExtras
 * JD-Core Version:    0.7.0.1
 */