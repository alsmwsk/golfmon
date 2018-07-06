package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class p
  implements Parcelable.Creator<ParcelableCollaborator>
{
  static void a(ParcelableCollaborator paramParcelableCollaborator, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramParcelableCollaborator.CK);
    b.a(paramParcel, 2, paramParcelableCollaborator.SH);
    b.a(paramParcel, 3, paramParcelableCollaborator.SI);
    b.a(paramParcel, 4, paramParcelableCollaborator.vZ, false);
    b.a(paramParcel, 5, paramParcelableCollaborator.SJ, false);
    b.a(paramParcel, 6, paramParcelableCollaborator.OS, false);
    b.a(paramParcel, 7, paramParcelableCollaborator.SK, false);
    b.a(paramParcel, 8, paramParcelableCollaborator.SL, false);
    b.H(paramParcel, i);
  }
  
  public ParcelableCollaborator be(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int i = a.G(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    boolean bool2 = false;
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
        bool2 = a.c(paramParcel, k);
        break;
      case 3: 
        bool1 = a.c(paramParcel, k);
        break;
      case 4: 
        str5 = a.o(paramParcel, k);
        break;
      case 5: 
        str4 = a.o(paramParcel, k);
        break;
      case 6: 
        str3 = a.o(paramParcel, k);
        break;
      case 7: 
        str2 = a.o(paramParcel, k);
        break;
      case 8: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new ParcelableCollaborator(j, bool2, bool1, str5, str4, str3, str2, str1);
  }
  
  public ParcelableCollaborator[] cu(int paramInt)
  {
    return new ParcelableCollaborator[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.p
 * JD-Core Version:    0.7.0.1
 */