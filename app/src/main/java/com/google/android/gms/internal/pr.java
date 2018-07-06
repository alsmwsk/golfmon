package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class pr
  implements Parcelable.Creator<pi.g>
{
  static void a(pi.g paramg, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    Set localSet = paramg.aon;
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramg.CK);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramg.apR);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramg.mValue, true);
    }
    b.H(paramParcel, i);
  }
  
  public pi.g dH(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int j = 0;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        bool = a.c(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new pi.g(localHashSet, j, bool, str);
  }
  
  public pi.g[] fF(int paramInt)
  {
    return new pi.g[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pr
 * JD-Core Version:    0.7.0.1
 */