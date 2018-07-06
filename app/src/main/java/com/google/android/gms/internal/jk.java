package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jk
  implements Parcelable.Creator<jj>
{
  static void a(jj paramjj, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramjj.version);
    b.c(paramParcel, 2, paramjj.MD);
    b.c(paramParcel, 3, paramjj.ME);
    b.a(paramParcel, 4, paramjj.MF, false);
    b.a(paramParcel, 5, paramjj.MG, false);
    b.a(paramParcel, 6, paramjj.MH, paramInt, false);
    b.a(paramParcel, 7, paramjj.MI, false);
    b.H(paramParcel, i);
  }
  
  public jj D(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int j = a.G(paramParcel);
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
    String str = null;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        k = a.g(paramParcel, n);
        break;
      case 3: 
        i = a.g(paramParcel, n);
        break;
      case 4: 
        str = a.o(paramParcel, n);
        break;
      case 5: 
        localIBinder = a.p(paramParcel, n);
        break;
      case 6: 
        arrayOfScope = (Scope[])a.b(paramParcel, n, Scope.CREATOR);
        break;
      case 7: 
        localBundle = a.q(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jj(m, k, i, str, localIBinder, arrayOfScope, localBundle);
  }
  
  public jj[] aC(int paramInt)
  {
    return new jj[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jk
 * JD-Core Version:    0.7.0.1
 */