package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

@ey
public final class es
  extends en.a
{
  private final InAppPurchaseListener oM;
  
  public es(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.oM = paramInAppPurchaseListener;
  }
  
  public void a(em paramem)
  {
    this.oM.onInAppPurchaseRequested(new ev(paramem));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.es
 * JD-Core Version:    0.7.0.1
 */