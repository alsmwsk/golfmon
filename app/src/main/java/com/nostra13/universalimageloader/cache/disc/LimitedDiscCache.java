package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class LimitedDiscCache
  extends BaseDiscCache
{
  private static final int INVALID_SIZE = -1;
  private final AtomicInteger cacheSize;
  private final Map<File, Long> lastUsageDates = Collections.synchronizedMap(new HashMap());
  private final int sizeLimit;
  
  public LimitedDiscCache(File paramFile, int paramInt)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator(), paramInt);
  }
  
  public LimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, int paramInt)
  {
    super(paramFile, paramFileNameGenerator);
    this.sizeLimit = paramInt;
    this.cacheSize = new AtomicInteger();
    calculateCacheSizeAndFillUsageMap();
  }
  
  private void calculateCacheSizeAndFillUsageMap()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        int i = 0;
        File[] arrayOfFile = LimitedDiscCache.this.cacheDir.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          for (int k = 0; k < j; k++)
          {
            File localFile = arrayOfFile[k];
            i += LimitedDiscCache.this.getSize(localFile);
            LimitedDiscCache.this.lastUsageDates.put(localFile, Long.valueOf(localFile.lastModified()));
          }
          LimitedDiscCache.this.cacheSize.set(i);
        }
      }
    }).start();
  }
  
  private int removeNext()
  {
    int i;
    if (this.lastUsageDates.isEmpty()) {
      i = -1;
    }
    File localFile;
    for (;;)
    {
      return i;
      Object localObject1 = null;
      localFile = null;
      Set localSet = this.lastUsageDates.entrySet();
      synchronized (this.lastUsageDates)
      {
        Iterator localIterator = localSet.iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localFile == null)
          {
            localFile = (File)localEntry.getKey();
            localObject1 = (Long)localEntry.getValue();
          }
          else
          {
            Long localLong = (Long)localEntry.getValue();
            if (localLong.longValue() < ((Long)localObject1).longValue())
            {
              localObject1 = localLong;
              localFile = (File)localEntry.getKey();
            }
          }
        }
        i = 0;
        if (localFile != null) {
          if (localFile.exists())
          {
            i = getSize(localFile);
            if (!localFile.delete()) {
              continue;
            }
            this.lastUsageDates.remove(localFile);
            return i;
          }
        }
      }
    }
    this.lastUsageDates.remove(localFile);
    return 0;
  }
  
  public void clear()
  {
    this.lastUsageDates.clear();
    this.cacheSize.set(0);
    super.clear();
  }
  
  public File get(String paramString)
  {
    File localFile = super.get(paramString);
    Long localLong = Long.valueOf(System.currentTimeMillis());
    localFile.setLastModified(localLong.longValue());
    this.lastUsageDates.put(localFile, localLong);
    return localFile;
  }
  
  protected abstract int getSize(File paramFile);
  
  public void put(String paramString, File paramFile)
  {
    int i = getSize(paramFile);
    int k;
    for (int j = this.cacheSize.get();; j = this.cacheSize.addAndGet(-k)) {
      if (j + i > this.sizeLimit)
      {
        k = removeNext();
        if (k != -1) {}
      }
      else
      {
        this.cacheSize.addAndGet(i);
        Long localLong = Long.valueOf(System.currentTimeMillis());
        paramFile.setLastModified(localLong.longValue());
        this.lastUsageDates.put(paramFile, localLong);
        return;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.LimitedDiscCache
 * JD-Core Version:    0.7.0.1
 */