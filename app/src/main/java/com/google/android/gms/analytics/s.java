package com.google.android.gms.analytics;

public final class s
{
  public static String A(int paramInt)
  {
    return d("&pr", paramInt);
  }
  
  public static String B(int paramInt)
  {
    return d("&promo", paramInt);
  }
  
  public static String C(int paramInt)
  {
    return d("pi", paramInt);
  }
  
  public static String D(int paramInt)
  {
    return d("&il", paramInt);
  }
  
  public static String E(int paramInt)
  {
    return d("cd", paramInt);
  }
  
  public static String F(int paramInt)
  {
    return d("cm", paramInt);
  }
  
  private static String d(String paramString, int paramInt)
  {
    if (paramInt < 1)
    {
      ae.T("index out of range for " + paramString + " (" + paramInt + ")");
      return "";
    }
    return paramString + paramInt;
  }
  
  static String y(int paramInt)
  {
    return d("&cd", paramInt);
  }
  
  static String z(int paramInt)
  {
    return d("&cm", paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.s
 * JD-Core Version:    0.7.0.1
 */