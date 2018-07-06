package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class f
  implements Parcelable.Creator<FullWallet>
{
  static void a(FullWallet paramFullWallet, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramFullWallet.getVersionCode());
    b.a(paramParcel, 2, paramFullWallet.auL, false);
    b.a(paramParcel, 3, paramFullWallet.auM, false);
    b.a(paramParcel, 4, paramFullWallet.auN, paramInt, false);
    b.a(paramParcel, 5, paramFullWallet.auO, false);
    b.a(paramParcel, 6, paramFullWallet.auP, paramInt, false);
    b.a(paramParcel, 7, paramFullWallet.auQ, paramInt, false);
    b.a(paramParcel, 8, paramFullWallet.auR, false);
    b.a(paramParcel, 9, paramFullWallet.auS, paramInt, false);
    b.a(paramParcel, 10, paramFullWallet.auT, paramInt, false);
    b.a(paramParcel, 11, paramFullWallet.auU, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public FullWallet dN(Parcel paramParcel)
  {
    InstrumentInfo[] arrayOfInstrumentInfo = null;
    int i = a.G(paramParcel);
    int j = 0;
    UserAddress localUserAddress1 = null;
    UserAddress localUserAddress2 = null;
    String[] arrayOfString = null;
    Address localAddress1 = null;
    Address localAddress2 = null;
    String str1 = null;
    ProxyCard localProxyCard = null;
    String str2 = null;
    String str3 = null;
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
        str3 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        localProxyCard = (ProxyCard)a.a(paramParcel, k, ProxyCard.CREATOR);
        break;
      case 5: 
        str1 = a.o(paramParcel, k);
        break;
      case 6: 
        localAddress2 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 7: 
        localAddress1 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 8: 
        arrayOfString = a.A(paramParcel, k);
        break;
      case 9: 
        localUserAddress2 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 10: 
        localUserAddress1 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 11: 
        arrayOfInstrumentInfo = (InstrumentInfo[])a.b(paramParcel, k, InstrumentInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new FullWallet(j, str3, str2, localProxyCard, str1, localAddress2, localAddress1, arrayOfString, localUserAddress2, localUserAddress1, arrayOfInstrumentInfo);
  }
  
  public FullWallet[] fU(int paramInt)
  {
    return new FullWallet[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.f
 * JD-Core Version:    0.7.0.1
 */