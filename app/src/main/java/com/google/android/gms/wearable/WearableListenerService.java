package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.ae.a;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.al;

public abstract class WearableListenerService
  extends Service
  implements DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private String CS;
  private IBinder Nk;
  private volatile int Pj = -1;
  private Handler axn;
  private Object axo = new Object();
  private boolean axp;
  
  private boolean bh(int paramInt)
  {
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    boolean bool = false;
    if (arrayOfString != null) {}
    for (int i = 0;; i++)
    {
      int j = arrayOfString.length;
      bool = false;
      if (i < j)
      {
        if ("com.google.android.gms".equals(arrayOfString[i])) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  private void rl()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (i == this.Pj) {
      return;
    }
    if ((GooglePlayServicesUtil.b(getPackageManager(), "com.google.android.gms")) && (bh(i)))
    {
      this.Pj = i;
      return;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return this.Nk;
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", "onCreate: " + getPackageName());
    }
    this.CS = getPackageName();
    HandlerThread localHandlerThread = new HandlerThread("WearableListenerService");
    localHandlerThread.start();
    this.axn = new Handler(localHandlerThread.getLooper());
    this.Nk = new a(null);
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer) {}
  
  public void onDestroy()
  {
    synchronized (this.axo)
    {
      this.axp = true;
      this.axn.getLooper().quit();
      super.onDestroy();
      return;
    }
  }
  
  public void onMessageReceived(MessageEvent paramMessageEvent) {}
  
  public void onPeerConnected(Node paramNode) {}
  
  public void onPeerDisconnected(Node paramNode) {}
  
  private class a
    extends ae.a
  {
    private a() {}
    
    public void a(final ai paramai)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onMessageReceived: " + paramai);
      }
      WearableListenerService.b(WearableListenerService.this);
      synchronized (WearableListenerService.c(WearableListenerService.this))
      {
        if (WearableListenerService.d(WearableListenerService.this)) {
          return;
        }
        WearableListenerService.e(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            WearableListenerService.this.onMessageReceived(paramai);
          }
        });
        return;
      }
    }
    
    public void a(final al paramal)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onPeerConnected: " + WearableListenerService.a(WearableListenerService.this) + ": " + paramal);
      }
      WearableListenerService.b(WearableListenerService.this);
      synchronized (WearableListenerService.c(WearableListenerService.this))
      {
        if (WearableListenerService.d(WearableListenerService.this)) {
          return;
        }
        WearableListenerService.e(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            WearableListenerService.this.onPeerConnected(paramal);
          }
        });
        return;
      }
    }
    
    public void aa(final DataHolder paramDataHolder)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onDataItemChanged: " + WearableListenerService.a(WearableListenerService.this) + ": " + paramDataHolder);
      }
      WearableListenerService.b(WearableListenerService.this);
      synchronized (WearableListenerService.c(WearableListenerService.this))
      {
        if (WearableListenerService.d(WearableListenerService.this))
        {
          paramDataHolder.close();
          return;
        }
        WearableListenerService.e(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            DataEventBuffer localDataEventBuffer = new DataEventBuffer(paramDataHolder);
            try
            {
              WearableListenerService.this.onDataChanged(localDataEventBuffer);
              return;
            }
            finally
            {
              localDataEventBuffer.release();
            }
          }
        });
        return;
      }
    }
    
    public void b(final al paramal)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onPeerDisconnected: " + WearableListenerService.a(WearableListenerService.this) + ": " + paramal);
      }
      WearableListenerService.b(WearableListenerService.this);
      synchronized (WearableListenerService.c(WearableListenerService.this))
      {
        if (WearableListenerService.d(WearableListenerService.this)) {
          return;
        }
        WearableListenerService.e(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            WearableListenerService.this.onPeerDisconnected(paramal);
          }
        });
        return;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService
 * JD-Core Version:    0.7.0.1
 */