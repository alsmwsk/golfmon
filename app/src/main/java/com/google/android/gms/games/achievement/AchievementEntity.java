package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;

public final class AchievementEntity
  implements SafeParcelable, Achievement
{
  public static final AchievementEntityCreator CREATOR = new AchievementEntityCreator();
  private final int CK;
  private final int Gt;
  private final String UO;
  private final Uri XA;
  private final String XB;
  private final int XC;
  private final String XD;
  private final PlayerEntity XE;
  private final int XF;
  private final String XG;
  private final long XH;
  private final long XI;
  private final String Xx;
  private final Uri Xy;
  private final String Xz;
  private final String mName;
  private final int mState;
  
  AchievementEntity(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, Uri paramUri1, String paramString4, Uri paramUri2, String paramString5, int paramInt3, String paramString6, PlayerEntity paramPlayerEntity, int paramInt4, int paramInt5, String paramString7, long paramLong1, long paramLong2)
  {
    this.CK = paramInt1;
    this.Xx = paramString1;
    this.Gt = paramInt2;
    this.mName = paramString2;
    this.UO = paramString3;
    this.Xy = paramUri1;
    this.Xz = paramString4;
    this.XA = paramUri2;
    this.XB = paramString5;
    this.XC = paramInt3;
    this.XD = paramString6;
    this.XE = paramPlayerEntity;
    this.mState = paramInt4;
    this.XF = paramInt5;
    this.XG = paramString7;
    this.XH = paramLong1;
    this.XI = paramLong2;
  }
  
  public AchievementEntity(Achievement paramAchievement)
  {
    this.CK = 1;
    this.Xx = paramAchievement.getAchievementId();
    this.Gt = paramAchievement.getType();
    this.mName = paramAchievement.getName();
    this.UO = paramAchievement.getDescription();
    this.Xy = paramAchievement.getUnlockedImageUri();
    this.Xz = paramAchievement.getUnlockedImageUrl();
    this.XA = paramAchievement.getRevealedImageUri();
    this.XB = paramAchievement.getRevealedImageUrl();
    this.XE = ((PlayerEntity)paramAchievement.getPlayer().freeze());
    this.mState = paramAchievement.getState();
    this.XH = paramAchievement.getLastUpdatedTimestamp();
    this.XI = paramAchievement.getXpValue();
    if (paramAchievement.getType() == 1)
    {
      this.XC = paramAchievement.getTotalSteps();
      this.XD = paramAchievement.getFormattedTotalSteps();
      this.XF = paramAchievement.getCurrentSteps();
    }
    for (this.XG = paramAchievement.getFormattedCurrentSteps();; this.XG = null)
    {
      je.f(this.Xx);
      je.f(this.UO);
      return;
      this.XC = 0;
      this.XD = null;
      this.XF = 0;
    }
  }
  
  static int a(Achievement paramAchievement)
  {
    int j;
    int i;
    if (paramAchievement.getType() == 1)
    {
      j = paramAchievement.getCurrentSteps();
      i = paramAchievement.getTotalSteps();
    }
    for (;;)
    {
      Object[] arrayOfObject = new Object[10];
      arrayOfObject[0] = paramAchievement.getAchievementId();
      arrayOfObject[1] = paramAchievement.getName();
      arrayOfObject[2] = Integer.valueOf(paramAchievement.getType());
      arrayOfObject[3] = paramAchievement.getDescription();
      arrayOfObject[4] = Long.valueOf(paramAchievement.getXpValue());
      arrayOfObject[5] = Integer.valueOf(paramAchievement.getState());
      arrayOfObject[6] = Long.valueOf(paramAchievement.getLastUpdatedTimestamp());
      arrayOfObject[7] = paramAchievement.getPlayer();
      arrayOfObject[8] = Integer.valueOf(j);
      arrayOfObject[9] = Integer.valueOf(i);
      return jv.hashCode(arrayOfObject);
      i = 0;
      j = 0;
    }
  }
  
  static boolean a(Achievement paramAchievement, Object paramObject)
  {
    int i = 1;
    if (!(paramObject instanceof Achievement)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (paramAchievement != paramObject)
      {
        Achievement localAchievement = (Achievement)paramObject;
        boolean bool2;
        boolean bool1;
        if (paramAchievement.getType() == i)
        {
          bool2 = jv.equal(Integer.valueOf(localAchievement.getCurrentSteps()), Integer.valueOf(paramAchievement.getCurrentSteps()));
          bool1 = jv.equal(Integer.valueOf(localAchievement.getTotalSteps()), Integer.valueOf(paramAchievement.getTotalSteps()));
        }
        while ((!jv.equal(localAchievement.getAchievementId(), paramAchievement.getAchievementId())) || (!jv.equal(localAchievement.getName(), paramAchievement.getName())) || (!jv.equal(Integer.valueOf(localAchievement.getType()), Integer.valueOf(paramAchievement.getType()))) || (!jv.equal(localAchievement.getDescription(), paramAchievement.getDescription())) || (!jv.equal(Long.valueOf(localAchievement.getXpValue()), Long.valueOf(paramAchievement.getXpValue()))) || (!jv.equal(Integer.valueOf(localAchievement.getState()), Integer.valueOf(paramAchievement.getState()))) || (!jv.equal(Long.valueOf(localAchievement.getLastUpdatedTimestamp()), Long.valueOf(paramAchievement.getLastUpdatedTimestamp()))) || (!jv.equal(localAchievement.getPlayer(), paramAchievement.getPlayer())) || (!bool2) || (!bool1))
        {
          return false;
          bool1 = i;
          bool2 = i;
        }
      }
    }
  }
  
  static String b(Achievement paramAchievement)
  {
    jv.a locala = jv.h(paramAchievement).a("Id", paramAchievement.getAchievementId()).a("Type", Integer.valueOf(paramAchievement.getType())).a("Name", paramAchievement.getName()).a("Description", paramAchievement.getDescription()).a("Player", paramAchievement.getPlayer()).a("State", Integer.valueOf(paramAchievement.getState()));
    if (paramAchievement.getType() == 1)
    {
      locala.a("CurrentSteps", Integer.valueOf(paramAchievement.getCurrentSteps()));
      locala.a("TotalSteps", Integer.valueOf(paramAchievement.getTotalSteps()));
    }
    return locala.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Achievement freeze()
  {
    return this;
  }
  
  public String getAchievementId()
  {
    return this.Xx;
  }
  
  public int getCurrentSteps()
  {
    return this.XF;
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.UO, paramCharArrayBuffer);
  }
  
  public String getFormattedCurrentSteps()
  {
    return this.XG;
  }
  
  public void getFormattedCurrentSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.XG, paramCharArrayBuffer);
  }
  
  public String getFormattedTotalSteps()
  {
    return this.XD;
  }
  
  public void getFormattedTotalSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.XD, paramCharArrayBuffer);
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.XH;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.XE;
  }
  
  public Uri getRevealedImageUri()
  {
    return this.XA;
  }
  
  public String getRevealedImageUrl()
  {
    return this.XB;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getTotalSteps()
  {
    return this.XC;
  }
  
  public int getType()
  {
    return this.Gt;
  }
  
  public Uri getUnlockedImageUri()
  {
    return this.Xy;
  }
  
  public String getUnlockedImageUrl()
  {
    return this.Xz;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public long getXpValue()
  {
    return this.XI;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AchievementEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.achievement.AchievementEntity
 * JD-Core Version:    0.7.0.1
 */