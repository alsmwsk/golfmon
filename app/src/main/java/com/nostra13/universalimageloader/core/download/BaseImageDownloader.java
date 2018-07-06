package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseImageDownloader
  implements ImageDownloader
{
  protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
  protected static final int BUFFER_SIZE = 32768;
  public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
  public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
  private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
  protected static final int MAX_REDIRECT_COUNT = 5;
  protected final int connectTimeout;
  protected final Context context;
  protected final int readTimeout;
  
  public BaseImageDownloader(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    this.connectTimeout = 5000;
    this.readTimeout = 20000;
  }
  
  public BaseImageDownloader(Context paramContext, int paramInt1, int paramInt2)
  {
    this.context = paramContext.getApplicationContext();
    this.connectTimeout = paramInt1;
    this.readTimeout = paramInt2;
  }
  
  protected HttpURLConnection createConnection(String paramString, Object paramObject)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(Uri.encode(paramString, "@#&=*+-_.,:!?()/~'%")).openConnection();
    localHttpURLConnection.setConnectTimeout(this.connectTimeout);
    localHttpURLConnection.setReadTimeout(this.readTimeout);
    return localHttpURLConnection;
  }
  
  public InputStream getStream(String paramString, Object paramObject)
    throws IOException
  {
    switch (1.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(paramString).ordinal()])
    {
    default: 
      return getStreamFromOtherSource(paramString, paramObject);
    case 1: 
    case 2: 
      return getStreamFromNetwork(paramString, paramObject);
    case 3: 
      return getStreamFromFile(paramString, paramObject);
    case 4: 
      return getStreamFromContent(paramString, paramObject);
    case 5: 
      return getStreamFromAssets(paramString, paramObject);
    }
    return getStreamFromDrawable(paramString, paramObject);
  }
  
  protected InputStream getStreamFromAssets(String paramString, Object paramObject)
    throws IOException
  {
    String str = ImageDownloader.Scheme.ASSETS.crop(paramString);
    return this.context.getAssets().open(str);
  }
  
  protected InputStream getStreamFromContent(String paramString, Object paramObject)
    throws FileNotFoundException
  {
    return this.context.getContentResolver().openInputStream(Uri.parse(paramString));
  }
  
  protected InputStream getStreamFromDrawable(String paramString, Object paramObject)
  {
    int i = Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(paramString));
    Bitmap localBitmap = ((BitmapDrawable)this.context.getResources().getDrawable(i)).getBitmap();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localBitmap.compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream);
    return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
  }
  
  protected InputStream getStreamFromFile(String paramString, Object paramObject)
    throws IOException
  {
    String str = ImageDownloader.Scheme.FILE.crop(paramString);
    return new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(str), 32768), new File(str).length());
  }
  
  protected InputStream getStreamFromNetwork(String paramString, Object paramObject)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = createConnection(paramString, paramObject);
    for (int i = 0; (localHttpURLConnection.getResponseCode() / 100 == 3) && (i < 5); i++) {
      localHttpURLConnection = createConnection(localHttpURLConnection.getHeaderField("Location"), paramObject);
    }
    return new ContentLengthInputStream(new BufferedInputStream(localHttpURLConnection.getInputStream(), 32768), localHttpURLConnection.getContentLength());
  }
  
  protected InputStream getStreamFromOtherSource(String paramString, Object paramObject)
    throws IOException
  {
    throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] { paramString }));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.BaseImageDownloader
 * JD-Core Version:    0.7.0.1
 */