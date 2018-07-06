package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class av
  implements Parcelable.Creator<OnResourceIdSetResponse>
{
  static void a(OnResourceIdSetResponse paramOnResourceIdSetResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOnResourceIdSetResponse.getVersionCode());
    b.b(paramParcel, 2, paramOnResourceIdSetResponse.iF(), false);
    b.H(paramParcel, i);
  }
  
  public OnResourceIdSetResponse aA(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
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
        localArrayList = a.C(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new OnResourceIdSetResponse(j, localArrayList);
  }
  
  public OnResourceIdSetResponse[] bP(int paramInt)
  {
    return new OnResourceIdSetResponse[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.av
 * JD-Core Version:    0.7.0.1
 */