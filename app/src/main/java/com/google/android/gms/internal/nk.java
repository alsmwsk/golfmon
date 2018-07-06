package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.c.a;
import com.google.android.gms.location.c.b;
import java.util.List;

public class nk
  extends nc
{
  private final nj agX = new nj(paramContext, this.Ee);
  private final mz agY = mz.a(paramContext, paramString3, paramString4, this.Ee);
  private final ie agZ = ie.a(paramContext, this.Ee);
  
  public nk(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2)
  {
    this(paramContext, paramLooper, paramString1, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString2, null);
  }
  
  public nk(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3)
  {
    this(paramContext, paramLooper, paramString1, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString2, paramString3, null);
  }
  
  public nk(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString2);
  }
  
  public void S(boolean paramBoolean)
    throws RemoteException
  {
    this.agX.S(paramBoolean);
  }
  
  public void a(long paramLong, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    dS();
    jx.i(paramPendingIntent);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      jx.b(bool, "detectionIntervalMillis must be >= 0");
      ((ni)hw()).a(paramLong, true, paramPendingIntent);
      return;
    }
  }
  
  public void a(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    dS();
    jx.i(paramPendingIntent);
    ((ni)hw()).a(paramPendingIntent);
  }
  
  public void a(PendingIntent paramPendingIntent, c.b paramb)
    throws RemoteException
  {
    dS();
    jx.b(paramPendingIntent, "PendingIntent must be specified.");
    jx.b(paramb, "OnRemoveGeofencesResultListener not provided.");
    if (paramb == null) {}
    for (Object localObject = null;; localObject = new b(paramb, this))
    {
      ((ni)hw()).a(paramPendingIntent, (nh)localObject, getContext().getPackageName());
      return;
    }
  }
  
  public void a(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, c.a parama)
    throws RemoteException
  {
    dS();
    jx.b(paramGeofencingRequest, "geofencingRequest can't be null.");
    jx.b(paramPendingIntent, "PendingIntent must be specified.");
    jx.b(parama, "OnAddGeofencesResultListener not provided.");
    if (parama == null) {}
    for (Object localObject = null;; localObject = new b(parama, this))
    {
      ((ni)hw()).a(paramGeofencingRequest, paramPendingIntent, (nh)localObject);
      return;
    }
  }
  
  public void a(LocationListener paramLocationListener)
    throws RemoteException
  {
    this.agX.a(paramLocationListener);
  }
  
  public void a(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    synchronized (this.agX)
    {
      this.agX.a(paramLocationRequest, paramLocationListener, paramLooper);
      return;
    }
  }
  
  public void a(List<String> paramList, c.b paramb)
    throws RemoteException
  {
    dS();
    boolean bool;
    String[] arrayOfString;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool = true;
      jx.b(bool, "geofenceRequestIds can't be null nor empty.");
      jx.b(paramb, "OnRemoveGeofencesResultListener not provided.");
      arrayOfString = (String[])paramList.toArray(new String[0]);
      if (paramb != null) {
        break label83;
      }
    }
    label83:
    for (Object localObject = null;; localObject = new b(paramb, this))
    {
      ((ni)hw()).a(arrayOfString, (nh)localObject, getContext().getPackageName());
      return;
      bool = false;
      break;
    }
  }
  
  public void b(Location paramLocation)
    throws RemoteException
  {
    this.agX.b(paramLocation);
  }
  
  public void b(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.agX.b(paramLocationRequest, paramPendingIntent);
  }
  
  public void c(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.agX.c(paramPendingIntent);
  }
  
  public void disconnect()
  {
    synchronized (this.agX)
    {
      boolean bool = isConnected();
      if (bool) {}
      try
      {
        this.agX.removeAllListeners();
        this.agX.nm();
        super.disconnect();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", localException);
        }
      }
    }
  }
  
  public Location nl()
  {
    return this.agX.nl();
  }
  
  private final class a
    extends jl<ni>.b<c.a>
  {
    private final int Iv;
    private final String[] aha;
    
    public a(c.a parama, int paramInt, String[] paramArrayOfString)
    {
      super(parama);
      this.Iv = LocationStatusCodes.eC(paramInt);
      this.aha = paramArrayOfString;
    }
    
    protected void a(c.a parama)
    {
      if (parama != null) {
        parama.a(this.Iv, this.aha);
      }
    }
    
    protected void hx() {}
  }
  
  private static final class b
    extends nh.a
  {
    private c.a ahc;
    private c.b ahd;
    private nk ahe;
    
    public b(c.a parama, nk paramnk)
    {
      this.ahc = parama;
      this.ahd = null;
      this.ahe = paramnk;
    }
    
    public b(c.b paramb, nk paramnk)
    {
      this.ahd = paramb;
      this.ahc = null;
      this.ahe = paramnk;
    }
    
    public void a(int paramInt, PendingIntent paramPendingIntent)
    {
      if (this.ahe == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
        return;
      }
      nk localnk1 = this.ahe;
      nk localnk2 = this.ahe;
      localnk2.getClass();
      localnk1.a(new nk.c(localnk2, 1, this.ahd, paramInt, paramPendingIntent));
      this.ahe = null;
      this.ahc = null;
      this.ahd = null;
    }
    
    public void a(int paramInt, String[] paramArrayOfString)
      throws RemoteException
    {
      if (this.ahe == null)
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
        return;
      }
      nk localnk1 = this.ahe;
      nk localnk2 = this.ahe;
      localnk2.getClass();
      localnk1.a(new nk.a(localnk2, this.ahc, paramInt, paramArrayOfString));
      this.ahe = null;
      this.ahc = null;
      this.ahd = null;
    }
    
    public void b(int paramInt, String[] paramArrayOfString)
    {
      if (this.ahe == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
        return;
      }
      nk localnk1 = this.ahe;
      nk localnk2 = this.ahe;
      localnk2.getClass();
      localnk1.a(new nk.c(localnk2, 2, this.ahd, paramInt, paramArrayOfString));
      this.ahe = null;
      this.ahc = null;
      this.ahd = null;
    }
  }
  
  private final class c
    extends jl<ni>.b<c.b>
  {
    private final int Iv;
    private final String[] aha;
    private final int ahf;
    private final PendingIntent mPendingIntent;
    
    public c(int paramInt1, c.b paramb, int paramInt2, PendingIntent paramPendingIntent)
    {
      super(paramb);
      if (paramInt1 == i) {}
      for (;;)
      {
        je.K(i);
        this.ahf = paramInt1;
        this.Iv = LocationStatusCodes.eC(paramInt2);
        this.mPendingIntent = paramPendingIntent;
        this.aha = null;
        return;
        i = 0;
      }
    }
    
    public c(int paramInt1, c.b paramb, int paramInt2, String[] paramArrayOfString)
    {
      super(paramb);
      if (paramInt1 == 2) {}
      for (boolean bool = true;; bool = false)
      {
        je.K(bool);
        this.ahf = paramInt1;
        this.Iv = LocationStatusCodes.eC(paramInt2);
        this.aha = paramArrayOfString;
        this.mPendingIntent = null;
        return;
      }
    }
    
    protected void a(c.b paramb)
    {
      if (paramb != null) {}
      switch (this.ahf)
      {
      default: 
        Log.wtf("LocationClientImpl", "Unsupported action: " + this.ahf);
        return;
      case 1: 
        paramb.a(this.Iv, this.mPendingIntent);
        return;
      }
      paramb.b(this.Iv, this.aha);
    }
    
    protected void hx() {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nk
 * JD-Core Version:    0.7.0.1
 */