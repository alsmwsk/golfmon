package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class PlayerLevelInfoCreator
  implements Parcelable.Creator<PlayerLevelInfo>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(PlayerLevelInfo paramPlayerLevelInfo, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramPlayerLevelInfo.getCurrentXpTotal());
    b.c(paramParcel, 1000, paramPlayerLevelInfo.getVersionCode());
    b.a(paramParcel, 2, paramPlayerLevelInfo.getLastLevelUpTimestamp());
    b.a(paramParcel, 3, paramPlayerLevelInfo.getCurrentLevel(), paramInt, false);
    b.a(paramParcel, 4, paramPlayerLevelInfo.getNextLevel(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public PlayerLevelInfo createFromParcel(Parcel paramParcel)
  {
    long l1 = 0L;
    PlayerLevel localPlayerLevel1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    PlayerLevel localPlayerLevel2 = null;
    long l2 = l1;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        l2 = a.i(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        l1 = a.i(paramParcel, k);
        break;
      case 3: 
        localPlayerLevel2 = (PlayerLevel)a.a(paramParcel, k, PlayerLevel.CREATOR);
        break;
      case 4: 
        localPlayerLevel1 = (PlayerLevel)a.a(paramParcel, k, PlayerLevel.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new PlayerLevelInfo(j, l2, l1, localPlayerLevel2, localPlayerLevel1);
  }
  
  public PlayerLevelInfo[] newArray(int paramInt)
  {
    return new PlayerLevelInfo[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevelInfoCreator
 * JD-Core Version:    0.7.0.1
 */