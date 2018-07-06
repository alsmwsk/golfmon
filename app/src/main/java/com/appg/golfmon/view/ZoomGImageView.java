package com.appg.golfmon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.ImageUtil;
import com.appg.golfmon.util.LogUtil;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ZoomGImageView
  extends ImageView
{
  public static final int CANCEL = 2;
  public static final int COMPLETE = 1;
  private static final int DRAG = 1;
  public static final int FAIL = 3;
  private static final int HEIGHT = 1;
  private static final int NONE = 0;
  private static final int WIDTH = 0;
  private static final int ZOOM = 2;
  private Drawable d;
  boolean isBottom = false;
  boolean isDraggable = false;
  boolean isLeft = false;
  boolean isRight = false;
  boolean isTop = false;
  private ImageLoader loader = null;
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
            if (ZoomGImageView.this.mIsBind) {
              ZoomGImageView.this.setImageBitmap(localBitmap);
            }
          } while (ZoomGImageView.this.mCallback == null);
          ZoomGImageView.this.mCallback.callback(1, str, localBitmap);
          return;
        } while (ZoomGImageView.this.mCallback == null);
        ZoomGImageView.this.mCallback.callback(3, str, null);
        return;
        if (ZoomGImageView.this.mCancelListener != null) {
          ZoomGImageView.this.mCancelListener.onCancel();
        }
      } while (ZoomGImageView.this.mCallback == null);
      ZoomGImageView.this.mCallback.callback(2, null, null);
    }
  };
  private Callback mCallback = null;
  private OnCancelLoadListener mCancelListener = null;
  private boolean mIsBind = true;
  private boolean mIsRound = false;
  private boolean mIsSave = false;
  private int mNoImgResId = -1;
  private int mResize = -1;
  Matrix matrix = new Matrix();
  private PointF mid = new PointF();
  private int mode = 0;
  private float oldDist = 1.0F;
  Matrix savedMatrix = new Matrix();
  Matrix savedMatrix2 = new Matrix();
  private PointF start = new PointF();
  
  public ZoomGImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ZoomGImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ZoomGImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void dumpEvent(MotionEvent paramMotionEvent)
  {
    String[] arrayOfString = { "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?" };
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramMotionEvent.getAction();
    int j = i & 0xFF;
    localStringBuilder.append("event ACTION_").append(arrayOfString[j]);
    if ((j == 5) || (j == 6))
    {
      localStringBuilder.append("(pid ").append(i >> 8);
      localStringBuilder.append(")");
    }
    localStringBuilder.append("[");
    for (int k = 0;; k++)
    {
      if (k >= paramMotionEvent.getPointerCount())
      {
        localStringBuilder.append("]");
        LogUtil.d("event", localStringBuilder.toString());
        return;
      }
      localStringBuilder.append("#").append(k);
      localStringBuilder.append("(pid ").append(paramMotionEvent.getPointerId(k));
      localStringBuilder.append(")=").append((int)paramMotionEvent.getX(k));
      localStringBuilder.append(",").append((int)paramMotionEvent.getY(k));
      if (k + 1 < paramMotionEvent.getPointerCount()) {
        localStringBuilder.append(";");
      }
    }
  }
  
  private void matrixTuning(Matrix paramMatrix)
  {
    float[] arrayOfFloat1 = new float[9];
    paramMatrix.getValues(arrayOfFloat1);
    float[] arrayOfFloat2 = new float[9];
    this.savedMatrix2.getValues(arrayOfFloat2);
    int i = getWidth();
    int j = getHeight();
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    int n = (int)(k * arrayOfFloat1[0]);
    int i1 = (int)(m * arrayOfFloat1[4]);
    if (arrayOfFloat1[2] < i - n) {
      arrayOfFloat1[2] = (i - n);
    }
    if (arrayOfFloat1[5] < j - i1) {
      arrayOfFloat1[5] = (j - i1);
    }
    if (arrayOfFloat1[2] >= 0.0F) {
      arrayOfFloat1[2] = 0.0F;
    }
    if (arrayOfFloat1[5] >= 0.0F) {
      arrayOfFloat1[5] = 0.0F;
    }
    if ((arrayOfFloat1[0] > 3.0F) || (arrayOfFloat1[4] > 3.0F))
    {
      arrayOfFloat1[0] = arrayOfFloat2[0];
      arrayOfFloat1[4] = arrayOfFloat2[4];
      arrayOfFloat1[2] = arrayOfFloat2[2];
      arrayOfFloat1[5] = arrayOfFloat2[5];
    }
    if ((k > i) || (m > j)) {
      if ((n < i) && (i1 < j))
      {
        int i4 = 0;
        if (k < m) {
          i4 = 1;
        }
        if (i4 == 0)
        {
          float f4 = i / k;
          arrayOfFloat1[4] = f4;
          arrayOfFloat1[0] = f4;
        }
        if (i4 == 1)
        {
          float f3 = j / m;
          arrayOfFloat1[4] = f3;
          arrayOfFloat1[0] = f3;
        }
        int i5 = (int)(k * arrayOfFloat1[0]);
        int i6 = (int)(m * arrayOfFloat1[4]);
        if (i5 > i)
        {
          float f2 = i / k;
          arrayOfFloat1[4] = f2;
          arrayOfFloat1[0] = f2;
        }
        if (i6 > j)
        {
          float f1 = j / m;
          arrayOfFloat1[4] = f1;
          arrayOfFloat1[0] = f1;
        }
      }
    }
    for (;;)
    {
      int i2 = (int)(k * arrayOfFloat1[0]);
      int i3 = (int)(m * arrayOfFloat1[4]);
      if (i2 < i) {
        arrayOfFloat1[2] = (i / 2.0F - i2 / 2.0F);
      }
      if (i3 < j) {
        arrayOfFloat1[5] = (j / 2.0F - i3 / 2.0F);
      }
      paramMatrix.setValues(arrayOfFloat1);
      this.savedMatrix2.set(paramMatrix);
      return;
      if (arrayOfFloat1[0] < 1.0F) {
        arrayOfFloat1[0] = 1.0F;
      }
      if (arrayOfFloat1[4] < 1.0F) {
        arrayOfFloat1[4] = 1.0F;
      }
    }
  }
  
  private void midPoint(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) + paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) + paramMotionEvent.getY(1);
    paramPointF.set(f1 / 2.0F, f2 / 2.0F);
  }
  
  private void printValue(float[] paramArrayOfFloat)
  {
    String str = "";
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfFloat.length)
      {
        LogUtil.d(str);
        return;
      }
      str = str + "value[" + i + "]=" + paramArrayOfFloat[i] + " // ";
    }
  }
  
  private void restore(Matrix paramMatrix)
  {
    setImageMatrix(this.matrix);
  }
  
  private void setNoImage()
  {
    if (this.mNoImgResId > 0)
    {
      setImageResource(this.mNoImgResId);
      return;
    }
    setImageBitmap(null);
  }
  
  private float spacing(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return FloatMath.sqrt(f1 * f1 + f2 * f2);
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
  
  protected void init()
  {
    this.d = getDrawable();
    initImgPos();
    setImageMatrix(this.matrix);
  }
  
  public void initImgPos()
  {
    float[] arrayOfFloat = new float[9];
    this.matrix.getValues(arrayOfFloat);
    int i = getWidth();
    int j = getHeight();
    if (this.d == null) {
      return;
    }
    int k = this.d.getIntrinsicWidth();
    int m = this.d.getIntrinsicHeight();
    ((int)(k * arrayOfFloat[0]));
    ((int)(m * arrayOfFloat[4]));
    if ((k > i) || (m > j))
    {
      float f = Math.max(i / k, j / m);
      arrayOfFloat[4] = f;
      arrayOfFloat[0] = f;
    }
    int n = (int)(k * arrayOfFloat[0]);
    int i1 = (int)(m * arrayOfFloat[4]);
    arrayOfFloat[2] = (i / 2.0F - n / 2.0F);
    arrayOfFloat[5] = (j / 2.0F - i1 / 2.0F);
    this.matrix.setValues(arrayOfFloat);
    setImageMatrix(this.matrix);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    init();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    LogUtil.e("onTouchEvent VIEW");
    boolean bool1;
    label138:
    boolean bool2;
    if (this.isDraggable) {
      switch (0xFF & paramMotionEvent.getAction())
      {
      case 3: 
      case 4: 
      default: 
        matrixTuning(this.matrix);
        if (this.mode == 1)
        {
          float[] arrayOfFloat = new float[9];
          this.savedMatrix2.getValues(arrayOfFloat);
          Drawable localDrawable = getDrawable();
          if (localDrawable != null)
          {
            int i = getWidth();
            int j = (int)(localDrawable.getIntrinsicWidth() * arrayOfFloat[0]);
            if (arrayOfFloat[2] != 0.0F) {
              break label400;
            }
            bool1 = true;
            this.isLeft = bool1;
            if (arrayOfFloat[2] - 10.0F >= i - j) {
              break label406;
            }
            bool2 = true;
            label165:
            this.isRight = bool2;
          }
        }
        break;
      }
    }
    for (;;)
    {
      setImageMatrix(this.savedMatrix2);
      return true;
      this.savedMatrix.set(this.matrix);
      this.start.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.mode = 1;
      break;
      this.oldDist = spacing(paramMotionEvent);
      if (this.oldDist <= 10.0F) {
        break;
      }
      this.savedMatrix.set(this.matrix);
      midPoint(this.mid, paramMotionEvent);
      this.mode = 2;
      break;
      this.mode = 0;
      restore(this.matrix);
      break;
      if (this.mode == 1)
      {
        this.matrix.set(this.savedMatrix);
        this.matrix.postTranslate(paramMotionEvent.getX() - this.start.x, paramMotionEvent.getY() - this.start.y);
        break;
      }
      if (this.mode != 2) {
        break;
      }
      float f1 = spacing(paramMotionEvent);
      if (f1 <= 10.0F) {
        break;
      }
      this.matrix.set(this.savedMatrix);
      float f2 = f1 / this.oldDist;
      this.matrix.postScale(f2, f2, this.mid.x, this.mid.y);
      break;
      label400:
      bool1 = false;
      break label138;
      label406:
      bool2 = false;
      break label165;
      this.isRight = false;
      this.isLeft = false;
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
    try
    {
      cancel();
      LogUtil.e(paramString1);
      this.loader = new ImageLoader(paramString2, null);
      this.loader.load(paramString1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
  
  public void setImageURL(final HashMap<String, Bitmap> paramHashMap, final String paramString1, final String paramString2, String paramString3)
  {
    cancel();
    setNoImage();
    if (FormatUtil.isNullorEmpty(paramString2))
    {
      setNoImage();
      setCallback(null);
      return;
    }
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString2)))
    {
      setImageBitmap((Bitmap)paramHashMap.get(paramString2));
      setCallback(null);
      return;
    }
    setCallback(new Callback()
    {
      public void callback(int paramAnonymousInt, Object paramAnonymousObject, Bitmap paramAnonymousBitmap)
      {
        if ((paramAnonymousInt == 1) && (paramString1.equals((String)paramAnonymousObject)) && (paramAnonymousBitmap != null))
        {
          ZoomGImageView.this.setImageBitmap(paramAnonymousBitmap);
          ZoomGImageView.this.setTag(paramString2);
          if (paramHashMap != null) {
            paramHashMap.put(paramString2, paramAnonymousBitmap);
          }
          return;
        }
        ZoomGImageView.this.setNoImage();
      }
    });
    setImageURL(ImageUtil.wrapImgUrl(paramString2, paramString3), paramString1);
  }
  
  public void setImageURLCache(String paramString1, String paramString2)
  {
    setImageURLCache(paramString1, paramString2, -1);
  }
  
  public void setImageURLCache(String paramString1, final String paramString2, int paramInt)
  {
    this.mResize = paramInt;
    this.mIsSave = true;
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
    File localFile = new File(getContext().getCacheDir(), paramString2);
    final String str = localFile.getAbsolutePath();
    if (localFile.isFile())
    {
      if (this.mCallback != null)
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              int[] arrayOfInt = ImageUtil.getImageSize(str);
              BitmapFactory.Options localOptions;
              if (ZoomGImageView.this.mResize > 0)
              {
                int i = Math.max(arrayOfInt[0], arrayOfInt[1]);
                int j = 2 * ZoomGImageView.this.mResize;
                localObject = null;
                if (i > j)
                {
                  int k = 1 + i / (2 * ZoomGImageView.this.mResize);
                  LogUtil.e("이미지 리사이즈 : " + k);
                  localOptions = new BitmapFactory.Options();
                  localOptions.inSampleSize = k;
                }
              }
              Bitmap localBitmap;
              for (Object localObject = BitmapFactory.decodeFile(str, localOptions);; localObject = localBitmap)
              {
                HashMap localHashMap = new HashMap();
                localHashMap.put("tag", paramString2);
                localHashMap.put("bmp", localObject);
                Message localMessage = new Message();
                localMessage.what = 1;
                localMessage.obj = localHashMap;
                ZoomGImageView.this.mBitmapHandler.sendMessage(localMessage);
                return;
                localBitmap = BitmapFactory.decodeFile(str);
              }
              return;
            }
            catch (Exception localException) {}
          }
        }).start();
        return;
      }
      setImageURI(Uri.parse(str));
      return;
    }
    setImageURL(paramString1, paramString2, str);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    this.matrix.set(paramMatrix);
  }
  
  public void setNoImageResID(int paramInt)
  {
    this.mNoImgResId = paramInt;
  }
  
  public void setOnCancelLoadListener(OnCancelLoadListener paramOnCancelLoadListener)
  {
    this.mCancelListener = paramOnCancelLoadListener;
  }
  
  public void setRound(boolean paramBoolean)
  {
    this.mIsRound = paramBoolean;
  }
  
  public void setSaved(boolean paramBoolean)
  {
    this.mIsSave = paramBoolean;
  }
  
  public void setSavedMatrix(Matrix paramMatrix)
  {
    this.savedMatrix.set(paramMatrix);
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
          ZoomGImageView.this.trace("이미지 로더가 이미 시작되었습니다.");
          return;
        }
        if ("".equals(paramString))
        {
          ZoomGImageView.this.trace("URL이 유효하지 않습니다.");
          Message localMessage = new Message();
          localMessage.what = 2;
          localMessage.obj = null;
          ZoomGImageView.this.mBitmapHandler.sendMessage(localMessage);
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
    
    public void run()
    {
      InputStream localInputStream = null;
      Message localMessage = new Message();
      try
      {
        ZoomGImageView.this.trace("이미지를 로딩합니다.");
        this.mClient = new DefaultHttpClient();
        HttpParams localHttpParams = this.mClient.getParams();
        HttpConnectionParams.setConnectionTimeout(localHttpParams, this.mTimeout);
        HttpConnectionParams.setSoTimeout(localHttpParams, this.mTimeout);
        HttpConnectionParams.setSocketBufferSize(localHttpParams, 8192);
        HttpGet localHttpGet = new HttpGet(new URL(this.mLoadUrl).toURI());
        localInputStream = new BufferedHttpEntity(this.mClient.execute(localHttpGet).getEntity()).getContent();
        if (localInputStream != null)
        {
          Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
          if ((ZoomGImageView.this.mIsSave) && (this.mSaveURI != null)) {
            ImageUtil.SaveBitmapToFileCache(localBitmap, this.mSaveURI, Bitmap.CompressFormat.PNG);
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("tag", this.mTag);
          localHashMap.put("bmp", localBitmap);
          localMessage.what = 1;
          localMessage.obj = localHashMap;
          ZoomGImageView.this.mBitmapHandler.sendMessage(localMessage);
          ZoomGImageView.this.trace("이미지를 로드를 완료했습니다.");
        }
        if (localInputStream != null) {}
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        do
        {
          localOutOfMemoryError = localOutOfMemoryError;
          localOutOfMemoryError.printStackTrace();
          localMessage.what = 3;
          localMessage.obj = null;
          ZoomGImageView.this.mBitmapHandler.sendMessage(localMessage);
        } while (localInputStream == null);
        try
        {
          localInputStream.close();
          return;
        }
        catch (Exception localException4)
        {
          localException4.printStackTrace();
          return;
        }
      }
      catch (Exception localException2)
      {
        do
        {
          localException2.printStackTrace();
          localMessage.what = 3;
          localMessage.obj = null;
          ZoomGImageView.this.mBitmapHandler.sendMessage(localMessage);
        } while (localInputStream == null);
        try
        {
          localInputStream.close();
          return;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localInputStream != null) {}
        try
        {
          localInputStream.close();
          throw localObject;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
          }
        }
      }
    }
    
    public void stop()
    {
      try
      {
        if (this.stateCode == 8)
        {
          ZoomGImageView.this.trace("이미지 로더가 이미 중지되었습니다.");
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
  
  public static abstract interface OnCancelLoadListener
  {
    public abstract void onCancel();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.view.ZoomGImageView
 * JD-Core Version:    0.7.0.1
 */