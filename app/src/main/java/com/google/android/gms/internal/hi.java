package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hi
  implements Parcelable.Creator<hh>
{
  static void a(hh paramhh, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramhh.CX, false);
    b.c(paramParcel, 1000, paramhh.CK);
    b.a(paramParcel, 3, paramhh.CY, paramInt, false);
    b.c(paramParcel, 4, paramhh.CZ);
    b.a(paramParcel, 5, paramhh.Da, false);
    b.H(paramParcel, i);
  }
  
  public hh[] L(int paramInt)
  {
    return new hh[paramInt];
  }
  
  public hh n(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int i = a.G(paramParcel);
    int j = 0;
    int k = -1;
    hp localhp = null;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str = a.o(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 3: 
        localhp = (hp)a.a(paramParcel, m, hp.CREATOR);
        break;
      case 4: 
        k = a.g(paramParcel, m);
        break;
      case 5: 
        arrayOfByte = a.r(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new hh(j, str, localhp, k, arrayOfByte);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hi
 * JD-Core Version:    0.7.0.1
 */