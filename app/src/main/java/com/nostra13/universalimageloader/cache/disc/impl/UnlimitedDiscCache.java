package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.BaseDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

public class UnlimitedDiscCache
  extends BaseDiscCache
{
  public UnlimitedDiscCache(File paramFile)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator());
  }
  
  public UnlimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator)
  {
    super(paramFile, paramFileNameGenerator);
  }
  
  public void put(String paramString, File paramFile) {}
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache
 * JD-Core Version:    0.7.0.1
 */