package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aq
  implements Parcelable.Creator<ap>
{
  static void a(ap paramap, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramap.versionCode);
    b.c(paramParcel, 2, paramap.statusCode);
    b.a(paramParcel, 3, paramap.axM, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public ap eB(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    m localm = null;
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
        localm = (m)a.a(paramParcel, m, m.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ap(k, i, localm);
  }
  
  public ap[] gK(int paramInt)
  {
    return new ap[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.aq
 * JD-Core Version:    0.7.0.1
 */