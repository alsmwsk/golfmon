package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;

public class ls
{
  public static <T> boolean a(List<T> paramList1, List<T> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext()) {
      if (!paramList2.contains(localIterator.next())) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ls
 * JD-Core Version:    0.7.0.1
 */