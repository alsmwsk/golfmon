package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class w
  implements ak, c.b, c.c
{
  private final Context mContext;
  private ld wb;
  private d yU;
  private final f yV;
  private boolean yX;
  private volatile long zh;
  private volatile a zi;
  private volatile b zj;
  private d zk;
  private final GoogleAnalytics zl;
  private final Queue<d> zm = new ConcurrentLinkedQueue();
  private volatile int zn;
  private volatile Timer zo;
  private volatile Timer zp;
  private volatile Timer zq;
  private boolean zr;
  private boolean zs;
  private boolean zt;
  private long zu = 300000L;
  
  w(Context paramContext, f paramf)
  {
    this(paramContext, paramf, null, GoogleAnalytics.getInstance(paramContext));
  }
  
  w(Context paramContext, f paramf, d paramd, GoogleAnalytics paramGoogleAnalytics)
  {
    this.zk = paramd;
    this.mContext = paramContext;
    this.yV = paramf;
    this.zl = paramGoogleAnalytics;
    this.wb = lf.jdMethod_if();
    this.zn = 0;
    this.zi = a.zD;
  }
  
  private Timer a(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
    return null;
  }
  
  private void cJ()
  {
    try
    {
      if ((this.zj != null) && (this.zi == a.zy))
      {
        this.zi = a.zC;
        this.zj.disconnect();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void eA()
  {
    this.zo = a(this.zo);
    this.zp = a(this.zp);
    this.zq = a(this.zq);
  }
  
  private void eC()
  {
    for (;;)
    {
      try
      {
        if (!Thread.currentThread().equals(this.yV.getThread()))
        {
          this.yV.dX().add(new Runnable()
          {
            public void run()
            {
              w.a(w.this);
            }
          });
          return;
        }
        if (this.zr) {
          dQ();
        }
        switch (2.zw[this.zi.ordinal()])
        {
        case 1: 
          if (this.zm.isEmpty()) {
            break;
          }
          d locald2 = (d)this.zm.poll();
          ae.V("Sending hit to store  " + locald2);
          this.yU.a(locald2.eH(), locald2.eI(), locald2.getPath(), locald2.eJ());
          break;
        case 7: 
          ae.V("Blocked. Dropping hits.");
        }
      }
      finally {}
      this.zm.clear();
      continue;
      if (this.yX)
      {
        eD();
        continue;
        if (!this.zm.isEmpty())
        {
          d locald1 = (d)this.zm.peek();
          ae.V("Sending hit to service   " + locald1);
          if (!this.zl.isDryRunEnabled()) {
            this.zj.a(locald1.eH(), locald1.eI(), locald1.getPath(), locald1.eJ());
          }
          for (;;)
          {
            this.zm.poll();
            break;
            ae.V("Dry run enabled. Hit not actually sent to service.");
          }
        }
        this.zh = this.wb.elapsedRealtime();
        continue;
        ae.V("Need to reconnect");
        if (!this.zm.isEmpty()) {
          eF();
        }
      }
    }
  }
  
  private void eD()
  {
    this.yU.dispatch();
    this.yX = false;
  }
  
  private void eE()
  {
    try
    {
      a locala1 = this.zi;
      a locala2 = a.zz;
      if (locala1 == locala2) {}
      for (;;)
      {
        return;
        if ((this.mContext == null) || (!"com.google.android.gms".equals(this.mContext.getPackageName()))) {
          break;
        }
        this.zi = a.zA;
        this.zj.disconnect();
        ae.W("Attempted to fall back to local store from service.");
      }
      eA();
    }
    finally {}
    ae.V("falling back to local store");
    if (this.zk != null) {}
    v localv;
    for (this.yU = this.zk;; this.yU = localv.ex())
    {
      this.zi = a.zz;
      eC();
      break;
      localv = v.eu();
      localv.a(this.mContext, this.yV);
    }
  }
  
  private void eF()
  {
    for (;;)
    {
      try
      {
        if ((!this.zt) && (this.zj != null))
        {
          a locala1 = this.zi;
          a locala2 = a.zz;
          if (locala1 != locala2) {
            try
            {
              this.zn = (1 + this.zn);
              a(this.zp);
              this.zi = a.zx;
              this.zp = new Timer("Failed Connect");
              this.zp.schedule(new c(null), 3000L);
              ae.V("connecting to Analytics service");
              this.zj.connect();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              ae.W("security exception on connectToService");
              eE();
              continue;
            }
          }
        }
        ae.W("client not initialized.");
      }
      finally {}
      eE();
    }
  }
  
  private void eG()
  {
    this.zo = a(this.zo);
    this.zo = new Timer("Service Reconnect");
    this.zo.schedule(new e(null), 5000L);
  }
  
  /* Error */
  public void a(int paramInt, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 360	com/google/android/gms/analytics/w$a:zB	Lcom/google/android/gms/analytics/w$a;
    //   6: putfield 90	com/google/android/gms/analytics/w:zi	Lcom/google/android/gms/analytics/w$a;
    //   9: aload_0
    //   10: getfield 83	com/google/android/gms/analytics/w:zn	I
    //   13: iconst_2
    //   14: if_icmpge +39 -> 53
    //   17: new 193	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 362
    //   27: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc_w 367
    //   37: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 291	com/google/android/gms/analytics/ae:W	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokespecial 369	com/google/android/gms/analytics/w:eG	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: new 193	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 362
    //   63: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 371
    //   73: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 291	com/google/android/gms/analytics/ae:W	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokespecial 107	com/google/android/gms/analytics/w:eE	()V
    //   86: goto -36 -> 50
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	w
    //   0	94	1	paramInt	int
    //   0	94	2	paramIntent	android.content.Intent
    //   89	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	89	finally
    //   53	86	89	finally
  }
  
  public void b(Map<String, String> paramMap, long paramLong, String paramString, List<ha> paramList)
  {
    ae.V("putHit called");
    this.zm.add(new d(paramMap, paramLong, paramString, paramList));
    eC();
  }
  
  public void dQ()
  {
    ae.V("clearHits called");
    this.zm.clear();
    switch (2.zw[this.zi.ordinal()])
    {
    default: 
      this.zr = true;
      return;
    case 1: 
      this.yU.l(0L);
      this.zr = false;
      return;
    }
    this.zj.dQ();
    this.zr = false;
  }
  
  public void dW()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.zt;
        if (bool) {
          return;
        }
        ae.V("setForceLocalDispatch called.");
        this.zt = true;
        switch (2.zw[this.zi.ordinal()])
        {
        case 1: 
        case 4: 
        case 5: 
        case 6: 
        case 2: 
          cJ();
          break;
        case 3: 
          this.zs = true;
        }
      }
      finally {}
    }
  }
  
  public void dispatch()
  {
    switch (2.zw[this.zi.ordinal()])
    {
    default: 
      this.yX = true;
    case 2: 
      return;
    }
    eD();
  }
  
  public void eB()
  {
    if (this.zj != null) {
      return;
    }
    this.zj = new c(this.mContext, this, this);
    eF();
  }
  
  /* Error */
  public void onConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_0
    //   5: getfield 134	com/google/android/gms/analytics/w:zp	Ljava/util/Timer;
    //   8: invokespecial 132	com/google/android/gms/analytics/w:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   11: putfield 134	com/google/android/gms/analytics/w:zp	Ljava/util/Timer;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 83	com/google/android/gms/analytics/w:zn	I
    //   19: ldc_w 397
    //   22: invokestatic 213	com/google/android/gms/analytics/ae:V	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getstatic 113	com/google/android/gms/analytics/w$a:zy	Lcom/google/android/gms/analytics/w$a;
    //   29: putfield 90	com/google/android/gms/analytics/w:zi	Lcom/google/android/gms/analytics/w$a;
    //   32: aload_0
    //   33: getfield 388	com/google/android/gms/analytics/w:zs	Z
    //   36: ifeq +15 -> 51
    //   39: aload_0
    //   40: invokespecial 354	com/google/android/gms/analytics/w:cJ	()V
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 388	com/google/android/gms/analytics/w:zs	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: invokespecial 101	com/google/android/gms/analytics/w:eC	()V
    //   55: aload_0
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 136	com/google/android/gms/analytics/w:zq	Ljava/util/Timer;
    //   61: invokespecial 132	com/google/android/gms/analytics/w:a	(Ljava/util/Timer;)Ljava/util/Timer;
    //   64: putfield 136	com/google/android/gms/analytics/w:zq	Ljava/util/Timer;
    //   67: aload_0
    //   68: new 94	java/util/Timer
    //   71: dup
    //   72: ldc_w 399
    //   75: invokespecial 318	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   78: putfield 136	com/google/android/gms/analytics/w:zq	Ljava/util/Timer;
    //   81: aload_0
    //   82: getfield 136	com/google/android/gms/analytics/w:zq	Ljava/util/Timer;
    //   85: new 401	com/google/android/gms/analytics/w$b
    //   88: dup
    //   89: aload_0
    //   90: aconst_null
    //   91: invokespecial 402	com/google/android/gms/analytics/w$b:<init>	(Lcom/google/android/gms/analytics/w;Lcom/google/android/gms/analytics/w$1;)V
    //   94: aload_0
    //   95: getfield 65	com/google/android/gms/analytics/w:zu	J
    //   98: invokevirtual 329	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   101: goto -53 -> 48
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	w
    //   104	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	104	finally
    //   51	101	104	finally
  }
  
  public void onDisconnected()
  {
    for (;;)
    {
      try
      {
        if (this.zi == a.zA)
        {
          ae.V("Service blocked.");
          eA();
          return;
        }
        if (this.zi == a.zC)
        {
          ae.V("Disconnected from service");
          eA();
          this.zi = a.zD;
          continue;
        }
        ae.V("Unexpected disconnect.");
      }
      finally {}
      this.zi = a.zB;
      if (this.zn < 2) {
        eG();
      } else {
        eE();
      }
    }
  }
  
  private static enum a
  {
    static
    {
      zA = new a("BLOCKED", 3);
      zB = new a("PENDING_CONNECTION", 4);
      zC = new a("PENDING_DISCONNECT", 5);
      zD = new a("DISCONNECTED", 6);
      a[] arrayOfa = new a[7];
      arrayOfa[0] = zx;
      arrayOfa[1] = zy;
      arrayOfa[2] = zz;
      arrayOfa[3] = zA;
      arrayOfa[4] = zB;
      arrayOfa[5] = zC;
      arrayOfa[6] = zD;
      zE = arrayOfa;
    }
    
    private a() {}
  }
  
  private class b
    extends TimerTask
  {
    private b() {}
    
    public void run()
    {
      if ((w.b(w.this) == w.a.zy) && (w.e(w.this).isEmpty()) && (w.f(w.this) + w.g(w.this) < w.h(w.this).elapsedRealtime()))
      {
        ae.V("Disconnecting due to inactivity");
        w.i(w.this);
        return;
      }
      w.j(w.this).schedule(new b(w.this), w.g(w.this));
    }
  }
  
  private class c
    extends TimerTask
  {
    private c() {}
    
    public void run()
    {
      if (w.b(w.this) == w.a.zx) {
        w.c(w.this);
      }
    }
  }
  
  private static class d
  {
    private final Map<String, String> zF;
    private final long zG;
    private final String zH;
    private final List<ha> zI;
    
    public d(Map<String, String> paramMap, long paramLong, String paramString, List<ha> paramList)
    {
      this.zF = paramMap;
      this.zG = paramLong;
      this.zH = paramString;
      this.zI = paramList;
    }
    
    public Map<String, String> eH()
    {
      return this.zF;
    }
    
    public long eI()
    {
      return this.zG;
    }
    
    public List<ha> eJ()
    {
      return this.zI;
    }
    
    public String getPath()
    {
      return this.zH;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PATH: ");
      localStringBuilder.append(this.zH);
      if (this.zF != null)
      {
        localStringBuilder.append("  PARAMS: ");
        Iterator localIterator = this.zF.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append("=");
          localStringBuilder.append((String)localEntry.getValue());
          localStringBuilder.append(",  ");
        }
      }
      return localStringBuilder.toString();
    }
  }
  
  private class e
    extends TimerTask
  {
    private e() {}
    
    public void run()
    {
      w.d(w.this);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.w
 * JD-Core Version:    0.7.0.1
 */