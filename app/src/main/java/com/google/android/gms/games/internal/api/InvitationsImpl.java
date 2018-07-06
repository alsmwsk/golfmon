package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl
  implements Invitations
{
  public Intent getInvitationInboxIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.d(paramGoogleApiClient).lo();
  }
  
  public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient paramGoogleApiClient)
  {
    return loadInvitations(paramGoogleApiClient, 0);
  }
  
  public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new LoadInvitationsImpl(paramGoogleApiClient, paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.c(this, paramInt);
      }
    });
  }
  
  public void registerInvitationListener(GoogleApiClient paramGoogleApiClient, OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    d locald = paramGoogleApiClient.d(paramOnInvitationReceivedListener);
    Games.d(paramGoogleApiClient).a(locald);
  }
  
  public void unregisterInvitationListener(GoogleApiClient paramGoogleApiClient)
  {
    Games.d(paramGoogleApiClient).lp();
  }
  
  private static abstract class LoadInvitationsImpl
    extends Games.BaseGamesApiMethodImpl<Invitations.LoadInvitationsResult>
  {
    private LoadInvitationsImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Invitations.LoadInvitationsResult T(final Status paramStatus)
    {
      new Invitations.LoadInvitationsResult()
      {
        public InvitationBuffer getInvitations()
        {
          return new InvitationBuffer(DataHolder.av(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.api.InvitationsImpl
 * JD-Core Version:    0.7.0.1
 */