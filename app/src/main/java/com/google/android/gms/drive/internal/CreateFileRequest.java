package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileRequest> CREATOR = new k();
  final int CK;
  final String Oy;
  final boolean PA;
  final int PB;
  final int PC;
  final Contents Pr;
  final MetadataBundle Px;
  final Integer Py;
  final DriveId Pz;
  
  CreateFileRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, Integer paramInteger, boolean paramBoolean, String paramString, int paramInt2, int paramInt3)
  {
    if ((paramContents != null) && (paramInt3 != 0)) {
      if (paramContents.getRequestId() != paramInt3) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      jx.b(bool, "inconsistent contents reference");
      if (((paramInteger != null) && (paramInteger.intValue() != 0)) || (paramContents != null) || (paramInt3 != 0)) {
        break;
      }
      throw new IllegalArgumentException("Need a valid contents");
    }
    this.CK = paramInt1;
    this.Pz = ((DriveId)jx.i(paramDriveId));
    this.Px = ((MetadataBundle)jx.i(paramMetadataBundle));
    this.Pr = paramContents;
    this.Py = paramInteger;
    this.Oy = paramString;
    this.PB = paramInt2;
    this.PA = paramBoolean;
    this.PC = paramInt3;
  }
  
  public CreateFileRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2, ExecutionOptions paramExecutionOptions)
  {
    this(2, paramDriveId, paramMetadataBundle, null, Integer.valueOf(paramInt2), paramExecutionOptions.iw(), paramExecutionOptions.iv(), paramExecutionOptions.ix(), paramInt1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CreateFileRequest
 * JD-Core Version:    0.7.0.1
 */