package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class SetDrivePreferencesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SetDrivePreferencesRequest> CREATOR = new bd();
  final int CK;
  final DrivePreferences QN;
  
  SetDrivePreferencesRequest(int paramInt, DrivePreferences paramDrivePreferences)
  {
    this.CK = paramInt;
    this.QN = paramDrivePreferences;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bd.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.SetDrivePreferencesRequest
 * JD-Core Version:    0.7.0.1
 */