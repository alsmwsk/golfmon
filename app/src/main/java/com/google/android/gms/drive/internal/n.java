package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class n
  implements Parcelable.Creator<DeleteResourceRequest>
{
  static void a(DeleteResourceRequest paramDeleteResourceRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramDeleteResourceRequest.CK);
    b.a(paramParcel, 2, paramDeleteResourceRequest.Pp, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public DeleteResourceRequest aj(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
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
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new DeleteResourceRequest(j, localDriveId);
  }
  
  public DeleteResourceRequest[] bu(int paramInt)
  {
    return new DeleteResourceRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.n
 * JD-Core Version:    0.7.0.1
 */