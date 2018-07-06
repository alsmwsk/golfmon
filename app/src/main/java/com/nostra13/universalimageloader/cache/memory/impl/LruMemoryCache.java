package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class LruMemoryCache
  implements MemoryCacheAware<String, Bitmap>
{
  private final LinkedHashMap<String, Bitmap> map;
  private final int maxSize;
  private int size;
  
  public LruMemoryCache(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.maxSize = paramInt;
    this.map = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int sizeOf(String paramString, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  /* Error */
  private void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 35	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:map	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 53	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 49	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:size	I
    //   23: ifeq +41 -> 64
    //   26: new 55	java/lang/IllegalStateException
    //   29: dup
    //   30: new 57	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 62	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 68	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 74
    //   49: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 78	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 49	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 35	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:map	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 53	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 35	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:map	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 82	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 88 1 0
    //   97: invokeinterface 94 1 0
    //   102: checkcast 96	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: ifnonnull +6 -> 113
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: aload_3
    //   114: invokeinterface 99 1 0
    //   119: checkcast 101	java/lang/String
    //   122: astore 4
    //   124: aload_3
    //   125: invokeinterface 104 1 0
    //   130: checkcast 39	android/graphics/Bitmap
    //   133: astore 5
    //   135: aload_0
    //   136: getfield 35	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:map	Ljava/util/LinkedHashMap;
    //   139: aload 4
    //   141: invokevirtual 108	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 49	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:size	I
    //   150: aload_0
    //   151: aload 4
    //   153: aload 5
    //   155: invokespecial 110	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:sizeOf	(Ljava/lang/String;Landroid/graphics/Bitmap;)I
    //   158: isub
    //   159: putfield 49	com/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache:size	I
    //   162: aload_0
    //   163: monitorexit
    //   164: goto -164 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	LruMemoryCache
    //   0	167	1	paramInt	int
    //   59	4	2	localObject	Object
    //   105	20	3	localEntry	java.util.Map.Entry
    //   122	30	4	str	String
    //   133	21	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	106	59	finally
    //   110	112	59	finally
    //   113	164	59	finally
  }
  
  public void clear()
  {
    trimToSize(-1);
  }
  
  public final Bitmap get(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Bitmap localBitmap = (Bitmap)this.map.get(paramString);
      return localBitmap;
    }
    finally {}
  }
  
  public Collection<String> keys()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.map.keySet());
      return localHashSet;
    }
    finally {}
  }
  
  public final boolean put(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramBitmap == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.size += sizeOf(paramString, paramBitmap);
      Bitmap localBitmap = (Bitmap)this.map.put(paramString, paramBitmap);
      if (localBitmap != null) {
        this.size -= sizeOf(paramString, localBitmap);
      }
      trimToSize(this.maxSize);
      return true;
    }
    finally {}
  }
  
  public final void remove(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Bitmap localBitmap = (Bitmap)this.map.remove(paramString);
      if (localBitmap != null) {
        this.size -= sizeOf(paramString, localBitmap);
      }
      return;
    }
    finally {}
  }
  
  public final String toString()
  {
    try
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.maxSize);
      String str = String.format("LruCache[maxSize=%d]", arrayOfObject);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache
 * JD-Core Version:    0.7.0.1
 */