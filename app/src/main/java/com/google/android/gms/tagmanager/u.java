package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class u
  extends aj
{
  private static final String ID = a.C.toString();
  private static final String NAME = b.dB.toString();
  private static final String aqZ = b.cr.toString();
  private final DataLayer aqn;
  
  public u(DataLayer paramDataLayer)
  {
    super(str, arrayOfString);
    this.aqn = paramDataLayer;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    Object localObject = this.aqn.get(di.j((d.a)paramMap.get(NAME)));
    if (localObject == null)
    {
      d.a locala = (d.a)paramMap.get(aqZ);
      if (locala != null) {
        return locala;
      }
      return di.rb();
    }
    return di.u(localObject);
  }
  
  public boolean pe()
  {
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.u
 * JD-Core Version:    0.7.0.1
 */