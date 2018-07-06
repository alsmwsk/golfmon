package com.appg.golfmon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.appg.golfmon.util.LogUtil;
import java.util.ArrayList;

public class TabMain
  extends TabBaseView
{
  private ArrayList<View> mBtnList = new ArrayList();
  
  public TabMain(Context paramContext)
  {
    super(paramContext);
  }
  
  public TabMain(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TabMain(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void init()
  {
    inflate(getContext(), 2130903098, this);
  }
  
  protected void listeners()
  {
    if (this.mBtnList != null) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mBtnList.size()) {
        return;
      }
      View localView = (View)this.mBtnList.get(i);
      if (localView != null) {
        localView.setOnClickListener(new TabBaseView.ClickTab(this, i));
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (this.mBtnList != null)
    {
      this.mBtnList.add(findViewById(2131362085));
      this.mBtnList.add(findViewById(2131362086));
      this.mBtnList.add(findViewById(2131362087));
      this.mBtnList.add(findViewById(2131362088));
      this.mBtnList.add(findViewById(2131362089));
      listeners();
    }
  }
  
  public void setTabOn(int paramInt)
  {
    if (this.mBtnList != null)
    {
      LogUtil.e("탭 널 아님");
      int i = 0;
      if (i >= this.mBtnList.size()) {
        return;
      }
      View localView = (View)this.mBtnList.get(i);
      LogUtil.e("뷰 검사");
      if (localView != null)
      {
        LogUtil.e("뷰 널 아님");
        if (i != paramInt) {
          break label72;
        }
      }
      label72:
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        i++;
        break;
      }
    }
    LogUtil.e("탭 널 임");
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.view.TabMain
 * JD-Core Version:    0.7.0.1
 */