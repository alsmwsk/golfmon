package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

@ey
public final class eg
  extends eq.a
  implements ServiceConnection
{
  private Context mContext;
  private eb sF;
  private String sM;
  private ef sQ;
  private boolean sW = false;
  private int sX;
  private Intent sY;
  
  public eg(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, ef paramef)
  {
    this.sM = paramString;
    this.sX = paramInt;
    this.sY = paramIntent;
    this.sW = paramBoolean;
    this.mContext = paramContext;
    this.sQ = paramef;
  }
  
  public void finishPurchase()
  {
    int i = ei.d(this.sY);
    if ((this.sX != -1) || (i != 0)) {
      return;
    }
    this.sF = new eb(this.mContext);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    this.mContext.bindService(localIntent, this, 1);
  }
  
  public String getProductId()
  {
    return this.sM;
  }
  
  public Intent getPurchaseData()
  {
    return this.sY;
  }
  
  public int getResultCode()
  {
    return this.sX;
  }
  
  public boolean isVerified()
  {
    return this.sW;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    gr.U("In-app billing service connected.");
    this.sF.t(paramIBinder);
    String str = ei.E(ei.e(this.sY));
    if (str == null) {
      return;
    }
    if (this.sF.c(this.mContext.getPackageName(), str) == 0) {
      eh.j(this.mContext).a(this.sQ);
    }
    this.mContext.unbindService(this);
    this.sF.destroy();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    gr.U("In-app billing service disconnected.");
    this.sF.destroy();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.eg
 * JD-Core Version:    0.7.0.1
 */