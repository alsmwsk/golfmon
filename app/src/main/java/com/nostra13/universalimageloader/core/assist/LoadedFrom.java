package com.nostra13.universalimageloader.core.assist;

public enum LoadedFrom
{
  static
  {
    DISC_CACHE = new LoadedFrom("DISC_CACHE", 1);
    MEMORY_CACHE = new LoadedFrom("MEMORY_CACHE", 2);
    LoadedFrom[] arrayOfLoadedFrom = new LoadedFrom[3];
    arrayOfLoadedFrom[0] = NETWORK;
    arrayOfLoadedFrom[1] = DISC_CACHE;
    arrayOfLoadedFrom[2] = MEMORY_CACHE;
    $VALUES = arrayOfLoadedFrom;
  }
  
  private LoadedFrom() {}
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.LoadedFrom
 * JD-Core Version:    0.7.0.1
 */