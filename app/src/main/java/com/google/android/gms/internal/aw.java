package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class aw
  implements Parcelable.Creator<av>
{
  static void a(av paramav, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramav.versionCode);
    b.a(paramParcel, 2, paramav.od);
    b.a(paramParcel, 3, paramav.extras, false);
    b.c(paramParcel, 4, paramav.oe);
    b.b(paramParcel, 5, paramav.of, false);
    b.a(paramParcel, 6, paramav.og);
    b.c(paramParcel, 7, paramav.oh);
    b.a(paramParcel, 8, paramav.oi);
    b.a(paramParcel, 9, paramav.oj, false);
    b.a(paramParcel, 10, paramav.ok, paramInt, false);
    b.a(paramParcel, 11, paramav.ol, paramInt, false);
    b.a(paramParcel, 12, paramav.om, false);
    b.a(paramParcel, 13, paramav.on, false);
    b.H(paramParcel, i);
  }
  
  public av b(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    long l = 0L;
    Bundle localBundle1 = null;
    int k = 0;
    ArrayList localArrayList = null;
    boolean bool1 = false;
    int m = 0;
    boolean bool2 = false;
    String str1 = null;
    bj localbj = null;
    Location localLocation = null;
    String str2 = null;
    Bundle localBundle2 = null;
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
        l = a.i(paramParcel, n);
        break;
      case 3: 
        localBundle1 = a.q(paramParcel, n);
        break;
      case 4: 
        k = a.g(paramParcel, n);
        break;
      case 5: 
        localArrayList = a.C(paramParcel, n);
        break;
      case 6: 
        bool1 = a.c(paramParcel, n);
        break;
      case 7: 
        m = a.g(paramParcel, n);
        break;
      case 8: 
        bool2 = a.c(paramParcel, n);
        break;
      case 9: 
        str1 = a.o(paramParcel, n);
        break;
      case 10: 
        localbj = (bj)a.a(paramParcel, n, bj.CREATOR);
        break;
      case 11: 
        localLocation = (Location)a.a(paramParcel, n, Location.CREATOR);
        break;
      case 12: 
        str2 = a.o(paramParcel, n);
        break;
      case 13: 
        localBundle2 = a.q(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new av(j, l, localBundle1, k, localArrayList, bool1, m, bool2, str1, localbj, localLocation, str2, localBundle2);
  }
  
  public av[] f(int paramInt)
  {
    return new av[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.aw
 * JD-Core Version:    0.7.0.1
 */