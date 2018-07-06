package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<ReferenceShiftedDetails>
{
  static void a(ReferenceShiftedDetails paramReferenceShiftedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramReferenceShiftedDetails.CK);
    b.a(paramParcel, 2, paramReferenceShiftedDetails.Te, false);
    b.a(paramParcel, 3, paramReferenceShiftedDetails.Tf, false);
    b.c(paramParcel, 4, paramReferenceShiftedDetails.Tg);
    b.c(paramParcel, 5, paramReferenceShiftedDetails.Th);
    b.H(paramParcel, i);
  }
  
  public ReferenceShiftedDetails bj(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = a.G(paramParcel);
    int k = 0;
    String str2 = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        str2 = a.o(paramParcel, n);
        break;
      case 3: 
        str1 = a.o(paramParcel, n);
        break;
      case 4: 
        k = a.g(paramParcel, n);
        break;
      case 5: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ReferenceShiftedDetails(m, str2, str1, k, i);
  }
  
  public ReferenceShiftedDetails[] cz(int paramInt)
  {
    return new ReferenceShiftedDetails[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.d
 * JD-Core Version:    0.7.0.1
 */