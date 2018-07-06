package com.appg.golfmon.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InflateUtil
{
  public static View inflate(Context paramContext, int paramInt, ViewGroup paramViewGroup)
  {
    return ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, paramViewGroup);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.InflateUtil
 * JD-Core Version:    0.7.0.1
 */