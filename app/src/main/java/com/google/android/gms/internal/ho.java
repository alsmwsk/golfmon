package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class ho
{
  private static final String[] Df;
  private static final Map<String, Integer> Dg;
  
  static
  {
    int i = 0;
    Df = new String[] { "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity" };
    Dg = new HashMap(Df.length);
    while (i < Df.length)
    {
      Dg.put(Df[i], Integer.valueOf(i));
      i++;
    }
  }
  
  public static String P(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= Df.length)) {
      return null;
    }
    return Df[paramInt];
  }
  
  public static int as(String paramString)
  {
    Integer localInteger = (Integer)Dg.get(paramString);
    if (localInteger == null) {
      throw new IllegalArgumentException("[" + paramString + "] is not a valid global search section name");
    }
    return localInteger.intValue();
  }
  
  public static int fF()
  {
    return Df.length;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ho
 * JD-Core Version:    0.7.0.1
 */