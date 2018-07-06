package com.appg.golfmon.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.io.IOException;

public class ImageUtil
{
  public static void SaveBitmapToFileCache(Bitmap paramBitmap, String paramString)
  {
    SaveBitmapToFileCache(paramBitmap, paramString, Bitmap.CompressFormat.PNG);
  }
  
  /* Error */
  public static void SaveBitmapToFileCache(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 25	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 27
    //   9: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_1
    //   13: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 43	com/appg/golfmon/util/LogUtil:e	(Ljava/lang/String;)V
    //   22: new 45	java/io/File
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 4
    //   32: aconst_null
    //   33: astore 5
    //   35: aload 4
    //   37: invokevirtual 50	java/io/File:createNewFile	()Z
    //   40: pop
    //   41: new 52	java/io/FileOutputStream
    //   44: dup
    //   45: aload 4
    //   47: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore 12
    //   52: aload_0
    //   53: aload_2
    //   54: bipush 100
    //   56: aload 12
    //   58: invokevirtual 61	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   61: pop
    //   62: aload 12
    //   64: ifnull +91 -> 155
    //   67: aload 12
    //   69: invokevirtual 64	java/io/FileOutputStream:close	()V
    //   72: ldc 2
    //   74: monitorexit
    //   75: return
    //   76: astore 8
    //   78: aload 4
    //   80: ifnull +9 -> 89
    //   83: aload 4
    //   85: invokevirtual 67	java/io/File:delete	()Z
    //   88: pop
    //   89: aload 8
    //   91: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   94: aload 5
    //   96: ifnull -24 -> 72
    //   99: aload 5
    //   101: invokevirtual 64	java/io/FileOutputStream:close	()V
    //   104: goto -32 -> 72
    //   107: astore 9
    //   109: aload 9
    //   111: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   114: goto -42 -> 72
    //   117: astore_3
    //   118: ldc 2
    //   120: monitorexit
    //   121: aload_3
    //   122: athrow
    //   123: astore 6
    //   125: aload 5
    //   127: ifnull +8 -> 135
    //   130: aload 5
    //   132: invokevirtual 64	java/io/FileOutputStream:close	()V
    //   135: aload 6
    //   137: athrow
    //   138: astore 7
    //   140: aload 7
    //   142: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   145: goto -10 -> 135
    //   148: astore 14
    //   150: aload 14
    //   152: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   155: goto -83 -> 72
    //   158: astore 6
    //   160: aload 12
    //   162: astore 5
    //   164: goto -39 -> 125
    //   167: astore 8
    //   169: aload 12
    //   171: astore 5
    //   173: goto -95 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramBitmap	Bitmap
    //   0	176	1	paramString	String
    //   0	176	2	paramCompressFormat	Bitmap.CompressFormat
    //   117	5	3	localObject1	Object
    //   30	54	4	localFile	File
    //   33	139	5	localObject2	Object
    //   123	13	6	localObject3	Object
    //   158	1	6	localObject4	Object
    //   138	3	7	localIOException1	IOException
    //   76	14	8	localException1	Exception
    //   167	1	8	localException2	Exception
    //   107	3	9	localIOException2	IOException
    //   50	120	12	localFileOutputStream	java.io.FileOutputStream
    //   148	3	14	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   35	52	76	java/lang/Exception
    //   99	104	107	java/io/IOException
    //   3	32	117	finally
    //   67	72	117	finally
    //   99	104	117	finally
    //   109	114	117	finally
    //   130	135	117	finally
    //   135	138	117	finally
    //   140	145	117	finally
    //   150	155	117	finally
    //   35	52	123	finally
    //   83	89	123	finally
    //   89	94	123	finally
    //   130	135	138	java/io/IOException
    //   67	72	148	java/io/IOException
    //   52	62	158	finally
    //   52	62	167	java/lang/Exception
  }
  
  public static boolean checkImage(String paramString)
  {
    return getImageSize(paramString) != null;
  }
  
  public static Matrix computeMatrixCenterCrop(Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix localMatrix = new Matrix();
    float f1 = Math.max(paramFloat1 / paramFloat3, paramFloat2 / paramFloat4);
    float f2 = paramFloat3 * f1;
    float f3 = paramFloat4 * f1;
    localMatrix.postScale(f1, f1);
    localMatrix.postTranslate(paramFloat1 / 2.0F - f2 / 2.0F, paramFloat2 / 2.0F - f3 / 2.0F);
    return localMatrix;
  }
  
  public static Matrix computeMatrixFitX(Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    LogUtil.d("////computeMatrixFitX");
    LogUtil.d("////viewWidth  : " + paramFloat1);
    LogUtil.d("////imgWidth   : " + paramFloat3);
    LogUtil.d("////imgHeight  : " + paramFloat4);
    if (paramMatrix == null) {
      paramMatrix = new Matrix();
    }
    paramMatrix.reset();
    float f = paramFloat1 / paramFloat3;
    paramMatrix.setScale(f, f);
    return paramMatrix;
  }
  
  public static float dipToPixel(Context paramContext, float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int[] getDisplaySize(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = localDisplayMetrics.widthPixels;
    arrayOfInt[1] = localDisplayMetrics.heightPixels;
    return arrayOfInt;
  }
  
  public static int[] getImageSize(String paramString)
  {
    int[] arrayOfInt = null;
    if (paramString != null)
    {
      try
      {
        if (paramString.equals("")) {
          return null;
        }
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        int i = localOptions.outWidth;
        arrayOfInt = null;
        if ((i <= 0) || (localOptions.outHeight <= 0)) {
          break label84;
        }
        arrayOfInt = new int[2];
        arrayOfInt[0] = localOptions.outWidth;
        arrayOfInt[1] = localOptions.outHeight;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return arrayOfInt;
    }
    label84:
    return null;
  }
  
  public static int getPhotoOrientationDegree(String paramString)
  {
    int j;
    if (paramString == null)
    {
      j = 0;
      return j;
    }
    try
    {
      ExifInterface localExifInterface1 = new ExifInterface(paramString);
      localExifInterface2 = localExifInterface1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int k;
        LogUtil.e("Error: " + localIOException.getMessage());
        ExifInterface localExifInterface2 = null;
      }
    }
    finally {}
    int i = 0;
    if (localExifInterface2 != null)
    {
      k = localExifInterface2.getAttributeInt("Orientation", -1);
      i = 0;
      if (k != -1)
      {
        i = 0;
        switch (k)
        {
        }
      }
    }
    for (;;)
    {
      LogUtil.e("Photo Degree: " + i);
      j = i;
      break;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  public static String getRealImagePath(Activity paramActivity, Uri paramUri)
  {
    Cursor localCursor = paramActivity.managedQuery(paramUri, new String[] { "_data" }, null, null, null);
    int i = localCursor.getColumnIndexOrThrow("_data");
    localCursor.moveToFirst();
    return localCursor.getString(i);
  }
  
  public static Bitmap getRotatedBitmap(Bitmap paramBitmap, int paramInt)
    throws OutOfMemoryError
  {
    if ((paramInt != 0) && (paramBitmap != null)) {}
    try
    {
      Matrix localMatrix = new Matrix();
      localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        paramBitmap = localBitmap;
      }
      return paramBitmap;
    }
    finally {}
  }
  
  public static String getRotatedImage(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 != null) {}
    BitmapFactory.Options localOptions1;
    Object localObject2;
    int j;
    int k;
    for (;;)
    {
      try
      {
        if (paramString1.trim().length() != 0)
        {
          boolean bool1 = paramString1.trim().equals("");
          if (!bool1) {}
        }
        else
        {
          paramString2 = null;
          return paramString2;
        }
        localBitmap1 = null;
        if (paramString1 != null) {}
        try
        {
          boolean bool2 = paramString1.equals("");
          if (!bool2) {
            continue;
          }
          i = 0;
        }
        catch (Exception localException2)
        {
          BitmapFactory.Options localOptions2;
          int i4;
          localException2.printStackTrace();
          int i = 0;
          if (localBitmap1 == null) {
            continue;
          }
          localBitmap1.recycle();
          i = 0;
          continue;
        }
        finally
        {
          if (localBitmap1 == null) {
            continue;
          }
          localBitmap1.recycle();
        }
        localOptions1 = new BitmapFactory.Options();
        localObject2 = null;
        j = 0;
        if (i == 0) {
          break;
        }
        j = 1;
      }
      finally {}
      if (localObject2 != null) {
        localObject2.recycle();
      }
      if (k == 0) {
        break label604;
      }
      paramString2 = null;
      continue;
      localOptions2 = new BitmapFactory.Options();
      localOptions2.inJustDecodeBounds = true;
      Bitmap localBitmap1 = BitmapFactory.decodeFile(paramString1, localOptions2);
      if (localOptions2.outWidth <= 720)
      {
        i4 = localOptions2.outHeight;
        if (i4 > 1280) {}
      }
      for (i = 0;; i = 1) {
        break;
      }
      try
      {
        label227:
        Bitmap localBitmap4 = BitmapFactory.decodeFile(paramString1, localOptions1);
        localObject2 = localBitmap4;
        int i3 = j * 2;
        localOptions1.inSampleSize = i3;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        LogUtil.e("Error(first): " + localOutOfMemoryError2.getMessage());
        j++;
        if (localObject2 != null) {
          localObject2.recycle();
        }
        int i2 = j * 2;
        localOptions1.inSampleSize = i2;
        localObject2 = null;
      }
      catch (Exception localException1)
      {
        LogUtil.e("Error(first e): " + localException1.getMessage());
        k = 1;
        int i1 = j * 2;
        localOptions1.inSampleSize = i1;
      }
      finally
      {
        localOptions1.inSampleSize = (j * 2);
      }
    }
    for (;;)
    {
      label372:
      Object localObject3;
      SaveBitmapToFileCache((Bitmap)localObject3, paramString2);
      Bitmap localBitmap2;
      if (localBitmap2 != null) {
        localBitmap2.recycle();
      }
      if (localObject3 != null) {
        ((Bitmap)localObject3).recycle();
      }
      break;
      label604:
      label614:
      do
      {
        try
        {
          localBitmap2 = BitmapFactory.decodeFile(paramString1, localOptions1);
          Matrix localMatrix = new Matrix();
          localMatrix.postRotate(paramInt, localBitmap2.getWidth() / 2.0F, localBitmap2.getHeight() / 2.0F);
          Bitmap localBitmap3 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), localMatrix, true);
          localObject3 = localBitmap3;
          if (localObject3 != null) {
            break label372;
          }
          int n = j * 2;
          localOptions1.inSampleSize = n;
          break label614;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localOutOfMemoryError1 = localOutOfMemoryError1;
          LogUtil.e("Error: " + localOutOfMemoryError1.getMessage());
          j++;
          if (localObject3 != null) {
            ((Bitmap)localObject3).recycle();
          }
          if (localBitmap2 != null) {
            localBitmap2.recycle();
          }
          localBitmap2 = null;
          localObject3 = null;
          if (0 != 0) {
            break label372;
          }
          int m = j * 2;
          localOptions1.inSampleSize = m;
          localBitmap2 = null;
          localObject3 = null;
          break label614;
        }
        finally {}
        if (localObject3 != null) {
          break label372;
        }
        localOptions1.inSampleSize = (j * 2);
        throw localObject4;
        k = 0;
        if (localObject2 != null) {
          break;
        }
        if (k == 0) {
          break label227;
        }
        break;
        localBitmap2 = null;
        localObject3 = null;
        if ((paramInt == 0) || (localObject3 != null)) {
          break label372;
        }
      } while (j < 5);
    }
  }
  
  public static float spToPixel(Context paramContext, float paramFloat)
  {
    return TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static File toFile(String paramString)
  {
    File localFile = null;
    if (paramString != null)
    {
      boolean bool = "".equals(paramString);
      localFile = null;
      if (!bool) {
        localFile = new File(paramString);
      }
    }
    return localFile;
  }
  
  public static String wrapImgUrl(String paramString1, String paramString2)
  {
    if (FormatUtil.isNullorEmpty(paramString1)) {
      return "";
    }
    return "http://115.68.14.78/" + paramString2 + "/" + paramString1;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.ImageUtil
 * JD-Core Version:    0.7.0.1
 */