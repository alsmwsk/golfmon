package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class aa
  extends aj
{
  private static final String ID = a.F.toString();
  
  public aa()
  {
    super(ID, new String[0]);
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if ((!str2.startsWith(str1)) && (!str1.equals("unknown"))) {
      str2 = str1 + " " + str2;
    }
    return di.u(str2);
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.aa
 * JD-Core Version:    0.7.0.1
 */