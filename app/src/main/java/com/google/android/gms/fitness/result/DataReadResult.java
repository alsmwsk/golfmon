package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReadResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataReadResult> CREATOR = new b();
  private final int CK;
  private final Status Eb;
  private final List<DataSet> Ua;
  private final List<DataSource> Uk;
  private final List<Bucket> Wr;
  private int Ws;
  private final List<DataType> Wt;
  
  DataReadResult(int paramInt1, List<RawDataSet> paramList, Status paramStatus, List<RawBucket> paramList1, int paramInt2, List<DataSource> paramList2, List<DataType> paramList3)
  {
    this.CK = paramInt1;
    this.Eb = paramStatus;
    this.Ws = paramInt2;
    this.Uk = paramList2;
    this.Wt = paramList3;
    this.Ua = new ArrayList(paramList.size());
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      RawDataSet localRawDataSet = (RawDataSet)localIterator1.next();
      this.Ua.add(new DataSet(localRawDataSet, paramList2, paramList3));
    }
    this.Wr = new ArrayList(paramList1.size());
    Iterator localIterator2 = paramList1.iterator();
    while (localIterator2.hasNext())
    {
      RawBucket localRawBucket = (RawBucket)localIterator2.next();
      this.Wr.add(new Bucket(localRawBucket, paramList2, paramList3));
    }
  }
  
  public DataReadResult(List<DataSet> paramList, List<Bucket> paramList1, Status paramStatus)
  {
    this.CK = 5;
    this.Ua = paramList;
    this.Eb = paramStatus;
    this.Wr = paramList1;
    this.Ws = 1;
    this.Uk = new ArrayList();
    this.Wt = new ArrayList();
  }
  
  public static DataReadResult a(Status paramStatus, DataReadRequest paramDataReadRequest)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramDataReadRequest.getDataSources().iterator();
    while (localIterator1.hasNext()) {
      localArrayList.add(DataSet.create((DataSource)localIterator1.next()));
    }
    Iterator localIterator2 = paramDataReadRequest.getDataTypes().iterator();
    while (localIterator2.hasNext())
    {
      DataType localDataType = (DataType)localIterator2.next();
      localArrayList.add(DataSet.create(new DataSource.Builder().setDataType(localDataType).setType(1).setName("Default").build()));
    }
    return new DataReadResult(localArrayList, Collections.emptyList(), paramStatus);
  }
  
  private void a(Bucket paramBucket, List<Bucket> paramList)
  {
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      Bucket localBucket = (Bucket)localIterator1.next();
      if (localBucket.b(paramBucket))
      {
        Iterator localIterator2 = paramBucket.getDataSets().iterator();
        while (localIterator2.hasNext()) {
          a((DataSet)localIterator2.next(), localBucket.getDataSets());
        }
      }
    }
    this.Wr.add(paramBucket);
  }
  
  private void a(DataSet paramDataSet, List<DataSet> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataSource().equals(paramDataSet.getDataSource()))
      {
        localDataSet.a(paramDataSet.getDataPoints());
        return;
      }
    }
    paramList.add(paramDataSet);
  }
  
  private boolean c(DataReadResult paramDataReadResult)
  {
    return (this.Eb.equals(paramDataReadResult.Eb)) && (jv.equal(this.Ua, paramDataReadResult.Ua)) && (jv.equal(this.Wr, paramDataReadResult.Wr));
  }
  
  public void b(DataReadResult paramDataReadResult)
  {
    Iterator localIterator1 = paramDataReadResult.getDataSets().iterator();
    while (localIterator1.hasNext()) {
      a((DataSet)localIterator1.next(), this.Ua);
    }
    Iterator localIterator2 = paramDataReadResult.getBuckets().iterator();
    while (localIterator2.hasNext()) {
      a((Bucket)localIterator2.next(), this.Wr);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataReadResult)) && (c((DataReadResult)paramObject)));
  }
  
  public List<Bucket> getBuckets()
  {
    return this.Wr;
  }
  
  public DataSet getDataSet(DataSource paramDataSource)
  {
    Iterator localIterator = this.Ua.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataSource.equals(localDataSet.getDataSource())) {
        return localDataSet;
      }
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramDataSource.getStreamIdentifier();
    throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", arrayOfObject));
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.Ua.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataType.equals(localDataSet.getDataType())) {
        return localDataSet;
      }
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramDataType.getName();
    throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", arrayOfObject));
  }
  
  public List<DataSet> getDataSets()
  {
    return this.Ua;
  }
  
  public Status getStatus()
  {
    return this.Eb;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.Eb;
    arrayOfObject[1] = this.Ua;
    arrayOfObject[2] = this.Wr;
    return jv.hashCode(arrayOfObject);
  }
  
  List<DataSource> jw()
  {
    return this.Uk;
  }
  
  public int kr()
  {
    return this.Ws;
  }
  
  List<RawBucket> ks()
  {
    ArrayList localArrayList = new ArrayList(this.Wr.size());
    Iterator localIterator = this.Wr.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawBucket((Bucket)localIterator.next(), this.Uk, this.Wt));
    }
    return localArrayList;
  }
  
  List<RawDataSet> kt()
  {
    ArrayList localArrayList = new ArrayList(this.Ua.size());
    Iterator localIterator = this.Ua.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataSet((DataSet)localIterator.next(), this.Uk, this.Wt));
    }
    return localArrayList;
  }
  
  List<DataType> ku()
  {
    return this.Wt;
  }
  
  public String toString()
  {
    jv.a locala1 = jv.h(this).a("status", this.Eb);
    Object localObject1;
    jv.a locala2;
    if (this.Ua.size() > 5)
    {
      localObject1 = this.Ua.size() + " data sets";
      locala2 = locala1.a("dataSets", localObject1);
      if (this.Wr.size() <= 5) {
        break label128;
      }
    }
    label128:
    for (Object localObject2 = this.Wr.size() + " buckets";; localObject2 = this.Wr)
    {
      return locala2.a("buckets", localObject2).toString();
      localObject1 = this.Ua;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.DataReadResult
 * JD-Core Version:    0.7.0.1
 */