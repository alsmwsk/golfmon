package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class im
  extends jl<iq>
{
  private static final Object HB = new Object();
  private static final Object HC = new Object();
  private static final is Hh = new is("CastClientImpl");
  private final Cast.Listener FD;
  private double Gp;
  private boolean Gq;
  private BaseImplementation.b<Status> HA;
  private ApplicationMetadata Hi;
  private final CastDevice Hj;
  private final Map<String, Cast.MessageReceivedCallback> Hk;
  private final long Hl;
  private c Hm;
  private String Hn;
  private boolean Ho;
  private boolean Hp;
  private boolean Hq;
  private int Hr;
  private int Hs;
  private final AtomicLong Ht;
  private String Hu;
  private String Hv;
  private Bundle Hw;
  private final Map<Long, BaseImplementation.b<Status>> Hx;
  private final b Hy;
  private BaseImplementation.b<Cast.ApplicationConnectionResult> Hz;
  private final Handler mHandler;
  
  public im(Context paramContext, Looper paramLooper, CastDevice paramCastDevice, long paramLong, Cast.Listener paramListener, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
    this.Hj = paramCastDevice;
    this.FD = paramListener;
    this.Hl = paramLong;
    this.mHandler = new Handler(paramLooper);
    this.Hk = new HashMap();
    this.Ht = new AtomicLong(0L);
    this.Hx = new HashMap();
    fW();
    this.Hy = new b(null);
    registerConnectionFailedListener(this.Hy);
  }
  
  private void a(ij paramij)
  {
    String str = paramij.fT();
    if (!in.a(str, this.Hn)) {
      this.Hn = str;
    }
    for (boolean bool = true;; bool = false)
    {
      is localis = Hh;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Boolean.valueOf(bool);
      arrayOfObject[1] = Boolean.valueOf(this.Ho);
      localis.b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", arrayOfObject);
      if ((this.FD != null) && ((bool) || (this.Ho))) {
        this.FD.onApplicationStatusChanged();
      }
      this.Ho = false;
      return;
    }
  }
  
  private void a(io paramio)
  {
    ApplicationMetadata localApplicationMetadata = paramio.getApplicationMetadata();
    if (!in.a(localApplicationMetadata, this.Hi))
    {
      this.Hi = localApplicationMetadata;
      this.FD.onApplicationMetadataChanged(this.Hi);
    }
    double d = paramio.fZ();
    if ((d != (0.0D / 0.0D)) && (d != this.Gp)) {
      this.Gp = d;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramio.gi();
      if (bool2 != this.Gq)
      {
        this.Gq = bool2;
        bool1 = true;
      }
      is localis1 = Hh;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Boolean.valueOf(bool1);
      arrayOfObject1[1] = Boolean.valueOf(this.Hp);
      localis1.b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", arrayOfObject1);
      if ((this.FD != null) && ((bool1) || (this.Hp))) {
        this.FD.onVolumeChanged();
      }
      int i = paramio.gj();
      if (i != this.Hr) {
        this.Hr = i;
      }
      for (boolean bool3 = true;; bool3 = false)
      {
        is localis2 = Hh;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Boolean.valueOf(bool3);
        arrayOfObject2[1] = Boolean.valueOf(this.Hp);
        localis2.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", arrayOfObject2);
        if ((this.FD != null) && ((bool3) || (this.Hp))) {
          this.FD.X(this.Hr);
        }
        int j = paramio.gk();
        if (j != this.Hs) {
          this.Hs = j;
        }
        for (boolean bool4 = true;; bool4 = false)
        {
          is localis3 = Hh;
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = Boolean.valueOf(bool4);
          arrayOfObject3[1] = Boolean.valueOf(this.Hp);
          localis3.b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", arrayOfObject3);
          if ((this.FD != null) && ((bool4) || (this.Hp))) {
            this.FD.Y(this.Hs);
          }
          this.Hp = false;
          return;
        }
      }
    }
  }
  
  private void c(BaseImplementation.b<Cast.ApplicationConnectionResult> paramb)
  {
    synchronized (HB)
    {
      if (this.Hz != null) {
        this.Hz.b(new a(new Status(2002)));
      }
      this.Hz = paramb;
      return;
    }
  }
  
  private void e(BaseImplementation.b<Status> paramb)
  {
    synchronized (HC)
    {
      if (this.HA != null)
      {
        paramb.b(new Status(2001));
        return;
      }
      this.HA = paramb;
      return;
    }
  }
  
  private void fW()
  {
    this.Hq = false;
    this.Hr = -1;
    this.Hs = -1;
    this.Hi = null;
    this.Hn = null;
    this.Gp = 0.0D;
    this.Gq = false;
  }
  
  private void ga()
  {
    Hh.b("removing all MessageReceivedCallbacks", new Object[0]);
    synchronized (this.Hk)
    {
      this.Hk.clear();
      return;
    }
  }
  
  private void gb()
    throws IllegalStateException
  {
    if ((!this.Hq) || (this.Hm == null) || (this.Hm.gh())) {
      throw new IllegalStateException("Not connected to a device");
    }
  }
  
  public void I(boolean paramBoolean)
    throws IllegalStateException, RemoteException
  {
    ((iq)hw()).a(paramBoolean, this.Gp, this.Gq);
  }
  
  protected iq L(IBinder paramIBinder)
  {
    return iq.a.M(paramIBinder);
  }
  
  public void a(double paramDouble)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    ((iq)hw()).a(paramDouble, this.Gp, this.Gq);
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    is localis = Hh;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localis.b("in onPostInitHandler; statusCode=%d", arrayOfObject);
    if ((paramInt == 0) || (paramInt == 1001))
    {
      this.Hq = true;
      this.Ho = true;
      this.Hp = true;
    }
    for (;;)
    {
      if (paramInt == 1001)
      {
        this.Hw = new Bundle();
        this.Hw.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
        paramInt = 0;
      }
      super.a(paramInt, paramIBinder, paramBundle);
      return;
      this.Hq = false;
    }
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    is localis = Hh;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.Hu;
    arrayOfObject[1] = this.Hv;
    localis.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", arrayOfObject);
    this.Hj.putInBundle(localBundle);
    localBundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.Hl);
    if (this.Hu != null)
    {
      localBundle.putString("last_application_id", this.Hu);
      if (this.Hv != null) {
        localBundle.putString("last_session_id", this.Hv);
      }
    }
    this.Hm = new c(null);
    paramjt.a(parame, 6587000, getContext().getPackageName(), this.Hm.asBinder(), localBundle);
  }
  
  public void a(String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    in.aF(paramString);
    aE(paramString);
    if (paramMessageReceivedCallback != null) {}
    synchronized (this.Hk)
    {
      this.Hk.put(paramString, paramMessageReceivedCallback);
      ((iq)hw()).aI(paramString);
      return;
    }
  }
  
  public void a(String paramString, LaunchOptions paramLaunchOptions, BaseImplementation.b<Cast.ApplicationConnectionResult> paramb)
    throws IllegalStateException, RemoteException
  {
    c(paramb);
    ((iq)hw()).a(paramString, paramLaunchOptions);
  }
  
  public void a(String paramString, BaseImplementation.b<Status> paramb)
    throws IllegalStateException, RemoteException
  {
    e(paramb);
    ((iq)hw()).aH(paramString);
  }
  
  public void a(String paramString1, String paramString2, BaseImplementation.b<Status> paramb)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("The message payload cannot be null or empty");
    }
    if (paramString2.length() > 65536) {
      throw new IllegalArgumentException("Message exceeds maximum size");
    }
    in.aF(paramString1);
    gb();
    long l = this.Ht.incrementAndGet();
    try
    {
      this.Hx.put(Long.valueOf(l), paramb);
      ((iq)hw()).a(paramString1, paramString2, l);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.Hx.remove(Long.valueOf(l));
      throw localThrowable;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, BaseImplementation.b<Cast.ApplicationConnectionResult> paramb)
    throws IllegalStateException, RemoteException
  {
    c(paramb);
    ((iq)hw()).g(paramString, paramBoolean);
  }
  
  public void aE(String paramString)
    throws IllegalArgumentException, RemoteException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }
    synchronized (this.Hk)
    {
      Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)this.Hk.remove(paramString);
      if (localMessageReceivedCallback == null) {}
    }
    is localis;
    Object[] arrayOfObject;
  }
  
  public void b(String paramString1, String paramString2, BaseImplementation.b<Cast.ApplicationConnectionResult> paramb)
    throws IllegalStateException, RemoteException
  {
    c(paramb);
    ((iq)hw()).k(paramString1, paramString2);
  }
  
  protected String bK()
  {
    return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.cast.internal.ICastDeviceController";
  }
  
  public void d(BaseImplementation.b<Status> paramb)
    throws IllegalStateException, RemoteException
  {
    e(paramb);
    ((iq)hw()).gl();
  }
  
  public void disconnect()
  {
    is localis1 = Hh;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this.Hm;
    arrayOfObject1[1] = Boolean.valueOf(isConnected());
    localis1.b("disconnect(); ServiceListener=%s, isConnected=%b", arrayOfObject1);
    c localc = this.Hm;
    this.Hm = null;
    if ((localc == null) || (!localc.gg()))
    {
      Hh.b("already disposed, so short-circuiting", new Object[0]);
      return;
    }
    ga();
    try
    {
      if ((isConnected()) || (isConnecting())) {
        ((iq)hw()).disconnect();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      is localis2 = Hh;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localRemoteException.getMessage();
      localis2.a(localRemoteException, "Error while disconnecting the controller interface: %s", arrayOfObject2);
      return;
    }
    finally
    {
      super.disconnect();
    }
  }
  
  public Bundle fX()
  {
    if (this.Hw != null)
    {
      Bundle localBundle = this.Hw;
      this.Hw = null;
      return localBundle;
    }
    return super.fX();
  }
  
  public void fY()
    throws IllegalStateException, RemoteException
  {
    ((iq)hw()).fY();
  }
  
  public double fZ()
    throws IllegalStateException
  {
    gb();
    return this.Gp;
  }
  
  public ApplicationMetadata getApplicationMetadata()
    throws IllegalStateException
  {
    gb();
    return this.Hi;
  }
  
  public String getApplicationStatus()
    throws IllegalStateException
  {
    gb();
    return this.Hn;
  }
  
  public boolean isMute()
    throws IllegalStateException
  {
    gb();
    return this.Gq;
  }
  
  private static final class a
    implements Cast.ApplicationConnectionResult
  {
    private final Status Eb;
    private final ApplicationMetadata HD;
    private final String HE;
    private final boolean HF;
    private final String vZ;
    
    public a(Status paramStatus)
    {
      this(paramStatus, null, null, null, false);
    }
    
    public a(Status paramStatus, ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.Eb = paramStatus;
      this.HD = paramApplicationMetadata;
      this.HE = paramString1;
      this.vZ = paramString2;
      this.HF = paramBoolean;
    }
    
    public ApplicationMetadata getApplicationMetadata()
    {
      return this.HD;
    }
    
    public String getApplicationStatus()
    {
      return this.HE;
    }
    
    public String getSessionId()
    {
      return this.vZ;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
    
    public boolean getWasLaunched()
    {
      return this.HF;
    }
  }
  
  private class b
    implements GoogleApiClient.OnConnectionFailedListener
  {
    private b() {}
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      im.b(im.this);
    }
  }
  
  private class c
    extends ir.a
  {
    private final AtomicBoolean HH = new AtomicBoolean(false);
    
    private c() {}
    
    private boolean ah(int paramInt)
    {
      synchronized ()
      {
        if (im.j(im.this) != null)
        {
          im.j(im.this).b(new Status(paramInt));
          im.b(im.this, null);
          return true;
        }
        return false;
      }
    }
    
    private void c(long paramLong, int paramInt)
    {
      synchronized (im.i(im.this))
      {
        BaseImplementation.b localb = (BaseImplementation.b)im.i(im.this).remove(Long.valueOf(paramLong));
        if (localb != null) {
          localb.b(new Status(paramInt));
        }
        return;
      }
    }
    
    public void a(ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    {
      if (this.HH.get()) {
        return;
      }
      im.a(im.this, paramApplicationMetadata);
      im.a(im.this, paramApplicationMetadata.getApplicationId());
      im.b(im.this, paramString2);
      synchronized (im.ge())
      {
        if (im.d(im.this) != null)
        {
          im.d(im.this).b(new im.a(new Status(0), paramApplicationMetadata, paramString1, paramString2, paramBoolean));
          im.a(im.this, null);
        }
        return;
      }
    }
    
    public void a(String paramString, double paramDouble, boolean paramBoolean)
    {
      im.gd().b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }
    
    public void a(String paramString, long paramLong)
    {
      if (this.HH.get()) {
        return;
      }
      c(paramLong, 0);
    }
    
    public void a(String paramString, long paramLong, int paramInt)
    {
      if (this.HH.get()) {
        return;
      }
      c(paramLong, paramInt);
    }
    
    public void ad(int paramInt)
    {
      if (!gg()) {}
      do
      {
        return;
        is localis = im.gd();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        localis.b("ICastDeviceControllerListener.onDisconnected: %d", arrayOfObject);
      } while (paramInt == 0);
      im.this.aD(2);
    }
    
    public void ae(int paramInt)
    {
      if (this.HH.get()) {
        return;
      }
      synchronized (im.ge())
      {
        if (im.d(im.this) != null)
        {
          im.d(im.this).b(new im.a(new Status(paramInt)));
          im.a(im.this, null);
        }
        return;
      }
    }
    
    public void af(int paramInt)
    {
      if (this.HH.get()) {
        return;
      }
      ah(paramInt);
    }
    
    public void ag(int paramInt)
    {
      if (this.HH.get()) {
        return;
      }
      ah(paramInt);
    }
    
    public void b(final ij paramij)
    {
      if (this.HH.get()) {
        return;
      }
      im.gd().b("onApplicationStatusChanged", new Object[0]);
      im.f(im.this).post(new Runnable()
      {
        public void run()
        {
          im.a(im.this, paramij);
        }
      });
    }
    
    public void b(final io paramio)
    {
      if (this.HH.get()) {
        return;
      }
      im.gd().b("onDeviceStatusChanged", new Object[0]);
      im.f(im.this).post(new Runnable()
      {
        public void run()
        {
          im.a(im.this, paramio);
        }
      });
    }
    
    public void b(String paramString, byte[] paramArrayOfByte)
    {
      if (this.HH.get()) {
        return;
      }
      is localis = im.gd();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(paramArrayOfByte.length);
      localis.b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", arrayOfObject);
    }
    
    public boolean gg()
    {
      if (this.HH.getAndSet(true)) {
        return false;
      }
      im.c(im.this);
      return true;
    }
    
    public boolean gh()
    {
      return this.HH.get();
    }
    
    public void j(final String paramString1, final String paramString2)
    {
      if (this.HH.get()) {
        return;
      }
      im.gd().b("Receive (type=text, ns=%s) %s", new Object[] { paramString1, paramString2 });
      im.f(im.this).post(new Runnable()
      {
        public void run()
        {
          synchronized (im.g(im.this))
          {
            Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)im.g(im.this).get(paramString1);
            if (localMessageReceivedCallback != null)
            {
              localMessageReceivedCallback.onMessageReceived(im.h(im.this), paramString1, paramString2);
              return;
            }
          }
          is localis = im.gd();
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = paramString1;
          localis.b("Discarded message for unknown namespace '%s'", arrayOfObject);
        }
      });
    }
    
    public void onApplicationDisconnected(final int paramInt)
    {
      if (this.HH.get()) {}
      do
      {
        return;
        im.a(im.this, null);
        im.b(im.this, null);
        ah(paramInt);
      } while (im.e(im.this) == null);
      im.f(im.this).post(new Runnable()
      {
        public void run()
        {
          if (im.e(im.this) != null) {
            im.e(im.this).onApplicationDisconnected(paramInt);
          }
        }
      });
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.im
 * JD-Core Version:    0.7.0.1
 */