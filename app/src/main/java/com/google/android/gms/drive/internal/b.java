package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.drive.DriveId;

public class b
  implements Parcelable.Creator<AuthorizeAccessRequest>
{
  static void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.H(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramAuthorizeAccessRequest.CK);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramAuthorizeAccessRequest.Pn);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramAuthorizeAccessRequest.Oj, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.H(paramParcel, i);
  }
  
  public AuthorizeAccessRequest aa(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    long l = 0L;
    DriveId localDriveId = null;
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
        l = a.i(paramParcel, k);
        break;
      case 3: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new AuthorizeAccessRequest(j, l, localDriveId);
  }
  
  public AuthorizeAccessRequest[] bk(int paramInt)
  {
    return new AuthorizeAccessRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.b
 * JD-Core Version:    0.7.0.1
 */