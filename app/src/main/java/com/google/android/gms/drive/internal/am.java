package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class am
  implements Parcelable.Creator<OnDeviceUsagePreferenceResponse>
{
  static void a(OnDeviceUsagePreferenceResponse paramOnDeviceUsagePreferenceResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOnDeviceUsagePreferenceResponse.CK);
    b.a(paramParcel, 2, paramOnDeviceUsagePreferenceResponse.QK, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public OnDeviceUsagePreferenceResponse ar(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    FileUploadPreferencesImpl localFileUploadPreferencesImpl = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localFileUploadPreferencesImpl = (FileUploadPreferencesImpl)a.a(paramParcel, k, FileUploadPreferencesImpl.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new OnDeviceUsagePreferenceResponse(j, localFileUploadPreferencesImpl);
  }
  
  public OnDeviceUsagePreferenceResponse[] bG(int paramInt)
  {
    return new OnDeviceUsagePreferenceResponse[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.am
 * JD-Core Version:    0.7.0.1
 */