package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ot
  implements Parcelable.Creator<or>
{
  static void a(or paramor, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramor.versionCode);
    b.a(paramParcel, 2, paramor.amW);
    b.a(paramParcel, 3, paramor.tag, false);
    b.a(paramParcel, 4, paramor.amX, false);
    b.a(paramParcel, 5, paramor.amY, false);
    b.H(paramParcel, i);
  }
  
  public or dt(Parcel paramParcel)
  {
    Bundle localBundle = null;
    int i = a.G(paramParcel);
    int j = 0;
    long l = 0L;
    byte[] arrayOfByte = null;
    String str = null;
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
        l = a.i(paramParcel, k);
        break;
      case 3: 
        str = a.o(paramParcel, k);
        break;
      case 4: 
        arrayOfByte = a.r(paramParcel, k);
        break;
      case 5: 
        localBundle = a.q(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new or(j, l, str, arrayOfByte, localBundle);
  }
  
  public or[] fq(int paramInt)
  {
    return new or[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ot
 * JD-Core Version:    0.7.0.1
 */