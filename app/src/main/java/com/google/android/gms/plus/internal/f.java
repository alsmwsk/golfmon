package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f
  implements Parcelable.Creator<PlusCommonExtras>
{
  static void a(PlusCommonExtras paramPlusCommonExtras, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramPlusCommonExtras.ox(), false);
    b.c(paramParcel, 1000, paramPlusCommonExtras.getVersionCode());
    b.a(paramParcel, 2, paramPlusCommonExtras.oy(), false);
    b.H(paramParcel, i);
  }
  
  public PlusCommonExtras dv(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.G(paramParcel);
    int j = 0;
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
        str2 = a.o(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new PlusCommonExtras(j, str2, str1);
  }
  
  public PlusCommonExtras[] ft(int paramInt)
  {
    return new PlusCommonExtras[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.f
 * JD-Core Version:    0.7.0.1
 */