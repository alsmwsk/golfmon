package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class LeaderboardEntity
  implements Leaderboard
{
  private final String OS;
  private final Uri WD;
  private final String WO;
  private final String adn;
  private final int ado;
  private final ArrayList<LeaderboardVariantEntity> adp;
  private final Game adq;
  
  public LeaderboardEntity(Leaderboard paramLeaderboard)
  {
    this.adn = paramLeaderboard.getLeaderboardId();
    this.OS = paramLeaderboard.getDisplayName();
    this.WD = paramLeaderboard.getIconImageUri();
    this.WO = paramLeaderboard.getIconImageUrl();
    this.ado = paramLeaderboard.getScoreOrder();
    Game localGame = paramLeaderboard.getGame();
    if (localGame == null) {}
    for (GameEntity localGameEntity = null;; localGameEntity = new GameEntity(localGame))
    {
      this.adq = localGameEntity;
      ArrayList localArrayList = paramLeaderboard.getVariants();
      int i = localArrayList.size();
      this.adp = new ArrayList(i);
      for (int j = 0; j < i; j++) {
        this.adp.add((LeaderboardVariantEntity)((LeaderboardVariant)localArrayList.get(j)).freeze());
      }
    }
  }
  
  static int a(Leaderboard paramLeaderboard)
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = paramLeaderboard.getLeaderboardId();
    arrayOfObject[1] = paramLeaderboard.getDisplayName();
    arrayOfObject[2] = paramLeaderboard.getIconImageUri();
    arrayOfObject[3] = Integer.valueOf(paramLeaderboard.getScoreOrder());
    arrayOfObject[4] = paramLeaderboard.getVariants();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(Leaderboard paramLeaderboard, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof Leaderboard)) {
      bool = false;
    }
    Leaderboard localLeaderboard;
    do
    {
      do
      {
        return bool;
      } while (paramLeaderboard == paramObject);
      localLeaderboard = (Leaderboard)paramObject;
    } while ((jv.equal(localLeaderboard.getLeaderboardId(), paramLeaderboard.getLeaderboardId())) && (jv.equal(localLeaderboard.getDisplayName(), paramLeaderboard.getDisplayName())) && (jv.equal(localLeaderboard.getIconImageUri(), paramLeaderboard.getIconImageUri())) && (jv.equal(Integer.valueOf(localLeaderboard.getScoreOrder()), Integer.valueOf(paramLeaderboard.getScoreOrder()))) && (jv.equal(localLeaderboard.getVariants(), paramLeaderboard.getVariants())));
    return false;
  }
  
  static String b(Leaderboard paramLeaderboard)
  {
    return jv.h(paramLeaderboard).a("LeaderboardId", paramLeaderboard.getLeaderboardId()).a("DisplayName", paramLeaderboard.getDisplayName()).a("IconImageUri", paramLeaderboard.getIconImageUri()).a("IconImageUrl", paramLeaderboard.getIconImageUrl()).a("ScoreOrder", Integer.valueOf(paramLeaderboard.getScoreOrder())).a("Variants", paramLeaderboard.getVariants()).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return this.OS;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.OS, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.adq;
  }
  
  public Uri getIconImageUri()
  {
    return this.WD;
  }
  
  public String getIconImageUrl()
  {
    return this.WO;
  }
  
  public String getLeaderboardId()
  {
    return this.adn;
  }
  
  public int getScoreOrder()
  {
    return this.ado;
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    return new ArrayList(this.adp);
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public Leaderboard mG()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardEntity
 * JD-Core Version:    0.7.0.1
 */