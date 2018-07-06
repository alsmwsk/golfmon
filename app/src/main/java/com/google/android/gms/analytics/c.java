package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.a;
import java.util.List;
import java.util.Map;

class c
  implements b
{
  private Context mContext;
  private ServiceConnection xV;
  private b xW;
  private c xX;
  private hb xY;
  
  public c(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    if (paramb == null) {
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    }
    this.xW = paramb;
    if (paramc == null) {
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    this.xX = paramc;
  }
  
  private hb dR()
  {
    dS();
    return this.xY;
  }
  
  private void dT()
  {
    dU();
  }
  
  private void dU()
  {
    this.xW.onConnected();
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<ha> paramList)
  {
    try
    {
      dR().a(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ae.T("sendHit failed: " + localRemoteException);
    }
  }
  
  public void connect()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", this.mContext.getPackageName());
    if (this.xV != null) {
      ae.T("Calling connect() while still connected, missing disconnect().");
    }
    boolean bool;
    do
    {
      return;
      this.xV = new a();
      bool = this.mContext.bindService(localIntent, this.xV, 129);
      ae.V("connect: bindService returned " + bool + " for " + localIntent);
    } while (bool);
    this.xV = null;
    this.xX.a(1, null);
  }
  
  public void dQ()
  {
    try
    {
      dR().dQ();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ae.T("clear hits failed: " + localRemoteException);
    }
  }
  
  protected void dS()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void disconnect()
  {
    this.xY = null;
    if (this.xV != null) {}
    try
    {
      this.mContext.unbindService(this.xV);
      label23:
      this.xV = null;
      this.xW.onDisconnected();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label23;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label23;
    }
  }
  
  public boolean isConnected()
  {
    return this.xY != null;
  }
  
  final class a
    implements ServiceConnection
  {
    a() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      ae.V("service connected, binder: " + paramIBinder);
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          ae.V("bound to service");
          c.a(c.this, hb.a.D(paramIBinder));
          c.a(c.this);
          return;
        }
      }
      catch (RemoteException localRemoteException) {}
      try
      {
        c.b(c.this).unbindService(this);
        label73:
        c.a(c.this, null);
        c.c(c.this).a(2, null);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label73;
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      ae.V("service disconnected: " + paramComponentName);
      c.a(c.this, null);
      c.d(c.this).onDisconnected();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onConnected();
    
    public abstract void onDisconnected();
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, Intent paramIntent);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.c
 * JD-Core Version:    0.7.0.1
 */