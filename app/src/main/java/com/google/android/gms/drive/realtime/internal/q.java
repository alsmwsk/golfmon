package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q
  implements Parcelable.Creator<ParcelableIndexReference>
{
  static void a(ParcelableIndexReference paramParcelableIndexReference, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramParcelableIndexReference.CK);
    b.a(paramParcel, 2, paramParcelableIndexReference.SM, false);
    b.c(paramParcel, 3, paramParcelableIndexReference.mIndex);
    b.a(paramParcel, 4, paramParcelableIndexReference.SN);
    b.H(paramParcel, i);
  }
  
  public ParcelableIndexReference bf(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    String str = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < i)
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
        str = a.o(paramParcel, m);
        break;
      case 3: 
        j = a.g(paramParcel, m);
        break;
      case 4: 
        bool = a.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new ParcelableIndexReference(k, str, j, bool);
  }
  
  public ParcelableIndexReference[] cv(int paramInt)
  {
    return new ParcelableIndexReference[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.q
 * JD-Core Version:    0.7.0.1
 */