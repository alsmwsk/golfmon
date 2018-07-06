package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class kn
  implements Parcelable.Creator<km>
{
  static void a(km paramkm, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramkm.getVersionCode());
    b.a(paramParcel, 2, paramkm.hF(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public km J(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    ko localko = null;
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
        localko = (ko)a.a(paramParcel, k, ko.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new km(j, localko);
  }
  
  public km[] aK(int paramInt)
  {
    return new km[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kn
 * JD-Core Version:    0.7.0.1
 */