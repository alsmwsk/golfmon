package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition.a;
import com.google.android.gms.location.ActivityRecognitionApi;

public class nb
  implements ActivityRecognitionApi
{
  public PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        paramAnonymousnk.a(paramPendingIntent);
        b(Status.Kw);
      }
    });
  }
  
  public PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, final long paramLong, PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramGoogleApiClient)
    {
      protected void a(nk paramAnonymousnk)
        throws RemoteException
      {
        paramAnonymousnk.a(paramLong, this.agB);
        b(Status.Kw);
      }
    });
  }
  
  private static abstract class a
    extends ActivityRecognition.a<Status>
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
 * Qualified Name:     com.google.android.gms.internal.nb
 * JD-Core Version:    0.7.0.1
 */