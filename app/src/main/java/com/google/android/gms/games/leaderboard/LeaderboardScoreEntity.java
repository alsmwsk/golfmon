package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.le;

public final class LeaderboardScoreEntity
  implements LeaderboardScore
{
  private final PlayerEntity adA;
  private final String adB;
  private final String adC;
  private final String adD;
  private final long ads;
  private final String adt;
  private final String adu;
  private final long adv;
  private final long adw;
  private final String adx;
  private final Uri ady;
  private final Uri adz;
  
  public LeaderboardScoreEntity(LeaderboardScore paramLeaderboardScore)
  {
    this.ads = paramLeaderboardScore.getRank();
    this.adt = ((String)jx.i(paramLeaderboardScore.getDisplayRank()));
    this.adu = ((String)jx.i(paramLeaderboardScore.getDisplayScore()));
    this.adv = paramLeaderboardScore.getRawScore();
    this.adw = paramLeaderboardScore.getTimestampMillis();
    this.adx = paramLeaderboardScore.getScoreHolderDisplayName();
    this.ady = paramLeaderboardScore.getScoreHolderIconImageUri();
    this.adz = paramLeaderboardScore.getScoreHolderHiResImageUri();
    Player localPlayer = paramLeaderboardScore.getScoreHolder();
    if (localPlayer == null) {}
    for (PlayerEntity localPlayerEntity = null;; localPlayerEntity = (PlayerEntity)localPlayer.freeze())
    {
      this.adA = localPlayerEntity;
      this.adB = paramLeaderboardScore.getScoreTag();
      this.adC = paramLeaderboardScore.getScoreHolderIconImageUrl();
      this.adD = paramLeaderboardScore.getScoreHolderHiResImageUrl();
      return;
    }
  }
  
  static int a(LeaderboardScore paramLeaderboardScore)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = Long.valueOf(paramLeaderboardScore.getRank());
    arrayOfObject[1] = paramLeaderboardScore.getDisplayRank();
    arrayOfObject[2] = Long.valueOf(paramLeaderboardScore.getRawScore());
    arrayOfObject[3] = paramLeaderboardScore.getDisplayScore();
    arrayOfObject[4] = Long.valueOf(paramLeaderboardScore.getTimestampMillis());
    arrayOfObject[5] = paramLeaderboardScore.getScoreHolderDisplayName();
    arrayOfObject[6] = paramLeaderboardScore.getScoreHolderIconImageUri();
    arrayOfObject[7] = paramLeaderboardScore.getScoreHolderHiResImageUri();
    arrayOfObject[8] = paramLeaderboardScore.getScoreHolder();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(LeaderboardScore paramLeaderboardScore, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof LeaderboardScore)) {
      bool = false;
    }
    LeaderboardScore localLeaderboardScore;
    do
    {
      do
      {
        return bool;
      } while (paramLeaderboardScore == paramObject);
      localLeaderboardScore = (LeaderboardScore)paramObject;
    } while ((jv.equal(Long.valueOf(localLeaderboardScore.getRank()), Long.valueOf(paramLeaderboardScore.getRank()))) && (jv.equal(localLeaderboardScore.getDisplayRank(), paramLeaderboardScore.getDisplayRank())) && (jv.equal(Long.valueOf(localLeaderboardScore.getRawScore()), Long.valueOf(paramLeaderboardScore.getRawScore()))) && (jv.equal(localLeaderboardScore.getDisplayScore(), paramLeaderboardScore.getDisplayScore())) && (jv.equal(Long.valueOf(localLeaderboardScore.getTimestampMillis()), Long.valueOf(paramLeaderboardScore.getTimestampMillis()))) && (jv.equal(localLeaderboardScore.getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderDisplayName())) && (jv.equal(localLeaderboardScore.getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderIconImageUri())) && (jv.equal(localLeaderboardScore.getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri())) && (jv.equal(localLeaderboardScore.getScoreHolder(), paramLeaderboardScore.getScoreHolder())) && (jv.equal(localLeaderboardScore.getScoreTag(), paramLeaderboardScore.getScoreTag())));
    return false;
  }
  
  static String b(LeaderboardScore paramLeaderboardScore)
  {
    jv.a locala = jv.h(paramLeaderboardScore).a("Rank", Long.valueOf(paramLeaderboardScore.getRank())).a("DisplayRank", paramLeaderboardScore.getDisplayRank()).a("Score", Long.valueOf(paramLeaderboardScore.getRawScore())).a("DisplayScore", paramLeaderboardScore.getDisplayScore()).a("Timestamp", Long.valueOf(paramLeaderboardScore.getTimestampMillis())).a("DisplayName", paramLeaderboardScore.getScoreHolderDisplayName()).a("IconImageUri", paramLeaderboardScore.getScoreHolderIconImageUri()).a("IconImageUrl", paramLeaderboardScore.getScoreHolderIconImageUrl()).a("HiResImageUri", paramLeaderboardScore.getScoreHolderHiResImageUri()).a("HiResImageUrl", paramLeaderboardScore.getScoreHolderHiResImageUrl());
    if (paramLeaderboardScore.getScoreHolder() == null) {}
    for (Object localObject = null;; localObject = paramLeaderboardScore.getScoreHolder()) {
      return locala.a("Player", localObject).a("ScoreTag", paramLeaderboardScore.getScoreTag()).toString();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return this.adt;
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.adt, paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return this.adu;
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.adu, paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return this.ads;
  }
  
  public long getRawScore()
  {
    return this.adv;
  }
  
  public Player getScoreHolder()
  {
    return this.adA;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (this.adA == null) {
      return this.adx;
    }
    return this.adA.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.adA == null)
    {
      le.b(this.adx, paramCharArrayBuffer);
      return;
    }
    this.adA.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (this.adA == null) {
      return this.adz;
    }
    return this.adA.getHiResImageUri();
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    if (this.adA == null) {
      return this.adD;
    }
    return this.adA.getHiResImageUrl();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (this.adA == null) {
      return this.ady;
    }
    return this.adA.getIconImageUri();
  }
  
  public String getScoreHolderIconImageUrl()
  {
    if (this.adA == null) {
      return this.adC;
    }
    return this.adA.getIconImageUrl();
  }
  
  public String getScoreTag()
  {
    return this.adB;
  }
  
  public long getTimestampMillis()
  {
    return this.adw;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public LeaderboardScore mJ()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardScoreEntity
 * JD-Core Version:    0.7.0.1
 */