package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

@ey
public final class ew
  extends er.a
{
  private final PlayStorePurchaseListener oN;
  
  public ew(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    this.oN = paramPlayStorePurchaseListener;
  }
  
  public void a(eq parameq)
  {
    this.oN.onInAppPurchaseFinished(new eu(parameq));
  }
  
  public boolean isValidPurchase(String paramString)
  {
    return this.oN.isValidPurchase(paramString);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ew
 * JD-Core Version:    0.7.0.1
 */