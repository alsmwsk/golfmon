package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator
  implements Parcelable.Creator<PlayerEntity>
{
  static void a(PlayerEntity paramPlayerEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramPlayerEntity.getPlayerId(), false);
    b.a(paramParcel, 2, paramPlayerEntity.getDisplayName(), false);
    b.a(paramParcel, 3, paramPlayerEntity.getIconImageUri(), paramInt, false);
    b.a(paramParcel, 4, paramPlayerEntity.getHiResImageUri(), paramInt, false);
    b.a(paramParcel, 5, paramPlayerEntity.getRetrievedTimestamp());
    b.c(paramParcel, 6, paramPlayerEntity.kE());
    b.a(paramParcel, 7, paramPlayerEntity.getLastPlayedWithTimestamp());
    b.a(paramParcel, 8, paramPlayerEntity.getIconImageUrl(), false);
    b.a(paramParcel, 9, paramPlayerEntity.getHiResImageUrl(), false);
    b.a(paramParcel, 14, paramPlayerEntity.getTitle(), false);
    b.a(paramParcel, 15, paramPlayerEntity.kF(), paramInt, false);
    b.a(paramParcel, 16, paramPlayerEntity.getLevelInfo(), paramInt, false);
    b.c(paramParcel, 1000, paramPlayerEntity.getVersionCode());
    b.a(paramParcel, 18, paramPlayerEntity.isProfileVisible());
    b.H(paramParcel, i);
  }
  
  public PlayerEntity cm(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    Uri localUri1 = null;
    Uri localUri2 = null;
    long l1 = 0L;
    int k = 0;
    long l2 = 0L;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    MostRecentGameInfoEntity localMostRecentGameInfoEntity = null;
    PlayerLevelInfo localPlayerLevelInfo = null;
    boolean bool = false;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str1 = a.o(paramParcel, m);
        break;
      case 2: 
        str2 = a.o(paramParcel, m);
        break;
      case 3: 
        localUri1 = (Uri)a.a(paramParcel, m, Uri.CREATOR);
        break;
      case 4: 
        localUri2 = (Uri)a.a(paramParcel, m, Uri.CREATOR);
        break;
      case 5: 
        l1 = a.i(paramParcel, m);
        break;
      case 6: 
        k = a.g(paramParcel, m);
        break;
      case 7: 
        l2 = a.i(paramParcel, m);
        break;
      case 8: 
        str3 = a.o(paramParcel, m);
        break;
      case 9: 
        str4 = a.o(paramParcel, m);
        break;
      case 14: 
        str5 = a.o(paramParcel, m);
        break;
      case 15: 
        localMostRecentGameInfoEntity = (MostRecentGameInfoEntity)a.a(paramParcel, m, MostRecentGameInfoEntity.CREATOR);
        break;
      case 16: 
        localPlayerLevelInfo = (PlayerLevelInfo)a.a(paramParcel, m, PlayerLevelInfo.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 18: 
        bool = a.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new PlayerEntity(j, str1, str2, localUri1, localUri2, l1, k, l2, str3, str4, str5, localMostRecentGameInfoEntity, localPlayerLevelInfo, bool);
  }
  
  public PlayerEntity[] dH(int paramInt)
  {
    return new PlayerEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerEntityCreator
 * JD-Core Version:    0.7.0.1
 */