package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class jn
  implements Handler.Callback
{
  private static final Object Nd = new Object();
  private static jn Ne;
  private final HashMap<String, a> Nf = new HashMap();
  private final Handler mHandler = new Handler(paramContext.getMainLooper(), this);
  private final Context mO;
  
  private jn(Context paramContext)
  {
    this.mO = paramContext.getApplicationContext();
  }
  
  public static jn J(Context paramContext)
  {
    synchronized (Nd)
    {
      if (Ne == null) {
        Ne = new jn(paramContext.getApplicationContext());
      }
      return Ne;
    }
  }
  
  public boolean a(String paramString, jl<?>.f paramjl)
  {
    for (;;)
    {
      a locala;
      synchronized (this.Nf)
      {
        locala = (a)this.Nf.get(paramString);
        if (locala == null)
        {
          locala = new a(paramString);
          locala.a(paramjl);
          locala.hA();
          this.Nf.put(paramString, locala);
          boolean bool = locala.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, locala);
        if (locala.c(paramjl)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + paramString);
        }
      }
      locala.a(paramjl);
      switch (locala.getState())
      {
      case 1: 
        paramjl.onServiceConnected(locala.getComponentName(), locala.getBinder());
        break;
      case 2: 
        locala.hA();
      }
    }
  }
  
  public void b(String paramString, jl<?>.f paramjl)
  {
    a locala;
    synchronized (this.Nf)
    {
      locala = (a)this.Nf.get(paramString);
      if (locala == null) {
        throw new IllegalStateException("Nonexistent connection status for service action: " + paramString);
      }
    }
    if (!locala.c(paramjl)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + paramString);
    }
    locala.b(paramjl);
    if (locala.hD())
    {
      Message localMessage = this.mHandler.obtainMessage(0, locala);
      this.mHandler.sendMessageDelayed(localMessage, 5000L);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    a locala = (a)paramMessage.obj;
    synchronized (this.Nf)
    {
      if (locala.hD())
      {
        locala.hB();
        this.Nf.remove(locala.hC());
      }
      return true;
    }
  }
  
  final class a
  {
    private final String Ng;
    private final a Nh;
    private final HashSet<jl<?>.f> Ni;
    private boolean Nj;
    private IBinder Nk;
    private ComponentName Nl;
    private int mState;
    
    public a(String paramString)
    {
      this.Ng = paramString;
      this.Nh = new a();
      this.Ni = new HashSet();
      this.mState = 2;
    }
    
    public void a(jl<?>.f paramjl)
    {
      this.Ni.add(paramjl);
    }
    
    public void b(jl<?>.f paramjl)
    {
      this.Ni.remove(paramjl);
    }
    
    public boolean c(jl<?>.f paramjl)
    {
      return this.Ni.contains(paramjl);
    }
    
    public IBinder getBinder()
    {
      return this.Nk;
    }
    
    public ComponentName getComponentName()
    {
      return this.Nl;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public void hA()
    {
      Intent localIntent = new Intent(this.Ng).setPackage("com.google.android.gms");
      this.Nj = jn.b(jn.this).bindService(localIntent, this.Nh, 129);
      if (this.Nj)
      {
        this.mState = 3;
        return;
      }
      jn.b(jn.this).unbindService(this.Nh);
    }
    
    public void hB()
    {
      jn.b(jn.this).unbindService(this.Nh);
      this.Nj = false;
      this.mState = 2;
    }
    
    public String hC()
    {
      return this.Ng;
    }
    
    public boolean hD()
    {
      return this.Ni.isEmpty();
    }
    
    public boolean isBound()
    {
      return this.Nj;
    }
    
    public class a
      implements ServiceConnection
    {
      public a() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (jn.a(jn.this))
        {
          jn.a.a(jn.a.this, paramIBinder);
          jn.a.a(jn.a.this, paramComponentName);
          Iterator localIterator = jn.a.a(jn.a.this).iterator();
          if (localIterator.hasNext()) {
            ((jl.f)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        jn.a.a(jn.a.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (jn.a(jn.this))
        {
          jn.a.a(jn.a.this, null);
          jn.a.a(jn.a.this, paramComponentName);
          Iterator localIterator = jn.a.a(jn.a.this).iterator();
          if (localIterator.hasNext()) {
            ((jl.f)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        jn.a.a(jn.a.this, 2);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jn
 * JD-Core Version:    0.7.0.1
 */