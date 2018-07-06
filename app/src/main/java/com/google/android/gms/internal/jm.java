package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;
import java.util.Iterator;

public final class jm
{
  private final b MX;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> MY = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> MZ = new ArrayList();
  private boolean Na = false;
  private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> Nb = new ArrayList();
  private final Handler mHandler;
  
  public jm(Context paramContext, Looper paramLooper, b paramb)
  {
    this.MX = paramb;
    this.mHandler = new a(paramLooper);
  }
  
  public void aE(int paramInt)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.MY)
    {
      this.Na = true;
      Iterator localIterator = new ArrayList(this.MY).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (localIterator.hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if (this.MX.gN()) {}
        }
        else
        {
          this.Na = false;
          return;
        }
      } while (!this.MY.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void b(ConnectionResult paramConnectionResult)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.Nb)
    {
      Iterator localIterator = new ArrayList(this.Nb).iterator();
      while (localIterator.hasNext())
      {
        GooglePlayServicesClient.OnConnectionFailedListener localOnConnectionFailedListener = (GooglePlayServicesClient.OnConnectionFailedListener)localIterator.next();
        if (!this.MX.gN()) {
          return;
        }
        if (this.Nb.contains(localOnConnectionFailedListener)) {
          localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
        }
      }
    }
  }
  
  protected void dU()
  {
    synchronized (this.MY)
    {
      f(this.MX.fX());
      return;
    }
  }
  
  public void f(Bundle paramBundle)
  {
    boolean bool1 = true;
    for (;;)
    {
      synchronized (this.MY)
      {
        if (!this.Na)
        {
          bool2 = bool1;
          jx.K(bool2);
          this.mHandler.removeMessages(1);
          this.Na = true;
          if (this.MZ.size() != 0) {
            break label164;
          }
          jx.K(bool1);
          Iterator localIterator = new ArrayList(this.MY).iterator();
          GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
          if (localIterator.hasNext())
          {
            localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
            if ((this.MX.gN()) && (this.MX.isConnected())) {}
          }
          else
          {
            this.MZ.clear();
            this.Na = false;
            return;
          }
          if (this.MZ.contains(localConnectionCallbacks)) {
            continue;
          }
          localConnectionCallbacks.onConnected(paramBundle);
        }
      }
      boolean bool2 = false;
      continue;
      label164:
      bool1 = false;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    jx.i(paramConnectionCallbacks);
    synchronized (this.MY)
    {
      boolean bool = this.MY.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    jx.i(paramOnConnectionFailedListener);
    synchronized (this.Nb)
    {
      boolean bool = this.Nb.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    jx.i(paramConnectionCallbacks);
    synchronized (this.MY)
    {
      if (this.MY.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.MX.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.MY.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    jx.i(paramOnConnectionFailedListener);
    synchronized (this.Nb)
    {
      if (this.Nb.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.Nb.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    jx.i(paramConnectionCallbacks);
    synchronized (this.MY)
    {
      if (this.MY != null)
      {
        if (this.MY.remove(paramConnectionCallbacks)) {
          break label63;
        }
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      label63:
      while (!this.Na) {
        return;
      }
      this.MZ.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    jx.i(paramOnConnectionFailedListener);
    synchronized (this.Nb)
    {
      if ((this.Nb != null) && (!this.Nb.remove(paramOnConnectionFailedListener))) {
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1) {
        synchronized (jm.a(jm.this))
        {
          if ((jm.b(jm.this).gN()) && (jm.b(jm.this).isConnected()) && (jm.a(jm.this).contains(paramMessage.obj)))
          {
            Bundle localBundle = jm.b(jm.this).fX();
            ((GoogleApiClient.ConnectionCallbacks)paramMessage.obj).onConnected(localBundle);
          }
          return;
        }
      }
      Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    }
  }
  
  public static abstract interface b
  {
    public abstract Bundle fX();
    
    public abstract boolean gN();
    
    public abstract boolean isConnected();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jm
 * JD-Core Version:    0.7.0.1
 */