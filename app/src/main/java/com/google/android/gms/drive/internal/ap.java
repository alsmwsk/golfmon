package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DrivePreferences;

public class ap
  implements Parcelable.Creator<OnDrivePreferencesResponse>
{
  static void a(OnDrivePreferencesResponse paramOnDrivePreferencesResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOnDrivePreferencesResponse.CK);
    b.a(paramParcel, 2, paramOnDrivePreferencesResponse.QN, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public OnDrivePreferencesResponse au(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    DrivePreferences localDrivePreferences = null;
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
        localDrivePreferences = (DrivePreferences)a.a(paramParcel, k, DrivePreferences.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new OnDrivePreferencesResponse(j, localDrivePreferences);
  }
  
  public OnDrivePreferencesResponse[] bJ(int paramInt)
  {
    return new OnDrivePreferencesResponse[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ap
 * JD-Core Version:    0.7.0.1
 */