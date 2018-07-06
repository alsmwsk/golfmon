package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class GameBadgeEntityCreator
  implements Parcelable.Creator<GameBadgeEntity>
{
  static void a(GameBadgeEntity paramGameBadgeEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramGameBadgeEntity.getType());
    b.c(paramParcel, 1000, paramGameBadgeEntity.getVersionCode());
    b.a(paramParcel, 2, paramGameBadgeEntity.getTitle(), false);
    b.a(paramParcel, 3, paramGameBadgeEntity.getDescription(), false);
    b.a(paramParcel, 4, paramGameBadgeEntity.getIconImageUri(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public GameBadgeEntity cv(Parcel paramParcel)
  {
    int i = 0;
    Uri localUri = null;
    int j = a.G(paramParcel);
    String str1 = null;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i = a.g(paramParcel, m);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        str2 = a.o(paramParcel, m);
        break;
      case 3: 
        str1 = a.o(paramParcel, m);
        break;
      case 4: 
        localUri = (Uri)a.a(paramParcel, m, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new GameBadgeEntity(k, i, str2, str1, localUri);
  }
  
  public GameBadgeEntity[] ed(int paramInt)
  {
    return new GameBadgeEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameBadgeEntityCreator
 * JD-Core Version:    0.7.0.1
 */