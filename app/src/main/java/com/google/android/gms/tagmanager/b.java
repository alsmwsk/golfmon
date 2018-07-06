package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class b
  extends aj
{
  private static final String ID = com.google.android.gms.internal.a.u.toString();
  private final a aqc;
  
  public b(Context paramContext)
  {
    this(a.W(paramContext));
  }
  
  b(a parama)
  {
    super(ID, new String[0]);
    this.aqc = parama;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    String str = this.aqc.pa();
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
 * Qualified Name:     com.google.android.gms.tagmanager.b
 * JD-Core Version:    0.7.0.1
 */