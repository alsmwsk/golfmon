package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@ey
public final class ci
  implements cd
{
  private final ce qc;
  private final v qd;
  
  public ci(ce paramce, v paramv)
  {
    this.qc = paramce;
    this.qd = paramv;
  }
  
  private static boolean b(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int c(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("o");
    if (str != null)
    {
      if ("p".equalsIgnoreCase(str)) {
        return gi.dv();
      }
      if ("l".equalsIgnoreCase(str)) {
        return gi.du();
      }
    }
    return -1;
  }
  
  public void a(gu paramgu, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("a");
    if (str1 == null) {
      gr.W("Action missing from an open GMSG.");
    }
    gv localgv;
    String str2;
    String str3;
    do
    {
      return;
      if ((this.qd != null) && (!this.qd.az()))
      {
        this.qd.d((String)paramMap.get("u"));
        return;
      }
      localgv = paramgu.dD();
      if ("expand".equalsIgnoreCase(str1))
      {
        if (paramgu.dH())
        {
          gr.W("Cannot expand WebView that is already expanded.");
          return;
        }
        localgv.a(b(paramMap), c(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase(str1))
      {
        String str4 = (String)paramMap.get("u");
        if (str4 != null)
        {
          localgv.a(b(paramMap), c(paramMap), str4);
          return;
        }
        localgv.a(b(paramMap), c(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase(str1)) {
        break;
      }
      str2 = (String)paramMap.get("product_id");
      str3 = (String)paramMap.get("report_urls");
    } while (this.qc == null);
    if ((str3 != null) && (!str3.isEmpty()))
    {
      String[] arrayOfString = str3.split(" ");
      this.qc.a(str2, new ArrayList(Arrays.asList(arrayOfString)));
      return;
    }
    this.qc.a(str2, new ArrayList());
    return;
    localgv.a(new do((String)paramMap.get("i"), (String)paramMap.get("u"), (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ci
 * JD-Core Version:    0.7.0.1
 */