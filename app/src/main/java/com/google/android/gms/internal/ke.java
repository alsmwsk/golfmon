package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class ke
  implements kd
{
  public PendingResult<Status> c(GoogleApiClient paramGoogleApiClient)
  {
    new kf.a(paramGoogleApiClient)
    {
      protected void a(kg paramAnonymouskg)
        throws RemoteException
      {
        ((ki)paramAnonymouskg.hw()).a(new ke.a(this));
      }
    }.gE();
  }
  
  private static class a
    extends kb
  {
    private final BaseImplementation.b<Status> Ea;
    
    public a(BaseImplementation.b<Status> paramb)
    {
      this.Ea = paramb;
    }
    
    public void aI(int paramInt)
      throws RemoteException
    {
      this.Ea.b(new Status(paramInt));
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ke
 * JD-Core Version:    0.7.0.1
 */