package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj
{
  private final Set<String> art;
  private final String aru;
  
  public aj(String paramString, String... paramVarArgs)
  {
    this.aru = paramString;
    this.art = new HashSet(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramVarArgs[j];
      this.art.add(str);
    }
  }
  
  public abstract d.a B(Map<String, d.a> paramMap);
  
  boolean a(Set<String> paramSet)
  {
    return paramSet.containsAll(this.art);
  }
  
  public String pI()
  {
    return this.aru;
  }
  
  public Set<String> pJ()
  {
    return this.art;
  }
  
  public abstract boolean pe();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.aj
 * JD-Core Version:    0.7.0.1
 */