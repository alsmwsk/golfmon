package com.nostra13.universalimageloader.cache.memory.impl;

import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class FuzzyKeyMemoryCache<K, V>
  implements MemoryCacheAware<K, V>
{
  private final MemoryCacheAware<K, V> cache;
  private final Comparator<K> keyComparator;
  
  public FuzzyKeyMemoryCache(MemoryCacheAware<K, V> paramMemoryCacheAware, Comparator<K> paramComparator)
  {
    this.cache = paramMemoryCacheAware;
    this.keyComparator = paramComparator;
  }
  
  public void clear()
  {
    this.cache.clear();
  }
  
  public V get(K paramK)
  {
    return this.cache.get(paramK);
  }
  
  public Collection<K> keys()
  {
    return this.cache.keys();
  }
  
  public boolean put(K paramK, V paramV)
  {
    synchronized (this.cache)
    {
      Iterator localIterator = this.cache.keys().iterator();
      Object localObject3;
      do
      {
        boolean bool = localIterator.hasNext();
        localObject2 = null;
        if (!bool) {
          break;
        }
        localObject3 = localIterator.next();
      } while (this.keyComparator.compare(paramK, localObject3) != 0);
      Object localObject2 = localObject3;
      if (localObject2 != null) {
        this.cache.remove(localObject2);
      }
      return this.cache.put(paramK, paramV);
    }
  }
  
  public void remove(K paramK)
  {
    this.cache.remove(paramK);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache
 * JD-Core Version:    0.7.0.1
 */