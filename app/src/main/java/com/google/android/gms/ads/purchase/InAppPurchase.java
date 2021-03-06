package com.google.android.gms.ads.purchase;

public abstract interface InAppPurchase
{
  public static final int RESOLUTION_CANCELED = 2;
  public static final int RESOLUTION_FAILURE = 0;
  public static final int RESOLUTION_INVALID_PRODUCT = 3;
  public static final int RESOLUTION_SUCCESS = 1;
  
  public abstract String getProductId();
  
  public abstract void recordPlayBillingResolution(int paramInt);
  
  public abstract void recordResolution(int paramInt);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.purchase.InAppPurchase
 * JD-Core Version:    0.7.0.1
 */