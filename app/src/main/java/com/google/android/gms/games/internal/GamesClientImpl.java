package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ll;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl
  extends jl<IGamesService>
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private final String DZ;
  EventIncrementManager Yk = new EventIncrementManager()
  {
    public EventIncrementCache lF()
    {
      return new GamesClientImpl.GameClientEventIncrementCache(GamesClientImpl.this);
    }
  };
  private final String Yl;
  private final Map<String, RealTimeSocket> Ym;
  private PlayerEntity Yn;
  private GameEntity Yo;
  private final PopupManager Yp;
  private boolean Yq = false;
  private final Binder Yr;
  private final long Ys;
  private final Games.GamesOptions Yt;
  
  public GamesClientImpl(Context paramContext, Looper paramLooper, String paramString1, String paramString2, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, int paramInt, View paramView, Games.GamesOptions paramGamesOptions)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.Yl = paramString1;
    this.DZ = ((String)jx.i(paramString2));
    this.Yr = new Binder();
    this.Ym = new HashMap();
    this.Yp = PopupManager.a(this, paramInt);
    k(paramView);
    this.Ys = hashCode();
    this.Yt = paramGamesOptions;
    registerConnectionCallbacks(this);
    registerConnectionFailedListener(this);
  }
  
  private static Room R(DataHolder paramDataHolder)
  {
    RoomBuffer localRoomBuffer = new RoomBuffer(paramDataHolder);
    try
    {
      int i = localRoomBuffer.getCount();
      Room localRoom = null;
      if (i > 0) {
        localRoom = (Room)((Room)localRoomBuffer.get(0)).freeze();
      }
      return localRoom;
    }
    finally
    {
      localRoomBuffer.release();
    }
  }
  
  private RealTimeSocket bB(String paramString)
  {
    if (ll.ii()) {}
    for (RealTimeSocket localRealTimeSocket = bD(paramString);; localRealTimeSocket = bC(paramString))
    {
      if (localRealTimeSocket != null) {
        this.Ym.put(paramString, localRealTimeSocket);
      }
      return localRealTimeSocket;
    }
  }
  
  private RealTimeSocket bC(String paramString)
  {
    try
    {
      String str = ((IGamesService)hw()).bH(paramString);
      if (str == null) {
        return null;
      }
      LocalSocket localLocalSocket = new LocalSocket();
      localLocalSocket.connect(new LocalSocketAddress(str));
      RealTimeSocketImpl localRealTimeSocketImpl = new RealTimeSocketImpl(localLocalSocket, paramString);
      return localRealTimeSocketImpl;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "Unable to create socket. Service died.");
      return null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        GamesLog.p("GamesClientImpl", "connect() call failed on socket: " + localIOException.getMessage());
      }
    }
  }
  
  private RealTimeSocket bD(String paramString)
  {
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = ((IGamesService)hw()).bN(paramString);
      if (localParcelFileDescriptor != null)
      {
        GamesLog.n("GamesClientImpl", "Created native libjingle socket.");
        return new LibjingleNativeSocket(localParcelFileDescriptor);
      }
      GamesLog.p("GamesClientImpl", "Unable to create socket for " + paramString);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "Unable to create socket. Service died.");
    }
    return null;
  }
  
  private void lD()
  {
    Iterator localIterator = this.Ym.values().iterator();
    while (localIterator.hasNext())
    {
      RealTimeSocket localRealTimeSocket = (RealTimeSocket)localIterator.next();
      try
      {
        localRealTimeSocket.close();
      }
      catch (IOException localIOException)
      {
        GamesLog.c("GamesClientImpl", "IOException:", localIOException);
      }
    }
    this.Ym.clear();
  }
  
  private void lg()
  {
    this.Yn = null;
  }
  
  public int a(d<RealTimeMultiplayer.ReliableMessageSentCallback> paramd, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      int i = ((IGamesService)hw()).a(new RealTimeReliableMessageBinderCallbacks(paramd), paramArrayOfByte, paramString1, paramString2);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
  {
    jx.b(paramArrayOfString, "Participant IDs must not be null");
    try
    {
      int i = ((IGamesService)hw()).b(paramArrayOfByte, paramString, paramArrayOfString);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public Intent a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).a(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bitmap paramBitmap, String paramString)
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).a(paramInt1, paramArrayOfByte, paramInt2, paramString);
      jx.b(paramBitmap, "Must provide a non null icon");
      localIntent.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", paramBitmap);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(Room paramRoom, int paramInt)
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).a((RoomEntity)paramRoom.freeze(), paramInt);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).a(paramString, paramBoolean1, paramBoolean2, paramInt);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null)) {
      this.Yq = paramBundle.getBoolean("show_welcome_popup");
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(IBinder paramIBinder, Bundle paramBundle)
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)hw()).a(paramIBinder, paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Requests.LoadRequestsResult> paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ((IGamesService)hw()).a(new RequestsLoadedBinderCallbacks(paramb), paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).a(new ExtendedGamesLoadedBinderCallback(paramb), paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<AppContents.LoadAppContentResult> paramb, int paramInt, String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).a(new AppContentLoadedBinderCallbacks(paramb), paramInt, paramString, paramArrayOfString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).a(new PlayersLoadedBinderCallback(paramb), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.LoadMatchesResult> paramb, int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      ((IGamesService)hw()).a(new TurnBasedMatchesLoadedBinderCallbacks(paramb), paramInt, paramArrayOfInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2)
  {
    try
    {
      ((IGamesService)hw()).a(new LeaderboardScoresLoadedBinderCallback(paramb), paramLeaderboardScoreBuffer.mH().mI(), paramInt1, paramInt2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, TurnBasedMatchConfig paramTurnBasedMatchConfig)
  {
    try
    {
      ((IGamesService)hw()).a(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramTurnBasedMatchConfig.getVariant(), paramTurnBasedMatchConfig.mO(), paramTurnBasedMatchConfig.getInvitedPlayerIds(), paramTurnBasedMatchConfig.getAutoMatchCriteria());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Snapshots.CommitSnapshotResult> paramb, Snapshot paramSnapshot, SnapshotMetadataChange paramSnapshotMetadataChange)
  {
    SnapshotContents localSnapshotContents = paramSnapshot.getSnapshotContents();
    if (!localSnapshotContents.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Snapshot already closed");
      com.google.android.gms.common.data.a locala = paramSnapshotMetadataChange.mT();
      if (locala != null) {
        locala.a(getContext().getCacheDir());
      }
      Contents localContents = localSnapshotContents.ir();
      localSnapshotContents.close();
      try
      {
        ((IGamesService)hw()).a(new SnapshotCommittedBinderCallbacks(paramb), paramSnapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity)paramSnapshotMetadataChange, localContents);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.o("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(BaseImplementation.b<Achievements.UpdateAchievementResult> paramb, String paramString)
  {
    if (paramb == null) {}
    for (Object localObject = null;; localObject = localAchievementUpdatedBinderCallback)
    {
      try
      {
        ((IGamesService)hw()).a((IGamesCallbacks)localObject, paramString, this.Yp.lV(), this.Yp.lU());
        return;
      }
      catch (RemoteException localRemoteException)
      {
        AchievementUpdatedBinderCallback localAchievementUpdatedBinderCallback;
        GamesLog.o("GamesClientImpl", "service died");
      }
      localAchievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(paramb);
    }
  }
  
  public void a(BaseImplementation.b<Achievements.UpdateAchievementResult> paramb, String paramString, int paramInt)
  {
    if (paramb == null) {}
    for (Object localObject = null;; localObject = new AchievementUpdatedBinderCallback(paramb)) {
      try
      {
        ((IGamesService)hw()).a((IGamesCallbacks)localObject, paramString, paramInt, this.Yp.lV(), this.Yp.lU());
        return;
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.o("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).a(new LeaderboardScoresLoadedBinderCallback(paramb), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid player collection: " + paramString);
        if (paramString.equals("played_with")) {
          i = 0;
        }
        break;
      }
    }
    try
    {
      ((IGamesService)hw()).d(new PlayersLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    try
    {
      ((IGamesService)hw()).a(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.LoadMatchesResult> paramb, String paramString, int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      ((IGamesService)hw()).a(new TurnBasedMatchesLoadedBinderCallbacks(paramb), paramString, paramInt, paramArrayOfInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.SubmitScoreResult> paramb, String paramString1, long paramLong, String paramString2)
  {
    if (paramb == null) {}
    for (Object localObject = null;; localObject = new SubmitScoreBinderCallbacks(paramb)) {
      try
      {
        ((IGamesService)hw()).a((IGamesCallbacks)localObject, paramString1, paramLong, paramString2);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.o("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.LeaveMatchResult> paramb, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)hw()).c(new TurnBasedMatchLeftBinderCallbacks(paramb), paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LoadPlayerScoreResult> paramb, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      ((IGamesService)hw()).a(new PlayerLeaderboardScoreLoadedBinderCallback(paramb), paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Requests.LoadRequestsResult> paramb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ((IGamesService)hw()).a(new RequestsLoadedBinderCallbacks(paramb), paramString1, paramString2, paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).a(new LeaderboardScoresLoadedBinderCallback(paramb), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid player collection: " + paramString1);
        if (paramString1.equals("circled"))
        {
          i = 0;
          continue;
          if (paramString1.equals("played_with"))
          {
            i = 1;
            continue;
            if (paramString1.equals("nearby")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    try
    {
      ((IGamesService)hw()).a(new PlayersLoadedBinderCallback(paramb), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Snapshots.OpenSnapshotResult> paramb, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, SnapshotContents paramSnapshotContents)
  {
    if (!paramSnapshotContents.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "SnapshotContents already closed");
      com.google.android.gms.common.data.a locala = paramSnapshotMetadataChange.mT();
      if (locala != null) {
        locala.a(getContext().getCacheDir());
      }
      Contents localContents = paramSnapshotContents.ir();
      paramSnapshotContents.close();
      try
      {
        ((IGamesService)hw()).a(new SnapshotOpenedBinderCallbacks(paramb), paramString1, paramString2, (SnapshotMetadataChangeEntity)paramSnapshotMetadataChange, localContents);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.o("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> paramb, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).b(new LeaderboardsLoadedBinderCallback(paramb), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Quests.LoadQuestsResult> paramb, String paramString1, String paramString2, boolean paramBoolean, String[] paramArrayOfString)
  {
    try
    {
      this.Yk.flush();
      ((IGamesService)hw()).a(new QuestsLoadedBinderCallbacks(paramb), paramString1, paramString2, paramArrayOfString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Quests.LoadQuestsResult> paramb, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    try
    {
      this.Yk.flush();
      ((IGamesService)hw()).a(new QuestsLoadedBinderCallbacks(paramb), paramString1, paramString2, paramArrayOfInt, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Requests.UpdateRequestsResult> paramb, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)hw()).a(new RequestsUpdatedBinderCallbacks(paramb), paramString1, paramString2, paramArrayOfString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).f(new PlayersLoadedBinderCallback(paramb), paramString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.UpdateMatchResult> paramb, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((IGamesService)hw()).a(new TurnBasedMatchUpdatedBinderCallbacks(paramb), paramString1, paramArrayOfByte, paramString2, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.UpdateMatchResult> paramb, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((IGamesService)hw()).a(new TurnBasedMatchUpdatedBinderCallbacks(paramb), paramString, paramArrayOfByte, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Requests.SendRequestResult> paramb, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    try
    {
      ((IGamesService)hw()).a(new RequestSentBinderCallbacks(paramb), paramString, paramArrayOfString, paramInt1, paramArrayOfByte, paramInt2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).c(new PlayersLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Status> paramb, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      ((IGamesService)hw()).a(new ContactSettingsUpdatedBinderCallback(paramb), paramBoolean, paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Events.LoadEventsResult> paramb, boolean paramBoolean, String... paramVarArgs)
  {
    try
    {
      this.Yk.flush();
      ((IGamesService)hw()).a(new EventsLoadedBinderCallback(paramb), paramBoolean, paramVarArgs);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Quests.LoadQuestsResult> paramb, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    try
    {
      this.Yk.flush();
      ((IGamesService)hw()).a(new QuestsLoadedBinderCallbacks(paramb), paramArrayOfInt, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)hw()).c(new PlayersLoadedBinderCallback(paramb), paramArrayOfString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(d<OnInvitationReceivedListener> paramd)
  {
    try
    {
      InvitationReceivedBinderCallback localInvitationReceivedBinderCallback = new InvitationReceivedBinderCallback(paramd);
      ((IGamesService)hw()).a(localInvitationReceivedBinderCallback, this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(d<RoomUpdateListener> paramd, d<RoomStatusUpdateListener> paramd1, d<RealTimeMessageReceivedListener> paramd2, RoomConfig paramRoomConfig)
  {
    lD();
    try
    {
      RoomBinderCallbacks localRoomBinderCallbacks = new RoomBinderCallbacks(paramd, paramd1, paramd2);
      ((IGamesService)hw()).a(localRoomBinderCallbacks, this.Yr, paramRoomConfig.getVariant(), paramRoomConfig.getInvitedPlayerIds(), paramRoomConfig.getAutoMatchCriteria(), paramRoomConfig.isSocketEnabled(), this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(d<RoomUpdateListener> paramd, String paramString)
  {
    try
    {
      ((IGamesService)hw()).c(new RoomBinderCallbacks(paramd), paramString);
      lD();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void a(Snapshot paramSnapshot)
  {
    SnapshotContents localSnapshotContents = paramSnapshot.getSnapshotContents();
    if (!localSnapshotContents.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Snapshot already closed");
      Contents localContents = localSnapshotContents.ir();
      localSnapshotContents.close();
      try
      {
        ((IGamesService)hw()).a(localContents);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.o("GamesClientImpl", "service died");
      }
    }
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    String str = getContext().getResources().getConfiguration().locale.toString();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.Yt.Xa);
    localBundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Yt.Xb);
    localBundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Yt.Xc);
    localBundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.Yt.Xd);
    localBundle.putInt("com.google.android.gms.games.key.sdkVariant", this.Yt.Xe);
    localBundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.Yt.Xf);
    localBundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.Yt.Xg);
    paramjt.a(parame, 6587000, getContext().getPackageName(), this.DZ, hv(), this.Yl, this.Yp.lV(), str, localBundle);
  }
  
  protected IGamesService aC(IBinder paramIBinder)
  {
    return IGamesService.Stub.aE(paramIBinder);
  }
  
  public Intent b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).b(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent b(int[] paramArrayOfInt)
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).b(paramArrayOfInt);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void b(BaseImplementation.b<Status> paramb)
  {
    try
    {
      this.Yk.flush();
      ((IGamesService)hw()).a(new SignOutCompleteBinderCallbacks(paramb));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Players.LoadPlayersResult> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).b(new PlayersLoadedBinderCallback(paramb), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Achievements.UpdateAchievementResult> paramb, String paramString)
  {
    if (paramb == null) {}
    for (Object localObject = null;; localObject = localAchievementUpdatedBinderCallback)
    {
      try
      {
        ((IGamesService)hw()).b((IGamesCallbacks)localObject, paramString, this.Yp.lV(), this.Yp.lU());
        return;
      }
      catch (RemoteException localRemoteException)
      {
        AchievementUpdatedBinderCallback localAchievementUpdatedBinderCallback;
        GamesLog.o("GamesClientImpl", "service died");
      }
      localAchievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(paramb);
    }
  }
  
  public void b(BaseImplementation.b<Achievements.UpdateAchievementResult> paramb, String paramString, int paramInt)
  {
    if (paramb == null) {}
    for (Object localObject = null;; localObject = new AchievementUpdatedBinderCallback(paramb)) {
      try
      {
        ((IGamesService)hw()).b((IGamesCallbacks)localObject, paramString, paramInt, this.Yp.lV(), this.Yp.lU());
        return;
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.o("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).b(new LeaderboardScoresLoadedBinderCallback(paramb), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).a(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Quests.ClaimMilestoneResult> paramb, String paramString1, String paramString2)
  {
    try
    {
      this.Yk.flush();
      ((IGamesService)hw()).f(new QuestMilestoneClaimBinderCallbacks(paramb, paramString2), paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).b(new LeaderboardScoresLoadedBinderCallback(paramb), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).b(new PlayersLoadedBinderCallback(paramb), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Achievements.LoadAchievementsResult> paramb, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).a(new AchievementsLoadedBinderCallback(paramb), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> paramb, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).c(new LeaderboardsLoadedBinderCallback(paramb), paramString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).b(new LeaderboardsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Quests.LoadQuestsResult> paramb, boolean paramBoolean, String[] paramArrayOfString)
  {
    try
    {
      this.Yk.flush();
      ((IGamesService)hw()).a(new QuestsLoadedBinderCallbacks(paramb), paramArrayOfString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Requests.UpdateRequestsResult> paramb, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)hw()).a(new RequestsUpdatedBinderCallbacks(paramb), paramArrayOfString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(d<OnTurnBasedMatchUpdateReceivedListener> paramd)
  {
    try
    {
      MatchUpdateReceivedBinderCallback localMatchUpdateReceivedBinderCallback = new MatchUpdateReceivedBinderCallback(paramd);
      ((IGamesService)hw()).b(localMatchUpdateReceivedBinderCallback, this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void b(d<RoomUpdateListener> paramd, d<RoomStatusUpdateListener> paramd1, d<RealTimeMessageReceivedListener> paramd2, RoomConfig paramRoomConfig)
  {
    lD();
    try
    {
      RoomBinderCallbacks localRoomBinderCallbacks = new RoomBinderCallbacks(paramd, paramd1, paramd2);
      ((IGamesService)hw()).a(localRoomBinderCallbacks, this.Yr, paramRoomConfig.getInvitationId(), paramRoomConfig.isSocketEnabled(), this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void bA(String paramString)
  {
    try
    {
      ((IGamesService)hw()).bL(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public Intent bE(String paramString)
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).bE(paramString);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void bF(String paramString)
  {
    try
    {
      ((IGamesService)hw()).a(paramString, this.Yp.lV(), this.Yp.lU());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  protected String bK()
  {
    return "com.google.android.gms.games.service.START";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.games.internal.IGamesService";
  }
  
  public void c(BaseImplementation.b<Invitations.LoadInvitationsResult> paramb, int paramInt)
  {
    try
    {
      ((IGamesService)hw()).a(new InvitationsLoadedBinderCallback(paramb), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Players.LoadPlayersResult> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).c(new PlayersLoadedBinderCallback(paramb), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).l(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Players.LoadXpStreamResult> paramb, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)hw()).b(new PlayerXpStreamLoadedBinderCallback(paramb), paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).e(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)hw()).d(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Snapshots.LoadSnapshotsResult> paramb, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).c(new SnapshotsLoadedBinderCallbacks(paramb), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Snapshots.OpenSnapshotResult> paramb, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).e(new SnapshotOpenedBinderCallbacks(paramb), paramString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Achievements.LoadAchievementsResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).a(new AchievementsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Requests.UpdateRequestsResult> paramb, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)hw()).b(new RequestsUpdatedBinderCallbacks(paramb), paramArrayOfString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void c(d<QuestUpdateListener> paramd)
  {
    try
    {
      QuestUpdateBinderCallback localQuestUpdateBinderCallback = new QuestUpdateBinderCallback(paramd);
      ((IGamesService)hw()).d(localQuestUpdateBinderCallback, this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  protected void c(String... paramVarArgs)
  {
    int i = 0;
    int j = 0;
    boolean bool1 = false;
    if (i < paramVarArgs.length)
    {
      String str = paramVarArgs[i];
      if (str.equals("https://www.googleapis.com/auth/games")) {
        bool1 = true;
      }
      for (;;)
      {
        i++;
        break;
        if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
          j = 1;
        }
      }
    }
    if (j != 0)
    {
      if (!bool1) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        jx.a(bool2, "Cannot have both %s and %s!", new Object[] { "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty" });
        return;
      }
    }
    jx.a(bool1, "Games APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/games" });
  }
  
  public void connect()
  {
    lg();
    super.connect();
  }
  
  public int d(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      int i = ((IGamesService)hw()).b(paramArrayOfByte, paramString, null);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public void d(BaseImplementation.b<Players.LoadPlayersResult> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).e(new PlayersLoadedBinderCallback(paramb), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).m(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<Players.LoadXpStreamResult> paramb, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)hw()).c(new PlayerXpStreamLoadedBinderCallback(paramb), paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).f(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)hw()).e(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> paramb, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).d(new LeaderboardsLoadedBinderCallback(paramb), paramString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<Events.LoadEventsResult> paramb, boolean paramBoolean)
  {
    try
    {
      this.Yk.flush();
      ((IGamesService)hw()).f(new EventsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void d(d<OnRequestReceivedListener> paramd)
  {
    try
    {
      RequestReceivedBinderCallback localRequestReceivedBinderCallback = new RequestReceivedBinderCallback(paramd);
      ((IGamesService)hw()).c(localRequestReceivedBinderCallback, this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void dS(int paramInt)
  {
    this.Yp.setGravity(paramInt);
  }
  
  public void dT(int paramInt)
  {
    try
    {
      ((IGamesService)hw()).dT(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void disconnect()
  {
    this.Yq = false;
    if (isConnected()) {}
    try
    {
      IGamesService localIGamesService = (IGamesService)hw();
      localIGamesService.lE();
      this.Yk.flush();
      localIGamesService.q(this.Ys);
      lD();
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.o("GamesClientImpl", "Failed to notify client disconnect.");
      }
    }
  }
  
  public void e(BaseImplementation.b<TurnBasedMultiplayer.LeaveMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).o(new TurnBasedMatchLeftBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void e(BaseImplementation.b<Invitations.LoadInvitationsResult> paramb, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)hw()).b(new InvitationsLoadedBinderCallback(paramb), paramString, paramInt, false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void e(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).c(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void e(BaseImplementation.b<Notifications.GameMuteStatusChangeResult> paramb, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).a(new GameMuteStatusChangedBinderCallback(paramb), paramString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void e(BaseImplementation.b<Snapshots.LoadSnapshotsResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).d(new SnapshotsLoadedBinderCallbacks(paramb), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<GamesMetadata.LoadGamesResult> paramb)
  {
    try
    {
      ((IGamesService)hw()).d(new GamesLoadedBinderCallback(paramb));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<TurnBasedMultiplayer.CancelMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).n(new TurnBasedMatchCanceledBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<Requests.LoadRequestSummariesResult> paramb, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)hw()).a(new RequestSummariesLoadedBinderCallbacks(paramb), paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)hw()).b(new PlayersLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<Players.LoadProfileSettingsResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).g(new ProfileSettingsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public Bundle fX()
  {
    try
    {
      Bundle localBundle = ((IGamesService)hw()).fX();
      if (localBundle != null) {
        localBundle.setClassLoader(GamesClientImpl.class.getClassLoader());
      }
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void g(BaseImplementation.b<Players.LoadOwnerCoverPhotoUrisResult> paramb)
  {
    try
    {
      ((IGamesService)hw()).j(new OwnerCoverPhotoUrisLoadedBinderCallback(paramb));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void g(BaseImplementation.b<TurnBasedMultiplayer.LoadMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).p(new TurnBasedMatchLoadedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void g(BaseImplementation.b<Status> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).h(new ProfileSettingsUpdatedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void h(BaseImplementation.b<Acls.LoadAclResult> paramb)
  {
    try
    {
      ((IGamesService)hw()).h(new NotifyAclLoadedBinderCallback(paramb));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void h(BaseImplementation.b<Quests.AcceptQuestResult> paramb, String paramString)
  {
    try
    {
      this.Yk.flush();
      ((IGamesService)hw()).u(new QuestAcceptedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void h(BaseImplementation.b<Notifications.ContactSettingLoadResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)hw()).e(new ContactSettingsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void i(BaseImplementation.b<Notifications.InboxCountResult> paramb)
  {
    try
    {
      ((IGamesService)hw()).t(new InboxCountsLoadedBinderCallback(paramb), null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void i(BaseImplementation.b<Snapshots.DeleteSnapshotResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).r(new SnapshotDeletedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void j(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).e(new ExtendedGamesLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void k(View paramView)
  {
    this.Yp.l(paramView);
  }
  
  public void k(BaseImplementation.b<GamesMetadata.LoadGameInstancesResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).f(new GameInstancesLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void l(BaseImplementation.b<GamesMetadata.LoadGameSearchSuggestionsResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).q(new GameSearchSuggestionsLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public int lA()
  {
    try
    {
      int i = ((IGamesService)hw()).lA();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int lB()
  {
    try
    {
      int i = ((IGamesService)hw()).lB();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int lC()
  {
    try
    {
      int i = ((IGamesService)hw()).lC();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public void lE()
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)hw()).lE();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public String lh()
  {
    try
    {
      String str = ((IGamesService)hw()).lh();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public String li()
  {
    try
    {
      String str = ((IGamesService)hw()).li();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  /* Error */
  public Player lj()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1057	com/google/android/gms/games/internal/GamesClientImpl:dS	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 254	com/google/android/gms/games/internal/GamesClientImpl:Yn	Lcom/google/android/gms/games/PlayerEntity;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +51 -> 63
    //   15: new 1059	com/google/android/gms/games/PlayerBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 153	com/google/android/gms/games/internal/GamesClientImpl:hw	()Landroid/os/IInterface;
    //   23: checkcast 155	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1063 1 0
    //   31: invokespecial 1064	com/google/android/gms/games/PlayerBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_3
    //   35: aload_3
    //   36: invokevirtual 1065	com/google/android/gms/games/PlayerBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 1068	com/google/android/gms/games/PlayerBuffer:get	(I)Lcom/google/android/gms/games/Player;
    //   48: invokeinterface 1071 1 0
    //   53: checkcast 1073	com/google/android/gms/games/PlayerEntity
    //   56: putfield 254	com/google/android/gms/games/internal/GamesClientImpl:Yn	Lcom/google/android/gms/games/PlayerEntity;
    //   59: aload_3
    //   60: invokevirtual 1074	com/google/android/gms/games/PlayerBuffer:release	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 254	com/google/android/gms/games/internal/GamesClientImpl:Yn	Lcom/google/android/gms/games/PlayerEntity;
    //   69: areturn
    //   70: astore 4
    //   72: aload_3
    //   73: invokevirtual 1074	com/google/android/gms/games/PlayerBuffer:release	()V
    //   76: aload 4
    //   78: athrow
    //   79: astore 5
    //   81: ldc 178
    //   83: ldc_w 265
    //   86: invokestatic 268	com/google/android/gms/games/internal/GamesLog:o	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: goto -26 -> 63
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	GamesClientImpl
    //   92	4	1	localObject1	Object
    //   10	2	2	localPlayerEntity	PlayerEntity
    //   34	39	3	localPlayerBuffer	PlayerBuffer
    //   70	7	4	localObject2	Object
    //   79	1	5	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	79	android/os/RemoteException
    //   59	63	79	android/os/RemoteException
    //   72	79	79	android/os/RemoteException
    //   6	11	92	finally
    //   15	35	92	finally
    //   59	63	92	finally
    //   63	65	92	finally
    //   72	79	92	finally
    //   81	89	92	finally
    //   93	95	92	finally
  }
  
  /* Error */
  public com.google.android.gms.games.Game lk()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1057	com/google/android/gms/games/internal/GamesClientImpl:dS	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 1078	com/google/android/gms/games/internal/GamesClientImpl:Yo	Lcom/google/android/gms/games/GameEntity;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +51 -> 63
    //   15: new 1080	com/google/android/gms/games/GameBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 153	com/google/android/gms/games/internal/GamesClientImpl:hw	()Landroid/os/IInterface;
    //   23: checkcast 155	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1083 1 0
    //   31: invokespecial 1084	com/google/android/gms/games/GameBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_3
    //   35: aload_3
    //   36: invokevirtual 1085	com/google/android/gms/games/GameBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 1088	com/google/android/gms/games/GameBuffer:get	(I)Lcom/google/android/gms/games/Game;
    //   48: invokeinterface 1091 1 0
    //   53: checkcast 1093	com/google/android/gms/games/GameEntity
    //   56: putfield 1078	com/google/android/gms/games/internal/GamesClientImpl:Yo	Lcom/google/android/gms/games/GameEntity;
    //   59: aload_3
    //   60: invokevirtual 1094	com/google/android/gms/games/GameBuffer:release	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 1078	com/google/android/gms/games/internal/GamesClientImpl:Yo	Lcom/google/android/gms/games/GameEntity;
    //   69: areturn
    //   70: astore 4
    //   72: aload_3
    //   73: invokevirtual 1094	com/google/android/gms/games/GameBuffer:release	()V
    //   76: aload 4
    //   78: athrow
    //   79: astore 5
    //   81: ldc 178
    //   83: ldc_w 265
    //   86: invokestatic 268	com/google/android/gms/games/internal/GamesLog:o	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: goto -26 -> 63
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	GamesClientImpl
    //   92	4	1	localObject1	Object
    //   10	2	2	localGameEntity	GameEntity
    //   34	39	3	localGameBuffer	GameBuffer
    //   70	7	4	localObject2	Object
    //   79	1	5	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	79	android/os/RemoteException
    //   59	63	79	android/os/RemoteException
    //   72	79	79	android/os/RemoteException
    //   6	11	92	finally
    //   15	35	92	finally
    //   59	63	92	finally
    //   63	65	92	finally
    //   72	79	92	finally
    //   81	89	92	finally
    //   93	95	92	finally
  }
  
  public Intent ll()
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).ll();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent lm()
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).lm();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent ln()
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).ln();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent lo()
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).lo();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void lp()
  {
    try
    {
      ((IGamesService)hw()).r(this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void lq()
  {
    try
    {
      ((IGamesService)hw()).s(this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void lr()
  {
    try
    {
      ((IGamesService)hw()).u(this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void ls()
  {
    try
    {
      ((IGamesService)hw()).t(this.Ys);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public Intent lt()
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).lt();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent lu()
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).lu();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int lv()
  {
    try
    {
      int i = ((IGamesService)hw()).lv();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return 4368;
  }
  
  public String lw()
  {
    try
    {
      String str = ((IGamesService)hw()).lw();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int lx()
  {
    try
    {
      int i = ((IGamesService)hw()).lx();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public Intent ly()
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).ly();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int lz()
  {
    try
    {
      int i = ((IGamesService)hw()).lz();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public void m(BaseImplementation.b<Players.LoadXpForGameCategoriesResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).s(new PlayerXpForGameCategoriesLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public Intent n(String paramString, int paramInt)
  {
    try
    {
      Intent localIntent = ((IGamesService)hw()).u(paramString, paramInt);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void n(BaseImplementation.b<Invitations.LoadInvitationsResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).k(new InvitationsLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void o(BaseImplementation.b<Status> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).j(new NotifyAclUpdatedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void o(String paramString, int paramInt)
  {
    this.Yk.o(paramString, paramInt);
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (this.Yq)
    {
      this.Yp.lT();
      this.Yq = false;
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.Yq = false;
  }
  
  public void onConnectionSuspended(int paramInt) {}
  
  public void p(BaseImplementation.b<Notifications.GameMuteStatusLoadResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)hw()).i(new GameMuteStatusLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void p(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)hw()).p(paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public void q(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)hw()).q(paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.o("GamesClientImpl", "service died");
    }
  }
  
  public RealTimeSocket s(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (!ParticipantUtils.bY(paramString2))) {
      throw new IllegalArgumentException("Bad participant ID");
    }
    RealTimeSocket localRealTimeSocket = (RealTimeSocket)this.Ym.get(paramString2);
    if ((localRealTimeSocket == null) || (localRealTimeSocket.isClosed())) {
      localRealTimeSocket = bB(paramString2);
    }
    return localRealTimeSocket;
  }
  
  private static abstract class AbstractPeerStatusNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    private final ArrayList<String> Yv = new ArrayList();
    
    AbstractPeerStatusNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super();
      int i = 0;
      int j = paramArrayOfString.length;
      while (i < j)
      {
        this.Yv.add(paramArrayOfString[i]);
        i++;
      }
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      a(paramRoomStatusUpdateListener, paramRoom, this.Yv);
    }
    
    protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList);
  }
  
  private static abstract class AbstractRoomNotifier
    extends com.google.android.gms.common.api.a<RoomUpdateListener>
  {
    AbstractRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    protected void a(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      a(paramRoomUpdateListener, GamesClientImpl.S(paramDataHolder), paramDataHolder.getStatusCode());
    }
    
    protected abstract void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt);
  }
  
  private static abstract class AbstractRoomStatusNotifier
    extends com.google.android.gms.common.api.a<RoomStatusUpdateListener>
  {
    AbstractRoomStatusNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      a(paramRoomStatusUpdateListener, GamesClientImpl.S(paramDataHolder));
    }
    
    protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom);
  }
  
  private static final class AcceptQuestResultImpl
    extends b
    implements Quests.AcceptQuestResult
  {
    private final Quest Yw;
    
    /* Error */
    AcceptQuestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 12	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 14	com/google/android/gms/games/quest/QuestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 15	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 19	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   18: ifle +27 -> 45
      //   21: aload_0
      //   22: new 21	com/google/android/gms/games/quest/QuestEntity
      //   25: dup
      //   26: aload_2
      //   27: iconst_0
      //   28: invokevirtual 25	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   31: checkcast 27	com/google/android/gms/games/quest/Quest
      //   34: invokespecial 30	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   37: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:Yw	Lcom/google/android/gms/games/quest/Quest;
      //   40: aload_2
      //   41: invokevirtual 36	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   44: return
      //   45: aload_0
      //   46: aconst_null
      //   47: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:Yw	Lcom/google/android/gms/games/quest/Quest;
      //   50: goto -10 -> 40
      //   53: astore_3
      //   54: aload_2
      //   55: invokevirtual 36	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   58: aload_3
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	AcceptQuestResultImpl
      //   0	60	1	paramDataHolder	DataHolder
      //   13	42	2	localQuestBuffer	QuestBuffer
      //   53	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	40	53	finally
      //   45	50	53	finally
    }
    
    public Quest getQuest()
    {
      return this.Yw;
    }
  }
  
  private static final class AchievementUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Achievements.UpdateAchievementResult> Ea;
    
    AchievementUpdatedBinderCallback(BaseImplementation.b<Achievements.UpdateAchievementResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void g(int paramInt, String paramString)
    {
      this.Ea.b(new GamesClientImpl.UpdateAchievementResultImpl(paramInt, paramString));
    }
  }
  
  private static final class AchievementsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Achievements.LoadAchievementsResult> Ea;
    
    AchievementsLoadedBinderCallback(BaseImplementation.b<Achievements.LoadAchievementsResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void c(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadAchievementsResultImpl(paramDataHolder));
    }
  }
  
  private static final class AppContentLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<AppContents.LoadAppContentResult> Yx;
    
    public AppContentLoadedBinderCallbacks(BaseImplementation.b<AppContents.LoadAppContentResult> paramb)
    {
      this.Yx = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void a(DataHolder[] paramArrayOfDataHolder)
    {
      this.Yx.b(new GamesClientImpl.LoadAppContentsResultImpl(paramArrayOfDataHolder));
    }
  }
  
  private static final class CancelMatchResultImpl
    implements TurnBasedMultiplayer.CancelMatchResult
  {
    private final Status Eb;
    private final String Yy;
    
    CancelMatchResultImpl(Status paramStatus, String paramString)
    {
      this.Eb = paramStatus;
      this.Yy = paramString;
    }
    
    public String getMatchId()
    {
      return this.Yy;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  private static final class ClaimMilestoneResultImpl
    extends b
    implements Quests.ClaimMilestoneResult
  {
    private final Quest Yw;
    private final Milestone Yz;
    
    /* Error */
    ClaimMilestoneResultImpl(DataHolder paramDataHolder, String paramString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: aload_1
      //   4: invokespecial 15	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   7: new 17	com/google/android/gms/games/quest/QuestBuffer
      //   10: dup
      //   11: aload_1
      //   12: invokespecial 18	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   15: astore 4
      //   17: aload 4
      //   19: invokevirtual 22	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   22: ifle +110 -> 132
      //   25: aload_0
      //   26: new 24	com/google/android/gms/games/quest/QuestEntity
      //   29: dup
      //   30: aload 4
      //   32: iconst_0
      //   33: invokevirtual 28	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   36: checkcast 30	com/google/android/gms/games/quest/Quest
      //   39: invokespecial 33	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   42: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Yw	Lcom/google/android/gms/games/quest/Quest;
      //   45: aload_0
      //   46: getfield 35	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Yw	Lcom/google/android/gms/games/quest/Quest;
      //   49: invokeinterface 39 1 0
      //   54: astore 6
      //   56: aload 6
      //   58: invokeinterface 44 1 0
      //   63: istore 7
      //   65: iload_3
      //   66: iload 7
      //   68: if_icmpge +53 -> 121
      //   71: aload 6
      //   73: iload_3
      //   74: invokeinterface 45 2 0
      //   79: checkcast 47	com/google/android/gms/games/quest/Milestone
      //   82: invokeinterface 51 1 0
      //   87: aload_2
      //   88: invokevirtual 57	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   91: ifeq +24 -> 115
      //   94: aload_0
      //   95: aload 6
      //   97: iload_3
      //   98: invokeinterface 45 2 0
      //   103: checkcast 47	com/google/android/gms/games/quest/Milestone
      //   106: putfield 59	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Yz	Lcom/google/android/gms/games/quest/Milestone;
      //   109: aload 4
      //   111: invokevirtual 63	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   114: return
      //   115: iinc 3 1
      //   118: goto -53 -> 65
      //   121: aload_0
      //   122: aconst_null
      //   123: putfield 59	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Yz	Lcom/google/android/gms/games/quest/Milestone;
      //   126: aload 4
      //   128: invokevirtual 63	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   131: return
      //   132: aload_0
      //   133: aconst_null
      //   134: putfield 59	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Yz	Lcom/google/android/gms/games/quest/Milestone;
      //   137: aload_0
      //   138: aconst_null
      //   139: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Yw	Lcom/google/android/gms/games/quest/Quest;
      //   142: goto -16 -> 126
      //   145: astore 5
      //   147: aload 4
      //   149: invokevirtual 63	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   152: aload 5
      //   154: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	155	0	this	ClaimMilestoneResultImpl
      //   0	155	1	paramDataHolder	DataHolder
      //   0	155	2	paramString	String
      //   1	115	3	i	int
      //   15	133	4	localQuestBuffer	QuestBuffer
      //   145	8	5	localObject	Object
      //   54	42	6	localList	List
      //   63	6	7	j	int
      // Exception table:
      //   from	to	target	type
      //   17	65	145	finally
      //   71	109	145	finally
      //   121	126	145	finally
      //   132	142	145	finally
    }
    
    public Milestone getMilestone()
    {
      return this.Yz;
    }
    
    public Quest getQuest()
    {
      return this.Yw;
    }
  }
  
  private static final class CommitSnapshotResultImpl
    extends b
    implements Snapshots.CommitSnapshotResult
  {
    private final SnapshotMetadata YA;
    
    /* Error */
    CommitSnapshotResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 12	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 14	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 15	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 19	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:getCount	()I
      //   18: ifle +24 -> 42
      //   21: aload_0
      //   22: new 21	com/google/android/gms/games/snapshot/SnapshotMetadataEntity
      //   25: dup
      //   26: aload_2
      //   27: iconst_0
      //   28: invokevirtual 25	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:get	(I)Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   31: invokespecial 28	com/google/android/gms/games/snapshot/SnapshotMetadataEntity:<init>	(Lcom/google/android/gms/games/snapshot/SnapshotMetadata;)V
      //   34: putfield 30	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:YA	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   37: aload_2
      //   38: invokevirtual 34	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:release	()V
      //   41: return
      //   42: aload_0
      //   43: aconst_null
      //   44: putfield 30	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:YA	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   47: goto -10 -> 37
      //   50: astore_3
      //   51: aload_2
      //   52: invokevirtual 34	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:release	()V
      //   55: aload_3
      //   56: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	57	0	this	CommitSnapshotResultImpl
      //   0	57	1	paramDataHolder	DataHolder
      //   13	39	2	localSnapshotMetadataBuffer	SnapshotMetadataBuffer
      //   50	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	37	50	finally
      //   42	47	50	finally
    }
    
    public SnapshotMetadata getSnapshotMetadata()
    {
      return this.YA;
    }
  }
  
  private static final class ConnectedToRoomNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    ConnectedToRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onConnectedToRoom(paramRoom);
    }
  }
  
  private static final class ContactSettingLoadResultImpl
    extends b
    implements Notifications.ContactSettingLoadResult
  {
    ContactSettingLoadResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class ContactSettingsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Notifications.ContactSettingLoadResult> Ea;
    
    ContactSettingsLoadedBinderCallback(BaseImplementation.b<Notifications.ContactSettingLoadResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void D(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.ContactSettingLoadResultImpl(paramDataHolder));
    }
  }
  
  private static final class ContactSettingsUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Status> Ea;
    
    ContactSettingsUpdatedBinderCallback(BaseImplementation.b<Status> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void dP(int paramInt)
    {
      this.Ea.b(new Status(paramInt));
    }
  }
  
  private static final class DeleteSnapshotResultImpl
    implements Snapshots.DeleteSnapshotResult
  {
    private final Status Eb;
    private final String YB;
    
    DeleteSnapshotResultImpl(int paramInt, String paramString)
    {
      this.Eb = new Status(paramInt);
      this.YB = paramString;
    }
    
    public String getSnapshotId()
    {
      return this.YB;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  private static final class DisconnectedFromRoomNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    DisconnectedFromRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onDisconnectedFromRoom(paramRoom);
    }
  }
  
  private static final class EventsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Events.LoadEventsResult> Ea;
    
    EventsLoadedBinderCallback(BaseImplementation.b<Events.LoadEventsResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void d(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadEventResultImpl(paramDataHolder));
    }
  }
  
  private static final class ExtendedGamesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> Ea;
    
    ExtendedGamesLoadedBinderCallback(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void j(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadExtendedGamesResultImpl(paramDataHolder));
    }
  }
  
  private class GameClientEventIncrementCache
    extends EventIncrementCache
  {
    public GameClientEventIncrementCache()
    {
      super(1000);
    }
    
    protected void r(String paramString, int paramInt)
    {
      try
      {
        if (GamesClientImpl.this.isConnected())
        {
          ((IGamesService)GamesClientImpl.this.hw()).o(paramString, paramInt);
          return;
        }
        GamesLog.p("GamesClientImpl", "Unable to increment event " + paramString + " by " + paramInt + " because the games client is no longer connected");
        return;
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.o("GamesClientImpl", "service died");
      }
    }
  }
  
  private static final class GameInstancesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<GamesMetadata.LoadGameInstancesResult> Ea;
    
    GameInstancesLoadedBinderCallback(BaseImplementation.b<GamesMetadata.LoadGameInstancesResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void k(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadGameInstancesResultImpl(paramDataHolder));
    }
  }
  
  private static final class GameMuteStatusChangeResultImpl
    implements Notifications.GameMuteStatusChangeResult
  {
    private final Status Eb;
    private final String YC;
    private final boolean YD;
    
    public GameMuteStatusChangeResultImpl(int paramInt, String paramString, boolean paramBoolean)
    {
      this.Eb = new Status(paramInt);
      this.YC = paramString;
      this.YD = paramBoolean;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  private static final class GameMuteStatusChangedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Notifications.GameMuteStatusChangeResult> Ea;
    
    GameMuteStatusChangedBinderCallback(BaseImplementation.b<Notifications.GameMuteStatusChangeResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void a(int paramInt, String paramString, boolean paramBoolean)
    {
      this.Ea.b(new GamesClientImpl.GameMuteStatusChangeResultImpl(paramInt, paramString, paramBoolean));
    }
  }
  
  private static final class GameMuteStatusLoadResultImpl
    implements Notifications.GameMuteStatusLoadResult
  {
    private final Status Eb;
    private final String YC;
    private final boolean YD;
    
    /* Error */
    public GameMuteStatusLoadResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 17	java/lang/Object:<init>	()V
      //   4: aload_0
      //   5: new 19	com/google/android/gms/common/api/Status
      //   8: dup
      //   9: aload_1
      //   10: invokevirtual 25	com/google/android/gms/common/data/DataHolder:getStatusCode	()I
      //   13: invokespecial 28	com/google/android/gms/common/api/Status:<init>	(I)V
      //   16: putfield 30	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:Eb	Lcom/google/android/gms/common/api/Status;
      //   19: aload_1
      //   20: invokevirtual 33	com/google/android/gms/common/data/DataHolder:getCount	()I
      //   23: ifle +32 -> 55
      //   26: aload_0
      //   27: aload_1
      //   28: ldc 35
      //   30: iconst_0
      //   31: iconst_0
      //   32: invokevirtual 39	com/google/android/gms/common/data/DataHolder:c	(Ljava/lang/String;II)Ljava/lang/String;
      //   35: putfield 41	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:YC	Ljava/lang/String;
      //   38: aload_0
      //   39: aload_1
      //   40: ldc 43
      //   42: iconst_0
      //   43: iconst_0
      //   44: invokevirtual 47	com/google/android/gms/common/data/DataHolder:d	(Ljava/lang/String;II)Z
      //   47: putfield 49	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:YD	Z
      //   50: aload_1
      //   51: invokevirtual 52	com/google/android/gms/common/data/DataHolder:close	()V
      //   54: return
      //   55: aload_0
      //   56: aconst_null
      //   57: putfield 41	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:YC	Ljava/lang/String;
      //   60: aload_0
      //   61: iconst_0
      //   62: putfield 49	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:YD	Z
      //   65: goto -15 -> 50
      //   68: astore_2
      //   69: aload_1
      //   70: invokevirtual 52	com/google/android/gms/common/data/DataHolder:close	()V
      //   73: aload_2
      //   74: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	GameMuteStatusLoadResultImpl
      //   0	75	1	paramDataHolder	DataHolder
      //   68	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	50	68	finally
      //   55	65	68	finally
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  private static final class GameMuteStatusLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Notifications.GameMuteStatusLoadResult> Ea;
    
    GameMuteStatusLoadedBinderCallback(BaseImplementation.b<Notifications.GameMuteStatusLoadResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void B(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.GameMuteStatusLoadResultImpl(paramDataHolder));
    }
  }
  
  private static final class GameSearchSuggestionsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<GamesMetadata.LoadGameSearchSuggestionsResult> Ea;
    
    GameSearchSuggestionsLoadedBinderCallback(BaseImplementation.b<GamesMetadata.LoadGameSearchSuggestionsResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void l(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadGameSearchSuggestionsResultImpl(paramDataHolder));
    }
  }
  
  private static final class GamesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<GamesMetadata.LoadGamesResult> Ea;
    
    GamesLoadedBinderCallback(BaseImplementation.b<GamesMetadata.LoadGamesResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void i(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadGamesResultImpl(paramDataHolder));
    }
  }
  
  private static final class InboxCountResultImpl
    implements Notifications.InboxCountResult
  {
    private final Status Eb;
    private final Bundle YE;
    
    InboxCountResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.Eb = paramStatus;
      this.YE = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  private static final class InboxCountsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Notifications.InboxCountResult> Ea;
    
    InboxCountsLoadedBinderCallback(BaseImplementation.b<Notifications.InboxCountResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void f(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.Ea.b(new GamesClientImpl.InboxCountResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class InitiateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.InitiateMatchResult
  {
    InitiateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class InvitationReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final d<OnInvitationReceivedListener> Qe;
    
    InvitationReceivedBinderCallback(d<OnInvitationReceivedListener> paramd)
    {
      this.Qe = paramd;
    }
    
    public void n(DataHolder paramDataHolder)
    {
      InvitationBuffer localInvitationBuffer = new InvitationBuffer(paramDataHolder);
      try
      {
        int i = localInvitationBuffer.getCount();
        Invitation localInvitation = null;
        if (i > 0) {
          localInvitation = (Invitation)((Invitation)localInvitationBuffer.get(0)).freeze();
        }
        localInvitationBuffer.release();
        if (localInvitation != null) {
          this.Qe.a(new GamesClientImpl.InvitationReceivedNotifier(localInvitation));
        }
        return;
      }
      finally
      {
        localInvitationBuffer.release();
      }
    }
    
    public void onInvitationRemoved(String paramString)
    {
      this.Qe.a(new GamesClientImpl.InvitationRemovedNotifier(paramString));
    }
  }
  
  private static final class InvitationReceivedNotifier
    implements d.b<OnInvitationReceivedListener>
  {
    private final Invitation YF;
    
    InvitationReceivedNotifier(Invitation paramInvitation)
    {
      this.YF = paramInvitation;
    }
    
    public void a(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationReceived(this.YF);
    }
    
    public void gG() {}
  }
  
  private static final class InvitationRemovedNotifier
    implements d.b<OnInvitationReceivedListener>
  {
    private final String YG;
    
    InvitationRemovedNotifier(String paramString)
    {
      this.YG = paramString;
    }
    
    public void a(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationRemoved(this.YG);
    }
    
    public void gG() {}
  }
  
  private static final class InvitationsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Invitations.LoadInvitationsResult> Ea;
    
    InvitationsLoadedBinderCallback(BaseImplementation.b<Invitations.LoadInvitationsResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void m(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadInvitationsResultImpl(paramDataHolder));
    }
  }
  
  private static final class JoinedRoomNotifier
    extends GamesClientImpl.AbstractRoomNotifier
  {
    public JoinedRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onJoinedRoom(paramInt, paramRoom);
    }
  }
  
  private static final class LeaderboardMetadataResultImpl
    extends b
    implements Leaderboards.LeaderboardMetadataResult
  {
    private final LeaderboardBuffer YH;
    
    LeaderboardMetadataResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.YH = new LeaderboardBuffer(paramDataHolder);
    }
    
    public LeaderboardBuffer getLeaderboards()
    {
      return this.YH;
    }
  }
  
  private static final class LeaderboardScoresLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Leaderboards.LoadScoresResult> Ea;
    
    LeaderboardScoresLoadedBinderCallback(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      this.Ea.b(new GamesClientImpl.LoadScoresResultImpl(paramDataHolder1, paramDataHolder2));
    }
  }
  
  private static final class LeaderboardsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> Ea;
    
    LeaderboardsLoadedBinderCallback(BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void e(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LeaderboardMetadataResultImpl(paramDataHolder));
    }
  }
  
  private static final class LeaveMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LeaveMatchResult
  {
    LeaveMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LeftRoomNotifier
    implements d.b<RoomUpdateListener>
  {
    private final int Iv;
    private final String YI;
    
    LeftRoomNotifier(int paramInt, String paramString)
    {
      this.Iv = paramInt;
      this.YI = paramString;
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener)
    {
      paramRoomUpdateListener.onLeftRoom(this.Iv, this.YI);
    }
    
    public void gG() {}
  }
  
  private static final class LoadAchievementsResultImpl
    extends b
    implements Achievements.LoadAchievementsResult
  {
    private final AchievementBuffer YJ;
    
    LoadAchievementsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.YJ = new AchievementBuffer(paramDataHolder);
    }
    
    public AchievementBuffer getAchievements()
    {
      return this.YJ;
    }
  }
  
  private static final class LoadAclResultImpl
    extends b
    implements Acls.LoadAclResult
  {
    LoadAclResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadAppContentsResultImpl
    extends b
    implements AppContents.LoadAppContentResult
  {
    private final ArrayList<DataHolder> YK;
    
    LoadAppContentsResultImpl(DataHolder[] paramArrayOfDataHolder)
    {
      super();
      this.YK = new ArrayList(Arrays.asList(paramArrayOfDataHolder));
    }
  }
  
  private static final class LoadEventResultImpl
    extends b
    implements Events.LoadEventsResult
  {
    private final EventBuffer YL;
    
    LoadEventResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.YL = new EventBuffer(paramDataHolder);
    }
    
    public EventBuffer getEvents()
    {
      return this.YL;
    }
  }
  
  private static final class LoadExtendedGamesResultImpl
    extends b
    implements GamesMetadata.LoadExtendedGamesResult
  {
    private final ExtendedGameBuffer YM;
    
    LoadExtendedGamesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.YM = new ExtendedGameBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGameInstancesResultImpl
    extends b
    implements GamesMetadata.LoadGameInstancesResult
  {
    private final GameInstanceBuffer YN;
    
    LoadGameInstancesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.YN = new GameInstanceBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGameSearchSuggestionsResultImpl
    extends b
    implements GamesMetadata.LoadGameSearchSuggestionsResult
  {
    private final GameSearchSuggestionBuffer YO;
    
    LoadGameSearchSuggestionsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.YO = new GameSearchSuggestionBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGamesResultImpl
    extends b
    implements GamesMetadata.LoadGamesResult
  {
    private final GameBuffer YP;
    
    LoadGamesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.YP = new GameBuffer(paramDataHolder);
    }
    
    public GameBuffer getGames()
    {
      return this.YP;
    }
  }
  
  private static final class LoadInvitationsResultImpl
    extends b
    implements Invitations.LoadInvitationsResult
  {
    private final InvitationBuffer YQ;
    
    LoadInvitationsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.YQ = new InvitationBuffer(paramDataHolder);
    }
    
    public InvitationBuffer getInvitations()
    {
      return this.YQ;
    }
  }
  
  private static final class LoadMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LoadMatchResult
  {
    LoadMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadMatchesResultImpl
    implements TurnBasedMultiplayer.LoadMatchesResult
  {
    private final Status Eb;
    private final LoadMatchesResponse YR;
    
    LoadMatchesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.Eb = paramStatus;
      this.YR = new LoadMatchesResponse(paramBundle);
    }
    
    public LoadMatchesResponse getMatches()
    {
      return this.YR;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
    
    public void release()
    {
      this.YR.release();
    }
  }
  
  private static final class LoadOwnerCoverPhotoUrisResultImpl
    implements Players.LoadOwnerCoverPhotoUrisResult
  {
    private final Bundle DJ;
    private final Status Eb;
    
    LoadOwnerCoverPhotoUrisResultImpl(int paramInt, Bundle paramBundle)
    {
      this.Eb = new Status(paramInt);
      this.DJ = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  private static final class LoadPlayerScoreResultImpl
    extends b
    implements Leaderboards.LoadPlayerScoreResult
  {
    private final LeaderboardScoreEntity YS;
    
    /* Error */
    LoadPlayerScoreResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 12	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 14	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 15	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 19	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:getCount	()I
      //   18: ifle +25 -> 43
      //   21: aload_0
      //   22: aload_2
      //   23: iconst_0
      //   24: invokevirtual 23	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:get	(I)Lcom/google/android/gms/games/leaderboard/LeaderboardScore;
      //   27: invokeinterface 29 1 0
      //   32: checkcast 31	com/google/android/gms/games/leaderboard/LeaderboardScoreEntity
      //   35: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:YS	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   38: aload_2
      //   39: invokevirtual 37	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:release	()V
      //   42: return
      //   43: aload_0
      //   44: aconst_null
      //   45: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:YS	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   48: goto -10 -> 38
      //   51: astore_3
      //   52: aload_2
      //   53: invokevirtual 37	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:release	()V
      //   56: aload_3
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	LoadPlayerScoreResultImpl
      //   0	58	1	paramDataHolder	DataHolder
      //   13	40	2	localLeaderboardScoreBuffer	LeaderboardScoreBuffer
      //   51	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	38	51	finally
      //   43	48	51	finally
    }
    
    public LeaderboardScore getScore()
    {
      return this.YS;
    }
  }
  
  private static final class LoadPlayersResultImpl
    extends b
    implements Players.LoadPlayersResult
  {
    private final PlayerBuffer YT;
    
    LoadPlayersResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.YT = new PlayerBuffer(paramDataHolder);
    }
    
    public PlayerBuffer getPlayers()
    {
      return this.YT;
    }
  }
  
  private static final class LoadProfileSettingsResultImpl
    extends b
    implements Players.LoadProfileSettingsResult
  {
    private final boolean YU;
    private final boolean Yh;
    
    /* Error */
    LoadProfileSettingsResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 13	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: aload_1
      //   6: invokevirtual 19	com/google/android/gms/common/data/DataHolder:getCount	()I
      //   9: ifle +38 -> 47
      //   12: aload_1
      //   13: iconst_0
      //   14: invokevirtual 23	com/google/android/gms/common/data/DataHolder:au	(I)I
      //   17: istore_3
      //   18: aload_0
      //   19: aload_1
      //   20: ldc 25
      //   22: iconst_0
      //   23: iload_3
      //   24: invokevirtual 29	com/google/android/gms/common/data/DataHolder:d	(Ljava/lang/String;II)Z
      //   27: putfield 31	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:Yh	Z
      //   30: aload_0
      //   31: aload_1
      //   32: ldc 33
      //   34: iconst_0
      //   35: iload_3
      //   36: invokevirtual 29	com/google/android/gms/common/data/DataHolder:d	(Ljava/lang/String;II)Z
      //   39: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:YU	Z
      //   42: aload_1
      //   43: invokevirtual 39	com/google/android/gms/common/data/DataHolder:close	()V
      //   46: return
      //   47: aload_0
      //   48: iconst_1
      //   49: putfield 31	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:Yh	Z
      //   52: aload_0
      //   53: iconst_0
      //   54: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:YU	Z
      //   57: goto -15 -> 42
      //   60: astore_2
      //   61: aload_1
      //   62: invokevirtual 39	com/google/android/gms/common/data/DataHolder:close	()V
      //   65: aload_2
      //   66: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	67	0	this	LoadProfileSettingsResultImpl
      //   0	67	1	paramDataHolder	DataHolder
      //   60	6	2	localObject	Object
      //   17	19	3	i	int
      // Exception table:
      //   from	to	target	type
      //   5	42	60	finally
      //   47	57	60	finally
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
    
    public boolean isProfileVisible()
    {
      return this.Yh;
    }
    
    public boolean isVisibilityExplicitlySet()
    {
      return this.YU;
    }
  }
  
  private static final class LoadQuestsResultImpl
    extends b
    implements Quests.LoadQuestsResult
  {
    private final DataHolder JG;
    
    LoadQuestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.JG = paramDataHolder;
    }
    
    public QuestBuffer getQuests()
    {
      return new QuestBuffer(this.JG);
    }
  }
  
  private static final class LoadRequestSummariesResultImpl
    extends b
    implements Requests.LoadRequestSummariesResult
  {
    LoadRequestSummariesResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadRequestsResultImpl
    implements Requests.LoadRequestsResult
  {
    private final Status Eb;
    private final Bundle YV;
    
    LoadRequestsResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.Eb = paramStatus;
      this.YV = paramBundle;
    }
    
    public GameRequestBuffer getRequests(int paramInt)
    {
      String str = RequestType.dZ(paramInt);
      if (!this.YV.containsKey(str)) {
        return null;
      }
      return new GameRequestBuffer((DataHolder)this.YV.get(str));
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
    
    public void release()
    {
      Iterator localIterator = this.YV.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        DataHolder localDataHolder = (DataHolder)this.YV.getParcelable(str);
        if (localDataHolder != null) {
          localDataHolder.close();
        }
      }
    }
  }
  
  private static final class LoadScoresResultImpl
    extends b
    implements Leaderboards.LoadScoresResult
  {
    private final LeaderboardEntity YW;
    private final LeaderboardScoreBuffer YX;
    
    /* Error */
    LoadScoresResultImpl(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_2
      //   2: invokespecial 15	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/leaderboard/LeaderboardBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/leaderboard/LeaderboardBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_3
      //   14: aload_3
      //   15: invokevirtual 22	com/google/android/gms/games/leaderboard/LeaderboardBuffer:getCount	()I
      //   18: ifle +40 -> 58
      //   21: aload_0
      //   22: aload_3
      //   23: iconst_0
      //   24: invokevirtual 26	com/google/android/gms/games/leaderboard/LeaderboardBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 28	com/google/android/gms/games/leaderboard/Leaderboard
      //   30: invokeinterface 32 1 0
      //   35: checkcast 34	com/google/android/gms/games/leaderboard/LeaderboardEntity
      //   38: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:YW	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   41: aload_3
      //   42: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardBuffer:release	()V
      //   45: aload_0
      //   46: new 42	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   49: dup
      //   50: aload_2
      //   51: invokespecial 43	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   54: putfield 45	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:YX	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;
      //   57: return
      //   58: aload_0
      //   59: aconst_null
      //   60: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:YW	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   63: goto -22 -> 41
      //   66: astore 4
      //   68: aload_3
      //   69: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardBuffer:release	()V
      //   72: aload 4
      //   74: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	LoadScoresResultImpl
      //   0	75	1	paramDataHolder1	DataHolder
      //   0	75	2	paramDataHolder2	DataHolder
      //   13	56	3	localLeaderboardBuffer	LeaderboardBuffer
      //   66	7	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	66	finally
      //   58	63	66	finally
    }
    
    public Leaderboard getLeaderboard()
    {
      return this.YW;
    }
    
    public LeaderboardScoreBuffer getScores()
    {
      return this.YX;
    }
  }
  
  private static final class LoadSnapshotsResultImpl
    extends b
    implements Snapshots.LoadSnapshotsResult
  {
    LoadSnapshotsResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
    
    public SnapshotMetadataBuffer getSnapshots()
    {
      return new SnapshotMetadataBuffer(this.JG);
    }
  }
  
  private static final class LoadXpForGameCategoriesResultImpl
    implements Players.LoadXpForGameCategoriesResult
  {
    private final Status Eb;
    private final List<String> YY;
    private final Bundle YZ;
    
    LoadXpForGameCategoriesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.Eb = paramStatus;
      this.YY = paramBundle.getStringArrayList("game_category_list");
      this.YZ = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  private static final class LoadXpStreamResultImpl
    extends b
    implements Players.LoadXpStreamResult
  {
    private final ExperienceEventBuffer Za;
    
    LoadXpStreamResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.Za = new ExperienceEventBuffer(paramDataHolder);
    }
  }
  
  private static final class MatchRemovedNotifier
    implements d.b<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final String Zb;
    
    MatchRemovedNotifier(String paramString)
    {
      this.Zb = paramString;
    }
    
    public void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Zb);
    }
    
    public void gG() {}
  }
  
  private static final class MatchUpdateReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final d<OnTurnBasedMatchUpdateReceivedListener> Qe;
    
    MatchUpdateReceivedBinderCallback(d<OnTurnBasedMatchUpdateReceivedListener> paramd)
    {
      this.Qe = paramd;
    }
    
    public void onTurnBasedMatchRemoved(String paramString)
    {
      this.Qe.a(new GamesClientImpl.MatchRemovedNotifier(paramString));
    }
    
    public void t(DataHolder paramDataHolder)
    {
      TurnBasedMatchBuffer localTurnBasedMatchBuffer = new TurnBasedMatchBuffer(paramDataHolder);
      try
      {
        int i = localTurnBasedMatchBuffer.getCount();
        TurnBasedMatch localTurnBasedMatch = null;
        if (i > 0) {
          localTurnBasedMatch = (TurnBasedMatch)((TurnBasedMatch)localTurnBasedMatchBuffer.get(0)).freeze();
        }
        localTurnBasedMatchBuffer.release();
        if (localTurnBasedMatch != null) {
          this.Qe.a(new GamesClientImpl.MatchUpdateReceivedNotifier(localTurnBasedMatch));
        }
        return;
      }
      finally
      {
        localTurnBasedMatchBuffer.release();
      }
    }
  }
  
  private static final class MatchUpdateReceivedNotifier
    implements d.b<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final TurnBasedMatch Zc;
    
    MatchUpdateReceivedNotifier(TurnBasedMatch paramTurnBasedMatch)
    {
      this.Zc = paramTurnBasedMatch;
    }
    
    public void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Zc);
    }
    
    public void gG() {}
  }
  
  private static final class MessageReceivedNotifier
    implements d.b<RealTimeMessageReceivedListener>
  {
    private final RealTimeMessage Zd;
    
    MessageReceivedNotifier(RealTimeMessage paramRealTimeMessage)
    {
      this.Zd = paramRealTimeMessage;
    }
    
    public void a(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      paramRealTimeMessageReceivedListener.onRealTimeMessageReceived(this.Zd);
    }
    
    public void gG() {}
  }
  
  private static final class NearbyPlayerDetectedNotifier
    implements d.b<OnNearbyPlayerDetectedListener>
  {
    private final Player Ze;
    
    public void a(OnNearbyPlayerDetectedListener paramOnNearbyPlayerDetectedListener)
    {
      paramOnNearbyPlayerDetectedListener.a(this.Ze);
    }
    
    public void gG() {}
  }
  
  private static final class NotifyAclLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Acls.LoadAclResult> Ea;
    
    NotifyAclLoadedBinderCallback(BaseImplementation.b<Acls.LoadAclResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void C(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadAclResultImpl(paramDataHolder));
    }
  }
  
  private static final class NotifyAclUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Status> Ea;
    
    NotifyAclUpdatedBinderCallback(BaseImplementation.b<Status> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void dO(int paramInt)
    {
      this.Ea.b(new Status(paramInt));
    }
  }
  
  private static final class OpenSnapshotResultImpl
    extends b
    implements Snapshots.OpenSnapshotResult
  {
    private final Snapshot Zf;
    private final String Zg;
    private final Snapshot Zh;
    private final Contents Zi;
    private final SnapshotContents Zj;
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, Contents paramContents)
    {
      this(paramDataHolder, null, paramContents, null, null);
    }
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      super();
      SnapshotMetadataBuffer localSnapshotMetadataBuffer = new SnapshotMetadataBuffer(paramDataHolder);
      for (;;)
      {
        try
        {
          if (localSnapshotMetadataBuffer.getCount() == 0)
          {
            this.Zf = null;
            this.Zh = null;
            localSnapshotMetadataBuffer.release();
            this.Zg = paramString;
            this.Zi = paramContents3;
            this.Zj = new SnapshotContentsEntity(paramContents3);
            return;
          }
          if (localSnapshotMetadataBuffer.getCount() != i) {
            break label147;
          }
          if (paramDataHolder.getStatusCode() != 4004)
          {
            je.K(i);
            this.Zf = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(paramContents1));
            this.Zh = null;
            continue;
          }
          int j = 0;
        }
        finally
        {
          localSnapshotMetadataBuffer.release();
        }
        continue;
        label147:
        this.Zf = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(paramContents1));
        this.Zh = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(paramContents2));
      }
    }
    
    public String getConflictId()
    {
      return this.Zg;
    }
    
    public Snapshot getConflictingSnapshot()
    {
      return this.Zh;
    }
    
    public SnapshotContents getResolutionSnapshotContents()
    {
      return this.Zj;
    }
    
    public Snapshot getSnapshot()
    {
      return this.Zf;
    }
  }
  
  private static final class OwnerCoverPhotoUrisLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadOwnerCoverPhotoUrisResult> Ea;
    
    OwnerCoverPhotoUrisLoadedBinderCallback(BaseImplementation.b<Players.LoadOwnerCoverPhotoUrisResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void d(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.Ea.b(new GamesClientImpl.LoadOwnerCoverPhotoUrisResultImpl(paramInt, paramBundle));
    }
  }
  
  private static final class P2PConnectedNotifier
    implements d.b<RoomStatusUpdateListener>
  {
    private final String Zk;
    
    P2PConnectedNotifier(String paramString)
    {
      this.Zk = paramString;
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      paramRoomStatusUpdateListener.onP2PConnected(this.Zk);
    }
    
    public void gG() {}
  }
  
  private static final class P2PDisconnectedNotifier
    implements d.b<RoomStatusUpdateListener>
  {
    private final String Zk;
    
    P2PDisconnectedNotifier(String paramString)
    {
      this.Zk = paramString;
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      paramRoomStatusUpdateListener.onP2PDisconnected(this.Zk);
    }
    
    public void gG() {}
  }
  
  private static final class PeerConnectedNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerConnectedNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersConnected(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerDeclinedNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerDeclinedNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerDeclined(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerDisconnectedNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerDisconnectedNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersDisconnected(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerInvitedToRoomNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerInvitedToRoomNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerInvitedToRoom(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerJoinedRoomNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerJoinedRoomNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerJoined(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerLeftRoomNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerLeftRoomNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerLeft(paramRoom, paramArrayList);
    }
  }
  
  private static final class PlayerLeaderboardScoreLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Leaderboards.LoadPlayerScoreResult> Ea;
    
    PlayerLeaderboardScoreLoadedBinderCallback(BaseImplementation.b<Leaderboards.LoadPlayerScoreResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void E(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadPlayerScoreResultImpl(paramDataHolder));
    }
  }
  
  private static final class PlayerXpForGameCategoriesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadXpForGameCategoriesResult> Ea;
    
    PlayerXpForGameCategoriesLoadedBinderCallback(BaseImplementation.b<Players.LoadXpForGameCategoriesResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void e(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.Ea.b(new GamesClientImpl.LoadXpForGameCategoriesResultImpl(localStatus, paramBundle));
    }
  }
  
  static final class PlayerXpStreamLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadXpStreamResult> Ea;
    
    PlayerXpStreamLoadedBinderCallback(BaseImplementation.b<Players.LoadXpStreamResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void P(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadXpStreamResultImpl(paramDataHolder));
    }
  }
  
  private static final class PlayersLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadPlayersResult> Ea;
    
    PlayersLoadedBinderCallback(BaseImplementation.b<Players.LoadPlayersResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void g(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
    
    public void h(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
  }
  
  static final class ProfileSettingsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadProfileSettingsResult> Ea;
    
    ProfileSettingsLoadedBinderCallback(BaseImplementation.b<Players.LoadProfileSettingsResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void Q(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.LoadProfileSettingsResultImpl(paramDataHolder));
    }
  }
  
  private static final class ProfileSettingsUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Status> Ea;
    
    ProfileSettingsUpdatedBinderCallback(BaseImplementation.b<Status> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void dQ(int paramInt)
    {
      this.Ea.b(new Status(paramInt));
    }
  }
  
  private static final class QuestAcceptedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Quests.AcceptQuestResult> Zl;
    
    public QuestAcceptedBinderCallbacks(BaseImplementation.b<Quests.AcceptQuestResult> paramb)
    {
      this.Zl = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void L(DataHolder paramDataHolder)
    {
      this.Zl.b(new GamesClientImpl.AcceptQuestResultImpl(paramDataHolder));
    }
  }
  
  private static final class QuestCompletedNotifier
    implements d.b<QuestUpdateListener>
  {
    private final Quest Yw;
    
    QuestCompletedNotifier(Quest paramQuest)
    {
      this.Yw = paramQuest;
    }
    
    public void a(QuestUpdateListener paramQuestUpdateListener)
    {
      paramQuestUpdateListener.onQuestCompleted(this.Yw);
    }
    
    public void gG() {}
  }
  
  private static final class QuestMilestoneClaimBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Quests.ClaimMilestoneResult> Zm;
    private final String Zn;
    
    public QuestMilestoneClaimBinderCallbacks(BaseImplementation.b<Quests.ClaimMilestoneResult> paramb, String paramString)
    {
      this.Zm = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
      this.Zn = ((String)jx.b(paramString, "MilestoneId must not be null"));
    }
    
    public void K(DataHolder paramDataHolder)
    {
      this.Zm.b(new GamesClientImpl.ClaimMilestoneResultImpl(paramDataHolder, this.Zn));
    }
  }
  
  private static final class QuestUpdateBinderCallback
    extends AbstractGamesCallbacks
  {
    private final d<QuestUpdateListener> Qe;
    
    QuestUpdateBinderCallback(d<QuestUpdateListener> paramd)
    {
      this.Qe = paramd;
    }
    
    private Quest T(DataHolder paramDataHolder)
    {
      QuestBuffer localQuestBuffer = new QuestBuffer(paramDataHolder);
      try
      {
        int i = localQuestBuffer.getCount();
        Quest localQuest = null;
        if (i > 0) {
          localQuest = (Quest)((Quest)localQuestBuffer.get(0)).freeze();
        }
        return localQuest;
      }
      finally
      {
        localQuestBuffer.release();
      }
    }
    
    public void M(DataHolder paramDataHolder)
    {
      Quest localQuest = T(paramDataHolder);
      if (localQuest != null) {
        this.Qe.a(new GamesClientImpl.QuestCompletedNotifier(localQuest));
      }
    }
  }
  
  private static final class QuestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Quests.LoadQuestsResult> Zo;
    
    public QuestsLoadedBinderCallbacks(BaseImplementation.b<Quests.LoadQuestsResult> paramb)
    {
      this.Zo = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void O(DataHolder paramDataHolder)
    {
      this.Zo.b(new GamesClientImpl.LoadQuestsResultImpl(paramDataHolder));
    }
  }
  
  private static final class RealTimeMessageSentNotifier
    implements d.b<RealTimeMultiplayer.ReliableMessageSentCallback>
  {
    private final int Iv;
    private final String Zp;
    private final int Zq;
    
    RealTimeMessageSentNotifier(int paramInt1, int paramInt2, String paramString)
    {
      this.Iv = paramInt1;
      this.Zq = paramInt2;
      this.Zp = paramString;
    }
    
    public void a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
    {
      if (paramReliableMessageSentCallback != null) {
        paramReliableMessageSentCallback.onRealTimeMessageSent(this.Iv, this.Zq, this.Zp);
      }
    }
    
    public void gG() {}
  }
  
  private static final class RealTimeReliableMessageBinderCallbacks
    extends AbstractGamesCallbacks
  {
    final d<RealTimeMultiplayer.ReliableMessageSentCallback> Zr;
    
    public RealTimeReliableMessageBinderCallbacks(d<RealTimeMultiplayer.ReliableMessageSentCallback> paramd)
    {
      this.Zr = paramd;
    }
    
    public void b(int paramInt1, int paramInt2, String paramString)
    {
      if (this.Zr != null) {
        this.Zr.a(new GamesClientImpl.RealTimeMessageSentNotifier(paramInt1, paramInt2, paramString));
      }
    }
  }
  
  private static final class RequestReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final d<OnRequestReceivedListener> Qe;
    
    RequestReceivedBinderCallback(d<OnRequestReceivedListener> paramd)
    {
      this.Qe = paramd;
    }
    
    public void o(DataHolder paramDataHolder)
    {
      GameRequestBuffer localGameRequestBuffer = new GameRequestBuffer(paramDataHolder);
      try
      {
        int i = localGameRequestBuffer.getCount();
        GameRequest localGameRequest = null;
        if (i > 0) {
          localGameRequest = (GameRequest)((GameRequest)localGameRequestBuffer.get(0)).freeze();
        }
        localGameRequestBuffer.release();
        if (localGameRequest != null) {
          this.Qe.a(new GamesClientImpl.RequestReceivedNotifier(localGameRequest));
        }
        return;
      }
      finally
      {
        localGameRequestBuffer.release();
      }
    }
    
    public void onRequestRemoved(String paramString)
    {
      this.Qe.a(new GamesClientImpl.RequestRemovedNotifier(paramString));
    }
  }
  
  private static final class RequestReceivedNotifier
    implements d.b<OnRequestReceivedListener>
  {
    private final GameRequest Zs;
    
    RequestReceivedNotifier(GameRequest paramGameRequest)
    {
      this.Zs = paramGameRequest;
    }
    
    public void a(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestReceived(this.Zs);
    }
    
    public void gG() {}
  }
  
  private static final class RequestRemovedNotifier
    implements d.b<OnRequestReceivedListener>
  {
    private final String Zt;
    
    RequestRemovedNotifier(String paramString)
    {
      this.Zt = paramString;
    }
    
    public void a(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestRemoved(this.Zt);
    }
    
    public void gG() {}
  }
  
  private static final class RequestSentBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Requests.SendRequestResult> Zu;
    
    public RequestSentBinderCallbacks(BaseImplementation.b<Requests.SendRequestResult> paramb)
    {
      this.Zu = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void G(DataHolder paramDataHolder)
    {
      this.Zu.b(new GamesClientImpl.SendRequestResultImpl(paramDataHolder));
    }
  }
  
  private static final class RequestSummariesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Requests.LoadRequestSummariesResult> Zv;
    
    public RequestSummariesLoadedBinderCallbacks(BaseImplementation.b<Requests.LoadRequestSummariesResult> paramb)
    {
      this.Zv = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void H(DataHolder paramDataHolder)
    {
      this.Zv.b(new GamesClientImpl.LoadRequestSummariesResultImpl(paramDataHolder));
    }
  }
  
  private static final class RequestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Requests.LoadRequestsResult> Zw;
    
    public RequestsLoadedBinderCallbacks(BaseImplementation.b<Requests.LoadRequestsResult> paramb)
    {
      this.Zw = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void c(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.Zw.b(new GamesClientImpl.LoadRequestsResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class RequestsUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Requests.UpdateRequestsResult> Zx;
    
    public RequestsUpdatedBinderCallbacks(BaseImplementation.b<Requests.UpdateRequestsResult> paramb)
    {
      this.Zx = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void F(DataHolder paramDataHolder)
    {
      this.Zx.b(new GamesClientImpl.UpdateRequestsResultImpl(paramDataHolder));
    }
  }
  
  private static final class RoomAutoMatchingNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    RoomAutoMatchingNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomAutoMatching(paramRoom);
    }
  }
  
  private static final class RoomBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final d<RealTimeMessageReceivedListener> ZA;
    private final d<? extends RoomUpdateListener> Zy;
    private final d<? extends RoomStatusUpdateListener> Zz;
    
    public RoomBinderCallbacks(d<RoomUpdateListener> paramd)
    {
      this.Zy = ((d)jx.b(paramd, "Callbacks must not be null"));
      this.Zz = null;
      this.ZA = null;
    }
    
    public RoomBinderCallbacks(d<? extends RoomUpdateListener> paramd, d<? extends RoomStatusUpdateListener> paramd1, d<RealTimeMessageReceivedListener> paramd2)
    {
      this.Zy = ((d)jx.b(paramd, "Callbacks must not be null"));
      this.Zz = paramd1;
      this.ZA = paramd2;
    }
    
    public void A(DataHolder paramDataHolder)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.DisconnectedFromRoomNotifier(paramDataHolder));
      }
    }
    
    public void a(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.PeerInvitedToRoomNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void b(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.PeerJoinedRoomNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void c(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.PeerLeftRoomNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void d(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.PeerDeclinedNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void e(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.PeerConnectedNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void f(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.PeerDisconnectedNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void onLeftRoom(int paramInt, String paramString)
    {
      this.Zy.a(new GamesClientImpl.LeftRoomNotifier(paramInt, paramString));
    }
    
    public void onP2PConnected(String paramString)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.P2PConnectedNotifier(paramString));
      }
    }
    
    public void onP2PDisconnected(String paramString)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.P2PDisconnectedNotifier(paramString));
      }
    }
    
    public void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage)
    {
      if (this.ZA != null) {
        this.ZA.a(new GamesClientImpl.MessageReceivedNotifier(paramRealTimeMessage));
      }
    }
    
    public void u(DataHolder paramDataHolder)
    {
      this.Zy.a(new GamesClientImpl.RoomCreatedNotifier(paramDataHolder));
    }
    
    public void v(DataHolder paramDataHolder)
    {
      this.Zy.a(new GamesClientImpl.JoinedRoomNotifier(paramDataHolder));
    }
    
    public void w(DataHolder paramDataHolder)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.RoomConnectingNotifier(paramDataHolder));
      }
    }
    
    public void x(DataHolder paramDataHolder)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.RoomAutoMatchingNotifier(paramDataHolder));
      }
    }
    
    public void y(DataHolder paramDataHolder)
    {
      this.Zy.a(new GamesClientImpl.RoomConnectedNotifier(paramDataHolder));
    }
    
    public void z(DataHolder paramDataHolder)
    {
      if (this.Zz != null) {
        this.Zz.a(new GamesClientImpl.ConnectedToRoomNotifier(paramDataHolder));
      }
    }
  }
  
  private static final class RoomConnectedNotifier
    extends GamesClientImpl.AbstractRoomNotifier
  {
    RoomConnectedNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomConnected(paramInt, paramRoom);
    }
  }
  
  private static final class RoomConnectingNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    RoomConnectingNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomConnecting(paramRoom);
    }
  }
  
  private static final class RoomCreatedNotifier
    extends GamesClientImpl.AbstractRoomNotifier
  {
    public RoomCreatedNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomCreated(paramInt, paramRoom);
    }
  }
  
  private static final class SendRequestResultImpl
    extends b
    implements Requests.SendRequestResult
  {
    private final GameRequest Zs;
    
    /* Error */
    SendRequestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 12	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 14	com/google/android/gms/games/request/GameRequestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 15	com/google/android/gms/games/request/GameRequestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 19	com/google/android/gms/games/request/GameRequestBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_2
      //   23: iconst_0
      //   24: invokevirtual 23	com/google/android/gms/games/request/GameRequestBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 25	com/google/android/gms/games/request/GameRequest
      //   30: invokeinterface 29 1 0
      //   35: checkcast 25	com/google/android/gms/games/request/GameRequest
      //   38: putfield 31	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:Zs	Lcom/google/android/gms/games/request/GameRequest;
      //   41: aload_2
      //   42: invokevirtual 35	com/google/android/gms/games/request/GameRequestBuffer:release	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 31	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:Zs	Lcom/google/android/gms/games/request/GameRequest;
      //   51: goto -10 -> 41
      //   54: astore_3
      //   55: aload_2
      //   56: invokevirtual 35	com/google/android/gms/games/request/GameRequestBuffer:release	()V
      //   59: aload_3
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	SendRequestResultImpl
      //   0	61	1	paramDataHolder	DataHolder
      //   13	43	2	localGameRequestBuffer	GameRequestBuffer
      //   54	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
  }
  
  private static final class SignOutCompleteBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Status> Ea;
    
    public SignOutCompleteBinderCallbacks(BaseImplementation.b<Status> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void fK()
    {
      Status localStatus = new Status(0);
      this.Ea.b(localStatus);
    }
  }
  
  private static final class SnapshotCommittedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Snapshots.CommitSnapshotResult> ZB;
    
    public SnapshotCommittedBinderCallbacks(BaseImplementation.b<Snapshots.CommitSnapshotResult> paramb)
    {
      this.ZB = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void J(DataHolder paramDataHolder)
    {
      this.ZB.b(new GamesClientImpl.CommitSnapshotResultImpl(paramDataHolder));
    }
  }
  
  static final class SnapshotDeletedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Snapshots.DeleteSnapshotResult> Ea;
    
    public SnapshotDeletedBinderCallbacks(BaseImplementation.b<Snapshots.DeleteSnapshotResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void i(int paramInt, String paramString)
    {
      this.Ea.b(new GamesClientImpl.DeleteSnapshotResultImpl(paramInt, paramString));
    }
  }
  
  private static final class SnapshotOpenedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Snapshots.OpenSnapshotResult> ZC;
    
    public SnapshotOpenedBinderCallbacks(BaseImplementation.b<Snapshots.OpenSnapshotResult> paramb)
    {
      this.ZC = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder, Contents paramContents)
    {
      this.ZC.b(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramContents));
    }
    
    public void a(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      this.ZC.b(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramString, paramContents1, paramContents2, paramContents3));
    }
  }
  
  private static final class SnapshotsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Snapshots.LoadSnapshotsResult> ZD;
    
    public SnapshotsLoadedBinderCallbacks(BaseImplementation.b<Snapshots.LoadSnapshotsResult> paramb)
    {
      this.ZD = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void I(DataHolder paramDataHolder)
    {
      this.ZD.b(new GamesClientImpl.LoadSnapshotsResultImpl(paramDataHolder));
    }
  }
  
  private static final class SubmitScoreBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Leaderboards.SubmitScoreResult> Ea;
    
    public SubmitScoreBinderCallbacks(BaseImplementation.b<Leaderboards.SubmitScoreResult> paramb)
    {
      this.Ea = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void f(DataHolder paramDataHolder)
    {
      this.Ea.b(new GamesClientImpl.SubmitScoreResultImpl(paramDataHolder));
    }
  }
  
  private static final class SubmitScoreResultImpl
    extends b
    implements Leaderboards.SubmitScoreResult
  {
    private final ScoreSubmissionData ZE;
    
    public SubmitScoreResultImpl(DataHolder paramDataHolder)
    {
      super();
      try
      {
        this.ZE = new ScoreSubmissionData(paramDataHolder);
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    
    public ScoreSubmissionData getScoreData()
    {
      return this.ZE;
    }
  }
  
  private static final class TurnBasedMatchCanceledBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.CancelMatchResult> ZF;
    
    public TurnBasedMatchCanceledBinderCallbacks(BaseImplementation.b<TurnBasedMultiplayer.CancelMatchResult> paramb)
    {
      this.ZF = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void h(int paramInt, String paramString)
    {
      Status localStatus = new Status(paramInt);
      this.ZF.b(new GamesClientImpl.CancelMatchResultImpl(localStatus, paramString));
    }
  }
  
  private static final class TurnBasedMatchInitiatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> ZG;
    
    public TurnBasedMatchInitiatedBinderCallbacks(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb)
    {
      this.ZG = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void q(DataHolder paramDataHolder)
    {
      this.ZG.b(new GamesClientImpl.InitiateMatchResultImpl(paramDataHolder));
    }
  }
  
  private static final class TurnBasedMatchLeftBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.LeaveMatchResult> ZH;
    
    public TurnBasedMatchLeftBinderCallbacks(BaseImplementation.b<TurnBasedMultiplayer.LeaveMatchResult> paramb)
    {
      this.ZH = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void s(DataHolder paramDataHolder)
    {
      this.ZH.b(new GamesClientImpl.LeaveMatchResultImpl(paramDataHolder));
    }
  }
  
  private static final class TurnBasedMatchLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.LoadMatchResult> ZI;
    
    public TurnBasedMatchLoadedBinderCallbacks(BaseImplementation.b<TurnBasedMultiplayer.LoadMatchResult> paramb)
    {
      this.ZI = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void p(DataHolder paramDataHolder)
    {
      this.ZI.b(new GamesClientImpl.LoadMatchResultImpl(paramDataHolder));
    }
  }
  
  private static abstract class TurnBasedMatchResult
    extends b
  {
    final TurnBasedMatch Zc;
    
    /* Error */
    TurnBasedMatchResult(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 10	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 12	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 13	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 17	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_2
      //   23: iconst_0
      //   24: invokevirtual 21	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 23	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   30: invokeinterface 27 1 0
      //   35: checkcast 23	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   38: putfield 29	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:Zc	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   41: aload_2
      //   42: invokevirtual 33	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:release	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 29	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:Zc	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   51: goto -10 -> 41
      //   54: astore_3
      //   55: aload_2
      //   56: invokevirtual 33	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:release	()V
      //   59: aload_3
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	TurnBasedMatchResult
      //   0	61	1	paramDataHolder	DataHolder
      //   13	43	2	localTurnBasedMatchBuffer	TurnBasedMatchBuffer
      //   54	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
    
    public TurnBasedMatch getMatch()
    {
      return this.Zc;
    }
  }
  
  private static final class TurnBasedMatchUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.UpdateMatchResult> ZJ;
    
    public TurnBasedMatchUpdatedBinderCallbacks(BaseImplementation.b<TurnBasedMultiplayer.UpdateMatchResult> paramb)
    {
      this.ZJ = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void r(DataHolder paramDataHolder)
    {
      this.ZJ.b(new GamesClientImpl.UpdateMatchResultImpl(paramDataHolder));
    }
  }
  
  private static final class TurnBasedMatchesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.LoadMatchesResult> ZK;
    
    public TurnBasedMatchesLoadedBinderCallbacks(BaseImplementation.b<TurnBasedMultiplayer.LoadMatchesResult> paramb)
    {
      this.ZK = ((BaseImplementation.b)jx.b(paramb, "Holder must not be null"));
    }
    
    public void b(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.ZK.b(new GamesClientImpl.LoadMatchesResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class UpdateAchievementResultImpl
    implements Achievements.UpdateAchievementResult
  {
    private final Status Eb;
    private final String Xx;
    
    UpdateAchievementResultImpl(int paramInt, String paramString)
    {
      this.Eb = new Status(paramInt);
      this.Xx = paramString;
    }
    
    public String getAchievementId()
    {
      return this.Xx;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  private static final class UpdateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.UpdateMatchResult
  {
    UpdateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class UpdateRequestsResultImpl
    extends b
    implements Requests.UpdateRequestsResult
  {
    private final RequestUpdateOutcomes ZL;
    
    UpdateRequestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.ZL = RequestUpdateOutcomes.W(paramDataHolder);
    }
    
    public Set<String> getRequestIds()
    {
      return this.ZL.getRequestIds();
    }
    
    public int getRequestOutcome(String paramString)
    {
      return this.ZL.getRequestOutcome(paramString);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.GamesClientImpl
 * JD-Core Version:    0.7.0.1
 */