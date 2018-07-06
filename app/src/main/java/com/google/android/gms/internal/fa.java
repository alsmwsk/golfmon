package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import org.json.JSONException;

@ey
public class fa
  extends gf
  implements fe.a
{
  private final Context mContext;
  private final Object mH = new Object();
  private cr qi;
  private final ez.a ti;
  private final Object tj = new Object();
  private final fh.a tk;
  private final k tl;
  private gf tm;
  private fj tn;
  
  public fa(Context paramContext, fh.a parama, k paramk, ez.a parama1)
  {
    this.ti = parama1;
    this.mContext = paramContext;
    this.tk = parama;
    this.tl = paramk;
  }
  
  private ay a(fh paramfh)
    throws fa.a
  {
    if (this.tn.tZ == null) {
      throw new a("The ad response must specify one of the supported ad sizes.", 0);
    }
    String[] arrayOfString = this.tn.tZ.split("x");
    if (arrayOfString.length != 2) {
      throw new a("Could not parse the ad size from the ad response: " + this.tn.tZ, 0);
    }
    for (;;)
    {
      int m;
      ay localay;
      try
      {
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[1]);
        ay[] arrayOfay = paramfh.lS.or;
        int k = arrayOfay.length;
        m = 0;
        if (m >= k) {
          break;
        }
        localay = arrayOfay[m];
        float f = this.mContext.getResources().getDisplayMetrics().density;
        if (localay.width == -1)
        {
          n = (int)(localay.widthPixels / f);
          if (localay.height != -2) {
            break label255;
          }
          i1 = (int)(localay.heightPixels / f);
          if ((i != n) || (j != i1)) {
            break label265;
          }
          return new ay(localay, paramfh.lS.or);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new a("Could not parse the ad size from the ad response: " + this.tn.tZ, 0);
      }
      int n = localay.width;
      continue;
      label255:
      int i1 = localay.height;
      continue;
      label265:
      m++;
    }
    throw new a("The ad size from the ad response was not one of the requested sizes: " + this.tn.tZ, 0);
  }
  
  private boolean c(long paramLong)
    throws fa.a
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
  
  private void cE()
    throws fa.a
  {
    if (this.tn.errorCode == -3) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.tn.tU)) {
        throw new a("No fill from ad server.", 3);
      }
      ga.a(this.mContext, this.tn.tT);
    } while (!this.tn.tW);
    try
    {
      this.qi = new cr(this.tn.tU);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new a("Could not parse mediation config: " + this.tn.tU, 0);
    }
  }
  
  private void e(long paramLong)
    throws fa.a
  {
    do
    {
      if (!c(paramLong)) {
        throw new a("Timed out waiting for ad response.", 2);
      }
    } while (this.tn == null);
    synchronized (this.tj)
    {
      this.tm = null;
      if ((this.tn.errorCode != -2) && (this.tn.errorCode != -3)) {
        throw new a("There was a problem getting an ad response. ErrorCode: " + this.tn.errorCode, this.tn.errorCode);
      }
    }
  }
  
  private void t(boolean paramBoolean)
  {
    ga.dc().x(paramBoolean);
    an localan = ga.dc().l(this.mContext);
    if ((localan != null) && (!localan.isAlive()))
    {
      gr.S("start fetching content...");
      localan.ba();
    }
  }
  
  public void a(fj paramfj)
  {
    synchronized (this.mH)
    {
      gr.S("Received ad response.");
      this.tn = paramfj;
      this.mH.notify();
      return;
    }
  }
  
  /* Error */
  public void cx()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/google/android/gms/internal/fa:mH	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: ldc 248
    //   9: invokestatic 234	com/google/android/gms/internal/gr:S	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 44	com/google/android/gms/internal/fa:tl	Lcom/google/android/gms/internal/k;
    //   16: invokevirtual 254	com/google/android/gms/internal/k:C	()Lcom/google/android/gms/internal/g;
    //   19: aload_0
    //   20: getfield 40	com/google/android/gms/internal/fa:mContext	Landroid/content/Context;
    //   23: invokeinterface 259 2 0
    //   28: astore_3
    //   29: new 92	com/google/android/gms/internal/fh
    //   32: dup
    //   33: aload_0
    //   34: getfield 42	com/google/android/gms/internal/fa:tk	Lcom/google/android/gms/internal/fh$a;
    //   37: aload_3
    //   38: invokespecial 262	com/google/android/gms/internal/fh:<init>	(Lcom/google/android/gms/internal/fh$a;Ljava/lang/String;)V
    //   41: astore 4
    //   43: bipush 254
    //   45: istore 5
    //   47: ldc2_w 263
    //   50: lstore 6
    //   52: invokestatic 153	android/os/SystemClock:elapsedRealtime	()J
    //   55: lstore 18
    //   57: aload_0
    //   58: getfield 40	com/google/android/gms/internal/fa:mContext	Landroid/content/Context;
    //   61: aload 4
    //   63: aload_0
    //   64: invokestatic 269	com/google/android/gms/internal/fe:a	(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Lcom/google/android/gms/internal/fe$a;)Lcom/google/android/gms/internal/gf;
    //   67: astore 20
    //   69: aload_0
    //   70: getfield 34	com/google/android/gms/internal/fa:tj	Ljava/lang/Object;
    //   73: astore 21
    //   75: aload 21
    //   77: monitorenter
    //   78: aload_0
    //   79: aload 20
    //   81: putfield 204	com/google/android/gms/internal/fa:tm	Lcom/google/android/gms/internal/gf;
    //   84: aload_0
    //   85: getfield 204	com/google/android/gms/internal/fa:tm	Lcom/google/android/gms/internal/gf;
    //   88: ifnonnull +181 -> 269
    //   91: new 48	com/google/android/gms/internal/fa$a
    //   94: dup
    //   95: ldc_w 271
    //   98: iconst_0
    //   99: invokespecial 63	com/google/android/gms/internal/fa$a:<init>	(Ljava/lang/String;I)V
    //   102: athrow
    //   103: astore 22
    //   105: aload 21
    //   107: monitorexit
    //   108: aload 22
    //   110: athrow
    //   111: astore 8
    //   113: aconst_null
    //   114: astore 9
    //   116: aload 8
    //   118: invokevirtual 275	com/google/android/gms/internal/fa$a:getErrorCode	()I
    //   121: istore 5
    //   123: iload 5
    //   125: iconst_3
    //   126: if_icmpeq +9 -> 135
    //   129: iload 5
    //   131: iconst_m1
    //   132: if_icmpne +196 -> 328
    //   135: aload 8
    //   137: invokevirtual 278	com/google/android/gms/internal/fa$a:getMessage	()Ljava/lang/String;
    //   140: invokestatic 281	com/google/android/gms/internal/gr:U	(Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield 52	com/google/android/gms/internal/fa:tn	Lcom/google/android/gms/internal/fj;
    //   147: ifnonnull +197 -> 344
    //   150: aload_0
    //   151: new 54	com/google/android/gms/internal/fj
    //   154: dup
    //   155: iload 5
    //   157: invokespecial 284	com/google/android/gms/internal/fj:<init>	(I)V
    //   160: putfield 52	com/google/android/gms/internal/fa:tn	Lcom/google/android/gms/internal/fj;
    //   163: getstatic 290	com/google/android/gms/internal/gq:wR	Landroid/os/Handler;
    //   166: new 292	com/google/android/gms/internal/fa$1
    //   169: dup
    //   170: aload_0
    //   171: invokespecial 295	com/google/android/gms/internal/fa$1:<init>	(Lcom/google/android/gms/internal/fa;)V
    //   174: invokevirtual 301	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   177: pop
    //   178: lload 6
    //   180: lstore 11
    //   182: aload_0
    //   183: getfield 52	com/google/android/gms/internal/fa:tn	Lcom/google/android/gms/internal/fj;
    //   186: getfield 304	com/google/android/gms/internal/fj:ue	Ljava/lang/String;
    //   189: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   192: istore 13
    //   194: iload 13
    //   196: ifne +181 -> 377
    //   199: new 306	org/json/JSONObject
    //   202: dup
    //   203: aload_0
    //   204: getfield 52	com/google/android/gms/internal/fa:tn	Lcom/google/android/gms/internal/fj;
    //   207: getfield 304	com/google/android/gms/internal/fj:ue	Ljava/lang/String;
    //   210: invokespecial 307	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   213: astore 14
    //   215: new 309	com/google/android/gms/internal/fy$a
    //   218: dup
    //   219: aload 4
    //   221: aload_0
    //   222: getfield 52	com/google/android/gms/internal/fa:tn	Lcom/google/android/gms/internal/fj;
    //   225: aload_0
    //   226: getfield 195	com/google/android/gms/internal/fa:qi	Lcom/google/android/gms/internal/cr;
    //   229: aload 9
    //   231: iload 5
    //   233: lload 11
    //   235: aload_0
    //   236: getfield 52	com/google/android/gms/internal/fa:tn	Lcom/google/android/gms/internal/fj;
    //   239: getfield 313	com/google/android/gms/internal/fj:ua	J
    //   242: aload 14
    //   244: invokespecial 316	com/google/android/gms/internal/fy$a:<init>	(Lcom/google/android/gms/internal/fh;Lcom/google/android/gms/internal/fj;Lcom/google/android/gms/internal/cr;Lcom/google/android/gms/internal/ay;IJJLorg/json/JSONObject;)V
    //   247: astore 15
    //   249: getstatic 290	com/google/android/gms/internal/gq:wR	Landroid/os/Handler;
    //   252: new 318	com/google/android/gms/internal/fa$2
    //   255: dup
    //   256: aload_0
    //   257: aload 15
    //   259: invokespecial 321	com/google/android/gms/internal/fa$2:<init>	(Lcom/google/android/gms/internal/fa;Lcom/google/android/gms/internal/fy$a;)V
    //   262: invokevirtual 301	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   265: pop
    //   266: aload_1
    //   267: monitorexit
    //   268: return
    //   269: aload 21
    //   271: monitorexit
    //   272: aload_0
    //   273: lload 18
    //   275: invokespecial 323	com/google/android/gms/internal/fa:e	(J)V
    //   278: invokestatic 153	android/os/SystemClock:elapsedRealtime	()J
    //   281: lstore 6
    //   283: aload_0
    //   284: invokespecial 325	com/google/android/gms/internal/fa:cE	()V
    //   287: aload 4
    //   289: getfield 96	com/google/android/gms/internal/fh:lS	Lcom/google/android/gms/internal/ay;
    //   292: getfield 102	com/google/android/gms/internal/ay:or	[Lcom/google/android/gms/internal/ay;
    //   295: ifnull +93 -> 388
    //   298: aload_0
    //   299: aload 4
    //   301: invokespecial 327	com/google/android/gms/internal/fa:a	(Lcom/google/android/gms/internal/fh;)Lcom/google/android/gms/internal/ay;
    //   304: astore 23
    //   306: aload 23
    //   308: astore 9
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 52	com/google/android/gms/internal/fa:tn	Lcom/google/android/gms/internal/fj;
    //   315: getfield 330	com/google/android/gms/internal/fj:uh	Z
    //   318: invokespecial 332	com/google/android/gms/internal/fa:t	(Z)V
    //   321: lload 6
    //   323: lstore 11
    //   325: goto -143 -> 182
    //   328: aload 8
    //   330: invokevirtual 278	com/google/android/gms/internal/fa$a:getMessage	()Ljava/lang/String;
    //   333: invokestatic 335	com/google/android/gms/internal/gr:W	(Ljava/lang/String;)V
    //   336: goto -193 -> 143
    //   339: astore_2
    //   340: aload_1
    //   341: monitorexit
    //   342: aload_2
    //   343: athrow
    //   344: aload_0
    //   345: new 54	com/google/android/gms/internal/fj
    //   348: dup
    //   349: iload 5
    //   351: aload_0
    //   352: getfield 52	com/google/android/gms/internal/fa:tn	Lcom/google/android/gms/internal/fj;
    //   355: getfield 338	com/google/android/gms/internal/fj:qA	J
    //   358: invokespecial 341	com/google/android/gms/internal/fj:<init>	(IJ)V
    //   361: putfield 52	com/google/android/gms/internal/fa:tn	Lcom/google/android/gms/internal/fj;
    //   364: goto -201 -> 163
    //   367: astore 17
    //   369: ldc_w 343
    //   372: aload 17
    //   374: invokestatic 346	com/google/android/gms/internal/gr:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   377: aconst_null
    //   378: astore 14
    //   380: goto -165 -> 215
    //   383: astore 8
    //   385: goto -269 -> 116
    //   388: aconst_null
    //   389: astore 9
    //   391: goto -81 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	fa
    //   4	337	1	localObject1	Object
    //   339	4	2	localObject2	Object
    //   28	10	3	str	String
    //   41	259	4	localfh	fh
    //   45	305	5	i	int
    //   50	272	6	l1	long
    //   111	218	8	locala1	a
    //   383	1	8	locala2	a
    //   114	276	9	localObject3	Object
    //   180	144	11	l2	long
    //   192	3	13	bool	boolean
    //   213	166	14	localJSONObject	org.json.JSONObject
    //   247	11	15	locala	fy.a
    //   367	6	17	localException	Exception
    //   55	219	18	l3	long
    //   67	13	20	localgf	gf
    //   73	197	21	localObject4	Object
    //   103	6	22	localObject5	Object
    //   304	3	23	localay	ay
    // Exception table:
    //   from	to	target	type
    //   78	103	103	finally
    //   105	108	103	finally
    //   269	272	103	finally
    //   52	78	111	com/google/android/gms/internal/fa$a
    //   108	111	111	com/google/android/gms/internal/fa$a
    //   272	306	111	com/google/android/gms/internal/fa$a
    //   7	43	339	finally
    //   52	78	339	finally
    //   108	111	339	finally
    //   116	123	339	finally
    //   135	143	339	finally
    //   143	163	339	finally
    //   163	178	339	finally
    //   182	194	339	finally
    //   199	215	339	finally
    //   215	268	339	finally
    //   272	306	339	finally
    //   310	321	339	finally
    //   328	336	339	finally
    //   340	342	339	finally
    //   344	364	339	finally
    //   369	377	339	finally
    //   199	215	367	java/lang/Exception
    //   310	321	383	com/google/android/gms/internal/fa$a
  }
  
  public void onStop()
  {
    synchronized (this.tj)
    {
      if (this.tm != null) {
        this.tm.cancel();
      }
      return;
    }
  }
  
  @ey
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
 * Qualified Name:     com.google.android.gms.internal.fa
 * JD-Core Version:    0.7.0.1
 */