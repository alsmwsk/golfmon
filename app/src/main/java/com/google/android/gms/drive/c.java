package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<DriveId>
{
  static void a(DriveId paramDriveId, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramDriveId.CK);
    b.a(paramParcel, 2, paramDriveId.Ot, false);
    b.a(paramParcel, 3, paramDriveId.Ou);
    b.a(paramParcel, 4, paramDriveId.Ov);
    b.H(paramParcel, i);
  }
  
  public DriveId S(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = a.G(paramParcel);
    int j = 0;
    String str = null;
    long l2 = l1;
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
        str = a.o(paramParcel, k);
        break;
      case 3: 
        l2 = a.i(paramParcel, k);
        break;
      case 4: 
        l1 = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new DriveId(j, str, l2, l1);
  }
  
  public DriveId[] aY(int paramInt)
  {
    return new DriveId[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.c
 * JD-Core Version:    0.7.0.1
 */