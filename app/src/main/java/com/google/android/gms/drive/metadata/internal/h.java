package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<MetadataBundle>
{
  static void a(MetadataBundle paramMetadataBundle, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramMetadataBundle.CK);
    b.a(paramParcel, 2, paramMetadataBundle.Ri, false);
    b.H(paramParcel, i);
  }
  
  public MetadataBundle aP(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    Bundle localBundle = null;
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
        localBundle = a.q(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new MetadataBundle(j, localBundle);
  }
  
  public MetadataBundle[] ce(int paramInt)
  {
    return new MetadataBundle[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.h
 * JD-Core Version:    0.7.0.1
 */