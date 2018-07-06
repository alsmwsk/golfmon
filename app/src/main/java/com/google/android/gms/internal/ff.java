package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@ey
public abstract class ff
  extends gf
{
  private final fh qh;
  private final fe.a tI;
  
  public ff(fh paramfh, fe.a parama)
  {
    this.qh = paramfh;
    this.tI = parama;
  }
  
  private static fj a(fl paramfl, fh paramfh)
  {
    try
    {
      fj localfj = paramfl.b(paramfh);
      return localfj;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not fetch ad response from ad request service.", localRemoteException);
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
      gr.d("Could not fetch ad response from ad request service due to an Exception.", localNullPointerException);
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      gr.d("Could not fetch ad response from ad request service due to an Exception.", localSecurityException);
      return null;
    }
    catch (Throwable localThrowable)
    {
      ga.e(localThrowable);
    }
    return null;
  }
  
  public abstract void cJ();
  
  public abstract fl cK();
  
  /* Error */
  public final void cx()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 56	com/google/android/gms/internal/ff:cK	()Lcom/google/android/gms/internal/fl;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +27 -> 33
    //   9: new 58	com/google/android/gms/internal/fj
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 61	com/google/android/gms/internal/fj:<init>	(I)V
    //   17: astore_3
    //   18: aload_0
    //   19: invokevirtual 63	com/google/android/gms/internal/ff:cJ	()V
    //   22: aload_0
    //   23: getfield 18	com/google/android/gms/internal/ff:tI	Lcom/google/android/gms/internal/fe$a;
    //   26: aload_3
    //   27: invokeinterface 68 2 0
    //   32: return
    //   33: aload_2
    //   34: aload_0
    //   35: getfield 16	com/google/android/gms/internal/ff:qh	Lcom/google/android/gms/internal/fh;
    //   38: invokestatic 70	com/google/android/gms/internal/ff:a	(Lcom/google/android/gms/internal/fl;Lcom/google/android/gms/internal/fh;)Lcom/google/android/gms/internal/fj;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnonnull -25 -> 18
    //   46: new 58	com/google/android/gms/internal/fj
    //   49: dup
    //   50: iconst_0
    //   51: invokespecial 61	com/google/android/gms/internal/fj:<init>	(I)V
    //   54: astore_3
    //   55: goto -37 -> 18
    //   58: astore_1
    //   59: aload_0
    //   60: invokevirtual 63	com/google/android/gms/internal/ff:cJ	()V
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	ff
    //   58	6	1	localObject	Object
    //   4	30	2	localfl	fl
    //   17	38	3	localfj	fj
    // Exception table:
    //   from	to	target	type
    //   0	5	58	finally
    //   9	18	58	finally
    //   33	42	58	finally
    //   46	55	58	finally
  }
  
  public final void onStop()
  {
    cJ();
  }
  
  @ey
  public static final class a
    extends ff
  {
    private final Context mContext;
    
    public a(Context paramContext, fh paramfh, fe.a parama)
    {
      super(parama);
      this.mContext = paramContext;
    }
    
    public void cJ() {}
    
    public fl cK()
    {
      Bundle localBundle = ga.bN();
      bm localbm = new bm(localBundle.getString("gads:sdk_core_location"), localBundle.getString("gads:sdk_core_experiment_id"), localBundle.getString("gads:block_autoclicks_experiment_id"), localBundle.getString("gads:spam_app_context:experiment_id"));
      return fq.a(this.mContext, localbm, new co(), new fx());
    }
  }
  
  @ey
  public static final class b
    extends ff
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private final Object mH = new Object();
    private final fe.a tI;
    private final fg tJ;
    
    public b(Context paramContext, fh paramfh, fe.a parama)
    {
      super(parama);
      this.tI = parama;
      this.tJ = new fg(paramContext, this, this, paramfh.lO.wU);
      this.tJ.connect();
    }
    
    public void cJ()
    {
      synchronized (this.mH)
      {
        if ((this.tJ.isConnected()) || (this.tJ.isConnecting())) {
          this.tJ.disconnect();
        }
        return;
      }
    }
    
    /* Error */
    public fl cK()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 27	com/google/android/gms/internal/ff$b:mH	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 48	com/google/android/gms/internal/ff$b:tJ	Lcom/google/android/gms/internal/fg;
      //   11: invokevirtual 71	com/google/android/gms/internal/fg:cL	()Lcom/google/android/gms/internal/fl;
      //   14: astore 5
      //   16: aload_1
      //   17: monitorexit
      //   18: aload 5
      //   20: areturn
      //   21: aload_1
      //   22: monitorexit
      //   23: aconst_null
      //   24: areturn
      //   25: astore_3
      //   26: aload_1
      //   27: monitorexit
      //   28: aload_3
      //   29: athrow
      //   30: astore_2
      //   31: goto -10 -> 21
      //   34: astore 4
      //   36: goto -15 -> 21
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	b
      //   30	1	2	localDeadObjectException	android.os.DeadObjectException
      //   25	4	3	localObject2	Object
      //   34	1	4	localIllegalStateException	java.lang.IllegalStateException
      //   14	5	5	localfl	fl
      // Exception table:
      //   from	to	target	type
      //   7	16	25	finally
      //   16	18	25	finally
      //   21	23	25	finally
      //   26	28	25	finally
      //   7	16	30	android/os/DeadObjectException
      //   7	16	34	java/lang/IllegalStateException
    }
    
    public void onConnected(Bundle paramBundle)
    {
      start();
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.tI.a(new fj(0));
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      gr.S("Disconnected from remote ad request service.");
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ff
 * JD-Core Version:    0.7.0.1
 */