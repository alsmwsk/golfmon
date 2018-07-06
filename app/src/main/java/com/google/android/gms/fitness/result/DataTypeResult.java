package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public class DataTypeResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataTypeResult> CREATOR = new d();
  private final int CK;
  private final Status Eb;
  private final DataType TM;
  
  DataTypeResult(int paramInt, Status paramStatus, DataType paramDataType)
  {
    this.CK = paramInt;
    this.Eb = paramStatus;
    this.TM = paramDataType;
  }
  
  public DataTypeResult(Status paramStatus, DataType paramDataType)
  {
    this.CK = 2;
    this.Eb = paramStatus;
    this.TM = paramDataType;
  }
  
  public static DataTypeResult E(Status paramStatus)
  {
    return new DataTypeResult(paramStatus, null);
  }
  
  private boolean b(DataTypeResult paramDataTypeResult)
  {
    return (this.Eb.equals(paramDataTypeResult.Eb)) && (jv.equal(this.TM, paramDataTypeResult.TM));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataTypeResult)) && (b((DataTypeResult)paramObject)));
  }
  
  public DataType getDataType()
  {
    return this.TM;
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
    arrayOfObject[1] = this.TM;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("status", this.Eb).a("dataType", this.TM).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.DataTypeResult
 * JD-Core Version:    0.7.0.1
 */