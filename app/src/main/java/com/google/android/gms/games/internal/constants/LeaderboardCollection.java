package com.google.android.gms.games.internal.constants;

public final class LeaderboardCollection
{
  public static String dZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown leaderboard collection: " + paramInt);
    case 0: 
      return "PUBLIC";
    }
    return "SOCIAL";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.constants.LeaderboardCollection
 * JD-Core Version:    0.7.0.1
 */