package com.google.android.gms.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface GamesMetadata
{
  public abstract Game getCurrentGame(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<LoadGamesResult> loadGame(GoogleApiClient paramGoogleApiClient);
  
  public static abstract interface LoadExtendedGamesResult
    extends Releasable, Result
  {}
  
  public static abstract interface LoadGameInstancesResult
    extends Releasable, Result
  {}
  
  public static abstract interface LoadGameSearchSuggestionsResult
    extends Releasable, Result
  {}
  
  public static abstract interface LoadGamesResult
    extends Releasable, Result
  {
    public abstract GameBuffer getGames();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.GamesMetadata
 * JD-Core Version:    0.7.0.1
 */