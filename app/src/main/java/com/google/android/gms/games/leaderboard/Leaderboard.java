package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

public abstract interface Leaderboard
  extends Freezable<Leaderboard>
{
  public static final int SCORE_ORDER_LARGER_IS_BETTER = 1;
  public static final int SCORE_ORDER_SMALLER_IS_BETTER;
  
  public abstract String getDisplayName();
  
  public abstract void getDisplayName(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract Game getGame();
  
  public abstract Uri getIconImageUri();
  
  @Deprecated
  public abstract String getIconImageUrl();
  
  public abstract String getLeaderboardId();
  
  public abstract int getScoreOrder();
  
  public abstract ArrayList<LeaderboardVariant> getVariants();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.Leaderboard
 * JD-Core Version:    0.7.0.1
 */