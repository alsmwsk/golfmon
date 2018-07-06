package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SyncImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageNonViewAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.L;
import java.util.concurrent.locks.ReentrantLock;

public class ImageLoader
{
  private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
  private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
  private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
  static final String LOG_DESTROY = "Destroy ImageLoader";
  static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
  static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
  public static final String TAG = ImageLoader.class.getSimpleName();
  private static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
  private static volatile ImageLoader instance;
  private ImageLoaderConfiguration configuration;
  private final ImageLoadingListener emptyListener = new SimpleImageLoadingListener();
  private ImageLoaderEngine engine;
  
  private void checkConfiguration()
  {
    if (this.configuration == null) {
      throw new IllegalStateException("ImageLoader must be init with configuration before using");
    }
  }
  
  public static ImageLoader getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ImageLoader();
      }
      return instance;
    }
    finally {}
  }
  
  public void cancelDisplayTask(ImageView paramImageView)
  {
    this.engine.cancelDisplayTaskFor(new ImageViewAware(paramImageView));
  }
  
  public void cancelDisplayTask(ImageAware paramImageAware)
  {
    this.engine.cancelDisplayTaskFor(paramImageAware);
  }
  
  public void clearDiscCache()
  {
    checkConfiguration();
    this.configuration.discCache.clear();
  }
  
  public void clearMemoryCache()
  {
    checkConfiguration();
    this.configuration.memoryCache.clear();
  }
  
  public void denyNetworkDownloads(boolean paramBoolean)
  {
    this.engine.denyNetworkDownloads(paramBoolean);
  }
  
  public void destroy()
  {
    if ((this.configuration != null) && (this.configuration.writeLogs)) {
      L.d("Destroy ImageLoader", new Object[0]);
    }
    stop();
    this.engine = null;
    this.configuration = null;
  }
  
  public void displayImage(String paramString, ImageView paramImageView)
  {
    displayImage(paramString, new ImageViewAware(paramImageView), null, null, null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions)
  {
    displayImage(paramString, new ImageViewAware(paramImageView), paramDisplayImageOptions, null, null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, paramImageView, paramDisplayImageOptions, paramImageLoadingListener, null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener, ImageLoadingProgressListener paramImageLoadingProgressListener)
  {
    displayImage(paramString, new ImageViewAware(paramImageView), paramDisplayImageOptions, paramImageLoadingListener, paramImageLoadingProgressListener);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, new ImageViewAware(paramImageView), null, paramImageLoadingListener, null);
  }
  
  public void displayImage(String paramString, ImageAware paramImageAware)
  {
    displayImage(paramString, paramImageAware, null, null, null);
  }
  
  public void displayImage(String paramString, ImageAware paramImageAware, DisplayImageOptions paramDisplayImageOptions)
  {
    displayImage(paramString, paramImageAware, paramDisplayImageOptions, null, null);
  }
  
  public void displayImage(String paramString, ImageAware paramImageAware, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, paramImageAware, paramDisplayImageOptions, paramImageLoadingListener, null);
  }
  
  public void displayImage(String paramString, ImageAware paramImageAware, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener, ImageLoadingProgressListener paramImageLoadingProgressListener)
  {
    checkConfiguration();
    if (paramImageAware == null) {
      throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
    }
    if (paramImageLoadingListener == null) {
      paramImageLoadingListener = this.emptyListener;
    }
    if (paramDisplayImageOptions == null) {
      paramDisplayImageOptions = this.configuration.defaultDisplayImageOptions;
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.engine.cancelDisplayTaskFor(paramImageAware);
      paramImageLoadingListener.onLoadingStarted(paramString, paramImageAware.getWrappedView());
      if (paramDisplayImageOptions.shouldShowImageForEmptyUri()) {
        paramImageAware.setImageDrawable(paramDisplayImageOptions.getImageForEmptyUri(this.configuration.resources));
      }
      for (;;)
      {
        paramImageLoadingListener.onLoadingComplete(paramString, paramImageAware.getWrappedView(), null);
        return;
        paramImageAware.setImageDrawable(null);
      }
    }
    ImageSize localImageSize = ImageSizeUtils.defineTargetSizeForView(paramImageAware, this.configuration.getMaxImageSize());
    String str = MemoryCacheUtil.generateKey(paramString, localImageSize);
    this.engine.prepareDisplayTaskFor(paramImageAware, str);
    paramImageLoadingListener.onLoadingStarted(paramString, paramImageAware.getWrappedView());
    Bitmap localBitmap = (Bitmap)this.configuration.memoryCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (this.configuration.writeLogs) {
        L.d("Load image from memory cache [%s]", new Object[] { str });
      }
      if (paramDisplayImageOptions.shouldPostProcess())
      {
        ReentrantLock localReentrantLock2 = this.engine.getLockForUri(paramString);
        ImageLoadingInfo localImageLoadingInfo2 = new ImageLoadingInfo(paramString, paramImageAware, localImageSize, str, paramDisplayImageOptions, paramImageLoadingListener, paramImageLoadingProgressListener, localReentrantLock2);
        ProcessAndDisplayImageTask localProcessAndDisplayImageTask = new ProcessAndDisplayImageTask(this.engine, localBitmap, localImageLoadingInfo2, paramDisplayImageOptions.getHandler());
        if (paramDisplayImageOptions.isSyncLoading())
        {
          localProcessAndDisplayImageTask.run();
          return;
        }
        this.engine.submit(localProcessAndDisplayImageTask);
        return;
      }
      paramDisplayImageOptions.getDisplayer().display(localBitmap, paramImageAware, LoadedFrom.MEMORY_CACHE);
      paramImageLoadingListener.onLoadingComplete(paramString, paramImageAware.getWrappedView(), localBitmap);
      return;
    }
    if (paramDisplayImageOptions.shouldShowImageOnLoading()) {
      paramImageAware.setImageDrawable(paramDisplayImageOptions.getImageOnLoading(this.configuration.resources));
    }
    LoadAndDisplayImageTask localLoadAndDisplayImageTask;
    for (;;)
    {
      ReentrantLock localReentrantLock1 = this.engine.getLockForUri(paramString);
      ImageLoadingInfo localImageLoadingInfo1 = new ImageLoadingInfo(paramString, paramImageAware, localImageSize, str, paramDisplayImageOptions, paramImageLoadingListener, paramImageLoadingProgressListener, localReentrantLock1);
      localLoadAndDisplayImageTask = new LoadAndDisplayImageTask(this.engine, localImageLoadingInfo1, paramDisplayImageOptions.getHandler());
      if (!paramDisplayImageOptions.isSyncLoading()) {
        break;
      }
      localLoadAndDisplayImageTask.run();
      return;
      if (paramDisplayImageOptions.isResetViewBeforeLoading()) {
        paramImageAware.setImageDrawable(null);
      }
    }
    this.engine.submit(localLoadAndDisplayImageTask);
  }
  
  public void displayImage(String paramString, ImageAware paramImageAware, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, paramImageAware, null, paramImageLoadingListener, null);
  }
  
  public DiscCacheAware getDiscCache()
  {
    checkConfiguration();
    return this.configuration.discCache;
  }
  
  public String getLoadingUriForView(ImageView paramImageView)
  {
    return this.engine.getLoadingUriForView(new ImageViewAware(paramImageView));
  }
  
  public String getLoadingUriForView(ImageAware paramImageAware)
  {
    return this.engine.getLoadingUriForView(paramImageAware);
  }
  
  public MemoryCacheAware<String, Bitmap> getMemoryCache()
  {
    checkConfiguration();
    return this.configuration.memoryCache;
  }
  
  public void handleSlowNetwork(boolean paramBoolean)
  {
    this.engine.handleSlowNetwork(paramBoolean);
  }
  
  public void init(ImageLoaderConfiguration paramImageLoaderConfiguration)
  {
    if (paramImageLoaderConfiguration == null) {
      try
      {
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
      }
      finally {}
    }
    if (this.configuration == null)
    {
      if (paramImageLoaderConfiguration.writeLogs) {
        L.d("Initialize ImageLoader with configuration", new Object[0]);
      }
      this.engine = new ImageLoaderEngine(paramImageLoaderConfiguration);
      this.configuration = paramImageLoaderConfiguration;
    }
    for (;;)
    {
      return;
      L.w("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
    }
  }
  
  public boolean isInited()
  {
    return this.configuration != null;
  }
  
  public void loadImage(String paramString, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, null, paramDisplayImageOptions, paramImageLoadingListener, null);
  }
  
  public void loadImage(String paramString, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, null, null, paramImageLoadingListener, null);
  }
  
  public void loadImage(String paramString, ImageSize paramImageSize, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, paramImageSize, paramDisplayImageOptions, paramImageLoadingListener, null);
  }
  
  public void loadImage(String paramString, ImageSize paramImageSize, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener, ImageLoadingProgressListener paramImageLoadingProgressListener)
  {
    checkConfiguration();
    if (paramImageSize == null) {
      paramImageSize = this.configuration.getMaxImageSize();
    }
    if (paramDisplayImageOptions == null) {
      paramDisplayImageOptions = this.configuration.defaultDisplayImageOptions;
    }
    displayImage(paramString, new ImageNonViewAware(paramString, paramImageSize, ViewScaleType.CROP), paramDisplayImageOptions, paramImageLoadingListener, paramImageLoadingProgressListener);
  }
  
  public void loadImage(String paramString, ImageSize paramImageSize, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, paramImageSize, null, paramImageLoadingListener, null);
  }
  
  public Bitmap loadImageSync(String paramString)
  {
    return loadImageSync(paramString, null, null);
  }
  
  public Bitmap loadImageSync(String paramString, DisplayImageOptions paramDisplayImageOptions)
  {
    return loadImageSync(paramString, null, paramDisplayImageOptions);
  }
  
  public Bitmap loadImageSync(String paramString, ImageSize paramImageSize)
  {
    return loadImageSync(paramString, paramImageSize, null);
  }
  
  public Bitmap loadImageSync(String paramString, ImageSize paramImageSize, DisplayImageOptions paramDisplayImageOptions)
  {
    if (paramDisplayImageOptions == null) {
      paramDisplayImageOptions = this.configuration.defaultDisplayImageOptions;
    }
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cloneFrom(paramDisplayImageOptions).syncLoading(true).build();
    SyncImageLoadingListener localSyncImageLoadingListener = new SyncImageLoadingListener();
    loadImage(paramString, paramImageSize, localDisplayImageOptions, localSyncImageLoadingListener);
    return localSyncImageLoadingListener.getLoadedBitmap();
  }
  
  public void pause()
  {
    this.engine.pause();
  }
  
  public void resume()
  {
    this.engine.resume();
  }
  
  public void stop()
  {
    this.engine.stop();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoader
 * JD-Core Version:    0.7.0.1
 */