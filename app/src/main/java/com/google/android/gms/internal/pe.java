package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class pe
  implements Parcelable.Creator<pd>
{
  static void a(pd parampd, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    Set localSet = parampd.aon;
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, parampd.CK);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, parampd.aoo, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.b(paramParcel, 3, parampd.aop, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, parampd.aoq, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, parampd.aor, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, parampd.aos, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, parampd.aot, true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      b.c(paramParcel, 8, parampd.aou, true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      b.c(paramParcel, 9, parampd.aov);
    }
    if (localSet.contains(Integer.valueOf(10))) {
      b.c(paramParcel, 10, parampd.aow, true);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      b.a(paramParcel, 11, parampd.aox, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      b.c(paramParcel, 12, parampd.aoy, true);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      b.a(paramParcel, 13, parampd.aoz, true);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      b.a(paramParcel, 14, parampd.aoA, true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      b.a(paramParcel, 15, parampd.aoB, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(17))) {
      b.a(paramParcel, 17, parampd.aoD, true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      b.a(paramParcel, 16, parampd.aoC, true);
    }
    if (localSet.contains(Integer.valueOf(19))) {
      b.c(paramParcel, 19, parampd.aoE, true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      b.a(paramParcel, 18, parampd.ov, true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      b.a(paramParcel, 21, parampd.aoG, true);
    }
    if (localSet.contains(Integer.valueOf(20))) {
      b.a(paramParcel, 20, parampd.aoF, true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      b.a(paramParcel, 23, parampd.UO, true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      b.a(paramParcel, 22, parampd.aoH, true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      b.a(paramParcel, 25, parampd.aoJ, true);
    }
    if (localSet.contains(Integer.valueOf(24))) {
      b.a(paramParcel, 24, parampd.aoI, true);
    }
    if (localSet.contains(Integer.valueOf(27))) {
      b.a(paramParcel, 27, parampd.aoL, true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      b.a(paramParcel, 26, parampd.aoK, true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      b.a(paramParcel, 29, parampd.aoN, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(28))) {
      b.a(paramParcel, 28, parampd.aoM, true);
    }
    if (localSet.contains(Integer.valueOf(31))) {
      b.a(paramParcel, 31, parampd.aoP, true);
    }
    if (localSet.contains(Integer.valueOf(30))) {
      b.a(paramParcel, 30, parampd.aoO, true);
    }
    if (localSet.contains(Integer.valueOf(34))) {
      b.a(paramParcel, 34, parampd.aoR, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(32))) {
      b.a(paramParcel, 32, parampd.CE, true);
    }
    if (localSet.contains(Integer.valueOf(33))) {
      b.a(paramParcel, 33, parampd.aoQ, true);
    }
    if (localSet.contains(Integer.valueOf(38))) {
      b.a(paramParcel, 38, parampd.agh);
    }
    if (localSet.contains(Integer.valueOf(39))) {
      b.a(paramParcel, 39, parampd.mName, true);
    }
    if (localSet.contains(Integer.valueOf(36))) {
      b.a(paramParcel, 36, parampd.agg);
    }
    if (localSet.contains(Integer.valueOf(37))) {
      b.a(paramParcel, 37, parampd.aoS, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(42))) {
      b.a(paramParcel, 42, parampd.aoV, true);
    }
    if (localSet.contains(Integer.valueOf(43))) {
      b.a(paramParcel, 43, parampd.aoW, true);
    }
    if (localSet.contains(Integer.valueOf(40))) {
      b.a(paramParcel, 40, parampd.aoT, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(41))) {
      b.c(paramParcel, 41, parampd.aoU, true);
    }
    if (localSet.contains(Integer.valueOf(46))) {
      b.a(paramParcel, 46, parampd.aoZ, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(47))) {
      b.a(paramParcel, 47, parampd.apa, true);
    }
    if (localSet.contains(Integer.valueOf(44))) {
      b.a(paramParcel, 44, parampd.aoX, true);
    }
    if (localSet.contains(Integer.valueOf(45))) {
      b.a(paramParcel, 45, parampd.aoY, true);
    }
    if (localSet.contains(Integer.valueOf(51))) {
      b.a(paramParcel, 51, parampd.ape, true);
    }
    if (localSet.contains(Integer.valueOf(50))) {
      b.a(paramParcel, 50, parampd.apd, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(49))) {
      b.a(paramParcel, 49, parampd.apc, true);
    }
    if (localSet.contains(Integer.valueOf(48))) {
      b.a(paramParcel, 48, parampd.apb, true);
    }
    if (localSet.contains(Integer.valueOf(55))) {
      b.a(paramParcel, 55, parampd.apg, true);
    }
    if (localSet.contains(Integer.valueOf(54))) {
      b.a(paramParcel, 54, parampd.vf, true);
    }
    if (localSet.contains(Integer.valueOf(53))) {
      b.a(paramParcel, 53, parampd.vc, true);
    }
    if (localSet.contains(Integer.valueOf(52))) {
      b.a(paramParcel, 52, parampd.apf, true);
    }
    if (localSet.contains(Integer.valueOf(56))) {
      b.a(paramParcel, 56, parampd.aph, true);
    }
    b.H(paramParcel, i);
  }
  
  public pd dx(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    Object localObject1 = null;
    ArrayList localArrayList1 = null;
    Object localObject2 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    ArrayList localArrayList2 = null;
    int k = 0;
    ArrayList localArrayList3 = null;
    Object localObject3 = null;
    ArrayList localArrayList4 = null;
    String str4 = null;
    String str5 = null;
    Object localObject4 = null;
    String str6 = null;
    String str7 = null;
    String str8 = null;
    ArrayList localArrayList5 = null;
    String str9 = null;
    String str10 = null;
    String str11 = null;
    String str12 = null;
    String str13 = null;
    String str14 = null;
    String str15 = null;
    String str16 = null;
    String str17 = null;
    Object localObject5 = null;
    String str18 = null;
    String str19 = null;
    String str20 = null;
    String str21 = null;
    Object localObject6 = null;
    double d1 = 0.0D;
    Object localObject7 = null;
    double d2 = 0.0D;
    String str22 = null;
    Object localObject8 = null;
    ArrayList localArrayList6 = null;
    String str23 = null;
    String str24 = null;
    String str25 = null;
    String str26 = null;
    Object localObject9 = null;
    String str27 = null;
    String str28 = null;
    String str29 = null;
    Object localObject10 = null;
    String str30 = null;
    String str31 = null;
    String str32 = null;
    String str33 = null;
    String str34 = null;
    String str35 = null;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      case 35: 
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        pd localpd10 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        localObject1 = localpd10;
        break;
      case 3: 
        localArrayList1 = a.C(paramParcel, m);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        pd localpd9 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        localObject2 = localpd9;
        break;
      case 5: 
        str1 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        str2 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str3 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(7));
        break;
      case 8: 
        localArrayList2 = a.c(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9: 
        k = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 10: 
        localArrayList3 = a.c(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(10));
        break;
      case 11: 
        pd localpd8 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(11));
        localObject3 = localpd8;
        break;
      case 12: 
        localArrayList4 = a.c(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 13: 
        str4 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(13));
        break;
      case 14: 
        str5 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15: 
        pd localpd7 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(15));
        localObject4 = localpd7;
        break;
      case 17: 
        str7 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(17));
        break;
      case 16: 
        str6 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19: 
        localArrayList5 = a.c(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(19));
        break;
      case 18: 
        str8 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 21: 
        str10 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 20: 
        str9 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 23: 
        str12 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22: 
        str11 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 25: 
        str14 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 24: 
        str13 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 27: 
        str16 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 26: 
        str15 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 29: 
        pd localpd6 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(29));
        localObject5 = localpd6;
        break;
      case 28: 
        str17 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(28));
        break;
      case 31: 
        str19 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(31));
        break;
      case 30: 
        str18 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(30));
        break;
      case 34: 
        pd localpd5 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(34));
        localObject6 = localpd5;
        break;
      case 32: 
        str20 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(32));
        break;
      case 33: 
        str21 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(33));
        break;
      case 38: 
        d2 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(38));
        break;
      case 39: 
        str22 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(39));
        break;
      case 36: 
        d1 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(36));
        break;
      case 37: 
        pd localpd4 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(37));
        localObject7 = localpd4;
        break;
      case 42: 
        str23 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(42));
        break;
      case 43: 
        str24 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(43));
        break;
      case 40: 
        pd localpd3 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(40));
        localObject8 = localpd3;
        break;
      case 41: 
        localArrayList6 = a.c(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(41));
        break;
      case 46: 
        pd localpd2 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(46));
        localObject9 = localpd2;
        break;
      case 47: 
        str27 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(47));
        break;
      case 44: 
        str25 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(44));
        break;
      case 45: 
        str26 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(45));
        break;
      case 51: 
        str30 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(51));
        break;
      case 50: 
        pd localpd1 = (pd)a.a(paramParcel, m, pd.CREATOR);
        localHashSet.add(Integer.valueOf(50));
        localObject10 = localpd1;
        break;
      case 49: 
        str29 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(49));
        break;
      case 48: 
        str28 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(48));
        break;
      case 55: 
        str34 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(55));
        break;
      case 54: 
        str33 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(54));
        break;
      case 53: 
        str32 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(53));
        break;
      case 52: 
        str31 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(52));
        break;
      case 56: 
        str35 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(56));
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new pd(localHashSet, j, localObject1, localArrayList1, localObject2, str1, str2, str3, localArrayList2, k, localArrayList3, localObject3, localArrayList4, str4, str5, localObject4, str6, str7, str8, localArrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, localObject5, str18, str19, str20, str21, localObject6, d1, localObject7, d2, str22, localObject8, localArrayList6, str23, str24, str25, str26, localObject9, str27, str28, str29, localObject10, str30, str31, str32, str33, str34, str35);
  }
  
  public pd[] fv(int paramInt)
  {
    return new pd[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pe
 * JD-Core Version:    0.7.0.1
 */