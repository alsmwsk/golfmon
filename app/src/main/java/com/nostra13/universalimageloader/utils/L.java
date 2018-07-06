package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

public final class L
{
  private static volatile boolean DISABLED = false;
  private static final String LOG_FORMAT = "%1$s\n%2$s";
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    log(3, null, paramString, paramVarArgs);
  }
  
  public static void disableLogging()
  {
    DISABLED = true;
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    log(6, null, paramString, paramVarArgs);
  }
  
  public static void e(Throwable paramThrowable)
  {
    log(6, paramThrowable, null, new Object[0]);
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log(6, paramThrowable, paramString, paramVarArgs);
  }
  
  public static void enableLogging()
  {
    DISABLED = false;
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    log(4, null, paramString, paramVarArgs);
  }
  
  private static void log(int paramInt, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (DISABLED) {
      return;
    }
    if (paramVarArgs.length > 0) {
      paramString = String.format(paramString, paramVarArgs);
    }
    String str2;
    if (paramThrowable == null)
    {
      str2 = paramString;
      Log.println(paramInt, ImageLoader.TAG, str2);
      return;
    }
    if (paramString == null) {}
    for (String str1 = paramThrowable.getMessage();; str1 = paramString)
    {
      str2 = String.format("%1$s\n%2$s", new Object[] { str1, Log.getStackTraceString(paramThrowable) });
      break;
    }
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    log(5, null, paramString, paramVarArgs);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.L
 * JD-Core Version:    0.7.0.1
 */