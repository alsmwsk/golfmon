package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class ji
  implements SafeParcelable
{
  private static ClassLoader MA = null;
  private static Integer MB = null;
  private static final Object Mz = new Object();
  private boolean MC = false;
  
  private static boolean a(Class<?> paramClass)
  {
    try
    {
      boolean bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      return bool;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return false;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
    return false;
  }
  
  protected static boolean aW(String paramString)
  {
    ClassLoader localClassLoader = hs();
    if (localClassLoader == null) {
      return true;
    }
    try
    {
      boolean bool = a(localClassLoader.loadClass(paramString));
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  protected static ClassLoader hs()
  {
    synchronized (Mz)
    {
      ClassLoader localClassLoader = MA;
      return localClassLoader;
    }
  }
  
  protected static Integer ht()
  {
    synchronized (Mz)
    {
      Integer localInteger = MB;
      return localInteger;
    }
  }
  
  protected boolean hu()
  {
    return this.MC;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ji
 * JD-Core Version:    0.7.0.1
 */