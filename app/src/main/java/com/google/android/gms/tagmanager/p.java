package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class p
  extends aj
{
  private static final String ID = a.D.toString();
  private final String TU;
  
  public p(String paramString)
  {
    super(ID, new String[0]);
    this.TU = paramString;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    if (this.TU == null) {
      return di.rb();
    }
    return di.u(this.TU);
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.p
 * JD-Core Version:    0.7.0.1
 */