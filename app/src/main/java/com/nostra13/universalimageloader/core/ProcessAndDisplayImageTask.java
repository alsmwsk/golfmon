package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;

class ProcessAndDisplayImageTask
  implements Runnable
{
  private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
  private final Bitmap bitmap;
  private final ImageLoaderEngine engine;
  private final Handler handler;
  private final ImageLoadingInfo imageLoadingInfo;
  
  public ProcessAndDisplayImageTask(ImageLoaderEngine paramImageLoaderEngine, Bitmap paramBitmap, ImageLoadingInfo paramImageLoadingInfo, Handler paramHandler)
  {
    this.engine = paramImageLoaderEngine;
    this.bitmap = paramBitmap;
    this.imageLoadingInfo = paramImageLoadingInfo;
    this.handler = paramHandler;
  }
  
  public void run()
  {
    if (this.engine.configuration.writeLogs)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.imageLoadingInfo.memoryCacheKey;
      L.d("PostProcess image before displaying [%s]", arrayOfObject);
    }
    DisplayBitmapTask localDisplayBitmapTask = new DisplayBitmapTask(this.imageLoadingInfo.options.getPostProcessor().process(this.bitmap), this.imageLoadingInfo, this.engine, LoadedFrom.MEMORY_CACHE);
    localDisplayBitmapTask.setLoggingEnabled(this.engine.configuration.writeLogs);
    if (this.imageLoadingInfo.options.isSyncLoading())
    {
      localDisplayBitmapTask.run();
      return;
    }
    this.handler.post(localDisplayBitmapTask);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ProcessAndDisplayImageTask
 * JD-Core Version:    0.7.0.1
 */