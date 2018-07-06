package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class kf<R extends Result>
  extends BaseImplementation.a<R, kg>
{
  public kf(GoogleApiClient paramGoogleApiClient)
  {
    super(kc.DQ, paramGoogleApiClient);
  }
  
  static abstract class a
    extends kf<Status>
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
 * Qualified Name:     com.google.android.gms.internal.kf
 * JD-Core Version:    0.7.0.1
 */