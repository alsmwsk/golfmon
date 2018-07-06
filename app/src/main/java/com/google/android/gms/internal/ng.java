package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationServices.a;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.c.a;
import com.google.android.gms.location.c.b;
import java.util.List;

public class ng
  implements GeofencingApi
{
  public PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, final GeofencingRequest paramGeofencingRequest, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        c.a local1 = new c.a()
        {
          public void a(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            ng.1.this.b(LocationStatusCodes.eD(paramAnonymous2Int));
          }
        };
        paramAnonymousnk.a(paramGeofencingRequest, paramPendingIntent, local1);
      }
    });
  }
  
  @Deprecated
  public PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, List<Geofence> paramList, PendingIntent paramPendingIntent)
  {
    GeofencingRequest.Builder localBuilder = new GeofencingRequest.Builder();
    localBuilder.addGeofences(paramList);
    localBuilder.setInitialTrigger(5);
    return addGeofences(paramGoogleApiClient, localBuilder.build(), paramPendingIntent);
  }
  
  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        c.b local1 = new c.b()
        {
          public void a(int paramAnonymous2Int, PendingIntent paramAnonymous2PendingIntent)
          {
            ng.2.this.b(LocationStatusCodes.eD(paramAnonymous2Int));
          }
          
          public void b(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
          }
        };
        paramAnonymousnk.a(paramPendingIntent, local1);
      }
    });
  }
  
  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final List<String> paramList)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        c.b local1 = new c.b()
        {
          public void a(int paramAnonymous2Int, PendingIntent paramAnonymous2PendingIntent)
          {
            Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
          }
          
          public void b(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            ng.3.this.b(LocationStatusCodes.eD(paramAnonymous2Int));
          }
        };
        paramAnonymousnk.a(paramList, local1);
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
 * Qualified Name:     com.google.android.gms.internal.ng
 * JD-Core Version:    0.7.0.1
 */