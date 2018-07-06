package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.k.a;
import com.google.android.gms.internal.jv;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new a();
  public static final int UNSPECIFIED = -1;
  private final int CK;
  private final DataSource TN;
  private final k VW;
  private final long Wy;
  private final long Wz;
  
  FitnessSensorServiceRequest(int paramInt, DataSource paramDataSource, IBinder paramIBinder, long paramLong1, long paramLong2)
  {
    this.CK = paramInt;
    this.TN = paramDataSource;
    this.VW = k.a.aq(paramIBinder);
    this.Wy = paramLong1;
    this.Wz = paramLong2;
  }
  
  private boolean a(FitnessSensorServiceRequest paramFitnessSensorServiceRequest)
  {
    return (jv.equal(this.TN, paramFitnessSensorServiceRequest.TN)) && (this.Wy == paramFitnessSensorServiceRequest.Wy) && (this.Wz == paramFitnessSensorServiceRequest.Wz);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof FitnessSensorServiceRequest)) && (a((FitnessSensorServiceRequest)paramObject)));
  }
  
  public long getBatchInterval(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.Wz, TimeUnit.MICROSECONDS);
  }
  
  public DataSource getDataSource()
  {
    return this.TN;
  }
  
  public SensorEventDispatcher getDispatcher()
  {
    return new b(this.VW);
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    if (this.Wy == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(this.Wy, TimeUnit.MICROSECONDS);
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.TN;
    arrayOfObject[1] = Long.valueOf(this.Wy);
    arrayOfObject[2] = Long.valueOf(this.Wz);
    return jv.hashCode(arrayOfObject);
  }
  
  public long jI()
  {
    return this.Wy;
  }
  
  IBinder kg()
  {
    return this.VW.asBinder();
  }
  
  public long kx()
  {
    return this.Wz;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.TN;
    return String.format("FitnessSensorServiceRequest{%s}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.service.FitnessSensorServiceRequest
 * JD-Core Version:    0.7.0.1
 */