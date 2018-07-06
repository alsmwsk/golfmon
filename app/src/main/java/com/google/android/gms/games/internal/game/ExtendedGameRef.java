package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef
  extends d
  implements ExtendedGame
{
  private final int Ya;
  private final SnapshotMetadataRef acD;
  private final GameRef acr;
  
  ExtendedGameRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.acr = new GameRef(paramDataHolder, paramInt1);
    this.Ya = paramInt2;
    if ((aQ("external_snapshot_id")) && (!aS("external_snapshot_id")))
    {
      this.acD = new SnapshotMetadataRef(paramDataHolder, paramInt1);
      return;
    }
    this.acD = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ExtendedGameEntity.a(this, paramObject);
  }
  
  public Game getGame()
  {
    return this.acr;
  }
  
  public int hashCode()
  {
    return ExtendedGameEntity.a(this);
  }
  
  public ArrayList<GameBadge> lY()
  {
    int i = 0;
    if (this.JG.c("badge_title", this.KZ, this.JG.au(this.KZ)) == null) {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(this.Ya);
    while (i < this.Ya)
    {
      localArrayList.add(new GameBadgeRef(this.JG, i + this.KZ));
      i++;
    }
    return localArrayList;
  }
  
  public int lZ()
  {
    return getInteger("availability");
  }
  
  public boolean ma()
  {
    return getBoolean("owned");
  }
  
  public int mb()
  {
    return getInteger("achievement_unlocked_count");
  }
  
  public long mc()
  {
    return getLong("last_played_server_time");
  }
  
  public long md()
  {
    return getLong("price_micros");
  }
  
  public String me()
  {
    return getString("formatted_price");
  }
  
  public long mf()
  {
    return getLong("full_price_micros");
  }
  
  public String mg()
  {
    return getString("formatted_full_price");
  }
  
  public SnapshotMetadata mh()
  {
    return this.acD;
  }
  
  public ExtendedGame mj()
  {
    return new ExtendedGameEntity(this);
  }
  
  public String toString()
  {
    return ExtendedGameEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ExtendedGameEntity)mj()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.ExtendedGameRef
 * JD-Core Version:    0.7.0.1
 */