package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.ha;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class x
  extends Thread
  implements f
{
  private static x zM;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final LinkedBlockingQueue<Runnable> zJ = new LinkedBlockingQueue();
  private volatile boolean zK = false;
  private volatile String zL;
  private volatile ak zN;
  private final Lock zO;
  private final List<ha> zP = new ArrayList();
  
  private x(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      this.zP.add(new ha("appendVersion", "&_v".substring(1), "ma4.0.4"));
      this.zO = new ReentrantLock();
      start();
      return;
    }
  }
  
  static x A(Context paramContext)
  {
    if (zM == null) {
      zM = new x(paramContext);
    }
    return zM;
  }
  
  static String B(Context paramContext)
  {
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput("gaInstallData");
      arrayOfByte = new byte[8192];
      i = localFileInputStream.read(arrayOfByte, 0, 8192);
      if (localFileInputStream.available() > 0)
      {
        ae.T("Too much campaign data, ignoring it.");
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
        return null;
      }
      localFileInputStream.close();
      paramContext.deleteFile("gaInstallData");
      if (i <= 0)
      {
        ae.W("Campaign file is empty.");
        return null;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      byte[] arrayOfByte;
      int i;
      ae.U("No campaign data found.");
      return null;
      String str = new String(arrayOfByte, 0, i);
      ae.U("Campaign found: " + str);
      return str;
    }
    catch (IOException localIOException)
    {
      ae.T("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return null;
  }
  
  static int ah(String paramString)
  {
    int i = 1;
    if (!TextUtils.isEmpty(paramString))
    {
      int j = -1 + paramString.length();
      i = 0;
      for (int k = j; k >= 0; k--)
      {
        int m = paramString.charAt(k);
        i = m + (0xFFFFFFF & i << 6) + (m << 14);
        int n = 0xFE00000 & i;
        if (n != 0) {
          i ^= n >> 21;
        }
      }
    }
    return i;
  }
  
  private void b(Runnable paramRunnable)
  {
    this.zJ.add(paramRunnable);
  }
  
  private String g(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void dQ()
  {
    b(new a(null));
  }
  
  public void dW()
  {
    b(new c(null));
  }
  
  public LinkedBlockingQueue<Runnable> dX()
  {
    return this.zJ;
  }
  
  public void dY()
  {
    init();
    ArrayList localArrayList = new ArrayList();
    this.zJ.drainTo(localArrayList);
    this.zO.lock();
    try
    {
      this.zK = true;
      Iterator localIterator = localArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Runnable localRunnable = (Runnable)localIterator.next();
          try
          {
            localRunnable.run();
          }
          catch (Throwable localThrowable)
          {
            ae.T("Error dispatching all events on exit, giving up: " + g(localThrowable));
          }
        }
      }
      return;
    }
    finally
    {
      this.zO.unlock();
    }
  }
  
  public void dispatch()
  {
    b(new b(null));
  }
  
  public Thread getThread()
  {
    return this;
  }
  
  /* Error */
  protected void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 189	com/google/android/gms/analytics/x:zN	Lcom/google/android/gms/analytics/ak;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 276	com/google/android/gms/analytics/w
    //   18: dup
    //   19: aload_0
    //   20: getfield 56	com/google/android/gms/analytics/x:mContext	Landroid/content/Context;
    //   23: aload_0
    //   24: invokespecial 279	com/google/android/gms/analytics/w:<init>	(Landroid/content/Context;Lcom/google/android/gms/analytics/f;)V
    //   27: putfield 189	com/google/android/gms/analytics/x:zN	Lcom/google/android/gms/analytics/ak;
    //   30: aload_0
    //   31: getfield 189	com/google/android/gms/analytics/x:zN	Lcom/google/android/gms/analytics/ak;
    //   34: invokeinterface 284 1 0
    //   39: goto -28 -> 11
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	x
    //   42	4	1	localObject	Object
    //   6	2	2	localak	ak
    // Exception table:
    //   from	to	target	type
    //   2	7	42	finally
    //   14	39	42	finally
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      Thread.sleep(5000L);
    }
    catch (InterruptedException localInterruptedException1)
    {
      try
      {
        for (;;)
        {
          init();
          this.zL = B(this.mContext);
          ae.V("Initialized GA Thread");
          while (!this.mClosed) {
            try
            {
              localRunnable = (Runnable)this.zJ.take();
              this.zO.lock();
            }
            catch (InterruptedException localInterruptedException2)
            {
              try
              {
                Runnable localRunnable;
                if (!this.zK) {
                  localRunnable.run();
                }
                this.zO.unlock();
              }
              finally
              {
                this.zO.unlock();
              }
              localInterruptedException2 = localInterruptedException2;
              ae.U(localInterruptedException2.toString());
            }
            catch (Throwable localThrowable2)
            {
              ae.T("Error on GAThread: " + g(localThrowable2));
              ae.T("Google Analytics is shutting down.");
              this.zK = true;
            }
          }
          localInterruptedException1 = localInterruptedException1;
          ae.W("sleep interrupted in GAThread initialize");
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          ae.T("Error initializing the GAThread: " + g(localThrowable1));
          ae.T("Google Analytics will not start up.");
          this.zK = true;
        }
      }
    }
  }
  
  public void u(Map<String, String> paramMap)
  {
    b(new d(paramMap));
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      x.d(x.this).dQ();
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      x.d(x.this).dispatch();
    }
  }
  
  private class c
    implements Runnable
  {
    private c() {}
    
    public void run()
    {
      x.d(x.this).dW();
    }
  }
  
  private class d
    implements Runnable
  {
    private final Map<String, String> zR;
    
    d()
    {
      Map localMap;
      this.zR = new HashMap(localMap);
      String str = (String)localMap.get("&ht");
      if (str != null) {}
      try
      {
        Long.valueOf(str);
        if (str == null)
        {
          long l = System.currentTimeMillis();
          this.zR.put("&ht", Long.toString(l));
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          str = null;
        }
      }
    }
    
    private String v(Map<String, String> paramMap)
    {
      if (paramMap.containsKey("useSecure"))
      {
        if (an.f((String)paramMap.get("useSecure"), true)) {
          return "https:";
        }
        return "http:";
      }
      return "https:";
    }
    
    private void w(Map<String, String> paramMap)
    {
      q localq = a.w(x.a(x.this));
      an.a(paramMap, "&adid", localq);
      an.a(paramMap, "&ate", localq);
    }
    
    private void x(Map<String, String> paramMap)
    {
      g localg = g.dZ();
      an.a(paramMap, "&an", localg);
      an.a(paramMap, "&av", localg);
      an.a(paramMap, "&aid", localg);
      an.a(paramMap, "&aiid", localg);
      paramMap.put("&v", "1");
    }
    
    private boolean y(Map<String, String> paramMap)
    {
      if (paramMap.get("&sf") == null) {
        return false;
      }
      double d = an.a((String)paramMap.get("&sf"), 100.0D);
      if (d >= 100.0D) {
        return false;
      }
      if (x.ah((String)paramMap.get("&cid")) % 10000 >= d * 100.0D)
      {
        if (paramMap.get("&t") == null) {}
        for (String str = "unknown";; str = (String)paramMap.get("&t"))
        {
          ae.V(String.format("%s hit sampled out", new Object[] { str }));
          return true;
        }
      }
      return false;
    }
    
    public void run()
    {
      w(this.zR);
      if (TextUtils.isEmpty((CharSequence)this.zR.get("&cid"))) {
        this.zR.put("&cid", k.el().getValue("&cid"));
      }
      if ((GoogleAnalytics.getInstance(x.a(x.this)).getAppOptOut()) || (y(this.zR))) {
        return;
      }
      if (!TextUtils.isEmpty(x.b(x.this)))
      {
        y.eK().D(true);
        this.zR.putAll(new HitBuilders.HitBuilder().setCampaignParamsFromUrl(x.b(x.this)).build());
        y.eK().D(false);
        x.a(x.this, null);
      }
      x(this.zR);
      Map localMap = ac.z(this.zR);
      x.d(x.this).b(localMap, Long.valueOf((String)this.zR.get("&ht")).longValue(), v(this.zR), x.c(x.this));
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.x
 * JD-Core Version:    0.7.0.1
 */