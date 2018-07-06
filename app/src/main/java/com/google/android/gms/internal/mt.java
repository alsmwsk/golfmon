package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;

public class mt
  implements Parcelable.Creator<ms>
{
  static void a(ms paramms, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramms.getDataSource(), paramInt, false);
    b.c(paramParcel, 1000, paramms.getVersionCode());
    b.H(paramParcel, i);
  }
  
  public ms bH(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    DataSource localDataSource = null;
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
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new ms(j, localDataSource);
  }
  
  public ms[] db(int paramInt)
  {
    return new ms[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mt
 * JD-Core Version:    0.7.0.1
 */