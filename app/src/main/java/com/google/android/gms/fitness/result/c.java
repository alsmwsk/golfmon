package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import java.util.ArrayList;

public class c
  implements Parcelable.Creator<DataSourcesResult>
{
  static void a(DataSourcesResult paramDataSourcesResult, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramDataSourcesResult.getDataSources(), false);
    b.c(paramParcel, 1000, paramDataSourcesResult.getVersionCode());
    b.a(paramParcel, 2, paramDataSourcesResult.getStatus(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public DataSourcesResult cf(Parcel paramParcel)
  {
    Status localStatus = null;
    int i = a.G(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, k, DataSource.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localStatus = (Status)a.a(paramParcel, k, Status.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new DataSourcesResult(j, localArrayList, localStatus);
  }
  
  public DataSourcesResult[] dA(int paramInt)
  {
    return new DataSourcesResult[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.c
 * JD-Core Version:    0.7.0.1
 */