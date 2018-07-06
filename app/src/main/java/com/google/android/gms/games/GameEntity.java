package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;

public final class GameEntity
  extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
  private final int CK;
  private final String Fo;
  private final String OS;
  private final String UO;
  private final String WA;
  private final String WB;
  private final String WC;
  private final Uri WD;
  private final Uri WE;
  private final Uri WF;
  private final boolean WG;
  private final boolean WH;
  private final String WI;
  private final int WJ;
  private final int WK;
  private final int WL;
  private final boolean WM;
  private final boolean WN;
  private final String WO;
  private final String WP;
  private final String WQ;
  private final boolean WR;
  private final boolean WS;
  private final boolean WT;
  private final String WU;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString11)
  {
    this.CK = paramInt1;
    this.Fo = paramString1;
    this.OS = paramString2;
    this.WA = paramString3;
    this.WB = paramString4;
    this.UO = paramString5;
    this.WC = paramString6;
    this.WD = paramUri1;
    this.WO = paramString8;
    this.WE = paramUri2;
    this.WP = paramString9;
    this.WF = paramUri3;
    this.WQ = paramString10;
    this.WG = paramBoolean1;
    this.WH = paramBoolean2;
    this.WI = paramString7;
    this.WJ = paramInt2;
    this.WK = paramInt3;
    this.WL = paramInt4;
    this.WM = paramBoolean3;
    this.WN = paramBoolean4;
    this.WR = paramBoolean5;
    this.WS = paramBoolean6;
    this.WT = paramBoolean7;
    this.WU = paramString11;
  }
  
  public GameEntity(Game paramGame)
  {
    this.CK = 5;
    this.Fo = paramGame.getApplicationId();
    this.WA = paramGame.getPrimaryCategory();
    this.WB = paramGame.getSecondaryCategory();
    this.UO = paramGame.getDescription();
    this.WC = paramGame.getDeveloperName();
    this.OS = paramGame.getDisplayName();
    this.WD = paramGame.getIconImageUri();
    this.WO = paramGame.getIconImageUrl();
    this.WE = paramGame.getHiResImageUri();
    this.WP = paramGame.getHiResImageUrl();
    this.WF = paramGame.getFeaturedImageUri();
    this.WQ = paramGame.getFeaturedImageUrl();
    this.WG = paramGame.ky();
    this.WH = paramGame.kA();
    this.WI = paramGame.kB();
    this.WJ = paramGame.kC();
    this.WK = paramGame.getAchievementTotalCount();
    this.WL = paramGame.getLeaderboardCount();
    this.WM = paramGame.isRealTimeMultiplayerEnabled();
    this.WN = paramGame.isTurnBasedMultiplayerEnabled();
    this.WR = paramGame.isMuted();
    this.WS = paramGame.kz();
    this.WT = paramGame.areSnapshotsEnabled();
    this.WU = paramGame.getThemeColor();
  }
  
  static int a(Game paramGame)
  {
    Object[] arrayOfObject = new Object[21];
    arrayOfObject[0] = paramGame.getApplicationId();
    arrayOfObject[1] = paramGame.getDisplayName();
    arrayOfObject[2] = paramGame.getPrimaryCategory();
    arrayOfObject[3] = paramGame.getSecondaryCategory();
    arrayOfObject[4] = paramGame.getDescription();
    arrayOfObject[5] = paramGame.getDeveloperName();
    arrayOfObject[6] = paramGame.getIconImageUri();
    arrayOfObject[7] = paramGame.getHiResImageUri();
    arrayOfObject[8] = paramGame.getFeaturedImageUri();
    arrayOfObject[9] = Boolean.valueOf(paramGame.ky());
    arrayOfObject[10] = Boolean.valueOf(paramGame.kA());
    arrayOfObject[11] = paramGame.kB();
    arrayOfObject[12] = Integer.valueOf(paramGame.kC());
    arrayOfObject[13] = Integer.valueOf(paramGame.getAchievementTotalCount());
    arrayOfObject[14] = Integer.valueOf(paramGame.getLeaderboardCount());
    arrayOfObject[15] = Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled());
    arrayOfObject[16] = Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled());
    arrayOfObject[17] = Boolean.valueOf(paramGame.isMuted());
    arrayOfObject[18] = Boolean.valueOf(paramGame.kz());
    arrayOfObject[19] = Boolean.valueOf(paramGame.areSnapshotsEnabled());
    arrayOfObject[20] = paramGame.getThemeColor();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(Game paramGame, Object paramObject)
  {
    boolean bool1 = true;
    if (!(paramObject instanceof Game)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      if (paramGame != paramObject)
      {
        Game localGame = (Game)paramObject;
        Boolean localBoolean;
        if ((jv.equal(localGame.getApplicationId(), paramGame.getApplicationId())) && (jv.equal(localGame.getDisplayName(), paramGame.getDisplayName())) && (jv.equal(localGame.getPrimaryCategory(), paramGame.getPrimaryCategory())) && (jv.equal(localGame.getSecondaryCategory(), paramGame.getSecondaryCategory())) && (jv.equal(localGame.getDescription(), paramGame.getDescription())) && (jv.equal(localGame.getDeveloperName(), paramGame.getDeveloperName())) && (jv.equal(localGame.getIconImageUri(), paramGame.getIconImageUri())) && (jv.equal(localGame.getHiResImageUri(), paramGame.getHiResImageUri())) && (jv.equal(localGame.getFeaturedImageUri(), paramGame.getFeaturedImageUri())) && (jv.equal(Boolean.valueOf(localGame.ky()), Boolean.valueOf(paramGame.ky()))) && (jv.equal(Boolean.valueOf(localGame.kA()), Boolean.valueOf(paramGame.kA()))) && (jv.equal(localGame.kB(), paramGame.kB())) && (jv.equal(Integer.valueOf(localGame.kC()), Integer.valueOf(paramGame.kC()))) && (jv.equal(Integer.valueOf(localGame.getAchievementTotalCount()), Integer.valueOf(paramGame.getAchievementTotalCount()))) && (jv.equal(Integer.valueOf(localGame.getLeaderboardCount()), Integer.valueOf(paramGame.getLeaderboardCount()))) && (jv.equal(Boolean.valueOf(localGame.isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()))))
        {
          localBoolean = Boolean.valueOf(localGame.isTurnBasedMultiplayerEnabled());
          if ((!paramGame.isTurnBasedMultiplayerEnabled()) || (!jv.equal(Boolean.valueOf(localGame.isMuted()), Boolean.valueOf(paramGame.isMuted()))) || (!jv.equal(Boolean.valueOf(localGame.kz()), Boolean.valueOf(paramGame.kz())))) {
            break label475;
          }
        }
        label475:
        for (boolean bool2 = bool1; (!jv.equal(localBoolean, Boolean.valueOf(bool2))) || (!jv.equal(Boolean.valueOf(localGame.areSnapshotsEnabled()), Boolean.valueOf(paramGame.areSnapshotsEnabled()))) || (!jv.equal(localGame.getThemeColor(), paramGame.getThemeColor())); bool2 = false) {
          return false;
        }
      }
    }
  }
  
  static String b(Game paramGame)
  {
    return jv.h(paramGame).a("ApplicationId", paramGame.getApplicationId()).a("DisplayName", paramGame.getDisplayName()).a("PrimaryCategory", paramGame.getPrimaryCategory()).a("SecondaryCategory", paramGame.getSecondaryCategory()).a("Description", paramGame.getDescription()).a("DeveloperName", paramGame.getDeveloperName()).a("IconImageUri", paramGame.getIconImageUri()).a("IconImageUrl", paramGame.getIconImageUrl()).a("HiResImageUri", paramGame.getHiResImageUri()).a("HiResImageUrl", paramGame.getHiResImageUrl()).a("FeaturedImageUri", paramGame.getFeaturedImageUri()).a("FeaturedImageUrl", paramGame.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(paramGame.ky())).a("InstanceInstalled", Boolean.valueOf(paramGame.kA())).a("InstancePackageName", paramGame.kB()).a("AchievementTotalCount", Integer.valueOf(paramGame.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(paramGame.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())).a("AreSnapshotsEnabled", Boolean.valueOf(paramGame.areSnapshotsEnabled())).a("ThemeColor", paramGame.getThemeColor()).toString();
  }
  
  public boolean areSnapshotsEnabled()
  {
    return this.WT;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Game freeze()
  {
    return this;
  }
  
  public int getAchievementTotalCount()
  {
    return this.WK;
  }
  
  public String getApplicationId()
  {
    return this.Fo;
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.UO, paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return this.WC;
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.WC, paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return this.OS;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.OS, paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return this.WF;
  }
  
  public String getFeaturedImageUrl()
  {
    return this.WQ;
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
  
  public int getLeaderboardCount()
  {
    return this.WL;
  }
  
  public String getPrimaryCategory()
  {
    return this.WA;
  }
  
  public String getSecondaryCategory()
  {
    return this.WB;
  }
  
  public String getThemeColor()
  {
    return this.WU;
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
  
  public boolean isMuted()
  {
    return this.WR;
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return this.WM;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return this.WN;
  }
  
  public boolean kA()
  {
    return this.WH;
  }
  
  public String kB()
  {
    return this.WI;
  }
  
  public int kC()
  {
    return this.WJ;
  }
  
  public boolean ky()
  {
    return this.WG;
  }
  
  public boolean kz()
  {
    return this.WS;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (!hu())
    {
      GameEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.Fo);
    paramParcel.writeString(this.OS);
    paramParcel.writeString(this.WA);
    paramParcel.writeString(this.WB);
    paramParcel.writeString(this.UO);
    paramParcel.writeString(this.WC);
    String str1;
    String str2;
    label90:
    String str3;
    label110:
    int j;
    if (this.WD == null)
    {
      str1 = null;
      paramParcel.writeString(str1);
      if (this.WE != null) {
        break label189;
      }
      str2 = null;
      paramParcel.writeString(str2);
      Uri localUri = this.WF;
      str3 = null;
      if (localUri != null) {
        break label201;
      }
      paramParcel.writeString(str3);
      if (!this.WG) {
        break label213;
      }
      j = i;
      label126:
      paramParcel.writeInt(j);
      if (!this.WH) {
        break label219;
      }
    }
    for (;;)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.WI);
      paramParcel.writeInt(this.WJ);
      paramParcel.writeInt(this.WK);
      paramParcel.writeInt(this.WL);
      return;
      str1 = this.WD.toString();
      break;
      label189:
      str2 = this.WE.toString();
      break label90;
      label201:
      str3 = this.WF.toString();
      break label110;
      label213:
      j = 0;
      break label126;
      label219:
      i = 0;
    }
  }
  
  static final class GameEntityCreatorCompat
    extends GameEntityCreator
  {
    public GameEntity cl(Parcel paramParcel)
    {
      if ((GameEntity.b(GameEntity.kD())) || (GameEntity.bz(GameEntity.class.getCanonicalName()))) {
        return super.cl(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      String str4 = paramParcel.readString();
      String str5 = paramParcel.readString();
      String str6 = paramParcel.readString();
      String str7 = paramParcel.readString();
      Uri localUri1;
      String str8;
      Uri localUri2;
      label88:
      String str9;
      Uri localUri3;
      label102:
      boolean bool1;
      if (str7 == null)
      {
        localUri1 = null;
        str8 = paramParcel.readString();
        if (str8 != null) {
          break label186;
        }
        localUri2 = null;
        str9 = paramParcel.readString();
        if (str9 != null) {
          break label196;
        }
        localUri3 = null;
        if (paramParcel.readInt() <= 0) {
          break label206;
        }
        bool1 = true;
        label112:
        if (paramParcel.readInt() <= 0) {
          break label212;
        }
      }
      label186:
      label196:
      label206:
      label212:
      for (boolean bool2 = true;; bool2 = false)
      {
        return new GameEntity(5, str1, str2, str3, str4, str5, str6, localUri1, localUri2, localUri3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false, false, null);
        localUri1 = Uri.parse(str7);
        break;
        localUri2 = Uri.parse(str8);
        break label88;
        localUri3 = Uri.parse(str9);
        break label102;
        bool1 = false;
        break label112;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.GameEntity
 * JD-Core Version:    0.7.0.1
 */