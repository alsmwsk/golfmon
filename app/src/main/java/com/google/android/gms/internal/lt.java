package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class lt
{
  private static final List<TimeUnit> TS;
  
  static
  {
    TimeUnit[] arrayOfTimeUnit = new TimeUnit[7];
    arrayOfTimeUnit[0] = TimeUnit.NANOSECONDS;
    arrayOfTimeUnit[1] = TimeUnit.MICROSECONDS;
    arrayOfTimeUnit[2] = TimeUnit.MILLISECONDS;
    arrayOfTimeUnit[3] = TimeUnit.SECONDS;
    arrayOfTimeUnit[4] = TimeUnit.MINUTES;
    arrayOfTimeUnit[5] = TimeUnit.HOURS;
    arrayOfTimeUnit[6] = TimeUnit.DAYS;
    TS = Arrays.asList(arrayOfTimeUnit);
  }
  
  public static long a(long paramLong, TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
  {
    return paramTimeUnit1.convert(paramTimeUnit2.convert(paramLong, paramTimeUnit1), paramTimeUnit2);
  }
  
  public static boolean a(TimeUnit paramTimeUnit)
  {
    return a(paramTimeUnit, TimeUnit.MILLISECONDS);
  }
  
  private static boolean a(TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
  {
    return TS.indexOf(paramTimeUnit1) < TS.indexOf(paramTimeUnit2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lt
 * JD-Core Version:    0.7.0.1
 */