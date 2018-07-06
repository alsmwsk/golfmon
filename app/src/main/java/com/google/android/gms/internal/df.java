package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@ey
public final class df<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  implements MediationBannerListener, MediationInterstitialListener
{
  private final da qW;
  
  public df(da paramda)
  {
    this.qW = paramda;
  }
  
  public void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    gr.S("Adapter called onClick.");
    if (!gq.dB())
    {
      gr.W("onClick must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdClicked();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdClicked.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    gr.S("Adapter called onDismissScreen.");
    if (!gq.dB())
    {
      gr.W("onDismissScreen must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    gr.S("Adapter called onDismissScreen.");
    if (!gq.dB())
    {
      gr.W("onDismissScreen must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    gr.S("Adapter called onFailedToReceiveAd with error. " + paramErrorCode);
    if (!gq.dB())
    {
      gr.W("onFailedToReceiveAd must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdFailedToLoad(dg.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.qW.onAdFailedToLoad(dg.a(paramErrorCode));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    gr.S("Adapter called onFailedToReceiveAd with error " + paramErrorCode + ".");
    if (!gq.dB())
    {
      gr.W("onFailedToReceiveAd must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdFailedToLoad(dg.a(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      this.qW.onAdFailedToLoad(dg.a(paramErrorCode));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
  
  public void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    gr.S("Adapter called onLeaveApplication.");
    if (!gq.dB())
    {
      gr.W("onLeaveApplication must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    gr.S("Adapter called onLeaveApplication.");
    if (!gq.dB())
    {
      gr.W("onLeaveApplication must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    gr.S("Adapter called onPresentScreen.");
    if (!gq.dB())
    {
      gr.W("onPresentScreen must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    gr.S("Adapter called onPresentScreen.");
    if (!gq.dB())
    {
      gr.W("onPresentScreen must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    gr.S("Adapter called onReceivedAd.");
    if (!gq.dB())
    {
      gr.W("onReceivedAd must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
  
  public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    gr.S("Adapter called onReceivedAd.");
    if (!gq.dB())
    {
      gr.W("onReceivedAd must be called on the main UI thread.");
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          try
          {
            df.a(df.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            gr.d("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
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
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.df
 * JD-Core Version:    0.7.0.1
 */