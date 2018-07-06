package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@ey
public class cl
  extends jl<cm>
{
  final int qg;
  
  public cl(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt)
  {
    super(paramContext, paramContext.getMainLooper(), paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.qg = paramInt;
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramjt.g(parame, this.qg, getContext().getPackageName(), localBundle);
  }
  
  protected String bK()
  {
    return "com.google.android.gms.ads.gservice.START";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.ads.internal.gservice.IGservicesValueService";
  }
  
  public cm bM()
    throws DeadObjectException
  {
    return (cm)super.hw();
  }
  
  protected cm k(IBinder paramIBinder)
  {
    return cm.a.m(paramIBinder);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cl
 * JD-Core Version:    0.7.0.1
 */