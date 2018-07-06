package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ey
class fu
{
  private int tq;
  private final List<String> uX;
  private final List<String> uY;
  private final String uZ;
  private final String va;
  private final String vb;
  private final String vc;
  private final boolean vd;
  private final int ve;
  private String vf;
  
  public fu(int paramInt, Map<String, String> paramMap)
  {
    this.vf = ((String)paramMap.get("url"));
    this.va = ((String)paramMap.get("base_uri"));
    this.vb = ((String)paramMap.get("post_parameters"));
    this.vd = parseBoolean((String)paramMap.get("drt_include"));
    this.uZ = ((String)paramMap.get("activation_overlay_url"));
    this.uY = J((String)paramMap.get("check_packages"));
    this.ve = parseInt((String)paramMap.get("request_id"));
    this.vc = ((String)paramMap.get("type"));
    this.uX = J((String)paramMap.get("errors"));
    this.tq = paramInt;
  }
  
  private List<String> J(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Arrays.asList(paramString.split(","));
  }
  
  private static boolean parseBoolean(String paramString)
  {
    return (paramString != null) && ((paramString.equals("1")) || (paramString.equals("true")));
  }
  
  private int parseInt(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    return Integer.parseInt(paramString);
  }
  
  public List<String> cT()
  {
    return this.uX;
  }
  
  public String cU()
  {
    return this.vb;
  }
  
  public boolean cV()
  {
    return this.vd;
  }
  
  public int getErrorCode()
  {
    return this.tq;
  }
  
  public String getType()
  {
    return this.vc;
  }
  
  public String getUrl()
  {
    return this.vf;
  }
  
  public void setUrl(String paramString)
  {
    this.vf = paramString;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fu
 * JD-Core Version:    0.7.0.1
 */