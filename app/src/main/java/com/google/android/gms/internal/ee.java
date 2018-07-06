package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

@ey
public class ee
  extends eo.a
  implements ServiceConnection
{
  private final Activity nB;
  private eb sF;
  private final eh sG;
  private ek sI;
  private Context sO;
  private em sP;
  private ef sQ;
  private ej sR;
  private String sS = null;
  
  public ee(Activity paramActivity)
  {
    this.nB = paramActivity;
    this.sG = eh.j(this.nB.getApplicationContext());
  }
  
  public static void a(Context paramContext, boolean paramBoolean, ea paramea)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", paramBoolean);
    ea.a(localIntent, paramea);
    paramContext.startActivity(localIntent);
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    if (this.sR != null) {
      this.sR.a(paramString, paramBoolean, paramInt, paramIntent, this.sQ);
    }
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: sipush 1001
    //   4: if_icmpne +85 -> 89
    //   7: aload_3
    //   8: invokestatic 96	com/google/android/gms/internal/ei:d	(Landroid/content/Intent;)I
    //   11: istore 6
    //   13: iload_2
    //   14: iconst_m1
    //   15: if_icmpne +75 -> 90
    //   18: iload 6
    //   20: ifne +70 -> 90
    //   23: aload_0
    //   24: getfield 98	com/google/android/gms/internal/ee:sI	Lcom/google/android/gms/internal/ek;
    //   27: aload_0
    //   28: getfield 32	com/google/android/gms/internal/ee:sS	Ljava/lang/String;
    //   31: iload_2
    //   32: aload_3
    //   33: invokevirtual 103	com/google/android/gms/internal/ek:a	(Ljava/lang/String;ILandroid/content/Intent;)Z
    //   36: istore 8
    //   38: iconst_0
    //   39: istore 7
    //   41: iload 8
    //   43: ifeq +6 -> 49
    //   46: iconst_1
    //   47: istore 7
    //   49: aload_0
    //   50: getfield 105	com/google/android/gms/internal/ee:sP	Lcom/google/android/gms/internal/em;
    //   53: iload 6
    //   55: invokeinterface 111 2 0
    //   60: aload_0
    //   61: getfield 34	com/google/android/gms/internal/ee:nB	Landroid/app/Activity;
    //   64: invokevirtual 114	android/app/Activity:finish	()V
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 105	com/google/android/gms/internal/ee:sP	Lcom/google/android/gms/internal/em;
    //   72: invokeinterface 118 1 0
    //   77: iload 7
    //   79: iload_2
    //   80: aload_3
    //   81: invokespecial 120	com/google/android/gms/internal/ee:a	(Ljava/lang/String;ZILandroid/content/Intent;)V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 32	com/google/android/gms/internal/ee:sS	Ljava/lang/String;
    //   89: return
    //   90: aload_0
    //   91: getfield 48	com/google/android/gms/internal/ee:sG	Lcom/google/android/gms/internal/eh;
    //   94: aload_0
    //   95: getfield 81	com/google/android/gms/internal/ee:sQ	Lcom/google/android/gms/internal/ef;
    //   98: invokevirtual 123	com/google/android/gms/internal/eh:a	(Lcom/google/android/gms/internal/ef;)V
    //   101: iconst_0
    //   102: istore 7
    //   104: goto -55 -> 49
    //   107: astore 5
    //   109: ldc 125
    //   111: invokestatic 131	com/google/android/gms/internal/gr:W	(Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 34	com/google/android/gms/internal/ee:nB	Landroid/app/Activity;
    //   118: invokevirtual 114	android/app/Activity:finish	()V
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 32	com/google/android/gms/internal/ee:sS	Ljava/lang/String;
    //   126: return
    //   127: astore 4
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 32	com/google/android/gms/internal/ee:sS	Ljava/lang/String;
    //   134: aload 4
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	ee
    //   0	137	1	paramInt1	int
    //   0	137	2	paramInt2	int
    //   0	137	3	paramIntent	Intent
    //   127	8	4	localObject	java.lang.Object
    //   107	1	5	localRemoteException	RemoteException
    //   11	43	6	i	int
    //   39	64	7	bool1	boolean
    //   36	6	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	13	107	android/os/RemoteException
    //   23	38	107	android/os/RemoteException
    //   49	84	107	android/os/RemoteException
    //   90	101	107	android/os/RemoteException
    //   7	13	127	finally
    //   23	38	127	finally
    //   49	84	127	finally
    //   90	101	127	finally
    //   109	121	127	finally
  }
  
  public void onCreate()
  {
    ea localea = ea.c(this.nB.getIntent());
    this.sR = localea.sB;
    this.sI = localea.md;
    this.sP = localea.sz;
    this.sF = new eb(this.nB.getApplicationContext());
    this.sO = localea.sA;
    if (this.nB.getResources().getConfiguration().orientation == 2) {
      this.nB.setRequestedOrientation(6);
    }
    for (;;)
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      this.nB.bindService(localIntent, this, 1);
      return;
      this.nB.setRequestedOrientation(7);
    }
  }
  
  public void onDestroy()
  {
    this.nB.unbindService(this);
    this.sF.destroy();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.sF.t(paramIBinder);
    try
    {
      this.sS = this.sI.cC();
      Bundle localBundle = this.sF.a(this.nB.getPackageName(), this.sP.getProductId(), this.sS);
      PendingIntent localPendingIntent = (PendingIntent)localBundle.getParcelable("BUY_INTENT");
      if (localPendingIntent == null)
      {
        int i = ei.b(localBundle);
        this.sP.recordPlayBillingResolution(i);
        a(this.sP.getProductId(), false, i, null);
        this.nB.finish();
        return;
      }
      this.sQ = new ef(this.sP.getProductId(), this.sS);
      this.sG.b(this.sQ);
      this.nB.startIntentSenderForResult(localPendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Error when connecting in-app billing service", localRemoteException);
      this.nB.finish();
      return;
    }
    catch (IntentSender.SendIntentException localSendIntentException)
    {
      label188:
      break label188;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    gr.U("In-app billing service disconnected.");
    this.sF.destroy();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ee
 * JD-Core Version:    0.7.0.1
 */