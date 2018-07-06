package com.appg.golfmon.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.view.ZoomGImageView;
import java.util.ArrayList;
import org.json.JSONObject;

public class ZoomImageViewPagerAdapter
  extends PagerAdapter
{
  private ArrayList<JSONObject> mImageJsonList = new ArrayList();
  private ArrayList<String> mImageUrlList = new ArrayList();
  private boolean mIsInfinity = false;
  private IReLoadJsonListener mJsonListener = null;
  private IReLoadListener mListener = null;
  private ArrayList<View> mViewList = new ArrayList();
  
  public ZoomImageViewPagerAdapter() {}
  
  public ZoomImageViewPagerAdapter(boolean paramBoolean)
  {
    this.mIsInfinity = paramBoolean;
  }
  
  private int getPosition(int paramInt)
  {
    if (this.mIsInfinity) {
      paramInt %= 3;
    }
    return paramInt;
  }
  
  public void add(ZoomGImageView paramZoomGImageView, String paramString)
  {
    add(paramZoomGImageView, paramString, null);
  }
  
  public void add(ZoomGImageView paramZoomGImageView, String paramString, JSONObject paramJSONObject)
  {
    this.mViewList.add(paramZoomGImageView);
    this.mImageUrlList.add(paramString);
    if (paramJSONObject != null) {
      this.mImageJsonList.add(paramJSONObject);
    }
  }
  
  public void clear()
  {
    this.mViewList.clear();
    this.mImageUrlList.clear();
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
    if ((getCount() > 0) && (getPosition(paramInt) < getCount())) {
      return (View)this.mViewList.get(getPosition(paramInt));
    }
    return null;
  }
  
  public JSONObject getItemJson(int paramInt)
  {
    if ((getCount() > 0) && (getPosition(paramInt) < getCount())) {
      return (JSONObject)this.mImageJsonList.get(getPosition(paramInt));
    }
    return null;
  }
  
  public String getItemUrl(int paramInt)
  {
    if ((getCount() > 0) && (getPosition(paramInt) < getCount())) {
      return (String)this.mImageUrlList.get(getPosition(paramInt));
    }
    return null;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    LogUtil.d("instantiateItem     =     " + paramInt);
    View localView = getItem(paramInt);
    if (!((String)this.mImageUrlList.get(paramInt)).equals((String)localView.getTag()))
    {
      if (this.mListener != null) {
        this.mListener.onReLoad((ZoomGImageView)localView, getItemUrl(paramInt));
      }
      if (this.mJsonListener != null) {
        this.mJsonListener.onReLoad((ZoomGImageView)localView, getItemJson(paramInt));
      }
    }
    ((ViewPager)paramView).addView(localView, 0);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setOnReLoadJsonListener(IReLoadJsonListener paramIReLoadJsonListener)
  {
    this.mJsonListener = paramIReLoadJsonListener;
  }
  
  public void setOnReLoadListener(IReLoadListener paramIReLoadListener)
  {
    this.mListener = paramIReLoadListener;
  }
  
  public static abstract interface IReLoadJsonListener
  {
    public abstract void onReLoad(ZoomGImageView paramZoomGImageView, JSONObject paramJSONObject);
  }
  
  public static abstract interface IReLoadListener
  {
    public abstract void onReLoad(ZoomGImageView paramZoomGImageView, String paramString);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.adapter.ZoomImageViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */