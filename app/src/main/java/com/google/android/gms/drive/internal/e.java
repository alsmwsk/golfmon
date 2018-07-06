package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class e
  implements Parcelable.Creator<CheckResourceIdsExistRequest>
{
  static void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramCheckResourceIdsExistRequest.getVersionCode());
    b.b(paramParcel, 2, paramCheckResourceIdsExistRequest.iF(), false);
    b.H(paramParcel, i);
  }
  
  public CheckResourceIdsExistRequest ac(Parcel paramParcel)
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
    return new CheckResourceIdsExistRequest(j, localArrayList);
  }
  
  public CheckResourceIdsExistRequest[] bm(int paramInt)
  {
    return new CheckResourceIdsExistRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.e
 * JD-Core Version:    0.7.0.1
 */