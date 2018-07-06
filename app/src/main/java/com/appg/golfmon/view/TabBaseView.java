package com.appg.golfmon.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.appg.golfmon.common.InterfaceSet.TabClickListener;

public abstract class TabBaseView
  extends LinearLayout
{
  private InterfaceSet.TabClickListener mListener = null;
  
  public TabBaseView(Context paramContext)
  {
    super(paramContext);
    init();
    listeners();
  }
  
  public TabBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
    listeners();
  }
  
  @SuppressLint({"NewApi"})
  public TabBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
    listeners();
  }
  
  protected abstract void init();
  
  protected abstract void listeners();
  
  public void setOnTabListener(InterfaceSet.TabClickListener paramTabClickListener)
  {
    this.mListener = paramTabClickListener;
  }
  
  protected abstract void setTabOn(int paramInt);
  
  public class ClickTab
    implements View.OnClickListener
  {
    private int position = 0;
    
    public ClickTab(int paramInt)
    {
      this.position = paramInt;
    }
    
    public void onClick(View paramView)
    {
      if (TabBaseView.this.mListener != null) {
        TabBaseView.this.mListener.onClick(paramView, this.position);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.view.TabBaseView
 * JD-Core Version:    0.7.0.1
 */