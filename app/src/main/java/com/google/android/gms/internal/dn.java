package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dn
  implements Parcelable.Creator<do>
{
  static void a(do paramdo, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramdo.versionCode);
    b.a(paramParcel, 2, paramdo.rG, false);
    b.a(paramParcel, 3, paramdo.rH, false);
    b.a(paramParcel, 4, paramdo.mimeType, false);
    b.a(paramParcel, 5, paramdo.packageName, false);
    b.a(paramParcel, 6, paramdo.rI, false);
    b.a(paramParcel, 7, paramdo.rJ, false);
    b.a(paramParcel, 8, paramdo.rK, false);
    b.H(paramParcel, i);
  }
  
  public do e(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
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
        str7 = a.o(paramParcel, k);
        break;
      case 3: 
        str6 = a.o(paramParcel, k);
        break;
      case 4: 
        str5 = a.o(paramParcel, k);
        break;
      case 5: 
        str4 = a.o(paramParcel, k);
        break;
      case 6: 
        str3 = a.o(paramParcel, k);
        break;
      case 7: 
        str2 = a.o(paramParcel, k);
        break;
      case 8: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new do(j, str7, str6, str5, str4, str3, str2, str1);
  }
  
  public do[] m(int paramInt)
  {
    return new do[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dn
 * JD-Core Version:    0.7.0.1
 */