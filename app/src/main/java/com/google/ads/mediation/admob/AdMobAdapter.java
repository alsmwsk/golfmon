package com.google.ads.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.gq;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public final class AdMobAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter
{
  private AdView i;
  private InterstitialAd j;
  
  static AdRequest a(Context paramContext, MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    Date localDate = paramMediationAdRequest.getBirthday();
    if (localDate != null) {
      localBuilder.setBirthday(localDate);
    }
    int k = paramMediationAdRequest.getGender();
    if (k != 0) {
      localBuilder.setGender(k);
    }
    Set localSet = paramMediationAdRequest.getKeywords();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext()) {
        localBuilder.addKeyword((String)localIterator.next());
      }
    }
    Location localLocation = paramMediationAdRequest.getLocation();
    if (localLocation != null) {
      localBuilder.setLocation(localLocation);
    }
    if (paramMediationAdRequest.isTesting()) {
      localBuilder.addTestDevice(gq.v(paramContext));
    }
    boolean bool;
    if (paramBundle2.getInt("tagForChildDirectedTreatment") != -1)
    {
      if (paramBundle2.getInt("tagForChildDirectedTreatment") == 1)
      {
        bool = true;
        localBuilder.tagForChildDirectedTreatment(bool);
      }
    }
    else {
      if (paramBundle1 == null) {
        break label248;
      }
    }
    for (;;)
    {
      paramBundle1.putInt("gw", 1);
      paramBundle1.putString("mad_hac", paramBundle2.getString("mad_hac"));
      if (!TextUtils.isEmpty(paramBundle2.getString("adJson"))) {
        paramBundle1.putString("_ad", paramBundle2.getString("adJson"));
      }
      paramBundle1.putBoolean("_noRefresh", true);
      localBuilder.addNetworkExtrasBundle(AdMobAdapter.class, paramBundle1);
      return localBuilder.build();
      bool = false;
      break;
      label248:
      paramBundle1 = new Bundle();
    }
  }
  
  public View getBannerView()
  {
    return this.i;
  }
  
  public void onDestroy()
  {
    if (this.i != null)
    {
      this.i.destroy();
      this.i = null;
    }
    if (this.j != null) {
      this.j = null;
    }
  }
  
  public void onPause()
  {
    if (this.i != null) {
      this.i.pause();
    }
  }
  
  public void onResume()
  {
    if (this.i != null) {
      this.i.resume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.i = new AdView(paramContext);
    this.i.setAdSize(new AdSize(paramAdSize.getWidth(), paramAdSize.getHeight()));
    this.i.setAdUnitId(paramBundle1.getString("pubid"));
    this.i.setAdListener(new a(this, paramMediationBannerListener));
    this.i.loadAd(a(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.j = new InterstitialAd(paramContext);
    this.j.setAdUnitId(paramBundle1.getString("pubid"));
    this.j.setAdListener(new b(this, paramMediationInterstitialListener));
    this.j.loadAd(a(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void showInterstitial()
  {
    this.j.show();
  }
  
  private static final class a
    extends AdListener
  {
    private final AdMobAdapter k;
    private final MediationBannerListener l;
    
    public a(AdMobAdapter paramAdMobAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.k = paramAdMobAdapter;
      this.l = paramMediationBannerListener;
    }
    
    public void onAdClosed()
    {
      this.l.onAdClosed(this.k);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.l.onAdFailedToLoad(this.k, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      this.l.onAdLeftApplication(this.k);
    }
    
    public void onAdLoaded()
    {
      this.l.onAdLoaded(this.k);
    }
    
    public void onAdOpened()
    {
      this.l.onAdClicked(this.k);
      this.l.onAdOpened(this.k);
    }
  }
  
  private static final class b
    extends AdListener
  {
    private final AdMobAdapter k;
    private final MediationInterstitialListener m;
    
    public b(AdMobAdapter paramAdMobAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.k = paramAdMobAdapter;
      this.m = paramMediationInterstitialListener;
    }
    
    public void onAdClosed()
    {
      this.m.onAdClosed(this.k);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.m.onAdFailedToLoad(this.k, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      this.m.onAdLeftApplication(this.k);
    }
    
    public void onAdLoaded()
    {
      this.m.onAdLoaded(this.k);
    }
    
    public void onAdOpened()
    {
      this.m.onAdOpened(this.k);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.admob.AdMobAdapter
 * JD-Core Version:    0.7.0.1
 */