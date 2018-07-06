package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class pg
  implements Parcelable.Creator<pf>
{
  static void a(pf parampf, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    Set localSet = parampf.aon;
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, parampf.CK);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, parampf.CE, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, parampf.api, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, parampf.apa, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, parampf.apj, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, parampf.vc, true);
    }
    b.H(paramParcel, i);
  }
  
  public pf dy(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.G(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    Object localObject1 = null;
    String str2 = null;
    Object localObject2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      case 3: 
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str3 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 4: 
        pd localpd2 = (pd)a.a(paramParcel, k, pd.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        localObject2 = localpd2;
        break;
      case 5: 
        str2 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        pd localpd1 = (pd)a.a(paramParcel, k, pd.CREATOR);
        localHashSet.add(Integer.valueOf(6));
        localObject1 = localpd1;
        break;
      case 7: 
        str1 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new pf(localHashSet, j, str3, localObject2, str2, localObject1, str1);
  }
  
  public pf[] fw(int paramInt)
  {
    return new pf[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pg
 * JD-Core Version:    0.7.0.1
 */