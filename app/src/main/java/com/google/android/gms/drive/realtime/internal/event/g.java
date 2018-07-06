package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g
  implements Parcelable.Creator<ValueChangedDetails>
{
  static void a(ValueChangedDetails paramValueChangedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramValueChangedDetails.CK);
    b.c(paramParcel, 2, paramValueChangedDetails.Tj);
    b.H(paramParcel, i);
  }
  
  public ValueChangedDetails bm(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ValueChangedDetails(k, i);
  }
  
  public ValueChangedDetails[] cC(int paramInt)
  {
    return new ValueChangedDetails[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.g
 * JD-Core Version:    0.7.0.1
 */