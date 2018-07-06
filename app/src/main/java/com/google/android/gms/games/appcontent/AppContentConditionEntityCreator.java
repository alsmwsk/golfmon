package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AppContentConditionEntityCreator
  implements Parcelable.Creator<AppContentConditionEntity>
{
  static void a(AppContentConditionEntity paramAppContentConditionEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramAppContentConditionEntity.kT(), false);
    b.c(paramParcel, 1000, paramAppContentConditionEntity.getVersionCode());
    b.a(paramParcel, 2, paramAppContentConditionEntity.kU(), false);
    b.a(paramParcel, 3, paramAppContentConditionEntity.kV(), false);
    b.a(paramParcel, 4, paramAppContentConditionEntity.kW(), false);
    b.H(paramParcel, i);
  }
  
  public AppContentConditionEntity cq(Parcel paramParcel)
  {
    Bundle localBundle = null;
    int i = a.G(paramParcel);
    int j = 0;
    String str1 = null;
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
        str3 = a.o(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        str1 = a.o(paramParcel, k);
        break;
      case 4: 
        localBundle = a.q(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new AppContentConditionEntity(j, str3, str2, str1, localBundle);
  }
  
  public AppContentConditionEntity[] dL(int paramInt)
  {
    return new AppContentConditionEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentConditionEntityCreator
 * JD-Core Version:    0.7.0.1
 */