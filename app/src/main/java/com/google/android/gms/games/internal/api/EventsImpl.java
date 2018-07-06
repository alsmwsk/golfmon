package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl
  implements Events
{
  public void increment(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    GamesClientImpl localGamesClientImpl = Games.e(paramGoogleApiClient);
    if (localGamesClientImpl.isConnected())
    {
      localGamesClientImpl.o(paramString, paramInt);
      return;
    }
    paramGoogleApiClient.b(new UpdateImpl(paramGoogleApiClient, paramString)
    {
      public void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.o(paramString, paramInt);
      }
    });
  }
  
  public PendingResult<Events.LoadEventsResult> load(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadImpl(paramGoogleApiClient, paramBoolean)
    {
      public void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.d(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final String... paramVarArgs)
  {
    paramGoogleApiClient.a(new LoadImpl(paramGoogleApiClient, paramBoolean)
    {
      public void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramBoolean, paramVarArgs);
      }
    });
  }
  
  private static abstract class LoadImpl
    extends Games.BaseGamesApiMethodImpl<Events.LoadEventsResult>
  {
    private LoadImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Events.LoadEventsResult O(final Status paramStatus)
    {
      new Events.LoadEventsResult()
      {
        public EventBuffer getEvents()
        {
          return new EventBuffer(DataHolder.av(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class UpdateImpl
    extends Games.BaseGamesApiMethodImpl<Result>
  {
    private UpdateImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Result c(final Status paramStatus)
    {
      new Result()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.api.EventsImpl
 * JD-Core Version:    0.7.0.1
 */