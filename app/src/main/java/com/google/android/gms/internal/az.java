package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class az
  implements Parcelable.Creator<ay>
{
  static void a(ay paramay, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramay.versionCode);
    b.a(paramParcel, 2, paramay.op, false);
    b.c(paramParcel, 3, paramay.height);
    b.c(paramParcel, 4, paramay.heightPixels);
    b.a(paramParcel, 5, paramay.oq);
    b.c(paramParcel, 6, paramay.width);
    b.c(paramParcel, 7, paramay.widthPixels);
    b.a(paramParcel, 8, paramay.or, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public ay c(Parcel paramParcel)
  {
    ay[] arrayOfay = null;
    int i = 0;
    int j = a.G(paramParcel);
    int k = 0;
    boolean bool = false;
    int m = 0;
    int n = 0;
    String str = null;
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
        str = a.o(paramParcel, i2);
        break;
      case 3: 
        n = a.g(paramParcel, i2);
        break;
      case 4: 
        m = a.g(paramParcel, i2);
        break;
      case 5: 
        bool = a.c(paramParcel, i2);
        break;
      case 6: 
        k = a.g(paramParcel, i2);
        break;
      case 7: 
        i = a.g(paramParcel, i2);
        break;
      case 8: 
        arrayOfay = (ay[])a.b(paramParcel, i2, ay.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ay(i1, str, n, m, bool, k, i, arrayOfay);
  }
  
  public ay[] g(int paramInt)
  {
    return new ay[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.az
 * JD-Core Version:    0.7.0.1
 */