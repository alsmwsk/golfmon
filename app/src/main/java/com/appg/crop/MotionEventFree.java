package com.appg.crop;

import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.appg.golfmon.util.LogUtil;

public class MotionEventFree
  implements IDataSet
{
  private float EX = 0.0F;
  private float EY = 0.0F;
  private int MIN_HEIGHT = 320;
  private int MIN_WIDTH = 320;
  private float MX = 0.0F;
  private float MY = 0.0F;
  private PointF[] PTS = new PointF[10];
  private float SX = 0.0F;
  private float SY = 0.0F;
  private int mPress = -1;
  
  public MotionEventFree(PointF[] paramArrayOfPointF, int paramInt1, int paramInt2)
  {
    this.PTS = paramArrayOfPointF;
    setMinSize(paramInt1, paramInt2);
  }
  
  private int getPresssPoint(float paramFloat1, float paramFloat2)
  {
    for (int i = 0;; i++)
    {
      if (i >= 8) {
        return 100;
      }
      int j = i;
      if ((Math.abs(paramFloat1 - this.PTS[j].x) < 40.0F) && (Math.abs(paramFloat2 - this.PTS[j].y) < 40.0F)) {
        return j;
      }
    }
  }
  
  private void moveAll(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1 + this.PTS[8].x;
    float f2 = paramFloat2 + this.PTS[8].y;
    float f3 = paramFloat1 + this.PTS[9].x;
    float f4 = paramFloat2 + this.PTS[9].y;
    if ((f3 > this.PTS[11].x) || (f1 < this.PTS[10].x))
    {
      f1 = this.PTS[8].x;
      f3 = this.PTS[9].x;
    }
    if ((f4 > this.PTS[11].y) || (f2 < this.PTS[10].y))
    {
      f2 = this.PTS[8].y;
      f4 = this.PTS[9].y;
    }
    this.PTS[8].set(f1, f2);
    this.PTS[9].set(f3, f4);
  }
  
  private void moveBottom(float paramFloat)
  {
    Log.e("", "PTS[9].y=" + this.PTS[9].y);
    float f = paramFloat + this.PTS[9].y;
    if ((f > this.PTS[11].y) || (f - this.MIN_HEIGHT < this.PTS[8].y)) {
      f = this.PTS[9].y;
    }
    this.PTS[9].set(this.PTS[9].x, f);
  }
  
  private void moveLeft(float paramFloat)
  {
    float f = paramFloat + this.PTS[8].x;
    if ((f < this.PTS[10].x) || (f + this.MIN_WIDTH > this.PTS[9].x)) {
      f = this.PTS[8].x;
    }
    this.PTS[8].set(f, this.PTS[8].y);
  }
  
  private void moveRight(float paramFloat)
  {
    float f = paramFloat + this.PTS[9].x;
    if ((f > this.PTS[11].x) || (f - this.MIN_WIDTH < this.PTS[8].x)) {
      f = this.PTS[9].x;
    }
    this.PTS[9].set(f, this.PTS[9].y);
  }
  
  private void moveTop(float paramFloat)
  {
    float f = paramFloat + this.PTS[8].y;
    if ((f < this.PTS[10].y) || (f + this.MIN_HEIGHT > this.PTS[9].y)) {
      f = this.PTS[8].y;
    }
    this.PTS[8].set(this.PTS[8].x, f);
  }
  
  public void computeSetPoint()
  {
    this.PTS[1].set(this.PTS[8].x + (this.PTS[9].x - this.PTS[8].x) / 2.0F, this.PTS[8].y);
    this.PTS[3].set(this.PTS[9].x, this.PTS[8].y + (this.PTS[9].y - this.PTS[8].y) / 2.0F);
    this.PTS[5].set(this.PTS[8].x + (this.PTS[9].x - this.PTS[8].x) / 2.0F, this.PTS[9].y);
    this.PTS[7].set(this.PTS[8].x, this.PTS[8].y + (this.PTS[9].y - this.PTS[8].y) / 2.0F);
    this.PTS[0].set(this.PTS[8].x, this.PTS[8].y);
    this.PTS[2].set(this.PTS[9].x, this.PTS[8].y);
    this.PTS[4].set(this.PTS[9].x, this.PTS[9].y);
    this.PTS[6].set(this.PTS[8].x, this.PTS[9].y);
  }
  
  public int getPressIdx()
  {
    return this.mPress;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      LogUtil.e("", "=======================");
      LogUtil.e("", "= START_POS : " + this.PTS[8].x + "," + this.PTS[8].y);
      LogUtil.e("", "= END_POS   : " + this.PTS[9].x + "," + this.PTS[9].y);
      LogUtil.e("", "=======================");
      this.mPress = -1;
    }
    for (;;)
    {
      computeSetPoint();
      return true;
      this.SX = paramMotionEvent.getX();
      this.SY = paramMotionEvent.getY();
      this.mPress = getPresssPoint(this.SX, this.SY);
      LogUtil.d("", "mPress " + this.mPress);
      LogUtil.d("", "MIN_WIDTH " + this.MIN_WIDTH);
      LogUtil.d("", "MIN_HEIGHT " + this.MIN_HEIGHT);
      continue;
      this.EX = paramMotionEvent.getX();
      this.EY = paramMotionEvent.getY();
      this.MX = (this.EX - this.SX);
      this.MY = (this.EY - this.SY);
      this.SX = this.EX;
      this.SY = this.EY;
      switch (this.mPress)
      {
      default: 
        break;
      case 0: 
        moveTop(this.MY);
        moveLeft(this.MX);
        break;
      case 100: 
        moveAll(this.MX, this.MY);
        break;
      case 1: 
        moveTop(this.MY);
        break;
      case 2: 
        moveRight(this.MX);
        moveTop(this.MY);
        break;
      case 3: 
        moveRight(this.MX);
        break;
      case 4: 
        moveRight(this.MX);
        moveBottom(this.MY);
        break;
      case 5: 
        moveBottom(this.MY);
        break;
      case 6: 
        moveLeft(this.MX);
        moveBottom(this.MY);
        break;
      case 7: 
        moveLeft(this.MX);
      }
    }
  }
  
  public void setImgSize(int paramInt1, int paramInt2) {}
  
  public void setMaxSize(int paramInt1, int paramInt2) {}
  
  public void setMinSize(int paramInt1, int paramInt2)
  {
    this.MIN_WIDTH = paramInt1;
    this.MIN_HEIGHT = paramInt2;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.crop.MotionEventFree
 * JD-Core Version:    0.7.0.1
 */