package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;

public final class PlayerEntity
  extends GamesDowngradeableSafeParcel
  implements Player
{
  public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
  private final int CK;
  private final String OH;
  private final String OS;
  private final Uri WD;
  private final Uri WE;
  private final String WO;
  private final String WP;
  private final String Xh;
  private final long Xi;
  private final int Xj;
  private final long Xk;
  private final MostRecentGameInfoEntity Xl;
  private final PlayerLevelInfo Xm;
  private final boolean Xn;
  
  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean)
  {
    this.CK = paramInt1;
    this.Xh = paramString1;
    this.OS = paramString2;
    this.WD = paramUri1;
    this.WO = paramString3;
    this.WE = paramUri2;
    this.WP = paramString4;
    this.Xi = paramLong1;
    this.Xj = paramInt2;
    this.Xk = paramLong2;
    this.OH = paramString5;
    this.Xn = paramBoolean;
    this.Xl = paramMostRecentGameInfoEntity;
    this.Xm = paramPlayerLevelInfo;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this.CK = 11;
    this.Xh = paramPlayer.getPlayerId();
    this.OS = paramPlayer.getDisplayName();
    this.WD = paramPlayer.getIconImageUri();
    this.WO = paramPlayer.getIconImageUrl();
    this.WE = paramPlayer.getHiResImageUri();
    this.WP = paramPlayer.getHiResImageUrl();
    this.Xi = paramPlayer.getRetrievedTimestamp();
    this.Xj = paramPlayer.kE();
    this.Xk = paramPlayer.getLastPlayedWithTimestamp();
    this.OH = paramPlayer.getTitle();
    this.Xn = paramPlayer.isProfileVisible();
    MostRecentGameInfo localMostRecentGameInfo = paramPlayer.kF();
    MostRecentGameInfoEntity localMostRecentGameInfoEntity;
    if (localMostRecentGameInfo == null)
    {
      localMostRecentGameInfoEntity = null;
      this.Xl = localMostRecentGameInfoEntity;
      this.Xm = paramPlayer.getLevelInfo();
      je.f(this.Xh);
      je.f(this.OS);
      if (this.Xi <= 0L) {
        break label192;
      }
    }
    label192:
    for (boolean bool = true;; bool = false)
    {
      je.K(bool);
      return;
      localMostRecentGameInfoEntity = new MostRecentGameInfoEntity(localMostRecentGameInfo);
      break;
    }
  }
  
  static boolean a(Player paramPlayer, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof Player)) {
      bool = false;
    }
    Player localPlayer;
    do
    {
      do
      {
        return bool;
      } while (paramPlayer == paramObject);
      localPlayer = (Player)paramObject;
    } while ((jv.equal(localPlayer.getPlayerId(), paramPlayer.getPlayerId())) && (jv.equal(localPlayer.getDisplayName(), paramPlayer.getDisplayName())) && (jv.equal(localPlayer.getIconImageUri(), paramPlayer.getIconImageUri())) && (jv.equal(localPlayer.getHiResImageUri(), paramPlayer.getHiResImageUri())) && (jv.equal(Long.valueOf(localPlayer.getRetrievedTimestamp()), Long.valueOf(paramPlayer.getRetrievedTimestamp()))) && (jv.equal(localPlayer.getTitle(), paramPlayer.getTitle())) && (jv.equal(localPlayer.getLevelInfo(), paramPlayer.getLevelInfo())));
    return false;
  }
  
  static int b(Player paramPlayer)
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = paramPlayer.getPlayerId();
    arrayOfObject[1] = paramPlayer.getDisplayName();
    arrayOfObject[2] = paramPlayer.getIconImageUri();
    arrayOfObject[3] = paramPlayer.getHiResImageUri();
    arrayOfObject[4] = Long.valueOf(paramPlayer.getRetrievedTimestamp());
    arrayOfObject[5] = paramPlayer.getTitle();
    arrayOfObject[6] = paramPlayer.getLevelInfo();
    return jv.hashCode(arrayOfObject);
  }
  
  static String c(Player paramPlayer)
  {
    return jv.h(paramPlayer).a("PlayerId", paramPlayer.getPlayerId()).a("DisplayName", paramPlayer.getDisplayName()).a("IconImageUri", paramPlayer.getIconImageUri()).a("IconImageUrl", paramPlayer.getIconImageUrl()).a("HiResImageUri", paramPlayer.getHiResImageUri()).a("HiResImageUrl", paramPlayer.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.getRetrievedTimestamp())).a("Title", paramPlayer.getTitle()).a("LevelInfo", paramPlayer.getLevelInfo()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Player freeze()
  {
    return this;
  }
  
  public String getDisplayName()
  {
    return this.OS;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.OS, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return this.WE;
  }
  
  public String getHiResImageUrl()
  {
    return this.WP;
  }
  
  public Uri getIconImageUri()
  {
    return this.WD;
  }
  
  public String getIconImageUrl()
  {
    return this.WO;
  }
  
  public long getLastPlayedWithTimestamp()
  {
    return this.Xk;
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.Xm;
  }
  
  public String getPlayerId()
  {
    return this.Xh;
  }
  
  public long getRetrievedTimestamp()
  {
    return this.Xi;
  }
  
  public String getTitle()
  {
    return this.OH;
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.OH, paramCharArrayBuffer);
  }
  
  public int getVersionCode()
  {
    return this.CK;
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
    return b(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isProfileVisible()
  {
    return this.Xn;
  }
  
  public int kE()
  {
    return this.Xj;
  }
  
  public MostRecentGameInfo kF()
  {
    return this.Xl;
  }
  
  public String toString()
  {
    return c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!hu())
    {
      PlayerEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.Xh);
    paramParcel.writeString(this.OS);
    String str1;
    String str2;
    if (this.WD == null)
    {
      str1 = null;
      paramParcel.writeString(str1);
      Uri localUri = this.WE;
      str2 = null;
      if (localUri != null) {
        break label84;
      }
    }
    for (;;)
    {
      paramParcel.writeString(str2);
      paramParcel.writeLong(this.Xi);
      return;
      str1 = this.WD.toString();
      break;
      label84:
      str2 = this.WE.toString();
    }
  }
  
  static final class PlayerEntityCreatorCompat
    extends PlayerEntityCreator
  {
    public PlayerEntity cm(Parcel paramParcel)
    {
      if ((PlayerEntity.b(PlayerEntity.kD())) || (PlayerEntity.bz(PlayerEntity.class.getCanonicalName()))) {
        return super.cm(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      String str4 = paramParcel.readString();
      Uri localUri1;
      if (str3 == null)
      {
        localUri1 = null;
        if (str4 != null) {
          break label104;
        }
      }
      label104:
      for (Uri localUri2 = null;; localUri2 = Uri.parse(str4))
      {
        return new PlayerEntity(11, str1, str2, localUri1, localUri2, paramParcel.readLong(), -1, -1L, null, null, null, null, null, true);
        localUri1 = Uri.parse(str3);
        break;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerEntity
 * JD-Core Version:    0.7.0.1
 */