package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.j;
import com.google.android.gms.fitness.result.DataTypeResult;

public class mi
  implements ConfigApi
{
  public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient paramGoogleApiClient, final DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    paramGoogleApiClient.b(new lu.a(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        mi.a locala = new mi.a(this, null);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(paramDataTypeCreateRequest, locala, str);
      }
      
      protected DataTypeResult w(Status paramAnonymousStatus)
      {
        return DataTypeResult.E(paramAnonymousStatus);
      }
    });
  }
  
  public PendingResult<Status> disableFit(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.b(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(localb, str);
      }
    });
  }
  
  public PendingResult<DataTypeResult> readDataType(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    paramGoogleApiClient.a(new lu.a(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        mi.a locala = new mi.a(this, null);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(this.Vd, locala, str);
      }
      
      protected DataTypeResult w(Status paramAnonymousStatus)
      {
        return DataTypeResult.E(paramAnonymousStatus);
      }
    });
  }
  
  private static class a
    extends ly.a
  {
    private final BaseImplementation.b<DataTypeResult> Ea;
    
    private a(BaseImplementation.b<DataTypeResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(DataTypeResult paramDataTypeResult)
    {
      this.Ea.b(paramDataTypeResult);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mi
 * JD-Core Version:    0.7.0.1
 */