package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.nf;
import com.google.android.gms.internal.ng;
import com.google.android.gms.internal.nk;

public class LocationServices
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api(DR, DQ, new Scope[0]);
  private static final Api.c<nk> DQ = new Api.c();
  private static final Api.b<nk, Api.ApiOptions.NoOptions> DR = new Api.b()
  {
    public nk e(Context paramAnonymousContext, Looper paramAnonymousLooper, jg paramAnonymousjg, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new nk(paramAnonymousContext, paramAnonymousLooper, paramAnonymousContext.getPackageName(), paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, "locationServices", paramAnonymousjg.getAccountName());
    }
    
    public int getPriority()
    {
      return 2147483647;
    }
  };
  public static FusedLocationProviderApi FusedLocationApi = new nf();
  public static GeofencingApi GeofencingApi = new ng();
  
  public static nk f(GoogleApiClient paramGoogleApiClient)
  {
    boolean bool1 = true;
    boolean bool2;
    nk localnk;
    if (paramGoogleApiClient != null)
    {
      bool2 = bool1;
      jx.b(bool2, "GoogleApiClient parameter is required.");
      localnk = (nk)paramGoogleApiClient.a(DQ);
      if (localnk == null) {
        break label44;
      }
    }
    for (;;)
    {
      jx.a(bool1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return localnk;
      bool2 = false;
      break;
      label44:
      bool1 = false;
    }
  }
  
  public static abstract class a<R extends Result>
    extends BaseImplementation.a<R, nk>
  {
    public a(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationServices
 * JD-Core Version:    0.7.0.1
 */