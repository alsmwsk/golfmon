package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class pz
  implements Parcelable.Creator<py>
{
  static void a(py parampy, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, parampy.getVersionCode());
    b.a(paramParcel, 2, parampy.avY, false);
    b.a(paramParcel, 3, parampy.avZ, false);
    b.H(paramParcel, i);
  }
  
  public py dY(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int i = a.G(paramParcel);
    int j = 0;
    byte[][] arrayOfByte = (byte[][])null;
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
        arrayOfString = a.A(paramParcel, k);
        break;
      case 3: 
        arrayOfByte = a.s(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new py(j, arrayOfString, arrayOfByte);
  }
  
  public py[] gf(int paramInt)
  {
    return new py[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pz
 * JD-Core Version:    0.7.0.1
 */