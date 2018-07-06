package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.j;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class cp
  implements o.e
{
  private String aqI;
  private final String aqm;
  private bg<c.j> asC;
  private r asD;
  private final ScheduledExecutorService asF;
  private final a asG;
  private ScheduledFuture<?> asH;
  private boolean mClosed;
  private final Context mContext;
  
  public cp(Context paramContext, String paramString, r paramr)
  {
    this(paramContext, paramString, paramr, null, null);
  }
  
  cp(Context paramContext, String paramString, r paramr, b paramb, a parama)
  {
    this.asD = paramr;
    this.mContext = paramContext;
    this.aqm = paramString;
    if (paramb == null) {
      paramb = new b()
      {
        public ScheduledExecutorService qh()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.asF = paramb.qh();
    if (parama == null)
    {
      this.asG = new a()
      {
        public co a(r paramAnonymousr)
        {
          return new co(cp.a(cp.this), cp.b(cp.this), paramAnonymousr);
        }
      };
      return;
    }
    this.asG = parama;
  }
  
  private co cM(String paramString)
  {
    co localco = this.asG.a(this.asD);
    localco.a(this.asC);
    localco.cw(this.aqI);
    localco.cL(paramString);
    return localco;
  }
  
  private void qg()
  {
    try
    {
      if (this.mClosed) {
        throw new IllegalStateException("called method after closed");
      }
    }
    finally {}
  }
  
  public void a(bg<c.j> parambg)
  {
    try
    {
      qg();
      this.asC = parambg;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void cw(String paramString)
  {
    try
    {
      qg();
      this.aqI = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(long paramLong, String paramString)
  {
    try
    {
      bh.V("loadAfterDelay: containerId=" + this.aqm + " delay=" + paramLong);
      qg();
      if (this.asC == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.asH != null) {
      this.asH.cancel(false);
    }
    this.asH = this.asF.schedule(cM(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void release()
  {
    try
    {
      qg();
      if (this.asH != null) {
        this.asH.cancel(false);
      }
      this.asF.shutdown();
      this.mClosed = true;
      return;
    }
    finally {}
  }
  
  static abstract interface a
  {
    public abstract co a(r paramr);
  }
  
  static abstract interface b
  {
    public abstract ScheduledExecutorService qh();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cp
 * JD-Core Version:    0.7.0.1
 */