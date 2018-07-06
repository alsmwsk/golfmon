package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@ey
public class ec
  extends gf
  implements ServiceConnection
{
  private Context mContext;
  private final Object mH = new Object();
  private boolean sD = false;
  private er sE;
  private eb sF;
  private eh sG;
  private List<ef> sH = null;
  private ek sI;
  
  public ec(Context paramContext, er paramer, ek paramek)
  {
    this.mContext = paramContext;
    this.sE = paramer;
    this.sI = paramek;
    this.sF = new eb(paramContext);
    this.sG = eh.j(this.mContext);
    this.sH = this.sG.d(10L);
  }
  
  private void a(final ef paramef, String paramString1, String paramString2)
  {
    final Intent localIntent = new Intent();
    localIntent.putExtra("RESPONSE_CODE", 0);
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    gq.wR.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (ec.a(ec.this).a(paramef.sU, -1, localIntent))
          {
            ec.c(ec.this).a(new eg(ec.b(ec.this), paramef.sV, true, -1, localIntent, paramef));
            return;
          }
          ec.c(ec.this).a(new eg(ec.b(ec.this), paramef.sV, false, -1, localIntent, paramef));
          return;
        }
        catch (RemoteException localRemoteException)
        {
          gr.W("Fail to verify and dispatch pending transaction");
        }
      }
    });
  }
  
  private void b(long paramLong)
  {
    do
    {
      if (!c(paramLong)) {
        gr.W("Timeout waiting for pending transaction to be processed.");
      }
    } while (!this.sD);
  }
  
  private boolean c(long paramLong)
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
      for (;;)
      {
        gr.W("waitWithTimeout_lock interrupted");
      }
    }
  }
  
  private void cy()
  {
    if (this.sH.isEmpty()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.sH.iterator();
    while (localIterator1.hasNext())
    {
      ef localef2 = (ef)localIterator1.next();
      localHashMap.put(localef2.sV, localef2);
    }
    String str1;
    for (Object localObject = null;; localObject = str1)
    {
      Bundle localBundle = this.sF.d(this.mContext.getPackageName(), (String)localObject);
      if (localBundle == null) {}
      do
      {
        do
        {
          Iterator localIterator2 = localHashMap.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            this.sG.a((ef)localHashMap.get(str2));
          }
          break;
        } while (ei.b(localBundle) != 0);
        ArrayList localArrayList1 = localBundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList2 = localBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList3 = localBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        str1 = localBundle.getString("INAPP_CONTINUATION_TOKEN");
        for (int i = 0; i < localArrayList1.size(); i++) {
          if (localHashMap.containsKey(localArrayList1.get(i)))
          {
            String str3 = (String)localArrayList1.get(i);
            String str4 = (String)localArrayList2.get(i);
            String str5 = (String)localArrayList3.get(i);
            ef localef1 = (ef)localHashMap.get(str3);
            String str6 = ei.D(str4);
            if (localef1.sU.equals(str6))
            {
              a(localef1, str4, str5);
              localHashMap.remove(str3);
            }
          }
        }
      } while ((str1 == null) || (localHashMap.isEmpty()));
    }
  }
  
  public void cx()
  {
    synchronized (this.mH)
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      this.mContext.bindService(localIntent, this, 1);
      b(SystemClock.elapsedRealtime());
      this.mContext.unbindService(this);
      this.sF.destroy();
      return;
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (this.mH)
    {
      this.sF.t(paramIBinder);
      cy();
      this.sD = true;
      this.mH.notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    gr.U("In-app billing service disconnected.");
    this.sF.destroy();
  }
  
  public void onStop()
  {
    synchronized (this.mH)
    {
      this.mContext.unbindService(this);
      this.sF.destroy();
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ec
 * JD-Core Version:    0.7.0.1
 */