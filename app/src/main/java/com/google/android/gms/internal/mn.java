package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.request.u;
import com.google.android.gms.fitness.request.w.a;
import com.google.android.gms.fitness.request.y.a;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

public class mn
  implements SessionsApi
{
  private PendingResult<SessionStopResult> a(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    paramGoogleApiClient.b(new lu.a(paramGoogleApiClient)
    {
      protected SessionStopResult A(Status paramAnonymousStatus)
      {
        return SessionStopResult.H(paramAnonymousStatus);
      }
      
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        mn.b localb = new mn.b(this, null);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(new y.a().bx(paramString1).by(paramString2).kl(), localb, str);
      }
    });
  }
  
  public PendingResult<Status> insertSession(GoogleApiClient paramGoogleApiClient, final SessionInsertRequest paramSessionInsertRequest)
  {
    paramGoogleApiClient.a(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(paramSessionInsertRequest, localb, str);
      }
    });
  }
  
  public PendingResult<SessionReadResult> readSession(GoogleApiClient paramGoogleApiClient, final SessionReadRequest paramSessionReadRequest)
  {
    paramGoogleApiClient.a(new lu.a(paramGoogleApiClient)
    {
      protected SessionReadResult B(Status paramAnonymousStatus)
      {
        return SessionReadResult.G(paramAnonymousStatus);
      }
      
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        mn.a locala = new mn.a(this, null);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(paramSessionReadRequest, locala, str);
      }
    });
  }
  
  public PendingResult<Status> registerForSessions(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        u localu = new u(paramPendingIntent);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(localu, localb, str);
      }
    });
  }
  
  public PendingResult<Status> startSession(GoogleApiClient paramGoogleApiClient, final Session paramSession)
  {
    paramGoogleApiClient.b(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(new w.a().b(paramSession).kk(), localb, str);
      }
    });
  }
  
  public PendingResult<SessionStopResult> stopSession(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return a(paramGoogleApiClient, null, paramString);
  }
  
  public PendingResult<Status> unregisterForSessions(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        aa localaa = new aa(paramPendingIntent);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(localaa, localb, str);
      }
    });
  }
  
  private static class a
    extends mb.a
  {
    private final BaseImplementation.b<SessionReadResult> Ea;
    
    private a(BaseImplementation.b<SessionReadResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(SessionReadResult paramSessionReadResult)
      throws RemoteException
    {
      this.Ea.b(paramSessionReadResult);
    }
  }
  
  private static class b
    extends mc.a
  {
    private final BaseImplementation.b<SessionStopResult> Ea;
    
    private b(BaseImplementation.b<SessionStopResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(SessionStopResult paramSessionStopResult)
    {
      this.Ea.b(paramSessionStopResult);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mn
 * JD-Core Version:    0.7.0.1
 */