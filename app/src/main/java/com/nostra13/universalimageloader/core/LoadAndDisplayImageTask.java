package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.IoUtils.CopyListener;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

final class LoadAndDisplayImageTask
  implements Runnable, IoUtils.CopyListener
{
  private static final int BUFFER_SIZE = 32768;
  private static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
  private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
  private static final String ERROR_PROCESSOR_FOR_DISC_CACHE_NULL = "Bitmap processor for disc cache returned null [%s]";
  private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
  private static final String LOG_CACHE_IMAGE_ON_DISC = "Cache image on disc [%s]";
  private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
  private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_DISC_CACHE = "Load image from disc cache [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
  private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
  private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
  private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISC = "Process image before cache on disc [%s]";
  private static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disc cache [%s]";
  private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
  private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
  private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
  private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
  private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
  private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
  private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
  private final ImageLoaderConfiguration configuration;
  private final ImageDecoder decoder;
  private final ImageDownloader downloader;
  private final ImageLoaderEngine engine;
  private final Handler handler;
  final ImageAware imageAware;
  private final ImageLoadingInfo imageLoadingInfo;
  final ImageLoadingListener listener;
  private LoadedFrom loadedFrom = LoadedFrom.NETWORK;
  private final String memoryCacheKey;
  private final ImageDownloader networkDeniedDownloader;
  final DisplayImageOptions options;
  final ImageLoadingProgressListener progressListener;
  private final ImageDownloader slowNetworkDownloader;
  private final ImageSize targetSize;
  final String uri;
  private final boolean writeLogs;
  
  public LoadAndDisplayImageTask(ImageLoaderEngine paramImageLoaderEngine, ImageLoadingInfo paramImageLoadingInfo, Handler paramHandler)
  {
    this.engine = paramImageLoaderEngine;
    this.imageLoadingInfo = paramImageLoadingInfo;
    this.handler = paramHandler;
    this.configuration = paramImageLoaderEngine.configuration;
    this.downloader = this.configuration.downloader;
    this.networkDeniedDownloader = this.configuration.networkDeniedDownloader;
    this.slowNetworkDownloader = this.configuration.slowNetworkDownloader;
    this.decoder = this.configuration.decoder;
    this.writeLogs = this.configuration.writeLogs;
    this.uri = paramImageLoadingInfo.uri;
    this.memoryCacheKey = paramImageLoadingInfo.memoryCacheKey;
    this.imageAware = paramImageLoadingInfo.imageAware;
    this.targetSize = paramImageLoadingInfo.targetSize;
    this.options = paramImageLoadingInfo.options;
    this.listener = paramImageLoadingInfo.listener;
    this.progressListener = paramImageLoadingInfo.progressListener;
  }
  
  private void checkTaskInterrupted()
    throws LoadAndDisplayImageTask.TaskCancelledException
  {
    if (isTaskInterrupted()) {
      throw new TaskCancelledException();
    }
  }
  
  private void checkTaskNotActual()
    throws LoadAndDisplayImageTask.TaskCancelledException
  {
    checkViewCollected();
    checkViewReused();
  }
  
  private void checkViewCollected()
    throws LoadAndDisplayImageTask.TaskCancelledException
  {
    if (isViewCollected()) {
      throw new TaskCancelledException();
    }
  }
  
  private void checkViewReused()
    throws LoadAndDisplayImageTask.TaskCancelledException
  {
    if (isViewReused()) {
      throw new TaskCancelledException();
    }
  }
  
  private Bitmap decodeImage(String paramString)
    throws IOException
  {
    ViewScaleType localViewScaleType = this.imageAware.getScaleType();
    ImageDecodingInfo localImageDecodingInfo = new ImageDecodingInfo(this.memoryCacheKey, paramString, this.targetSize, localViewScaleType, getDownloader(), this.options);
    return this.decoder.decode(localImageDecodingInfo);
  }
  
  private boolean delayIfNeed()
  {
    if (this.options.shouldDelayBeforeLoading())
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(this.options.getDelayBeforeLoading());
      arrayOfObject1[1] = this.memoryCacheKey;
      log("Delay %d ms before loading...  [%s]", arrayOfObject1);
      try
      {
        Thread.sleep(this.options.getDelayBeforeLoading());
        return isTaskNotActual();
      }
      catch (InterruptedException localInterruptedException)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.memoryCacheKey;
        L.e("Task was interrupted [%s]", arrayOfObject2);
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private boolean downloadImage(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 206	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:getDownloader	()Lcom/nostra13/universalimageloader/core/download/ImageDownloader;
    //   4: aload_0
    //   5: getfield 147	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:uri	Ljava/lang/String;
    //   8: aload_0
    //   9: getfield 159	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   12: invokevirtual 257	com/nostra13/universalimageloader/core/DisplayImageOptions:getExtraForDownloader	()Ljava/lang/Object;
    //   15: invokeinterface 263 3 0
    //   20: astore_2
    //   21: new 265	java/io/BufferedOutputStream
    //   24: dup
    //   25: new 267	java/io/FileOutputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 270	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: ldc 11
    //   35: invokespecial 273	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   38: astore_3
    //   39: aload_2
    //   40: aload_3
    //   41: aload_0
    //   42: invokestatic 279	com/nostra13/universalimageloader/utils/IoUtils:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/nostra13/universalimageloader/utils/IoUtils$CopyListener;)Z
    //   45: istore 6
    //   47: aload_3
    //   48: invokestatic 283	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   51: aload_2
    //   52: invokestatic 283	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   55: iload 6
    //   57: ireturn
    //   58: astore 4
    //   60: aload_3
    //   61: invokestatic 283	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   64: aload 4
    //   66: athrow
    //   67: astore 5
    //   69: aload_2
    //   70: invokestatic 283	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   73: aload 5
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	LoadAndDisplayImageTask
    //   0	76	1	paramFile	File
    //   20	50	2	localInputStream	java.io.InputStream
    //   38	23	3	localBufferedOutputStream	BufferedOutputStream
    //   58	7	4	localObject1	Object
    //   67	7	5	localObject2	Object
    //   45	11	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	47	58	finally
    //   21	39	67	finally
    //   47	51	67	finally
    //   60	67	67	finally
  }
  
  private void fireCancelEvent()
  {
    if ((this.options.isSyncLoading()) || (isTaskInterrupted())) {
      return;
    }
    this.handler.post(new Runnable()
    {
      public void run()
      {
        LoadAndDisplayImageTask.this.listener.onLoadingCancelled(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView());
      }
    });
  }
  
  private void fireFailEvent(final FailReason.FailType paramFailType, final Throwable paramThrowable)
  {
    if ((this.options.isSyncLoading()) || (isTaskInterrupted()) || (isTaskNotActual())) {
      return;
    }
    this.handler.post(new Runnable()
    {
      public void run()
      {
        if (LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
          LoadAndDisplayImageTask.this.imageAware.setImageDrawable(LoadAndDisplayImageTask.this.options.getImageOnFail(LoadAndDisplayImageTask.this.configuration.resources));
        }
        LoadAndDisplayImageTask.this.listener.onLoadingFailed(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView(), new FailReason(paramFailType, paramThrowable));
      }
    });
  }
  
  private boolean fireProgressEvent(final int paramInt1, final int paramInt2)
  {
    if ((this.options.isSyncLoading()) || (isTaskInterrupted()) || (isTaskNotActual())) {
      return false;
    }
    this.handler.post(new Runnable()
    {
      public void run()
      {
        LoadAndDisplayImageTask.this.progressListener.onProgressUpdate(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView(), paramInt1, paramInt2);
      }
    });
    return true;
  }
  
  private ImageDownloader getDownloader()
  {
    if (this.engine.isNetworkDenied()) {
      return this.networkDeniedDownloader;
    }
    if (this.engine.isSlowNetwork()) {
      return this.slowNetworkDownloader;
    }
    return this.downloader;
  }
  
  private File getImageFileInDiscCache()
  {
    File localFile1 = this.configuration.discCache.get(this.uri);
    File localFile2 = localFile1.getParentFile();
    if ((localFile2 == null) || ((!localFile2.exists()) && (!localFile2.mkdirs())))
    {
      localFile1 = this.configuration.reserveDiscCache.get(this.uri);
      File localFile3 = localFile1.getParentFile();
      if ((localFile3 != null) && (!localFile3.exists())) {
        localFile3.mkdirs();
      }
    }
    return localFile1;
  }
  
  private boolean isTaskInterrupted()
  {
    if (Thread.interrupted())
    {
      log("Task was interrupted [%s]");
      return true;
    }
    return false;
  }
  
  private boolean isTaskNotActual()
  {
    return (isViewCollected()) || (isViewReused());
  }
  
  private boolean isViewCollected()
  {
    if (this.imageAware.isCollected())
    {
      log("ImageAware was collected by GC. Task is cancelled. [%s]");
      return true;
    }
    return false;
  }
  
  private boolean isViewReused()
  {
    String str = this.engine.getLoadingUriForView(this.imageAware);
    if (!this.memoryCacheKey.equals(str)) {}
    for (int i = 1; i != 0; i = 0)
    {
      log("ImageAware is reused for another image. Task is cancelled. [%s]");
      return true;
    }
    return false;
  }
  
  private void log(String paramString)
  {
    if (this.writeLogs)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.memoryCacheKey;
      L.d(paramString, arrayOfObject);
    }
  }
  
  private void log(String paramString, Object... paramVarArgs)
  {
    if (this.writeLogs) {
      L.d(paramString, paramVarArgs);
    }
  }
  
  private boolean resizeAndSaveImage(File paramFile, int paramInt1, int paramInt2)
    throws IOException
  {
    ImageSize localImageSize = new ImageSize(paramInt1, paramInt2);
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
    ImageDecodingInfo localImageDecodingInfo = new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(paramFile.getAbsolutePath()), localImageSize, ViewScaleType.FIT_INSIDE, getDownloader(), localDisplayImageOptions);
    Bitmap localBitmap = this.decoder.decode(localImageDecodingInfo);
    if ((localBitmap != null) && (this.configuration.processorForDiscCache != null))
    {
      log("Process image before cache on disc [%s]");
      localBitmap = this.configuration.processorForDiscCache.process(localBitmap);
      if (localBitmap == null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.memoryCacheKey;
        L.e("Bitmap processor for disc cache returned null [%s]", arrayOfObject);
      }
    }
    BufferedOutputStream localBufferedOutputStream;
    if (localBitmap != null) {
      localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile), 32768);
    }
    try
    {
      localBitmap.compress(this.configuration.imageCompressFormatForDiscCache, this.configuration.imageQualityForDiscCache, localBufferedOutputStream);
      IoUtils.closeSilently(localBufferedOutputStream);
      localBitmap.recycle();
      return true;
    }
    finally
    {
      IoUtils.closeSilently(localBufferedOutputStream);
    }
  }
  
  private boolean tryCacheImageOnDisc(File paramFile)
    throws LoadAndDisplayImageTask.TaskCancelledException
  {
    log("Cache image on disc [%s]");
    boolean bool = false;
    try
    {
      bool = downloadImage(paramFile);
      if (bool)
      {
        int i = this.configuration.maxImageWidthForDiscCache;
        int j = this.configuration.maxImageHeightForDiscCache;
        if ((i > 0) || (j > 0))
        {
          log("Resize image in disc cache [%s]");
          bool = resizeAndSaveImage(paramFile, i, j);
        }
        this.configuration.discCache.put(this.uri, paramFile);
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        L.e(localIOException);
      } while (!paramFile.exists());
      paramFile.delete();
    }
    return bool;
    return bool;
  }
  
  private Bitmap tryLoadBitmap()
    throws LoadAndDisplayImageTask.TaskCancelledException
  {
    File localFile = getImageFileInDiscCache();
    localBitmap = null;
    try
    {
      String str1 = ImageDownloader.Scheme.FILE.wrap(localFile.getAbsolutePath());
      boolean bool = localFile.exists();
      localBitmap = null;
      if (bool)
      {
        log("Load image from disc cache [%s]");
        this.loadedFrom = LoadedFrom.DISC_CACHE;
        checkTaskNotActual();
        localBitmap = decodeImage(str1);
      }
      if ((localBitmap == null) || (localBitmap.getWidth() <= 0) || (localBitmap.getHeight() <= 0))
      {
        log("Load image from network [%s]");
        this.loadedFrom = LoadedFrom.NETWORK;
        if ((this.options.isCacheOnDisc()) && (tryCacheImageOnDisc(localFile))) {}
        for (String str2 = str1;; str2 = this.uri)
        {
          checkTaskNotActual();
          localBitmap = decodeImage(str2);
          if ((localBitmap != null) && (localBitmap.getWidth() > 0) && (localBitmap.getHeight() > 0)) {
            break;
          }
          fireFailEvent(FailReason.FailType.DECODING_ERROR, null);
          return localBitmap;
        }
      }
      return localBitmap;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      fireFailEvent(FailReason.FailType.NETWORK_DENIED, null);
      return localBitmap;
    }
    catch (TaskCancelledException localTaskCancelledException)
    {
      throw localTaskCancelledException;
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
      fireFailEvent(FailReason.FailType.IO_ERROR, localIOException);
      if (localFile.exists())
      {
        localFile.delete();
        return localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      L.e(localOutOfMemoryError);
      fireFailEvent(FailReason.FailType.OUT_OF_MEMORY, localOutOfMemoryError);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      L.e(localThrowable);
      fireFailEvent(FailReason.FailType.UNKNOWN, localThrowable);
    }
  }
  
  private boolean waitIfPaused()
  {
    AtomicBoolean localAtomicBoolean = this.engine.getPause();
    if (localAtomicBoolean.get()) {}
    synchronized (this.engine.getPauseLock())
    {
      if (localAtomicBoolean.get()) {
        log("ImageLoader is paused. Waiting...  [%s]");
      }
      try
      {
        this.engine.getPauseLock().wait();
        log(".. Resume loading [%s]");
        return isTaskNotActual();
      }
      catch (InterruptedException localInterruptedException)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.memoryCacheKey;
        L.e("Task was interrupted [%s]", arrayOfObject);
        return true;
      }
    }
  }
  
  String getLoadingUri()
  {
    return this.uri;
  }
  
  public boolean onBytesCopied(int paramInt1, int paramInt2)
  {
    return (this.progressListener == null) || (fireProgressEvent(paramInt1, paramInt2));
  }
  
  public void run()
  {
    if (waitIfPaused()) {}
    while (delayIfNeed()) {
      return;
    }
    ReentrantLock localReentrantLock = this.imageLoadingInfo.loadFromUriLock;
    log("Start display image task [%s]");
    if (localReentrantLock.isLocked()) {
      log("Image already is loading. Waiting... [%s]");
    }
    localReentrantLock.lock();
    try
    {
      checkTaskNotActual();
      Object localObject2 = (Bitmap)this.configuration.memoryCache.get(this.memoryCacheKey);
      if (localObject2 == null)
      {
        Bitmap localBitmap = tryLoadBitmap();
        localObject2 = localBitmap;
        if (localObject2 == null) {
          return;
        }
        checkTaskNotActual();
        checkTaskInterrupted();
        if (this.options.shouldPreProcess())
        {
          log("PreProcess image before caching in memory [%s]");
          localObject2 = this.options.getPreProcessor().process((Bitmap)localObject2);
          if (localObject2 == null)
          {
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = this.memoryCacheKey;
            L.e("Pre-processor returned null [%s]", arrayOfObject2);
          }
        }
        if ((localObject2 != null) && (this.options.isCacheInMemory()))
        {
          log("Cache image in memory [%s]");
          this.configuration.memoryCache.put(this.memoryCacheKey, localObject2);
        }
      }
      DisplayBitmapTask localDisplayBitmapTask;
      for (;;)
      {
        if ((localObject2 != null) && (this.options.shouldPostProcess()))
        {
          log("PostProcess image before displaying [%s]");
          localObject2 = this.options.getPostProcessor().process((Bitmap)localObject2);
          if (localObject2 == null)
          {
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = this.memoryCacheKey;
            L.e("Post-processor returned null [%s]", arrayOfObject1);
          }
        }
        checkTaskNotActual();
        checkTaskInterrupted();
        localReentrantLock.unlock();
        localDisplayBitmapTask = new DisplayBitmapTask((Bitmap)localObject2, this.imageLoadingInfo, this.engine, this.loadedFrom);
        localDisplayBitmapTask.setLoggingEnabled(this.writeLogs);
        if (!this.options.isSyncLoading()) {
          break;
        }
        return;
        this.loadedFrom = LoadedFrom.MEMORY_CACHE;
        log("...Get cached bitmap from memory after waiting. [%s]");
      }
      this.handler.post(localDisplayBitmapTask);
    }
    catch (TaskCancelledException localTaskCancelledException)
    {
      fireCancelEvent();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  class TaskCancelledException
    extends Exception
  {
    TaskCancelledException() {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.LoadAndDisplayImageTask
 * JD-Core Version:    0.7.0.1
 */