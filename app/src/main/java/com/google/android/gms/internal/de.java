package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@ey
public final class de<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends cz.a
{
  private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> qX;
  private final NETWORK_EXTRAS qY;
  
  public de(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    this.qX = paramMediationAdapter;
    this.qY = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS b(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    HashMap localHashMap;
    if (paramString1 != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        localHashMap = new HashMap(localJSONObject.length());
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localJSONObject.getString(str));
          continue;
          localHashMap = new HashMap(0);
        }
      }
      catch (Throwable localThrowable)
      {
        gr.d("Could not get MediationServerParameters.", localThrowable);
        throw new RemoteException();
      }
    }
    Class localClass = this.qX.getServerParametersType();
    MediationServerParameters localMediationServerParameters = null;
    if (localClass != null)
    {
      localMediationServerParameters = (MediationServerParameters)localClass.newInstance();
      localMediationServerParameters.load(localHashMap);
    }
    return localMediationServerParameters;
  }
  
  public void a(d paramd, av paramav, String paramString, da paramda)
    throws RemoteException
  {
    a(paramd, paramav, paramString, null, paramda);
  }
  
  public void a(d paramd, av paramav, String paramString1, String paramString2, da paramda)
    throws RemoteException
  {
    if (!(this.qX instanceof MediationInterstitialAdapter))
    {
      gr.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
      throw new RemoteException();
    }
    gr.S("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.qX).requestInterstitialAd(new df(paramda), (Activity)e.f(paramd), b(paramString1, paramav.oh, paramString2), dg.d(paramav), this.qY);
      return;
    }
    catch (Throwable localThrowable)
    {
      gr.d("Could not request interstitial ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void a(d paramd, ay paramay, av paramav, String paramString, da paramda)
    throws RemoteException
  {
    a(paramd, paramay, paramav, paramString, null, paramda);
  }
  
  public void a(d paramd, ay paramay, av paramav, String paramString1, String paramString2, da paramda)
    throws RemoteException
  {
    if (!(this.qX instanceof MediationBannerAdapter))
    {
      gr.W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
      throw new RemoteException();
    }
    gr.S("Requesting banner ad from adapter.");
    try
    {
      ((MediationBannerAdapter)this.qX).requestBannerAd(new df(paramda), (Activity)e.f(paramd), b(paramString1, paramav.oh, paramString2), dg.b(paramay), dg.d(paramav), this.qY);
      return;
    }
    catch (Throwable localThrowable)
    {
      gr.d("Could not request banner ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.qX.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      gr.d("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public d getView()
    throws RemoteException
  {
    if (!(this.qX instanceof MediationBannerAdapter))
    {
      gr.W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      d locald = e.k(((MediationBannerAdapter)this.qX).getBannerView());
      return locald;
    }
    catch (Throwable localThrowable)
    {
      gr.d("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void resume()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.qX instanceof MediationInterstitialAdapter))
    {
      gr.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
      throw new RemoteException();
    }
    gr.S("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.qX).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      gr.d("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.de
 * JD-Core Version:    0.7.0.1
 */