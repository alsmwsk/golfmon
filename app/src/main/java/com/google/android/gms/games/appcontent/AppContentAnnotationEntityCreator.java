package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AppContentAnnotationEntityCreator
  implements Parcelable.Creator<AppContentAnnotationEntity>
{
  static void a(AppContentAnnotationEntity paramAppContentAnnotationEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramAppContentAnnotationEntity.getDescription(), false);
    b.c(paramParcel, 1000, paramAppContentAnnotationEntity.getVersionCode());
    b.a(paramParcel, 2, paramAppContentAnnotationEntity.kL(), paramInt, false);
    b.a(paramParcel, 3, paramAppContentAnnotationEntity.getTitle(), false);
    b.a(paramParcel, 4, paramAppContentAnnotationEntity.getType(), false);
    b.H(paramParcel, i);
  }
  
  public AppContentAnnotationEntity co(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    String str2 = null;
    Uri localUri = null;
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
        localUri = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new AppContentAnnotationEntity(j, str3, localUri, str2, str1);
  }
  
  public AppContentAnnotationEntity[] dJ(int paramInt)
  {
    return new AppContentAnnotationEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentAnnotationEntityCreator
 * JD-Core Version:    0.7.0.1
 */