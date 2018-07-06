package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.ll;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object Lu = new Object();
  private static HashSet<Uri> Lv = new HashSet();
  private static ImageManager Lw;
  private static ImageManager Lx;
  private final jc LA;
  private final Map<a, ImageReceiver> LB;
  private final Map<Uri, ImageReceiver> LC;
  private final Map<Uri, Long> LD;
  private final ExecutorService Ly;
  private final b Lz;
  private final Context mContext;
  private final Handler mHandler;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.Ly = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.Lz = new b(this.mContext);
      if (ll.ij()) {
        hd();
      }
    }
    for (;;)
    {
      this.LA = new jc();
      this.LB = new HashMap();
      this.LC = new HashMap();
      this.LD = new HashMap();
      return;
      this.Lz = null;
    }
  }
  
  private Bitmap a(a.a parama)
  {
    if (this.Lz == null) {
      return null;
    }
    return (Bitmap)this.Lz.get(parama);
  }
  
  public static ImageManager c(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Lx == null) {
        Lx = new ImageManager(paramContext, true);
      }
      return Lx;
    }
    if (Lw == null) {
      Lw = new ImageManager(paramContext, false);
    }
    return Lw;
  }
  
  public static ImageManager create(Context paramContext)
  {
    return c(paramContext, false);
  }
  
  private void hd()
  {
    this.mContext.registerComponentCallbacks(new e(this.Lz));
  }
  
  public void a(a parama)
  {
    je.aU("ImageManager.loadImage() must be called in the main thread");
    new d(parama).run();
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    a(new a.b(paramImageView, paramInt));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    a(new a.b(paramImageView, paramUri));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    a.b localb = new a.b(paramImageView, paramUri);
    localb.az(paramInt);
    a(localb);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    a(new a.c(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    a.c localc = new a.c(paramOnImageLoadedListener, paramUri);
    localc.az(paramInt);
    a(localc);
  }
  
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final ArrayList<a> LE;
    private final Uri mUri;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      this.mUri = paramUri;
      this.LE = new ArrayList();
    }
    
    public void b(a parama)
    {
      je.aU("ImageReceiver.addImageRequest() must be called in the main thread");
      this.LE.add(parama);
    }
    
    public void c(a parama)
    {
      je.aU("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.LE.remove(parama);
    }
    
    public void hg()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.b(ImageManager.this).sendBroadcast(localIntent);
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.f(ImageManager.this).execute(new ImageManager.c(ImageManager.this, this.mUri, localParcelFileDescriptor));
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  private static final class a
  {
    static int a(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }
  
  private static final class b
    extends kj<a.a, Bitmap>
  {
    public b(Context paramContext)
    {
      super();
    }
    
    private static int I(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      int i;
      if ((0x100000 & paramContext.getApplicationInfo().flags) != 0)
      {
        i = 1;
        if ((i == 0) || (!ll.ig())) {
          break label55;
        }
      }
      label55:
      for (int j = ImageManager.a.a(localActivityManager);; j = localActivityManager.getMemoryClass())
      {
        return (int)(0.33F * (j * 1048576));
        i = 0;
        break;
      }
    }
    
    protected int a(a.a parama, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }
    
    protected void a(boolean paramBoolean, a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, parama, paramBitmap1, paramBitmap2);
    }
  }
  
  private final class c
    implements Runnable
  {
    private final ParcelFileDescriptor LG;
    private final Uri mUri;
    
    public c(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.mUri = paramUri;
      this.LG = paramParcelFileDescriptor;
    }
    
    public void run()
    {
      je.aV("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      ParcelFileDescriptor localParcelFileDescriptor = this.LG;
      Object localObject = null;
      boolean bool = false;
      if (localParcelFileDescriptor != null) {}
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(this.LG.getFileDescriptor());
        localObject = localBitmap;
        CountDownLatch localCountDownLatch;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          for (;;)
          {
            this.LG.close();
            localCountDownLatch = new CountDownLatch(1);
            ImageManager.g(ImageManager.this).post(new ImageManager.f(ImageManager.this, this.mUri, localObject, bool, localCountDownLatch));
            try
            {
              localCountDownLatch.await();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
            localOutOfMemoryError = localOutOfMemoryError;
            Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, localOutOfMemoryError);
            bool = true;
            localObject = null;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("ImageManager", "closed failed", localIOException);
          }
        }
      }
    }
  }
  
  private final class d
    implements Runnable
  {
    private final a LH;
    
    public d(a parama)
    {
      this.LH = parama;
    }
    
    public void run()
    {
      je.aU("LoadImageRunnable must be executed on the main thread");
      ImageManager.ImageReceiver localImageReceiver1 = (ImageManager.ImageReceiver)ImageManager.a(ImageManager.this).get(this.LH);
      if (localImageReceiver1 != null)
      {
        ImageManager.a(ImageManager.this).remove(this.LH);
        localImageReceiver1.c(this.LH);
      }
      a.a locala = this.LH.LJ;
      if (locala.uri == null)
      {
        this.LH.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
        return;
      }
      Bitmap localBitmap = ImageManager.a(ImageManager.this, locala);
      if (localBitmap != null)
      {
        this.LH.a(ImageManager.b(ImageManager.this), localBitmap, true);
        return;
      }
      Long localLong = (Long)ImageManager.d(ImageManager.this).get(locala.uri);
      if (localLong != null)
      {
        if (SystemClock.elapsedRealtime() - localLong.longValue() < 3600000L)
        {
          this.LH.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
          return;
        }
        ImageManager.d(ImageManager.this).remove(locala.uri);
      }
      this.LH.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this));
      ImageManager.ImageReceiver localImageReceiver2 = (ImageManager.ImageReceiver)ImageManager.e(ImageManager.this).get(locala.uri);
      if (localImageReceiver2 == null)
      {
        localImageReceiver2 = new ImageManager.ImageReceiver(ImageManager.this, locala.uri);
        ImageManager.e(ImageManager.this).put(locala.uri, localImageReceiver2);
      }
      localImageReceiver2.b(this.LH);
      if (!(this.LH instanceof a.c)) {
        ImageManager.a(ImageManager.this).put(this.LH, localImageReceiver2);
      }
      synchronized (ImageManager.he())
      {
        if (!ImageManager.hf().contains(locala.uri))
        {
          ImageManager.hf().add(locala.uri);
          localImageReceiver2.hg();
        }
        return;
      }
    }
  }
  
  private static final class e
    implements ComponentCallbacks2
  {
    private final ImageManager.b Lz;
    
    public e(ImageManager.b paramb)
    {
      this.Lz = paramb;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory()
    {
      this.Lz.evictAll();
    }
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60) {
        this.Lz.evictAll();
      }
      while (paramInt < 20) {
        return;
      }
      this.Lz.trimToSize(this.Lz.size() / 2);
    }
  }
  
  private final class f
    implements Runnable
  {
    private boolean LI;
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch mr;
    
    public f(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.mUri = paramUri;
      this.mBitmap = paramBitmap;
      this.LI = paramBoolean;
      this.mr = paramCountDownLatch;
    }
    
    private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      ArrayList localArrayList = ImageManager.ImageReceiver.a(paramImageReceiver);
      int i = localArrayList.size();
      int j = 0;
      if (j < i)
      {
        a locala = (a)localArrayList.get(j);
        if (paramBoolean) {
          locala.a(ImageManager.b(ImageManager.this), this.mBitmap, false);
        }
        for (;;)
        {
          if (!(locala instanceof a.c)) {
            ImageManager.a(ImageManager.this).remove(locala);
          }
          j++;
          break;
          ImageManager.d(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          locala.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), false);
        }
      }
    }
    
    public void run()
    {
      je.aU("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null) {
        bool = true;
      }
      while (ImageManager.h(ImageManager.this) != null) {
        if (this.LI)
        {
          ImageManager.h(ImageManager.this).evictAll();
          System.gc();
          this.LI = false;
          ImageManager.g(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.h(ImageManager.this).put(new a.a(this.mUri), this.mBitmap);
        }
      }
      ImageManager.ImageReceiver localImageReceiver = (ImageManager.ImageReceiver)ImageManager.e(ImageManager.this).remove(this.mUri);
      if (localImageReceiver != null) {
        a(localImageReceiver, bool);
      }
      this.mr.countDown();
      synchronized (ImageManager.he())
      {
        ImageManager.hf().remove(this.mUri);
        return;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.7.0.1
 */