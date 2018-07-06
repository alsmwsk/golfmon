package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ax
  extends aj
{
  private static final String ID = a.ad.toString();
  private static final String aqd = b.bW.toString();
  private final Context lM;
  
  public ax(Context paramContext)
  {
    super(ID, new String[0]);
    this.lM = paramContext;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    if ((d.a)paramMap.get(aqd) != null) {}
    for (String str1 = di.j((d.a)paramMap.get(aqd));; str1 = null)
    {
      String str2 = ay.e(this.lM, str1);
      if (str2 == null) {
        break;
      }
      return di.u(str2);
    }
    return di.rb();
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ax
 * JD-Core Version:    0.7.0.1
 */