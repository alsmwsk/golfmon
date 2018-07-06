package com.appg.golfmon.common;

import android.content.Context;
import android.view.View;
import org.json.JSONObject;

public class InterfaceSet
{
  public static abstract interface IBooleanListener
  {
    public abstract void result(boolean paramBoolean);
  }
  
  public static abstract interface IRefresh
  {
    public abstract void refresh();
  }
  
  public static abstract interface IScollState
  {
    public abstract boolean isBottom();
    
    public abstract boolean isTop();
  }
  
  public static abstract interface IScrollPullListener
  {
    public abstract void onPullDown(Context paramContext);
    
    public abstract void onPullUp(Context paramContext);
  }
  
  public static abstract interface OnClickJsonListener
  {
    public abstract void onClick(View paramView, int paramInt, JSONObject paramJSONObject);
  }
  
  public static abstract interface TabClickListener
  {
    public abstract void onClick(View paramView, int paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.common.InterfaceSet
 * JD-Core Version:    0.7.0.1
 */