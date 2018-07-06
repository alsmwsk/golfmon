package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract interface PendingResult<R extends Result>
{
  public abstract void a(a parama);
  
  public abstract R await();
  
  public abstract R await(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void cancel();
  
  public abstract boolean isCanceled();
  
  public abstract void setResultCallback(ResultCallback<R> paramResultCallback);
  
  public abstract void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit);
  
  public static abstract interface a
  {
    public abstract void m(Status paramStatus);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResult
 * JD-Core Version:    0.7.0.1
 */