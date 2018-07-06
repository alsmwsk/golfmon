package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class bj
  extends aj
{
  private static final String ID = a.ai.toString();
  private static final String arp = b.bw.toString();
  
  public bj()
  {
    super(str, arrayOfString);
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    return di.u(di.j((d.a)paramMap.get(arp)).toLowerCase());
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bj
 * JD-Core Version:    0.7.0.1
 */