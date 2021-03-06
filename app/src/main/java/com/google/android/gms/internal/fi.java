package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class fi
  implements Parcelable.Creator<fh>
{
  static void a(fh paramfh, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramfh.versionCode);
    b.a(paramParcel, 2, paramfh.tK, false);
    b.a(paramParcel, 3, paramfh.tL, paramInt, false);
    b.a(paramParcel, 4, paramfh.lS, paramInt, false);
    b.a(paramParcel, 5, paramfh.lL, false);
    b.a(paramParcel, 6, paramfh.applicationInfo, paramInt, false);
    b.a(paramParcel, 7, paramfh.tM, paramInt, false);
    b.a(paramParcel, 8, paramfh.tN, false);
    b.a(paramParcel, 9, paramfh.tO, false);
    b.a(paramParcel, 10, paramfh.tP, false);
    b.a(paramParcel, 11, paramfh.lO, paramInt, false);
    b.a(paramParcel, 12, paramfh.tQ, false);
    b.c(paramParcel, 13, paramfh.tR);
    b.b(paramParcel, 14, paramfh.mc, false);
    b.a(paramParcel, 15, paramfh.tS, false);
    b.a(paramParcel, 16, paramfh.tT);
    b.H(paramParcel, i);
  }
  
  public fh h(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    Bundle localBundle1 = null;
    av localav = null;
    ay localay = null;
    String str1 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    gs localgs = null;
    Bundle localBundle2 = null;
    int k = 0;
    ArrayList localArrayList = null;
    Bundle localBundle3 = null;
    boolean bool = false;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localBundle1 = a.q(paramParcel, m);
        break;
      case 3: 
        localav = (av)a.a(paramParcel, m, av.CREATOR);
        break;
      case 4: 
        localay = (ay)a.a(paramParcel, m, ay.CREATOR);
        break;
      case 5: 
        str1 = a.o(paramParcel, m);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)a.a(paramParcel, m, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)a.a(paramParcel, m, PackageInfo.CREATOR);
        break;
      case 8: 
        str2 = a.o(paramParcel, m);
        break;
      case 9: 
        str3 = a.o(paramParcel, m);
        break;
      case 10: 
        str4 = a.o(paramParcel, m);
        break;
      case 11: 
        localgs = (gs)a.a(paramParcel, m, gs.CREATOR);
        break;
      case 12: 
        localBundle2 = a.q(paramParcel, m);
        break;
      case 13: 
        k = a.g(paramParcel, m);
        break;
      case 14: 
        localArrayList = a.C(paramParcel, m);
        break;
      case 15: 
        localBundle3 = a.q(paramParcel, m);
        break;
      case 16: 
        bool = a.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new fh(j, localBundle1, localav, localay, str1, localApplicationInfo, localPackageInfo, str2, str3, str4, localgs, localBundle2, k, localArrayList, localBundle3, bool);
  }
  
  public fh[] q(int paramInt)
  {
    return new fh[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fi
 * JD-Core Version:    0.7.0.1
 */