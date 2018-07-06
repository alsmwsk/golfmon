package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.LimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.L;
import java.io.File;

public class TotalSizeLimitedDiscCache
  extends LimitedDiscCache
{
  private static final int MIN_NORMAL_CACHE_SIZE = 2097152;
  private static final int MIN_NORMAL_CACHE_SIZE_IN_MB = 2;
  
  public TotalSizeLimitedDiscCache(File paramFile, int paramInt)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator(), paramInt);
  }
  
  public TotalSizeLimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, int paramInt)
  {
    super(paramFile, paramFileNameGenerator, paramInt);
    if (paramInt < 2097152)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(2);
      L.w("You set too small disc cache size (less than %1$d Mb)", arrayOfObject);
    }
  }
  
  protected int getSize(File paramFile)
  {
    return (int)paramFile.length();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.TotalSizeLimitedDiscCache
 * JD-Core Version:    0.7.0.1
 */