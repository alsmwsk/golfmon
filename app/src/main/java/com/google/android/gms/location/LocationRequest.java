package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class LocationRequest
  implements SafeParcelable
{
  public static final d CREATOR = new d();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  private final int CK;
  boolean Wg;
  long age;
  long agr;
  long ags;
  int agt;
  float agu;
  long agv;
  int mPriority;
  
  public LocationRequest()
  {
    this.CK = 1;
    this.mPriority = 102;
    this.agr = 3600000L;
    this.ags = 600000L;
    this.Wg = false;
    this.age = 9223372036854775807L;
    this.agt = 2147483647;
    this.agu = 0.0F;
    this.agv = 0L;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat, long paramLong4)
  {
    this.CK = paramInt1;
    this.mPriority = paramInt2;
    this.agr = paramLong1;
    this.ags = paramLong2;
    this.Wg = paramBoolean;
    this.age = paramLong3;
    this.agt = paramInt3;
    this.agu = paramFloat;
    this.agv = paramLong4;
  }
  
  private static void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("invalid displacement: " + paramFloat);
    }
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  private static void ey(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException("invalid quality: " + paramInt);
    }
  }
  
  public static String ez(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      return "???";
    case 100: 
      return "PRIORITY_HIGH_ACCURACY";
    case 102: 
      return "PRIORITY_BALANCED_POWER_ACCURACY";
    case 104: 
      return "PRIORITY_LOW_POWER";
    }
    return "PRIORITY_NO_POWER";
  }
  
  private static void v(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("invalid interval: " + paramLong);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    LocationRequest localLocationRequest;
    do
    {
      return true;
      if (!(paramObject instanceof LocationRequest)) {
        return false;
      }
      localLocationRequest = (LocationRequest)paramObject;
    } while ((this.mPriority == localLocationRequest.mPriority) && (this.agr == localLocationRequest.agr) && (this.ags == localLocationRequest.ags) && (this.Wg == localLocationRequest.Wg) && (this.age == localLocationRequest.age) && (this.agt == localLocationRequest.agt) && (this.agu == localLocationRequest.agu));
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.age;
  }
  
  public long getFastestInterval()
  {
    return this.ags;
  }
  
  public long getInterval()
  {
    return this.agr;
  }
  
  public int getNumUpdates()
  {
    return this.agt;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public float getSmallestDisplacement()
  {
    return this.agu;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.mPriority);
    arrayOfObject[1] = Long.valueOf(this.agr);
    arrayOfObject[2] = Long.valueOf(this.ags);
    arrayOfObject[3] = Boolean.valueOf(this.Wg);
    arrayOfObject[4] = Long.valueOf(this.age);
    arrayOfObject[5] = Integer.valueOf(this.agt);
    arrayOfObject[6] = Float.valueOf(this.agu);
    return jv.hashCode(arrayOfObject);
  }
  
  public LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > 9223372036854775807L - l) {}
    for (this.age = 9223372036854775807L;; this.age = (l + paramLong))
    {
      if (this.age < 0L) {
        this.age = 0L;
      }
      return this;
    }
  }
  
  public LocationRequest setExpirationTime(long paramLong)
  {
    this.age = paramLong;
    if (this.age < 0L) {
      this.age = 0L;
    }
    return this;
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    v(paramLong);
    this.Wg = true;
    this.ags = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    v(paramLong);
    this.agr = paramLong;
    if (!this.Wg) {
      this.ags = ((this.agr / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("invalid numUpdates: " + paramInt);
    }
    this.agt = paramInt;
    return this;
  }
  
  public LocationRequest setPriority(int paramInt)
  {
    ey(paramInt);
    this.mPriority = paramInt;
    return this;
  }
  
  public LocationRequest setSmallestDisplacement(float paramFloat)
  {
    a(paramFloat);
    this.agu = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(ez(this.mPriority));
    if (this.mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.agr + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.ags + "ms");
    if (this.age != 9223372036854775807L)
    {
      long l = this.age - SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l + "ms");
    }
    if (this.agt != 2147483647) {
      localStringBuilder.append(" num=").append(this.agt);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationRequest
 * JD-Core Version:    0.7.0.1
 */