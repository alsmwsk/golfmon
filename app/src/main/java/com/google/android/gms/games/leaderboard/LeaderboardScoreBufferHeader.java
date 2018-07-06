package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader
{
  private final Bundle DJ;
  
  public LeaderboardScoreBufferHeader(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    this.DJ = paramBundle;
  }
  
  public Bundle mI()
  {
    return this.DJ;
  }
  
  public static final class Builder {}
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader
 * JD-Core Version:    0.7.0.1
 */