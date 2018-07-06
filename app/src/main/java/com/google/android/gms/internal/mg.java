package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataSource;

public class mg
{
  private static final ThreadLocal<String> UV = new ThreadLocal();
  
  public static String bw(String paramString)
  {
    return r(paramString, (String)UV.get());
  }
  
  public static DataSource c(DataSource paramDataSource)
  {
    if (!paramDataSource.jz()) {}
    String str;
    do
    {
      return paramDataSource;
      str = (String)UV.get();
    } while ((jN()) || (str.equals(paramDataSource.getAppPackageName())));
    return paramDataSource.jA();
  }
  
  public static boolean jN()
  {
    String str = (String)UV.get();
    return (str == null) || (str.startsWith("com.google"));
  }
  
  private static String r(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return paramString1;
    }
    byte[] arrayOfByte = new byte[paramString1.length() + paramString2.length()];
    System.arraycopy(paramString1.getBytes(), 0, arrayOfByte, 0, paramString1.length());
    System.arraycopy(paramString2.getBytes(), 0, arrayOfByte, paramString1.length(), paramString2.length());
    return Integer.toHexString(lk.a(arrayOfByte, 0, arrayOfByte.length, 0));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mg
 * JD-Core Version:    0.7.0.1
 */