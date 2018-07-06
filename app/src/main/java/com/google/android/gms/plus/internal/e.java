package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jd;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.b;
import com.google.android.gms.internal.jl.d;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ky;
import com.google.android.gms.internal.lm;
import com.google.android.gms.internal.pf;
import com.google.android.gms.internal.pi;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class e
  extends jl<d>
{
  private Person anG;
  private final h anH;
  
  public e(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, h paramh)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramh.oz());
    this.anH = paramh;
  }
  
  public jr a(BaseImplementation.b<People.LoadPeopleResult> paramb, int paramInt, String paramString)
  {
    dS();
    e locale = new e(paramb);
    try
    {
      jr localjr = ((d)hw()).a(locale, 1, paramInt, -1, paramString);
      return localjr;
    }
    catch (RemoteException localRemoteException)
    {
      locale.a(DataHolder.av(8), null);
    }
    return null;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
      this.anG = pi.i(paramBundle.getByteArray("loaded_person"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(BaseImplementation.b<Moments.LoadMomentsResult> paramb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    dS();
    if (paramb != null) {}
    for (b localb = new b(paramb);; localb = null) {
      try
      {
        ((d)hw()).a(localb, paramInt, paramString1, paramUri, paramString2, paramString3);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localb.a(DataHolder.av(8), null, null);
      }
    }
  }
  
  public void a(BaseImplementation.b<Status> paramb, Moment paramMoment)
  {
    dS();
    if (paramb != null) {}
    for (a locala = new a(paramb);; locala = null) {
      try
      {
        ky localky = ky.a((pf)paramMoment);
        ((d)hw()).a(locala, localky);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        if (locala != null) {
          break;
        }
        throw new IllegalStateException(localRemoteException);
        locala.aA(new Status(8, null, null));
      }
    }
  }
  
  public void a(BaseImplementation.b<People.LoadPeopleResult> paramb, Collection<String> paramCollection)
  {
    dS();
    e locale = new e(paramb);
    try
    {
      ((d)hw()).a(locale, new ArrayList(paramCollection));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      locale.a(DataHolder.av(8), null);
    }
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    Bundle localBundle = this.anH.oH();
    localBundle.putStringArray("request_visible_actions", this.anH.oA());
    localBundle.putString("auth_package", this.anH.oC());
    paramjt.a(parame, new jj(2).aX(this.anH.oD()).a(jd.aT(this.anH.getAccountName())).a(lm.d(hv())).e(localBundle));
  }
  
  protected String bK()
  {
    return "com.google.android.gms.plus.service.START";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.plus.internal.IPlusService";
  }
  
  protected d bN(IBinder paramIBinder)
  {
    return d.a.bM(paramIBinder);
  }
  
  public boolean cj(String paramString)
  {
    return Arrays.asList(hv()).contains(paramString);
  }
  
  public void clearDefaultAccount()
  {
    dS();
    try
    {
      this.anG = null;
      ((d)hw()).clearDefaultAccount();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void d(BaseImplementation.b<People.LoadPeopleResult> paramb, String[] paramArrayOfString)
  {
    a(paramb, Arrays.asList(paramArrayOfString));
  }
  
  public String getAccountName()
  {
    dS();
    try
    {
      String str = ((d)hw()).getAccountName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public Person getCurrentPerson()
  {
    dS();
    return this.anG;
  }
  
  public void j(BaseImplementation.b<Moments.LoadMomentsResult> paramb)
  {
    a(paramb, 20, null, null, null, "me");
  }
  
  public void k(BaseImplementation.b<People.LoadPeopleResult> paramb)
  {
    dS();
    e locale = new e(paramb);
    try
    {
      ((d)hw()).a(locale, 2, 1, -1, null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      locale.a(DataHolder.av(8), null);
    }
  }
  
  public void l(BaseImplementation.b<Status> paramb)
  {
    dS();
    clearDefaultAccount();
    g localg = new g(paramb);
    try
    {
      ((d)hw()).b(localg);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localg.h(8, null);
    }
  }
  
  public jr q(BaseImplementation.b<People.LoadPeopleResult> paramb, String paramString)
  {
    return a(paramb, 0, paramString);
  }
  
  public void removeMoment(String paramString)
  {
    dS();
    try
    {
      ((d)hw()).removeMoment(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  final class a
    extends a
  {
    private final BaseImplementation.b<Status> anI;
    
    public a()
    {
      Object localObject;
      this.anI = localObject;
    }
    
    public void aA(Status paramStatus)
    {
      e.this.a(new e.d(e.this, this.anI, paramStatus));
    }
  }
  
  final class b
    extends a
  {
    private final BaseImplementation.b<Moments.LoadMomentsResult> anI;
    
    public b()
    {
      Object localObject;
      this.anI = localObject;
    }
    
    public void a(DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      if (paramDataHolder.gV() != null) {}
      for (PendingIntent localPendingIntent = (PendingIntent)paramDataHolder.gV().getParcelable("pendingIntent");; localPendingIntent = null)
      {
        Status localStatus = new Status(paramDataHolder.getStatusCode(), null, localPendingIntent);
        if ((!localStatus.isSuccess()) && (paramDataHolder != null)) {
          if (!paramDataHolder.isClosed()) {
            paramDataHolder.close();
          }
        }
        for (DataHolder localDataHolder = null;; localDataHolder = paramDataHolder)
        {
          e.this.a(new e.c(e.this, this.anI, localStatus, localDataHolder, paramString1, paramString2));
          return;
        }
      }
    }
  }
  
  final class c
    extends jl<d>.d<BaseImplementation.b<Moments.LoadMomentsResult>>
    implements Moments.LoadMomentsResult
  {
    private final Status Eb;
    private final String OB;
    private final String anK;
    private MomentBuffer anL;
    
    public c(Status paramStatus, DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      super(paramStatus, paramString1);
      this.Eb = paramDataHolder;
      this.OB = paramString2;
      Object localObject;
      this.anK = localObject;
    }
    
    protected void a(BaseImplementation.b<Moments.LoadMomentsResult> paramb, DataHolder paramDataHolder)
    {
      if (paramDataHolder != null) {}
      for (MomentBuffer localMomentBuffer = new MomentBuffer(paramDataHolder);; localMomentBuffer = null)
      {
        this.anL = localMomentBuffer;
        paramb.b(this);
        return;
      }
    }
    
    public MomentBuffer getMomentBuffer()
    {
      return this.anL;
    }
    
    public String getNextPageToken()
    {
      return this.OB;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
    
    public String getUpdated()
    {
      return this.anK;
    }
    
    public void release()
    {
      if (this.anL != null) {
        this.anL.close();
      }
    }
  }
  
  final class d
    extends jl<d>.b<BaseImplementation.b<Status>>
  {
    private final Status Eb;
    
    public d(Status paramStatus)
    {
      super(paramStatus);
      Object localObject;
      this.Eb = localObject;
    }
    
    protected void hx() {}
    
    protected void m(BaseImplementation.b<Status> paramb)
    {
      if (paramb != null) {
        paramb.b(this.Eb);
      }
    }
  }
  
  final class e
    extends a
  {
    private final BaseImplementation.b<People.LoadPeopleResult> anI;
    
    public e()
    {
      Object localObject;
      this.anI = localObject;
    }
    
    public void a(DataHolder paramDataHolder, String paramString)
    {
      if (paramDataHolder.gV() != null) {}
      for (PendingIntent localPendingIntent = (PendingIntent)paramDataHolder.gV().getParcelable("pendingIntent");; localPendingIntent = null)
      {
        Status localStatus = new Status(paramDataHolder.getStatusCode(), null, localPendingIntent);
        if ((!localStatus.isSuccess()) && (paramDataHolder != null)) {
          if (!paramDataHolder.isClosed()) {
            paramDataHolder.close();
          }
        }
        for (DataHolder localDataHolder = null;; localDataHolder = paramDataHolder)
        {
          e.this.a(new e.f(e.this, this.anI, localStatus, localDataHolder, paramString));
          return;
        }
      }
    }
  }
  
  final class f
    extends jl<d>.d<BaseImplementation.b<People.LoadPeopleResult>>
    implements People.LoadPeopleResult
  {
    private final Status Eb;
    private final String OB;
    private PersonBuffer anM;
    
    public f(Status paramStatus, DataHolder paramDataHolder, String paramString)
    {
      super(paramStatus, paramString);
      this.Eb = paramDataHolder;
      Object localObject;
      this.OB = localObject;
    }
    
    protected void a(BaseImplementation.b<People.LoadPeopleResult> paramb, DataHolder paramDataHolder)
    {
      if (paramDataHolder != null) {}
      for (PersonBuffer localPersonBuffer = new PersonBuffer(paramDataHolder);; localPersonBuffer = null)
      {
        this.anM = localPersonBuffer;
        paramb.b(this);
        return;
      }
    }
    
    public String getNextPageToken()
    {
      return this.OB;
    }
    
    public PersonBuffer getPersonBuffer()
    {
      return this.anM;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
    
    public void release()
    {
      if (this.anM != null) {
        this.anM.close();
      }
    }
  }
  
  final class g
    extends a
  {
    private final BaseImplementation.b<Status> anI;
    
    public g()
    {
      Object localObject;
      this.anI = localObject;
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      if (paramBundle != null) {}
      for (PendingIntent localPendingIntent = (PendingIntent)paramBundle.getParcelable("pendingIntent");; localPendingIntent = null)
      {
        Status localStatus = new Status(paramInt, null, localPendingIntent);
        e.this.a(new e.h(e.this, this.anI, localStatus));
        return;
      }
    }
  }
  
  final class h
    extends jl<d>.b<BaseImplementation.b<Status>>
  {
    private final Status Eb;
    
    public h(Status paramStatus)
    {
      super(paramStatus);
      Object localObject;
      this.Eb = localObject;
    }
    
    protected void hx() {}
    
    protected void m(BaseImplementation.b<Status> paramb)
    {
      e.this.disconnect();
      if (paramb != null) {
        paramb.b(this.Eb);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.e
 * JD-Core Version:    0.7.0.1
 */