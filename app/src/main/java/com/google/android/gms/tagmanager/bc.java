package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Locale;
import java.util.Map;

class bc
  extends aj
{
  private static final String ID = a.N.toString();
  
  public bc()
  {
    super(ID, new String[0]);
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    Locale localLocale = Locale.getDefault();
    if (localLocale == null) {
      return di.rb();
    }
    String str = localLocale.getLanguage();
    if (str == null) {
      return di.rb();
    }
    return di.u(str.toLowerCase());
  }
  
  public boolean pe()
  {
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bc
 * JD-Core Version:    0.7.0.1
 */