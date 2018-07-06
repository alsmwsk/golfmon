package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dq
  implements Parcelable.Creator<dr>
{
  static void a(dr paramdr, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramdr.versionCode);
    b.a(paramParcel, 2, paramdr.sb, paramInt, false);
    b.a(paramParcel, 3, paramdr.ck(), false);
    b.a(paramParcel, 4, paramdr.cl(), false);
    b.a(paramParcel, 5, paramdr.cm(), false);
    b.a(paramParcel, 6, paramdr.cn(), false);
    b.a(paramParcel, 7, paramdr.sg, false);
    b.a(paramParcel, 8, paramdr.sh);
    b.a(paramParcel, 9, paramdr.si, false);
    b.a(paramParcel, 10, paramdr.cp(), false);
    b.c(paramParcel, 11, paramdr.orientation);
    b.c(paramParcel, 12, paramdr.sk);
    b.a(paramParcel, 13, paramdr.rH, false);
    b.a(paramParcel, 14, paramdr.lO, paramInt, false);
    b.a(paramParcel, 15, paramdr.co(), false);
    b.a(paramParcel, 17, paramdr.sn, paramInt, false);
    b.a(paramParcel, 16, paramdr.sm, false);
    b.H(paramParcel, i);
  }
  
  public dr f(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    do localdo = null;
    IBinder localIBinder1 = null;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder4 = null;
    String str1 = null;
    boolean bool = false;
    String str2 = null;
    IBinder localIBinder5 = null;
    int k = 0;
    int m = 0;
    String str3 = null;
    gs localgs = null;
    IBinder localIBinder6 = null;
    String str4 = null;
    y localy = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        j = a.g(paramParcel, n);
        break;
      case 2: 
        localdo = (do)a.a(paramParcel, n, do.CREATOR);
        break;
      case 3: 
        localIBinder1 = a.p(paramParcel, n);
        break;
      case 4: 
        localIBinder2 = a.p(paramParcel, n);
        break;
      case 5: 
        localIBinder3 = a.p(paramParcel, n);
        break;
      case 6: 
        localIBinder4 = a.p(paramParcel, n);
        break;
      case 7: 
        str1 = a.o(paramParcel, n);
        break;
      case 8: 
        bool = a.c(paramParcel, n);
        break;
      case 9: 
        str2 = a.o(paramParcel, n);
        break;
      case 10: 
        localIBinder5 = a.p(paramParcel, n);
        break;
      case 11: 
        k = a.g(paramParcel, n);
        break;
      case 12: 
        m = a.g(paramParcel, n);
        break;
      case 13: 
        str3 = a.o(paramParcel, n);
        break;
      case 14: 
        localgs = (gs)a.a(paramParcel, n, gs.CREATOR);
        break;
      case 15: 
        localIBinder6 = a.p(paramParcel, n);
        break;
      case 17: 
        localy = (y)a.a(paramParcel, n, y.CREATOR);
        break;
      case 16: 
        str4 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new dr(j, localdo, localIBinder1, localIBinder2, localIBinder3, localIBinder4, str1, bool, str2, localIBinder5, k, m, str3, localgs, localIBinder6, str4, localy);
  }
  
  public dr[] n(int paramInt)
  {
    return new dr[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dq
 * JD-Core Version:    0.7.0.1
 */