package org.apache.commons.httpclient.util;

public class LangUtils
{
  public static final int HASH_OFFSET = 37;
  public static final int HASH_SEED = 17;
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static int hashCode(int paramInt1, int paramInt2)
  {
    return paramInt2 + paramInt1 * 37;
  }
  
  public static int hashCode(int paramInt, Object paramObject)
  {
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0) {
      return hashCode(paramInt, i);
    }
  }
  
  public static int hashCode(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return hashCode(paramInt, i);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.util.LangUtils
 * JD-Core Version:    0.7.0.1
 */