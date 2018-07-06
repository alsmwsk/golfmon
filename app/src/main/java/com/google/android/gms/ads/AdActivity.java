package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.dw;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.gr;

public final class AdActivity
  extends Activity
{
  public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
  public static final String SIMPLE_CLASS_NAME = "AdActivity";
  private dx lf;
  
  private void X()
  {
    if (this.lf != null) {}
    try
    {
      this.lf.X();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not forward setContentViewSet to ad overlay:", localRemoteException);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lf = dw.b(this);
    if (this.lf == null)
    {
      gr.W("Could not create ad overlay.");
      finish();
      return;
    }
    try
    {
      this.lf.onCreate(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not forward onCreate to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.lf != null) {
        this.lf.onDestroy();
      }
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.d("Could not forward onDestroy to ad overlay:", localRemoteException);
      }
    }
  }
  
  protected void onPause()
  {
    try
    {
      if (this.lf != null) {
        this.lf.onPause();
      }
      super.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.d("Could not forward onPause to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    try
    {
      if (this.lf != null) {
        this.lf.onRestart();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not forward onRestart to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      if (this.lf != null) {
        this.lf.onResume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not forward onResume to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      if (this.lf != null) {
        this.lf.onSaveInstanceState(paramBundle);
      }
      super.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.d("Could not forward onSaveInstanceState to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    try
    {
      if (this.lf != null) {
        this.lf.onStart();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not forward onStart to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onStop()
  {
    try
    {
      if (this.lf != null) {
        this.lf.onStop();
      }
      super.onStop();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.d("Could not forward onStop to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    X();
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    X();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    X();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdActivity
 * JD-Core Version:    0.7.0.1
 */