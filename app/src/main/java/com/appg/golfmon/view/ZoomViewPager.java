package com.appg.golfmon.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import com.appg.golfmon.adapter.ZoomImageViewPagerAdapter;
import com.appg.golfmon.util.LogUtil;

public class ZoomViewPager
  extends ViewPager
{
  private ZoomGImageView imageView;
  View.OnClickListener mClickListener = null;
  private float mStartX = 0.0F;
  private float mStartY = 0.0F;
  private PointF m_start = new PointF();
  
  public ZoomViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ZoomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void print(MotionEvent paramMotionEvent)
  {
    String str = "";
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      LogUtil.i(str + ":" + paramMotionEvent.getX() + "," + paramMotionEvent.getY());
      return;
      str = "ACTION_CANCEL";
      continue;
      str = "ACTION_DOWN";
      continue;
      str = "ACTION_MASK";
      continue;
      str = "ACTION_MOVE";
      continue;
      str = "ACTION_OUTSIDE";
      continue;
      str = "ACTION_POINTER_1_DOWN";
      continue;
      str = "ACTION_POINTER_1_UP";
      continue;
      str = "ACTION_POINTER_2_DOWN";
      continue;
      str = "ACTION_POINTER_2_UP";
      continue;
      str = "ACTION_POINTER_3_DOWN";
      continue;
      str = "ACTION_POINTER_3_UP";
      continue;
      str = "ACTION_POINTER_INDEX_MASK";
      continue;
      str = "ACTION_POINTER_INDEX_SHIFT";
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.mStartX = paramMotionEvent.getX();
      this.mStartY = paramMotionEvent.getY();
      continue;
      if ((Math.abs(paramMotionEvent.getX() - this.mStartX) < 20.0F) && (Math.abs(paramMotionEvent.getY() - this.mStartY) < 20.0F) && (this.mClickListener != null)) {
        this.mClickListener.onClick(this);
      }
      this.mStartX = 0.0F;
      this.mStartY = 0.0F;
    }
  }
  
  public Object getSelectedView()
  {
    return ((ZoomImageViewPagerAdapter)getAdapter()).getItem(getCurrentItem());
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.imageView = ((ZoomGImageView)getSelectedView());
    if (this.imageView != null) {
      switch (0xFF & paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      if (!this.imageView.isDraggable) {
        onTouchEvent(paramMotionEvent);
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.m_start.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.imageView.isDraggable = true;
      continue;
      this.imageView.isDraggable = true;
      if (this.imageView.getScaleType() != ImageView.ScaleType.MATRIX)
      {
        this.imageView.setMatrix(this.imageView.getImageMatrix());
        this.imageView.setScaleType(ImageView.ScaleType.MATRIX);
        continue;
        LogUtil.e("onInterceptTouchEvent VIEWPAGER ACTION_MOVE");
        if (paramMotionEvent.getX() - this.m_start.x < 0.0F)
        {
          if (this.imageView.isRight) {
            this.imageView.isDraggable = false;
          }
        }
        else if ((paramMotionEvent.getX() - this.m_start.x > 0.0F) && (this.imageView.isLeft)) {
          this.imageView.isDraggable = false;
        }
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mClickListener = paramOnClickListener;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.view.ZoomViewPager
 * JD-Core Version:    0.7.0.1
 */