package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@ey
public final class ck
{
  public static void a(Context paramContext, b paramb)
  {
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0)
    {
      paramb.a(bn.by());
      return;
    }
    new a(paramContext, paramb);
  }
  
  public static final class a
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private final Object mH = new Object();
    private final ck.b qe;
    private final cl qf;
    
    public a(Context paramContext, ck.b paramb)
    {
      this(paramContext, paramb, false);
    }
    
    a(Context paramContext, ck.b paramb, boolean paramBoolean)
    {
      this.qe = paramb;
      this.qf = new cl(paramContext, this, this, 6587000);
      if (!paramBoolean) {
        this.qf.connect();
      }
    }
    
    public void onConnected(Bundle paramBundle)
    {
      Bundle localBundle1 = bn.by();
      Object localObject1 = this.mH;
      for (;;)
      {
        try
        {
          cm localcm = this.qf.bM();
          if (localcm == null) {
            break label208;
          }
          Bundle localBundle3 = localcm.bN();
          localBundle2 = localBundle3;
          localBundle2 = localBundle1;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localIllegalStateException = localIllegalStateException;
          gr.d("Error when get Gservice values", localIllegalStateException);
          if ((this.qf.isConnected()) || (this.qf.isConnecting()))
          {
            this.qf.disconnect();
            localBundle2 = localBundle1;
            continue;
          }
        }
        catch (RemoteException localRemoteException)
        {
          gr.d("Error when get Gservice values", localRemoteException);
          if ((this.qf.isConnected()) || (this.qf.isConnecting()))
          {
            this.qf.disconnect();
            localBundle2 = localBundle1;
            continue;
          }
        }
        finally
        {
          if ((this.qf.isConnected()) || (this.qf.isConnecting())) {
            this.qf.disconnect();
          }
        }
        continue;
        label208:
        Bundle localBundle2 = localBundle1;
      }
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.qe.a(bn.by());
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      gr.S("Disconnected from remote ad request service.");
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Bundle paramBundle);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ck
 * JD-Core Version:    0.7.0.1
 */