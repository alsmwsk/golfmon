package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class pl
  implements Parcelable.Creator<pi.b>
{
  static void a(pi.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    Set localSet = paramb.aon;
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramb.CK);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramb.apG, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramb.apH, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.c(paramParcel, 4, paramb.apI);
    }
    b.H(paramParcel, i);
  }
  
  public pi.b dB(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = 0;
    int j = a.G(paramParcel);
    HashSet localHashSet = new HashSet();
    Object localObject2 = null;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        pi.b.a locala = (pi.b.a)a.a(paramParcel, m, pi.b.a.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        localObject2 = locala;
        break;
      case 3: 
        pi.b.b localb = (pi.b.b)a.a(paramParcel, m, pi.b.b.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        localObject1 = localb;
        break;
      case 4: 
        i = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new pi.b(localHashSet, k, localObject2, localObject1, i);
  }
  
  public pi.b[] fz(int paramInt)
  {
    return new pi.b[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pl
 * JD-Core Version:    0.7.0.1
 */