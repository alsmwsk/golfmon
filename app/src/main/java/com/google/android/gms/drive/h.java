package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<UserMetadata>
{
  static void a(UserMetadata paramUserMetadata, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramUserMetadata.CK);
    b.a(paramParcel, 2, paramUserMetadata.OR, false);
    b.a(paramParcel, 3, paramUserMetadata.OS, false);
    b.a(paramParcel, 4, paramUserMetadata.OT, false);
    b.a(paramParcel, 5, paramUserMetadata.OU);
    b.a(paramParcel, 6, paramUserMetadata.OV, false);
    b.H(paramParcel, i);
  }
  
  public UserMetadata W(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int i = a.G(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        str4 = a.o(paramParcel, k);
        break;
      case 3: 
        str3 = a.o(paramParcel, k);
        break;
      case 4: 
        str2 = a.o(paramParcel, k);
        break;
      case 5: 
        bool = a.c(paramParcel, k);
        break;
      case 6: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new UserMetadata(j, str4, str3, str2, bool, str1);
  }
  
  public UserMetadata[] be(int paramInt)
  {
    return new UserMetadata[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.h
 * JD-Core Version:    0.7.0.1
 */