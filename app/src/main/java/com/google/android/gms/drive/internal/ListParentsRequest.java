package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ListParentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ListParentsRequest> CREATOR = new ai();
  final int CK;
  final DriveId QE;
  
  ListParentsRequest(int paramInt, DriveId paramDriveId)
  {
    this.CK = paramInt;
    this.QE = paramDriveId;
  }
  
  public ListParentsRequest(DriveId paramDriveId)
  {
    this(1, paramDriveId);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ai.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ListParentsRequest
 * JD-Core Version:    0.7.0.1
 */