package com.appg.golfmon.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.appg.golfmon.util.LogUtil;
import java.util.ArrayList;

public class ViewPagerAdapter
  extends PagerAdapter
{
  ArrayList<View> mViewList = new ArrayList();
  
  public void add(View paramView)
  {
    this.mViewList.add(paramView);
  }
  
  public void clear()
  {
    this.mViewList.clear();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    LogUtil.i("destroyItem     =     " + paramInt);
    ((ViewPager)paramView).removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.mViewList.size();
  }
  
  public View getItem(int paramInt)
  {
    if ((getCount() > 0) && (paramInt < getCount())) {
      return (View)this.mViewList.get(paramInt);
    }
    return null;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    LogUtil.d("instantiateItem     =     " + paramInt);
    View localView = (View)this.mViewList.get(paramInt);
    if (localView.getParent() != null) {
      destroyItem(paramView, paramInt, localView);
    }
    ((ViewPager)paramView).addView(localView, 0);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void remove(ViewPager paramViewPager, int paramInt)
  {
    int i = paramViewPager.getCurrentItem();
    LogUtil.d("setPos : " + i);
    this.mViewList.remove(paramInt);
    notifyDataSetChanged();
    paramViewPager.setCurrentItem(i - 1, false);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.adapter.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */