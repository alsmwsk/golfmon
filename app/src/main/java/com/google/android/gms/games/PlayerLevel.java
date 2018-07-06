package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;

public final class PlayerLevel
  implements SafeParcelable
{
  public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();
  private final int CK;
  private final int Xo;
  private final long Xp;
  private final long Xq;
  
  PlayerLevel(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    boolean bool2;
    if (paramLong1 >= 0L)
    {
      bool2 = bool1;
      jx.a(bool2, "Min XP must be positive!");
      if (paramLong2 <= paramLong1) {
        break label66;
      }
    }
    for (;;)
    {
      jx.a(bool1, "Max XP must be more than min XP!");
      this.CK = paramInt1;
      this.Xo = paramInt2;
      this.Xp = paramLong1;
      this.Xq = paramLong2;
      return;
      bool2 = false;
      break;
      label66:
      bool1 = false;
    }
  }
  
  public PlayerLevel(int paramInt, long paramLong1, long paramLong2)
  {
    this(1, paramInt, paramLong1, paramLong2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof PlayerLevel)) {
      bool = false;
    }
    PlayerLevel localPlayerLevel;
    do
    {
      do
      {
        return bool;
      } while (this == paramObject);
      localPlayerLevel = (PlayerLevel)paramObject;
    } while ((jv.equal(Integer.valueOf(localPlayerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber()))) && (jv.equal(Long.valueOf(localPlayerLevel.getMinXp()), Long.valueOf(getMinXp()))) && (jv.equal(Long.valueOf(localPlayerLevel.getMaxXp()), Long.valueOf(getMaxXp()))));
    return false;
  }
  
  public int getLevelNumber()
  {
    return this.Xo;
  }
  
  public long getMaxXp()
  {
    return this.Xq;
  }
  
  public long getMinXp()
  {
    return this.Xp;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.Xo);
    arrayOfObject[1] = Long.valueOf(this.Xp);
    arrayOfObject[2] = Long.valueOf(this.Xq);
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("LevelNumber", Integer.valueOf(getLevelNumber())).a("MinXp", Long.valueOf(getMinXp())).a("MaxXp", Long.valueOf(getMaxXp())).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevel
 * JD-Core Version:    0.7.0.1
 */