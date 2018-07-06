package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class z
  implements Parcelable.Creator<y>
{
  static void a(y paramy, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramy.getVersionCode());
    b.a(paramParcel, 2, paramy.oa(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public y cZ(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    Point localPoint = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localPoint = (Point)a.a(paramParcel, k, Point.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new y(j, localPoint);
  }
  
  public y[] eV(int paramInt)
  {
    return new y[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.z
 * JD-Core Version:    0.7.0.1
 */