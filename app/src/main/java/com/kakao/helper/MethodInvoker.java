package com.kakao.helper;

import java.lang.reflect.Method;

public final class MethodInvoker
{
  private static Method findMethod(String paramString, Method[] paramArrayOfMethod)
  {
    int i = paramArrayOfMethod.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return null;
      }
      Method localMethod = paramArrayOfMethod[j];
      if (localMethod.getName().equals(paramString))
      {
        localMethod.setAccessible(true);
        return localMethod;
      }
    }
  }
  
  public static void invoke(Object paramObject, String paramString, Object... paramVarArgs)
    throws Exception
  {
    if (paramObject == null) {
      throw new RuntimeException("methodOwnerClass is null.");
    }
    for (Class localClass = paramObject.getClass();; localClass = localClass.getSuperclass())
    {
      if (localClass.equals(Object.class)) {
        return;
      }
      Method[] arrayOfMethod = localClass.getDeclaredMethods();
      if (arrayOfMethod != null)
      {
        Method localMethod = findMethod(paramString, arrayOfMethod);
        if (localMethod != null)
        {
          localMethod.invoke(paramObject, paramVarArgs);
          return;
        }
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.helper.MethodInvoker
 * JD-Core Version:    0.7.0.1
 */