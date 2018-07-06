package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.LimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

public class FileCountLimitedDiscCache
  extends LimitedDiscCache
{
  public FileCountLimitedDiscCache(File paramFile, int paramInt)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator(), paramInt);
  }
  
  public FileCountLimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, int paramInt)
  {
    super(paramFile, paramFileNameGenerator, paramInt);
  }
  
  protected int getSize(File paramFile)
  {
    return 1;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.FileCountLimitedDiscCache
 * JD-Core Version:    0.7.0.1
 */