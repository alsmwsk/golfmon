package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.BaseDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeDiscCache
  extends BaseDiscCache
{
  private final Map<File, Long> loadingDates = Collections.synchronizedMap(new HashMap());
  private final long maxFileAge;
  
  public LimitedAgeDiscCache(File paramFile, long paramLong)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator(), paramLong);
  }
  
  public LimitedAgeDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, long paramLong)
  {
    super(paramFile, paramFileNameGenerator);
    this.maxFileAge = (1000L * paramLong);
  }
  
  public File get(String paramString)
  {
    File localFile = super.get(paramString);
    Long localLong;
    int i;
    if (localFile.exists())
    {
      localLong = (Long)this.loadingDates.get(localFile);
      if (localLong != null) {
        break label76;
      }
      i = 0;
      localLong = Long.valueOf(localFile.lastModified());
      if (System.currentTimeMillis() - localLong.longValue() <= this.maxFileAge) {
        break label82;
      }
      localFile.delete();
      this.loadingDates.remove(localFile);
    }
    label76:
    label82:
    while (i != 0)
    {
      return localFile;
      i = 1;
      break;
    }
    this.loadingDates.put(localFile, localLong);
    return localFile;
  }
  
  public void put(String paramString, File paramFile)
  {
    long l = System.currentTimeMillis();
    paramFile.setLastModified(l);
    this.loadingDates.put(paramFile, Long.valueOf(l));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiscCache
 * JD-Core Version:    0.7.0.1
 */