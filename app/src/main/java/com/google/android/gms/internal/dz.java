package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dz
  implements Parcelable.Creator<ea>
{
  static void a(ea paramea, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramea.versionCode);
    b.a(paramParcel, 3, paramea.cu(), false);
    b.a(paramParcel, 4, paramea.cv(), false);
    b.a(paramParcel, 5, paramea.cw(), false);
    b.a(paramParcel, 6, paramea.ct(), false);
    b.H(paramParcel, i);
  }
  
  public ea g(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder4 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      case 2: 
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 3: 
        localIBinder4 = a.p(paramParcel, k);
        break;
      case 4: 
        localIBinder3 = a.p(paramParcel, k);
        break;
      case 5: 
        localIBinder2 = a.p(paramParcel, k);
        break;
      case 6: 
        localIBinder1 = a.p(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new ea(j, localIBinder4, localIBinder3, localIBinder2, localIBinder1);
  }
  
  public ea[] o(int paramInt)
  {
    return new ea[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dz
 * JD-Core Version:    0.7.0.1
 */