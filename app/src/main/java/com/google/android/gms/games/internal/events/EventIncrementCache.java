package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache
{
  final Object ack = new Object();
  private Handler acl;
  private boolean acm;
  private HashMap<String, AtomicInteger> acn;
  private int aco;
  
  public EventIncrementCache(Looper paramLooper, int paramInt)
  {
    this.acl = new Handler(paramLooper);
    this.acn = new HashMap();
    this.aco = paramInt;
  }
  
  private void lX()
  {
    synchronized (this.ack)
    {
      this.acm = false;
      flush();
      return;
    }
  }
  
  public void flush()
  {
    synchronized (this.ack)
    {
      Iterator localIterator = this.acn.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        r((String)localEntry.getKey(), ((AtomicInteger)localEntry.getValue()).get());
      }
    }
    this.acn.clear();
  }
  
  protected abstract void r(String paramString, int paramInt);
  
  public void y(String paramString, int paramInt)
  {
    synchronized (this.ack)
    {
      if (!this.acm)
      {
        this.acm = true;
        this.acl.postDelayed(new Runnable()
        {
          public void run()
          {
            EventIncrementCache.a(EventIncrementCache.this);
          }
        }, this.aco);
      }
      AtomicInteger localAtomicInteger = (AtomicInteger)this.acn.get(paramString);
      if (localAtomicInteger == null)
      {
        localAtomicInteger = new AtomicInteger();
        this.acn.put(paramString, localAtomicInteger);
      }
      localAtomicInteger.addAndGet(paramInt);
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.events.EventIncrementCache
 * JD-Core Version:    0.7.0.1
 */