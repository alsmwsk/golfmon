package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class ny
  implements SafeParcelable
{
  public static final nz CREATOR = new nz();
  public static final long ahz = TimeUnit.HOURS.toMillis(1L);
  final int CK;
  private final long agr;
  private final nu ahA;
  private final int mPriority;
  
  public ny(int paramInt1, nu paramnu, long paramLong, int paramInt2)
  {
    this.CK = paramInt1;
    this.ahA = paramnu;
    this.agr = paramLong;
    this.mPriority = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    ny localny;
    do
    {
      return true;
      if (!(paramObject instanceof ny)) {
        return false;
      }
      localny = (ny)paramObject;
    } while ((jv.equal(this.ahA, localny.ahA)) && (this.agr == localny.agr) && (this.mPriority == localny.mPriority));
    return false;
  }
  
  public long getInterval()
  {
    return this.agr;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.ahA;
    arrayOfObject[1] = Long.valueOf(this.agr);
    arrayOfObject[2] = Integer.valueOf(this.mPriority);
    return jv.hashCode(arrayOfObject);
  }
  
  public nu nt()
  {
    return this.ahA;
  }
  
  public String toString()
  {
    return jv.h(this).a("filter", this.ahA).a("interval", Long.valueOf(this.agr)).a("priority", Integer.valueOf(this.mPriority)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nz.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ny
 * JD-Core Version:    0.7.0.1
 */