package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class k
  implements Parcelable.Creator<MaskedWallet>
{
  static void a(MaskedWallet paramMaskedWallet, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramMaskedWallet.getVersionCode());
    b.a(paramParcel, 2, paramMaskedWallet.auL, false);
    b.a(paramParcel, 3, paramMaskedWallet.auM, false);
    b.a(paramParcel, 4, paramMaskedWallet.auR, false);
    b.a(paramParcel, 5, paramMaskedWallet.auO, false);
    b.a(paramParcel, 6, paramMaskedWallet.auP, paramInt, false);
    b.a(paramParcel, 7, paramMaskedWallet.auQ, paramInt, false);
    b.a(paramParcel, 8, paramMaskedWallet.avw, paramInt, false);
    b.a(paramParcel, 9, paramMaskedWallet.avx, paramInt, false);
    b.a(paramParcel, 10, paramMaskedWallet.auS, paramInt, false);
    b.a(paramParcel, 11, paramMaskedWallet.auT, paramInt, false);
    b.a(paramParcel, 12, paramMaskedWallet.auU, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public MaskedWallet dS(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    String[] arrayOfString = null;
    String str3 = null;
    Address localAddress1 = null;
    Address localAddress2 = null;
    LoyaltyWalletObject[] arrayOfLoyaltyWalletObject = null;
    OfferWalletObject[] arrayOfOfferWalletObject = null;
    UserAddress localUserAddress1 = null;
    UserAddress localUserAddress2 = null;
    InstrumentInfo[] arrayOfInstrumentInfo = null;
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
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        arrayOfString = a.A(paramParcel, k);
        break;
      case 5: 
        str3 = a.o(paramParcel, k);
        break;
      case 6: 
        localAddress1 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 7: 
        localAddress2 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 8: 
        arrayOfLoyaltyWalletObject = (LoyaltyWalletObject[])a.b(paramParcel, k, LoyaltyWalletObject.CREATOR);
        break;
      case 9: 
        arrayOfOfferWalletObject = (OfferWalletObject[])a.b(paramParcel, k, OfferWalletObject.CREATOR);
        break;
      case 10: 
        localUserAddress1 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 11: 
        localUserAddress2 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 12: 
        arrayOfInstrumentInfo = (InstrumentInfo[])a.b(paramParcel, k, InstrumentInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new MaskedWallet(j, str1, str2, arrayOfString, str3, localAddress1, localAddress2, arrayOfLoyaltyWalletObject, arrayOfOfferWalletObject, localUserAddress1, localUserAddress2, arrayOfInstrumentInfo);
  }
  
  public MaskedWallet[] fZ(int paramInt)
  {
    return new MaskedWallet[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.k
 * JD-Core Version:    0.7.0.1
 */