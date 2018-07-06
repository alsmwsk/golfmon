package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class n
  implements Parcelable.Creator<OfferWalletObject>
{
  static void a(OfferWalletObject paramOfferWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOfferWalletObject.getVersionCode());
    b.a(paramParcel, 2, paramOfferWalletObject.fl, false);
    b.a(paramParcel, 3, paramOfferWalletObject.avN, false);
    b.a(paramParcel, 4, paramOfferWalletObject.avO, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public OfferWalletObject dV(Parcel paramParcel)
  {
    CommonWalletObject localCommonWalletObject = null;
    int i = a.G(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
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
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        str1 = a.o(paramParcel, k);
        break;
      case 4: 
        localCommonWalletObject = (CommonWalletObject)a.a(paramParcel, k, CommonWalletObject.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new OfferWalletObject(j, str2, str1, localCommonWalletObject);
  }
  
  public OfferWalletObject[] gc(int paramInt)
  {
    return new OfferWalletObject[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.n
 * JD-Core Version:    0.7.0.1
 */