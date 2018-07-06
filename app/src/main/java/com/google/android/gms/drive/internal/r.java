package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.c;
import com.google.android.gms.drive.events.d;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class r
  extends jl<ae>
{
  private final String DZ;
  private final String JK;
  private final Bundle PK;
  private final boolean PL;
  private DriveId PM;
  private DriveId PN;
  final GoogleApiClient.ConnectionCallbacks PO;
  final Map<DriveId, Map<c, aa>> PP = new HashMap();
  
  public r(Context paramContext, Looper paramLooper, jg paramjg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, Bundle paramBundle)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.DZ = ((String)jx.b(paramjg.hm(), "Must call Api.ClientBuilder.setAccountName()"));
    this.JK = paramjg.hq();
    this.PO = paramConnectionCallbacks;
    this.PK = paramBundle;
    Intent localIntent = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
    localIntent.setPackage(paramContext.getPackageName());
    List localList = paramContext.getPackageManager().queryIntentServices(localIntent, 0);
    switch (localList.size())
    {
    default: 
      throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + localIntent.getAction() + " action");
    case 0: 
      this.PL = false;
      return;
    }
    ServiceInfo localServiceInfo = ((ResolveInfo)localList.get(0)).serviceInfo;
    if (!localServiceInfo.exported) {
      throw new IllegalStateException("Drive event service " + localServiceInfo.name + " must be exported in AndroidManifest.xml");
    }
    this.PL = true;
  }
  
  protected ae W(IBinder paramIBinder)
  {
    return ae.a.X(paramIBinder);
  }
  
  PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt)
  {
    jx.b(d.a(paramInt, paramDriveId), "id");
    jx.a(isConnected(), "Client must be connected");
    if (!this.PL) {
      throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }
    paramGoogleApiClient.b(new q.a(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramAnonymousr.iG().a(new AddEventListenerRequest(paramDriveId, paramInt), null, null, new bg(this));
      }
    });
  }
  
  PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, c paramc)
  {
    jx.b(d.a(paramInt, paramDriveId), "id");
    jx.b(paramc, "listener");
    jx.a(isConnected(), "Client must be connected");
    for (;;)
    {
      Map localMap2;
      aa localaa1;
      synchronized (this.PP)
      {
        localMap2 = (Map)this.PP.get(paramDriveId);
        if (localMap2 != null) {
          break label209;
        }
        HashMap localHashMap = new HashMap();
        this.PP.put(paramDriveId, localHashMap);
        localObject2 = localHashMap;
        localaa1 = (aa)((Map)localObject2).get(paramc);
        if (localaa1 == null)
        {
          localaa2 = new aa(getLooper(), getContext(), paramInt, paramc);
          ((Map)localObject2).put(paramc, localaa2);
          localaa2.bw(paramInt);
          BaseImplementation.a locala = paramGoogleApiClient.b(new q.a(paramGoogleApiClient)
          {
            protected void a(r paramAnonymousr)
              throws RemoteException
            {
              paramAnonymousr.iG().a(new AddEventListenerRequest(paramDriveId, paramInt), localaa2, null, new bg(this));
            }
          });
          return locala;
        }
        if (localaa1.bx(paramInt))
        {
          p.j localj = new p.j(paramGoogleApiClient, Status.Kw);
          return localj;
        }
      }
      final aa localaa2 = localaa1;
      continue;
      label209:
      Object localObject2 = localMap2;
    }
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.PM = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.PN = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    String str = getContext().getPackageName();
    jx.i(parame);
    jx.i(str);
    jx.i(hv());
    Bundle localBundle = new Bundle();
    if (!str.equals(this.JK)) {
      localBundle.putString("proxy_package_name", this.JK);
    }
    localBundle.putAll(this.PK);
    paramjt.a(parame, 6587000, str, hv(), this.DZ, localBundle);
  }
  
  PendingResult<Status> b(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt)
  {
    jx.b(d.a(paramInt, paramDriveId), "id");
    jx.a(isConnected(), "Client must be connected");
    paramGoogleApiClient.b(new q.a(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramAnonymousr.iG().a(new RemoveEventListenerRequest(paramDriveId, paramInt), null, null, new bg(this));
      }
    });
  }
  
  PendingResult<Status> b(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, c paramc)
  {
    jx.b(d.a(paramInt, paramDriveId), "id");
    jx.a(isConnected(), "Client must be connected");
    jx.b(paramc, "listener");
    Map localMap2;
    final aa localaa;
    synchronized (this.PP)
    {
      localMap2 = (Map)this.PP.get(paramDriveId);
      if (localMap2 == null)
      {
        p.j localj1 = new p.j(paramGoogleApiClient, Status.Kw);
        return localj1;
      }
      localaa = (aa)localMap2.remove(paramc);
      if (localaa == null)
      {
        p.j localj2 = new p.j(paramGoogleApiClient, Status.Kw);
        return localj2;
      }
    }
    if (localMap2.isEmpty()) {
      this.PP.remove(paramDriveId);
    }
    BaseImplementation.a locala = paramGoogleApiClient.b(new q.a(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramAnonymousr.iG().a(new RemoveEventListenerRequest(paramDriveId, paramInt), localaa, null, new bg(this));
      }
    });
    return locala;
  }
  
  protected String bK()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  PendingResult<Status> cancelPendingActions(GoogleApiClient paramGoogleApiClient, final List<String> paramList)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramList != null)
    {
      bool2 = bool1;
      jx.L(bool2);
      if (paramList.isEmpty()) {
        break label59;
      }
    }
    for (;;)
    {
      jx.L(bool1);
      jx.a(isConnected(), "Client must be connected");
      paramGoogleApiClient.b(new q.a(paramGoogleApiClient)
      {
        protected void a(r paramAnonymousr)
          throws RemoteException
        {
          paramAnonymousr.iG().a(new CancelPendingActionsRequest(paramList), new bg(this));
        }
      });
      bool2 = false;
      break;
      label59:
      bool1 = false;
    }
  }
  
  public void disconnect()
  {
    if (isConnected()) {}
    try
    {
      ((ae)hw()).a(new DisconnectRequest());
      label26:
      super.disconnect();
      this.PP.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label26;
    }
  }
  
  public ae iG()
    throws DeadObjectException
  {
    return (ae)hw();
  }
  
  public DriveId iH()
  {
    return this.PM;
  }
  
  public DriveId iI()
  {
    return this.PN;
  }
  
  public boolean iJ()
  {
    return this.PL;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.r
 * JD-Core Version:    0.7.0.1
 */