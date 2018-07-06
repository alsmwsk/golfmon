package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class jv
{
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static a h(Object paramObject)
  {
    return new a(paramObject, null);
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static final class a
  {
    private final List<String> Nr;
    private final Object Ns;
    
    private a(Object paramObject)
    {
      this.Ns = jx.i(paramObject);
      this.Nr = new ArrayList();
    }
    
    public a a(String paramString, Object paramObject)
    {
      this.Nr.add((String)jx.i(paramString) + "=" + String.valueOf(paramObject));
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(this.Ns.getClass().getSimpleName()).append('{');
      int i = this.Nr.size();
      for (int j = 0; j < i; j++)
      {
        localStringBuilder.append((String)this.Nr.get(j));
        if (j < i - 1) {
          localStringBuilder.append(", ");
        }
      }
      return '}';
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jv
 * JD-Core Version:    0.7.0.1
 */