package com.nostra13.universalimageloader.utils;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public final class ImageSizeUtils
{
  private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
  private static ImageSize maxBitmapSize;
  
  static
  {
    int[] arrayOfInt = new int[1];
    GLES10.glGetIntegerv(3379, arrayOfInt, 0);
    int i = Math.max(arrayOfInt[0], 2048);
    maxBitmapSize = new ImageSize(i, i);
  }
  
  public static int computeImageSampleSize(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int i = paramImageSize1.getWidth();
    int j = paramImageSize1.getHeight();
    int k = paramImageSize2.getWidth();
    int m = paramImageSize2.getHeight();
    int n = 1;
    int i1 = i / k;
    int i2 = j / m;
    switch (1.$SwitchMap$com$nostra13$universalimageloader$core$assist$ViewScaleType[paramViewScaleType.ordinal()])
    {
    }
    for (;;)
    {
      if (n < 1) {
        n = 1;
      }
      return n;
      if (paramBoolean) {
        while ((i / 2 >= k) || (j / 2 >= m))
        {
          i /= 2;
          j /= 2;
          n *= 2;
        }
      }
      n = Math.max(i1, i2);
      continue;
      if (paramBoolean) {
        while ((i / 2 >= k) && (j / 2 >= m))
        {
          i /= 2;
          j /= 2;
          n *= 2;
        }
      } else {
        n = Math.min(i1, i2);
      }
    }
  }
  
  public static float computeImageScale(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int i = paramImageSize1.getWidth();
    int j = paramImageSize1.getHeight();
    int k = paramImageSize2.getWidth();
    int m = paramImageSize2.getHeight();
    float f1 = i / k;
    float f2 = j / m;
    int n;
    if (((paramViewScaleType == ViewScaleType.FIT_INSIDE) && (f1 >= f2)) || ((paramViewScaleType == ViewScaleType.CROP) && (f1 < f2))) {
      n = k;
    }
    for (int i1 = (int)(j / f1);; i1 = m)
    {
      float f3 = 1.0F;
      if (((!paramBoolean) && (n < i) && (i1 < j)) || ((paramBoolean) && (n != i) && (i1 != j))) {
        f3 = n / i;
      }
      return f3;
      n = (int)(i / f2);
    }
  }
  
  public static int computeMinImageSampleSize(ImageSize paramImageSize)
  {
    int i = paramImageSize.getWidth();
    int j = paramImageSize.getHeight();
    int k = maxBitmapSize.getWidth();
    int m = maxBitmapSize.getHeight();
    return Math.max((int)Math.ceil(i / k), (int)Math.ceil(j / m));
  }
  
  public static ImageSize defineTargetSizeForView(ImageAware paramImageAware, ImageSize paramImageSize)
  {
    int i = paramImageAware.getWidth();
    if (i <= 0) {
      i = paramImageSize.getWidth();
    }
    int j = paramImageAware.getHeight();
    if (j <= 0) {
      j = paramImageSize.getHeight();
    }
    return new ImageSize(i, j);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.ImageSizeUtils
 * JD-Core Version:    0.7.0.1
 */