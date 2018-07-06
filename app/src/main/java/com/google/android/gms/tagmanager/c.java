package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class c
  extends aj
{
  private static final String ID = com.google.android.gms.internal.a.v.toString();
  private final a aqc;
  
  public c(Context paramContext)
  {
    this(a.W(paramContext));
  }
  
  c(a parama)
  {
    super(ID, new String[0]);
    this.aqc = parama;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    if (!this.aqc.isLimitAdTrackingEnabled()) {}
    for (boolean bool = true;; bool = false) {
      return di.u(Boolean.valueOf(bool));
    }
  }
  
  public boolean pe()
  {
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.c
 * JD-Core Version:    0.7.0.1
 */