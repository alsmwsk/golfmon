package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.c;

public abstract class AbstractFilter
  implements Filter
{
  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a(new c());
    return String.format("Filter[%s]", arrayOfObject);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.AbstractFilter
 * JD-Core Version:    0.7.0.1
 */