package com.appg.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.appg.golfmon.util.ImageUtil;
import com.appg.golfmon.util.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CropImage
  extends View
{
  public static final int FREE = 100;
  public static final int SCALE = 200;
  public static final int SCALE_2 = 300;
  public static final int SENSITIVITY = 40;
  private Bitmap DISPLAY_BITMAP;
  private float DISPLAY_HEIGHT;
  private float DISPLAY_WIDTH;
  private int IMAGE_DEGREE = 0;
  private int MIN_HEIGHT = 100;
  private int MIN_WIDTH = 100;
  private int MODE = 100;
  private int ORIGINAL_BITMAP_HEIGHT = 0;
  private String ORIGINAL_BITMAP_PATH = "";
  private int ORIGINAL_BITMAP_WIDTH = 0;
  private int POINT_COLOR = -12537089;
  private Paint POINT_PAINT = null;
  private Paint POINT_PAINT_OVER = null;
  private float POSITION_HORIZONTAL = 0.0F;
  private float POSITION_VERTICAL = 0.0F;
  private PointF[] PTS = new PointF[12];
  private int RECT_LINE_COLOR = -12537089;
  private int RECT_LINE_WIDTH = 2;
  private Paint RECT_PAINT = null;
  private Paint RECT_PAINT_OVER = null;
  private float RESIZE_RATIO = 0.0F;
  private int mInSampleSize = 1;
  private IDataSet mListener = null;
  private int mPlusDegree = 0;
  
  public CropImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.DISPLAY_WIDTH = localDisplayMetrics.widthPixels;
    this.DISPLAY_HEIGHT = localDisplayMetrics.heightPixels;
    this.RECT_PAINT = new Paint();
    this.RECT_PAINT.setStyle(Paint.Style.STROKE);
    this.RECT_PAINT.setColor(this.RECT_LINE_COLOR);
    this.RECT_PAINT.setStrokeWidth(this.RECT_LINE_WIDTH);
    this.RECT_PAINT_OVER = new Paint();
    this.RECT_PAINT_OVER.setStyle(Paint.Style.FILL);
    this.RECT_PAINT_OVER.setColor(822083583);
    this.POINT_PAINT = new Paint();
    this.POINT_PAINT.setStyle(Paint.Style.FILL);
    this.POINT_PAINT.setColor(this.POINT_COLOR);
    this.POINT_PAINT.setTextSize(15.0F);
    this.POINT_PAINT.setAntiAlias(true);
    this.POINT_PAINT_OVER = new Paint();
    this.POINT_PAINT_OVER.setStyle(Paint.Style.FILL);
    this.POINT_PAINT_OVER.setColor(817946879);
    this.POINT_PAINT_OVER.setAntiAlias(true);
    for (int i = 0;; i++)
    {
      if (i >= 8)
      {
        this.PTS[8] = new PointF(0.0F, 0.0F);
        this.PTS[9] = new PointF(this.DISPLAY_WIDTH, this.DISPLAY_HEIGHT);
        this.PTS[10] = new PointF(0.0F, 0.0F);
        this.PTS[11] = new PointF(this.DISPLAY_WIDTH, this.DISPLAY_HEIGHT);
        return;
      }
      this.PTS[i] = new PointF();
    }
  }
  
  private void onLayout2()
  {
    if (this.DISPLAY_BITMAP != null) {
      this.DISPLAY_BITMAP.recycle();
    }
    this.DISPLAY_WIDTH = getWidth();
    this.DISPLAY_HEIGHT = getHeight();
    LogUtil.e("VIEW WIDTH : " + getWidth());
    LogUtil.e("VIEW HEIGHT : " + getHeight());
    this.RESIZE_RATIO = 1.0F;
    float f1 = Math.min(this.ORIGINAL_BITMAP_HEIGHT, this.DISPLAY_HEIGHT) / Math.max(this.ORIGINAL_BITMAP_HEIGHT, this.DISPLAY_HEIGHT);
    float f2 = Math.min(this.ORIGINAL_BITMAP_WIDTH, this.DISPLAY_WIDTH) / Math.max(this.ORIGINAL_BITMAP_WIDTH, this.DISPLAY_WIDTH);
    LogUtil.e("WIDTH_RATIO : " + f1);
    LogUtil.e("HEIGHT_RATIO : " + f2);
    if (f1 > f2) {
      if (this.DISPLAY_WIDTH < this.ORIGINAL_BITMAP_WIDTH) {
        this.RESIZE_RATIO = (this.DISPLAY_WIDTH / this.ORIGINAL_BITMAP_WIDTH);
      }
    }
    for (;;)
    {
      LogUtil.e("RESIZE_RATIO : " + this.RESIZE_RATIO);
      double d = 0.0D;
      label237:
      int i;
      int j;
      Bitmap localBitmap1;
      int k;
      label373:
      int m;
      label404:
      Bitmap localBitmap2;
      if ((this.RESIZE_RATIO > 1.0F) || ((this.RESIZE_RATIO <= Math.pow(2.0D, -1.0D * d)) && (this.RESIZE_RATIO >= Math.pow(2.0D, -1.0D * (1.0D + d)))))
      {
        i = (int)(this.ORIGINAL_BITMAP_WIDTH * this.RESIZE_RATIO);
        j = (int)(this.ORIGINAL_BITMAP_HEIGHT * this.RESIZE_RATIO);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = (2 * (int)Math.pow(2.0D, 1.0D + d));
        localBitmap1 = BitmapFactory.decodeFile(this.ORIGINAL_BITMAP_PATH, localOptions);
        if ((this.IMAGE_DEGREE + this.mPlusDegree != 0) && (this.IMAGE_DEGREE + this.mPlusDegree != 180)) {
          break label611;
        }
        k = i;
        if ((this.IMAGE_DEGREE + this.mPlusDegree != 0) && (this.IMAGE_DEGREE + this.mPlusDegree != 180)) {
          break label618;
        }
        m = j;
        localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, k, m, false);
      }
      try
      {
        this.DISPLAY_BITMAP = ImageUtil.getRotatedBitmap(localBitmap2, this.IMAGE_DEGREE + this.mPlusDegree);
        label434:
        localBitmap1.recycle();
        this.POSITION_HORIZONTAL = (this.DISPLAY_WIDTH / 2.0F - this.DISPLAY_BITMAP.getWidth() / 2);
        this.POSITION_VERTICAL = (this.DISPLAY_HEIGHT / 2.0F - this.DISPLAY_BITMAP.getHeight() / 2);
        this.PTS[10].y = this.POSITION_VERTICAL;
        this.PTS[10].x = this.POSITION_HORIZONTAL;
        this.PTS[11].y = (this.POSITION_VERTICAL + this.DISPLAY_BITMAP.getHeight());
        this.PTS[11].x = (this.POSITION_HORIZONTAL + this.DISPLAY_BITMAP.getWidth());
        if (this.MODE == 200) {
          initModeScale();
        }
        for (;;)
        {
          invalidate();
          return;
          if (this.DISPLAY_HEIGHT >= this.ORIGINAL_BITMAP_HEIGHT) {
            break;
          }
          this.RESIZE_RATIO = (this.DISPLAY_HEIGHT / this.ORIGINAL_BITMAP_HEIGHT);
          break;
          d += 1.0D;
          break label237;
          label611:
          k = j;
          break label373;
          label618:
          m = i;
          break label404;
          if (this.MODE == 100) {
            initModeFree();
          } else if (this.MODE == 300) {
            initModeScale(this.MIN_WIDTH, this.MIN_HEIGHT);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label434;
      }
    }
  }
  
  public boolean between(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 > paramFloat2) && (paramFloat1 < paramFloat3);
  }
  
  public boolean between(int paramInt, float paramFloat1, float paramFloat2)
  {
    return (paramInt > paramFloat1) && (paramInt < paramFloat2);
  }
  
  public boolean between(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 > paramInt2) && (paramInt1 < paramInt3);
  }
  
  public byte[] bitmapToByteArray(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return arrayOfByte;
  }
  
  public void getCropUri(final ImagePathCallBack paramImagePathCallBack)
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   4: invokestatic 35	com/appg/crop/CropImage:access$0	(Lcom/appg/crop/CropImage;)[Landroid/graphics/PointF;
        //   7: bipush 8
        //   9: aaload
        //   10: getfield 41	android/graphics/PointF:x	F
        //   13: aload_0
        //   14: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   17: invokestatic 35	com/appg/crop/CropImage:access$0	(Lcom/appg/crop/CropImage;)[Landroid/graphics/PointF;
        //   20: bipush 10
        //   22: aaload
        //   23: getfield 41	android/graphics/PointF:x	F
        //   26: fsub
        //   27: aload_0
        //   28: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   31: invokestatic 45	com/appg/crop/CropImage:access$1	(Lcom/appg/crop/CropImage;)F
        //   34: fdiv
        //   35: fstore_1
        //   36: aload_0
        //   37: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   40: invokestatic 35	com/appg/crop/CropImage:access$0	(Lcom/appg/crop/CropImage;)[Landroid/graphics/PointF;
        //   43: bipush 9
        //   45: aaload
        //   46: getfield 41	android/graphics/PointF:x	F
        //   49: aload_0
        //   50: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   53: invokestatic 35	com/appg/crop/CropImage:access$0	(Lcom/appg/crop/CropImage;)[Landroid/graphics/PointF;
        //   56: bipush 10
        //   58: aaload
        //   59: getfield 41	android/graphics/PointF:x	F
        //   62: fsub
        //   63: aload_0
        //   64: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   67: invokestatic 45	com/appg/crop/CropImage:access$1	(Lcom/appg/crop/CropImage;)F
        //   70: fdiv
        //   71: fstore_2
        //   72: aload_0
        //   73: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   76: invokestatic 35	com/appg/crop/CropImage:access$0	(Lcom/appg/crop/CropImage;)[Landroid/graphics/PointF;
        //   79: bipush 8
        //   81: aaload
        //   82: getfield 48	android/graphics/PointF:y	F
        //   85: aload_0
        //   86: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   89: invokestatic 35	com/appg/crop/CropImage:access$0	(Lcom/appg/crop/CropImage;)[Landroid/graphics/PointF;
        //   92: bipush 10
        //   94: aaload
        //   95: getfield 48	android/graphics/PointF:y	F
        //   98: fsub
        //   99: aload_0
        //   100: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   103: invokestatic 45	com/appg/crop/CropImage:access$1	(Lcom/appg/crop/CropImage;)F
        //   106: fdiv
        //   107: fstore_3
        //   108: aload_0
        //   109: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   112: invokestatic 35	com/appg/crop/CropImage:access$0	(Lcom/appg/crop/CropImage;)[Landroid/graphics/PointF;
        //   115: bipush 9
        //   117: aaload
        //   118: getfield 48	android/graphics/PointF:y	F
        //   121: aload_0
        //   122: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   125: invokestatic 35	com/appg/crop/CropImage:access$0	(Lcom/appg/crop/CropImage;)[Landroid/graphics/PointF;
        //   128: bipush 10
        //   130: aaload
        //   131: getfield 48	android/graphics/PointF:y	F
        //   134: fsub
        //   135: aload_0
        //   136: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   139: invokestatic 45	com/appg/crop/CropImage:access$1	(Lcom/appg/crop/CropImage;)F
        //   142: fdiv
        //   143: fstore 4
        //   145: fload_2
        //   146: fconst_0
        //   147: fcmpg
        //   148: ifge +5 -> 153
        //   151: fconst_0
        //   152: fstore_2
        //   153: fload_1
        //   154: fconst_0
        //   155: fcmpg
        //   156: ifge +5 -> 161
        //   159: fconst_0
        //   160: fstore_1
        //   161: fload 4
        //   163: fconst_0
        //   164: fcmpg
        //   165: ifge +6 -> 171
        //   168: fconst_0
        //   169: fstore 4
        //   171: fload_3
        //   172: fconst_0
        //   173: fcmpg
        //   174: ifge +5 -> 179
        //   177: fconst_0
        //   178: fstore_3
        //   179: new 50	java/lang/StringBuilder
        //   182: dup
        //   183: ldc 52
        //   185: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   188: fload_1
        //   189: invokevirtual 59	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   192: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   195: invokestatic 68	com/appg/golfmon/util/LogUtil:e	(Ljava/lang/String;)V
        //   198: new 50	java/lang/StringBuilder
        //   201: dup
        //   202: ldc 70
        //   204: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   207: fload_2
        //   208: invokevirtual 59	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   211: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   214: invokestatic 68	com/appg/golfmon/util/LogUtil:e	(Ljava/lang/String;)V
        //   217: new 50	java/lang/StringBuilder
        //   220: dup
        //   221: ldc 72
        //   223: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   226: fload_3
        //   227: invokevirtual 59	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   230: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   233: invokestatic 68	com/appg/golfmon/util/LogUtil:e	(Ljava/lang/String;)V
        //   236: new 50	java/lang/StringBuilder
        //   239: dup
        //   240: ldc 74
        //   242: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   245: fload 4
        //   247: invokevirtual 59	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   250: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   253: invokestatic 68	com/appg/golfmon/util/LogUtil:e	(Ljava/lang/String;)V
        //   256: aload_0
        //   257: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   260: invokestatic 78	com/appg/crop/CropImage:access$2	(Lcom/appg/crop/CropImage;)I
        //   263: istore 5
        //   265: aconst_null
        //   266: astore 6
        //   268: iload 5
        //   270: bipush 16
        //   272: if_icmplt +441 -> 713
        //   275: new 50	java/lang/StringBuilder
        //   278: dup
        //   279: ldc 80
        //   281: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   284: aload 6
        //   286: invokevirtual 86	android/graphics/Bitmap:getWidth	()I
        //   289: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   292: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   295: invokestatic 92	com/appg/golfmon/util/LogUtil:d	(Ljava/lang/String;)V
        //   298: new 50	java/lang/StringBuilder
        //   301: dup
        //   302: ldc 94
        //   304: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   307: aload 6
        //   309: invokevirtual 97	android/graphics/Bitmap:getHeight	()I
        //   312: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   315: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   318: invokestatic 92	com/appg/golfmon/util/LogUtil:d	(Ljava/lang/String;)V
        //   321: fload_2
        //   322: fload_1
        //   323: fsub
        //   324: f2i
        //   325: aload_0
        //   326: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   329: invokestatic 78	com/appg/crop/CropImage:access$2	(Lcom/appg/crop/CropImage;)I
        //   332: idiv
        //   333: istore 11
        //   335: fload 4
        //   337: fload_3
        //   338: fsub
        //   339: f2i
        //   340: aload_0
        //   341: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   344: invokestatic 78	com/appg/crop/CropImage:access$2	(Lcom/appg/crop/CropImage;)I
        //   347: idiv
        //   348: istore 12
        //   350: fload_1
        //   351: f2i
        //   352: aload_0
        //   353: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   356: invokestatic 78	com/appg/crop/CropImage:access$2	(Lcom/appg/crop/CropImage;)I
        //   359: idiv
        //   360: i2f
        //   361: fstore 13
        //   363: fload_3
        //   364: f2i
        //   365: aload_0
        //   366: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   369: invokestatic 78	com/appg/crop/CropImage:access$2	(Lcom/appg/crop/CropImage;)I
        //   372: idiv
        //   373: i2f
        //   374: fstore 14
        //   376: new 50	java/lang/StringBuilder
        //   379: dup
        //   380: ldc 52
        //   382: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   385: fload 13
        //   387: invokevirtual 59	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   390: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   393: invokestatic 92	com/appg/golfmon/util/LogUtil:d	(Ljava/lang/String;)V
        //   396: new 50	java/lang/StringBuilder
        //   399: dup
        //   400: ldc 72
        //   402: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   405: fload 14
        //   407: invokevirtual 59	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   410: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   413: invokestatic 92	com/appg/golfmon/util/LogUtil:d	(Ljava/lang/String;)V
        //   416: new 50	java/lang/StringBuilder
        //   419: dup
        //   420: ldc 99
        //   422: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   425: iload 11
        //   427: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   430: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   433: invokestatic 92	com/appg/golfmon/util/LogUtil:d	(Ljava/lang/String;)V
        //   436: new 50	java/lang/StringBuilder
        //   439: dup
        //   440: ldc 101
        //   442: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   445: iload 12
        //   447: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   450: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   453: invokestatic 92	com/appg/golfmon/util/LogUtil:d	(Ljava/lang/String;)V
        //   456: fconst_1
        //   457: fstore 15
        //   459: iload 11
        //   461: sipush 720
        //   464: if_icmple +33 -> 497
        //   467: ldc 102
        //   469: fconst_1
        //   470: iload 11
        //   472: i2f
        //   473: fmul
        //   474: fdiv
        //   475: fstore 15
        //   477: new 50	java/lang/StringBuilder
        //   480: dup
        //   481: ldc 104
        //   483: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   486: fload 15
        //   488: invokevirtual 59	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   491: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   494: invokestatic 68	com/appg/golfmon/util/LogUtil:e	(Ljava/lang/String;)V
        //   497: fload 15
        //   499: iload 11
        //   501: i2f
        //   502: fmul
        //   503: fstore 16
        //   505: fload 15
        //   507: iload 12
        //   509: i2f
        //   510: fmul
        //   511: fstore 17
        //   513: new 50	java/lang/StringBuilder
        //   516: dup
        //   517: ldc 106
        //   519: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   522: fload 16
        //   524: invokevirtual 59	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   527: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   530: invokestatic 92	com/appg/golfmon/util/LogUtil:d	(Ljava/lang/String;)V
        //   533: new 50	java/lang/StringBuilder
        //   536: dup
        //   537: ldc 108
        //   539: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   542: fload 17
        //   544: invokevirtual 59	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
        //   547: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   550: invokestatic 92	com/appg/golfmon/util/LogUtil:d	(Ljava/lang/String;)V
        //   553: new 110	android/graphics/Matrix
        //   556: dup
        //   557: invokespecial 111	android/graphics/Matrix:<init>	()V
        //   560: astore 18
        //   562: aload 18
        //   564: fload 15
        //   566: fload 15
        //   568: invokevirtual 115	android/graphics/Matrix:postScale	(FF)Z
        //   571: pop
        //   572: aload 6
        //   574: fload 13
        //   576: f2i
        //   577: fload 14
        //   579: f2i
        //   580: iload 11
        //   582: iload 12
        //   584: aload 18
        //   586: iconst_1
        //   587: invokestatic 119	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
        //   590: astore 20
        //   592: aload_0
        //   593: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   596: aload 20
        //   598: invokevirtual 123	com/appg/crop/CropImage:bitmapToByteArray	(Landroid/graphics/Bitmap;)[B
        //   601: astore 21
        //   603: new 125	java/io/File
        //   606: dup
        //   607: aload_0
        //   608: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   611: invokevirtual 129	com/appg/crop/CropImage:getContext	()Landroid/content/Context;
        //   614: invokevirtual 135	android/content/Context:getCacheDir	()Ljava/io/File;
        //   617: new 50	java/lang/StringBuilder
        //   620: dup
        //   621: invokestatic 141	java/lang/System:currentTimeMillis	()J
        //   624: invokestatic 147	java/lang/String:valueOf	(J)Ljava/lang/String;
        //   627: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   630: ldc 149
        //   632: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   635: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   638: invokespecial 155	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   641: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   644: astore 22
        //   646: aconst_null
        //   647: astore 23
        //   649: new 160	java/io/FileOutputStream
        //   652: dup
        //   653: aload 22
        //   655: invokespecial 161	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
        //   658: astore 24
        //   660: aload 24
        //   662: aload 21
        //   664: invokevirtual 165	java/io/FileOutputStream:write	([B)V
        //   667: aload 24
        //   669: ifnull +214 -> 883
        //   672: aload 24
        //   674: invokevirtual 168	java/io/FileOutputStream:close	()V
        //   677: aload 6
        //   679: invokevirtual 171	android/graphics/Bitmap:recycle	()V
        //   682: aload 20
        //   684: invokevirtual 171	android/graphics/Bitmap:recycle	()V
        //   687: aload_0
        //   688: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   691: invokevirtual 175	com/appg/crop/CropImage:getHandler	()Landroid/os/Handler;
        //   694: new 177	com/appg/crop/CropImage$1$1
        //   697: dup
        //   698: aload_0
        //   699: aload_0
        //   700: getfield 21	com/appg/crop/CropImage$1:val$callBack	Lcom/appg/crop/CropImage$ImagePathCallBack;
        //   703: aload 22
        //   705: invokespecial 180	com/appg/crop/CropImage$1$1:<init>	(Lcom/appg/crop/CropImage$1;Lcom/appg/crop/CropImage$ImagePathCallBack;Ljava/lang/String;)V
        //   708: invokevirtual 186	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   711: pop
        //   712: return
        //   713: new 188	android/graphics/BitmapFactory$Options
        //   716: dup
        //   717: invokespecial 189	android/graphics/BitmapFactory$Options:<init>	()V
        //   720: astore 7
        //   722: aload 7
        //   724: aload_0
        //   725: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   728: invokestatic 78	com/appg/crop/CropImage:access$2	(Lcom/appg/crop/CropImage;)I
        //   731: putfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   734: aload_0
        //   735: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   738: invokestatic 197	com/appg/crop/CropImage:access$3	(Lcom/appg/crop/CropImage;)Ljava/lang/String;
        //   741: aload 7
        //   743: invokestatic 203	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   746: aload_0
        //   747: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   750: invokestatic 206	com/appg/crop/CropImage:access$4	(Lcom/appg/crop/CropImage;)I
        //   753: aload_0
        //   754: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   757: invokestatic 209	com/appg/crop/CropImage:access$5	(Lcom/appg/crop/CropImage;)I
        //   760: iadd
        //   761: invokestatic 215	com/appg/golfmon/util/ImageUtil:getRotatedBitmap	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   764: astore 10
        //   766: aload 10
        //   768: astore 6
        //   770: goto -495 -> 275
        //   773: astore 8
        //   775: new 50	java/lang/StringBuilder
        //   778: dup
        //   779: ldc 217
        //   781: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   784: aload_0
        //   785: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   788: invokestatic 78	com/appg/crop/CropImage:access$2	(Lcom/appg/crop/CropImage;)I
        //   791: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   794: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   797: invokestatic 68	com/appg/golfmon/util/LogUtil:e	(Ljava/lang/String;)V
        //   800: aload_0
        //   801: getfield 19	com/appg/crop/CropImage$1:this$0	Lcom/appg/crop/CropImage;
        //   804: astore 9
        //   806: aload 9
        //   808: iconst_2
        //   809: aload 9
        //   811: invokestatic 78	com/appg/crop/CropImage:access$2	(Lcom/appg/crop/CropImage;)I
        //   814: imul
        //   815: invokestatic 221	com/appg/crop/CropImage:access$6	(Lcom/appg/crop/CropImage;I)V
        //   818: goto -562 -> 256
        //   821: astore 25
        //   823: aload 25
        //   825: invokevirtual 224	java/lang/Exception:printStackTrace	()V
        //   828: aload 23
        //   830: ifnull -153 -> 677
        //   833: aload 23
        //   835: invokevirtual 168	java/io/FileOutputStream:close	()V
        //   838: goto -161 -> 677
        //   841: astore 28
        //   843: aload 28
        //   845: invokevirtual 225	java/io/IOException:printStackTrace	()V
        //   848: goto -171 -> 677
        //   851: astore 26
        //   853: aload 23
        //   855: ifnull +8 -> 863
        //   858: aload 23
        //   860: invokevirtual 168	java/io/FileOutputStream:close	()V
        //   863: aload 26
        //   865: athrow
        //   866: astore 27
        //   868: aload 27
        //   870: invokevirtual 225	java/io/IOException:printStackTrace	()V
        //   873: goto -10 -> 863
        //   876: astore 30
        //   878: aload 30
        //   880: invokevirtual 225	java/io/IOException:printStackTrace	()V
        //   883: goto -206 -> 677
        //   886: astore 26
        //   888: aload 24
        //   890: astore 23
        //   892: goto -39 -> 853
        //   895: astore 25
        //   897: aload 24
        //   899: astore 23
        //   901: goto -78 -> 823
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	904	0	this	1
        //   35	316	1	f1	float
        //   71	251	2	f2	float
        //   107	257	3	f3	float
        //   143	193	4	f4	float
        //   263	10	5	i	int
        //   266	503	6	localObject1	Object
        //   720	22	7	localOptions	BitmapFactory.Options
        //   773	1	8	localOutOfMemoryError	OutOfMemoryError
        //   804	6	9	localCropImage	CropImage
        //   764	3	10	localBitmap1	Bitmap
        //   333	248	11	j	int
        //   348	235	12	k	int
        //   361	214	13	f5	float
        //   374	204	14	f6	float
        //   457	110	15	f7	float
        //   503	20	16	f8	float
        //   511	32	17	f9	float
        //   560	25	18	localMatrix	android.graphics.Matrix
        //   590	93	20	localBitmap2	Bitmap
        //   601	62	21	arrayOfByte	byte[]
        //   644	60	22	str	String
        //   647	253	23	localObject2	Object
        //   658	240	24	localFileOutputStream	java.io.FileOutputStream
        //   821	3	25	localException1	Exception
        //   895	1	25	localException2	Exception
        //   851	13	26	localObject3	Object
        //   886	1	26	localObject4	Object
        //   866	3	27	localIOException1	IOException
        //   841	3	28	localIOException2	IOException
        //   876	3	30	localIOException3	IOException
        // Exception table:
        //   from	to	target	type
        //   713	766	773	java/lang/OutOfMemoryError
        //   649	660	821	java/lang/Exception
        //   833	838	841	java/io/IOException
        //   649	660	851	finally
        //   823	828	851	finally
        //   858	863	866	java/io/IOException
        //   672	677	876	java/io/IOException
        //   660	667	886	finally
        //   660	667	895	java/lang/Exception
      }
    }).start();
  }
  
  public void initModeFree()
  {
    this.MODE = 100;
    this.mListener = new MotionEventFree(this.PTS, this.MIN_WIDTH, this.MIN_HEIGHT);
    this.PTS[8].set(this.PTS[10].x, this.PTS[10].y);
    this.PTS[9].set(this.PTS[11].x, this.PTS[11].y);
    this.mListener.setMinSize(this.MIN_WIDTH, this.MIN_HEIGHT);
    this.mListener.computeSetPoint();
    invalidate();
  }
  
  public void initModeScale()
  {
    this.MODE = 200;
    this.mListener = new MotionEventScale(this.PTS, this.MIN_WIDTH, this.MIN_HEIGHT);
    float f1 = this.PTS[11].x - this.PTS[10].x;
    float f2 = this.PTS[11].y - this.PTS[10].y;
    if (f1 < f2) {}
    for (float f3 = f1;; f3 = f2)
    {
      this.PTS[8].set(this.DISPLAY_WIDTH / 2.0F - f3 / 2.0F, this.DISPLAY_HEIGHT / 2.0F - f3 / 2.0F);
      this.PTS[9].set(this.DISPLAY_WIDTH / 2.0F + f3 / 2.0F, this.DISPLAY_HEIGHT / 2.0F + f3 / 2.0F);
      this.mListener.setMinSize(this.MIN_WIDTH, this.MIN_HEIGHT);
      this.mListener.computeSetPoint();
      invalidate();
      return;
    }
  }
  
  public void initModeScale(int paramInt1, int paramInt2)
  {
    this.MODE = 300;
    this.MIN_WIDTH = paramInt1;
    this.MIN_HEIGHT = paramInt2;
    this.mListener = new MotionEventScale(this.PTS, this.MIN_WIDTH, this.MIN_HEIGHT);
    float f1 = this.PTS[11].x - this.PTS[10].x;
    float f2 = this.PTS[11].y - this.PTS[10].y;
    float f3 = paramInt2 / paramInt1;
    if (f2 / f1 > f3)
    {
      float f5 = f1 * f3;
      this.PTS[8].set((this.DISPLAY_WIDTH - f1) / 2.0F, (f5 + (this.DISPLAY_HEIGHT - f1)) / 2.0F);
      this.PTS[9].set((f1 + this.DISPLAY_WIDTH) / 2.0F, (f1 + this.DISPLAY_HEIGHT - f5) / 2.0F);
    }
    for (;;)
    {
      this.mListener.setMinSize(this.MIN_WIDTH, this.MIN_HEIGHT);
      this.mListener.computeSetPoint();
      invalidate();
      return;
      float f4 = f2 * f3;
      this.PTS[8].set((this.DISPLAY_WIDTH - f2 - f4) / 2.0F, (this.DISPLAY_HEIGHT - f2) / 2.0F);
      this.PTS[9].set((f4 + (f2 + this.DISPLAY_WIDTH)) / 2.0F, (f2 + this.DISPLAY_HEIGHT) / 2.0F);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.DISPLAY_BITMAP, this.POSITION_HORIZONTAL, this.POSITION_VERTICAL, null);
    if (this.mListener == null) {}
    for (;;)
    {
      return;
      int i = this.mListener.getPressIdx();
      switch (i)
      {
      default: 
        paramCanvas.drawCircle(this.PTS[i].x, this.PTS[i].y, 40.0F, this.POINT_PAINT_OVER);
      }
      for (;;)
      {
        paramCanvas.drawRect(this.PTS[8].x, this.PTS[8].y, this.PTS[9].x, this.PTS[9].y, this.RECT_PAINT);
        if (this.MODE != 100) {
          break label248;
        }
        for (int k = 0; k < 8; k++) {
          paramCanvas.drawCircle(this.PTS[k].x, this.PTS[k].y, 10.0F, this.POINT_PAINT);
        }
        paramCanvas.drawRect(this.PTS[8].x, this.PTS[8].y, this.PTS[9].x, this.PTS[9].y, this.RECT_PAINT_OVER);
      }
      label248:
      if ((this.MODE == 200) || (this.MODE == 300)) {
        for (int j = 0; j < 4; j++) {
          paramCanvas.drawCircle(this.PTS[(j * 2)].x, this.PTS[(j * 2)].y, 10.0F, this.POINT_PAINT);
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    LogUtil.e("finish inflate");
    super.onFinishInflate();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LogUtil.e("on layout");
    LogUtil.e("changed : " + paramBoolean);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    onLayout2();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mListener == null) {
      return false;
    }
    boolean bool = this.mListener.onTouch(this, paramMotionEvent);
    invalidate();
    return bool;
  }
  
  @SuppressLint({"WrongCall"})
  public void rotate()
  {
    this.mPlusDegree = (90 + this.mPlusDegree);
    if (this.mPlusDegree == 360) {
      this.mPlusDegree = 0;
    }
    setSizeOfImage(this.ORIGINAL_BITMAP_PATH);
    onLayout2();
  }
  
  public void setImage(String paramString)
  {
    this.ORIGINAL_BITMAP_PATH = paramString;
    this.IMAGE_DEGREE = ImageUtil.getPhotoOrientationDegree(this.ORIGINAL_BITMAP_PATH);
    setSizeOfImage(this.ORIGINAL_BITMAP_PATH);
  }
  
  public void setSizeOfImage(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((this.IMAGE_DEGREE + this.mPlusDegree == 0) || (this.IMAGE_DEGREE + this.mPlusDegree == 180))
      {
        this.ORIGINAL_BITMAP_WIDTH = localOptions.outWidth;
        this.ORIGINAL_BITMAP_HEIGHT = localOptions.outHeight;
        return;
      }
      this.ORIGINAL_BITMAP_WIDTH = localOptions.outHeight;
      this.ORIGINAL_BITMAP_HEIGHT = localOptions.outWidth;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static abstract interface ImagePathCallBack
  {
    public abstract void onResult(String paramString);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.crop.CropImage
 * JD-Core Version:    0.7.0.1
 */