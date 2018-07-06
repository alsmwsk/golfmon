package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hq
  implements Parcelable.Creator<hp>
{
  static void a(hp paramhp, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramhp.name, false);
    b.c(paramParcel, 1000, paramhp.CK);
    b.a(paramParcel, 2, paramhp.Dh, false);
    b.a(paramParcel, 3, paramhp.Di);
    b.c(paramParcel, 4, paramhp.weight);
    b.a(paramParcel, 5, paramhp.Dj);
    b.a(paramParcel, 6, paramhp.Dk, false);
    b.a(paramParcel, 7, paramhp.Dl, paramInt, false);
    b.a(paramParcel, 8, paramhp.Dm, false);
    b.a(paramParcel, 11, paramhp.Dn, false);
    b.H(paramParcel, i);
  }
  
  public hp[] R(int paramInt)
  {
    return new hp[paramInt];
  }
  
  public hp r(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int i = a.G(paramParcel);
    int j = 1;
    int[] arrayOfInt = null;
    hj[] arrayOfhj = null;
    String str2 = null;
    boolean bool2 = false;
    String str3 = null;
    String str4 = null;
    int k = 0;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str4 = a.o(paramParcel, m);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        str3 = a.o(paramParcel, m);
        break;
      case 3: 
        bool2 = a.c(paramParcel, m);
        break;
      case 4: 
        j = a.g(paramParcel, m);
        break;
      case 5: 
        bool1 = a.c(paramParcel, m);
        break;
      case 6: 
        str2 = a.o(paramParcel, m);
        break;
      case 7: 
        arrayOfhj = (hj[])a.b(paramParcel, m, hj.CREATOR);
        break;
      case 8: 
        arrayOfInt = a.u(paramParcel, m);
        break;
      case 11: 
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new hp(k, str4, str3, bool2, j, bool1, str2, arrayOfhj, arrayOfInt, str1);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hq
 * JD-Core Version:    0.7.0.1
 */