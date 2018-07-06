package com.appg.crop;

import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.appg.golfmon.util.LogUtil;

public class MotionEventScale
  implements IDataSet
{
  private float EX = 0.0F;
  private float EY = 0.0F;
  private int MIN_HEIGHT = 100;
  private int MIN_WIDTH = 100;
  private float MX = 0.0F;
  private float MY = 0.0F;
  private PointF[] PTS = new PointF[10];
  private float SX = 0.0F;
  private float SY = 0.0F;
  private int mPress = -1;
  
  public MotionEventScale(PointF[] paramArrayOfPointF, int paramInt1, int paramInt2)
  {
    this.PTS = paramArrayOfPointF;
    setMinSize(paramInt1, paramInt2);
  }
  
  private int getPresssPoint(float paramFloat1, float paramFloat2)
  {
    for (int i = 0;; i++)
    {
      if (i >= 4) {
        return 100;
      }
      int j = i * 2;
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
  
  private void moveScale_BL(float paramFloat1, float paramFloat2)
  {
    float f1 = (float)(Math.sqrt(Math.pow(paramFloat1, 2.0D) + Math.pow(paramFloat2, 2.0D)) / 2.0D);
    float f2;
    float f3;
    float f4;
    if ((paramFloat1 >= 0.0F) && (paramFloat2 <= 0.0F))
    {
      f2 = f1 * -1.0F;
      Log.e("", "X=" + paramFloat1 + "//Y=" + paramFloat2 + "//dis=" + f2);
      if (this.MIN_WIDTH >= this.MIN_HEIGHT) {
        break label197;
      }
      f3 = this.PTS[8].x - f2;
      f4 = this.PTS[9].y + f2 * this.MIN_WIDTH / this.MIN_HEIGHT;
      label138:
      if ((f3 >= this.PTS[10].x) && (f3 + this.MIN_WIDTH <= this.PTS[9].x)) {
        break label242;
      }
    }
    label197:
    label242:
    while ((f4 > this.PTS[11].y) || (f4 - this.MIN_HEIGHT < this.PTS[8].y))
    {
      do
      {
        return;
      } while ((paramFloat1 > 0.0F) || (paramFloat2 < 0.0F));
      f2 = f1 * 1.0F;
      break;
      f3 = this.PTS[8].x - f2 * this.MIN_WIDTH / this.MIN_HEIGHT;
      f4 = f2 + this.PTS[9].y;
      break label138;
    }
    this.PTS[8].set(f3, this.PTS[8].y);
    this.PTS[9].set(this.PTS[9].x, f4);
  }
  
  private void moveScale_BR(float paramFloat1, float paramFloat2)
  {
    float f1 = (float)(Math.sqrt(Math.pow(paramFloat1, 2.0D) + Math.pow(paramFloat2, 2.0D)) / 2.0D);
    float f2;
    float f3;
    float f4;
    if ((paramFloat1 <= 0.0F) && (paramFloat2 <= 0.0F))
    {
      f2 = f1 * -1.0F;
      Log.e("", "X=" + paramFloat1 + "//Y=" + paramFloat2 + "//dis=" + f2);
      if (this.MIN_WIDTH >= this.MIN_HEIGHT) {
        break label197;
      }
      f3 = f2 + this.PTS[9].x;
      f4 = this.PTS[9].y + f2 * this.MIN_WIDTH / this.MIN_HEIGHT;
      label138:
      if ((f3 <= this.PTS[11].x) && (f3 - this.MIN_WIDTH >= this.PTS[8].x)) {
        break label242;
      }
    }
    label197:
    label242:
    while ((f4 > this.PTS[11].y) || (f4 - this.MIN_HEIGHT < this.PTS[8].y))
    {
      do
      {
        return;
      } while ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F));
      f2 = f1 * 1.0F;
      break;
      f3 = this.PTS[9].x + f2 * this.MIN_WIDTH / this.MIN_HEIGHT;
      f4 = f2 + this.PTS[9].y;
      break label138;
    }
    this.PTS[9].set(f3, f4);
  }
  
  private void moveScale_TL(float paramFloat1, float paramFloat2)
  {
    float f1 = (float)(Math.sqrt(Math.pow(paramFloat1, 2.0D) + Math.pow(paramFloat2, 2.0D)) / 2.0D);
    float f2;
    float f3;
    float f4;
    if ((paramFloat1 <= 0.0F) && (paramFloat2 <= 0.0F))
    {
      f2 = f1 * -1.0F;
      Log.e("", "X=" + paramFloat1 + "//Y=" + paramFloat2 + "//dis=" + f2);
      if (this.MIN_WIDTH >= this.MIN_HEIGHT) {
        break label197;
      }
      f3 = f2 + this.PTS[8].x;
      f4 = this.PTS[8].y + f2 * this.MIN_WIDTH / this.MIN_HEIGHT;
      label138:
      if ((f3 >= this.PTS[10].x) && (f3 + this.MIN_WIDTH <= this.PTS[9].x)) {
        break label242;
      }
    }
    label197:
    label242:
    while ((f4 < this.PTS[10].y) || (f4 + this.MIN_HEIGHT > this.PTS[9].y))
    {
      do
      {
        return;
      } while ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F));
      f2 = f1 * 1.0F;
      break;
      f3 = this.PTS[8].x + f2 * this.MIN_WIDTH / this.MIN_HEIGHT;
      f4 = f2 + this.PTS[8].y;
      break label138;
    }
    this.PTS[8].set(f3, f4);
  }
  
  private void moveScale_TR(float paramFloat1, float paramFloat2)
  {
    float f1 = (float)(Math.sqrt(Math.pow(paramFloat1, 2.0D) + Math.pow(paramFloat2, 2.0D)) / 2.0D);
    float f2;
    float f3;
    float f4;
    if ((paramFloat1 >= 0.0F) && (paramFloat2 <= 0.0F))
    {
      f2 = f1 * -1.0F;
      Log.e("", "X=" + paramFloat1 + "//Y=" + paramFloat2 + "//dis=" + f2);
      if (this.MIN_WIDTH >= this.MIN_HEIGHT) {
        break label197;
      }
      f3 = this.PTS[9].x - f2;
      f4 = this.PTS[8].y + f2 * this.MIN_WIDTH / this.MIN_HEIGHT;
      label138:
      if ((f3 <= this.PTS[11].x) && (f3 - this.MIN_WIDTH >= this.PTS[8].x)) {
        break label242;
      }
    }
    label197:
    label242:
    while ((f4 < this.PTS[10].y) || (f4 + this.MIN_HEIGHT > this.PTS[9].y))
    {
      do
      {
        return;
      } while ((paramFloat1 > 0.0F) || (paramFloat2 < 0.0F));
      f2 = f1 * 1.0F;
      break;
      f3 = this.PTS[9].x - f2 * this.MIN_WIDTH / this.MIN_HEIGHT;
      f4 = f2 + this.PTS[8].y;
      break label138;
    }
    this.PTS[8].set(this.PTS[8].x, f4);
    this.PTS[9].set(f3, this.PTS[9].y);
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
  
  public PointF[] getPTS()
  {
    return this.PTS;
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
    }
    for (int i = 8;; i++)
    {
      if (i >= 12)
      {
        LogUtil.e("", "=======================");
        this.mPress = -1;
        for (;;)
        {
          computeSetPoint();
          return true;
          this.SX = paramMotionEvent.getX();
          this.SY = paramMotionEvent.getY();
          this.mPress = getPresssPoint(this.SX, this.SY);
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
            moveScale_TL(this.MX, this.MY);
            break;
          case 100: 
            moveAll(this.MX, this.MY);
            break;
          case 2: 
            moveScale_TR(this.MX, this.MY);
            break;
          case 4: 
            moveScale_BR(this.MX, this.MY);
            break;
          case 6: 
            moveScale_BL(this.MX, this.MY);
          }
        }
      }
      LogUtil.e("", "pts[" + i + "]{" + this.PTS[i].x + "," + this.PTS[i].y + "}");
    }
  }
  
  public void setImgSize(int paramInt1, int paramInt2) {}
  
  public void setMaxSize(int paramInt1, int paramInt2) {}
  
  public void setMinSize(int paramInt1, int paramInt2)
  {
    this.MIN_WIDTH = paramInt1;
    this.MIN_HEIGHT = paramInt2;
  }
  
  public void setPTS(PointF[] paramArrayOfPointF)
  {
    this.PTS = paramArrayOfPointF;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.crop.MotionEventScale
 * JD-Core Version:    0.7.0.1
 */