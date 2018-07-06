package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

public enum ViewScaleType
{
  static
  {
    CROP = new ViewScaleType("CROP", 1);
    ViewScaleType[] arrayOfViewScaleType = new ViewScaleType[2];
    arrayOfViewScaleType[0] = FIT_INSIDE;
    arrayOfViewScaleType[1] = CROP;
    $VALUES = arrayOfViewScaleType;
  }
  
  private ViewScaleType() {}
  
  public static ViewScaleType fromImageView(ImageView paramImageView)
  {
    switch (1.$SwitchMap$android$widget$ImageView$ScaleType[paramImageView.getScaleType().ordinal()])
    {
    default: 
      return CROP;
    }
    return FIT_INSIDE;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ViewScaleType
 * JD-Core Version:    0.7.0.1
 */