package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ip
  implements Parcelable.Creator<io>
{
  static void a(io paramio, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramio.getVersionCode());
    b.a(paramParcel, 2, paramio.fZ());
    b.a(paramParcel, 3, paramio.gi());
    b.c(paramParcel, 4, paramio.gj());
    b.a(paramParcel, 5, paramio.getApplicationMetadata(), paramInt, false);
    b.c(paramParcel, 6, paramio.gk());
    b.H(paramParcel, i);
  }
  
  public io[] ai(int paramInt)
  {
    return new io[paramInt];
  }
  
  public io y(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    double d = 0.0D;
    ApplicationMetadata localApplicationMetadata = null;
    int k = 0;
    boolean bool = false;
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
        d = a.m(paramParcel, n);
        break;
      case 3: 
        bool = a.c(paramParcel, n);
        break;
      case 4: 
        k = a.g(paramParcel, n);
        break;
      case 5: 
        localApplicationMetadata = (ApplicationMetadata)a.a(paramParcel, n, ApplicationMetadata.CREATOR);
        break;
      case 6: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new io(m, d, bool, k, localApplicationMetadata, i);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ip
 * JD-Core Version:    0.7.0.1
 */