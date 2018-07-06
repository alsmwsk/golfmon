package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawBucket> CREATOR = new m();
  final int CK;
  final long LW;
  final long TO;
  final Session TQ;
  final int UI;
  final List<RawDataSet> Ua;
  final int Ub;
  final boolean Uc;
  
  RawBucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<RawDataSet> paramList, int paramInt3, boolean paramBoolean)
  {
    this.CK = paramInt1;
    this.LW = paramLong1;
    this.TO = paramLong2;
    this.TQ = paramSession;
    this.UI = paramInt2;
    this.Ua = paramList;
    this.Ub = paramInt3;
    this.Uc = paramBoolean;
  }
  
  public RawBucket(Bucket paramBucket, List<DataSource> paramList, List<DataType> paramList1)
  {
    this.CK = 2;
    this.LW = paramBucket.getStartTime(TimeUnit.MILLISECONDS);
    this.TO = paramBucket.getEndTime(TimeUnit.MILLISECONDS);
    this.TQ = paramBucket.getSession();
    this.UI = paramBucket.jm();
    this.Ub = paramBucket.getBucketType();
    this.Uc = paramBucket.jn();
    List localList = paramBucket.getDataSets();
    this.Ua = new ArrayList(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      this.Ua.add(new RawDataSet(localDataSet, paramList, paramList1));
    }
  }
  
  private boolean a(RawBucket paramRawBucket)
  {
    return (this.LW == paramRawBucket.LW) && (this.TO == paramRawBucket.TO) && (this.UI == paramRawBucket.UI) && (jv.equal(this.Ua, paramRawBucket.Ua)) && (this.Ub == paramRawBucket.Ub) && (this.Uc == paramRawBucket.Uc);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawBucket)) && (a((RawBucket)paramObject)));
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Long.valueOf(this.LW);
    arrayOfObject[1] = Long.valueOf(this.TO);
    arrayOfObject[2] = Integer.valueOf(this.Ub);
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("startTime", Long.valueOf(this.LW)).a("endTime", Long.valueOf(this.TO)).a("activity", Integer.valueOf(this.UI)).a("dataSets", this.Ua).a("bucketType", Integer.valueOf(this.Ub)).a("serverHasMoreData", Boolean.valueOf(this.Uc)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.RawBucket
 * JD-Core Version:    0.7.0.1
 */