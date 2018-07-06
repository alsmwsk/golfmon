package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BaseImplementation
{
  static void a(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("GoogleApi", "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  public static abstract class AbstractPendingResult<R extends Result>
    implements BaseImplementation.b<R>, PendingResult<R>
  {
    private final Object Jp = new Object();
    private final ArrayList<PendingResult.a> Jq = new ArrayList();
    private ResultCallback<R> Jr;
    private volatile R Js;
    private volatile boolean Jt;
    private boolean Ju;
    private boolean Jv;
    private jr Jw;
    protected final BaseImplementation.CallbackHandler<R> mHandler;
    private final CountDownLatch mr = new CountDownLatch(1);
    
    protected AbstractPendingResult(Looper paramLooper)
    {
      this.mHandler = new BaseImplementation.CallbackHandler(paramLooper);
    }
    
    protected AbstractPendingResult(BaseImplementation.CallbackHandler<R> paramCallbackHandler)
    {
      this.mHandler = paramCallbackHandler;
    }
    
    private void c(R paramR)
    {
      this.Js = paramR;
      this.Jw = null;
      this.mr.countDown();
      Status localStatus = this.Js.getStatus();
      if (this.Jr != null)
      {
        this.mHandler.removeTimeoutMessages();
        if (!this.Ju) {
          this.mHandler.sendResultCallback(this.Jr, gA());
        }
      }
      Iterator localIterator = this.Jq.iterator();
      while (localIterator.hasNext()) {
        ((PendingResult.a)localIterator.next()).m(localStatus);
      }
      this.Jq.clear();
    }
    
    private R gA()
    {
      for (;;)
      {
        synchronized (this.Jp)
        {
          if (!this.Jt)
          {
            bool = true;
            jx.a(bool, "Result has already been consumed.");
            jx.a(isReady(), "Result is not ready.");
            Result localResult = this.Js;
            gB();
            return localResult;
          }
        }
        boolean bool = false;
      }
    }
    
    private void gC()
    {
      synchronized (this.Jp)
      {
        if (!isReady())
        {
          b(c(Status.Kx));
          this.Jv = true;
        }
        return;
      }
    }
    
    private void gD()
    {
      synchronized (this.Jp)
      {
        if (!isReady())
        {
          b(c(Status.Kz));
          this.Jv = true;
        }
        return;
      }
    }
    
    public final void a(PendingResult.a parama)
    {
      if (!this.Jt) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "Result has already been consumed.");
        synchronized (this.Jp)
        {
          if (isReady())
          {
            parama.m(this.Js.getStatus());
            return;
          }
          this.Jq.add(parama);
        }
      }
    }
    
    protected final void a(jr paramjr)
    {
      synchronized (this.Jp)
      {
        this.Jw = paramjr;
        return;
      }
    }
    
    public final R await()
    {
      boolean bool1 = true;
      boolean bool2;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        bool2 = bool1;
      }
      for (;;)
      {
        jx.a(bool2, "await must not be called on the UI thread");
        if (!this.Jt) {
          jx.a(bool1, "Result has already been consumed");
        }
        try
        {
          this.mr.await();
          jx.a(isReady(), "Result is not ready.");
          return gA();
          bool2 = false;
          continue;
          bool1 = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            gC();
          }
        }
      }
    }
    
    public final R await(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool1 = true;
      boolean bool2;
      if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
        bool2 = bool1;
      }
      for (;;)
      {
        jx.a(bool2, "await must not be called on the UI thread when time is greater than zero.");
        if (!this.Jt) {
          jx.a(bool1, "Result has already been consumed.");
        }
        try
        {
          if (!this.mr.await(paramLong, paramTimeUnit)) {
            gD();
          }
          jx.a(isReady(), "Result is not ready.");
          return gA();
          bool2 = false;
          continue;
          bool1 = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            gC();
          }
        }
      }
    }
    
    public final void b(R paramR)
    {
      boolean bool1 = true;
      for (;;)
      {
        synchronized (this.Jp)
        {
          if ((this.Jv) || (this.Ju))
          {
            BaseImplementation.a(paramR);
            return;
          }
          if (!isReady())
          {
            bool2 = bool1;
            jx.a(bool2, "Results have already been set");
            if (this.Jt) {
              break label81;
            }
            jx.a(bool1, "Result has already been consumed");
            c(paramR);
            return;
          }
        }
        boolean bool2 = false;
        continue;
        label81:
        bool1 = false;
      }
    }
    
    protected abstract R c(Status paramStatus);
    
    public void cancel()
    {
      synchronized (this.Jp)
      {
        if ((this.Ju) || (this.Jt)) {
          return;
        }
        jr localjr = this.Jw;
        if (localjr == null) {}
      }
      try
      {
        this.Jw.cancel();
        label42:
        BaseImplementation.a(this.Js);
        this.Jr = null;
        this.Ju = true;
        c(c(Status.KA));
        return;
        localObject2 = finally;
        throw localObject2;
      }
      catch (RemoteException localRemoteException)
      {
        break label42;
      }
    }
    
    protected void gB()
    {
      this.Jt = true;
      this.Js = null;
      this.Jr = null;
    }
    
    public boolean isCanceled()
    {
      synchronized (this.Jp)
      {
        boolean bool = this.Ju;
        return bool;
      }
    }
    
    public final boolean isReady()
    {
      return this.mr.getCount() == 0L;
    }
    
    public final void setResultCallback(ResultCallback<R> paramResultCallback)
    {
      if (!this.Jt) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "Result has already been consumed.");
        for (;;)
        {
          synchronized (this.Jp)
          {
            if (isCanceled()) {
              return;
            }
            if (isReady())
            {
              this.mHandler.sendResultCallback(paramResultCallback, gA());
              return;
            }
          }
          this.Jr = paramResultCallback;
        }
      }
    }
    
    public final void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool1 = true;
      boolean bool2;
      if (!this.Jt)
      {
        bool2 = bool1;
        jx.a(bool2, "Result has already been consumed.");
        if (this.mHandler == null) {
          break label114;
        }
      }
      for (;;)
      {
        jx.a(bool1, "CallbackHandler has not been set before calling setResultCallback.");
        for (;;)
        {
          synchronized (this.Jp)
          {
            if (isCanceled()) {
              return;
            }
            if (isReady())
            {
              this.mHandler.sendResultCallback(paramResultCallback, gA());
              return;
            }
          }
          this.Jr = paramResultCallback;
          this.mHandler.sendTimeoutResultCallback(this, paramTimeUnit.toMillis(paramLong));
        }
        bool2 = false;
        break;
        label114:
        bool1 = false;
      }
    }
  }
  
  public static class CallbackHandler<R extends Result>
    extends Handler
  {
    public static final int CALLBACK_ON_COMPLETE = 1;
    public static final int CALLBACK_ON_TIMEOUT = 2;
    
    public CallbackHandler()
    {
      this(Looper.getMainLooper());
    }
    
    public CallbackHandler(Looper paramLooper)
    {
      super();
    }
    
    protected void deliverResultCallback(ResultCallback<R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        BaseImplementation.a(paramR);
        throw localRuntimeException;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.wtf("GoogleApi", "Don't know how to handle this message.");
        return;
      case 1: 
        Pair localPair = (Pair)paramMessage.obj;
        deliverResultCallback((ResultCallback)localPair.first, (Result)localPair.second);
        return;
      }
      BaseImplementation.AbstractPendingResult.a((BaseImplementation.AbstractPendingResult)paramMessage.obj);
    }
    
    public void removeTimeoutMessages()
    {
      removeMessages(2);
    }
    
    public void sendResultCallback(ResultCallback<R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
    
    public void sendTimeoutResultCallback(BaseImplementation.AbstractPendingResult<R> paramAbstractPendingResult, long paramLong)
    {
      sendMessageDelayed(obtainMessage(2, paramAbstractPendingResult), paramLong);
    }
  }
  
  public static abstract class a<R extends Result, A extends Api.a>
    extends BaseImplementation.AbstractPendingResult<R>
    implements c.d<A>
  {
    private final Api.c<A> Jn;
    private final GoogleApiClient Jx;
    private c.b Jy;
    
    protected a(Api.c<A> paramc, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.Jn = ((Api.c)jx.i(paramc));
      this.Jx = paramGoogleApiClient;
    }
    
    private void a(RemoteException paramRemoteException)
    {
      l(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    protected abstract void a(A paramA)
      throws RemoteException;
    
    public void a(c.b paramb)
    {
      this.Jy = paramb;
    }
    
    public final void b(A paramA)
      throws DeadObjectException
    {
      try
      {
        a(paramA);
        return;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        a(localDeadObjectException);
        throw localDeadObjectException;
      }
      catch (RemoteException localRemoteException)
      {
        a(localRemoteException);
      }
    }
    
    protected void gB()
    {
      super.gB();
      if (this.Jy != null)
      {
        this.Jy.b(this);
        this.Jy = null;
      }
    }
    
    public final a gE()
    {
      jx.b(this.Jx, "GoogleApiClient was not set.");
      this.Jx.b(this);
      return this;
    }
    
    public int gF()
    {
      return 0;
    }
    
    public final Api.c<A> gz()
    {
      return this.Jn;
    }
    
    public final void l(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Failed result must not be success");
        b(c(paramStatus));
        return;
      }
    }
  }
  
  public static abstract interface b<R>
  {
    public abstract void b(R paramR);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BaseImplementation
 * JD-Core Version:    0.7.0.1
 */