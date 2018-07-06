package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnStorageStatsResponse> CREATOR = new aw();
  final int CK;
  StorageStats QS;
  
  OnStorageStatsResponse(int paramInt, StorageStats paramStorageStats)
  {
    this.CK = paramInt;
    this.QS = paramStorageStats;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aw.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnStorageStatsResponse
 * JD-Core Version:    0.7.0.1
 */