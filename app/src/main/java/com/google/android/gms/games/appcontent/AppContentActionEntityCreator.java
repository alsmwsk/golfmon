package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class AppContentActionEntityCreator
  implements Parcelable.Creator<AppContentActionEntity>
{
  static void a(AppContentActionEntity paramAppContentActionEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramAppContentActionEntity.kH(), false);
    b.c(paramParcel, 1000, paramAppContentActionEntity.getVersionCode());
    b.a(paramParcel, 2, paramAppContentActionEntity.kI(), false);
    b.a(paramParcel, 3, paramAppContentActionEntity.getExtras(), false);
    b.a(paramParcel, 4, paramAppContentActionEntity.getLabel(), false);
    b.a(paramParcel, 5, paramAppContentActionEntity.kJ(), false);
    b.a(paramParcel, 6, paramAppContentActionEntity.getType(), false);
    b.H(paramParcel, i);
  }
  
  public AppContentActionEntity cn(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    String str2 = null;
    String str3 = null;
    Bundle localBundle = null;
    String str4 = null;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, k, AppContentConditionEntity.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str4 = a.o(paramParcel, k);
        break;
      case 3: 
        localBundle = a.q(paramParcel, k);
        break;
      case 4: 
        str3 = a.o(paramParcel, k);
        break;
      case 5: 
        str2 = a.o(paramParcel, k);
        break;
      case 6: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new AppContentActionEntity(j, localArrayList, str4, localBundle, str3, str2, str1);
  }
  
  public AppContentActionEntity[] dI(int paramInt)
  {
    return new AppContentActionEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentActionEntityCreator
 * JD-Core Version:    0.7.0.1
 */