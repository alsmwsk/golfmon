package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.k.a;
import com.google.android.gms.internal.jv;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class o
  implements SafeParcelable
{
  public static final Parcelable.Creator<o> CREATOR = new p();
  private final int CK;
  private final DataType TM;
  private final DataSource TN;
  private final long UQ;
  private final int UR;
  private k VW;
  int VX;
  int VY;
  private final long VZ;
  private final long Wa;
  private final List<LocationRequest> Wb;
  private final long Wc;
  private final List Wd;
  private final PendingIntent mPendingIntent;
  
  o(int paramInt1, DataSource paramDataSource, DataType paramDataType, IBinder paramIBinder, int paramInt2, int paramInt3, long paramLong1, long paramLong2, PendingIntent paramPendingIntent, long paramLong3, int paramInt4, List<LocationRequest> paramList, long paramLong4)
  {
    this.CK = paramInt1;
    this.TN = paramDataSource;
    this.TM = paramDataType;
    if (paramIBinder == null) {}
    for (k localk = null;; localk = k.a.aq(paramIBinder))
    {
      this.VW = localk;
      if (paramLong1 == 0L) {
        paramLong1 = paramInt2;
      }
      this.UQ = paramLong1;
      this.Wa = paramLong3;
      if (paramLong2 == 0L) {
        paramLong2 = paramInt3;
      }
      this.VZ = paramLong2;
      this.Wb = paramList;
      this.mPendingIntent = paramPendingIntent;
      this.UR = paramInt4;
      this.Wd = Collections.emptyList();
      this.Wc = paramLong4;
      return;
    }
  }
  
  private o(DataSource paramDataSource, DataType paramDataType, k paramk, PendingIntent paramPendingIntent, long paramLong1, long paramLong2, long paramLong3, int paramInt, List paramList1, List paramList2, long paramLong4)
  {
    this.CK = 4;
    this.TN = paramDataSource;
    this.TM = paramDataType;
    this.VW = paramk;
    this.mPendingIntent = paramPendingIntent;
    this.UQ = paramLong1;
    this.Wa = paramLong2;
    this.VZ = paramLong3;
    this.UR = paramInt;
    this.Wb = paramList1;
    this.Wd = paramList2;
    this.Wc = paramLong4;
  }
  
  public o(SensorRequest paramSensorRequest, k paramk, PendingIntent paramPendingIntent)
  {
    this(paramSensorRequest.getDataSource(), paramSensorRequest.getDataType(), paramk, paramPendingIntent, paramSensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), paramSensorRequest.getFastestRate(TimeUnit.MICROSECONDS), paramSensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), paramSensorRequest.getAccuracyMode(), null, Collections.emptyList(), paramSensorRequest.kh());
  }
  
  private boolean a(o paramo)
  {
    return (jv.equal(this.TN, paramo.TN)) && (jv.equal(this.TM, paramo.TM)) && (this.UQ == paramo.UQ) && (this.Wa == paramo.Wa) && (this.VZ == paramo.VZ) && (this.UR == paramo.UR) && (jv.equal(this.Wb, paramo.Wb));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof o)) && (a((o)paramObject)));
  }
  
  public int getAccuracyMode()
  {
    return this.UR;
  }
  
  public DataSource getDataSource()
  {
    return this.TN;
  }
  
  public DataType getDataType()
  {
    return this.TM;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = this.TN;
    arrayOfObject[1] = this.TM;
    arrayOfObject[2] = this.VW;
    arrayOfObject[3] = Long.valueOf(this.UQ);
    arrayOfObject[4] = Long.valueOf(this.Wa);
    arrayOfObject[5] = Long.valueOf(this.VZ);
    arrayOfObject[6] = Integer.valueOf(this.UR);
    arrayOfObject[7] = this.Wb;
    return jv.hashCode(arrayOfObject);
  }
  
  public long jI()
  {
    return this.UQ;
  }
  
  public PendingIntent kb()
  {
    return this.mPendingIntent;
  }
  
  public long kc()
  {
    return this.Wa;
  }
  
  public long kd()
  {
    return this.VZ;
  }
  
  public List<LocationRequest> ke()
  {
    return this.Wb;
  }
  
  public long kf()
  {
    return this.Wc;
  }
  
  IBinder kg()
  {
    if (this.VW == null) {
      return null;
    }
    return this.VW.asBinder();
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.TM;
    arrayOfObject[1] = this.TN;
    arrayOfObject[2] = Long.valueOf(this.UQ);
    arrayOfObject[3] = Long.valueOf(this.Wa);
    arrayOfObject[4] = Long.valueOf(this.VZ);
    return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.o
 * JD-Core Version:    0.7.0.1
 */