package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.nn;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<GeofencingRequest>
{
  static void a(GeofencingRequest paramGeofencingRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramGeofencingRequest.ng(), false);
    b.c(paramParcel, 1000, paramGeofencingRequest.getVersionCode());
    b.c(paramParcel, 2, paramGeofencingRequest.getInitialTrigger());
    b.H(paramParcel, i);
  }
  
  public GeofencingRequest cI(Parcel paramParcel)
  {
    int i = 0;
    int j = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    ArrayList localArrayList = null;
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
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m, nn.CREATOR);
        break;
      case 1000: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        break;
      case 2: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new GeofencingRequest(k, localArrayList, i);
  }
  
  public GeofencingRequest[] ex(int paramInt)
  {
    return new GeofencingRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.a
 * JD-Core Version:    0.7.0.1
 */