package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

public abstract class BaseDiscCache
  implements DiscCacheAware
{
  private static final String ERROR_ARG_NULL = "\"%s\" argument must be not null";
  protected File cacheDir;
  private FileNameGenerator fileNameGenerator;
  
  public BaseDiscCache(File paramFile)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator());
  }
  
  public BaseDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[] { "cacheDir" }));
    }
    if (paramFileNameGenerator == null) {
      throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[] { "fileNameGenerator" }));
    }
    this.cacheDir = paramFile;
    this.fileNameGenerator = paramFileNameGenerator;
  }
  
  public void clear()
  {
    File[] arrayOfFile = this.cacheDir.listFiles();
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++) {
        arrayOfFile[j].delete();
      }
    }
  }
  
  public File get(String paramString)
  {
    String str = this.fileNameGenerator.generate(paramString);
    return new File(this.cacheDir, str);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.BaseDiscCache
 * JD-Core Version:    0.7.0.1
 */