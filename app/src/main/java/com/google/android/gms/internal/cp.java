package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;

@ey
public final class cp
{
  private final cy lA;
  private final Context mContext;
  private final Object mH = new Object();
  private final fh qh;
  private final cr qi;
  private boolean qj = false;
  private cu qk;
  
  public cp(Context paramContext, fh paramfh, cy paramcy, cr paramcr)
  {
    this.mContext = paramContext;
    this.qh = paramfh;
    this.lA = paramcy;
    this.qi = paramcr;
  }
  
  public cv a(long paramLong1, long paramLong2)
  {
    gr.S("Starting mediation.");
    Iterator localIterator1 = this.qi.qu.iterator();
    while (localIterator1.hasNext())
    {
      cq localcq = (cq)localIterator1.next();
      gr.U("Trying mediation network: " + localcq.qo);
      Iterator localIterator2 = localcq.qp.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        final cv localcv2;
        synchronized (this.mH)
        {
          if (this.qj)
          {
            cv localcv1 = new cv(-1);
            return localcv1;
          }
          this.qk = new cu(this.mContext, str, this.lA, this.qi, localcq, this.qh.tL, this.qh.lS, this.qh.lO);
          localcv2 = this.qk.b(paramLong1, paramLong2);
          if (localcv2.qO == 0)
          {
            gr.S("Adapter succeeded.");
            return localcv2;
          }
        }
        if (localcv2.qQ != null) {
          gq.wR.post(new Runnable()
          {
            public void run()
            {
              try
              {
                localcv2.qQ.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                gr.d("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    return new cv(1);
  }
  
  public void cancel()
  {
    synchronized (this.mH)
    {
      this.qj = true;
      if (this.qk != null) {
        this.qk.cancel();
      }
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cp
 * JD-Core Version:    0.7.0.1
 */