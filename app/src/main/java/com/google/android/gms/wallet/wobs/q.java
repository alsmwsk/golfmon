package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q
  implements Parcelable.Creator<p>
{
  static void a(p paramp, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramp.getVersionCode());
    b.a(paramParcel, 2, paramp.awT, false);
    b.a(paramParcel, 3, paramp.tU, false);
    b.a(paramParcel, 4, paramp.awX, paramInt, false);
    b.a(paramParcel, 5, paramp.awY, paramInt, false);
    b.a(paramParcel, 6, paramp.awZ, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public p ek(Parcel paramParcel)
  {
    n localn1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    n localn2 = null;
    l locall = null;
    String str1 = null;
    String str2 = null;
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
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        str1 = a.o(paramParcel, k);
        break;
      case 4: 
        locall = (l)a.a(paramParcel, k, l.CREATOR);
        break;
      case 5: 
        localn2 = (n)a.a(paramParcel, k, n.CREATOR);
        break;
      case 6: 
        localn1 = (n)a.a(paramParcel, k, n.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new p(j, str2, str1, locall, localn2, localn1);
  }
  
  public p[] gt(int paramInt)
  {
    return new p[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.q
 * JD-Core Version:    0.7.0.1
 */