package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import android.view.View;

public abstract interface ImageLoadingListener
{
  public abstract void onLoadingCancelled(String paramString, View paramView);
  
  public abstract void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap);
  
  public abstract void onLoadingFailed(String paramString, View paramView, FailReason paramFailReason);
  
  public abstract void onLoadingStarted(String paramString, View paramView);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ImageLoadingListener
 * JD-Core Version:    0.7.0.1
 */