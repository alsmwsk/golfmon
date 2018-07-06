package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.utils.L;

final class DisplayBitmapTask
  implements Runnable
{
  private static final String LOG_DISPLAY_IMAGE_IN_IMAGEAWARE = "Display image in ImageAware (loaded from %1$s) [%2$s]";
  private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
  private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
  private final Bitmap bitmap;
  private final BitmapDisplayer displayer;
  private final ImageLoaderEngine engine;
  private final ImageAware imageAware;
  private final String imageUri;
  private final ImageLoadingListener listener;
  private final LoadedFrom loadedFrom;
  private boolean loggingEnabled;
  private final String memoryCacheKey;
  
  public DisplayBitmapTask(Bitmap paramBitmap, ImageLoadingInfo paramImageLoadingInfo, ImageLoaderEngine paramImageLoaderEngine, LoadedFrom paramLoadedFrom)
  {
    this.bitmap = paramBitmap;
    this.imageUri = paramImageLoadingInfo.uri;
    this.imageAware = paramImageLoadingInfo.imageAware;
    this.memoryCacheKey = paramImageLoadingInfo.memoryCacheKey;
    this.displayer = paramImageLoadingInfo.options.getDisplayer();
    this.listener = paramImageLoadingInfo.listener;
    this.engine = paramImageLoaderEngine;
    this.loadedFrom = paramLoadedFrom;
  }
  
  private boolean isViewWasReused()
  {
    String str = this.engine.getLoadingUriForView(this.imageAware);
    return !this.memoryCacheKey.equals(str);
  }
  
  public void run()
  {
    if (this.imageAware.isCollected())
    {
      if (this.loggingEnabled)
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = this.memoryCacheKey;
        L.d("ImageAware was collected by GC. Task is cancelled. [%s]", arrayOfObject3);
      }
      this.listener.onLoadingCancelled(this.imageUri, this.imageAware.getWrappedView());
      return;
    }
    if (isViewWasReused())
    {
      if (this.loggingEnabled)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.memoryCacheKey;
        L.d("ImageAware is reused for another image. Task is cancelled. [%s]", arrayOfObject2);
      }
      this.listener.onLoadingCancelled(this.imageUri, this.imageAware.getWrappedView());
      return;
    }
    if (this.loggingEnabled)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = this.loadedFrom;
      arrayOfObject1[1] = this.memoryCacheKey;
      L.d("Display image in ImageAware (loaded from %1$s) [%2$s]", arrayOfObject1);
    }
    this.displayer.display(this.bitmap, this.imageAware, this.loadedFrom);
    this.listener.onLoadingComplete(this.imageUri, this.imageAware.getWrappedView(), this.bitmap);
    this.engine.cancelDisplayTaskFor(this.imageAware);
  }
  
  void setLoggingEnabled(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DisplayBitmapTask
 * JD-Core Version:    0.7.0.1
 */