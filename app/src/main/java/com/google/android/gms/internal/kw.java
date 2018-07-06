package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class kw
  implements Parcelable.Creator<kv>
{
  static void a(kv paramkv, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramkv.getVersionCode());
    b.c(paramParcel, 2, paramkv.hZ(), false);
    b.a(paramParcel, 3, paramkv.ia(), false);
    b.H(paramParcel, i);
  }
  
  public kv O(Parcel paramParcel)
  {
    String str = null;
    int i = a.G(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
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
        localArrayList = a.c(paramParcel, k, kv.a.CREATOR);
        break;
      case 3: 
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new kv(j, localArrayList, str);
  }
  
  public kv[] aP(int paramInt)
  {
    return new kv[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kw
 * JD-Core Version:    0.7.0.1
 */