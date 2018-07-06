package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ey
public class gj<T>
  implements Future<T>
{
  private final Object mH = new Object();
  private boolean qj = false;
  private T wF = null;
  private boolean wG = false;
  
  public void a(T paramT)
  {
    synchronized (this.mH)
    {
      if (this.wG) {
        throw new IllegalStateException("Provided CallbackFuture with multiple values.");
      }
    }
    this.wG = true;
    this.wF = paramT;
    this.mH.notifyAll();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    synchronized (this.mH)
    {
      if (this.wG) {
        return false;
      }
    }
    this.qj = true;
    this.wG = true;
    this.mH.notifyAll();
    return true;
  }
  
  public T get()
  {
    synchronized (this.mH)
    {
      boolean bool = this.wG;
      if (bool) {}
    }
    try
    {
      this.mH.wait();
      label23:
      if (this.qj)
      {
        throw new CancellationException("CallbackFuture was cancelled.");
        localObject2 = finally;
        throw localObject2;
      }
      Object localObject3 = this.wF;
      return localObject3;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label23;
    }
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    synchronized (this.mH)
    {
      boolean bool = this.wG;
      if (!bool) {}
      try
      {
        long l = paramTimeUnit.toMillis(paramLong);
        if (l != 0L) {
          this.mH.wait(l);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        label43:
        Object localObject3;
        break label43;
      }
      if (!this.wG) {
        throw new TimeoutException("CallbackFuture timed out.");
      }
    }
    if (this.qj) {
      throw new CancellationException("CallbackFuture was cancelled.");
    }
    localObject3 = this.wF;
    return localObject3;
  }
  
  public boolean isCancelled()
  {
    synchronized (this.mH)
    {
      boolean bool = this.qj;
      return bool;
    }
  }
  
  public boolean isDone()
  {
    synchronized (this.mH)
    {
      boolean bool = this.wG;
      return bool;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gj
 * JD-Core Version:    0.7.0.1
 */