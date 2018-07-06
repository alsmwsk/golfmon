package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl
  implements Players
{
  public Player getCurrentPlayer(GoogleApiClient paramGoogleApiClient)
  {
    return Games.d(paramGoogleApiClient).lj();
  }
  
  public String getCurrentPlayerId(GoogleApiClient paramGoogleApiClient)
  {
    return Games.d(paramGoogleApiClient).li();
  }
  
  public Intent getPlayerSearchIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.d(paramGoogleApiClient).lt();
  }
  
  public PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramGoogleApiClient, paramBoolean)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramGoogleApiClient, paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramInt, false, paramBoolean);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramGoogleApiClient, paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramInt, true, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramGoogleApiClient, paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, "played_with", paramInt, true, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramGoogleApiClient, paramString)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramString, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient paramGoogleApiClient, final String paramString, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramGoogleApiClient, paramString)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramString, paramBoolean);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramGoogleApiClient, paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, "played_with", paramInt, false, paramBoolean);
      }
    });
  }
  
  private static abstract class LoadOwnerCoverPhotoUrisImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadOwnerCoverPhotoUrisResult>
  {
    public Players.LoadOwnerCoverPhotoUrisResult ac(final Status paramStatus)
    {
      new Players.LoadOwnerCoverPhotoUrisResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadPlayersImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult>
  {
    private LoadPlayersImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Players.LoadPlayersResult ad(final Status paramStatus)
    {
      new Players.LoadPlayersResult()
      {
        public PlayerBuffer getPlayers()
        {
          return new PlayerBuffer(DataHolder.av(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class LoadProfileSettingsResultImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadProfileSettingsResult>
  {
    protected Players.LoadProfileSettingsResult ae(final Status paramStatus)
    {
      new Players.LoadProfileSettingsResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public boolean isProfileVisible()
        {
          return true;
        }
        
        public boolean isVisibilityExplicitlySet()
        {
          return false;
        }
      };
    }
  }
  
  private static abstract class LoadXpForGameCategoriesResultImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGameCategoriesResult>
  {
    public Players.LoadXpForGameCategoriesResult af(final Status paramStatus)
    {
      new Players.LoadXpForGameCategoriesResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadXpStreamResultImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadXpStreamResult>
  {
    public Players.LoadXpStreamResult ag(final Status paramStatus)
    {
      new Players.LoadXpStreamResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class UpdateProfileSettingsResultImpl
    extends Games.BaseGamesApiMethodImpl<Status>
  {
    protected Status b(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.api.PlayersImpl
 * JD-Core Version:    0.7.0.1
 */