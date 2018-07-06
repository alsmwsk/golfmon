package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba
{
  public static cr.c cI(String paramString)
    throws JSONException
  {
    d.a locala = n(new JSONObject(paramString));
    cr.d locald = cr.c.qo();
    for (int i = 0; i < locala.gx.length; i++) {
      locald.a(cr.a.qk().b(b.df.toString(), locala.gx[i]).b(b.cU.toString(), di.cZ(m.ph())).b(m.pi(), locala.gy[i]).qn());
    }
    return locald.qr();
  }
  
  private static d.a n(Object paramObject)
    throws JSONException
  {
    return di.u(o(paramObject));
  }
  
  static Object o(Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof JSONArray)) {
      throw new RuntimeException("JSONArrays are not supported");
    }
    if (JSONObject.NULL.equals(paramObject)) {
      throw new RuntimeException("JSON nulls are not supported");
    }
    if ((paramObject instanceof JSONObject))
    {
      JSONObject localJSONObject = (JSONObject)paramObject;
      HashMap localHashMap = new HashMap();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, o(localJSONObject.get(str)));
      }
      paramObject = localHashMap;
    }
    return paramObject;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ba
 * JD-Core Version:    0.7.0.1
 */