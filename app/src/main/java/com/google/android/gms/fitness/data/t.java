package com.google.android.gms.fitness.data;

import java.util.List;

public class t
{
  public static <T> int a(T paramT, List<T> paramList)
  {
    int i;
    if (paramT == null) {
      i = -1;
    }
    do
    {
      return i;
      i = paramList.indexOf(paramT);
    } while (i >= 0);
    paramList.add(paramT);
    return -1 + paramList.size();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.t
 * JD-Core Version:    0.7.0.1
 */