package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hs
  implements Parcelable.Creator<hr>
{
  static void a(hr paramhr, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramhr.Dw, paramInt, false);
    b.c(paramParcel, 1000, paramhr.CK);
    b.a(paramParcel, 2, paramhr.Dx);
    b.c(paramParcel, 3, paramhr.Dy);
    b.a(paramParcel, 4, paramhr.pc, false);
    b.a(paramParcel, 5, paramhr.Dz, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public hr[] S(int paramInt)
  {
    return new hr[paramInt];
  }
  
  public hr s(Parcel paramParcel)
  {
    int i = 0;
    hd localhd = null;
    int j = a.G(paramParcel);
    long l = 0L;
    String str = null;
    hf localhf = null;
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
        localhf = (hf)a.a(paramParcel, m, hf.CREATOR);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        l = a.i(paramParcel, m);
        break;
      case 3: 
        i = a.g(paramParcel, m);
        break;
      case 4: 
        str = a.o(paramParcel, m);
        break;
      case 5: 
        localhd = (hd)a.a(paramParcel, m, hd.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new hr(k, localhf, l, i, str, localhd);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hs
 * JD-Core Version:    0.7.0.1
 */