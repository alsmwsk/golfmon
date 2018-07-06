package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;

public final class jp
{
  private final String Nq;
  
  public jp(String paramString)
  {
    this.Nq = ((String)jx.i(paramString));
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; (i < arrayOfStackTraceElement.length) && (i < 2); i++)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i].toString());
      localStringBuilder.append("\n");
    }
    oo localoo = new oo(paramContext, 10);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "GMS_WTF";
    arrayOfString[1] = localStringBuilder.toString();
    localoo.a("GMS_WTF", null, arrayOfString);
    localoo.send();
    if (aF(7))
    {
      Log.e(paramString1, paramString2, paramThrowable);
      Log.wtf(paramString1, paramString2, paramThrowable);
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (aF(4)) {
      Log.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public boolean aF(int paramInt)
  {
    return Log.isLoggable(this.Nq, paramInt);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (aF(5)) {
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (aF(6)) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public void m(String paramString1, String paramString2)
  {
    if (aF(3)) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public void n(String paramString1, String paramString2)
  {
    if (aF(2)) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public void o(String paramString1, String paramString2)
  {
    if (aF(5)) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public void p(String paramString1, String paramString2)
  {
    if (aF(6)) {
      Log.e(paramString1, paramString2);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jp
 * JD-Core Version:    0.7.0.1
 */