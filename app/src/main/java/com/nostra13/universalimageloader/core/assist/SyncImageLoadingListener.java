package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import android.view.View;

public class SyncImageLoadingListener
  extends SimpleImageLoadingListener
{
  private Bitmap loadedImage;
  
  public Bitmap getLoadedBitmap()
  {
    return this.loadedImage;
  }
  
  public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap)
  {
    this.loadedImage = paramBitmap;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.SyncImageLoadingListener
 * JD-Core Version:    0.7.0.1
 */