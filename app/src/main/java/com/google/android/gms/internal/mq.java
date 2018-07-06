package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

public class mq
  implements SafeParcelable
{
  public static final Parcelable.Creator<mq> CREATOR = new mr();
  private final int CK;
  private final List<DataType> TY;
  
  mq(int paramInt, List<DataType> paramList)
  {
    this.CK = paramInt;
    this.TY = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DataType> getDataTypes()
  {
    return Collections.unmodifiableList(this.TY);
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public String toString()
  {
    return jv.h(this).a("dataTypes", this.TY).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mr.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mq
 * JD-Core Version:    0.7.0.1
 */