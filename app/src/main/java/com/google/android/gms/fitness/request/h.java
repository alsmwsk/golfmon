package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class h
  implements Parcelable.Creator<DataSourcesRequest>
{
  static void a(DataSourcesRequest paramDataSourcesRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramDataSourcesRequest.getDataTypes(), false);
    b.c(paramParcel, 1000, paramDataSourcesRequest.getVersionCode());
    b.a(paramParcel, 2, paramDataSourcesRequest.jZ(), false);
    b.a(paramParcel, 3, paramDataSourcesRequest.jY());
    b.H(paramParcel, i);
  }
  
  public DataSourcesRequest bM(Parcel paramParcel)
  {
    ArrayList localArrayList1 = null;
    boolean bool = false;
    int i = a.G(paramParcel);
    ArrayList localArrayList2 = null;
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
        localArrayList2 = a.c(paramParcel, k, DataType.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList1 = a.B(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new DataSourcesRequest(j, localArrayList2, localArrayList1, bool);
  }
  
  public DataSourcesRequest[] dg(int paramInt)
  {
    return new DataSourcesRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.h
 * JD-Core Version:    0.7.0.1
 */