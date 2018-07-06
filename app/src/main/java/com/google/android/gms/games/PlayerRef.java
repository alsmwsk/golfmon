package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef
  extends d
  implements Player
{
  private final PlayerLevelInfo Xm;
  private final PlayerColumnNames Xv;
  private final MostRecentGameInfoRef Xw;
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.Xv = new PlayerColumnNames(paramString);
    this.Xw = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.Xv);
    int j;
    PlayerLevel localPlayerLevel1;
    if (kG())
    {
      int i = getInteger(this.Xv.acV);
      j = getInteger(this.Xv.acY);
      localPlayerLevel1 = new PlayerLevel(i, getLong(this.Xv.acW), getLong(this.Xv.acX));
      if (i == j) {
        break label185;
      }
    }
    label185:
    for (PlayerLevel localPlayerLevel2 = new PlayerLevel(j, getLong(this.Xv.acX), getLong(this.Xv.acZ));; localPlayerLevel2 = localPlayerLevel1)
    {
      this.Xm = new PlayerLevelInfo(getLong(this.Xv.acU), getLong(this.Xv.ada), localPlayerLevel1, localPlayerLevel2);
      return;
      this.Xm = null;
      return;
    }
  }
  
  private boolean kG()
  {
    if (aS(this.Xv.acU)) {}
    while (getLong(this.Xv.acU) == -1L) {
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerEntity.a(this, paramObject);
  }
  
  public Player freeze()
  {
    return new PlayerEntity(this);
  }
  
  public String getDisplayName()
  {
    return getString(this.Xv.acM);
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.Xv.acM, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return aR(this.Xv.acP);
  }
  
  public String getHiResImageUrl()
  {
    return getString(this.Xv.acQ);
  }
  
  public Uri getIconImageUri()
  {
    return aR(this.Xv.acN);
  }
  
  public String getIconImageUrl()
  {
    return getString(this.Xv.acO);
  }
  
  public long getLastPlayedWithTimestamp()
  {
    if ((!aQ(this.Xv.acT)) || (aS(this.Xv.acT))) {
      return -1L;
    }
    return getLong(this.Xv.acT);
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.Xm;
  }
  
  public String getPlayerId()
  {
    return getString(this.Xv.acL);
  }
  
  public long getRetrievedTimestamp()
  {
    return getLong(this.Xv.acR);
  }
  
  public String getTitle()
  {
    return getString(this.Xv.adb);
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.Xv.adb, paramCharArrayBuffer);
  }
  
  public boolean hasHiResImage()
  {
    return getHiResImageUri() != null;
  }
  
  public boolean hasIconImage()
  {
    return getIconImageUri() != null;
  }
  
  public int hashCode()
  {
    return PlayerEntity.b(this);
  }
  
  public boolean isProfileVisible()
  {
    return getBoolean(this.Xv.add);
  }
  
  public int kE()
  {
    return getInteger(this.Xv.acS);
  }
  
  public MostRecentGameInfo kF()
  {
    if (aS(this.Xv.ade)) {
      return null;
    }
    return this.Xw;
  }
  
  public String toString()
  {
    return PlayerEntity.c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerRef
 * JD-Core Version:    0.7.0.1
 */