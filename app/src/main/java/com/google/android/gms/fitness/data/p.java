package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class p
  implements Parcelable.Creator<Session>
{
  static void a(Session paramSession, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramSession.jo());
    b.c(paramParcel, 1000, paramSession.getVersionCode());
    b.a(paramParcel, 2, paramSession.jp());
    b.a(paramParcel, 3, paramSession.getName(), false);
    b.a(paramParcel, 4, paramSession.getIdentifier(), false);
    b.a(paramParcel, 5, paramSession.getDescription(), false);
    b.c(paramParcel, 7, paramSession.jm());
    b.a(paramParcel, 8, paramSession.jx(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public Session bC(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    a locala = null;
    int j = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    String str1 = null;
    String str2 = null;
    String str3 = null;
    long l2 = l1;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
        break;
      case 1: 
        l2 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, m);
        break;
      case 1000: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        break;
      case 2: 
        l1 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, m);
        break;
      case 3: 
        str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 4: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 5: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 7: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        break;
      case 8: 
        locala = (a)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, a.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new Session(k, l2, l1, str3, str2, str1, i, locala);
  }
  
  public Session[] cW(int paramInt)
  {
    return new Session[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.p
 * JD-Core Version:    0.7.0.1
 */