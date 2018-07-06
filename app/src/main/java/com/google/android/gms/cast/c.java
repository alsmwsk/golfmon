package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<LaunchOptions>
{
  static void a(LaunchOptions paramLaunchOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramLaunchOptions.getVersionCode());
    b.a(paramParcel, 2, paramLaunchOptions.getRelaunchIfRunning());
    b.a(paramParcel, 3, paramLaunchOptions.getLanguage(), false);
    b.H(paramParcel, i);
  }
  
  public LaunchOptions[] aa(int paramInt)
  {
    return new LaunchOptions[paramInt];
  }
  
  public LaunchOptions w(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    String str = null;
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
        bool = a.c(paramParcel, k);
        break;
      case 3: 
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new LaunchOptions(j, bool, str);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.c
 * JD-Core Version:    0.7.0.1
 */