package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class bk
  implements Parcelable.Creator<bj>
{
  static void a(bj parambj, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, parambj.versionCode);
    b.c(paramParcel, 2, parambj.oQ);
    b.c(paramParcel, 3, parambj.backgroundColor);
    b.c(paramParcel, 4, parambj.oR);
    b.c(paramParcel, 5, parambj.oS);
    b.c(paramParcel, 6, parambj.oT);
    b.c(paramParcel, 7, parambj.oU);
    b.c(paramParcel, 8, parambj.oV);
    b.c(paramParcel, 9, parambj.oW);
    b.a(paramParcel, 10, parambj.oX, false);
    b.c(paramParcel, 11, parambj.oY);
    b.a(paramParcel, 12, parambj.oZ, false);
    b.c(paramParcel, 13, parambj.pa);
    b.c(paramParcel, 14, parambj.pb);
    b.a(paramParcel, 15, parambj.pc, false);
    b.H(paramParcel, i);
  }
  
  public bj d(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    String str1 = null;
    int i6 = 0;
    String str2 = null;
    int i7 = 0;
    int i8 = 0;
    String str3 = null;
    while (paramParcel.dataPosition() < i)
    {
      int i9 = a.F(paramParcel);
      switch (a.aH(i9))
      {
      default: 
        a.b(paramParcel, i9);
        break;
      case 1: 
        j = a.g(paramParcel, i9);
        break;
      case 2: 
        k = a.g(paramParcel, i9);
        break;
      case 3: 
        m = a.g(paramParcel, i9);
        break;
      case 4: 
        n = a.g(paramParcel, i9);
        break;
      case 5: 
        i1 = a.g(paramParcel, i9);
        break;
      case 6: 
        i2 = a.g(paramParcel, i9);
        break;
      case 7: 
        i3 = a.g(paramParcel, i9);
        break;
      case 8: 
        i4 = a.g(paramParcel, i9);
        break;
      case 9: 
        i5 = a.g(paramParcel, i9);
        break;
      case 10: 
        str1 = a.o(paramParcel, i9);
        break;
      case 11: 
        i6 = a.g(paramParcel, i9);
        break;
      case 12: 
        str2 = a.o(paramParcel, i9);
        break;
      case 13: 
        i7 = a.g(paramParcel, i9);
        break;
      case 14: 
        i8 = a.g(paramParcel, i9);
        break;
      case 15: 
        str3 = a.o(paramParcel, i9);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new bj(j, k, m, n, i1, i2, i3, i4, i5, str1, i6, str2, i7, i8, str3);
  }
  
  public bj[] i(int paramInt)
  {
    return new bj[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bk
 * JD-Core Version:    0.7.0.1
 */