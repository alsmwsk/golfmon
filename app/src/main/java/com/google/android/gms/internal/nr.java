package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class nr
  implements Parcelable.Creator<nq>
{
  static void a(nq paramnq, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramnq.nr());
    b.c(paramParcel, 1000, paramnq.CK);
    b.c(paramParcel, 2, paramnq.ahn, false);
    b.H(paramParcel, i);
  }
  
  public nq cO(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    ArrayList localArrayList = null;
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
        bool = a.c(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList = a.c(paramParcel, k, oa.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new nq(j, bool, localArrayList);
  }
  
  public nq[] eK(int paramInt)
  {
    return new nq[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nr
 * JD-Core Version:    0.7.0.1
 */