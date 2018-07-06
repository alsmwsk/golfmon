package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class ImageViewAware
  implements ImageAware
{
  protected boolean checkActualViewSize;
  protected Reference<ImageView> imageViewRef;
  
  public ImageViewAware(ImageView paramImageView)
  {
    this(paramImageView, true);
  }
  
  public ImageViewAware(ImageView paramImageView, boolean paramBoolean)
  {
    this.imageViewRef = new WeakReference(paramImageView);
    this.checkActualViewSize = paramBoolean;
  }
  
  private static int getImageViewFieldValue(Object paramObject, String paramString)
  {
    try
    {
      Field localField = ImageView.class.getDeclaredField(paramString);
      localField.setAccessible(true);
      int i = ((Integer)localField.get(paramObject)).intValue();
      int j = 0;
      if (i > 0)
      {
        j = 0;
        if (i < 2147483647) {
          j = i;
        }
      }
      return j;
    }
    catch (Exception localException)
    {
      L.e(localException);
    }
    return 0;
  }
  
  public int getHeight()
  {
    ImageView localImageView = (ImageView)this.imageViewRef.get();
    if (localImageView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
      boolean bool = this.checkActualViewSize;
      int i = 0;
      if (bool)
      {
        i = 0;
        if (localLayoutParams != null)
        {
          int j = localLayoutParams.height;
          i = 0;
          if (j != -2) {
            i = localImageView.getHeight();
          }
        }
      }
      if ((i <= 0) && (localLayoutParams != null)) {
        i = localLayoutParams.height;
      }
      if (i <= 0) {
        i = getImageViewFieldValue(localImageView, "mMaxHeight");
      }
      return i;
    }
    return 0;
  }
  
  public int getId()
  {
    ImageView localImageView = (ImageView)this.imageViewRef.get();
    if (localImageView == null) {
      return super.hashCode();
    }
    return localImageView.hashCode();
  }
  
  public ViewScaleType getScaleType()
  {
    ImageView localImageView = (ImageView)this.imageViewRef.get();
    if (localImageView != null) {
      return ViewScaleType.fromImageView(localImageView);
    }
    return null;
  }
  
  public int getWidth()
  {
    ImageView localImageView = (ImageView)this.imageViewRef.get();
    if (localImageView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
      boolean bool = this.checkActualViewSize;
      int i = 0;
      if (bool)
      {
        i = 0;
        if (localLayoutParams != null)
        {
          int j = localLayoutParams.width;
          i = 0;
          if (j != -2) {
            i = localImageView.getWidth();
          }
        }
      }
      if ((i <= 0) && (localLayoutParams != null)) {
        i = localLayoutParams.width;
      }
      if (i <= 0) {
        i = getImageViewFieldValue(localImageView, "mMaxWidth");
      }
      return i;
    }
    return 0;
  }
  
  public ImageView getWrappedView()
  {
    return (ImageView)this.imageViewRef.get();
  }
  
  public boolean isCollected()
  {
    return this.imageViewRef.get() == null;
  }
  
  public boolean setImageBitmap(Bitmap paramBitmap)
  {
    ImageView localImageView = (ImageView)this.imageViewRef.get();
    if (localImageView != null)
    {
      localImageView.setImageBitmap(paramBitmap);
      return true;
    }
    return false;
  }
  
  public boolean setImageDrawable(Drawable paramDrawable)
  {
    ImageView localImageView = (ImageView)this.imageViewRef.get();
    if (localImageView != null)
    {
      localImageView.setImageDrawable(paramDrawable);
      return true;
    }
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.imageaware.ImageViewAware
 * JD-Core Version:    0.7.0.1
 */