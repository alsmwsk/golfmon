package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.ag.a;
import com.google.android.gms.drive.internal.w;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService
  extends Service
  implements ChangeListener, CompletionListener
{
  public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
  private CountDownLatch Pg;
  a Ph;
  boolean Pi = false;
  int Pj = -1;
  private final String mName;
  
  protected DriveEventService()
  {
    this("DriveEventService");
  }
  
  protected DriveEventService(String paramString)
  {
    this.mName = paramString;
  }
  
  private void a(OnEventResponse paramOnEventResponse)
  {
    DriveEvent localDriveEvent = paramOnEventResponse.iQ();
    w.m("DriveEventService", "handleEventMessage: " + localDriveEvent);
    try
    {
      switch (localDriveEvent.getType())
      {
      default: 
        w.o(this.mName, "Unhandled event: " + localDriveEvent);
        return;
      }
    }
    catch (Exception localException)
    {
      w.a(this.mName, localException, "Error handling event: " + localDriveEvent);
      return;
    }
    onChange((ChangeEvent)localDriveEvent);
    return;
    onCompletion((CompletionEvent)localDriveEvent);
  }
  
  private boolean bh(int paramInt)
  {
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    boolean bool = false;
    int i;
    if (arrayOfString != null) {
      i = arrayOfString.length;
    }
    for (int j = 0;; j++)
    {
      bool = false;
      if (j < i)
      {
        if ("com.google.android.gms".equals(arrayOfString[j])) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  private void iD()
    throws SecurityException
  {
    int i = getCallingUid();
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
  
  protected int getCallingUid()
  {
    return Binder.getCallingUid();
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        if ("com.google.android.gms.drive.events.HANDLE_EVENT".equals(paramIntent.getAction()))
        {
          final CountDownLatch localCountDownLatch;
          if ((this.Ph == null) && (!this.Pi))
          {
            this.Pi = true;
            localCountDownLatch = new CountDownLatch(1);
            this.Pg = new CountDownLatch(1);
            new Thread()
            {
              public void run()
              {
                try
                {
                  Looper.prepare();
                  DriveEventService.this.Ph = new DriveEventService.a(DriveEventService.this);
                  DriveEventService.this.Pi = false;
                  localCountDownLatch.countDown();
                  w.m("DriveEventService", "Bound and starting loop");
                  Looper.loop();
                  w.m("DriveEventService", "Finished loop");
                  return;
                }
                finally
                {
                  if (DriveEventService.b(DriveEventService.this) != null) {
                    DriveEventService.b(DriveEventService.this).countDown();
                  }
                }
              }
            }.start();
          }
          try
          {
            if (!localCountDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
              w.p("DriveEventService", "Failed to synchronously initialize event handler.");
            }
            IBinder localIBinder2 = new b().asBinder();
            localIBinder1 = localIBinder2;
            return localIBinder1;
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException("Unable to start event handler", localInterruptedException);
          }
        }
        IBinder localIBinder1 = null;
      }
      finally {}
    }
  }
  
  public void onChange(ChangeEvent paramChangeEvent)
  {
    w.o(this.mName, "Unhandled change event: " + paramChangeEvent);
  }
  
  public void onCompletion(CompletionEvent paramCompletionEvent)
  {
    w.o(this.mName, "Unhandled completion event: " + paramCompletionEvent);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 25
    //   4: ldc 207
    //   6: invokestatic 77	com/google/android/gms/drive/internal/w:m	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 156	com/google/android/gms/drive/events/DriveEventService:Ph	Lcom/google/android/gms/drive/events/DriveEventService$a;
    //   13: ifnull +53 -> 66
    //   16: aload_0
    //   17: getfield 156	com/google/android/gms/drive/events/DriveEventService:Ph	Lcom/google/android/gms/drive/events/DriveEventService$a;
    //   20: invokestatic 212	com/google/android/gms/drive/events/DriveEventService$a:a	(Lcom/google/android/gms/drive/events/DriveEventService$a;)Landroid/os/Message;
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 156	com/google/android/gms/drive/events/DriveEventService:Ph	Lcom/google/android/gms/drive/events/DriveEventService$a;
    //   28: aload_2
    //   29: invokevirtual 216	com/google/android/gms/drive/events/DriveEventService$a:sendMessage	(Landroid/os/Message;)Z
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 156	com/google/android/gms/drive/events/DriveEventService:Ph	Lcom/google/android/gms/drive/events/DriveEventService$a;
    //   38: aload_0
    //   39: getfield 109	com/google/android/gms/drive/events/DriveEventService:Pg	Ljava/util/concurrent/CountDownLatch;
    //   42: ldc2_w 170
    //   45: getstatic 177	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   48: invokevirtual 181	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   51: ifne +10 -> 61
    //   54: ldc 25
    //   56: ldc 218
    //   58: invokestatic 88	com/google/android/gms/drive/internal/w:o	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 109	com/google/android/gms/drive/events/DriveEventService:Pg	Ljava/util/concurrent/CountDownLatch;
    //   66: aload_0
    //   67: invokespecial 220	android/app/Service:onDestroy	()V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore 4
    //   80: goto -19 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	DriveEventService
    //   73	4	1	localObject	Object
    //   23	6	2	localMessage	Message
    //   78	1	4	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	38	73	finally
    //   38	61	73	finally
    //   61	66	73	finally
    //   66	70	73	finally
    //   38	61	78	java/lang/InterruptedException
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return true;
  }
  
  final class a
    extends Handler
  {
    a() {}
    
    private Message b(OnEventResponse paramOnEventResponse)
    {
      return obtainMessage(1, paramOnEventResponse);
    }
    
    private Message iE()
    {
      return obtainMessage(2);
    }
    
    public void handleMessage(Message paramMessage)
    {
      w.m("DriveEventService", "handleMessage message type:" + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        w.o("DriveEventService", "Unexpected message type:" + paramMessage.what);
        return;
      case 1: 
        DriveEventService.a(DriveEventService.this, (OnEventResponse)paramMessage.obj);
        return;
      }
      getLooper().quit();
    }
  }
  
  final class b
    extends ag.a
  {
    b() {}
    
    public void c(OnEventResponse paramOnEventResponse)
      throws RemoteException
    {
      synchronized (DriveEventService.this)
      {
        w.m("DriveEventService", "onEvent: " + paramOnEventResponse);
        DriveEventService.a(DriveEventService.this);
        if (DriveEventService.this.Ph != null)
        {
          Message localMessage = DriveEventService.a.a(DriveEventService.this.Ph, paramOnEventResponse);
          DriveEventService.this.Ph.sendMessage(localMessage);
          return;
        }
        w.p("DriveEventService", "Receiving event before initialize is completed.");
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.DriveEventService
 * JD-Core Version:    0.7.0.1
 */