package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class ox
  extends jl<oq>
{
  private final String CS;
  private final ou anm;
  private final os ann;
  private boolean ano;
  private final Object mH;
  
  public ox(Context paramContext, ou paramou)
  {
    super(paramContext, paramou, paramou, new String[0]);
    this.CS = paramContext.getPackageName();
    this.anm = ((ou)jx.i(paramou));
    this.anm.a(this);
    this.ann = new os();
    this.mH = new Object();
    this.ano = true;
  }
  
  private void c(ov paramov, or paramor)
  {
    this.ann.a(paramov, paramor);
  }
  
  private void d(ov paramov, or paramor)
  {
    try
    {
      or();
      ((oq)hw()).a(this.CS, paramov, paramor);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
      c(paramov, paramor);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
      c(paramov, paramor);
    }
  }
  
  private void or()
  {
    boolean bool;
    if (!this.ano)
    {
      bool = true;
      je.K(bool);
      if (this.ann.isEmpty()) {}
    }
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      ArrayList localArrayList;
      os.a locala;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.ann.op().iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label204;
          }
          locala = (os.a)localIterator.next();
          if (locala.and == null) {
            break;
          }
          ((oq)hw()).a(this.CS, locala.anb, qw.f(locala.and));
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
      }
      bool = false;
      break;
      if (locala.anb.equals(localObject1))
      {
        localArrayList.add(locala.anc);
        localObject2 = localObject1;
      }
      else
      {
        if (!localArrayList.isEmpty())
        {
          ((oq)hw()).a(this.CS, localObject1, localArrayList);
          localArrayList.clear();
        }
        ov localov = locala.anb;
        localArrayList.add(locala.anc);
        localObject2 = localov;
        continue;
        label204:
        if (!localArrayList.isEmpty()) {
          ((oq)hw()).a(this.CS, localObject1, localArrayList);
        }
        this.ann.clear();
        return;
      }
    }
  }
  
  void U(boolean paramBoolean)
  {
    synchronized (this.mH)
    {
      boolean bool = this.ano;
      this.ano = paramBoolean;
      if ((bool) && (!this.ano)) {
        or();
      }
      return;
    }
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramjt.f(parame, 6587000, getContext().getPackageName(), localBundle);
  }
  
  public void b(ov paramov, or paramor)
  {
    synchronized (this.mH)
    {
      if (this.ano)
      {
        c(paramov, paramor);
        return;
      }
      d(paramov, paramor);
    }
  }
  
  protected oq bJ(IBinder paramIBinder)
  {
    return oq.a.bI(paramIBinder);
  }
  
  protected String bK()
  {
    return "com.google.android.gms.playlog.service.START";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.playlog.internal.IPlayLogService";
  }
  
  public void start()
  {
    synchronized (this.mH)
    {
      if ((isConnecting()) || (isConnected())) {
        return;
      }
      this.anm.T(true);
      connect();
      return;
    }
  }
  
  public void stop()
  {
    synchronized (this.mH)
    {
      this.anm.T(false);
      disconnect();
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ox
 * JD-Core Version:    0.7.0.1
 */