package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawDataPoint> CREATOR = new n();
  final int CK;
  final int UJ;
  final int UK;
  final long Ud;
  final long Ue;
  final Value[] Uf;
  final long Uh;
  final long Ui;
  
  RawDataPoint(int paramInt1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    this.CK = paramInt1;
    this.Ud = paramLong1;
    this.Ue = paramLong2;
    this.UJ = paramInt2;
    this.UK = paramInt3;
    this.Uh = paramLong3;
    this.Ui = paramLong4;
    this.Uf = paramArrayOfValue;
  }
  
  RawDataPoint(DataPoint paramDataPoint, List<DataSource> paramList)
  {
    this.CK = 4;
    this.Ud = paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS);
    this.Ue = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
    this.Uf = paramDataPoint.jr();
    this.UJ = t.a(paramDataPoint.getDataSource(), paramList);
    this.UK = t.a(paramDataPoint.getOriginalDataSource(), paramList);
    this.Uh = paramDataPoint.js();
    this.Ui = paramDataPoint.jt();
  }
  
  private boolean a(RawDataPoint paramRawDataPoint)
  {
    return (this.Ud == paramRawDataPoint.Ud) && (this.Ue == paramRawDataPoint.Ue) && (Arrays.equals(this.Uf, paramRawDataPoint.Uf)) && (this.UJ == paramRawDataPoint.UJ) && (this.UK == paramRawDataPoint.UK) && (this.Uh == paramRawDataPoint.Uh);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawDataPoint)) && (a((RawDataPoint)paramObject)));
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(this.Ud);
    arrayOfObject[1] = Long.valueOf(this.Ue);
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Arrays.toString(this.Uf);
    arrayOfObject[1] = Long.valueOf(this.Ue);
    arrayOfObject[2] = Long.valueOf(this.Ud);
    arrayOfObject[3] = Integer.valueOf(this.UJ);
    arrayOfObject[4] = Integer.valueOf(this.UK);
    return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.RawDataPoint
 * JD-Core Version:    0.7.0.1
 */