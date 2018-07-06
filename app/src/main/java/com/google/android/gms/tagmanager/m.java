package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class m
  extends aj
{
  private static final String ID = a.A.toString();
  private static final String VALUE = b.ff.toString();
  
  public m()
  {
    super(str, arrayOfString);
  }
  
  public static String ph()
  {
    return ID;
  }
  
  public static String pi()
  {
    return VALUE;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    return (d.a)paramMap.get(VALUE);
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.m
 * JD-Core Version:    0.7.0.1
 */