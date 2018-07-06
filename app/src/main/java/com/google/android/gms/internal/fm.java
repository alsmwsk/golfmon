package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.Future;

@ey
public class fm
  extends gf
{
  private final Object mH = new Object();
  private final fc.a tA;
  private final fy.a tB;
  private final fj tn;
  private final fn ui;
  private Future<fy> uj;
  
  public fm(Context paramContext, u paramu, ai paramai, fy.a parama, fc.a parama1)
  {
    this(parama, parama1, new fn(paramContext, paramu, paramai, new gn(), parama));
  }
  
  fm(fy.a parama, fc.a parama1, fn paramfn)
  {
    this.tB = parama;
    this.tn = parama.vK;
    this.tA = parama1;
    this.ui = paramfn;
  }
  
  private fy s(int paramInt)
  {
    return new fy(this.tB.vJ.tL, null, null, paramInt, null, null, this.tn.orientation, this.tn.qA, this.tB.vJ.tO, false, null, null, null, null, null, this.tn.tX, this.tB.lS, this.tn.tV, this.tB.vG, this.tn.ua, this.tn.ub, this.tB.vD, null);
  }
  
  /* Error */
  public void cx()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/google/android/gms/internal/fm:mH	Ljava/lang/Object;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 52	com/google/android/gms/internal/fm:ui	Lcom/google/android/gms/internal/fn;
    //   14: invokestatic 123	com/google/android/gms/internal/gh:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   17: putfield 125	com/google/android/gms/internal/fm:uj	Ljava/util/concurrent/Future;
    //   20: aload 8
    //   22: monitorexit
    //   23: aload_0
    //   24: getfield 125	com/google/android/gms/internal/fm:uj	Ljava/util/concurrent/Future;
    //   27: ldc2_w 126
    //   30: getstatic 133	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   33: invokeinterface 139 4 0
    //   38: checkcast 58	com/google/android/gms/internal/fy
    //   41: astore_3
    //   42: bipush 254
    //   44: istore_2
    //   45: aload_3
    //   46: ifnull +68 -> 114
    //   49: getstatic 145	com/google/android/gms/internal/gq:wR	Landroid/os/Handler;
    //   52: new 147	com/google/android/gms/internal/fm$1
    //   55: dup
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 150	com/google/android/gms/internal/fm$1:<init>	(Lcom/google/android/gms/internal/fm;Lcom/google/android/gms/internal/fy;)V
    //   61: invokevirtual 156	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   64: pop
    //   65: return
    //   66: astore 9
    //   68: aload 8
    //   70: monitorexit
    //   71: aload 9
    //   73: athrow
    //   74: astore 7
    //   76: ldc 158
    //   78: invokestatic 164	com/google/android/gms/internal/gr:W	(Ljava/lang/String;)V
    //   81: iconst_2
    //   82: istore_2
    //   83: aconst_null
    //   84: astore_3
    //   85: goto -40 -> 45
    //   88: astore 6
    //   90: aconst_null
    //   91: astore_3
    //   92: iconst_0
    //   93: istore_2
    //   94: goto -49 -> 45
    //   97: astore 5
    //   99: iconst_m1
    //   100: istore_2
    //   101: aconst_null
    //   102: astore_3
    //   103: goto -58 -> 45
    //   106: astore_1
    //   107: iconst_m1
    //   108: istore_2
    //   109: aconst_null
    //   110: astore_3
    //   111: goto -66 -> 45
    //   114: aload_0
    //   115: iload_2
    //   116: invokespecial 166	com/google/android/gms/internal/fm:s	(I)Lcom/google/android/gms/internal/fy;
    //   119: astore_3
    //   120: goto -71 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	fm
    //   106	1	1	localCancellationException	java.util.concurrent.CancellationException
    //   44	72	2	i	int
    //   41	79	3	localfy	fy
    //   97	1	5	localInterruptedException	java.lang.InterruptedException
    //   88	1	6	localExecutionException	java.util.concurrent.ExecutionException
    //   74	1	7	localTimeoutException	java.util.concurrent.TimeoutException
    //   66	6	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	23	66	finally
    //   68	71	66	finally
    //   0	9	74	java/util/concurrent/TimeoutException
    //   23	42	74	java/util/concurrent/TimeoutException
    //   71	74	74	java/util/concurrent/TimeoutException
    //   0	9	88	java/util/concurrent/ExecutionException
    //   23	42	88	java/util/concurrent/ExecutionException
    //   71	74	88	java/util/concurrent/ExecutionException
    //   0	9	97	java/lang/InterruptedException
    //   23	42	97	java/lang/InterruptedException
    //   71	74	97	java/lang/InterruptedException
    //   0	9	106	java/util/concurrent/CancellationException
    //   23	42	106	java/util/concurrent/CancellationException
    //   71	74	106	java/util/concurrent/CancellationException
  }
  
  public void onStop()
  {
    synchronized (this.mH)
    {
      if (this.uj != null) {
        this.uj.cancel(true);
      }
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fm
 * JD-Core Version:    0.7.0.1
 */