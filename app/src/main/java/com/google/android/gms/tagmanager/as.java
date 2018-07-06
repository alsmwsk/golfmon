package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as
  extends Thread
  implements ar
{
  private static as ary;
  private final LinkedBlockingQueue<Runnable> arx = new LinkedBlockingQueue();
  private volatile at arz;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile boolean zK = false;
  
  private as(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  static as Z(Context paramContext)
  {
    if (ary == null) {
      ary = new as(paramContext);
    }
    return ary;
  }
  
  private String g(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void b(Runnable paramRunnable)
  {
    this.arx.add(paramRunnable);
  }
  
  void b(String paramString, final long paramLong)
  {
    b(new Runnable()
    {
      public void run()
      {
        if (as.a(as.this) == null)
        {
          cy localcy = cy.qN();
          localcy.a(as.b(as.this), jdField_this);
          as.a(as.this, localcy.qO());
        }
        as.a(as.this).f(paramLong, this.wO);
      }
    });
  }
  
  public void cE(String paramString)
  {
    b(paramString, System.currentTimeMillis());
  }
  
  public void run()
  {
    while (!this.mClosed) {
      try
      {
        Runnable localRunnable = (Runnable)this.arx.take();
        if (!this.zK) {
          localRunnable.run();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        bh.U(localInterruptedException.toString());
      }
      catch (Throwable localThrowable)
      {
        bh.T("Error on Google TagManager Thread: " + g(localThrowable));
        bh.T("Google TagManager is shutting down.");
        this.zK = true;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.as
 * JD-Core Version:    0.7.0.1
 */