package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch
  extends aj
{
  private static final String ID = a.ag.toString();
  private static final String asw = b.bw.toString();
  private static final String asx = b.bx.toString();
  private static final String asy = b.dc.toString();
  private static final String asz = b.cW.toString();
  
  public ch()
  {
    super(str, arrayOfString);
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    d.a locala1 = (d.a)paramMap.get(asw);
    d.a locala2 = (d.a)paramMap.get(asx);
    if ((locala1 == null) || (locala1 == di.rb()) || (locala2 == null) || (locala2 == di.rb())) {
      return di.rb();
    }
    int i = 64;
    if (di.n((d.a)paramMap.get(asy)).booleanValue()) {
      i = 66;
    }
    d.a locala3 = (d.a)paramMap.get(asz);
    int j;
    if (locala3 != null)
    {
      Long localLong = di.l(locala3);
      if (localLong == di.qW()) {
        return di.rb();
      }
      j = localLong.intValue();
      if (j < 0) {
        return di.rb();
      }
    }
    else
    {
      j = 1;
    }
    try
    {
      String str1 = di.j(locala1);
      Matcher localMatcher = Pattern.compile(di.j(locala2), i).matcher(str1);
      boolean bool = localMatcher.find();
      String str2 = null;
      if (bool)
      {
        int k = localMatcher.groupCount();
        str2 = null;
        if (k >= j) {
          str2 = localMatcher.group(j);
        }
      }
      if (str2 == null) {
        return di.rb();
      }
      d.a locala4 = di.u(str2);
      return locala4;
    }
    catch (PatternSyntaxException localPatternSyntaxException) {}
    return di.rb();
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ch
 * JD-Core Version:    0.7.0.1
 */