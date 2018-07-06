package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DrivePreferences
  implements SafeParcelable
{
  public static final Parcelable.Creator<DrivePreferences> CREATOR = new d();
  final int CK;
  final boolean Ox;
  
  DrivePreferences(int paramInt, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.Ox = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DrivePreferences
 * JD-Core Version:    0.7.0.1
 */