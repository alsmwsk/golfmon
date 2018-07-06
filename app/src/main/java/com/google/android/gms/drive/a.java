package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<Contents>
{
  static void a(Contents paramContents, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramContents.CK);
    b.a(paramParcel, 2, paramContents.LG, paramInt, false);
    b.c(paramParcel, 3, paramContents.ve);
    b.c(paramParcel, 4, paramContents.Oi);
    b.a(paramParcel, 5, paramContents.Oj, paramInt, false);
    b.a(paramParcel, 7, paramContents.Ok);
    b.H(paramParcel, i);
  }
  
  public Contents R(Parcel paramParcel)
  {
    DriveId localDriveId = null;
    boolean bool = false;
    int i = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    int j = 0;
    int k = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
    int m = 0;
    while (paramParcel.dataPosition() < i)
    {
      int n = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(n))
      {
      case 6: 
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, n);
        break;
      case 1: 
        m = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 2: 
        localParcelFileDescriptor = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, ParcelFileDescriptor.CREATOR);
        break;
      case 3: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 4: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 5: 
        localDriveId = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, DriveId.CREATOR);
        break;
      case 7: 
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new Contents(m, localParcelFileDescriptor, k, j, localDriveId, bool);
  }
  
  public Contents[] aX(int paramInt)
  {
    return new Contents[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.a
 * JD-Core Version:    0.7.0.1
 */