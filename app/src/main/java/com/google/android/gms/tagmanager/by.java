package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class by
  extends cd
{
  public by(String paramString)
  {
    super(paramString);
  }
  
  protected boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap)
  {
    dh localdh1 = di.k(parama1);
    dh localdh2 = di.k(parama2);
    if ((localdh1 == di.qZ()) || (localdh2 == di.qZ())) {
      return false;
    }
    return a(localdh1, localdh2, paramMap);
  }
  
  protected abstract boolean a(dh paramdh1, dh paramdh2, Map<String, d.a> paramMap);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.by
 * JD-Core Version:    0.7.0.1
 */