package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LRULimitedMemoryCache
  extends LimitedMemoryCache<String, Bitmap>
{
  private static final int INITIAL_CAPACITY = 10;
  private static final float LOAD_FACTOR = 1.1F;
  private final Map<String, Bitmap> lruCache = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));
  
  public LRULimitedMemoryCache(int paramInt)
  {
    super(paramInt);
  }
  
  public void clear()
  {
    this.lruCache.clear();
    super.clear();
  }
  
  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }
  
  public Bitmap get(String paramString)
  {
    this.lruCache.get(paramString);
    return (Bitmap)super.get(paramString);
  }
  
  protected int getSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public boolean put(String paramString, Bitmap paramBitmap)
  {
    if (super.put(paramString, paramBitmap))
    {
      this.lruCache.put(paramString, paramBitmap);
      return true;
    }
    return false;
  }
  
  public void remove(String paramString)
  {
    this.lruCache.remove(paramString);
    super.remove(paramString);
  }
  
  protected Bitmap removeNext()
  {
    synchronized (this.lruCache)
    {
      Iterator localIterator = this.lruCache.entrySet().iterator();
      boolean bool = localIterator.hasNext();
      Bitmap localBitmap = null;
      if (bool)
      {
        localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
        localIterator.remove();
      }
      return localBitmap;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache
 * JD-Core Version:    0.7.0.1
 */