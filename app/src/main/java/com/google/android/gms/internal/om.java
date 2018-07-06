package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class om
  extends jl<ok>
{
  public om(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramjt.a(parame, 6587000, getContext().getPackageName(), localBundle);
  }
  
  public ok bH(IBinder paramIBinder)
  {
    return ok.a.bG(paramIBinder);
  }
  
  protected String bK()
  {
    return "com.google.android.gms.panorama.service.START";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.panorama.internal.IPanoramaService";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.om
 * JD-Core Version:    0.7.0.1
 */