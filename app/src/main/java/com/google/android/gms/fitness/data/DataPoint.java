package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lt;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataPoint> CREATOR = new e();
  private final int CK;
  private final DataSource TN;
  private long Ud;
  private long Ue;
  private final Value[] Uf;
  private DataSource Ug;
  private long Uh;
  private long Ui;
  
  DataPoint(int paramInt, DataSource paramDataSource1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, DataSource paramDataSource2, long paramLong3, long paramLong4)
  {
    this.CK = paramInt;
    this.TN = paramDataSource1;
    this.Ug = paramDataSource2;
    this.Ud = paramLong1;
    this.Ue = paramLong2;
    this.Uf = paramArrayOfValue;
    this.Uh = paramLong3;
    this.Ui = paramLong4;
  }
  
  private DataPoint(DataSource paramDataSource)
  {
    this.CK = 4;
    this.TN = ((DataSource)jx.b(paramDataSource, "Data source cannot be null"));
    List localList = paramDataSource.getDataType().getFields();
    this.Uf = new Value[localList.size()];
    Iterator localIterator = localList.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      Field localField = (Field)localIterator.next();
      this.Uf[i] = new Value(localField.getFormat());
    }
  }
  
  DataPoint(List<DataSource> paramList, RawDataPoint paramRawDataPoint)
  {
    this(4, c(paramList, paramRawDataPoint.UJ), paramRawDataPoint.Ud, paramRawDataPoint.Ue, paramRawDataPoint.Uf, c(paramList, paramRawDataPoint.UK), paramRawDataPoint.Uh, paramRawDataPoint.Ui);
  }
  
  private boolean a(DataPoint paramDataPoint)
  {
    return (jv.equal(this.TN, paramDataPoint.TN)) && (this.Ud == paramDataPoint.Ud) && (this.Ue == paramDataPoint.Ue) && (Arrays.equals(this.Uf, paramDataPoint.Uf)) && (jv.equal(this.Ug, paramDataPoint.Ug));
  }
  
  private static DataSource c(List<DataSource> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return (DataSource)paramList.get(paramInt);
    }
    return null;
  }
  
  private void cL(int paramInt)
  {
    List localList = getDataType().getFields();
    int i = localList.size();
    if (paramInt == i) {}
    for (boolean bool = true;; bool = false)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = Integer.valueOf(i);
      arrayOfObject[2] = localList;
      jx.b(bool, "Attempting to insert %s values, but needed %s: %s", arrayOfObject);
      return;
    }
  }
  
  public static DataPoint create(DataSource paramDataSource)
  {
    return new DataPoint(paramDataSource);
  }
  
  public static DataPoint extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataPoint)c.a(paramIntent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
  }
  
  private boolean jq()
  {
    return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataPoint)) && (a((DataPoint)paramObject)));
  }
  
  public DataSource getDataSource()
  {
    return this.TN;
  }
  
  public DataType getDataType()
  {
    return this.TN.getDataType();
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.Ud, TimeUnit.NANOSECONDS);
  }
  
  public DataSource getOriginalDataSource()
  {
    return this.Ug;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.Ue, TimeUnit.NANOSECONDS);
  }
  
  public long getTimestamp(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.Ud, TimeUnit.NANOSECONDS);
  }
  
  public long getTimestampNanos()
  {
    return this.Ud;
  }
  
  public Value getValue(Field paramField)
  {
    int i = getDataType().indexOf(paramField);
    return this.Uf[i];
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.TN;
    arrayOfObject[1] = Long.valueOf(this.Ud);
    arrayOfObject[2] = Long.valueOf(this.Ue);
    return jv.hashCode(arrayOfObject);
  }
  
  public Value[] jr()
  {
    return this.Uf;
  }
  
  public long js()
  {
    return this.Uh;
  }
  
  public long jt()
  {
    return this.Ui;
  }
  
  public long ju()
  {
    return this.Ue;
  }
  
  public DataPoint setFloatValues(float... paramVarArgs)
  {
    cL(paramVarArgs.length);
    for (int i = 0; i < paramVarArgs.length; i++) {
      this.Uf[i].setFloat(paramVarArgs[i]);
    }
    return this;
  }
  
  public DataPoint setIntValues(int... paramVarArgs)
  {
    cL(paramVarArgs.length);
    for (int i = 0; i < paramVarArgs.length; i++) {
      this.Uf[i].setInt(paramVarArgs[i]);
    }
    return this;
  }
  
  public DataPoint setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    this.Ue = paramTimeUnit.toNanos(paramLong1);
    this.Ud = paramTimeUnit.toNanos(paramLong2);
    return this;
  }
  
  public DataPoint setTimestamp(long paramLong, TimeUnit paramTimeUnit)
  {
    this.Ud = paramTimeUnit.toNanos(paramLong);
    if ((jq()) && (lt.a(paramTimeUnit)))
    {
      Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
      this.Ud = lt.a(this.Ud, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
    }
    return this;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Arrays.toString(this.Uf);
    arrayOfObject[1] = Long.valueOf(this.Ue);
    arrayOfObject[2] = Long.valueOf(this.Ud);
    arrayOfObject[3] = Long.valueOf(this.Uh);
    arrayOfObject[4] = Long.valueOf(this.Ui);
    arrayOfObject[5] = this.TN;
    arrayOfObject[6] = this.Ug;
    return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.DataPoint
 * JD-Core Version:    0.7.0.1
 */