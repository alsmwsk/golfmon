package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class ol
  implements PanoramaApi
{
  private static void a(Context paramContext, Uri paramUri)
  {
    paramContext.revokeUriPermission(paramUri, 1);
  }
  
  private static void a(Context paramContext, ok paramok, final oj paramoj, final Uri paramUri, Bundle paramBundle)
    throws RemoteException
  {
    paramContext.grantUriPermission("com.google.android.gms", paramUri, 1);
    oj.a local3 = new oj.a()
    {
      public void a(int paramAnonymousInt1, Bundle paramAnonymousBundle, int paramAnonymousInt2, Intent paramAnonymousIntent)
        throws RemoteException
      {
        ol.b(this.nf, paramUri);
        paramoj.a(paramAnonymousInt1, paramAnonymousBundle, paramAnonymousInt2, paramAnonymousIntent);
      }
    };
    try
    {
      paramok.a(local3, paramUri, paramBundle, true);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a(paramContext, paramUri);
      throw localRemoteException;
    }
    catch (RuntimeException localRuntimeException)
    {
      a(paramContext, paramUri);
      throw localRuntimeException;
    }
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new a(paramGoogleApiClient)
    {
      protected void a(Context paramAnonymousContext, ok paramAnonymousok)
        throws RemoteException
      {
        paramAnonymousok.a(new ol.b(this), paramUri, null, false);
      }
    });
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new a(paramGoogleApiClient)
    {
      protected void a(Context paramAnonymousContext, ok paramAnonymousok)
        throws RemoteException
      {
        ol.b(paramAnonymousContext, paramAnonymousok, new ol.b(this), paramUri, null);
      }
    });
  }
  
  private static abstract class a
    extends ol.c<PanoramaApi.PanoramaResult>
  {
    public a(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected PanoramaApi.PanoramaResult ay(Status paramStatus)
    {
      return new on(paramStatus, null);
    }
  }
  
  private static final class b
    extends oj.a
  {
    private final BaseImplementation.b<PanoramaApi.PanoramaResult> Ea;
    
    public b(BaseImplementation.b<PanoramaApi.PanoramaResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle != null) {}
      for (PendingIntent localPendingIntent = (PendingIntent)paramBundle.getParcelable("pendingIntent");; localPendingIntent = null)
      {
        Status localStatus = new Status(paramInt1, null, localPendingIntent);
        this.Ea.b(new on(localStatus, paramIntent));
        return;
      }
    }
  }
  
  private static abstract class c<R extends Result>
    extends BaseImplementation.a<R, om>
  {
    protected c(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected abstract void a(Context paramContext, ok paramok)
      throws RemoteException;
    
    protected final void a(om paramom)
      throws RemoteException
    {
      a(paramom.getContext(), (ok)paramom.hw());
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ol
 * JD-Core Version:    0.7.0.1
 */