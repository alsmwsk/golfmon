package com.nostra13.universalimageloader.cache.memory;

import java.util.Collection;

public abstract interface MemoryCacheAware<K, V>
{
  public abstract void clear();
  
  public abstract V get(K paramK);
  
  public abstract Collection<K> keys();
  
  public abstract boolean put(K paramK, V paramV);
  
  public abstract void remove(K paramK);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
 * JD-Core Version:    0.7.0.1
 */