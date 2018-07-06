package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class o
  implements Parcelable.Creator<RawDataSet>
{
  static void a(RawDataSet paramRawDataSet, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramRawDataSet.UJ);
    b.c(paramParcel, 1000, paramRawDataSet.CK);
    b.c(paramParcel, 2, paramRawDataSet.UL);
    b.c(paramParcel, 3, paramRawDataSet.UM, false);
    b.a(paramParcel, 4, paramRawDataSet.Uc);
    b.H(paramParcel, i);
  }
  
  public RawDataSet bB(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 1000: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        j = a.g(paramParcel, n);
        break;
      case 3: 
        localArrayList = a.c(paramParcel, n, RawDataPoint.CREATOR);
        break;
      case 4: 
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new RawDataSet(m, k, j, localArrayList, bool);
  }
  
  public RawDataSet[] cU(int paramInt)
  {
    return new RawDataSet[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.o
 * JD-Core Version:    0.7.0.1
 */