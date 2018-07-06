package com.google.android.gms.tagmanager;

class dh
  extends Number
  implements Comparable<dh>
{
  private double atZ;
  private long aua;
  private boolean aub;
  
  private dh(double paramDouble)
  {
    this.atZ = paramDouble;
    this.aub = false;
  }
  
  private dh(long paramLong)
  {
    this.aua = paramLong;
    this.aub = true;
  }
  
  public static dh a(Double paramDouble)
  {
    return new dh(paramDouble.doubleValue());
  }
  
  public static dh cY(String paramString)
    throws NumberFormatException
  {
    try
    {
      dh localdh1 = new dh(Long.parseLong(paramString));
      return localdh1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        dh localdh2 = new dh(Double.parseDouble(paramString));
        return localdh2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        throw new NumberFormatException(paramString + " is not a valid TypedNumber");
      }
    }
  }
  
  public static dh z(long paramLong)
  {
    return new dh(paramLong);
  }
  
  public int a(dh paramdh)
  {
    if ((qR()) && (paramdh.qR())) {
      return new Long(this.aua).compareTo(Long.valueOf(paramdh.aua));
    }
    return Double.compare(doubleValue(), paramdh.doubleValue());
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    if (qR()) {
      return this.aua;
    }
    return this.atZ;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof dh)) && (a((dh)paramObject) == 0);
  }
  
  public float floatValue()
  {
    return (float)doubleValue();
  }
  
  public int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public int intValue()
  {
    return qT();
  }
  
  public long longValue()
  {
    return qS();
  }
  
  public boolean qQ()
  {
    return !qR();
  }
  
  public boolean qR()
  {
    return this.aub;
  }
  
  public long qS()
  {
    if (qR()) {
      return this.aua;
    }
    return this.atZ;
  }
  
  public int qT()
  {
    return (int)longValue();
  }
  
  public short qU()
  {
    return (short)(int)longValue();
  }
  
  public short shortValue()
  {
    return qU();
  }
  
  public String toString()
  {
    if (qR()) {
      return Long.toString(this.aua);
    }
    return Double.toString(this.atZ);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.dh
 * JD-Core Version:    0.7.0.1
 */