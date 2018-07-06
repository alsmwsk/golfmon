package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

@ey
public final class dd
  implements MediationBannerListener, MediationInterstitialListener
{
  private final da qW;
  
  public dd(da paramda)
  {
    this.qW = paramda;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    jx.aU("onAdClicked must be called on the main UI thread.");
    gr.S("Adapter called onAdClicked.");
    try
    {
      this.qW.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdClicked.", localRemoteException);
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    jx.aU("onAdClicked must be called on the main UI thread.");
    gr.S("Adapter called onAdClicked.");
    try
    {
      this.qW.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdClicked.", localRemoteException);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    jx.aU("onAdClosed must be called on the main UI thread.");
    gr.S("Adapter called onAdClosed.");
    try
    {
      this.qW.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdClosed.", localRemoteException);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    jx.aU("onAdClosed must be called on the main UI thread.");
    gr.S("Adapter called onAdClosed.");
    try
    {
      this.qW.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdClosed.", localRemoteException);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    jx.aU("onAdFailedToLoad must be called on the main UI thread.");
    gr.S("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.qW.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    jx.aU("onAdFailedToLoad must be called on the main UI thread.");
    gr.S("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.qW.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    jx.aU("onAdLeftApplication must be called on the main UI thread.");
    gr.S("Adapter called onAdLeftApplication.");
    try
    {
      this.qW.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdLeftApplication.", localRemoteException);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    jx.aU("onAdLeftApplication must be called on the main UI thread.");
    gr.S("Adapter called onAdLeftApplication.");
    try
    {
      this.qW.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdLeftApplication.", localRemoteException);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    jx.aU("onAdLoaded must be called on the main UI thread.");
    gr.S("Adapter called onAdLoaded.");
    try
    {
      this.qW.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdLoaded.", localRemoteException);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    jx.aU("onAdLoaded must be called on the main UI thread.");
    gr.S("Adapter called onAdLoaded.");
    try
    {
      this.qW.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdLoaded.", localRemoteException);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    jx.aU("onAdOpened must be called on the main UI thread.");
    gr.S("Adapter called onAdOpened.");
    try
    {
      this.qW.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdOpened.", localRemoteException);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    jx.aU("onAdOpened must be called on the main UI thread.");
    gr.S("Adapter called onAdOpened.");
    try
    {
      this.qW.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdOpened.", localRemoteException);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dd
 * JD-Core Version:    0.7.0.1
 */