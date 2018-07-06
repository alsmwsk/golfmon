package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class pj
  implements Parcelable.Creator<pi>
{
  static void a(pi parampi, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    Set localSet = parampi.aon;
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, parampi.CK);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, parampi.apl, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, parampi.apm, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, parampi.apn, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, parampi.apo, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.c(paramParcel, 6, parampi.app);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, parampi.apq, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      b.a(paramParcel, 8, parampi.apr, true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      b.a(paramParcel, 9, parampi.OS, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      b.c(paramParcel, 12, parampi.ow);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      b.a(paramParcel, 14, parampi.CE, true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      b.a(paramParcel, 15, parampi.aps, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      b.a(paramParcel, 16, parampi.apt);
    }
    if (localSet.contains(Integer.valueOf(19))) {
      b.a(paramParcel, 19, parampi.apu, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      b.a(paramParcel, 18, parampi.FR, true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      b.c(paramParcel, 21, parampi.apw);
    }
    if (localSet.contains(Integer.valueOf(20))) {
      b.a(paramParcel, 20, parampi.apv, true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      b.c(paramParcel, 23, parampi.apy, true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      b.c(paramParcel, 22, parampi.apx, true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      b.c(paramParcel, 25, parampi.apA);
    }
    if (localSet.contains(Integer.valueOf(24))) {
      b.c(paramParcel, 24, parampi.apz);
    }
    if (localSet.contains(Integer.valueOf(27))) {
      b.a(paramParcel, 27, parampi.vf, true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      b.a(paramParcel, 26, parampi.apB, true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      b.a(paramParcel, 29, parampi.apD);
    }
    if (localSet.contains(Integer.valueOf(28))) {
      b.c(paramParcel, 28, parampi.apC, true);
    }
    b.H(paramParcel, i);
  }
  
  public pi dz(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    String str1 = null;
    Object localObject1 = null;
    String str2 = null;
    String str3 = null;
    int k = 0;
    Object localObject2 = null;
    String str4 = null;
    String str5 = null;
    int m = 0;
    String str6 = null;
    Object localObject3 = null;
    boolean bool1 = false;
    String str7 = null;
    Object localObject4 = null;
    String str8 = null;
    int n = 0;
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    int i1 = 0;
    int i2 = 0;
    String str9 = null;
    String str10 = null;
    ArrayList localArrayList3 = null;
    boolean bool2 = false;
    while (paramParcel.dataPosition() < i)
    {
      int i3 = a.F(paramParcel);
      switch (a.aH(i3))
      {
      case 10: 
      case 11: 
      case 13: 
      case 17: 
      default: 
        a.b(paramParcel, i3);
        break;
      case 1: 
        j = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str1 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        pi.a locala = (pi.a)a.a(paramParcel, i3, pi.a.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        localObject1 = locala;
        break;
      case 4: 
        str2 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str3 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        k = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        pi.b localb = (pi.b)a.a(paramParcel, i3, pi.b.CREATOR);
        localHashSet.add(Integer.valueOf(7));
        localObject2 = localb;
        break;
      case 8: 
        str4 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9: 
        str5 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 12: 
        m = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 14: 
        str6 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15: 
        pi.c localc = (pi.c)a.a(paramParcel, i3, pi.c.CREATOR);
        localHashSet.add(Integer.valueOf(15));
        localObject3 = localc;
        break;
      case 16: 
        bool1 = a.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19: 
        pi.d locald = (pi.d)a.a(paramParcel, i3, pi.d.CREATOR);
        localHashSet.add(Integer.valueOf(19));
        localObject4 = locald;
        break;
      case 18: 
        str7 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 21: 
        n = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 20: 
        str8 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 23: 
        localArrayList2 = a.c(paramParcel, i3, pi.g.CREATOR);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22: 
        localArrayList1 = a.c(paramParcel, i3, pi.f.CREATOR);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 25: 
        i2 = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 24: 
        i1 = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 27: 
        str10 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 26: 
        str9 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 29: 
        bool2 = a.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(29));
        break;
      case 28: 
        localArrayList3 = a.c(paramParcel, i3, pi.h.CREATOR);
        localHashSet.add(Integer.valueOf(28));
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new pi(localHashSet, j, str1, localObject1, str2, str3, k, localObject2, str4, str5, m, str6, localObject3, bool1, str7, localObject4, str8, n, localArrayList1, localArrayList2, i1, i2, str9, str10, localArrayList3, bool2);
  }
  
  public pi[] fx(int paramInt)
  {
    return new pi[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pj
 * JD-Core Version:    0.7.0.1
 */