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
import com.google.android.gms.internal.nb;
import com.google.android.gms.internal.nk;

public class ActivityRecognition
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api(DR, DQ, new Scope[0]);
  public static ActivityRecognitionApi ActivityRecognitionApi = new nb();
  public static final String CLIENT_NAME = "activity_recognition";
  private static final Api.c<nk> DQ = new Api.c();
  private static final Api.b<nk, Api.ApiOptions.NoOptions> DR = new Api.b()
  {
    public nk e(Context paramAnonymousContext, Looper paramAnonymousLooper, jg paramAnonymousjg, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new nk(paramAnonymousContext, paramAnonymousLooper, paramAnonymousContext.getPackageName(), paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, "activity_recognition");
    }
    
    public int getPriority()
    {
      return 2147483647;
    }
  };
  
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
 * Qualified Name:     com.google.android.gms.location.ActivityRecognition
 * JD-Core Version:    0.7.0.1
 */