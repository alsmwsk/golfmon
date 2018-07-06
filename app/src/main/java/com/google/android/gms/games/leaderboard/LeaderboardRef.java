package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef
  extends d
  implements Leaderboard
{
  private final int Ya;
  private final Game adq;
  
  LeaderboardRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.Ya = paramInt2;
    this.adq = new GameRef(paramDataHolder, paramInt1);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardEntity.a(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return getString("name");
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a("name", paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.adq;
  }
  
  public Uri getIconImageUri()
  {
    return aR("board_icon_image_uri");
  }
  
  public String getIconImageUrl()
  {
    return getString("board_icon_image_url");
  }
  
  public String getLeaderboardId()
  {
    return getString("external_leaderboard_id");
  }
  
  public int getScoreOrder()
  {
    return getInteger("score_order");
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    ArrayList localArrayList = new ArrayList(this.Ya);
    for (int i = 0; i < this.Ya; i++) {
      localArrayList.add(new LeaderboardVariantRef(this.JG, i + this.KZ));
    }
    return localArrayList;
  }
  
  public int hashCode()
  {
    return LeaderboardEntity.a(this);
  }
  
  public Leaderboard mG()
  {
    return new LeaderboardEntity(this);
  }
  
  public String toString()
  {
    return LeaderboardEntity.b(this);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardRef
 * JD-Core Version:    0.7.0.1
 */