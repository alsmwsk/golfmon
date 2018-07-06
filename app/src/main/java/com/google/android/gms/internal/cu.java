package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.dynamic.e;

@ey
public final class cu
  implements cv.a
{
  private final cy lA;
  private final Context mContext;
  private final Object mH = new Object();
  private final av mw;
  private final String qF;
  private final long qG;
  private final cq qH;
  private final ay qI;
  private final gs qJ;
  private cz qK;
  private int qL = -2;
  
  public cu(Context paramContext, String paramString, cy paramcy, cr paramcr, cq paramcq, av paramav, ay paramay, gs paramgs)
  {
    this.mContext = paramContext;
    this.lA = paramcy;
    this.qH = paramcq;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      this.qF = bO();
      if (paramcr.qv == -1L) {
        break label106;
      }
    }
    label106:
    for (long l = paramcr.qv;; l = 10000L)
    {
      this.qG = l;
      this.mw = paramav;
      this.qI = paramay;
      this.qJ = paramgs;
      return;
      this.qF = paramString;
      break;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (this.qL != -2) {
        return;
      }
      b(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void a(ct paramct)
  {
    try
    {
      if (this.qJ.wU < 4100000)
      {
        if (this.qI.oq)
        {
          this.qK.a(e.k(this.mContext), this.mw, this.qH.qt, paramct);
          return;
        }
        this.qK.a(e.k(this.mContext), this.qI, this.mw, this.qH.qt, paramct);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not request ad from mediation adapter.", localRemoteException);
      k(5);
      return;
    }
    if (this.qI.oq)
    {
      this.qK.a(e.k(this.mContext), this.mw, this.qH.qt, this.qH.qn, paramct);
      return;
    }
    this.qK.a(e.k(this.mContext), this.qI, this.mw, this.qH.qt, this.qH.qn, paramct);
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = paramLong2 - (l1 - paramLong1);
    long l3 = paramLong4 - (l1 - paramLong3);
    if ((l2 <= 0L) || (l3 <= 0L))
    {
      gr.U("Timed out waiting for adapter.");
      this.qL = 3;
      return;
    }
    try
    {
      this.mH.wait(Math.min(l2, l3));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.qL = -1;
    }
  }
  
  private String bO()
  {
    try
    {
      if (!TextUtils.isEmpty(this.qH.qr))
      {
        if (this.lA.y(this.qH.qr)) {
          return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (RemoteException localRemoteException)
    {
      gr.W("Fail to determine the custom event's version, assuming the old one.");
    }
    return "com.google.ads.mediation.customevent.CustomEventAdapter";
  }
  
  private cz bP()
  {
    gr.U("Instantiating mediation adapter: " + this.qF);
    try
    {
      cz localcz = this.lA.x(this.qF);
      return localcz;
    }
    catch (RemoteException localRemoteException)
    {
      gr.a("Could not instantiate mediation adapter: " + this.qF, localRemoteException);
    }
    return null;
  }
  
  public cv b(long paramLong1, long paramLong2)
  {
    synchronized (this.mH)
    {
      long l = SystemClock.elapsedRealtime();
      final ct localct = new ct();
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          synchronized (cu.a(cu.this))
          {
            if (cu.b(cu.this) != -2) {
              return;
            }
            cu.a(cu.this, cu.c(cu.this));
            if (cu.d(cu.this) == null)
            {
              cu.this.k(4);
              return;
            }
          }
          localct.a(cu.this);
          cu.a(cu.this, localct);
        }
      });
      a(l, this.qG, paramLong1, paramLong2);
      cv localcv = new cv(this.qH, this.qK, this.qF, localct, this.qL);
      return localcv;
    }
  }
  
  public void cancel()
  {
    synchronized (this.mH)
    {
      try
      {
        if (this.qK != null) {
          this.qK.destroy();
        }
        this.qL = -1;
        this.mH.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          gr.d("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public void k(int paramInt)
  {
    synchronized (this.mH)
    {
      this.qL = paramInt;
      this.mH.notify();
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cu
 * JD-Core Version:    0.7.0.1
 */