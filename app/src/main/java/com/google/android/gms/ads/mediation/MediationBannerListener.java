package com.google.android.gms.ads.mediation;

public abstract interface MediationBannerListener
{
  public abstract void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter);
  
  public abstract void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter);
  
  public abstract void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt);
  
  public abstract void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter);
  
  public abstract void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter);
  
  public abstract void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationBannerListener
 * JD-Core Version:    0.7.0.1
 */