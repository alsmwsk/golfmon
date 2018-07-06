package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class j
  implements Parcelable.Creator<CreateFileIntentSenderRequest>
{
  static void a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramCreateFileIntentSenderRequest.CK);
    b.a(paramParcel, 2, paramCreateFileIntentSenderRequest.Px, paramInt, false);
    b.c(paramParcel, 3, paramCreateFileIntentSenderRequest.ve);
    b.a(paramParcel, 4, paramCreateFileIntentSenderRequest.OH, false);
    b.a(paramParcel, 5, paramCreateFileIntentSenderRequest.OJ, paramInt, false);
    b.a(paramParcel, 6, paramCreateFileIntentSenderRequest.Py, false);
    b.H(paramParcel, i);
  }
  
  public CreateFileIntentSenderRequest ag(Parcel paramParcel)
  {
    int i = 0;
    Integer localInteger = null;
    int j = a.G(paramParcel);
    DriveId localDriveId = null;
    String str = null;
    MetadataBundle localMetadataBundle = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, m, MetadataBundle.CREATOR);
        break;
      case 3: 
        i = a.g(paramParcel, m);
        break;
      case 4: 
        str = a.o(paramParcel, m);
        break;
      case 5: 
        localDriveId = (DriveId)a.a(paramParcel, m, DriveId.CREATOR);
        break;
      case 6: 
        localInteger = a.h(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new CreateFileIntentSenderRequest(k, localMetadataBundle, i, str, localDriveId, localInteger);
  }
  
  public CreateFileIntentSenderRequest[] br(int paramInt)
  {
    return new CreateFileIntentSenderRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.j
 * JD-Core Version:    0.7.0.1
 */