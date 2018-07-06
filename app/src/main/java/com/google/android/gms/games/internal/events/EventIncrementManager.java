package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager
{
  private final AtomicReference<EventIncrementCache> acq = new AtomicReference();
  
  public void flush()
  {
    EventIncrementCache localEventIncrementCache = (EventIncrementCache)this.acq.get();
    if (localEventIncrementCache != null) {
      localEventIncrementCache.flush();
    }
  }
  
  protected abstract EventIncrementCache lF();
  
  public void o(String paramString, int paramInt)
  {
    EventIncrementCache localEventIncrementCache = (EventIncrementCache)this.acq.get();
    if (localEventIncrementCache == null)
    {
      localEventIncrementCache = lF();
      if (!this.acq.compareAndSet(null, localEventIncrementCache)) {
        localEventIncrementCache = (EventIncrementCache)this.acq.get();
      }
    }
    localEventIncrementCache.y(paramString, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.events.EventIncrementManager
 * JD-Core Version:    0.7.0.1
 */