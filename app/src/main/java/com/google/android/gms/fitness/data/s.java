package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class s
  implements Parcelable.Creator<Subscription>
{
  static void a(Subscription paramSubscription, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramSubscription.getDataSource(), paramInt, false);
    b.c(paramParcel, 1000, paramSubscription.getVersionCode());
    b.a(paramParcel, 2, paramSubscription.getDataType(), paramInt, false);
    b.a(paramParcel, 3, paramSubscription.jI());
    b.c(paramParcel, 4, paramSubscription.getAccuracyMode());
    b.H(paramParcel, i);
  }
  
  public Subscription bE(Parcel paramParcel)
  {
    DataType localDataType = null;
    int i = 0;
    int j = a.G(paramParcel);
    long l = 0L;
    DataSource localDataSource = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        localDataSource = (DataSource)a.a(paramParcel, m, DataSource.CREATOR);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        localDataType = (DataType)a.a(paramParcel, m, DataType.CREATOR);
        break;
      case 3: 
        l = a.i(paramParcel, m);
        break;
      case 4: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new Subscription(k, localDataSource, localDataType, l, i);
  }
  
  public Subscription[] cY(int paramInt)
  {
    return new Subscription[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.s
 * JD-Core Version:    0.7.0.1
 */