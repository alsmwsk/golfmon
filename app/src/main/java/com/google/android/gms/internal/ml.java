package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.data.Subscription.a;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.af.a;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.aj.a;
import com.google.android.gms.fitness.request.m;
import com.google.android.gms.fitness.request.m.a;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class ml
  implements RecordingApi
{
  private PendingResult<ListSubscriptionsResult> a(GoogleApiClient paramGoogleApiClient, final m paramm)
  {
    paramGoogleApiClient.a(new lu.a(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        ml.a locala = new ml.a(this, null);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(paramm, locala, str);
      }
      
      protected ListSubscriptionsResult y(Status paramAnonymousStatus)
      {
        return ListSubscriptionsResult.F(paramAnonymousStatus);
      }
    });
  }
  
  public PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final af paramaf)
  {
    paramGoogleApiClient.a(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(paramaf, localb, str);
      }
    });
  }
  
  public PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final aj paramaj)
  {
    paramGoogleApiClient.b(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(paramaj, localb, str);
      }
    });
  }
  
  public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient)
  {
    return a(paramGoogleApiClient, new m.a().ka());
  }
  
  public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return a(paramGoogleApiClient, new m.a().c(paramDataType).ka());
  }
  
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return a(paramGoogleApiClient, new af.a().b(new Subscription.a().b(paramDataSource).jK()).kp());
  }
  
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return a(paramGoogleApiClient, new af.a().b(new Subscription.a().b(paramDataType).jK()).kp());
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return a(paramGoogleApiClient, new aj.a().d(paramDataSource).kq());
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return a(paramGoogleApiClient, new aj.a().d(paramDataType).kq());
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, Subscription paramSubscription)
  {
    if (paramSubscription.getDataType() == null) {
      return unsubscribe(paramGoogleApiClient, paramSubscription.getDataSource());
    }
    return unsubscribe(paramGoogleApiClient, paramSubscription.getDataType());
  }
  
  private static class a
    extends ma.a
  {
    private final BaseImplementation.b<ListSubscriptionsResult> Ea;
    
    private a(BaseImplementation.b<ListSubscriptionsResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(ListSubscriptionsResult paramListSubscriptionsResult)
    {
      this.Ea.b(paramListSubscriptionsResult);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ml
 * JD-Core Version:    0.7.0.1
 */