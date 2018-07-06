package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class k
  implements Parcelable.Creator<CreateFileRequest>
{
  static void a(CreateFileRequest paramCreateFileRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramCreateFileRequest.CK);
    b.a(paramParcel, 2, paramCreateFileRequest.Pz, paramInt, false);
    b.a(paramParcel, 3, paramCreateFileRequest.Px, paramInt, false);
    b.a(paramParcel, 4, paramCreateFileRequest.Pr, paramInt, false);
    b.a(paramParcel, 5, paramCreateFileRequest.Py, false);
    b.a(paramParcel, 6, paramCreateFileRequest.PA);
    b.a(paramParcel, 7, paramCreateFileRequest.Oy, false);
    b.c(paramParcel, 8, paramCreateFileRequest.PB);
    b.c(paramParcel, 9, paramCreateFileRequest.PC);
    b.H(paramParcel, i);
  }
  
  public CreateFileRequest ah(Parcel paramParcel)
  {
    int i = 0;
    String str = null;
    int j = a.G(paramParcel);
    int k = 0;
    boolean bool = false;
    Integer localInteger = null;
    Contents localContents = null;
    MetadataBundle localMetadataBundle = null;
    DriveId localDriveId = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, n, DriveId.CREATOR);
        break;
      case 3: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, n, MetadataBundle.CREATOR);
        break;
      case 4: 
        localContents = (Contents)a.a(paramParcel, n, Contents.CREATOR);
        break;
      case 5: 
        localInteger = a.h(paramParcel, n);
        break;
      case 6: 
        bool = a.c(paramParcel, n);
        break;
      case 7: 
        str = a.o(paramParcel, n);
        break;
      case 8: 
        k = a.g(paramParcel, n);
        break;
      case 9: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new CreateFileRequest(m, localDriveId, localMetadataBundle, localContents, localInteger, bool, str, k, i);
  }
  
  public CreateFileRequest[] bs(int paramInt)
  {
    return new CreateFileRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.k
 * JD-Core Version:    0.7.0.1
 */