package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class PlayerLevelInfo
  implements SafeParcelable
{
  public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
  private final int CK;
  private final long Xr;
  private final long Xs;
  private final PlayerLevel Xt;
  private final PlayerLevel Xu;
  
  PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    if (paramLong1 != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      jx.K(bool);
      jx.i(paramPlayerLevel1);
      jx.i(paramPlayerLevel2);
      this.CK = paramInt;
      this.Xr = paramLong1;
      this.Xs = paramLong2;
      this.Xt = paramPlayerLevel1;
      this.Xu = paramPlayerLevel2;
      return;
    }
  }
  
  public PlayerLevelInfo(long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    this(1, paramLong1, paramLong2, paramPlayerLevel1, paramPlayerLevel2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof PlayerLevelInfo)) {
      bool = false;
    }
    PlayerLevelInfo localPlayerLevelInfo;
    do
    {
      do
      {
        return bool;
      } while (paramObject == this);
      localPlayerLevelInfo = (PlayerLevelInfo)paramObject;
    } while ((jv.equal(Long.valueOf(this.Xr), Long.valueOf(localPlayerLevelInfo.Xr))) && (jv.equal(Long.valueOf(this.Xs), Long.valueOf(localPlayerLevelInfo.Xs))) && (jv.equal(this.Xt, localPlayerLevelInfo.Xt)) && (jv.equal(this.Xu, localPlayerLevelInfo.Xu)));
    return false;
  }
  
  public PlayerLevel getCurrentLevel()
  {
    return this.Xt;
  }
  
  public long getCurrentXpTotal()
  {
    return this.Xr;
  }
  
  public long getLastLevelUpTimestamp()
  {
    return this.Xs;
  }
  
  public PlayerLevel getNextLevel()
  {
    return this.Xu;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(this.Xr);
    arrayOfObject[1] = Long.valueOf(this.Xs);
    arrayOfObject[2] = this.Xt;
    arrayOfObject[3] = this.Xu;
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean isMaxLevel()
  {
    return this.Xt.equals(this.Xu);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelInfoCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevelInfo
 * JD-Core Version:    0.7.0.1
 */