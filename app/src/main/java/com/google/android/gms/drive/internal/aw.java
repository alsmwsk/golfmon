package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.StorageStats;

public class aw
  implements Parcelable.Creator<OnStorageStatsResponse>
{
  static void a(OnStorageStatsResponse paramOnStorageStatsResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOnStorageStatsResponse.CK);
    b.a(paramParcel, 2, paramOnStorageStatsResponse.QS, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public OnStorageStatsResponse aB(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    StorageStats localStorageStats = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localStorageStats = (StorageStats)a.a(paramParcel, k, StorageStats.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new OnStorageStatsResponse(j, localStorageStats);
  }
  
  public OnStorageStatsResponse[] bQ(int paramInt)
  {
    return new OnStorageStatsResponse[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.aw
 * JD-Core Version:    0.7.0.1
 */