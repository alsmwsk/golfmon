package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnSyncMoreResponse> CREATOR = new ax();
  final int CK;
  final boolean PJ;
  
  OnSyncMoreResponse(int paramInt, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.PJ = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ax.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnSyncMoreResponse
 * JD-Core Version:    0.7.0.1
 */