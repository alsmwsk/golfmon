package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class b
  implements Parcelable.Creator<FieldOnlyFilter>
{
  static void a(FieldOnlyFilter paramFieldOnlyFilter, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.H(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramFieldOnlyFilter.CK);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 1, paramFieldOnlyFilter.Si, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.H(paramParcel, i);
  }
  
  public FieldOnlyFilter aT(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    MetadataBundle localMetadataBundle = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 1: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new FieldOnlyFilter(j, localMetadataBundle);
  }
  
  public FieldOnlyFilter[] ci(int paramInt)
  {
    return new FieldOnlyFilter[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.b
 * JD-Core Version:    0.7.0.1
 */