package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class ax
  implements Parcelable.Creator<aw>
{
  static void a(aw paramaw, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramaw.versionCode);
    b.c(paramParcel, 2, paramaw.statusCode);
    b.a(paramParcel, 3, paramaw.ayc);
    b.c(paramParcel, 4, paramaw.aye, false);
    b.H(paramParcel, i);
  }
  
  public aw eE(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    long l = 0L;
    ArrayList localArrayList = null;
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
        l = a.i(paramParcel, m);
        break;
      case 4: 
        localArrayList = a.c(paramParcel, m, an.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new aw(k, i, l, localArrayList);
  }
  
  public aw[] gO(int paramInt)
  {
    return new aw[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ax
 * JD-Core Version:    0.7.0.1
 */