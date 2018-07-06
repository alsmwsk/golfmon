package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<CreateContentsRequest>
{
  static void a(CreateContentsRequest paramCreateContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramCreateContentsRequest.CK);
    b.c(paramParcel, 2, paramCreateContentsRequest.Oi);
    b.H(paramParcel, i);
  }
  
  public CreateContentsRequest af(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    int k = 536870912;
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
        k = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new CreateContentsRequest(j, k);
  }
  
  public CreateContentsRequest[] bp(int paramInt)
  {
    return new CreateContentsRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.h
 * JD-Core Version:    0.7.0.1
 */