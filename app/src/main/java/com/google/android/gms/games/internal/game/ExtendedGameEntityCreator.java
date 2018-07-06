package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator
  implements Parcelable.Creator<ExtendedGameEntity>
{
  static void a(ExtendedGameEntity paramExtendedGameEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramExtendedGameEntity.mi(), paramInt, false);
    b.c(paramParcel, 1000, paramExtendedGameEntity.getVersionCode());
    b.c(paramParcel, 2, paramExtendedGameEntity.lZ());
    b.a(paramParcel, 3, paramExtendedGameEntity.ma());
    b.c(paramParcel, 4, paramExtendedGameEntity.mb());
    b.a(paramParcel, 5, paramExtendedGameEntity.mc());
    b.a(paramParcel, 6, paramExtendedGameEntity.md());
    b.a(paramParcel, 7, paramExtendedGameEntity.me(), false);
    b.a(paramParcel, 8, paramExtendedGameEntity.mf());
    b.a(paramParcel, 9, paramExtendedGameEntity.mg(), false);
    b.c(paramParcel, 10, paramExtendedGameEntity.lY(), false);
    b.a(paramParcel, 11, paramExtendedGameEntity.mh(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public ExtendedGameEntity cu(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    GameEntity localGameEntity = null;
    int k = 0;
    boolean bool = false;
    int m = 0;
    long l1 = 0L;
    long l2 = 0L;
    String str1 = null;
    long l3 = 0L;
    String str2 = null;
    ArrayList localArrayList = null;
    SnapshotMetadataEntity localSnapshotMetadataEntity = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        localGameEntity = (GameEntity)a.a(paramParcel, n, GameEntity.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, n);
        break;
      case 2: 
        k = a.g(paramParcel, n);
        break;
      case 3: 
        bool = a.c(paramParcel, n);
        break;
      case 4: 
        m = a.g(paramParcel, n);
        break;
      case 5: 
        l1 = a.i(paramParcel, n);
        break;
      case 6: 
        l2 = a.i(paramParcel, n);
        break;
      case 7: 
        str1 = a.o(paramParcel, n);
        break;
      case 8: 
        l3 = a.i(paramParcel, n);
        break;
      case 9: 
        str2 = a.o(paramParcel, n);
        break;
      case 10: 
        localArrayList = a.c(paramParcel, n, GameBadgeEntity.CREATOR);
        break;
      case 11: 
        localSnapshotMetadataEntity = (SnapshotMetadataEntity)a.a(paramParcel, n, SnapshotMetadataEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new ExtendedGameEntity(j, localGameEntity, k, bool, m, l1, l2, str1, l3, str2, localArrayList, localSnapshotMetadataEntity);
  }
  
  public ExtendedGameEntity[] eb(int paramInt)
  {
    return new ExtendedGameEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.ExtendedGameEntityCreator
 * JD-Core Version:    0.7.0.1
 */