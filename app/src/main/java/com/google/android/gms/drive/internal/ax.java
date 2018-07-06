package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ax
  implements Parcelable.Creator<OnSyncMoreResponse>
{
  static void a(OnSyncMoreResponse paramOnSyncMoreResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOnSyncMoreResponse.CK);
    b.a(paramParcel, 2, paramOnSyncMoreResponse.PJ);
    b.H(paramParcel, i);
  }
  
  public OnSyncMoreResponse aC(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    int j = 0;
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
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new OnSyncMoreResponse(j, bool);
  }
  
  public OnSyncMoreResponse[] bR(int paramInt)
  {
    return new OnSyncMoreResponse[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ax
 * JD-Core Version:    0.7.0.1
 */