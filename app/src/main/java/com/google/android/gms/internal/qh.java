package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public class qh
  extends jl<qc>
{
  private final String DZ;
  private final int avV;
  private final int mTheme;
  private final Activity nB;
  
  public qh(Activity paramActivity, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt1, String paramString, int paramInt2)
  {
    super(paramActivity, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.nB = paramActivity;
    this.avV = paramInt1;
    this.DZ = paramString;
    this.mTheme = paramInt2;
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", paramInt1);
    localBundle.putString("androidPackageName", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(paramString2, "com.google"));
    }
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", paramInt2);
    return localBundle;
  }
  
  private Bundle rf()
  {
    return a(this.avV, this.nB.getPackageName(), this.DZ, this.mTheme);
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    paramjt.k(parame, 6587000, getContext().getPackageName());
  }
  
  public void a(FullWalletRequest paramFullWalletRequest, int paramInt)
  {
    b localb = new b(paramInt);
    Bundle localBundle = rf();
    try
    {
      ((qc)hw()).a(paramFullWalletRequest, localBundle, localb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException getting full wallet", localRemoteException);
      localb.a(8, null, Bundle.EMPTY);
    }
  }
  
  public void a(MaskedWalletRequest paramMaskedWalletRequest, int paramInt)
  {
    Bundle localBundle = rf();
    b localb = new b(paramInt);
    try
    {
      ((qc)hw()).a(paramMaskedWalletRequest, localBundle, localb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException getting masked wallet", localRemoteException);
      localb.a(8, null, Bundle.EMPTY);
    }
  }
  
  public void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    Bundle localBundle = rf();
    try
    {
      ((qc)hw()).a(paramNotifyTransactionStatusRequest, localBundle);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  protected String bK()
  {
    return "com.google.android.gms.wallet.service.BIND";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.wallet.internal.IOwService";
  }
  
  protected qc bV(IBinder paramIBinder)
  {
    return qc.a.bR(paramIBinder);
  }
  
  public void d(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = rf();
    b localb = new b(paramInt);
    try
    {
      ((qc)hw()).a(paramString1, paramString2, localBundle, localb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException changing masked wallet", localRemoteException);
      localb.a(8, null, Bundle.EMPTY);
    }
  }
  
  public void gk(int paramInt)
  {
    Bundle localBundle = rf();
    b localb = new b(paramInt);
    try
    {
      ((qc)hw()).a(localBundle, localb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", localRemoteException);
      localb.a(8, false, Bundle.EMPTY);
    }
  }
  
  private static class a
    extends qf.a
  {
    public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle) {}
    
    public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle) {}
    
    public void a(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
    
    public void a(Status paramStatus, py parampy, Bundle paramBundle) {}
    
    public void i(int paramInt, Bundle paramBundle) {}
  }
  
  final class b
    extends qh.a
  {
    private final int My;
    
    public b(int paramInt)
    {
      super();
      this.My = paramInt;
    }
    
    public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
    {
      PendingIntent localPendingIntent1 = null;
      if (paramBundle != null) {
        localPendingIntent1 = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      ConnectionResult localConnectionResult = new ConnectionResult(paramInt, localPendingIntent1);
      if (localConnectionResult.hasResolution()) {
        try
        {
          localConnectionResult.startResolutionForResult(qh.b(qh.this), this.My);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", localSendIntentException);
          return;
        }
      }
      Intent localIntent = new Intent();
      int i;
      PendingIntent localPendingIntent2;
      if (localConnectionResult.isSuccess())
      {
        i = -1;
        localIntent.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", paramFullWallet);
        localPendingIntent2 = qh.b(qh.this).createPendingResult(this.My, localIntent, 1073741824);
        if (localPendingIntent2 == null) {
          Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
        }
      }
      else
      {
        if (paramInt == 408) {}
        for (i = 0;; i = 1)
        {
          localIntent.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
          break;
        }
      }
      try
      {
        localPendingIntent2.send(i);
        return;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", localCanceledException);
      }
    }
    
    public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
    {
      PendingIntent localPendingIntent1 = null;
      if (paramBundle != null) {
        localPendingIntent1 = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      ConnectionResult localConnectionResult = new ConnectionResult(paramInt, localPendingIntent1);
      if (localConnectionResult.hasResolution()) {
        try
        {
          localConnectionResult.startResolutionForResult(qh.b(qh.this), this.My);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", localSendIntentException);
          return;
        }
      }
      Intent localIntent = new Intent();
      int i;
      PendingIntent localPendingIntent2;
      if (localConnectionResult.isSuccess())
      {
        i = -1;
        localIntent.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", paramMaskedWallet);
        localPendingIntent2 = qh.b(qh.this).createPendingResult(this.My, localIntent, 1073741824);
        if (localPendingIntent2 == null) {
          Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
        }
      }
      else
      {
        if (paramInt == 408) {}
        for (i = 0;; i = 1)
        {
          localIntent.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
          break;
        }
      }
      try
      {
        localPendingIntent2.send(i);
        return;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", localCanceledException);
      }
    }
    
    public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", paramBoolean);
      PendingIntent localPendingIntent = qh.b(qh.this).createPendingResult(this.My, localIntent, 1073741824);
      if (localPendingIntent == null)
      {
        Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
        return;
      }
      try
      {
        localPendingIntent.send(-1);
        return;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", localCanceledException);
      }
    }
    
    public void i(int paramInt, Bundle paramBundle)
    {
      jx.b(paramBundle, "Bundle should not be null");
      ConnectionResult localConnectionResult = new ConnectionResult(paramInt, (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
      if (localConnectionResult.hasResolution()) {
        try
        {
          localConnectionResult.startResolutionForResult(qh.b(qh.this), this.My);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", localSendIntentException);
          return;
        }
      }
      Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + localConnectionResult);
      Intent localIntent = new Intent();
      localIntent.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
      PendingIntent localPendingIntent = qh.b(qh.this).createPendingResult(this.My, localIntent, 1073741824);
      if (localPendingIntent == null)
      {
        Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
        return;
      }
      try
      {
        localPendingIntent.send(1);
        return;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", localCanceledException);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qh
 * JD-Core Version:    0.7.0.1
 */