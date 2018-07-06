package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class kg
  extends jl<ki>
{
  public kg(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramVarArgs);
  }
  
  protected ki T(IBinder paramIBinder)
  {
    return ki.a.V(paramIBinder);
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    paramjt.j(parame, 6587000, getContext().getPackageName());
  }
  
  public String bK()
  {
    return "com.google.android.gms.common.service.START";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kg
 * JD-Core Version:    0.7.0.1
 */