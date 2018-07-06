package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class kz
  implements Parcelable.Creator<ky>
{
  static void a(ky paramky, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramky.getVersionCode());
    b.a(paramParcel, 2, paramky.ic(), false);
    b.a(paramParcel, 3, paramky.id(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public ky Q(Parcel paramParcel)
  {
    kv localkv = null;
    int i = a.G(paramParcel);
    int j = 0;
    Parcel localParcel = null;
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
        localParcel = a.D(paramParcel, k);
        break;
      case 3: 
        localkv = (kv)a.a(paramParcel, k, kv.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new ky(j, localParcel, localkv);
  }
  
  public ky[] aR(int paramInt)
  {
    return new ky[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kz
 * JD-Core Version:    0.7.0.1
 */