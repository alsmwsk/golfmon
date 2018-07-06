package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<ValuesAddedDetails>
{
  static void a(ValuesAddedDetails paramValuesAddedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramValuesAddedDetails.CK);
    b.c(paramParcel, 2, paramValuesAddedDetails.mIndex);
    b.c(paramParcel, 3, paramValuesAddedDetails.SO);
    b.c(paramParcel, 4, paramValuesAddedDetails.SP);
    b.a(paramParcel, 5, paramValuesAddedDetails.Tk, false);
    b.c(paramParcel, 6, paramValuesAddedDetails.Tl);
    b.H(paramParcel, i);
  }
  
  public ValuesAddedDetails bn(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    String str = null;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i2 = a.F(paramParcel);
      switch (a.aH(i2))
      {
      default: 
        a.b(paramParcel, i2);
        break;
      case 1: 
        i1 = a.g(paramParcel, i2);
        break;
      case 2: 
        n = a.g(paramParcel, i2);
        break;
      case 3: 
        m = a.g(paramParcel, i2);
        break;
      case 4: 
        k = a.g(paramParcel, i2);
        break;
      case 5: 
        str = a.o(paramParcel, i2);
        break;
      case 6: 
        i = a.g(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ValuesAddedDetails(i1, n, m, k, str, i);
  }
  
  public ValuesAddedDetails[] cD(int paramInt)
  {
    return new ValuesAddedDetails[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.h
 * JD-Core Version:    0.7.0.1
 */