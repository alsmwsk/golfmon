package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new j();
  final int CK;
  final String OH;
  final DriveId OJ;
  final MetadataBundle Px;
  final Integer Py;
  final int ve;
  
  CreateFileIntentSenderRequest(int paramInt1, MetadataBundle paramMetadataBundle, int paramInt2, String paramString, DriveId paramDriveId, Integer paramInteger)
  {
    this.CK = paramInt1;
    this.Px = paramMetadataBundle;
    this.ve = paramInt2;
    this.OH = paramString;
    this.OJ = paramDriveId;
    this.Py = paramInteger;
  }
  
  public CreateFileIntentSenderRequest(MetadataBundle paramMetadataBundle, int paramInt1, String paramString, DriveId paramDriveId, int paramInt2)
  {
    this(1, paramMetadataBundle, paramInt1, paramString, paramDriveId, Integer.valueOf(paramInt2));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CreateFileIntentSenderRequest
 * JD-Core Version:    0.7.0.1
 */