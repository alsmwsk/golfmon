package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<DrivePreferences>
{
  static void a(DrivePreferences paramDrivePreferences, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramDrivePreferences.CK);
    b.a(paramParcel, 2, paramDrivePreferences.Ox);
    b.H(paramParcel, i);
  }
  
  public DrivePreferences T(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    int j = 0;
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
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new DrivePreferences(j, bool);
  }
  
  public DrivePreferences[] aZ(int paramInt)
  {
    return new DrivePreferences[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.d
 * JD-Core Version:    0.7.0.1
 */