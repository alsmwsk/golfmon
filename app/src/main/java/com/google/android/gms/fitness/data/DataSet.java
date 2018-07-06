package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSet> CREATOR = new f();
  private final int CK;
  private final DataType TM;
  private final DataSource TN;
  private boolean Uc = false;
  private final List<DataPoint> Uj;
  private final List<DataSource> Uk;
  
  DataSet(int paramInt, DataSource paramDataSource, DataType paramDataType, List<RawDataPoint> paramList, List<DataSource> paramList1, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.TN = paramDataSource;
    this.TM = paramDataType;
    this.Uc = paramBoolean;
    this.Uj = new ArrayList(paramList.size());
    if (paramInt >= 2) {}
    for (;;)
    {
      this.Uk = paramList1;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        RawDataPoint localRawDataPoint = (RawDataPoint)localIterator.next();
        this.Uj.add(new DataPoint(this.Uk, localRawDataPoint));
      }
      paramList1 = Collections.singletonList(paramDataSource);
    }
  }
  
  private DataSet(DataSource paramDataSource, DataType paramDataType)
  {
    this.CK = 3;
    this.TN = ((DataSource)jx.i(paramDataSource));
    this.TM = ((DataType)jx.i(paramDataType));
    this.Uj = new ArrayList();
    this.Uk = new ArrayList();
    this.Uk.add(this.TN);
  }
  
  public DataSet(RawDataSet paramRawDataSet, List<DataSource> paramList, List<DataType> paramList1)
  {
    this(3, (DataSource)d(paramList, paramRawDataSet.UJ), (DataType)d(paramList1, paramRawDataSet.UL), paramRawDataSet.UM, paramList, paramRawDataSet.Uc);
  }
  
  private boolean a(DataSet paramDataSet)
  {
    return (jv.equal(this.TM, paramDataSet.TM)) && (jv.equal(this.TN, paramDataSet.TN)) && (jv.equal(this.Uj, paramDataSet.Uj)) && (this.Uc == paramDataSet.Uc);
  }
  
  public static DataSet create(DataSource paramDataSource)
  {
    jx.b(paramDataSource, "DataSource should be specified");
    return new DataSet(paramDataSource, paramDataSource.getDataType());
  }
  
  private static <T> T d(List<T> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return paramList.get(paramInt);
    }
    return null;
  }
  
  public void a(Iterable<DataPoint> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      b((DataPoint)localIterator.next());
    }
  }
  
  public void add(DataPoint paramDataPoint)
  {
    DataSource localDataSource = paramDataPoint.getDataSource();
    boolean bool1 = localDataSource.getStreamIdentifier().equals(this.TN.getStreamIdentifier());
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = localDataSource;
    arrayOfObject1[1] = this.TN;
    jx.b(bool1, "Conflicting data sources found %s vs %s", arrayOfObject1);
    boolean bool2 = paramDataPoint.getDataType().getName().equals(this.TM.getName());
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = paramDataPoint.getDataType();
    arrayOfObject2[1] = this.TM;
    jx.b(bool2, "Conflicting data types found %s vs %s", arrayOfObject2);
    boolean bool3;
    if (paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS) > 0L)
    {
      bool3 = true;
      jx.b(bool3, "Data point does not have the timestamp set: %s", new Object[] { paramDataPoint });
      if (paramDataPoint.getStartTime(TimeUnit.NANOSECONDS) > paramDataPoint.getEndTime(TimeUnit.NANOSECONDS)) {
        break label175;
      }
    }
    label175:
    for (boolean bool4 = true;; bool4 = false)
    {
      jx.b(bool4, "Data point with start time greater than end time found: %s", new Object[] { paramDataPoint });
      b(paramDataPoint);
      return;
      bool3 = false;
      break;
    }
  }
  
  public void addAll(Iterable<DataPoint> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      add((DataPoint)localIterator.next());
    }
  }
  
  public void b(DataPoint paramDataPoint)
  {
    this.Uj.add(paramDataPoint);
    DataSource localDataSource = paramDataPoint.getOriginalDataSource();
    if ((localDataSource != null) && (!this.Uk.contains(localDataSource))) {
      this.Uk.add(localDataSource);
    }
  }
  
  public DataPoint createDataPoint()
  {
    return DataPoint.create(this.TN);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataSet)) && (a((DataSet)paramObject)));
  }
  
  List<RawDataPoint> f(List<DataSource> paramList)
  {
    ArrayList localArrayList = new ArrayList(this.Uj.size());
    Iterator localIterator = this.Uj.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataPoint((DataPoint)localIterator.next(), paramList));
    }
    return localArrayList;
  }
  
  public List<DataPoint> getDataPoints()
  {
    return Collections.unmodifiableList(this.Uj);
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
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.TM;
    arrayOfObject[1] = this.TN;
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean jn()
  {
    return this.Uc;
  }
  
  List<RawDataPoint> jv()
  {
    return f(this.Uk);
  }
  
  List<DataSource> jw()
  {
    return this.Uk;
  }
  
  public String toString()
  {
    Object localObject = jv();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this.TN.toDebugString();
    if (this.Uj.size() < 10) {}
    for (;;)
    {
      arrayOfObject1[1] = localObject;
      return String.format("DataSet{%s %s}", arrayOfObject1);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(this.Uj.size());
      arrayOfObject2[1] = ((List)localObject).subList(0, 5);
      localObject = String.format("%d data points, first 5: %s", arrayOfObject2);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.DataSet
 * JD-Core Version:    0.7.0.1
 */