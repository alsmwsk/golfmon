package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class cf
  extends aj
{
  private static final String ID = a.Q.toString();
  private static final String asu = b.dz.toString();
  private static final String asv = b.dy.toString();
  
  public cf()
  {
    super(ID, new String[0]);
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    d.a locala1 = (d.a)paramMap.get(asu);
    d.a locala2 = (d.a)paramMap.get(asv);
    double d3;
    double d1;
    if ((locala1 != null) && (locala1 != di.rb()) && (locala2 != null) && (locala2 != di.rb()))
    {
      dh localdh1 = di.k(locala1);
      dh localdh2 = di.k(locala2);
      if ((localdh1 != di.qZ()) && (localdh2 != di.qZ()))
      {
        d3 = localdh1.doubleValue();
        d1 = localdh2.doubleValue();
        if (d3 > d1) {}
      }
    }
    for (double d2 = d3;; d2 = 0.0D)
    {
      return di.u(Long.valueOf(Math.round(d2 + Math.random() * (d1 - d2))));
      d1 = 2147483647.0D;
    }
  }
  
  public boolean pe()
  {
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cf
 * JD-Core Version:    0.7.0.1
 */