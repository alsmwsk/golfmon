package com.google.android.gms.wallet.fragment;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public class Dimension
{
  public static final int MATCH_PARENT = -1;
  public static final int UNIT_DIP = 1;
  public static final int UNIT_IN = 4;
  public static final int UNIT_MM = 5;
  public static final int UNIT_PT = 3;
  public static final int UNIT_PX = 0;
  public static final int UNIT_SP = 2;
  public static final int WRAP_CONTENT = -2;
  
  public static int a(long paramLong, DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    int k;
    switch (i)
    {
    default: 
      throw new IllegalStateException("Unexpected unit or type: " + i);
    case 129: 
      return j;
    case 128: 
      return TypedValue.complexToDimensionPixelSize(j, paramDisplayMetrics);
    case 0: 
      k = 0;
    }
    for (;;)
    {
      return Math.round(TypedValue.applyDimension(k, Float.intBitsToFloat(j), paramDisplayMetrics));
      k = 1;
      continue;
      k = 2;
      continue;
      k = 3;
      continue;
      k = 4;
      continue;
      k = 5;
    }
  }
  
  public static long a(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unrecognized unit: " + paramInt);
    }
    return p(paramInt, Float.floatToIntBits(paramFloat));
  }
  
  public static long a(TypedValue paramTypedValue)
  {
    switch (paramTypedValue.type)
    {
    default: 
      throw new IllegalArgumentException("Unexpected dimension type: " + paramTypedValue.type);
    case 16: 
      return gg(paramTypedValue.data);
    }
    return p(128, paramTypedValue.data);
  }
  
  public static long gg(int paramInt)
  {
    if (paramInt < 0)
    {
      if ((paramInt == -1) || (paramInt == -2)) {
        return p(129, paramInt);
      }
      throw new IllegalArgumentException("Unexpected dimension value: " + paramInt);
    }
    return a(0, paramInt);
  }
  
  private static long p(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | 0xFFFFFFFF & paramInt2;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.Dimension
 * JD-Core Version:    0.7.0.1
 */