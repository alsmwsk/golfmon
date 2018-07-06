package com.nostra13.universalimageloader.cache.disc;

import java.io.File;

public abstract interface DiscCacheAware
{
  public abstract void clear();
  
  public abstract File get(String paramString);
  
  public abstract void put(String paramString, File paramFile);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.DiscCacheAware
 * JD-Core Version:    0.7.0.1
 */