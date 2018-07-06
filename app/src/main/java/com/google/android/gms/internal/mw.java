package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class mw
  extends jl<my>
{
  private final String DZ;
  private a afJ;
  private final int mTheme;
  private Activity nB;
  
  public mw(Activity paramActivity, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, int paramInt)
  {
    super(paramActivity, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.DZ = paramString;
    this.nB = paramActivity;
    this.mTheme = paramInt;
  }
  
  public void a(UserAddressRequest paramUserAddressRequest, int paramInt)
  {
    ne();
    this.afJ = new a(paramInt, this.nB);
    try
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
      if (!TextUtils.isEmpty(this.DZ)) {
        localBundle1.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.DZ, "com.google"));
      }
      localBundle1.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
      nd().a(this.afJ, paramUserAddressRequest, localBundle1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("AddressClientImpl", "Exception requesting user address", localRemoteException);
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
      this.afJ.g(1, localBundle2);
    }
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    paramjt.d(parame, 6587000, getContext().getPackageName());
  }
  
  protected my aI(IBinder paramIBinder)
  {
    return my.a.aK(paramIBinder);
  }
  
  protected String bK()
  {
    return "com.google.android.gms.identity.service.BIND";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.identity.intents.internal.IAddressService";
  }
  
  public void disconnect()
  {
    super.disconnect();
    if (this.afJ != null)
    {
      a.a(this.afJ, null);
      this.afJ = null;
    }
  }
  
  protected my nd()
    throws DeadObjectException
  {
    return (my)super.hw();
  }
  
  protected void ne()
  {
    super.dS();
  }
  
  public static final class a
    extends mx.a
  {
    private final int My;
    private Activity nB;
    
    public a(int paramInt, Activity paramActivity)
    {
      this.My = paramInt;
      this.nB = paramActivity;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.nB = paramActivity;
    }
    
    public void g(int paramInt, Bundle paramBundle)
    {
      PendingIntent localPendingIntent1;
      if (paramInt == 1)
      {
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        localPendingIntent1 = this.nB.createPendingResult(this.My, localIntent, 1073741824);
        if (localPendingIntent1 != null) {}
      }
      for (;;)
      {
        return;
        try
        {
          localPendingIntent1.send(1);
          return;
        }
        catch (PendingIntent.CanceledException localCanceledException1)
        {
          Log.w("AddressClientImpl", "Exception settng pending result", localCanceledException1);
          return;
        }
        PendingIntent localPendingIntent2 = null;
        if (paramBundle != null) {
          localPendingIntent2 = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
        }
        ConnectionResult localConnectionResult = new ConnectionResult(paramInt, localPendingIntent2);
        if (localConnectionResult.hasResolution()) {
          try
          {
            localConnectionResult.startResolutionForResult(this.nB, this.My);
            return;
          }
          catch (IntentSender.SendIntentException localSendIntentException)
          {
            Log.w("AddressClientImpl", "Exception starting pending intent", localSendIntentException);
            return;
          }
        }
        try
        {
          PendingIntent localPendingIntent3 = this.nB.createPendingResult(this.My, new Intent(), 1073741824);
          if (localPendingIntent3 != null)
          {
            localPendingIntent3.send(1);
            return;
          }
        }
        catch (PendingIntent.CanceledException localCanceledException2)
        {
          Log.w("AddressClientImpl", "Exception setting pending result", localCanceledException2);
        }
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mw
 * JD-Core Version:    0.7.0.1
 */