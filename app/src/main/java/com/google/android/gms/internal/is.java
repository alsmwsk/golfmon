package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class is
{
  private static boolean HN = false;
  private boolean HO;
  private boolean HP;
  private String HQ;
  protected final String mTag;
  
  public is(String paramString)
  {
    this(paramString, go());
  }
  
  public is(String paramString, boolean paramBoolean)
  {
    this.mTag = paramString;
    this.HO = paramBoolean;
    this.HP = false;
  }
  
  public static boolean go()
  {
    return HN;
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    if (gn()) {
      Log.v(this.mTag, e(paramString, paramVarArgs));
    }
  }
  
  public void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if ((gm()) || (HN)) {
      Log.d(this.mTag, e(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public void aK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (String str = null;; str = String.format("[%s] ", new Object[] { paramString }))
    {
      this.HQ = str;
      return;
    }
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    if ((gm()) || (HN)) {
      Log.d(this.mTag, e(paramString, paramVarArgs));
    }
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    Log.i(this.mTag, e(paramString, paramVarArgs));
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    Log.w(this.mTag, e(paramString, paramVarArgs));
  }
  
  protected String e(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (;;)
    {
      if (!TextUtils.isEmpty(this.HQ)) {
        paramString = this.HQ + paramString;
      }
      return paramString;
      paramString = String.format(paramString, paramVarArgs);
    }
  }
  
  public boolean gm()
  {
    return this.HO;
  }
  
  public boolean gn()
  {
    return this.HP;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.is
 * JD-Core Version:    0.7.0.1
 */