package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class e
  extends aj
{
  private static final String ID = a.Y.toString();
  private static final String aqd = b.bW.toString();
  private static final String aqe = b.bZ.toString();
  private final Context lM;
  
  public e(Context paramContext)
  {
    super(str, arrayOfString);
    this.lM = paramContext;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    d.a locala1 = (d.a)paramMap.get(aqe);
    if (locala1 == null) {
      return di.rb();
    }
    String str1 = di.j(locala1);
    d.a locala2 = (d.a)paramMap.get(aqd);
    if (locala2 != null) {}
    for (String str2 = di.j(locala2);; str2 = null)
    {
      String str3 = ay.f(this.lM, str1, str2);
      if (str3 == null) {
        break;
      }
      return di.u(str3);
    }
    return di.rb();
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.e
 * JD-Core Version:    0.7.0.1
 */