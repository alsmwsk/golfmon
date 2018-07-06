package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class f
  implements Parcelable.Creator<DataSet>
{
  static void a(DataSet paramDataSet, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramDataSet.getDataSource(), paramInt, false);
    b.c(paramParcel, 1000, paramDataSet.getVersionCode());
    b.a(paramParcel, 2, paramDataSet.getDataType(), paramInt, false);
    b.d(paramParcel, 3, paramDataSet.jv(), false);
    b.c(paramParcel, 4, paramDataSet.jw(), false);
    b.a(paramParcel, 5, paramDataSet.jn());
    b.H(paramParcel, i);
  }
  
  public DataSet bu(Parcel paramParcel)
  {
    boolean bool = false;
    ArrayList localArrayList1 = null;
    int i = a.G(paramParcel);
    ArrayList localArrayList2 = new ArrayList();
    DataType localDataType = null;
    DataSource localDataSource = null;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localDataSource = (DataSource)a.a(paramParcel, k, DataSource.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localDataType = (DataType)a.a(paramParcel, k, DataType.CREATOR);
        break;
      case 3: 
        a.a(paramParcel, k, localArrayList2, getClass().getClassLoader());
        break;
      case 4: 
        localArrayList1 = a.c(paramParcel, k, DataSource.CREATOR);
        break;
      case 5: 
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new DataSet(j, localDataSource, localDataType, localArrayList2, localArrayList1, bool);
  }
  
  public DataSet[] cN(int paramInt)
  {
    return new DataSet[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.f
 * JD-Core Version:    0.7.0.1
 */