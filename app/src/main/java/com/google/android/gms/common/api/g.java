package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import java.util.List;

public class g
  extends Fragment
  implements DialogInterface.OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult>
{
  private boolean KC;
  private int KD = -1;
  private ConnectionResult KE;
  private final Handler KF = new Handler(Looper.getMainLooper());
  private final SparseArray<b> KG = new SparseArray();
  
  public static g a(FragmentActivity paramFragmentActivity)
  {
    jx.aU("Must be called from main thread of process");
    FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
    try
    {
      g localg = (g)localFragmentManager.findFragmentByTag("GmsSupportLifecycleFragment");
      if ((localg == null) || (localg.isRemoving()))
      {
        localg = new g();
        localFragmentManager.beginTransaction().add(localg, "GmsSupportLifecycleFragment").commit();
        localFragmentManager.executePendingTransactions();
      }
      return localg;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", localClassCastException);
    }
  }
  
  private void a(int paramInt, ConnectionResult paramConnectionResult)
  {
    if (!this.KC)
    {
      this.KC = true;
      this.KD = paramInt;
      this.KE = paramConnectionResult;
      this.KF.post(new c(paramInt, paramConnectionResult));
    }
  }
  
  private void aq(int paramInt)
  {
    if (paramInt == this.KD) {
      gR();
    }
  }
  
  private void b(int paramInt, ConnectionResult paramConnectionResult)
  {
    Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
    b localb = (b)this.KG.get(paramInt);
    if (localb != null)
    {
      ao(paramInt);
      GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = localb.KK;
      if (localOnConnectionFailedListener != null) {
        localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
      }
    }
    gR();
  }
  
  private void gR()
  {
    int i = 0;
    this.KC = false;
    this.KD = -1;
    this.KE = null;
    LoaderManager localLoaderManager = getLoaderManager();
    while (i < this.KG.size())
    {
      int j = this.KG.keyAt(i);
      a locala = ap(j);
      if (locala != null) {
        locala.gS();
      }
      localLoaderManager.initLoader(j, null, this);
      i++;
    }
  }
  
  public void a(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    jx.b(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.KG.indexOfKey(paramInt) < 0) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Already managing a GoogleApiClient with id " + paramInt);
      b localb = new b(paramGoogleApiClient, paramOnConnectionFailedListener, null);
      this.KG.put(paramInt, localb);
      if (getActivity() != null) {
        getLoaderManager().initLoader(paramInt, null, this);
      }
      return;
    }
  }
  
  public void a(Loader<ConnectionResult> paramLoader, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.isSuccess())
    {
      aq(paramLoader.getId());
      return;
    }
    a(paramLoader.getId(), paramConnectionResult);
  }
  
  public GoogleApiClient an(int paramInt)
  {
    if (getActivity() != null)
    {
      a locala = ap(paramInt);
      if (locala != null) {
        return locala.KH;
      }
    }
    return null;
  }
  
  public void ao(int paramInt)
  {
    getLoaderManager().destroyLoader(paramInt);
    this.KG.remove(paramInt);
  }
  
  a ap(int paramInt)
  {
    try
    {
      a locala = (a)getLoaderManager().getLoader(paramInt);
      return locala;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", localClassCastException);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label62;
      }
      gR();
      return;
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0) {
        break;
      }
      continue;
      if (paramInt2 != -1) {
        break;
      }
    }
    label62:
    b(this.KD, this.KE);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    int i = 0;
    if (i < this.KG.size())
    {
      int j = this.KG.keyAt(i);
      a locala = ap(j);
      if ((locala != null) && (((b)this.KG.valueAt(i)).KH != locala.KH)) {
        getLoaderManager().restartLoader(j, null, this);
      }
      for (;;)
      {
        i++;
        break;
        getLoaderManager().initLoader(j, null, this);
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    b(this.KD, this.KE);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.KC = paramBundle.getBoolean("resolving_error", false);
      this.KD = paramBundle.getInt("failed_client_id", -1);
      if (this.KD >= 0) {
        this.KE = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public Loader<ConnectionResult> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new a(getActivity(), ((b)this.KG.get(paramInt)).KH);
  }
  
  public void onLoaderReset(Loader<ConnectionResult> paramLoader)
  {
    if (paramLoader.getId() == this.KD) {
      gR();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.KC);
    if (this.KD >= 0)
    {
      paramBundle.putInt("failed_client_id", this.KD);
      paramBundle.putInt("failed_status", this.KE.getErrorCode());
      paramBundle.putParcelable("failed_resolution", this.KE.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (!this.KC) {
      for (int i = 0; i < this.KG.size(); i++) {
        getLoaderManager().initLoader(this.KG.keyAt(i), null, this);
      }
    }
  }
  
  static class a
    extends Loader<ConnectionResult>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    public final GoogleApiClient KH;
    private boolean KI;
    private ConnectionResult KJ;
    
    public a(Context paramContext, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.KH = paramGoogleApiClient;
    }
    
    private void a(ConnectionResult paramConnectionResult)
    {
      this.KJ = paramConnectionResult;
      if ((isStarted()) && (!isAbandoned())) {
        deliverResult(paramConnectionResult);
      }
    }
    
    public void gS()
    {
      if (this.KI)
      {
        this.KI = false;
        if ((isStarted()) && (!isAbandoned())) {
          this.KH.connect();
        }
      }
    }
    
    public void onConnected(Bundle paramBundle)
    {
      this.KI = false;
      a(ConnectionResult.Iu);
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.KI = true;
      a(paramConnectionResult);
    }
    
    public void onConnectionSuspended(int paramInt) {}
    
    protected void onReset()
    {
      this.KJ = null;
      this.KI = false;
      this.KH.unregisterConnectionCallbacks(this);
      this.KH.unregisterConnectionFailedListener(this);
      this.KH.disconnect();
    }
    
    protected void onStartLoading()
    {
      super.onStartLoading();
      this.KH.registerConnectionCallbacks(this);
      this.KH.registerConnectionFailedListener(this);
      if (this.KJ != null) {
        deliverResult(this.KJ);
      }
      if ((!this.KH.isConnected()) && (!this.KH.isConnecting()) && (!this.KI)) {
        this.KH.connect();
      }
    }
    
    protected void onStopLoading()
    {
      this.KH.disconnect();
    }
  }
  
  private static class b
  {
    public final GoogleApiClient KH;
    public final GoogleApiClient.OnConnectionFailedListener KK;
    
    private b(GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.KH = paramGoogleApiClient;
      this.KK = paramOnConnectionFailedListener;
    }
  }
  
  private class c
    implements Runnable
  {
    private final int KL;
    private final ConnectionResult KM;
    
    public c(int paramInt, ConnectionResult paramConnectionResult)
    {
      this.KL = paramInt;
      this.KM = paramConnectionResult;
    }
    
    public void run()
    {
      if (this.KM.hasResolution()) {
        try
        {
          int i = 1 + (1 + g.this.getActivity().getSupportFragmentManager().getFragments().indexOf(g.this) << 16);
          this.KM.startResolutionForResult(g.this.getActivity(), i);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          g.a(g.this);
          return;
        }
      }
      if (GooglePlayServicesUtil.isUserRecoverableError(this.KM.getErrorCode()))
      {
        GooglePlayServicesUtil.showErrorDialogFragment(this.KM.getErrorCode(), g.this.getActivity(), g.this, 2, g.this);
        return;
      }
      g.a(g.this, this.KL, this.KM);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.g
 * JD-Core Version:    0.7.0.1
 */