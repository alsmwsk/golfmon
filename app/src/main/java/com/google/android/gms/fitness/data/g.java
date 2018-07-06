package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g
  implements Parcelable.Creator<DataSource>
{
  static void a(DataSource paramDataSource, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramDataSource.getDataType(), paramInt, false);
    b.c(paramParcel, 1000, paramDataSource.getVersionCode());
    b.a(paramParcel, 2, paramDataSource.getName(), false);
    b.c(paramParcel, 3, paramDataSource.getType());
    b.a(paramParcel, 4, paramDataSource.getDevice(), paramInt, false);
    b.a(paramParcel, 5, paramDataSource.jx(), paramInt, false);
    b.a(paramParcel, 6, paramDataSource.getStreamName(), false);
    b.a(paramParcel, 7, paramDataSource.jz());
    b.H(paramParcel, i);
  }
  
  public DataSource bv(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int i = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    a locala = null;
    Device localDevice = null;
    int j = 0;
    String str2 = null;
    DataType localDataType = null;
    int k = 0;
    while (paramParcel.dataPosition() < i)
    {
      int m = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
        break;
      case 1: 
        localDataType = (DataType)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, DataType.CREATOR);
        break;
      case 1000: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        break;
      case 2: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 3: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        break;
      case 4: 
        localDevice = (Device)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, Device.CREATOR);
        break;
      case 5: 
        locala = (a)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, a.CREATOR);
        break;
      case 6: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 7: 
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new DataSource(k, localDataType, str2, j, localDevice, locala, str1, bool);
  }
  
  public DataSource[] cO(int paramInt)
  {
    return new DataSource[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.g
 * JD-Core Version:    0.7.0.1
 */