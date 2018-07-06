package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

public class ImageNonViewAware
  implements ImageAware
{
  protected final ImageSize imageSize;
  protected final String imageUri;
  protected final ViewScaleType scaleType;
  
  public ImageNonViewAware(ImageSize paramImageSize, ViewScaleType paramViewScaleType)
  {
    this(null, paramImageSize, paramViewScaleType);
  }
  
  public ImageNonViewAware(String paramString, ImageSize paramImageSize, ViewScaleType paramViewScaleType)
  {
    this.imageUri = paramString;
    this.imageSize = paramImageSize;
    this.scaleType = paramViewScaleType;
  }
  
  public int getHeight()
  {
    return this.imageSize.getHeight();
  }
  
  public int getId()
  {
    if (TextUtils.isEmpty(this.imageUri)) {
      return super.hashCode();
    }
    return this.imageUri.hashCode();
  }
  
  public ViewScaleType getScaleType()
  {
    return this.scaleType;
  }
  
  public int getWidth()
  {
    return this.imageSize.getWidth();
  }
  
  public View getWrappedView()
  {
    return null;
  }
  
  public boolean isCollected()
  {
    return false;
  }
  
  public boolean setImageBitmap(Bitmap paramBitmap)
  {
    return true;
  }
  
  public boolean setImageDrawable(Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.imageaware.ImageNonViewAware
 * JD-Core Version:    0.7.0.1
 */