package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j
  implements Parcelable.Creator<ValuesSetDetails>
{
  static void a(ValuesSetDetails paramValuesSetDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramValuesSetDetails.CK);
    b.c(paramParcel, 2, paramValuesSetDetails.mIndex);
    b.c(paramParcel, 3, paramValuesSetDetails.SO);
    b.c(paramParcel, 4, paramValuesSetDetails.SP);
    b.H(paramParcel, i);
  }
  
  public ValuesSetDetails bp(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    int k = 0;
    int m = 0;
    int n = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i1 = a.F(paramParcel);
      switch (a.aH(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        n = a.g(paramParcel, i1);
        break;
      case 2: 
        m = a.g(paramParcel, i1);
        break;
      case 3: 
        k = a.g(paramParcel, i1);
        break;
      case 4: 
        i = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ValuesSetDetails(n, m, k, i);
  }
  
  public ValuesSetDetails[] cF(int paramInt)
  {
    return new ValuesSetDetails[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.j
 * JD-Core Version:    0.7.0.1
 */