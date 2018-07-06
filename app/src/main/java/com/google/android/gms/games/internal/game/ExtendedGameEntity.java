package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;

public final class ExtendedGameEntity
  extends GamesDowngradeableSafeParcel
  implements ExtendedGame
{
  public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();
  private final int CK;
  private final String acA;
  private final ArrayList<GameBadgeEntity> acB;
  private final SnapshotMetadataEntity acC;
  private final GameEntity acs;
  private final int act;
  private final boolean acu;
  private final int acv;
  private final long acw;
  private final long acx;
  private final String acy;
  private final long acz;
  
  ExtendedGameEntity(int paramInt1, GameEntity paramGameEntity, int paramInt2, boolean paramBoolean, int paramInt3, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, ArrayList<GameBadgeEntity> paramArrayList, SnapshotMetadataEntity paramSnapshotMetadataEntity)
  {
    this.CK = paramInt1;
    this.acs = paramGameEntity;
    this.act = paramInt2;
    this.acu = paramBoolean;
    this.acv = paramInt3;
    this.acw = paramLong1;
    this.acx = paramLong2;
    this.acy = paramString1;
    this.acz = paramLong3;
    this.acA = paramString2;
    this.acB = paramArrayList;
    this.acC = paramSnapshotMetadataEntity;
  }
  
  public ExtendedGameEntity(ExtendedGame paramExtendedGame)
  {
    this.CK = 2;
    Game localGame = paramExtendedGame.getGame();
    GameEntity localGameEntity;
    SnapshotMetadata localSnapshotMetadata;
    SnapshotMetadataEntity localSnapshotMetadataEntity;
    if (localGame == null)
    {
      localGameEntity = null;
      this.acs = localGameEntity;
      this.act = paramExtendedGame.lZ();
      this.acu = paramExtendedGame.ma();
      this.acv = paramExtendedGame.mb();
      this.acw = paramExtendedGame.mc();
      this.acx = paramExtendedGame.md();
      this.acy = paramExtendedGame.me();
      this.acz = paramExtendedGame.mf();
      this.acA = paramExtendedGame.mg();
      localSnapshotMetadata = paramExtendedGame.mh();
      localSnapshotMetadataEntity = null;
      if (localSnapshotMetadata != null) {
        break label211;
      }
    }
    for (;;)
    {
      this.acC = localSnapshotMetadataEntity;
      ArrayList localArrayList = paramExtendedGame.lY();
      int i = localArrayList.size();
      this.acB = new ArrayList(i);
      for (int j = 0; j < i; j++) {
        this.acB.add((GameBadgeEntity)((GameBadge)localArrayList.get(j)).freeze());
      }
      localGameEntity = new GameEntity(localGame);
      break;
      label211:
      localSnapshotMetadataEntity = new SnapshotMetadataEntity(localSnapshotMetadata);
    }
  }
  
  static int a(ExtendedGame paramExtendedGame)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = paramExtendedGame.getGame();
    arrayOfObject[1] = Integer.valueOf(paramExtendedGame.lZ());
    arrayOfObject[2] = Boolean.valueOf(paramExtendedGame.ma());
    arrayOfObject[3] = Integer.valueOf(paramExtendedGame.mb());
    arrayOfObject[4] = Long.valueOf(paramExtendedGame.mc());
    arrayOfObject[5] = Long.valueOf(paramExtendedGame.md());
    arrayOfObject[6] = paramExtendedGame.me();
    arrayOfObject[7] = Long.valueOf(paramExtendedGame.mf());
    arrayOfObject[8] = paramExtendedGame.mg();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(ExtendedGame paramExtendedGame, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof ExtendedGame)) {
      bool = false;
    }
    ExtendedGame localExtendedGame;
    do
    {
      do
      {
        return bool;
      } while (paramExtendedGame == paramObject);
      localExtendedGame = (ExtendedGame)paramObject;
    } while ((jv.equal(localExtendedGame.getGame(), paramExtendedGame.getGame())) && (jv.equal(Integer.valueOf(localExtendedGame.lZ()), Integer.valueOf(paramExtendedGame.lZ()))) && (jv.equal(Boolean.valueOf(localExtendedGame.ma()), Boolean.valueOf(paramExtendedGame.ma()))) && (jv.equal(Integer.valueOf(localExtendedGame.mb()), Integer.valueOf(paramExtendedGame.mb()))) && (jv.equal(Long.valueOf(localExtendedGame.mc()), Long.valueOf(paramExtendedGame.mc()))) && (jv.equal(Long.valueOf(localExtendedGame.md()), Long.valueOf(paramExtendedGame.md()))) && (jv.equal(localExtendedGame.me(), paramExtendedGame.me())) && (jv.equal(Long.valueOf(localExtendedGame.mf()), Long.valueOf(paramExtendedGame.mf()))) && (jv.equal(localExtendedGame.mg(), paramExtendedGame.mg())));
    return false;
  }
  
  static String b(ExtendedGame paramExtendedGame)
  {
    return jv.h(paramExtendedGame).a("Game", paramExtendedGame.getGame()).a("Availability", Integer.valueOf(paramExtendedGame.lZ())).a("Owned", Boolean.valueOf(paramExtendedGame.ma())).a("AchievementUnlockedCount", Integer.valueOf(paramExtendedGame.mb())).a("LastPlayedServerTimestamp", Long.valueOf(paramExtendedGame.mc())).a("PriceMicros", Long.valueOf(paramExtendedGame.md())).a("FormattedPrice", paramExtendedGame.me()).a("FullPriceMicros", Long.valueOf(paramExtendedGame.mf())).a("FormattedFullPrice", paramExtendedGame.mg()).a("Snapshot", paramExtendedGame.mh()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public ArrayList<GameBadge> lY()
  {
    return new ArrayList(this.acB);
  }
  
  public int lZ()
  {
    return this.act;
  }
  
  public boolean ma()
  {
    return this.acu;
  }
  
  public int mb()
  {
    return this.acv;
  }
  
  public long mc()
  {
    return this.acw;
  }
  
  public long md()
  {
    return this.acx;
  }
  
  public String me()
  {
    return this.acy;
  }
  
  public long mf()
  {
    return this.acz;
  }
  
  public String mg()
  {
    return this.acA;
  }
  
  public SnapshotMetadata mh()
  {
    return this.acC;
  }
  
  public GameEntity mi()
  {
    return this.acs;
  }
  
  public ExtendedGame mj()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    if (!hu())
    {
      ExtendedGameEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    this.acs.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.act);
    if (this.acu) {}
    for (int j = 1;; j = 0)
    {
      paramParcel.writeInt(j);
      paramParcel.writeInt(this.acv);
      paramParcel.writeLong(this.acw);
      paramParcel.writeLong(this.acx);
      paramParcel.writeString(this.acy);
      paramParcel.writeLong(this.acz);
      paramParcel.writeString(this.acA);
      int k = this.acB.size();
      paramParcel.writeInt(k);
      while (i < k)
      {
        ((GameBadgeEntity)this.acB.get(i)).writeToParcel(paramParcel, paramInt);
        i++;
      }
      break;
    }
  }
  
  static final class ExtendedGameEntityCreatorCompat
    extends ExtendedGameEntityCreator
  {
    public ExtendedGameEntity cu(Parcel paramParcel)
    {
      if ((ExtendedGameEntity.b(ExtendedGameEntity.kD())) || (ExtendedGameEntity.bz(ExtendedGameEntity.class.getCanonicalName()))) {
        return super.cu(paramParcel);
      }
      GameEntity localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
      int i = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      int j;
      long l1;
      long l2;
      String str1;
      long l3;
      String str2;
      ArrayList localArrayList;
      for (boolean bool = true;; bool = false)
      {
        j = paramParcel.readInt();
        l1 = paramParcel.readLong();
        l2 = paramParcel.readLong();
        str1 = paramParcel.readString();
        l3 = paramParcel.readLong();
        str2 = paramParcel.readString();
        int k = paramParcel.readInt();
        localArrayList = new ArrayList(k);
        for (int m = 0; m < k; m++) {
          localArrayList.add(GameBadgeEntity.CREATOR.cv(paramParcel));
        }
      }
      return new ExtendedGameEntity(2, localGameEntity, i, bool, j, l1, l2, str1, l3, str2, localArrayList, null);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.ExtendedGameEntity
 * JD-Core Version:    0.7.0.1
 */