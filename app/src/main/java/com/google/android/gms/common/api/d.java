package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.jx;

public final class d<L>
{
  private final d<L>.a Kt;
  private volatile L mListener;
  
  d(Looper paramLooper, L paramL)
  {
    this.Kt = new a(paramLooper);
    this.mListener = jx.b(paramL, "Listener must not be null");
  }
  
  public void a(b<? super L> paramb)
  {
    jx.b(paramb, "Notifier must not be null");
    Message localMessage = this.Kt.obtainMessage(1, paramb);
    this.Kt.sendMessage(localMessage);
  }
  
  void b(b<? super L> paramb)
  {
    Object localObject = this.mListener;
    if (localObject == null)
    {
      paramb.gG();
      return;
    }
    try
    {
      paramb.c(localObject);
      return;
    }
    catch (Exception localException)
    {
      Log.w("ListenerHolder", "Notifying listener failed", localException);
      paramb.gG();
    }
  }
  
  public void clear()
  {
    this.mListener = null;
  }
  
  private final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = 1;
      if (paramMessage.what == i) {}
      for (;;)
      {
        jx.L(i);
        d.this.b((d.b)paramMessage.obj);
        return;
        int j = 0;
      }
    }
  }
  
  public static abstract interface b<L>
  {
    public abstract void c(L paramL);
    
    public abstract void gG();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.d
 * JD-Core Version:    0.7.0.1
 */