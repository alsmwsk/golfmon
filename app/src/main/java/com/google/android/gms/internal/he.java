package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class he
  implements Parcelable.Creator<hd>
{
  static void a(hd paramhd, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramhd.CL, paramInt, false);
    b.c(paramParcel, 1000, paramhd.CK);
    b.a(paramParcel, 2, paramhd.CM, false);
    b.a(paramParcel, 3, paramhd.CN);
    b.a(paramParcel, 4, paramhd.account, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public hd[] J(int paramInt)
  {
    return new hd[paramInt];
  }
  
  public hd l(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int i = a.G(paramParcel);
    String str = null;
    hh[] arrayOfhh = null;
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
        arrayOfhh = (hh[])a.b(paramParcel, k, hh.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.o(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
        break;
      case 4: 
        localAccount = (Account)a.a(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new hd(j, arrayOfhh, str, bool, localAccount);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.he
 * JD-Core Version:    0.7.0.1
 */