package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class nc
  extends jl<ni>
{
  protected final np<ni> Ee = new np()
  {
    public void dS()
    {
      nc.a(nc.this);
    }
    
    public ni nh()
      throws DeadObjectException
    {
      return (ni)nc.this.hw();
    }
  };
  private final String agD;
  
  public nc(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.agD = paramString;
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.agD);
    paramjt.e(parame, 6587000, getContext().getPackageName(), localBundle);
  }
  
  protected ni aM(IBinder paramIBinder)
  {
    return ni.a.aO(paramIBinder);
  }
  
  protected String bK()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nc
 * JD-Core Version:    0.7.0.1
 */