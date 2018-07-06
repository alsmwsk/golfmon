package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataSourcesResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataSourcesResult> CREATOR = new c();
  private final int CK;
  private final Status Eb;
  private final List<DataSource> VH;
  
  DataSourcesResult(int paramInt, List<DataSource> paramList, Status paramStatus)
  {
    this.CK = paramInt;
    this.VH = Collections.unmodifiableList(paramList);
    this.Eb = paramStatus;
  }
  
  public DataSourcesResult(List<DataSource> paramList, Status paramStatus)
  {
    this.CK = 3;
    this.VH = Collections.unmodifiableList(paramList);
    this.Eb = paramStatus;
  }
  
  public static DataSourcesResult D(Status paramStatus)
  {
    return new DataSourcesResult(Collections.emptyList(), paramStatus);
  }
  
  private boolean b(DataSourcesResult paramDataSourcesResult)
  {
    return (this.Eb.equals(paramDataSourcesResult.Eb)) && (jv.equal(this.VH, paramDataSourcesResult.VH));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataSourcesResult)) && (b((DataSourcesResult)paramObject)));
  }
  
  public List<DataSource> getDataSources()
  {
    return this.VH;
  }
  
  public List<DataSource> getDataSources(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.VH.iterator();
    while (localIterator.hasNext())
    {
      DataSource localDataSource = (DataSource)localIterator.next();
      if (localDataSource.getDataType().equals(paramDataType)) {
        localArrayList.add(localDataSource);
      }
    }
    return Collections.unmodifiableList(localArrayList);
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
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.Eb;
    arrayOfObject[1] = this.VH;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("status", this.Eb).a("dataSets", this.VH).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.DataSourcesResult
 * JD-Core Version:    0.7.0.1
 */