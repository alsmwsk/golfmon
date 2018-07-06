package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnLoadRealtimeResponse> CREATOR = new au();
  final int CK;
  final boolean wg;
  
  OnLoadRealtimeResponse(int paramInt, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.wg = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    au.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnLoadRealtimeResponse
 * JD-Core Version:    0.7.0.1
 */