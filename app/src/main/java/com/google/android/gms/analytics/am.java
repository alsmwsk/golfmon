package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class am
  implements m
{
  int CA = -1;
  Map<String, String> CB = new HashMap();
  String Cv;
  double Cw = -1.0D;
  int Cx = -1;
  int Cy = -1;
  int Cz = -1;
  
  public String am(String paramString)
  {
    String str = (String)this.CB.get(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public boolean fA()
  {
    return this.Cz != -1;
  }
  
  public boolean fB()
  {
    return this.Cz == 1;
  }
  
  public boolean fC()
  {
    return this.CA == 1;
  }
  
  public boolean ft()
  {
    return this.Cv != null;
  }
  
  public String fu()
  {
    return this.Cv;
  }
  
  public boolean fv()
  {
    return this.Cw >= 0.0D;
  }
  
  public double fw()
  {
    return this.Cw;
  }
  
  public boolean fx()
  {
    return this.Cx >= 0;
  }
  
  public boolean fy()
  {
    return this.Cy != -1;
  }
  
  public boolean fz()
  {
    return this.Cy == 1;
  }
  
  public int getSessionTimeout()
  {
    return this.Cx;
  }
  
  public String k(Activity paramActivity)
  {
    return am(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.am
 * JD-Core Version:    0.7.0.1
 */