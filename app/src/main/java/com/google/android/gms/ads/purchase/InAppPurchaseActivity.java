package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.gr;

public final class InAppPurchaseActivity
  extends Activity
{
  public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
  public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
  private eo xz;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      if (this.xz != null) {
        this.xz.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.d("Could not forward onActivityResult to in-app purchase manager:", localRemoteException);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.xz = et.e(this);
    if (this.xz == null)
    {
      gr.W("Could not create in-app purchase manager.");
      finish();
      return;
    }
    try
    {
      this.xz.onCreate();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not forward onCreate to in-app purchase manager:", localRemoteException);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.xz != null) {
        this.xz.onDestroy();
      }
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.d("Could not forward onDestroy to in-app purchase manager:", localRemoteException);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.purchase.InAppPurchaseActivity
 * JD-Core Version:    0.7.0.1
 */