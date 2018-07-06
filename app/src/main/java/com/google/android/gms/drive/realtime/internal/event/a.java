package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<ObjectChangedDetails>
{
  static void a(ObjectChangedDetails paramObjectChangedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramObjectChangedDetails.CK);
    b.c(paramParcel, 2, paramObjectChangedDetails.SO);
    b.c(paramParcel, 3, paramObjectChangedDetails.SP);
    b.H(paramParcel, i);
  }
  
  public ObjectChangedDetails bg(Parcel paramParcel)
  {
    int i = 0;
    int j = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(n))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, n);
        break;
      case 1: 
        m = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 2: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 3: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ObjectChangedDetails(m, k, i);
  }
  
  public ObjectChangedDetails[] cw(int paramInt)
  {
    return new ObjectChangedDetails[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.a
 * JD-Core Version:    0.7.0.1
 */