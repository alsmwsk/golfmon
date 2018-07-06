package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<AppVisibleCustomProperties>
{
  static void a(AppVisibleCustomProperties paramAppVisibleCustomProperties, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramAppVisibleCustomProperties.CK);
    b.c(paramParcel, 2, paramAppVisibleCustomProperties.Re, false);
    b.H(paramParcel, i);
  }
  
  public AppVisibleCustomProperties aN(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, CustomProperty.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new AppVisibleCustomProperties(j, localArrayList);
  }
  
  public AppVisibleCustomProperties[] cc(int paramInt)
  {
    return new AppVisibleCustomProperties[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.a
 * JD-Core Version:    0.7.0.1
 */