package com.google.android.gms.ads.mediation;

public abstract interface MediationInterstitialListener
{
  public abstract void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter);
  
  public abstract void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter);
  
  public abstract void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt);
  
  public abstract void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter);
  
  public abstract void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter);
  
  public abstract void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationInterstitialListener
 * JD-Core Version:    0.7.0.1
 */