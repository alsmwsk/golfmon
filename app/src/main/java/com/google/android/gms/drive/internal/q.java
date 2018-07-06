package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

abstract class q<R extends Result>
  extends BaseImplementation.a<R, r>
{
  public q(GoogleApiClient paramGoogleApiClient)
  {
    super(Drive.DQ, paramGoogleApiClient);
  }
  
  static abstract class a
    extends q<Status>
  {
    a(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected Status b(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.q
 * JD-Core Version:    0.7.0.1
 */