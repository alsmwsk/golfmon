package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<WalletFragmentOptions>
{
  static void a(WalletFragmentOptions paramWalletFragmentOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.H(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramWalletFragmentOptions.CK);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 2, paramWalletFragmentOptions.getEnvironment());
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 3, paramWalletFragmentOptions.getTheme());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramWalletFragmentOptions.getFragmentStyle(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 5, paramWalletFragmentOptions.getMode());
    com.google.android.gms.common.internal.safeparcel.b.H(paramParcel, i);
  }
  
  public WalletFragmentOptions ea(Parcel paramParcel)
  {
    int i = 1;
    int j = 0;
    int k = a.G(paramParcel);
    WalletFragmentStyle localWalletFragmentStyle = null;
    int m = i;
    int n = 0;
    while (paramParcel.dataPosition() < k)
    {
      int i1 = a.F(paramParcel);
      switch (a.aH(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        n = a.g(paramParcel, i1);
        break;
      case 2: 
        m = a.g(paramParcel, i1);
        break;
      case 3: 
        j = a.g(paramParcel, i1);
        break;
      case 4: 
        localWalletFragmentStyle = (WalletFragmentStyle)a.a(paramParcel, i1, WalletFragmentStyle.CREATOR);
        break;
      case 5: 
        i = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new WalletFragmentOptions(n, m, j, localWalletFragmentStyle, i);
  }
  
  public WalletFragmentOptions[] gi(int paramInt)
  {
    return new WalletFragmentOptions[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.b
 * JD-Core Version:    0.7.0.1
 */