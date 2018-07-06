package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.List;

@ey
public class fd
  extends gf
  implements gv.a
{
  private final cy lA;
  private final Context mContext;
  private final Object mH = new Object();
  private final gu mo;
  private cr qi;
  private final fc.a tA;
  private final fy.a tB;
  private boolean tC = false;
  private cp tD;
  private cv tE;
  private final Object tj = new Object();
  private fj tn;
  
  public fd(Context paramContext, fy.a parama, gu paramgu, cy paramcy, fc.a parama1)
  {
    this.mContext = paramContext;
    this.tB = parama;
    this.tn = parama.vK;
    this.mo = paramgu;
    this.lA = paramcy;
    this.tA = parama1;
    this.qi = parama.vE;
  }
  
  private void a(fh paramfh, long paramLong)
    throws fd.a
  {
    synchronized (this.tj)
    {
      this.tD = new cp(this.mContext, paramfh, this.lA, this.qi);
      this.tE = this.tD.a(paramLong, 60000L);
      switch (this.tE.qO)
      {
      default: 
        throw new a("Unexpected mediation result: " + this.tE.qO, 0);
      }
    }
    throw new a("No fill from any mediation ad networks.", 3);
  }
  
  private boolean c(long paramLong)
    throws fd.a
  {
    long l = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (l <= 0L) {
      return false;
    }
    try
    {
      this.mH.wait(l);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new a("Ad request cancelled.", -1);
    }
  }
  
  private void f(long paramLong)
    throws fd.a
  {
    gq.wR.post(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          synchronized (fd.a(fd.this))
          {
            if (fd.c(fd.this).errorCode != -2) {
              return;
            }
            fd.d(fd.this).dD().a(fd.this);
            if (fd.c(fd.this).errorCode == -3)
            {
              gr.V("Loading URL in WebView: " + fd.c(fd.this).sg);
              fd.d(fd.this).loadUrl(fd.c(fd.this).sg);
              return;
            }
          }
          gr.V("Loading HTML in WebView.");
          fd.d(fd.this).loadDataWithBaseURL(gi.L(fd.c(fd.this).sg), fd.c(fd.this).tU, "text/html", "UTF-8", null);
        }
      }
    });
    h(paramLong);
  }
  
  private void h(long paramLong)
    throws fd.a
  {
    do
    {
      if (!c(paramLong)) {
        throw new a("Timed out waiting for WebView to finish loading.", 2);
      }
    } while (!this.tC);
  }
  
  public void a(gu paramgu)
  {
    synchronized (this.mH)
    {
      gr.S("WebView finished loading.");
      this.tC = true;
      this.mH.notify();
      return;
    }
  }
  
  public void cx()
  {
    for (;;)
    {
      int i;
      long l2;
      synchronized (this.mH)
      {
        gr.S("AdRendererBackgroundTask started.");
        fh localfh = this.tB.vJ;
        i = this.tB.errorCode;
        try
        {
          l2 = SystemClock.elapsedRealtime();
          if (this.tn.tW)
          {
            a(localfh, l2);
            av localav = localfh.tL;
            gu localgu = this.mo;
            List localList1 = this.tn.qw;
            List localList2 = this.tn.qx;
            List localList3 = this.tn.tY;
            int j = this.tn.orientation;
            long l1 = this.tn.qA;
            String str1 = localfh.tO;
            boolean bool = this.tn.tW;
            if (this.tE == null) {
              break label457;
            }
            localcq = this.tE.qP;
            if (this.tE == null) {
              break label463;
            }
            localcz = this.tE.qQ;
            if (this.tE == null) {
              break label436;
            }
            localObject3 = this.tE.qR;
            cr localcr = this.qi;
            if (this.tE == null) {
              break label451;
            }
            localct = this.tE.qS;
            final fy localfy = new fy(localav, localgu, localList1, i, localList2, localList3, j, l1, str1, bool, localcq, localcz, (String)localObject3, localcr, localct, this.tn.tX, this.tB.lS, this.tn.tV, this.tB.vG, this.tn.ua, this.tn.ub, this.tB.vD, null);
            gq.wR.post(new Runnable()
            {
              public void run()
              {
                synchronized (fd.a(fd.this))
                {
                  fd.b(fd.this).a(localfy);
                  return;
                }
              }
            });
            return;
          }
          if (!this.tn.uc) {
            break label393;
          }
          g(l2);
          continue;
          if (i != -1) {
            break label402;
          }
        }
        catch (a locala)
        {
          i = locala.getErrorCode();
          if (i == 3) {}
        }
        gr.U(locala.getMessage());
        if (this.tn != null) {
          break label413;
        }
        this.tn = new fj(i);
        gq.wR.post(new Runnable()
        {
          public void run()
          {
            fd.this.onStop();
          }
        });
      }
      label393:
      f(l2);
      continue;
      label402:
      gr.W(locala.getMessage());
      continue;
      label413:
      this.tn = new fj(i, this.tn.qA);
      continue;
      label436:
      String str2 = AdMobAdapter.class.getName();
      Object localObject3 = str2;
      continue;
      label451:
      ct localct = null;
      continue;
      label457:
      cq localcq = null;
      continue;
      label463:
      cz localcz = null;
    }
  }
  
  protected void g(long paramLong)
    throws fd.a
  {
    ay localay = this.mo.ac();
    int i;
    if (localay.oq) {
      i = this.mContext.getResources().getDisplayMetrics().widthPixels;
    }
    final fb localfb;
    for (int j = this.mContext.getResources().getDisplayMetrics().heightPixels;; j = localay.heightPixels)
    {
      localfb = new fb(this, this.mo, i, j);
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          synchronized (fd.a(fd.this))
          {
            if (fd.c(fd.this).errorCode != -2) {
              return;
            }
            fd.d(fd.this).dD().a(fd.this);
            localfb.b(fd.c(fd.this));
            return;
          }
        }
      });
      h(paramLong);
      if (!localfb.cH()) {
        break;
      }
      gr.S("Ad-Network indicated no fill with passback URL.");
      throw new a("AdNetwork sent passback url", 3);
      i = localay.widthPixels;
    }
    if (!localfb.cI()) {
      throw new a("AdNetwork timed out", 2);
    }
  }
  
  public void onStop()
  {
    synchronized (this.tj)
    {
      this.mo.stopLoading();
      gi.a(this.mo);
      if (this.tD != null) {
        this.tD.cancel();
      }
      return;
    }
  }
  
  private static final class a
    extends Exception
  {
    private final int tq;
    
    public a(String paramString, int paramInt)
    {
      super();
      this.tq = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.tq;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fd
 * JD-Core Version:    0.7.0.1
 */