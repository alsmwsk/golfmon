package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;

public class lm
{
  public static Scope[] d(String[] paramArrayOfString)
  {
    jx.b(paramArrayOfString, "scopeStrings can't be null.");
    Scope[] arrayOfScope = new Scope[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++) {
      arrayOfScope[i] = new Scope(paramArrayOfString[i]);
    }
    return arrayOfScope;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lm
 * JD-Core Version:    0.7.0.1
 */