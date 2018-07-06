package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.bi;

public final class PublisherInterstitialAd
{
  private final bi lm = new bi(paramContext, this);
  
  public PublisherInterstitialAd(Context paramContext) {}
  
  public AdListener getAdListener()
  {
    return this.lm.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return this.lm.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.lm.getAppEventListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return this.lm.getMediationAdapterClassName();
  }
  
  public boolean isLoaded()
  {
    return this.lm.isLoaded();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.lm.a(paramPublisherAdRequest.Y());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.lm.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.lm.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.lm.setAppEventListener(paramAppEventListener);
  }
  
  public void show()
  {
    this.lm.show();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherInterstitialAd
 * JD-Core Version:    0.7.0.1
 */