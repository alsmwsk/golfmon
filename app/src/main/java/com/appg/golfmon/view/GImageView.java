package com.appg.golfmon.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.appg.golfmon.util.FileUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.LogUtil;
import java.io.File;
import java.util.HashMap;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

public class GImageView
  extends ImageView
{
  public static final int CANCEL = 2;
  public static final int COMPLETE = 1;
  public static final int FAIL = 3;
  private ImageLoader loader = null;
  @SuppressLint({"HandlerLeak"})
  private Handler mBitmapHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        String str;
        do
        {
          Bitmap localBitmap;
          do
          {
            return;
            HashMap localHashMap = (HashMap)paramAnonymousMessage.obj;
            str = "";
            if (localHashMap.containsKey("tag")) {
              str = (String)localHashMap.get("tag");
            }
            boolean bool = localHashMap.containsKey("bmp");
            localBitmap = null;
            if (bool) {
              localBitmap = (Bitmap)localHashMap.get("bmp");
            }
            if (localBitmap == null) {
              break;
            }
            if (GImageView.this.mIsBind) {
              GImageView.this.setImageBitmap(localBitmap);
            }
          } while (GImageView.this.mCallback == null);
          GImageView.this.mCallback.callback(1, str, localBitmap);
          return;
        } while (GImageView.this.mCallback == null);
        GImageView.this.mCallback.callback(3, str, null);
        return;
      } while (GImageView.this.mCallback == null);
      GImageView.this.mCallback.callback(2, null, null);
    }
  };
  private Callback mCallback = null;
  private boolean mIsBind = true;
  private boolean mIsSave = false;
  
  public GImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void trace(Object paramObject)
  {
    LogUtil.d((String)paramObject);
  }
  
  public void cancel()
  {
    try
    {
      if ((this.loader != null) && (this.loader.isAlive())) {
        this.loader.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setBind(boolean paramBoolean)
  {
    this.mIsBind = paramBoolean;
  }
  
  public void setCallback(Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setImageURL(String paramString)
  {
    setImageURL(paramString, "");
  }
  
  public void setImageURL(String paramString1, String paramString2)
  {
    setImageURL(paramString1, paramString2, null);
  }
  
  public void setImageURL(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      cancel();
      LogUtil.e(paramString1);
      this.loader = new ImageLoader(paramString2, paramString3);
      this.loader.load(paramString1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setImageURLCache(String paramString1, String paramString2)
  {
    if (FormatUtil.isNullorEmpty(paramString1))
    {
      Message localMessage = new Message();
      HashMap localHashMap = new HashMap();
      localHashMap.put("tag", paramString2);
      localHashMap.put("bmp", null);
      localMessage.what = 3;
      localMessage.obj = localHashMap;
      this.mBitmapHandler.sendMessage(localMessage);
      return;
    }
    setSaved(true);
    setImageURL(paramString1, paramString2, getContext().getCacheDir().getAbsolutePath() + "/" + paramString2);
  }
  
  public void setImageViewUser(String paramString1, String paramString2, final int paramInt)
  {
    if (FormatUtil.isNullorEmpty(paramString1))
    {
      setScaleType(ImageView.ScaleType.FIT_XY);
      setImageResource(paramInt);
      setTag(null);
    }
    final String str1;
    do
    {
      final String str2;
      do
      {
        return;
        if (!paramString1.startsWith("http")) {
          break;
        }
        str2 = "RS" + paramString2 + FileUtil.getFileName(paramString1);
      } while (str2.equals(getTag()));
      setScaleType(ImageView.ScaleType.FIT_XY);
      setImageResource(paramInt);
      setTag(paramString1);
      setCallback(new Callback()
      {
        public void callback(int paramAnonymousInt, Object paramAnonymousObject, Bitmap paramAnonymousBitmap)
        {
          if (!FormatUtil.isNullorEmpty((String)GImageView.this.getTag()))
          {
            if ((paramAnonymousInt == 1) && (str2.equals((String)paramAnonymousObject)) && (paramAnonymousBitmap != null))
            {
              GImageView.this.setScaleType(ImageView.ScaleType.CENTER_CROP);
              GImageView.this.setImageBitmap(paramAnonymousBitmap);
              GImageView.this.setTag(paramAnonymousObject);
              return;
            }
            GImageView.this.setScaleType(ImageView.ScaleType.FIT_XY);
            GImageView.this.setImageResource(paramInt);
            GImageView.this.setTag(null);
            return;
          }
          GImageView.this.setScaleType(ImageView.ScaleType.FIT_XY);
          GImageView.this.setImageResource(paramInt);
          GImageView.this.setTag(null);
        }
      });
      setImageURLCache(paramString1, str2);
      return;
      str1 = "RS" + paramString2 + FileUtil.getFileName(paramString1);
    } while (str1.equals(getTag()));
    setScaleType(ImageView.ScaleType.FIT_XY);
    setImageResource(paramInt);
    setTag(paramString1);
    setCallback(new Callback()
    {
      public void callback(int paramAnonymousInt, Object paramAnonymousObject, Bitmap paramAnonymousBitmap)
      {
        if (!FormatUtil.isNullorEmpty((String)GImageView.this.getTag()))
        {
          if ((paramAnonymousInt == 1) && (str1.equals((String)paramAnonymousObject)) && (paramAnonymousBitmap != null))
          {
            GImageView.this.setScaleType(ImageView.ScaleType.CENTER_CROP);
            GImageView.this.setImageBitmap(paramAnonymousBitmap);
            GImageView.this.setTag(paramAnonymousObject);
            return;
          }
          GImageView.this.setScaleType(ImageView.ScaleType.FIT_XY);
          GImageView.this.setImageResource(paramInt);
          GImageView.this.setTag(null);
          return;
        }
        GImageView.this.setScaleType(ImageView.ScaleType.FIT_XY);
        GImageView.this.setImageResource(paramInt);
        GImageView.this.setTag(null);
      }
    });
    setImageURLCache("http://115.68.14.78/" + paramString2 + "/" + paramString1, str1);
  }
  
  public void setSaved(boolean paramBoolean)
  {
    this.mIsSave = paramBoolean;
  }
  
  public static abstract interface Callback
  {
    public abstract void callback(int paramInt, Object paramObject, Bitmap paramBitmap);
  }
  
  private class ImageLoader
    implements Runnable
  {
    private static final int STATE_INIT = 1;
    private static final int STATE_STARTED = 2;
    private static final int STATE_STOPPED = 8;
    private HttpClient mClient = null;
    private String mLoadUrl = "";
    private String mSaveURI = "";
    private String mTag = "";
    private Thread mThisThread = null;
    private String mThreadName = "Genius Image Loader";
    private int mTimeout = 10000;
    private int stateCode = 1;
    
    public ImageLoader(String paramString1, String paramString2)
    {
      this.mTag = paramString1;
      this.mSaveURI = paramString2;
    }
    
    public boolean isAlive()
    {
      return (this.mThisThread != null) && (this.mThisThread.isAlive());
    }
    
    public void load(String paramString)
    {
      try
      {
        if (this.stateCode != 1)
        {
          GImageView.this.trace("이미지 로더가 이미 시작되었습니다.");
          return;
        }
        if ("".equals(paramString))
        {
          GImageView.this.trace("URL이 유효하지 않습니다.");
          Message localMessage = new Message();
          localMessage.what = 2;
          localMessage.obj = null;
          GImageView.this.mBitmapHandler.sendMessage(localMessage);
          return;
        }
      }
      finally {}
      this.mLoadUrl = paramString;
      this.mThisThread = new Thread(this);
      if (this.mThreadName != null) {
        this.mThisThread.setName(this.mThreadName);
      }
      this.mThisThread.start();
      this.stateCode = 2;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   4: invokestatic 115	com/appg/golfmon/view/GImageView:access$4	(Lcom/appg/golfmon/view/GImageView;)Z
      //   7: ifeq +153 -> 160
      //   10: new 117	java/io/File
      //   13: dup
      //   14: aload_0
      //   15: getfield 49	com/appg/golfmon/view/GImageView$ImageLoader:mSaveURI	Ljava/lang/String;
      //   18: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
      //   21: astore_1
      //   22: aload_1
      //   23: invokevirtual 122	java/io/File:isFile	()Z
      //   26: ifeq +134 -> 160
      //   29: aload_0
      //   30: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   33: new 124	java/lang/StringBuilder
      //   36: dup
      //   37: ldc 126
      //   39: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   42: aload_0
      //   43: getfield 49	com/appg/golfmon/view/GImageView$ImageLoader:mSaveURI	Ljava/lang/String;
      //   46: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   52: invokestatic 69	com/appg/golfmon/view/GImageView:access$2	(Lcom/appg/golfmon/view/GImageView;Ljava/lang/Object;)V
      //   55: aload_1
      //   56: invokevirtual 138	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   59: invokestatic 144	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   62: astore 28
      //   64: new 146	java/util/HashMap
      //   67: dup
      //   68: invokespecial 147	java/util/HashMap:<init>	()V
      //   71: astore 29
      //   73: aload 29
      //   75: ldc 149
      //   77: aload_0
      //   78: getfield 47	com/appg/golfmon/view/GImageView$ImageLoader:mTag	Ljava/lang/String;
      //   81: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   84: pop
      //   85: aload 29
      //   87: ldc 155
      //   89: aload 28
      //   91: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   94: pop
      //   95: new 79	android/os/Message
      //   98: dup
      //   99: invokespecial 80	android/os/Message:<init>	()V
      //   102: astore 32
      //   104: aload 32
      //   106: iconst_1
      //   107: putfield 83	android/os/Message:what	I
      //   110: aload 32
      //   112: aload 29
      //   114: putfield 87	android/os/Message:obj	Ljava/lang/Object;
      //   117: aload_0
      //   118: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   121: invokestatic 91	com/appg/golfmon/view/GImageView:access$3	(Lcom/appg/golfmon/view/GImageView;)Landroid/os/Handler;
      //   124: aload 32
      //   126: invokevirtual 97	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
      //   129: pop
      //   130: return
      //   131: astore 27
      //   133: aload_0
      //   134: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   137: new 124	java/lang/StringBuilder
      //   140: dup
      //   141: ldc 157
      //   143: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   146: aload 27
      //   148: invokevirtual 160	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
      //   151: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   154: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   157: invokestatic 69	com/appg/golfmon/view/GImageView:access$2	(Lcom/appg/golfmon/view/GImageView;Ljava/lang/Object;)V
      //   160: aconst_null
      //   161: astore_2
      //   162: new 79	android/os/Message
      //   165: dup
      //   166: invokespecial 80	android/os/Message:<init>	()V
      //   169: astore_3
      //   170: aload_0
      //   171: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   174: new 124	java/lang/StringBuilder
      //   177: dup
      //   178: ldc 162
      //   180: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   183: aload_0
      //   184: getfield 43	com/appg/golfmon/view/GImageView$ImageLoader:mLoadUrl	Ljava/lang/String;
      //   187: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   190: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   193: invokestatic 69	com/appg/golfmon/view/GImageView:access$2	(Lcom/appg/golfmon/view/GImageView;Ljava/lang/Object;)V
      //   196: aload_0
      //   197: new 164	org/apache/http/impl/client/DefaultHttpClient
      //   200: dup
      //   201: invokespecial 165	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
      //   204: putfield 51	com/appg/golfmon/view/GImageView$ImageLoader:mClient	Lorg/apache/http/client/HttpClient;
      //   207: aload_0
      //   208: getfield 51	com/appg/golfmon/view/GImageView$ImageLoader:mClient	Lorg/apache/http/client/HttpClient;
      //   211: invokeinterface 171 1 0
      //   216: astore 18
      //   218: aload 18
      //   220: aload_0
      //   221: getfield 45	com/appg/golfmon/view/GImageView$ImageLoader:mTimeout	I
      //   224: invokestatic 177	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
      //   227: aload 18
      //   229: aload_0
      //   230: getfield 45	com/appg/golfmon/view/GImageView$ImageLoader:mTimeout	I
      //   233: invokestatic 180	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
      //   236: aload 18
      //   238: sipush 8192
      //   241: invokestatic 183	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
      //   244: new 185	org/apache/http/client/methods/HttpGet
      //   247: dup
      //   248: new 187	java/net/URL
      //   251: dup
      //   252: aload_0
      //   253: getfield 43	com/appg/golfmon/view/GImageView$ImageLoader:mLoadUrl	Ljava/lang/String;
      //   256: ldc 189
      //   258: ldc 191
      //   260: invokevirtual 195	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   263: invokespecial 196	java/net/URL:<init>	(Ljava/lang/String;)V
      //   266: invokevirtual 200	java/net/URL:toURI	()Ljava/net/URI;
      //   269: invokespecial 203	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
      //   272: astore 19
      //   274: new 205	org/apache/http/entity/BufferedHttpEntity
      //   277: dup
      //   278: aload_0
      //   279: getfield 51	com/appg/golfmon/view/GImageView$ImageLoader:mClient	Lorg/apache/http/client/HttpClient;
      //   282: aload 19
      //   284: invokeinterface 209 2 0
      //   289: invokeinterface 215 1 0
      //   294: invokespecial 218	org/apache/http/entity/BufferedHttpEntity:<init>	(Lorg/apache/http/HttpEntity;)V
      //   297: invokevirtual 222	org/apache/http/entity/BufferedHttpEntity:getContent	()Ljava/io/InputStream;
      //   300: astore_2
      //   301: aload_2
      //   302: ifnull +294 -> 596
      //   305: aload_2
      //   306: invokestatic 226	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
      //   309: astore 20
      //   311: aload 20
      //   313: ifnull +173 -> 486
      //   316: aload_0
      //   317: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   320: invokestatic 115	com/appg/golfmon/view/GImageView:access$4	(Lcom/appg/golfmon/view/GImageView;)Z
      //   323: ifeq +22 -> 345
      //   326: aload_0
      //   327: getfield 49	com/appg/golfmon/view/GImageView$ImageLoader:mSaveURI	Ljava/lang/String;
      //   330: ifnull +15 -> 345
      //   333: aload 20
      //   335: aload_0
      //   336: getfield 49	com/appg/golfmon/view/GImageView$ImageLoader:mSaveURI	Ljava/lang/String;
      //   339: getstatic 232	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
      //   342: invokestatic 238	com/appg/golfmon/util/ImageUtil:SaveBitmapToFileCache	(Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;)V
      //   345: new 146	java/util/HashMap
      //   348: dup
      //   349: invokespecial 147	java/util/HashMap:<init>	()V
      //   352: astore 21
      //   354: aload 21
      //   356: ldc 149
      //   358: aload_0
      //   359: getfield 47	com/appg/golfmon/view/GImageView$ImageLoader:mTag	Ljava/lang/String;
      //   362: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   365: pop
      //   366: aload 21
      //   368: ldc 155
      //   370: aload 20
      //   372: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   375: pop
      //   376: aload_3
      //   377: iconst_1
      //   378: putfield 83	android/os/Message:what	I
      //   381: aload_3
      //   382: aload 21
      //   384: putfield 87	android/os/Message:obj	Ljava/lang/Object;
      //   387: aload_0
      //   388: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   391: invokestatic 91	com/appg/golfmon/view/GImageView:access$3	(Lcom/appg/golfmon/view/GImageView;)Landroid/os/Handler;
      //   394: aload_3
      //   395: invokevirtual 97	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
      //   398: pop
      //   399: aload_0
      //   400: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   403: new 124	java/lang/StringBuilder
      //   406: dup
      //   407: ldc 240
      //   409: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   412: aload_0
      //   413: getfield 43	com/appg/golfmon/view/GImageView$ImageLoader:mLoadUrl	Ljava/lang/String;
      //   416: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   419: ldc 242
      //   421: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   424: aload_0
      //   425: getfield 49	com/appg/golfmon/view/GImageView$ImageLoader:mSaveURI	Ljava/lang/String;
      //   428: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   431: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   434: invokestatic 69	com/appg/golfmon/view/GImageView:access$2	(Lcom/appg/golfmon/view/GImageView;Ljava/lang/Object;)V
      //   437: aload_2
      //   438: ifnull -308 -> 130
      //   441: aload_2
      //   442: invokevirtual 247	java/io/InputStream:close	()V
      //   445: return
      //   446: astore 25
      //   448: aload 25
      //   450: invokevirtual 250	java/lang/Exception:printStackTrace	()V
      //   453: return
      //   454: astore 26
      //   456: aload_0
      //   457: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   460: new 124	java/lang/StringBuilder
      //   463: dup
      //   464: ldc 157
      //   466: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   469: aload 26
      //   471: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   474: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   477: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   480: invokestatic 69	com/appg/golfmon/view/GImageView:access$2	(Lcom/appg/golfmon/view/GImageView;Ljava/lang/Object;)V
      //   483: goto -323 -> 160
      //   486: new 111	java/lang/Exception
      //   489: dup
      //   490: ldc 253
      //   492: invokespecial 254	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   495: athrow
      //   496: astore 12
      //   498: aload_0
      //   499: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   502: new 124	java/lang/StringBuilder
      //   505: dup
      //   506: ldc_w 256
      //   509: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   512: aload 12
      //   514: invokevirtual 160	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
      //   517: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   520: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   523: invokestatic 69	com/appg/golfmon/view/GImageView:access$2	(Lcom/appg/golfmon/view/GImageView;Ljava/lang/Object;)V
      //   526: new 146	java/util/HashMap
      //   529: dup
      //   530: invokespecial 147	java/util/HashMap:<init>	()V
      //   533: astore 13
      //   535: aload 13
      //   537: ldc 149
      //   539: aload_0
      //   540: getfield 47	com/appg/golfmon/view/GImageView$ImageLoader:mTag	Ljava/lang/String;
      //   543: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   546: pop
      //   547: aload 13
      //   549: ldc 155
      //   551: aconst_null
      //   552: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   555: pop
      //   556: aload_3
      //   557: iconst_3
      //   558: putfield 83	android/os/Message:what	I
      //   561: aload_3
      //   562: aload 13
      //   564: putfield 87	android/os/Message:obj	Ljava/lang/Object;
      //   567: aload_0
      //   568: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   571: invokestatic 91	com/appg/golfmon/view/GImageView:access$3	(Lcom/appg/golfmon/view/GImageView;)Landroid/os/Handler;
      //   574: aload_3
      //   575: invokevirtual 97	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
      //   578: pop
      //   579: aload_2
      //   580: ifnull -450 -> 130
      //   583: aload_2
      //   584: invokevirtual 247	java/io/InputStream:close	()V
      //   587: return
      //   588: astore 17
      //   590: aload 17
      //   592: invokevirtual 250	java/lang/Exception:printStackTrace	()V
      //   595: return
      //   596: new 111	java/lang/Exception
      //   599: dup
      //   600: ldc_w 258
      //   603: invokespecial 254	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   606: athrow
      //   607: astore 6
      //   609: aload_0
      //   610: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   613: new 124	java/lang/StringBuilder
      //   616: dup
      //   617: ldc_w 256
      //   620: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   623: aload 6
      //   625: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   628: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   631: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   634: invokestatic 69	com/appg/golfmon/view/GImageView:access$2	(Lcom/appg/golfmon/view/GImageView;Ljava/lang/Object;)V
      //   637: new 146	java/util/HashMap
      //   640: dup
      //   641: invokespecial 147	java/util/HashMap:<init>	()V
      //   644: astore 7
      //   646: aload 7
      //   648: ldc 149
      //   650: aload_0
      //   651: getfield 47	com/appg/golfmon/view/GImageView$ImageLoader:mTag	Ljava/lang/String;
      //   654: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   657: pop
      //   658: aload 7
      //   660: ldc 155
      //   662: aconst_null
      //   663: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   666: pop
      //   667: aload_3
      //   668: iconst_3
      //   669: putfield 83	android/os/Message:what	I
      //   672: aload_3
      //   673: aload 7
      //   675: putfield 87	android/os/Message:obj	Ljava/lang/Object;
      //   678: aload_0
      //   679: getfield 30	com/appg/golfmon/view/GImageView$ImageLoader:this$0	Lcom/appg/golfmon/view/GImageView;
      //   682: invokestatic 91	com/appg/golfmon/view/GImageView:access$3	(Lcom/appg/golfmon/view/GImageView;)Landroid/os/Handler;
      //   685: aload_3
      //   686: invokevirtual 97	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
      //   689: pop
      //   690: aload_2
      //   691: ifnull -561 -> 130
      //   694: aload_2
      //   695: invokevirtual 247	java/io/InputStream:close	()V
      //   698: return
      //   699: astore 11
      //   701: aload 11
      //   703: invokevirtual 250	java/lang/Exception:printStackTrace	()V
      //   706: return
      //   707: astore 4
      //   709: aload_2
      //   710: ifnull +7 -> 717
      //   713: aload_2
      //   714: invokevirtual 247	java/io/InputStream:close	()V
      //   717: aload 4
      //   719: athrow
      //   720: astore 5
      //   722: aload 5
      //   724: invokevirtual 250	java/lang/Exception:printStackTrace	()V
      //   727: goto -10 -> 717
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	730	0	this	ImageLoader
      //   21	35	1	localFile	File
      //   161	553	2	localInputStream	java.io.InputStream
      //   169	517	3	localMessage1	Message
      //   707	11	4	localObject	Object
      //   720	3	5	localException1	Exception
      //   607	17	6	localException2	Exception
      //   644	30	7	localHashMap1	HashMap
      //   699	3	11	localException3	Exception
      //   496	17	12	localOutOfMemoryError1	java.lang.OutOfMemoryError
      //   533	30	13	localHashMap2	HashMap
      //   588	3	17	localException4	Exception
      //   216	21	18	localHttpParams	org.apache.http.params.HttpParams
      //   272	11	19	localHttpGet	org.apache.http.client.methods.HttpGet
      //   309	62	20	localBitmap1	Bitmap
      //   352	31	21	localHashMap3	HashMap
      //   446	3	25	localException5	Exception
      //   454	16	26	localException6	Exception
      //   131	16	27	localOutOfMemoryError2	java.lang.OutOfMemoryError
      //   62	28	28	localBitmap2	Bitmap
      //   71	42	29	localHashMap4	HashMap
      //   102	23	32	localMessage2	Message
      // Exception table:
      //   from	to	target	type
      //   55	130	131	java/lang/OutOfMemoryError
      //   441	445	446	java/lang/Exception
      //   55	130	454	java/lang/Exception
      //   170	301	496	java/lang/OutOfMemoryError
      //   305	311	496	java/lang/OutOfMemoryError
      //   316	345	496	java/lang/OutOfMemoryError
      //   345	437	496	java/lang/OutOfMemoryError
      //   486	496	496	java/lang/OutOfMemoryError
      //   596	607	496	java/lang/OutOfMemoryError
      //   583	587	588	java/lang/Exception
      //   170	301	607	java/lang/Exception
      //   305	311	607	java/lang/Exception
      //   316	345	607	java/lang/Exception
      //   345	437	607	java/lang/Exception
      //   486	496	607	java/lang/Exception
      //   596	607	607	java/lang/Exception
      //   694	698	699	java/lang/Exception
      //   170	301	707	finally
      //   305	311	707	finally
      //   316	345	707	finally
      //   345	437	707	finally
      //   486	496	707	finally
      //   498	579	707	finally
      //   596	607	707	finally
      //   609	690	707	finally
      //   713	717	720	java/lang/Exception
    }
    
    public void stop()
    {
      try
      {
        if (this.stateCode == 8)
        {
          GImageView.this.trace("이미지 로더가 이미 중지되었습니다.");
          return;
        }
        this.stateCode = 8;
        if (this.mClient != null) {
          this.mClient.getConnectionManager().shutdown();
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.view.GImageView
 * JD-Core Version:    0.7.0.1
 */