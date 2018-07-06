package com.google.android.gms.internal;

import java.util.ArrayList;

public final class la
{
  public static <T> int a(T[] paramArrayOfT, T paramT)
  {
    int i = 0;
    int j;
    if (paramArrayOfT != null) {
      j = paramArrayOfT.length;
    }
    while (i < j) {
      if (jv.equal(paramArrayOfT[i], paramT))
      {
        return i;
        j = 0;
        i = 0;
      }
      else
      {
        i++;
      }
    }
    return -1;
  }
  
  public static void a(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int i = paramArrayOfDouble.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[j]));
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int i = paramArrayOfFloat.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[j]));
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Integer.toString(paramArrayOfInt[j]));
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int i = paramArrayOfLong.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Long.toString(paramArrayOfLong[j]));
    }
  }
  
  public static <T> void a(StringBuilder paramStringBuilder, T[] paramArrayOfT)
  {
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(paramArrayOfT[j].toString());
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append("\"").append(paramArrayOfString[j]).append("\"");
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int i = paramArrayOfBoolean.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[j]));
    }
  }
  
  public static Integer[] a(int[] paramArrayOfInt)
  {
    Integer[] arrayOfInteger;
    if (paramArrayOfInt == null) {
      arrayOfInteger = null;
    }
    for (;;)
    {
      return arrayOfInteger;
      int i = paramArrayOfInt.length;
      arrayOfInteger = new Integer[i];
      for (int j = 0; j < i; j++) {
        arrayOfInteger[j] = Integer.valueOf(paramArrayOfInt[j]);
      }
    }
  }
  
  public static <T> ArrayList<T> b(T[] paramArrayOfT)
  {
    int i = paramArrayOfT.length;
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList.add(paramArrayOfT[j]);
    }
    return localArrayList;
  }
  
  public static <T> boolean b(T[] paramArrayOfT, T paramT)
  {
    return a(paramArrayOfT, paramT) >= 0;
  }
  
  public static <T> ArrayList<T> ie()
  {
    return new ArrayList();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.la
 * JD-Core Version:    0.7.0.1
 */