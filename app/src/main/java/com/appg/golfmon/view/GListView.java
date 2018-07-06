package com.appg.golfmon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.appg.golfmon.common.InterfaceSet.IScollState;
import com.appg.golfmon.common.InterfaceSet.IScrollPullListener;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GListView
  extends ListView
  implements InterfaceSet.IScollState, AbsListView.OnScrollListener
{
  public static final int DIRECT_BOTTOM = 101;
  public static final int DIRECT_TOP = 100;
  private GListAdapter mAdapter = null;
  private boolean mHasMore = true;
  private boolean mIsBottom = false;
  private boolean mIsTop = true;
  private IMakeView mMv = null;
  private AbsListView.OnScrollListener mOnScrollListener = null;
  private int mResourceID;
  private int mScrollDirect = 0;
  private InterfaceSet.IScrollPullListener mScrollPullListener = null;
  private float mScrollStartY = 0.0F;
  private float mStartY = 0.0F;
  private int mTotalCount = 0;
  private float mTouchEventAction = 0.0F;
  
  public GListView(Context paramContext)
  {
    super(paramContext);
    initialize();
  }
  
  public GListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize();
  }
  
  public GListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize();
  }
  
  private void initialize()
  {
    setCacheColorHint(0);
    this.mAdapter = new GListAdapter(getContext(), new ArrayList());
    setAdapter(this.mAdapter);
    super.setOnScrollListener(this);
  }
  
  public void addFooterView(View paramView)
  {
    setAdapter(null);
    super.addFooterView(paramView);
    setAdapter(this.mAdapter);
  }
  
  public void addHeaderView(View paramView)
  {
    setAdapter(null);
    super.addHeaderView(paramView);
    setAdapter(this.mAdapter);
  }
  
  public void addItem(JSONObject paramJSONObject)
  {
    this.mAdapter.add(paramJSONObject);
  }
  
  public void addItems(ArrayList<JSONObject> paramArrayList)
  {
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
      i = paramArrayList.size();
    }
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      this.mAdapter.add((JSONObject)paramArrayList.get(j));
    }
  }
  
  public void addItems(JSONArray paramJSONArray)
  {
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0)) {
      i = paramJSONArray.length();
    }
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      this.mAdapter.add(JSONUtil.getJSONObject(paramJSONArray, j));
    }
  }
  
  public void addItems(JSONObject... paramVarArgs)
  {
    for (int i = 0;; i++)
    {
      if (i >= paramVarArgs.length) {
        return;
      }
      this.mAdapter.add(paramVarArgs[i]);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getRawY();
    if (i == 0)
    {
      this.mScrollStartY = 0.0F;
      if (i != 0) {
        break label110;
      }
      this.mStartY = paramMotionEvent.getRawY();
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (i != 2) {
        break;
      }
      if (this.mScrollStartY == 0.0F)
      {
        this.mScrollStartY = f1;
        break;
      }
      float f2 = this.mScrollStartY - f1;
      if (Math.abs(f2) <= 60.0F) {
        break;
      }
      if (f2 < 0.0F) {}
      for (int j = 100;; j = 101)
      {
        this.mScrollDirect = j;
        this.mScrollStartY = f1;
        break;
      }
      label110:
      if (i == 1)
      {
        this.mTouchEventAction = (this.mStartY - paramMotionEvent.getRawY());
        this.mStartY = 0.0F;
      }
    }
  }
  
  public GListAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public int getCountAll()
  {
    return this.mAdapter.getCount();
  }
  
  public boolean getHasMore()
  {
    return this.mHasMore;
  }
  
  public JSONObject getItem(int paramInt)
  {
    GListAdapter localGListAdapter = this.mAdapter;
    JSONObject localJSONObject = null;
    if (localGListAdapter != null) {
      localJSONObject = (JSONObject)this.mAdapter.getItem(paramInt);
    }
    return localJSONObject;
  }
  
  public JSONObject getLastItem()
  {
    int i = getCountAll();
    if (i == 0) {
      return null;
    }
    return (JSONObject)getAdapter().getItem(i - 1);
  }
  
  public String getPageNo(String paramString)
  {
    if ((!FormatUtil.isNullorEmpty(paramString)) && (getCountAll() > 0)) {
      return JSONUtil.getString((JSONObject)this.mAdapter.getItem(-1 + getCountAll()), paramString, "");
    }
    return "";
  }
  
  public int getScrollDirect()
  {
    return this.mScrollDirect;
  }
  
  public int getTotalCount()
  {
    return this.mTotalCount;
  }
  
  public View inflateItemView(View paramView, int paramInt)
  {
    if (paramView == null) {
      paramView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, null);
    }
    return paramView;
  }
  
  public boolean isBottom()
  {
    return this.mIsBottom;
  }
  
  public boolean isTop()
  {
    return this.mIsTop;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = true;
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    View localView1 = paramAbsListView.getChildAt(0);
    if (localView1 == null)
    {
      this.mIsTop = bool1;
      return;
    }
    if ((paramInt1 == 0) && (localView1.getTop() == paramAbsListView.getPaddingTop())) {}
    View localView2;
    for (boolean bool2 = bool1;; bool2 = false)
    {
      this.mIsTop = bool2;
      if (this.mIsTop) {
        break label144;
      }
      localView2 = paramAbsListView.getChildAt(-1 + paramAbsListView.getChildCount());
      if (localView2 != null) {
        break;
      }
      this.mIsBottom = bool1;
      return;
    }
    if ((paramInt3 == paramInt1 + paramInt2) && (localView2.getBottom() <= paramAbsListView.getHeight() - paramAbsListView.getPaddingBottom())) {}
    for (;;)
    {
      this.mIsBottom = bool1;
      return;
      bool1 = false;
    }
    label144:
    this.mIsBottom = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    LogUtil.e(paramInt + "//" + this.mIsTop + "//" + this.mIsBottom + "//" + this.mTouchEventAction);
    if (paramInt == 0)
    {
      if (this.mTouchEventAction <= 0.0F) {
        break label120;
      }
      if ((this.mIsBottom) && (this.mScrollPullListener != null)) {
        this.mScrollPullListener.onPullUp(getContext());
      }
    }
    for (;;)
    {
      this.mTouchEventAction = 0.0F;
      return;
      label120:
      if ((this.mTouchEventAction < 0.0F) && (this.mIsTop) && (this.mScrollPullListener != null)) {
        this.mScrollPullListener.onPullDown(getContext());
      }
    }
  }
  
  public void refresh()
  {
    this.mAdapter.notifyDataSetChanged();
    refreshDrawableState();
  }
  
  public void remove(JSONObject paramJSONObject)
  {
    this.mAdapter.remove(paramJSONObject);
  }
  
  public void removeAll()
  {
    this.mAdapter.clear();
    refreshDrawableState();
    this.mHasMore = true;
    this.mTotalCount = 0;
  }
  
  public void setHasMore(boolean paramBoolean)
  {
    this.mHasMore = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
  
  public void setOnScrollPullListener(InterfaceSet.IScrollPullListener paramIScrollPullListener)
  {
    this.mScrollPullListener = paramIScrollPullListener;
  }
  
  public void setScrollDirect(int paramInt)
  {
    this.mScrollDirect = paramInt;
  }
  
  public void setTotalCount(int paramInt)
  {
    this.mTotalCount = paramInt;
  }
  
  public void setViewMaker(int paramInt, IMakeView paramIMakeView)
  {
    this.mAdapter = new GListAdapter(getContext(), new ArrayList());
    removeAll();
    setAdapter(this.mAdapter);
    this.mResourceID = paramInt;
    this.mMv = paramIMakeView;
  }
  
  public class GListAdapter
    extends ArrayAdapter<JSONObject>
  {
    public GListAdapter(List<JSONObject> paramList)
    {
      super(0, 0, localList);
    }
    
    public JSONObject getItemNext(int paramInt)
    {
      if (paramInt < -1 + getCount()) {
        return (JSONObject)getItem(paramInt + 1);
      }
      return null;
    }
    
    public JSONObject getItemPrev(int paramInt)
    {
      if (paramInt > 0) {
        return (JSONObject)getItem(paramInt - 1);
      }
      return null;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return GListView.this.mMv.makeView(this, paramInt, GListView.this.inflateItemView(paramView, GListView.this.mResourceID), paramViewGroup);
    }
    
    class ViewHolder
    {
      ImageView ivThum;
      TextView txtDate;
      TextView txtName;
      TextView txtPayWeekDay;
      TextView txtPayWeekEnd;
      TextView txtTitle;
      
      ViewHolder() {}
    }
  }
  
  public static abstract interface IMakeView
  {
    public abstract View makeView(GListView.GListAdapter paramGListAdapter, int paramInt, View paramView, ViewGroup paramViewGroup);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.view.GListView
 * JD-Core Version:    0.7.0.1
 */