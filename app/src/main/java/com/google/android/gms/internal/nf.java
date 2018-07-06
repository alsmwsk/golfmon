package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.a;

public class nf
  implements FusedLocationProviderApi
{
  public Location getLastLocation(GoogleApiClient paramGoogleApiClient)
  {
    nk localnk = LocationServices.f(paramGoogleApiClient);
    try
    {
      Location localLocation = localnk.nl();
      return localLocation;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        paramAnonymousnk.c(paramPendingIntent);
        b(Status.Kw);
      }
    });
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        paramAnonymousnk.a(paramLocationListener);
        b(Status.Kw);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        paramAnonymousnk.b(paramLocationRequest, paramPendingIntent);
        b(Status.Kw);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        paramAnonymousnk.a(paramLocationRequest, paramLocationListener, null);
        b(Status.Kw);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener, final Looper paramLooper)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        paramAnonymousnk.a(paramLocationRequest, paramLocationListener, paramLooper);
        b(Status.Kw);
      }
    });
  }
  
  public PendingResult<Status> setMockLocation(GoogleApiClient paramGoogleApiClient, final Location paramLocation)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        paramAnonymousnk.b(paramLocation);
        b(Status.Kw);
      }
    });
  }
  
  public PendingResult<Status> setMockMode(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        paramAnonymousnk.S(paramBoolean);
        b(Status.Kw);
      }
    });
  }
  
  private static abstract class a
    extends LocationServices.a<Status>
  {
    public a(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status b(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nf
 * JD-Core Version:    0.7.0.1
 */