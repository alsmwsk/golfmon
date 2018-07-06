package com.google.android.gms.internal;

import android.accounts.Account;
import android.text.TextUtils;

public class jd
  extends jq.a
{
  private Account CR;
  
  public jd(Account paramAccount)
  {
    this.CR = paramAccount;
  }
  
  public static jd aT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (Account localAccount = null;; localAccount = new Account(paramString, "com.google")) {
      return new jd(localAccount);
    }
  }
  
  public Account hk()
  {
    return this.CR;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jd
 * JD-Core Version:    0.7.0.1
 */