package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.List;

public final class RawDataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawDataSet> CREATOR = new o();
  final int CK;
  final int UJ;
  final int UL;
  final List<RawDataPoint> UM;
  final boolean Uc;
  
  RawDataSet(int paramInt1, int paramInt2, int paramInt3, List<RawDataPoint> paramList, boolean paramBoolean)
  {
    this.CK = paramInt1;
    this.UJ = paramInt2;
    this.UL = paramInt3;
    this.UM = paramList;
    this.Uc = paramBoolean;
  }
  
  public RawDataSet(DataSet paramDataSet, List<DataSource> paramList, List<DataType> paramList1)
  {
    this.CK = 2;
    this.UM = paramDataSet.f(paramList);
    this.Uc = paramDataSet.jn();
    this.UJ = t.a(paramDataSet.getDataSource(), paramList);
    this.UL = t.a(paramDataSet.getDataType(), paramList1);
  }
  
  private boolean a(RawDataSet paramRawDataSet)
  {
    return (this.UJ == paramRawDataSet.UJ) && (this.UL == paramRawDataSet.UL) && (this.Uc == paramRawDataSet.Uc) && (jv.equal(this.UM, paramRawDataSet.UM));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawDataSet)) && (a((RawDataSet)paramObject)));
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.UJ);
    arrayOfObject[1] = Integer.valueOf(this.UL);
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.UJ);
    arrayOfObject[1] = Integer.valueOf(this.UL);
    arrayOfObject[2] = this.UM;
    return String.format("RawDataSet{%s@[%s, %s]}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.RawDataSet
 * JD-Core Version:    0.7.0.1
 */