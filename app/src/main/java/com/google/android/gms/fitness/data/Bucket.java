package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket
  implements SafeParcelable
{
  public static final Parcelable.Creator<Bucket> CREATOR = new d();
  public static final int TYPE_ACTIVITY_SEGMENT = 4;
  public static final int TYPE_ACTIVITY_TYPE = 3;
  public static final int TYPE_SESSION = 2;
  public static final int TYPE_TIME = 1;
  private final int CK;
  private final long LW;
  private final long TO;
  private final Session TQ;
  private final int TZ;
  private final List<DataSet> Ua;
  private final int Ub;
  private boolean Uc = false;
  
  Bucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<DataSet> paramList, int paramInt3, boolean paramBoolean)
  {
    this.CK = paramInt1;
    this.LW = paramLong1;
    this.TO = paramLong2;
    this.TQ = paramSession;
    this.TZ = paramInt2;
    this.Ua = paramList;
    this.Ub = paramInt3;
    this.Uc = paramBoolean;
  }
  
  public Bucket(RawBucket paramRawBucket, List<DataSource> paramList, List<DataType> paramList1)
  {
    this(2, paramRawBucket.LW, paramRawBucket.TO, paramRawBucket.TQ, paramRawBucket.UI, a(paramRawBucket.Ua, paramList, paramList1), paramRawBucket.Ub, paramRawBucket.Uc);
  }
  
  private static List<DataSet> a(List<RawDataSet> paramList, List<DataSource> paramList1, List<DataType> paramList2)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new DataSet((RawDataSet)localIterator.next(), paramList1, paramList2));
    }
    return localArrayList;
  }
  
  private boolean a(Bucket paramBucket)
  {
    return (this.LW == paramBucket.LW) && (this.TO == paramBucket.TO) && (this.TZ == paramBucket.TZ) && (jv.equal(this.Ua, paramBucket.Ua)) && (this.Ub == paramBucket.Ub) && (this.Uc == paramBucket.Uc);
  }
  
  public static String cJ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "bug";
    case 1: 
      return "time";
    case 3: 
      return "type";
    case 4: 
      return "segment";
    case 2: 
      return "session";
    }
    return "unknown";
  }
  
  public boolean b(Bucket paramBucket)
  {
    return (this.LW == paramBucket.LW) && (this.TO == paramBucket.TO) && (this.TZ == paramBucket.TZ) && (this.Ub == paramBucket.Ub);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Bucket)) && (a((Bucket)paramObject)));
  }
  
  public String getActivity()
  {
    return FitnessActivities.getName(this.TZ);
  }
  
  public int getBucketType()
  {
    return this.Ub;
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.Ua.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataType().equals(paramDataType)) {
        return localDataSet;
      }
    }
    return null;
  }
  
  public List<DataSet> getDataSets()
  {
    return this.Ua;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
  }
  
  public Session getSession()
  {
    return this.TQ;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(this.LW);
    arrayOfObject[1] = Long.valueOf(this.TO);
    arrayOfObject[2] = Integer.valueOf(this.TZ);
    arrayOfObject[3] = Integer.valueOf(this.Ub);
    return jv.hashCode(arrayOfObject);
  }
  
  public int jm()
  {
    return this.TZ;
  }
  
  public boolean jn()
  {
    if (this.Uc) {
      return true;
    }
    Iterator localIterator = this.Ua.iterator();
    while (localIterator.hasNext()) {
      if (((DataSet)localIterator.next()).jn()) {
        return true;
      }
    }
    return false;
  }
  
  public long jo()
  {
    return this.LW;
  }
  
  public long jp()
  {
    return this.TO;
  }
  
  public String toString()
  {
    return jv.h(this).a("startTime", Long.valueOf(this.LW)).a("endTime", Long.valueOf(this.TO)).a("activity", Integer.valueOf(this.TZ)).a("dataSets", this.Ua).a("bucketType", cJ(this.Ub)).a("serverHasMoreData", Boolean.valueOf(this.Uc)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.Bucket
 * JD-Core Version:    0.7.0.1
 */