package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aj
  implements Parcelable.Creator<ai>
{
  static void a(ai paramai, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramai.CK);
    b.c(paramParcel, 2, paramai.getRequestId());
    b.a(paramParcel, 3, paramai.getPath(), false);
    b.a(paramParcel, 4, paramai.getData(), false);
    b.a(paramParcel, 5, paramai.getSourceNodeId(), false);
    b.H(paramParcel, i);
  }
  
  public ai ey(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int j = a.G(paramParcel);
    byte[] arrayOfByte = null;
    String str2 = null;
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
        break;
      case 3: 
        str2 = a.o(paramParcel, m);
        break;
      case 4: 
        arrayOfByte = a.r(paramParcel, m);
        break;
      case 5: 
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ai(k, i, str2, arrayOfByte, str1);
  }
  
  public ai[] gH(int paramInt)
  {
    return new ai[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.aj
 * JD-Core Version:    0.7.0.1
 */