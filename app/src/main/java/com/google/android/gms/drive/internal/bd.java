package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DrivePreferences;

public class bd
  implements Parcelable.Creator<SetDrivePreferencesRequest>
{
  static void a(SetDrivePreferencesRequest paramSetDrivePreferencesRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramSetDrivePreferencesRequest.CK);
    b.a(paramParcel, 2, paramSetDrivePreferencesRequest.QN, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public SetDrivePreferencesRequest aH(Parcel paramParcel)
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
    return new SetDrivePreferencesRequest(j, localDrivePreferences);
  }
  
  public SetDrivePreferencesRequest[] bW(int paramInt)
  {
    return new SetDrivePreferencesRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.bd
 * JD-Core Version:    0.7.0.1
 */