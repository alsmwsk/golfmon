package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class AppContentSectionEntityCreator
  implements Parcelable.Creator<AppContentSectionEntity>
{
  static void a(AppContentSectionEntity paramAppContentSectionEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramAppContentSectionEntity.getActions(), false);
    b.c(paramParcel, 1000, paramAppContentSectionEntity.getVersionCode());
    b.a(paramParcel, 2, paramAppContentSectionEntity.kY(), paramInt, false);
    b.c(paramParcel, 3, paramAppContentSectionEntity.kZ(), false);
    b.a(paramParcel, 4, paramAppContentSectionEntity.kI(), false);
    b.a(paramParcel, 5, paramAppContentSectionEntity.kP(), false);
    b.a(paramParcel, 6, paramAppContentSectionEntity.kQ(), false);
    b.a(paramParcel, 7, paramAppContentSectionEntity.getTitle(), false);
    b.a(paramParcel, 8, paramAppContentSectionEntity.getType(), false);
    b.H(paramParcel, i);
  }
  
  public AppContentSectionEntity cr(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    String str2 = null;
    String str3 = null;
    Bundle localBundle = null;
    String str4 = null;
    ArrayList localArrayList1 = null;
    Uri localUri = null;
    ArrayList localArrayList2 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList2 = a.c(paramParcel, k, AppContentActionEntity.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localUri = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 3: 
        localArrayList1 = a.c(paramParcel, k, AppContentCardEntity.CREATOR);
        break;
      case 4: 
        str4 = a.o(paramParcel, k);
        break;
      case 5: 
        localBundle = a.q(paramParcel, k);
        break;
      case 6: 
        str3 = a.o(paramParcel, k);
        break;
      case 7: 
        str2 = a.o(paramParcel, k);
        break;
      case 8: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new AppContentSectionEntity(j, localArrayList2, localUri, localArrayList1, str4, localBundle, str3, str2, str1);
  }
  
  public AppContentSectionEntity[] dM(int paramInt)
  {
    return new AppContentSectionEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentSectionEntityCreator
 * JD-Core Version:    0.7.0.1
 */