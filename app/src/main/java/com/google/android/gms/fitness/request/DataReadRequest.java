package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DataReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataReadRequest> CREATOR = new g();
  public static final int NO_LIMIT;
  private final int CK;
  private final long LW;
  private final long TO;
  private final List<DataType> TY;
  private final int Ub;
  private final List<DataSource> VH;
  private final List<DataType> VL;
  private final List<DataSource> VM;
  private final long VN;
  private final DataSource VO;
  private final int VP;
  private final boolean VQ;
  private final boolean VR;
  
  DataReadRequest(int paramInt1, List<DataType> paramList1, List<DataSource> paramList2, long paramLong1, long paramLong2, List<DataType> paramList3, List<DataSource> paramList4, int paramInt2, long paramLong3, DataSource paramDataSource, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.CK = paramInt1;
    this.TY = Collections.unmodifiableList(paramList1);
    this.VH = Collections.unmodifiableList(paramList2);
    this.LW = paramLong1;
    this.TO = paramLong2;
    this.VL = Collections.unmodifiableList(paramList3);
    this.VM = Collections.unmodifiableList(paramList4);
    this.Ub = paramInt2;
    this.VN = paramLong3;
    this.VO = paramDataSource;
    this.VP = paramInt3;
    this.VQ = paramBoolean1;
    this.VR = paramBoolean2;
  }
  
  private DataReadRequest(Builder paramBuilder)
  {
    this.CK = 2;
    this.TY = Collections.unmodifiableList(Builder.a(paramBuilder));
    this.VH = Collections.unmodifiableList(Builder.b(paramBuilder));
    this.LW = Builder.c(paramBuilder);
    this.TO = Builder.d(paramBuilder);
    this.VL = Collections.unmodifiableList(Builder.e(paramBuilder));
    this.VM = Collections.unmodifiableList(Builder.f(paramBuilder));
    this.Ub = Builder.g(paramBuilder);
    this.VN = Builder.h(paramBuilder);
    this.VO = Builder.i(paramBuilder);
    this.VP = Builder.j(paramBuilder);
    this.VQ = Builder.k(paramBuilder);
    this.VR = Builder.l(paramBuilder);
  }
  
  private boolean a(DataReadRequest paramDataReadRequest)
  {
    return (this.TY.equals(paramDataReadRequest.TY)) && (this.VH.equals(paramDataReadRequest.VH)) && (this.LW == paramDataReadRequest.LW) && (this.TO == paramDataReadRequest.TO) && (this.Ub == paramDataReadRequest.Ub) && (this.VM.equals(paramDataReadRequest.VM)) && (this.VL.equals(paramDataReadRequest.VL)) && (jv.equal(this.VO, paramDataReadRequest.VO)) && (this.VN == paramDataReadRequest.VN) && (this.VR == paramDataReadRequest.VR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataReadRequest)) && (a((DataReadRequest)paramObject)));
  }
  
  public DataSource getActivityDataSource()
  {
    return this.VO;
  }
  
  public List<DataSource> getAggregatedDataSources()
  {
    return this.VM;
  }
  
  public List<DataType> getAggregatedDataTypes()
  {
    return this.VL;
  }
  
  public long getBucketDuration(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.VN, TimeUnit.MILLISECONDS);
  }
  
  public int getBucketType()
  {
    return this.Ub;
  }
  
  public List<DataSource> getDataSources()
  {
    return this.VH;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.TY;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
  }
  
  public int getLimit()
  {
    return this.VP;
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
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.Ub);
    arrayOfObject[1] = Long.valueOf(this.LW);
    arrayOfObject[2] = Long.valueOf(this.TO);
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean jV()
  {
    return this.VR;
  }
  
  public boolean jW()
  {
    return this.VQ;
  }
  
  public long jX()
  {
    return this.VN;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataReadRequest{");
    if (!this.TY.isEmpty())
    {
      Iterator localIterator4 = this.TY.iterator();
      while (localIterator4.hasNext()) {
        localStringBuilder.append(((DataType)localIterator4.next()).jB()).append(" ");
      }
    }
    if (!this.VH.isEmpty())
    {
      Iterator localIterator3 = this.VH.iterator();
      while (localIterator3.hasNext()) {
        localStringBuilder.append(((DataSource)localIterator3.next()).toDebugString()).append(" ");
      }
    }
    if (this.Ub != 0)
    {
      localStringBuilder.append("bucket by ").append(Bucket.cJ(this.Ub));
      if (this.VN > 0L) {
        localStringBuilder.append(" >").append(this.VN).append("ms");
      }
      localStringBuilder.append(": ");
    }
    if (!this.VL.isEmpty())
    {
      Iterator localIterator2 = this.VL.iterator();
      while (localIterator2.hasNext()) {
        localStringBuilder.append(((DataType)localIterator2.next()).jB()).append(" ");
      }
    }
    if (!this.VM.isEmpty())
    {
      Iterator localIterator1 = this.VM.iterator();
      while (localIterator1.hasNext()) {
        localStringBuilder.append(((DataSource)localIterator1.next()).toDebugString()).append(" ");
      }
    }
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(this.LW);
    arrayOfObject[1] = Long.valueOf(this.LW);
    arrayOfObject[2] = Long.valueOf(this.TO);
    arrayOfObject[3] = Long.valueOf(this.TO);
    localStringBuilder.append(String.format("(%tF %tT - %tF %tT)", arrayOfObject));
    if (this.VO != null) {
      localStringBuilder.append("activities: ").append(this.VO.toDebugString());
    }
    if (this.VR) {
      localStringBuilder.append(" +server");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long LW;
    private long TO;
    private List<DataType> TY = new ArrayList();
    private int Ub = 0;
    private List<DataSource> VH = new ArrayList();
    private List<DataType> VL = new ArrayList();
    private List<DataSource> VM = new ArrayList();
    private long VN = 0L;
    private DataSource VO;
    private int VP = 0;
    private boolean VQ = false;
    private boolean VR = false;
    
    public Builder aggregate(DataSource paramDataSource, DataType paramDataType)
    {
      jx.b(paramDataSource, "Attempting to add a null data source");
      if (!this.VH.contains(paramDataSource)) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "Cannot add the same data source for aggregated and detailed");
        DataType localDataType = paramDataSource.getDataType();
        jx.b(DataType.AGGREGATE_INPUT_TYPES.contains(localDataType), "Unsupported input data type specified for aggregation: %s", new Object[] { localDataType });
        jx.b(DataType.getAggregatesForInput(localDataType).contains(paramDataType), "Invalid output aggregate data type specified: %s -> %s", new Object[] { localDataType, paramDataType });
        if (!this.VM.contains(paramDataSource)) {
          this.VM.add(paramDataSource);
        }
        return this;
      }
    }
    
    public Builder aggregate(DataType paramDataType1, DataType paramDataType2)
    {
      jx.b(paramDataType1, "Attempting to use a null data type");
      if (!this.TY.contains(paramDataType1)) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "Cannot add the same data type as aggregated and detailed");
        jx.b(DataType.AGGREGATE_INPUT_TYPES.contains(paramDataType1), "Unsupported input data type specified for aggregation: %s", new Object[] { paramDataType1 });
        jx.b(DataType.getAggregatesForInput(paramDataType1).contains(paramDataType2), "Invalid output aggregate data type specified: %s -> %s", new Object[] { paramDataType1, paramDataType2 });
        if (!this.VL.contains(paramDataType1)) {
          this.VL.add(paramDataType1);
        }
        return this;
      }
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool1;
      if (this.Ub == 0)
      {
        bool1 = true;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(this.Ub);
        jx.b(bool1, "Bucketing strategy already set to %s", arrayOfObject1);
        if (paramInt <= 0) {
          break label86;
        }
      }
      label86:
      for (boolean bool2 = true;; bool2 = false)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt);
        jx.b(bool2, "Must specify a valid minimum duration for an activity segment: %d", arrayOfObject2);
        this.Ub = 4;
        this.VN = paramTimeUnit.toMillis(paramInt);
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      boolean bool1;
      boolean bool2;
      if (this.Ub == 0)
      {
        bool1 = true;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(this.Ub);
        jx.b(bool1, "Bucketing strategy already set to %s", arrayOfObject1);
        if (paramInt <= 0) {
          break label131;
        }
        bool2 = true;
        label43:
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt);
        jx.b(bool2, "Must specify a valid minimum duration for an activity segment: %d", arrayOfObject2);
        if (paramDataSource == null) {
          break label137;
        }
      }
      label131:
      label137:
      for (boolean bool3 = true;; bool3 = false)
      {
        jx.b(bool3, "Invalid activity data source specified");
        jx.b(paramDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
        this.VO = paramDataSource;
        this.Ub = 4;
        this.VN = paramTimeUnit.toMillis(paramInt);
        return this;
        bool1 = false;
        break;
        bool2 = false;
        break label43;
      }
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool1;
      if (this.Ub == 0)
      {
        bool1 = true;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(this.Ub);
        jx.b(bool1, "Bucketing strategy already set to %s", arrayOfObject1);
        if (paramInt <= 0) {
          break label86;
        }
      }
      label86:
      for (boolean bool2 = true;; bool2 = false)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt);
        jx.b(bool2, "Must specify a valid minimum duration for an activity segment: %d", arrayOfObject2);
        this.Ub = 3;
        this.VN = paramTimeUnit.toMillis(paramInt);
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      boolean bool1;
      boolean bool2;
      if (this.Ub == 0)
      {
        bool1 = true;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(this.Ub);
        jx.b(bool1, "Bucketing strategy already set to %s", arrayOfObject1);
        if (paramInt <= 0) {
          break label131;
        }
        bool2 = true;
        label43:
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt);
        jx.b(bool2, "Must specify a valid minimum duration for an activity segment: %d", arrayOfObject2);
        if (paramDataSource == null) {
          break label137;
        }
      }
      label131:
      label137:
      for (boolean bool3 = true;; bool3 = false)
      {
        jx.b(bool3, "Invalid activity data source specified");
        jx.b(paramDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
        this.VO = paramDataSource;
        this.Ub = 3;
        this.VN = paramTimeUnit.toMillis(paramInt);
        return this;
        bool1 = false;
        break;
        bool2 = false;
        break label43;
      }
    }
    
    public Builder bucketBySession(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool1;
      if (this.Ub == 0)
      {
        bool1 = true;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(this.Ub);
        jx.b(bool1, "Bucketing strategy already set to %s", arrayOfObject1);
        if (paramInt <= 0) {
          break label86;
        }
      }
      label86:
      for (boolean bool2 = true;; bool2 = false)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt);
        jx.b(bool2, "Must specify a valid minimum duration for an activity segment: %d", arrayOfObject2);
        this.Ub = 2;
        this.VN = paramTimeUnit.toMillis(paramInt);
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder bucketByTime(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool1;
      if (this.Ub == 0)
      {
        bool1 = true;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(this.Ub);
        jx.b(bool1, "Bucketing strategy already set to %s", arrayOfObject1);
        if (paramInt <= 0) {
          break label86;
        }
      }
      label86:
      for (boolean bool2 = true;; bool2 = false)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt);
        jx.b(bool2, "Must specify a valid minimum duration for an activity segment: %d", arrayOfObject2);
        this.Ub = 1;
        this.VN = paramTimeUnit.toMillis(paramInt);
        return this;
        bool1 = false;
        break;
      }
    }
    
    public DataReadRequest build()
    {
      boolean bool1 = true;
      boolean bool2;
      boolean bool3;
      label69:
      boolean bool4;
      label118:
      boolean bool5;
      if ((!this.VH.isEmpty()) || (!this.TY.isEmpty()) || (!this.VM.isEmpty()) || (!this.VL.isEmpty()))
      {
        bool2 = bool1;
        jx.a(bool2, "Must add at least one data source (aggregated or detailed)");
        if (this.LW <= 0L) {
          break label216;
        }
        bool3 = bool1;
        Object[] arrayOfObject1 = new Object[bool1];
        arrayOfObject1[0] = Long.valueOf(this.LW);
        jx.a(bool3, "Invalid start time: %s", arrayOfObject1);
        if ((this.TO <= 0L) || (this.TO <= this.LW)) {
          break label221;
        }
        bool4 = bool1;
        Object[] arrayOfObject2 = new Object[bool1];
        arrayOfObject2[0] = Long.valueOf(this.TO);
        jx.a(bool4, "Invalid end time: %s", arrayOfObject2);
        if ((!this.VM.isEmpty()) || (!this.VL.isEmpty())) {
          break label227;
        }
        bool5 = bool1;
        label171:
        if (((!bool5) || (this.Ub != 0)) && ((bool5) || (this.Ub == 0))) {
          break label233;
        }
      }
      for (;;)
      {
        jx.a(bool1, "Must specify a valid bucketing strategy while requesting aggregation");
        return new DataReadRequest(this, null);
        bool2 = false;
        break;
        label216:
        bool3 = false;
        break label69;
        label221:
        bool4 = false;
        break label118;
        label227:
        bool5 = false;
        break label171;
        label233:
        bool1 = false;
      }
    }
    
    public Builder enableServerQueries()
    {
      this.VR = true;
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      jx.b(paramDataSource, "Attempting to add a null data source");
      if (!this.VM.contains(paramDataSource)) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Cannot add the same data source as aggregated and detailed");
        if (!this.VH.contains(paramDataSource)) {
          this.VH.add(paramDataSource);
        }
        return this;
      }
    }
    
    public Builder read(DataType paramDataType)
    {
      jx.b(paramDataType, "Attempting to use a null data type");
      if (!this.VL.contains(paramDataType)) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "Cannot add the same data type as aggregated and detailed");
        if (!this.TY.contains(paramDataType)) {
          this.TY.add(paramDataType);
        }
        return this;
      }
    }
    
    public Builder setLimit(int paramInt)
    {
      if (paramInt > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        jx.b(bool, "Invalid limit %d is specified", arrayOfObject);
        this.VP = paramInt;
        return this;
      }
    }
    
    public Builder setTimeRange(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.LW = paramTimeUnit.toMillis(paramLong1);
      this.TO = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.DataReadRequest
 * JD-Core Version:    0.7.0.1
 */