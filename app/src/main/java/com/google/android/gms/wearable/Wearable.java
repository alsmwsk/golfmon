package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.ay;
import com.google.android.gms.wearable.internal.ba;
import com.google.android.gms.wearable.internal.e;

public class Wearable
{
  public static final Api<WearableOptions> API = new Api(DR, DQ, new Scope[0]);
  public static final Api.c<ba> DQ;
  private static final Api.b<ba, WearableOptions> DR;
  public static final DataApi DataApi = new com.google.android.gms.wearable.internal.f();
  public static final MessageApi MessageApi = new ah();
  public static final NodeApi NodeApi = new ak();
  public static final b axl = new e();
  public static final f axm = new ay();
  
  static
  {
    DQ = new Api.c();
    DR = new Api.b()
    {
      public ba a(Context paramAnonymousContext, Looper paramAnonymousLooper, jg paramAnonymousjg, Wearable.WearableOptions paramAnonymousWearableOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        if (paramAnonymousWearableOptions != null) {}
        for (;;)
        {
          return new ba(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
          new Wearable.WearableOptions(new Wearable.WearableOptions.Builder(), null);
        }
      }
      
      public int getPriority()
      {
        return 2147483647;
      }
    };
  }
  
  public static final class WearableOptions
    implements Api.ApiOptions.Optional
  {
    private WearableOptions(Builder paramBuilder) {}
    
    public static class Builder
    {
      public Wearable.WearableOptions build()
      {
        return new Wearable.WearableOptions(this, null);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.Wearable
 * JD-Core Version:    0.7.0.1
 */