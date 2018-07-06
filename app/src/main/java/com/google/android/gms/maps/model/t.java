package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class t
  implements Parcelable.Creator<StreetViewPanoramaOrientation>
{
  static void a(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaOrientation.getVersionCode());
    b.a(paramParcel, 2, paramStreetViewPanoramaOrientation.tilt);
    b.a(paramParcel, 3, paramStreetViewPanoramaOrientation.bearing);
    b.H(paramParcel, i);
  }
  
  public StreetViewPanoramaOrientation dl(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int i = a.G(paramParcel);
    int j = 0;
    float f2 = 0.0F;
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
        f2 = a.l(paramParcel, k);
        break;
      case 3: 
        f1 = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new StreetViewPanoramaOrientation(j, f2, f1);
  }
  
  public StreetViewPanoramaOrientation[] fh(int paramInt)
  {
    return new StreetViewPanoramaOrientation[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.t
 * JD-Core Version:    0.7.0.1
 */