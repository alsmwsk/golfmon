package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ow
  implements Parcelable.Creator<ov>
{
  static void a(ov paramov, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramov.versionCode);
    b.a(paramParcel, 2, paramov.packageName, false);
    b.c(paramParcel, 3, paramov.ang);
    b.c(paramParcel, 4, paramov.anh);
    b.a(paramParcel, 5, paramov.ani, false);
    b.a(paramParcel, 6, paramov.anj, false);
    b.a(paramParcel, 7, paramov.ank);
    b.a(paramParcel, 8, paramov.anl, false);
    b.H(paramParcel, i);
  }
  
  public ov du(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int j = a.G(paramParcel);
    boolean bool = true;
    String str2 = null;
    String str3 = null;
    int k = 0;
    String str4 = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        str4 = a.o(paramParcel, n);
        break;
      case 3: 
        k = a.g(paramParcel, n);
        break;
      case 4: 
        i = a.g(paramParcel, n);
        break;
      case 5: 
        str3 = a.o(paramParcel, n);
        break;
      case 6: 
        str2 = a.o(paramParcel, n);
        break;
      case 7: 
        bool = a.c(paramParcel, n);
        break;
      case 8: 
        str1 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ov(m, str4, k, i, str3, str2, bool, str1);
  }
  
  public ov[] fr(int paramInt)
  {
    return new ov[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ow
 * JD-Core Version:    0.7.0.1
 */