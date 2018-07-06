package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class v
  extends aj
{
  private static final Object yT = new Object();
  private static v zf;
  private Context mContext;
  private Handler mHandler;
  private d yU;
  private volatile f yV;
  private int yW = 1800;
  private boolean yX = true;
  private boolean yY;
  private String yZ;
  private boolean yt = false;
  private boolean za = true;
  private boolean zb = true;
  private e zc = new e()
  {
    public void B(boolean paramAnonymousBoolean)
    {
      v.this.a(paramAnonymousBoolean, v.a(v.this));
    }
  };
  private u zd;
  private boolean ze = false;
  
  public static v eu()
  {
    if (zf == null) {
      zf = new v();
    }
    return zf;
  }
  
  private void ev()
  {
    this.zd = new u(this);
    this.zd.z(this.mContext);
  }
  
  private void ew()
  {
    this.mHandler = new Handler(this.mContext.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (v.ez().equals(paramAnonymousMessage.obj)))
        {
          y.eK().D(true);
          v.this.dispatchLocalHits();
          y.eK().D(false);
          if ((v.b(v.this) > 0) && (!v.c(v.this))) {
            v.d(v.this).sendMessageDelayed(v.d(v.this).obtainMessage(1, v.ez()), 1000 * v.b(v.this));
          }
        }
        return true;
      }
    });
    if (this.yW > 0) {
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yT), 1000 * this.yW);
    }
  }
  
  void C(boolean paramBoolean)
  {
    try
    {
      a(this.ze, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void a(Context paramContext, f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/google/android/gms/analytics/v:mContext	Landroid/content/Context;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 123	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   21: putfield 84	com/google/android/gms/analytics/v:mContext	Landroid/content/Context;
    //   24: aload_0
    //   25: getfield 125	com/google/android/gms/analytics/v:yV	Lcom/google/android/gms/analytics/f;
    //   28: ifnonnull -15 -> 13
    //   31: aload_0
    //   32: aload_2
    //   33: putfield 125	com/google/android/gms/analytics/v:yV	Lcom/google/android/gms/analytics/f;
    //   36: aload_0
    //   37: getfield 45	com/google/android/gms/analytics/v:yX	Z
    //   40: ifeq +12 -> 52
    //   43: aload_0
    //   44: invokevirtual 128	com/google/android/gms/analytics/v:dispatchLocalHits	()V
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 45	com/google/android/gms/analytics/v:yX	Z
    //   52: aload_0
    //   53: getfield 130	com/google/android/gms/analytics/v:yY	Z
    //   56: ifeq -43 -> 13
    //   59: aload_0
    //   60: invokevirtual 133	com/google/android/gms/analytics/v:dW	()V
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 130	com/google/android/gms/analytics/v:yY	Z
    //   68: goto -55 -> 13
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	v
    //   0	76	1	paramContext	Context
    //   0	76	2	paramf	f
    //   71	4	3	localObject	Object
    //   6	3	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	8	71	finally
    //   16	52	71	finally
    //   52	68	71	finally
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        if (this.ze == paramBoolean1)
        {
          boolean bool = this.za;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.yW > 0)) {
          this.mHandler.removeMessages(1, yT);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.yW > 0)) {
          this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yT), 1000 * this.yW);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label157;
        }
        if (paramBoolean2) {
          break label150;
        }
      }
      finally {}
      ae.V(str);
      this.ze = paramBoolean1;
      this.za = paramBoolean2;
      continue;
      label150:
      String str = "terminated.";
      continue;
      label157:
      str = "initiated.";
    }
  }
  
  void dW()
  {
    if (this.yV == null)
    {
      ae.V("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.yY = true;
      return;
    }
    y.eK().a(y.a.Bb);
    this.yV.dW();
  }
  
  /* Error */
  void dispatchLocalHits()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 125	com/google/android/gms/analytics/v:yV	Lcom/google/android/gms/analytics/f;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 182
    //   11: invokestatic 156	com/google/android/gms/analytics/ae:V	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 45	com/google/android/gms/analytics/v:yX	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 168	com/google/android/gms/analytics/y:eK	()Lcom/google/android/gms/analytics/y;
    //   25: getstatic 185	com/google/android/gms/analytics/y$a:AO	Lcom/google/android/gms/analytics/y$a;
    //   28: invokevirtual 177	com/google/android/gms/analytics/y:a	(Lcom/google/android/gms/analytics/y$a;)V
    //   31: aload_0
    //   32: getfield 125	com/google/android/gms/analytics/v:yV	Lcom/google/android/gms/analytics/f;
    //   35: invokeinterface 188 1 0
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	v
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  d ex()
  {
    try
    {
      if (this.yU != null) {
        break label100;
      }
      if (this.mContext == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.yU = new ag(this.zc, this.mContext, new j());
    this.yU.setDryRun(this.yt);
    if (this.yZ != null)
    {
      this.yU.dV().ad(this.yZ);
      this.yZ = null;
    }
    label100:
    if (this.mHandler == null) {
      ew();
    }
    if ((this.zd == null) && (this.zb)) {
      ev();
    }
    d locald = this.yU;
    return locald;
  }
  
  void ey()
  {
    try
    {
      if ((!this.ze) && (this.za) && (this.yW > 0))
      {
        this.mHandler.removeMessages(1, yT);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, yT));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void setLocalDispatchPeriod(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/google/android/gms/analytics/v:mHandler	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 235
    //   11: invokestatic 156	com/google/android/gms/analytics/ae:V	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 43	com/google/android/gms/analytics/v:yW	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 168	com/google/android/gms/analytics/y:eK	()Lcom/google/android/gms/analytics/y;
    //   25: getstatic 238	com/google/android/gms/analytics/y$a:AP	Lcom/google/android/gms/analytics/y$a;
    //   28: invokevirtual 177	com/google/android/gms/analytics/y:a	(Lcom/google/android/gms/analytics/y$a;)V
    //   31: aload_0
    //   32: getfield 58	com/google/android/gms/analytics/v:ze	Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 47	com/google/android/gms/analytics/v:za	Z
    //   42: ifeq +21 -> 63
    //   45: aload_0
    //   46: getfield 43	com/google/android/gms/analytics/v:yW	I
    //   49: ifle +14 -> 63
    //   52: aload_0
    //   53: getfield 69	com/google/android/gms/analytics/v:mHandler	Landroid/os/Handler;
    //   56: iconst_1
    //   57: getstatic 40	com/google/android/gms/analytics/v:yT	Ljava/lang/Object;
    //   60: invokevirtual 137	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 43	com/google/android/gms/analytics/v:yW	I
    //   68: iload_1
    //   69: ifle -50 -> 19
    //   72: aload_0
    //   73: getfield 58	com/google/android/gms/analytics/v:ze	Z
    //   76: ifne -57 -> 19
    //   79: aload_0
    //   80: getfield 47	com/google/android/gms/analytics/v:za	Z
    //   83: ifeq -64 -> 19
    //   86: aload_0
    //   87: getfield 69	com/google/android/gms/analytics/v:mHandler	Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield 69	com/google/android/gms/analytics/v:mHandler	Landroid/os/Handler;
    //   94: iconst_1
    //   95: getstatic 40	com/google/android/gms/analytics/v:yT	Ljava/lang/Object;
    //   98: invokevirtual 107	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   101: iload_1
    //   102: sipush 1000
    //   105: imul
    //   106: i2l
    //   107: invokevirtual 111	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   110: pop
    //   111: goto -92 -> 19
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	v
    //   0	119	1	paramInt	int
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	114	finally
    //   22	63	114	finally
    //   63	68	114	finally
    //   72	111	114	finally
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.v
 * JD-Core Version:    0.7.0.1
 */