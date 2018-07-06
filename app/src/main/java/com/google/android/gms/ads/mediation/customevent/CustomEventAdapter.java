package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.gr;

public final class CustomEventAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter
{
  private View n;
  private CustomEventBanner xu;
  private CustomEventInterstitial xv;
  
  private static <T> T a(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      gr.W("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    return null;
  }
  
  private void a(View paramView)
  {
    this.n = paramView;
  }
  
  public View getBannerView()
  {
    return this.n;
  }
  
  public void onDestroy()
  {
    if (this.xu != null) {
      this.xu.onDestroy();
    }
    if (this.xv != null) {
      this.xv.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.xu != null) {
      this.xu.onPause();
    }
    if (this.xv != null) {
      this.xv.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.xu != null) {
      this.xu.onResume();
    }
    if (this.xv != null) {
      this.xv.onResume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.xu = ((CustomEventBanner)a(paramBundle1.getString("class_name")));
    if (this.xu == null)
    {
      paramMediationBannerListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (Bundle localBundle = null;; localBundle = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.xu.requestBannerAd(paramContext, new a(this, paramMediationBannerListener), paramBundle1.getString("parameter"), paramAdSize, paramMediationAdRequest, localBundle);
      return;
    }
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.xv = ((CustomEventInterstitial)a(paramBundle1.getString("class_name")));
    if (this.xv == null)
    {
      paramMediationInterstitialListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (Bundle localBundle = null;; localBundle = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.xv.requestInterstitialAd(paramContext, new b(this, paramMediationInterstitialListener), paramBundle1.getString("parameter"), paramMediationAdRequest, localBundle);
      return;
    }
  }
  
  public void showInterstitial()
  {
    this.xv.showInterstitial();
  }
  
  private static final class a
    implements CustomEventBannerListener
  {
    private final MediationBannerListener l;
    private final CustomEventAdapter xw;
    
    public a(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.xw = paramCustomEventAdapter;
      this.l = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      gr.S("Custom event adapter called onAdClicked.");
      this.l.onAdClicked(this.xw);
    }
    
    public void onAdClosed()
    {
      gr.S("Custom event adapter called onAdClosed.");
      this.l.onAdClosed(this.xw);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      gr.S("Custom event adapter called onAdFailedToLoad.");
      this.l.onAdFailedToLoad(this.xw, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      gr.S("Custom event adapter called onAdLeftApplication.");
      this.l.onAdLeftApplication(this.xw);
    }
    
    public void onAdLoaded(View paramView)
    {
      gr.S("Custom event adapter called onAdLoaded.");
      CustomEventAdapter.a(this.xw, paramView);
      this.l.onAdLoaded(this.xw);
    }
    
    public void onAdOpened()
    {
      gr.S("Custom event adapter called onAdOpened.");
      this.l.onAdOpened(this.xw);
    }
  }
  
  private class b
    implements CustomEventInterstitialListener
  {
    private final MediationInterstitialListener m;
    private final CustomEventAdapter xw;
    
    public b(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.xw = paramCustomEventAdapter;
      this.m = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      gr.S("Custom event adapter called onAdClicked.");
      this.m.onAdClicked(this.xw);
    }
    
    public void onAdClosed()
    {
      gr.S("Custom event adapter called onAdClosed.");
      this.m.onAdClosed(this.xw);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      gr.S("Custom event adapter called onFailedToReceiveAd.");
      this.m.onAdFailedToLoad(this.xw, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      gr.S("Custom event adapter called onAdLeftApplication.");
      this.m.onAdLeftApplication(this.xw);
    }
    
    public void onAdLoaded()
    {
      gr.S("Custom event adapter called onReceivedAd.");
      this.m.onAdLoaded(CustomEventAdapter.this);
    }
    
    public void onAdOpened()
    {
      gr.S("Custom event adapter called onAdOpened.");
      this.m.onAdOpened(this.xw);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
 * JD-Core Version:    0.7.0.1
 */