package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ba
  implements Parcelable.Creator<OpenFileIntentSenderRequest>
{
  static void a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOpenFileIntentSenderRequest.CK);
    b.a(paramParcel, 2, paramOpenFileIntentSenderRequest.OH, false);
    b.a(paramParcel, 3, paramOpenFileIntentSenderRequest.OI, false);
    b.a(paramParcel, 4, paramOpenFileIntentSenderRequest.OJ, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public OpenFileIntentSenderRequest aE(Parcel paramParcel)
  {
    DriveId localDriveId = null;
    int i = a.G(paramParcel);
    int j = 0;
    String[] arrayOfString = null;
    String str = null;
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
        arrayOfString = a.A(paramParcel, k);
        break;
      case 4: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new OpenFileIntentSenderRequest(j, str, arrayOfString, localDriveId);
  }
  
  public OpenFileIntentSenderRequest[] bT(int paramInt)
  {
    return new OpenFileIntentSenderRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ba
 * JD-Core Version:    0.7.0.1
 */