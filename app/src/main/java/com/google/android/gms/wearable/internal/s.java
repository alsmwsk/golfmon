package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wearable.c;

public class s
  implements Parcelable.Creator<r>
{
  static void a(r paramr, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramr.versionCode);
    b.c(paramParcel, 2, paramr.statusCode);
    b.a(paramParcel, 3, paramr.axJ, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public r es(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    c localc = null;
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
        k = a.g(paramParcel, m);
        break;
      case 2: 
        i = a.g(paramParcel, m);
        break;
      case 3: 
        localc = (c)a.a(paramParcel, m, c.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new r(k, i, localc);
  }
  
  public r[] gB(int paramInt)
  {
    return new r[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.s
 * JD-Core Version:    0.7.0.1
 */