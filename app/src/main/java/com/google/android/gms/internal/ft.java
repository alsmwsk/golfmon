package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ey
public final class ft
{
  private int mOrientation = -1;
  private String pD;
  private String uJ;
  private String uK;
  private List<String> uL;
  private String uM;
  private String uN;
  private List<String> uO;
  private long uP = -1L;
  private boolean uQ = false;
  private final long uR = -1L;
  private long uS = -1L;
  private boolean uT = false;
  private boolean uU = false;
  private boolean uV = false;
  private boolean uW = true;
  private List<String> uo;
  
  static String a(Map<String, List<String>> paramMap, String paramString)
  {
    List localList = (List)paramMap.get(paramString);
    if ((localList != null) && (!localList.isEmpty())) {
      return (String)localList.get(0);
    }
    return null;
  }
  
  static long b(Map<String, List<String>> paramMap, String paramString)
  {
    List localList = (List)paramMap.get(paramString);
    if ((localList != null) && (!localList.isEmpty()))
    {
      String str = (String)localList.get(0);
      try
      {
        float f = Float.parseFloat(str);
        return (f * 1000.0F);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        gr.W("Could not parse float from " + paramString + " header: " + str);
      }
    }
    return -1L;
  }
  
  static List<String> c(Map<String, List<String>> paramMap, String paramString)
  {
    List localList = (List)paramMap.get(paramString);
    if ((localList != null) && (!localList.isEmpty()))
    {
      String str = (String)localList.get(0);
      if (str != null) {
        return Arrays.asList(str.trim().split("\\s+"));
      }
    }
    return null;
  }
  
  private boolean d(Map<String, List<String>> paramMap, String paramString)
  {
    List localList = (List)paramMap.get(paramString);
    return (localList != null) && (!localList.isEmpty()) && (Boolean.valueOf((String)localList.get(0)).booleanValue());
  }
  
  private void f(Map<String, List<String>> paramMap)
  {
    this.uJ = a(paramMap, "X-Afma-Ad-Size");
  }
  
  private void g(Map<String, List<String>> paramMap)
  {
    List localList = c(paramMap, "X-Afma-Click-Tracking-Urls");
    if (localList != null) {
      this.uL = localList;
    }
  }
  
  private void h(Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((localList != null) && (!localList.isEmpty())) {
      this.uM = ((String)localList.get(0));
    }
  }
  
  private void i(Map<String, List<String>> paramMap)
  {
    List localList = c(paramMap, "X-Afma-Tracking-Urls");
    if (localList != null) {
      this.uO = localList;
    }
  }
  
  private void j(Map<String, List<String>> paramMap)
  {
    long l = b(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      this.uP = l;
    }
  }
  
  private void k(Map<String, List<String>> paramMap)
  {
    this.uN = a(paramMap, "X-Afma-ActiveView");
  }
  
  private void l(Map<String, List<String>> paramMap)
  {
    this.uU |= d(paramMap, "X-Afma-Native");
  }
  
  private void m(Map<String, List<String>> paramMap)
  {
    this.uT |= d(paramMap, "X-Afma-Custom-Rendering-Allowed");
  }
  
  private void n(Map<String, List<String>> paramMap)
  {
    this.uQ |= d(paramMap, "X-Afma-Mediation");
  }
  
  private void o(Map<String, List<String>> paramMap)
  {
    List localList = c(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (localList != null) {
      this.uo = localList;
    }
  }
  
  private void p(Map<String, List<String>> paramMap)
  {
    long l = b(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      this.uS = l;
    }
  }
  
  private void q(Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get("X-Afma-Orientation");
    String str;
    if ((localList != null) && (!localList.isEmpty()))
    {
      str = (String)localList.get(0);
      if (!"portrait".equalsIgnoreCase(str)) {
        break label53;
      }
      this.mOrientation = gi.dv();
    }
    label53:
    while (!"landscape".equalsIgnoreCase(str)) {
      return;
    }
    this.mOrientation = gi.du();
  }
  
  private void r(Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get("X-Afma-Use-HTTPS");
    if ((localList != null) && (!localList.isEmpty())) {
      this.uV = Boolean.valueOf((String)localList.get(0)).booleanValue();
    }
  }
  
  private void s(Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get("X-Afma-Content-Url-Opted-Out");
    if ((localList != null) && (!localList.isEmpty())) {
      this.uW = Boolean.valueOf((String)localList.get(0)).booleanValue();
    }
  }
  
  public void a(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    this.uK = paramString1;
    this.pD = paramString2;
    e(paramMap);
  }
  
  public void e(Map<String, List<String>> paramMap)
  {
    f(paramMap);
    g(paramMap);
    h(paramMap);
    i(paramMap);
    j(paramMap);
    n(paramMap);
    o(paramMap);
    p(paramMap);
    q(paramMap);
    k(paramMap);
    r(paramMap);
    m(paramMap);
    l(paramMap);
    s(paramMap);
  }
  
  public fj i(long paramLong)
  {
    return new fj(this.uK, this.pD, this.uL, this.uO, this.uP, this.uQ, -1L, this.uo, this.uS, this.mOrientation, this.uJ, paramLong, this.uM, this.uN, this.uT, this.uU, this.uV, this.uW);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ft
 * JD-Core Version:    0.7.0.1
 */