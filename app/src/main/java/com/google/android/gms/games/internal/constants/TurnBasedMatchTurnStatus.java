package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class TurnBasedMatchTurnStatus
{
  public static String dZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      GamesLog.p("MatchTurnStatus", "Unknown match turn status: " + paramInt);
      return "TURN_STATUS_UNKNOWN";
    case 0: 
      return "TURN_STATUS_INVITED";
    case 1: 
      return "TURN_STATUS_MY_TURN";
    case 2: 
      return "TURN_STATUS_THEIR_TURN";
    }
    return "TURN_STATUS_COMPLETE";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus
 * JD-Core Version:    0.7.0.1
 */