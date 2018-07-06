package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class as
  implements Parcelable.Creator<OnListParentsResponse>
{
  static void a(OnListParentsResponse paramOnListParentsResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOnListParentsResponse.CK);
    b.a(paramParcel, 2, paramOnListParentsResponse.QR, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public OnListParentsResponse ax(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    DataHolder localDataHolder = null;
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
        localDataHolder = (DataHolder)a.a(paramParcel, k, DataHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new OnListParentsResponse(j, localDataHolder);
  }
  
  public OnListParentsResponse[] bM(int paramInt)
  {
    return new OnListParentsResponse[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.as
 * JD-Core Version:    0.7.0.1
 */