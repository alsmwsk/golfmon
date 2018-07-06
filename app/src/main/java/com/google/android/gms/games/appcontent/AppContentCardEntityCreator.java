package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class AppContentCardEntityCreator
  implements Parcelable.Creator<AppContentCardEntity>
{
  static void a(AppContentCardEntity paramAppContentCardEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramAppContentCardEntity.getActions(), false);
    b.c(paramParcel, 1000, paramAppContentCardEntity.getVersionCode());
    b.c(paramParcel, 2, paramAppContentCardEntity.kN(), false);
    b.c(paramParcel, 3, paramAppContentCardEntity.kH(), false);
    b.a(paramParcel, 4, paramAppContentCardEntity.kI(), false);
    b.c(paramParcel, 5, paramAppContentCardEntity.kO());
    b.a(paramParcel, 6, paramAppContentCardEntity.getDescription(), false);
    b.a(paramParcel, 7, paramAppContentCardEntity.kP(), false);
    b.a(paramParcel, 8, paramAppContentCardEntity.getIconImageUri(), paramInt, false);
    b.a(paramParcel, 9, paramAppContentCardEntity.kL(), paramInt, false);
    b.a(paramParcel, 10, paramAppContentCardEntity.kQ(), false);
    b.a(paramParcel, 11, paramAppContentCardEntity.getTitle(), false);
    b.c(paramParcel, 12, paramAppContentCardEntity.kR());
    b.a(paramParcel, 13, paramAppContentCardEntity.getType(), false);
    b.H(paramParcel, i);
  }
  
  public AppContentCardEntity cp(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList3 = null;
    String str1 = null;
    int k = 0;
    String str2 = null;
    Bundle localBundle = null;
    Uri localUri1 = null;
    Uri localUri2 = null;
    String str3 = null;
    String str4 = null;
    int m = 0;
    String str5 = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        localArrayList1 = a.c(paramParcel, n, AppContentActionEntity.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, n);
        break;
      case 2: 
        localArrayList2 = a.c(paramParcel, n, AppContentAnnotationEntity.CREATOR);
        break;
      case 3: 
        localArrayList3 = a.c(paramParcel, n, AppContentConditionEntity.CREATOR);
        break;
      case 4: 
        str1 = a.o(paramParcel, n);
        break;
      case 5: 
        k = a.g(paramParcel, n);
        break;
      case 6: 
        str2 = a.o(paramParcel, n);
        break;
      case 7: 
        localBundle = a.q(paramParcel, n);
        break;
      case 8: 
        localUri1 = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        break;
      case 9: 
        localUri2 = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        break;
      case 10: 
        str3 = a.o(paramParcel, n);
        break;
      case 11: 
        str4 = a.o(paramParcel, n);
        break;
      case 12: 
        m = a.g(paramParcel, n);
        break;
      case 13: 
        str5 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new AppContentCardEntity(j, localArrayList1, localArrayList2, localArrayList3, str1, k, str2, localBundle, localUri1, localUri2, str3, str4, m, str5);
  }
  
  public AppContentCardEntity[] dK(int paramInt)
  {
    return new AppContentCardEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentCardEntityCreator
 * JD-Core Version:    0.7.0.1
 */