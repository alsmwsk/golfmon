package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class LeaderboardVariantEntity
  implements LeaderboardVariant
{
  private final int adF;
  private final int adG;
  private final boolean adH;
  private final long adI;
  private final String adJ;
  private final long adK;
  private final String adL;
  private final String adM;
  private final long adN;
  private final String adO;
  private final String adP;
  private final String adQ;
  
  public LeaderboardVariantEntity(LeaderboardVariant paramLeaderboardVariant)
  {
    this.adF = paramLeaderboardVariant.getTimeSpan();
    this.adG = paramLeaderboardVariant.getCollection();
    this.adH = paramLeaderboardVariant.hasPlayerInfo();
    this.adI = paramLeaderboardVariant.getRawPlayerScore();
    this.adJ = paramLeaderboardVariant.getDisplayPlayerScore();
    this.adK = paramLeaderboardVariant.getPlayerRank();
    this.adL = paramLeaderboardVariant.getDisplayPlayerRank();
    this.adM = paramLeaderboardVariant.getPlayerScoreTag();
    this.adN = paramLeaderboardVariant.getNumScores();
    this.adO = paramLeaderboardVariant.mK();
    this.adP = paramLeaderboardVariant.mL();
    this.adQ = paramLeaderboardVariant.mM();
  }
  
  static int a(LeaderboardVariant paramLeaderboardVariant)
  {
    Object[] arrayOfObject = new Object[11];
    arrayOfObject[0] = Integer.valueOf(paramLeaderboardVariant.getTimeSpan());
    arrayOfObject[1] = Integer.valueOf(paramLeaderboardVariant.getCollection());
    arrayOfObject[2] = Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo());
    arrayOfObject[3] = Long.valueOf(paramLeaderboardVariant.getRawPlayerScore());
    arrayOfObject[4] = paramLeaderboardVariant.getDisplayPlayerScore();
    arrayOfObject[5] = Long.valueOf(paramLeaderboardVariant.getPlayerRank());
    arrayOfObject[6] = paramLeaderboardVariant.getDisplayPlayerRank();
    arrayOfObject[7] = Long.valueOf(paramLeaderboardVariant.getNumScores());
    arrayOfObject[8] = paramLeaderboardVariant.mK();
    arrayOfObject[9] = paramLeaderboardVariant.mM();
    arrayOfObject[10] = paramLeaderboardVariant.mL();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(LeaderboardVariant paramLeaderboardVariant, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof LeaderboardVariant)) {
      bool = false;
    }
    LeaderboardVariant localLeaderboardVariant;
    do
    {
      do
      {
        return bool;
      } while (paramLeaderboardVariant == paramObject);
      localLeaderboardVariant = (LeaderboardVariant)paramObject;
    } while ((jv.equal(Integer.valueOf(localLeaderboardVariant.getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getTimeSpan()))) && (jv.equal(Integer.valueOf(localLeaderboardVariant.getCollection()), Integer.valueOf(paramLeaderboardVariant.getCollection()))) && (jv.equal(Boolean.valueOf(localLeaderboardVariant.hasPlayerInfo()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()))) && (jv.equal(Long.valueOf(localLeaderboardVariant.getRawPlayerScore()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()))) && (jv.equal(localLeaderboardVariant.getDisplayPlayerScore(), paramLeaderboardVariant.getDisplayPlayerScore())) && (jv.equal(Long.valueOf(localLeaderboardVariant.getPlayerRank()), Long.valueOf(paramLeaderboardVariant.getPlayerRank()))) && (jv.equal(localLeaderboardVariant.getDisplayPlayerRank(), paramLeaderboardVariant.getDisplayPlayerRank())) && (jv.equal(Long.valueOf(localLeaderboardVariant.getNumScores()), Long.valueOf(paramLeaderboardVariant.getNumScores()))) && (jv.equal(localLeaderboardVariant.mK(), paramLeaderboardVariant.mK())) && (jv.equal(localLeaderboardVariant.mM(), paramLeaderboardVariant.mM())) && (jv.equal(localLeaderboardVariant.mL(), paramLeaderboardVariant.mL())));
    return false;
  }
  
  static String b(LeaderboardVariant paramLeaderboardVariant)
  {
    jv.a locala1 = jv.h(paramLeaderboardVariant).a("TimeSpan", TimeSpan.dZ(paramLeaderboardVariant.getTimeSpan())).a("Collection", LeaderboardCollection.dZ(paramLeaderboardVariant.getCollection()));
    Object localObject1;
    String str1;
    label77:
    Object localObject2;
    label107:
    jv.a locala4;
    if (paramLeaderboardVariant.hasPlayerInfo())
    {
      localObject1 = Long.valueOf(paramLeaderboardVariant.getRawPlayerScore());
      jv.a locala2 = locala1.a("RawPlayerScore", localObject1);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label201;
      }
      str1 = paramLeaderboardVariant.getDisplayPlayerScore();
      jv.a locala3 = locala2.a("DisplayPlayerScore", str1);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label208;
      }
      localObject2 = Long.valueOf(paramLeaderboardVariant.getPlayerRank());
      locala4 = locala3.a("PlayerRank", localObject2);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label215;
      }
    }
    label201:
    label208:
    label215:
    for (String str2 = paramLeaderboardVariant.getDisplayPlayerRank();; str2 = "none")
    {
      return locala4.a("DisplayPlayerRank", str2).a("NumScores", Long.valueOf(paramLeaderboardVariant.getNumScores())).a("TopPageNextToken", paramLeaderboardVariant.mK()).a("WindowPageNextToken", paramLeaderboardVariant.mM()).a("WindowPagePrevToken", paramLeaderboardVariant.mL()).toString();
      localObject1 = "none";
      break;
      str1 = "none";
      break label77;
      localObject2 = "none";
      break label107;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int getCollection()
  {
    return this.adG;
  }
  
  public String getDisplayPlayerRank()
  {
    return this.adL;
  }
  
  public String getDisplayPlayerScore()
  {
    return this.adJ;
  }
  
  public long getNumScores()
  {
    return this.adN;
  }
  
  public long getPlayerRank()
  {
    return this.adK;
  }
  
  public String getPlayerScoreTag()
  {
    return this.adM;
  }
  
  public long getRawPlayerScore()
  {
    return this.adI;
  }
  
  public int getTimeSpan()
  {
    return this.adF;
  }
  
  public boolean hasPlayerInfo()
  {
    return this.adH;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String mK()
  {
    return this.adO;
  }
  
  public String mL()
  {
    return this.adP;
  }
  
  public String mM()
  {
    return this.adQ;
  }
  
  public LeaderboardVariant mN()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardVariantEntity
 * JD-Core Version:    0.7.0.1
 */