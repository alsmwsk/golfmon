package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class s
  extends aj
{
  private static final String ID = a.L.toString();
  private static final String aqO = b.cV.toString();
  private static final String aqf = b.bl.toString();
  private final a aqP;
  
  public s(a parama)
  {
    super(str, arrayOfString);
    this.aqP = parama;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    String str = di.j((d.a)paramMap.get(aqO));
    HashMap localHashMap = new HashMap();
    d.a locala1 = (d.a)paramMap.get(aqf);
    if (locala1 != null)
    {
      Object localObject = di.o(locala1);
      if (!(localObject instanceof Map))
      {
        bh.W("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        return di.rb();
      }
      Iterator localIterator = ((Map)localObject).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put(localEntry.getKey().toString(), localEntry.getValue());
      }
    }
    try
    {
      d.a locala2 = di.u(this.aqP.b(str, localHashMap));
      return locala2;
    }
    catch (Exception localException)
    {
      bh.W("Custom macro/tag " + str + " threw exception " + localException.getMessage());
    }
    return di.rb();
  }
  
  public boolean pe()
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract Object b(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.s
 * JD-Core Version:    0.7.0.1
 */