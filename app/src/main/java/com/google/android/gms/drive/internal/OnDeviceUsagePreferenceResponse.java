package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDeviceUsagePreferenceResponse> CREATOR = new am();
  final int CK;
  final FileUploadPreferencesImpl QK;
  
  OnDeviceUsagePreferenceResponse(int paramInt, FileUploadPreferencesImpl paramFileUploadPreferencesImpl)
  {
    this.CK = paramInt;
    this.QK = paramFileUploadPreferencesImpl;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public FileUploadPreferencesImpl iN()
  {
    return this.QK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    am.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse
 * JD-Core Version:    0.7.0.1
 */