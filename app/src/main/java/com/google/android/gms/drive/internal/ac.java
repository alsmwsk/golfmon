package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ac
  implements Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest>
{
  static void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramGetDriveIdFromUniqueIdentifierRequest.CK);
    b.a(paramParcel, 2, paramGetDriveIdFromUniqueIdentifierRequest.QC, false);
    b.a(paramParcel, 3, paramGetDriveIdFromUniqueIdentifierRequest.QD);
    b.H(paramParcel, i);
  }
  
  public GetDriveIdFromUniqueIdentifierRequest am(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    String str = null;
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
        str = a.o(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new GetDriveIdFromUniqueIdentifierRequest(j, str, bool);
  }
  
  public GetDriveIdFromUniqueIdentifierRequest[] bB(int paramInt)
  {
    return new GetDriveIdFromUniqueIdentifierRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ac
 * JD-Core Version:    0.7.0.1
 */