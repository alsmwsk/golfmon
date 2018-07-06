package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class af
{
  private final Map<String, Integer> BO = new HashMap();
  private final Map<String, String> BP = new HashMap();
  private final boolean BQ;
  private final String BR;
  
  public af(String paramString, boolean paramBoolean)
  {
    this.BQ = paramBoolean;
    this.BR = paramString;
  }
  
  public void e(String paramString, int paramInt)
  {
    if (!this.BQ) {
      return;
    }
    Integer localInteger = (Integer)this.BO.get(paramString);
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    this.BO.put(paramString, Integer.valueOf(paramInt + localInteger.intValue()));
  }
  
  public String fg()
  {
    if (!this.BQ) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.BR);
    Iterator localIterator1 = this.BO.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str2 = (String)localIterator1.next();
      localStringBuilder.append("&").append(str2).append("=").append(this.BO.get(str2));
    }
    Iterator localIterator2 = this.BP.keySet().iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      localStringBuilder.append("&").append(str1).append("=").append((String)this.BP.get(str1));
    }
    return localStringBuilder.toString();
  }
  
  public void g(String paramString1, String paramString2)
  {
    if ((!this.BQ) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    this.BP.put(paramString1, paramString2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.af
 * JD-Core Version:    0.7.0.1
 */