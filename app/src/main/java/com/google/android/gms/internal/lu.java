package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;

public abstract interface lu
  extends Api.a
{
  public abstract Context getContext();
  
  public abstract lz jM()
    throws DeadObjectException;
  
  public static abstract class a<R extends Result>
    extends BaseImplementation.a<R, lu>
  {
    public a(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  public static class b
    extends md.a
  {
    private final BaseImplementation.b<Status> Ea;
    
    public b(BaseImplementation.b<Status> paramb)
    {
      this.Ea = paramb;
    }
    
    public void j(Status paramStatus)
    {
      this.Ea.b(paramStatus);
    }
  }
  
  public static abstract class c
    extends lu.a<Status>
  {
    c(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected Status b(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        jx.L(bool);
        return paramStatus;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lu
 * JD-Core Version:    0.7.0.1
 */