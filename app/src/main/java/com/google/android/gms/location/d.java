package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<LocationRequest>
{
  static void a(LocationRequest paramLocationRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramLocationRequest.mPriority);
    b.c(paramParcel, 1000, paramLocationRequest.getVersionCode());
    b.a(paramParcel, 2, paramLocationRequest.agr);
    b.a(paramParcel, 3, paramLocationRequest.ags);
    b.a(paramParcel, 4, paramLocationRequest.Wg);
    b.a(paramParcel, 5, paramLocationRequest.age);
    b.c(paramParcel, 6, paramLocationRequest.agt);
    b.a(paramParcel, 7, paramLocationRequest.agu);
    b.a(paramParcel, 8, paramLocationRequest.agv);
    b.H(paramParcel, i);
  }
  
  public LocationRequest cJ(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    int k = 102;
    long l1 = 3600000L;
    long l2 = 600000L;
    boolean bool = false;
    long l3 = 9223372036854775807L;
    int m = 2147483647;
    float f = 0.0F;
    long l4 = 0L;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 1000: 
        j = a.g(paramParcel, n);
        break;
      case 2: 
        l1 = a.i(paramParcel, n);
        break;
      case 3: 
        l2 = a.i(paramParcel, n);
        break;
      case 4: 
        bool = a.c(paramParcel, n);
        break;
      case 5: 
        l3 = a.i(paramParcel, n);
        break;
      case 6: 
        m = a.g(paramParcel, n);
        break;
      case 7: 
        f = a.l(paramParcel, n);
        break;
      case 8: 
        l4 = a.i(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new LocationRequest(j, k, l1, l2, bool, l3, m, f, l4);
  }
  
  public LocationRequest[] eA(int paramInt)
  {
    return new LocationRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.d
 * JD-Core Version:    0.7.0.1
 */