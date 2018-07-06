package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class w
  extends dg
{
  private static final String ID = a.ah.toString();
  private static final String VALUE = b.ff.toString();
  private static final String ark = b.bS.toString();
  private final DataLayer aqn;
  
  public w(DataLayer paramDataLayer)
  {
    super(str, arrayOfString);
    this.aqn = paramDataLayer;
  }
  
  private void a(d.a parama)
  {
    if ((parama == null) || (parama == di.qV())) {}
    String str;
    do
    {
      return;
      str = di.j(parama);
    } while (str == di.ra());
    this.aqn.cx(str);
  }
  
  private void b(d.a parama)
  {
    if ((parama == null) || (parama == di.qV())) {}
    for (;;)
    {
      return;
      Object localObject1 = di.o(parama);
      if ((localObject1 instanceof List))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          if ((localObject2 instanceof Map))
          {
            Map localMap = (Map)localObject2;
            this.aqn.push(localMap);
          }
        }
      }
    }
  }
  
  public void D(Map<String, d.a> paramMap)
  {
    b((d.a)paramMap.get(VALUE));
    a((d.a)paramMap.get(ark));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.w
 * JD-Core Version:    0.7.0.1
 */