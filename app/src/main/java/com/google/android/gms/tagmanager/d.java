package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

class d
  implements DataLayer.b
{
  private final Context lM;
  
  public d(Context paramContext)
  {
    this.lM = paramContext;
  }
  
  public void C(Map<String, Object> paramMap)
  {
    Object localObject1 = paramMap.get("gtm.url");
    Object localObject3;
    if (localObject1 == null)
    {
      localObject3 = paramMap.get("gtm");
      if ((localObject3 == null) || (!(localObject3 instanceof Map))) {}
    }
    for (Object localObject2 = ((Map)localObject3).get("url");; localObject2 = localObject1)
    {
      if ((localObject2 == null) || (!(localObject2 instanceof String))) {}
      String str;
      do
      {
        return;
        str = Uri.parse((String)localObject2).getQueryParameter("referrer");
      } while (str == null);
      ay.f(this.lM, str);
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.d
 * JD-Core Version:    0.7.0.1
 */