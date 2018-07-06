package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ig
  implements Parcelable.Creator<if>
{
  static void a(if paramif, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramif.responseCode);
    b.c(paramParcel, 1000, paramif.versionCode);
    b.a(paramParcel, 2, paramif.Ep, false);
    b.a(paramParcel, 3, paramif.Eq, false);
    b.H(paramParcel, i);
  }
  
  public if[] U(int paramInt)
  {
    return new if[paramInt];
  }
  
  public if t(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int i = 0;
    int j = a.G(paramParcel);
    Bundle localBundle = null;
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
        i = a.g(paramParcel, m);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        localBundle = a.q(paramParcel, m);
        break;
      case 3: 
        arrayOfByte = a.r(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new if(k, i, localBundle, arrayOfByte);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ig
 * JD-Core Version:    0.7.0.1
 */