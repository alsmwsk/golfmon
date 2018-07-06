package com.appg.golfmon.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ImageView;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ImageDownLoader
{
  private static final int DELAY_BEFORE_PURGE = 60000;
  private static final int HARD_CACHE_CAPACITY = 10;
  private static Bitmap mDownLoadingImage = null;
  private static final ConcurrentHashMap<String, SoftReference<Bitmap>> sSoftBitmapCache = new ConcurrentHashMap(5);
  private Context hContext;
  private Mode mMode = Mode.NO_ASYNC_TASK;
  private final Handler purgeHandler = new Handler();
  private final Runnable purger = new Runnable()
  {
    public void run()
    {
      ImageDownLoader.this.clearCache();
    }
  };
  private final HashMap<String, Bitmap> sHardBitmapCache = new LinkedHashMap(5, 0.75F, true)
  {
    private static final long serialVersionUID = 1841155755907303027L;
    
    protected boolean removeEldestEntry(Map.Entry<String, Bitmap> paramAnonymousEntry)
    {
      if (size() > 10)
      {
        ImageDownLoader.sSoftBitmapCache.put((String)paramAnonymousEntry.getKey(), new SoftReference((Bitmap)paramAnonymousEntry.getValue()));
        return true;
      }
      return false;
    }
  };
  
  public ImageDownLoader(Context paramContext)
  {
    this.hContext = paramContext;
  }
  
  private void addBitmapToCache(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      synchronized (this.sHardBitmapCache)
      {
        this.sHardBitmapCache.put(paramString, paramBitmap);
        return;
      }
    }
  }
  
  private static boolean cancelPotentialDownload(String paramString, ImageView paramImageView)
  {
    BitmapDownloaderTask localBitmapDownloaderTask = getBitmapDownloaderTask(paramImageView);
    if (localBitmapDownloaderTask != null)
    {
      String str = localBitmapDownloaderTask.mUrl;
      if ((str == null) || (!str.equals(paramString))) {
        localBitmapDownloaderTask.cancel(true);
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  private void forceDownload(String paramString, ImageView paramImageView)
  {
    if (paramString == null) {
      paramImageView.setImageDrawable(null);
    }
    while (!cancelPotentialDownload(paramString, paramImageView)) {
      return;
    }
    switch (this.mMode)
    {
    default: 
      return;
    case CORRECT: 
      Bitmap localBitmap = downloadBitmap(paramString);
      addBitmapToCache(paramString, localBitmap);
      paramImageView.setImageBitmap(localBitmap);
      return;
    case NO_ASYNC_TASK: 
      paramImageView.setMinimumHeight(128);
      new BitmapDownloaderTask(paramImageView).execute(new String[] { paramString });
      return;
    }
    BitmapDownloaderTask localBitmapDownloaderTask = new BitmapDownloaderTask(paramImageView);
    paramImageView.setImageDrawable(new DownloadedDrawable(localBitmapDownloaderTask));
    paramImageView.setMinimumWidth(150);
    paramImageView.setMinimumHeight(105);
    localBitmapDownloaderTask.execute(new String[] { paramString });
  }
  
  private static BitmapDownloaderTask getBitmapDownloaderTask(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof DownloadedDrawable)) {
        return ((DownloadedDrawable)localDrawable).getBitmapDownloaderTask();
      }
    }
    return null;
  }
  
  private Bitmap getBitmapFromCache(String paramString)
  {
    synchronized (this.sHardBitmapCache)
    {
      Bitmap localBitmap1 = (Bitmap)this.sHardBitmapCache.get(paramString);
      if (localBitmap1 != null)
      {
        this.sHardBitmapCache.remove(paramString);
        this.sHardBitmapCache.put(paramString, localBitmap1);
        return localBitmap1;
      }
      SoftReference localSoftReference = (SoftReference)sSoftBitmapCache.get(paramString);
      if (localSoftReference == null) {
        break label100;
      }
      Bitmap localBitmap2 = (Bitmap)localSoftReference.get();
      if (localBitmap2 != null) {
        return localBitmap2;
      }
    }
    sSoftBitmapCache.remove(paramString);
    label100:
    return null;
  }
  
  private void resetPurgeTimer()
  {
    this.purgeHandler.removeCallbacks(this.purger);
    this.purgeHandler.postDelayed(this.purger, 60000L);
  }
  
  public void clearCache()
  {
    this.sHardBitmapCache.clear();
    sSoftBitmapCache.clear();
  }
  
  public void download(ImageView paramImageView, String paramString)
  {
    resetPurgeTimer();
    Bitmap localBitmap = getBitmapFromCache(paramString);
    if (localBitmap == null)
    {
      forceDownload(paramString, paramImageView);
      return;
    }
    cancelPotentialDownload(paramString, paramImageView);
    paramImageView.setImageBitmap(localBitmap);
  }
  
  Bitmap downloadBitmap(String paramString)
  {
    Object localObject1;
    HttpGet localHttpGet;
    if (this.mMode == Mode.NO_ASYNC_TASK)
    {
      localObject1 = new DefaultHttpClient();
      localHttpGet = new HttpGet(paramString);
    }
    label83:
    do
    {
      try
      {
        localHttpResponse = ((HttpClient)localObject1).execute(localHttpGet);
        int i = localHttpResponse.getStatusLine().getStatusCode();
        if (i == 200) {
          break label83;
        }
      }
      catch (IOException localIOException)
      {
        HttpResponse localHttpResponse;
        HttpEntity localHttpEntity;
        InputStream localInputStream;
        localHttpGet.abort();
        return null;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localHttpGet.abort();
        return null;
      }
      catch (Exception localException)
      {
        localHttpGet.abort();
        return null;
      }
      finally
      {
        if (!(localObject1 instanceof AndroidHttpClient)) {
          continue;
        }
        ((AndroidHttpClient)localObject1).close();
      }
      return null;
      localObject1 = AndroidHttpClient.newInstance("Android");
      break;
      localHttpEntity = localHttpResponse.getEntity();
      if (localHttpEntity != null)
      {
        localInputStream = null;
        try
        {
          localInputStream = localHttpEntity.getContent();
          Bitmap localBitmap = BitmapFactory.decodeStream(new FlushedInputStream(localInputStream));
          if (localInputStream != null) {
            localInputStream.close();
          }
          localHttpEntity.consumeContent();
          if ((localObject1 instanceof AndroidHttpClient)) {
            ((AndroidHttpClient)localObject1).close();
          }
          return localBitmap;
        }
        finally
        {
          if (localInputStream != null) {
            localInputStream.close();
          }
          localHttpEntity.consumeContent();
        }
      }
    } while (!(localObject1 instanceof AndroidHttpClient));
    ((AndroidHttpClient)localObject1).close();
    return null;
  }
  
  public void setDownLoadingImage(int paramInt) {}
  
  public void setDownLoadingImage(Bitmap paramBitmap) {}
  
  public void setDownLoadingImage(Drawable paramDrawable) {}
  
  public void setMode(Mode paramMode)
  {
    this.mMode = paramMode;
    clearCache();
  }
  
  class BitmapDownloaderTask
    extends AsyncTask<String, Void, Bitmap>
  {
    private final WeakReference<ImageView> mImageViewReference;
    private String mUrl;
    
    public BitmapDownloaderTask(ImageView paramImageView)
    {
      this.mImageViewReference = new WeakReference(paramImageView);
    }
    
    protected Bitmap doInBackground(String... paramVarArgs)
    {
      this.mUrl = paramVarArgs[0];
      return ImageDownLoader.this.downloadBitmap(this.mUrl);
    }
    
    protected void onPostExecute(Bitmap paramBitmap)
    {
      if (isCancelled()) {
        paramBitmap = null;
      }
      ImageDownLoader.this.addBitmapToCache(this.mUrl, paramBitmap);
      if (this.mImageViewReference != null)
      {
        ImageView localImageView = (ImageView)this.mImageViewReference.get();
        if ((this == ImageDownLoader.getBitmapDownloaderTask(localImageView)) || (ImageDownLoader.this.mMode != ImageDownLoader.Mode.CORRECT)) {
          localImageView.setImageBitmap(paramBitmap);
        }
      }
    }
  }
  
  static class DownloadedDrawable
    extends BitmapDrawable
  {
    private final WeakReference<ImageDownLoader.BitmapDownloaderTask> mBitmapDownloaderTaskReference;
    
    public DownloadedDrawable(ImageDownLoader.BitmapDownloaderTask paramBitmapDownloaderTask)
    {
      super();
      this.mBitmapDownloaderTaskReference = new WeakReference(paramBitmapDownloaderTask);
    }
    
    public ImageDownLoader.BitmapDownloaderTask getBitmapDownloaderTask()
    {
      return (ImageDownLoader.BitmapDownloaderTask)this.mBitmapDownloaderTaskReference.get();
    }
  }
  
  static class FlushedInputStream
    extends FilterInputStream
  {
    public FlushedInputStream(InputStream paramInputStream)
    {
      super();
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      long l2;
      for (long l1 = 0L;; l1 += l2)
      {
        if (l1 >= paramLong) {}
        do
        {
          return l1;
          l2 = this.in.skip(paramLong - l1);
          if (l2 != 0L) {
            break;
          }
        } while (read() < 0);
        l2 = 1L;
      }
    }
  }
  
  public static enum Mode
  {
    CORRECT,  NO_DOWNLOADED_DRAWABLE,  NO_ASYNC_TASK;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.ImageDownLoader
 * JD-Core Version:    0.7.0.1
 */