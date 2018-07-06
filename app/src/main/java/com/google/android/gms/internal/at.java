package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

@ey
public final class at
  extends bc.a
{
  private final AdListener ob;
  
  public at(AdListener paramAdListener)
  {
    this.ob = paramAdListener;
  }
  
  public void onAdClosed()
  {
    this.ob.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    this.ob.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    this.ob.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    this.ob.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    this.ob.onAdOpened();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.at
 * JD-Core Version:    0.7.0.1
 */