package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;

public final class ib
  extends jl<id>
{
  private final String DZ;
  
  public ib(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.DZ = ((String)jx.i(paramString));
  }
  
  protected id H(IBinder paramIBinder)
  {
    return id.a.J(paramIBinder);
  }
  
  public void a(BaseImplementation.b<AppStateManager.StateListResult> paramb)
  {
    try
    {
      ((id)hw()).a(new c(paramb));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void a(BaseImplementation.b<AppStateManager.StateDeletedResult> paramb, int paramInt)
  {
    try
    {
      ((id)hw()).b(new a(paramb), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void a(BaseImplementation.b<AppStateManager.StateResult> paramb, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      ((id)hw()).a(new e(paramb), paramInt, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void a(BaseImplementation.b<AppStateManager.StateResult> paramb, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramb == null) {}
    for (Object localObject = null;; localObject = locale)
    {
      try
      {
        ((id)hw()).a((ic)localObject, paramInt, paramArrayOfByte);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        e locale;
        Log.w("AppStateClient", "service died");
      }
      locale = new e(paramb);
    }
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    paramjt.a(parame, 6587000, getContext().getPackageName(), this.DZ, hv());
  }
  
  public void b(BaseImplementation.b<Status> paramb)
  {
    try
    {
      ((id)hw()).b(new g(paramb));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void b(BaseImplementation.b<AppStateManager.StateResult> paramb, int paramInt)
  {
    try
    {
      ((id)hw()).a(new e(paramb), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  protected String bK()
  {
    return "com.google.android.gms.appstate.service.START";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.appstate.internal.IAppStateService";
  }
  
  protected void c(String... paramVarArgs)
  {
    int i = 0;
    boolean bool = false;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals("https://www.googleapis.com/auth/appstate")) {
        bool = true;
      }
      i++;
    }
    jx.a(bool, String.format("App State APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/appstate" }));
  }
  
  public int fL()
  {
    try
    {
      int i = ((id)hw()).fL();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
    return 2;
  }
  
  public int fM()
  {
    try
    {
      int i = ((id)hw()).fM();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
    return 2;
  }
  
  private static final class a
    extends ia
  {
    private final BaseImplementation.b<AppStateManager.StateDeletedResult> Ea;
    
    public a(BaseImplementation.b<AppStateManager.StateDeletedResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Result holder must not be null"));
    }
    
    public void e(int paramInt1, int paramInt2)
    {
      Status localStatus = new Status(paramInt1);
      this.Ea.b(new ib.b(localStatus, paramInt2));
    }
  }
  
  private static final class b
    implements AppStateManager.StateDeletedResult
  {
    private final Status Eb;
    private final int Ec;
    
    public b(Status paramStatus, int paramInt)
    {
      this.Eb = paramStatus;
      this.Ec = paramInt;
    }
    
    public int getStateKey()
    {
      return this.Ec;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  private static final class c
    extends ia
  {
    private final BaseImplementation.b<AppStateManager.StateListResult> Ea;
    
    public c(BaseImplementation.b<AppStateManager.StateListResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Result holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder)
    {
      this.Ea.b(new ib.d(paramDataHolder));
    }
  }
  
  private static final class d
    extends b
    implements AppStateManager.StateListResult
  {
    private final AppStateBuffer Ed;
    
    public d(DataHolder paramDataHolder)
    {
      super();
      this.Ed = new AppStateBuffer(paramDataHolder);
    }
    
    public AppStateBuffer getStateBuffer()
    {
      return this.Ed;
    }
  }
  
  private static final class e
    extends ia
  {
    private final BaseImplementation.b<AppStateManager.StateResult> Ea;
    
    public e(BaseImplementation.b<AppStateManager.StateResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Result holder must not be null"));
    }
    
    public void a(int paramInt, DataHolder paramDataHolder)
    {
      this.Ea.b(new ib.f(paramInt, paramDataHolder));
    }
  }
  
  private static final class f
    extends b
    implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult
  {
    private final int Ec;
    private final AppStateBuffer Ed;
    
    public f(int paramInt, DataHolder paramDataHolder)
    {
      super();
      this.Ec = paramInt;
      this.Ed = new AppStateBuffer(paramDataHolder);
    }
    
    private boolean fN()
    {
      return this.Eb.getStatusCode() == 2000;
    }
    
    public AppStateManager.StateConflictResult getConflictResult()
    {
      if (fN()) {
        return this;
      }
      return null;
    }
    
    public AppStateManager.StateLoadedResult getLoadedResult()
    {
      if (fN()) {
        this = null;
      }
      return this;
    }
    
    public byte[] getLocalData()
    {
      if (this.Ed.getCount() == 0) {
        return null;
      }
      return this.Ed.get(0).getLocalData();
    }
    
    public String getResolvedVersion()
    {
      if (this.Ed.getCount() == 0) {
        return null;
      }
      return this.Ed.get(0).getConflictVersion();
    }
    
    public byte[] getServerData()
    {
      if (this.Ed.getCount() == 0) {
        return null;
      }
      return this.Ed.get(0).getConflictData();
    }
    
    public int getStateKey()
    {
      return this.Ec;
    }
    
    public void release()
    {
      this.Ed.release();
    }
  }
  
  private static final class g
    extends ia
  {
    private final BaseImplementation.b<Status> Ea;
    
    public g(BaseImplementation.b<Status> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void fK()
    {
      Status localStatus = new Status(0);
      this.Ea.b(localStatus);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ib
 * JD-Core Version:    0.7.0.1
 */