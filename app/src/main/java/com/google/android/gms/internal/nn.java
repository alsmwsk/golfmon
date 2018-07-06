package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class nn
  implements SafeParcelable, Geofence
{
  public static final no CREATOR = new no();
  private final int CK;
  private final String Zt;
  private final int agd;
  private final short agf;
  private final double agg;
  private final double agh;
  private final float agi;
  private final int agj;
  private final int agk;
  private final long ahl;
  
  public nn(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    cb(paramString);
    b(paramFloat);
    a(paramDouble1, paramDouble2);
    int i = eH(paramInt2);
    this.CK = paramInt1;
    this.agf = paramShort;
    this.Zt = paramString;
    this.agg = paramDouble1;
    this.agh = paramDouble2;
    this.agi = paramFloat;
    this.ahl = paramLong;
    this.agd = i;
    this.agj = paramInt3;
    this.agk = paramInt4;
  }
  
  public nn(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
  }
  
  private static void a(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
      throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
    }
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
    }
  }
  
  private static void b(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
    }
  }
  
  private static void cb(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
    }
  }
  
  private static int eH(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  private static String eI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  public static nn h(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    nn localnn = CREATOR.cN(localParcel);
    localParcel.recycle();
    return localnn;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    nn localnn;
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof nn)) {
        return false;
      }
      localnn = (nn)paramObject;
      if (this.agi != localnn.agi) {
        return false;
      }
      if (this.agg != localnn.agg) {
        return false;
      }
      if (this.agh != localnn.agh) {
        return false;
      }
    } while (this.agf == localnn.agf);
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.ahl;
  }
  
  public double getLatitude()
  {
    return this.agg;
  }
  
  public double getLongitude()
  {
    return this.agh;
  }
  
  public int getNotificationResponsiveness()
  {
    return this.agj;
  }
  
  public String getRequestId()
  {
    return this.Zt;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.agg);
    int i = 31 + (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.agh);
    return 31 * (31 * (31 * (i * 31 + (int)(l2 ^ l2 >>> 32)) + Float.floatToIntBits(this.agi)) + this.agf) + this.agd;
  }
  
  public short nn()
  {
    return this.agf;
  }
  
  public float no()
  {
    return this.agi;
  }
  
  public int np()
  {
    return this.agd;
  }
  
  public int nq()
  {
    return this.agk;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = eI(this.agf);
    arrayOfObject[1] = this.Zt;
    arrayOfObject[2] = Integer.valueOf(this.agd);
    arrayOfObject[3] = Double.valueOf(this.agg);
    arrayOfObject[4] = Double.valueOf(this.agh);
    arrayOfObject[5] = Float.valueOf(this.agi);
    arrayOfObject[6] = Integer.valueOf(this.agj / 1000);
    arrayOfObject[7] = Integer.valueOf(this.agk);
    arrayOfObject[8] = Long.valueOf(this.ahl);
    return String.format(localLocale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    no.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nn
 * JD-Core Version:    0.7.0.1
 */