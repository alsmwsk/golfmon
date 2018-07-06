package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class jl<T extends IInterface>
  implements Api.a, jm.b
{
  public static final String[] MP = { "service_esmobile", "service_googleme" };
  private final Looper JF;
  private final jm JS;
  private T MJ;
  private final ArrayList<jl<T>.b<?>> MK = new ArrayList();
  private jl<T>.f ML;
  private int MM = 1;
  private final String[] MN;
  boolean MO = false;
  private final Context mContext;
  private final Object mH = new Object();
  final Handler mHandler;
  
  protected jl(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this.mContext = ((Context)jx.i(paramContext));
    this.JF = ((Looper)jx.b(paramLooper, "Looper must not be null"));
    this.JS = new jm(paramContext, paramLooper, this);
    this.mHandler = new a(paramLooper);
    c(paramVarArgs);
    this.MN = paramVarArgs;
    registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)jx.i(paramConnectionCallbacks));
    registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)jx.i(paramOnConnectionFailedListener));
  }
  
  @Deprecated
  protected jl(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this(paramContext, paramContext.getMainLooper(), new c(paramConnectionCallbacks), new g(paramOnConnectionFailedListener), paramVarArgs);
  }
  
  private void a(int paramInt, T paramT)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (paramInt == 3)
    {
      bool2 = bool1;
      if (paramT == null) {
        break label65;
      }
      bool3 = bool1;
      label17:
      if (bool2 != bool3) {
        break label71;
      }
    }
    for (;;)
    {
      jx.L(bool1);
      synchronized (this.mH)
      {
        this.MM = paramInt;
        this.MJ = paramT;
        return;
      }
      bool2 = false;
      break;
      label65:
      bool3 = false;
      break label17;
      label71:
      bool1 = false;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.mH)
    {
      if (this.MM != paramInt1) {
        return false;
      }
      a(paramInt2, paramT);
      return true;
    }
  }
  
  protected final void N(IBinder paramIBinder)
  {
    try
    {
      a(jt.a.Q(paramIBinder), new e(this));
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      Log.w("GmsClient", "service died");
      aD(1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("GmsClient", "Remote exception occurred", localRemoteException);
    }
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new h(paramInt, paramIBinder, paramBundle)));
  }
  
  @Deprecated
  public final void a(jl<T>.b<?> paramjl)
  {
    synchronized (this.MK)
    {
      this.MK.add(paramjl);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(2, paramjl));
      return;
    }
  }
  
  protected abstract void a(jt paramjt, e parame)
    throws RemoteException;
  
  public void aD(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(paramInt)));
  }
  
  protected abstract String bK();
  
  protected abstract String bL();
  
  protected void c(String... paramVarArgs) {}
  
  public void connect()
  {
    this.MO = true;
    a(2, null);
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
    if (i != 0)
    {
      a(1, null);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(i)));
    }
    do
    {
      return;
      if (this.ML != null)
      {
        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + bK());
        jn.J(this.mContext).b(bK(), this.ML);
      }
      this.ML = new f();
    } while (jn.J(this.mContext).a(bK(), this.ML));
    Log.e("GmsClient", "unable to connect to service: " + bK());
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
  }
  
  protected final void dS()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void disconnect()
  {
    this.MO = false;
    synchronized (this.MK)
    {
      int i = this.MK.size();
      for (int j = 0; j < i; j++) {
        ((b)this.MK.get(j)).hz();
      }
      this.MK.clear();
      a(1, null);
      if (this.ML != null)
      {
        jn.J(this.mContext).b(bK(), this.ML);
        this.ML = null;
      }
      return;
    }
  }
  
  public Bundle fX()
  {
    return null;
  }
  
  public boolean gN()
  {
    return this.MO;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.JF;
  }
  
  public final String[] hv()
  {
    return this.MN;
  }
  
  public final T hw()
    throws DeadObjectException
  {
    synchronized (this.mH)
    {
      if (this.MM == 4) {
        throw new DeadObjectException();
      }
    }
    dS();
    if (this.MJ != null) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Client is connected but service is null");
      IInterface localIInterface = this.MJ;
      return localIInterface;
    }
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.mH)
      {
        if (this.MM == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (;;)
    {
      synchronized (this.mH)
      {
        if (this.MM == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.JS.isConnectionCallbacksRegistered(new c(paramConnectionCallbacks));
  }
  
  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.JS.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  protected abstract T l(IBinder paramIBinder);
  
  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.JS.registerConnectionCallbacks(new c(paramConnectionCallbacks));
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.JS.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.JS.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.JS.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.JS.unregisterConnectionCallbacks(new c(paramConnectionCallbacks));
  }
  
  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.JS.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.what == 1) && (!jl.this.isConnecting()))
      {
        jl.b localb2 = (jl.b)paramMessage.obj;
        localb2.hx();
        localb2.unregister();
        return;
      }
      if (paramMessage.what == 3)
      {
        jl.a(jl.this).b(new ConnectionResult(((Integer)paramMessage.obj).intValue(), null));
        return;
      }
      if (paramMessage.what == 4)
      {
        jl.a(jl.this, 4, null);
        jl.a(jl.this).aE(((Integer)paramMessage.obj).intValue());
        jl.a(jl.this, 4, 1, null);
        return;
      }
      if ((paramMessage.what == 2) && (!jl.this.isConnected()))
      {
        jl.b localb1 = (jl.b)paramMessage.obj;
        localb1.hx();
        localb1.unregister();
        return;
      }
      if ((paramMessage.what == 2) || (paramMessage.what == 1))
      {
        ((jl.b)paramMessage.obj).hy();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
  }
  
  protected abstract class b<TListener>
  {
    private boolean MR;
    private TListener mListener;
    
    public b()
    {
      Object localObject;
      this.mListener = localObject;
      this.MR = false;
    }
    
    protected abstract void g(TListener paramTListener);
    
    protected abstract void hx();
    
    /* Error */
    public void hy()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 21	com/google/android/gms/internal/jl$b:mListener	Ljava/lang/Object;
      //   6: astore_2
      //   7: aload_0
      //   8: getfield 23	com/google/android/gms/internal/jl$b:MR	Z
      //   11: ifeq +33 -> 44
      //   14: ldc 31
      //   16: new 33	java/lang/StringBuilder
      //   19: dup
      //   20: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   23: ldc 36
      //   25: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: aload_0
      //   29: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   32: ldc 45
      //   34: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 55	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   43: pop
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_2
      //   47: ifnull +36 -> 83
      //   50: aload_0
      //   51: aload_2
      //   52: invokevirtual 57	com/google/android/gms/internal/jl$b:g	(Ljava/lang/Object;)V
      //   55: aload_0
      //   56: monitorenter
      //   57: aload_0
      //   58: iconst_1
      //   59: putfield 23	com/google/android/gms/internal/jl$b:MR	Z
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_0
      //   65: invokevirtual 60	com/google/android/gms/internal/jl$b:unregister	()V
      //   68: return
      //   69: astore_1
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_1
      //   73: athrow
      //   74: astore 4
      //   76: aload_0
      //   77: invokevirtual 62	com/google/android/gms/internal/jl$b:hx	()V
      //   80: aload 4
      //   82: athrow
      //   83: aload_0
      //   84: invokevirtual 62	com/google/android/gms/internal/jl$b:hx	()V
      //   87: goto -32 -> 55
      //   90: astore_3
      //   91: aload_0
      //   92: monitorexit
      //   93: aload_3
      //   94: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	95	0	this	b
      //   69	4	1	localObject1	Object
      //   6	46	2	localObject2	Object
      //   90	4	3	localObject3	Object
      //   74	7	4	localRuntimeException	java.lang.RuntimeException
      // Exception table:
      //   from	to	target	type
      //   2	44	69	finally
      //   44	46	69	finally
      //   70	72	69	finally
      //   50	55	74	java/lang/RuntimeException
      //   57	64	90	finally
      //   91	93	90	finally
    }
    
    public void hz()
    {
      try
      {
        this.mListener = null;
        return;
      }
      finally {}
    }
    
    public void unregister()
    {
      hz();
      synchronized (jl.b(jl.this))
      {
        jl.b(jl.this).remove(this);
        return;
      }
    }
  }
  
  public static final class c
    implements GoogleApiClient.ConnectionCallbacks
  {
    private final GooglePlayServicesClient.ConnectionCallbacks MS;
    
    public c(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      this.MS = paramConnectionCallbacks;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof c)) {
        return this.MS.equals(((c)paramObject).MS);
      }
      return this.MS.equals(paramObject);
    }
    
    public void onConnected(Bundle paramBundle)
    {
      this.MS.onConnected(paramBundle);
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      this.MS.onDisconnected();
    }
  }
  
  public abstract class d<TListener>
    extends jl<T>.b<TListener>
  {
    private final DataHolder JG;
    
    public d(DataHolder paramDataHolder)
    {
      super(paramDataHolder);
      Object localObject;
      this.JG = localObject;
    }
    
    protected abstract void b(TListener paramTListener, DataHolder paramDataHolder);
    
    protected final void g(TListener paramTListener)
    {
      b(paramTListener, this.JG);
    }
    
    protected void hx()
    {
      if (this.JG != null) {
        this.JG.close();
      }
    }
  }
  
  public static final class e
    extends js.a
  {
    private jl MT;
    
    public e(jl paramjl)
    {
      this.MT = paramjl;
    }
    
    public void b(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      jx.b("onPostInitComplete can be called only once per call to getServiceFromBroker", this.MT);
      this.MT.a(paramInt, paramIBinder, paramBundle);
      this.MT = null;
    }
  }
  
  public final class f
    implements ServiceConnection
  {
    public f() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      jl.this.N(paramIBinder);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      jl.this.mHandler.sendMessage(jl.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
    }
  }
  
  public static final class g
    implements GoogleApiClient.OnConnectionFailedListener
  {
    private final GooglePlayServicesClient.OnConnectionFailedListener MU;
    
    public g(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.MU = paramOnConnectionFailedListener;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof g)) {
        return this.MU.equals(((g)paramObject).MU);
      }
      return this.MU.equals(paramObject);
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.MU.onConnectionFailed(paramConnectionResult);
    }
  }
  
  protected final class h
    extends jl<T>.b<Boolean>
  {
    public final Bundle MV;
    public final IBinder MW;
    public final int statusCode;
    
    public h(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.MW = paramIBinder;
      this.MV = paramBundle;
    }
    
    protected void b(Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        jl.a(jl.this, 1, null);
        return;
      }
      switch (this.statusCode)
      {
      default: 
        if (this.MV == null) {
          break;
        }
      }
      for (PendingIntent localPendingIntent = (PendingIntent)this.MV.getParcelable("pendingIntent");; localPendingIntent = null)
      {
        if (jl.c(jl.this) != null)
        {
          jn.J(jl.d(jl.this)).b(jl.this.bK(), jl.c(jl.this));
          jl.a(jl.this, null);
        }
        jl.a(jl.this, 1, null);
        jl.a(jl.this).b(new ConnectionResult(this.statusCode, localPendingIntent));
        return;
        try
        {
          String str = this.MW.getInterfaceDescriptor();
          if (jl.this.bL().equals(str))
          {
            IInterface localIInterface = jl.this.l(this.MW);
            if (localIInterface != null)
            {
              jl.a(jl.this, 3, localIInterface);
              jl.a(jl.this).dU();
              return;
            }
          }
        }
        catch (RemoteException localRemoteException)
        {
          jn.J(jl.d(jl.this)).b(jl.this.bK(), jl.c(jl.this));
          jl.a(jl.this, null);
          jl.a(jl.this, 1, null);
          jl.a(jl.this).b(new ConnectionResult(8, null));
          return;
        }
        jl.a(jl.this, 1, null);
        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
      }
    }
    
    protected void hx() {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jl
 * JD-Core Version:    0.7.0.1
 */