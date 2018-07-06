package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ah
  extends aj
{
  private static final String ID = a.K.toString();
  private final ct aqo;
  
  public ah(ct paramct)
  {
    super(ID, new String[0]);
    this.aqo = paramct;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    String str = this.aqo.qE();
    if (str == null) {
      return di.rb();
    }
    return di.u(str);
  }
  
  public boolean pe()
  {
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ah
 * JD-Core Version:    0.7.0.1
 */