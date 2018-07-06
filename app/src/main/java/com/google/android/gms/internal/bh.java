package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.b;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

public final class bh
{
  private final cx oH = new cx();
  private final ax oI;
  private bd oJ;
  private String oK;
  private ViewGroup oL;
  private InAppPurchaseListener oM;
  private PlayStorePurchaseListener oN;
  private b oO;
  private AdListener ob;
  private AppEventListener os;
  private AdSize[] ot;
  private String ou;
  
  public bh(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, ax.bg());
  }
  
  public bh(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, ax.bg());
  }
  
  bh(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, ax paramax)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, paramax, null);
  }
  
  bh(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, ax paramax, bd parambd)
  {
    this.oL = paramViewGroup;
    this.oI = paramax;
    if (paramAttributeSet != null)
    {
      Context localContext = paramViewGroup.getContext();
      try
      {
        bb localbb = new bb(localContext, paramAttributeSet);
        this.ot = localbb.h(paramBoolean);
        this.ou = localbb.getAdUnitId();
        if (paramViewGroup.isInEditMode())
        {
          gq.a(paramViewGroup, new ay(localContext, this.ot[0]), "Ads by Google");
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        gq.a(paramViewGroup, new ay(localContext, AdSize.BANNER), localIllegalArgumentException.getMessage(), localIllegalArgumentException.getMessage());
        return;
      }
    }
    this.oJ = parambd;
  }
  
  private void bm()
  {
    try
    {
      d locald = this.oJ.ab();
      if (locald == null) {
        return;
      }
      this.oL.addView((View)e.f(locald));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  private void bn()
    throws RemoteException
  {
    if (((this.ot == null) || (this.ou == null)) && (this.oJ == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    Context localContext = this.oL.getContext();
    this.oJ = au.a(localContext, new ay(localContext, this.ot), this.ou, this.oH);
    if (this.ob != null) {
      this.oJ.a(new at(this.ob));
    }
    if (this.os != null) {
      this.oJ.a(new ba(this.os));
    }
    if (this.oM != null) {
      this.oJ.a(new es(this.oM));
    }
    if (this.oN != null) {
      this.oJ.a(new ew(this.oN), this.oK);
    }
    if (this.oO != null) {
      this.oJ.a(new bs(this.oO));
    }
    bm();
  }
  
  public void a(bg parambg)
  {
    try
    {
      if (this.oJ == null) {
        bn();
      }
      if (this.oJ.a(this.oI.a(this.oL.getContext(), parambg))) {
        this.oH.d(parambg.bj());
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to load ad.", localRemoteException);
    }
  }
  
  public void a(AdSize... paramVarArgs)
  {
    this.ot = paramVarArgs;
    try
    {
      if (this.oJ != null) {
        this.oJ.a(new ay(this.oL.getContext(), this.ot));
      }
      this.oL.requestLayout();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.d("Failed to set the ad size.", localRemoteException);
      }
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.oJ != null) {
        this.oJ.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.ob;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (this.oJ != null)
      {
        AdSize localAdSize = this.oJ.ac().bh();
        return localAdSize;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to get the current AdSize.", localRemoteException);
      if (this.ot != null) {
        return this.ot[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return this.ot;
  }
  
  public String getAdUnitId()
  {
    return this.ou;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.os;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.oM;
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      if (this.oJ != null)
      {
        String str = this.oJ.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public void pause()
  {
    try
    {
      if (this.oJ != null) {
        this.oJ.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to call pause.", localRemoteException);
    }
  }
  
  public void recordManualImpression()
  {
    try
    {
      if (this.oJ != null) {
        this.oJ.an();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to record impression.", localRemoteException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.oJ != null) {
        this.oJ.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to call resume.", localRemoteException);
    }
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.ob = paramAdListener;
      bd localbd;
      if (this.oJ != null)
      {
        localbd = this.oJ;
        if (paramAdListener == null) {
          break label40;
        }
      }
      label40:
      for (at localat = new at(paramAdListener);; localat = null)
      {
        localbd.a(localat);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to set the AdListener.", localRemoteException);
    }
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (this.ot != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    a(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.ou != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }
    this.ou = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.os = paramAppEventListener;
      bd localbd;
      if (this.oJ != null)
      {
        localbd = this.oJ;
        if (paramAppEventListener == null) {
          break label40;
        }
      }
      label40:
      for (ba localba = new ba(paramAppEventListener);; localba = null)
      {
        localbd.a(localba);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to set the AppEventListener.", localRemoteException);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (this.oN != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      this.oM = paramInAppPurchaseListener;
      bd localbd;
      if (this.oJ != null)
      {
        localbd = this.oJ;
        if (paramInAppPurchaseListener == null) {
          break label58;
        }
      }
      label58:
      for (es locales = new es(paramInAppPurchaseListener);; locales = null)
      {
        localbd.a(locales);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to set the InAppPurchaseListener.", localRemoteException);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (this.oM != null) {
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
    }
    try
    {
      this.oN = paramPlayStorePurchaseListener;
      this.oK = paramString;
      bd localbd;
      if (this.oJ != null)
      {
        localbd = this.oJ;
        if (paramPlayStorePurchaseListener == null) {
          break label66;
        }
      }
      label66:
      for (ew localew = new ew(paramPlayStorePurchaseListener);; localew = null)
      {
        localbd.a(localew, paramString);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Failed to set the play store purchase parameter.", localRemoteException);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bh
 * JD-Core Version:    0.7.0.1
 */