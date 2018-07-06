package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new f();
  final int CK;
  final String Oy;
  final boolean Oz;
  final DriveId Pp;
  final MetadataBundle Pq;
  final Contents Pr;
  final int Ps;
  
  CloseContentsAndUpdateMetadataRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, boolean paramBoolean, String paramString, int paramInt2)
  {
    this.CK = paramInt1;
    this.Pp = paramDriveId;
    this.Pq = paramMetadataBundle;
    this.Pr = paramContents;
    this.Oz = paramBoolean;
    this.Oy = paramString;
    this.Ps = paramInt2;
  }
  
  public CloseContentsAndUpdateMetadataRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, ExecutionOptions paramExecutionOptions)
  {
    this(1, paramDriveId, paramMetadataBundle, paramContents, paramExecutionOptions.iw(), paramExecutionOptions.iv(), paramExecutionOptions.ix());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest
 * JD-Core Version:    0.7.0.1
 */