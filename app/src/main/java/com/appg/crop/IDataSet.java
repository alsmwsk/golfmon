package com.appg.crop;

import android.view.View.OnTouchListener;

public abstract interface IDataSet
  extends View.OnTouchListener
{
  public abstract void computeSetPoint();
  
  public abstract int getPressIdx();
  
  public abstract void setImgSize(int paramInt1, int paramInt2);
  
  public abstract void setMaxSize(int paramInt1, int paramInt2);
  
  public abstract void setMinSize(int paramInt1, int paramInt2);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.crop.IDataSet
 * JD-Core Version:    0.7.0.1
 */