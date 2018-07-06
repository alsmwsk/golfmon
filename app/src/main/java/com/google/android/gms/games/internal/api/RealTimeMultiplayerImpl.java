package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.d;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public final class RealTimeMultiplayerImpl
  implements RealTimeMultiplayer
{
  private static <L> d<L> a(GoogleApiClient paramGoogleApiClient, L paramL)
  {
    if (paramL == null) {
      return null;
    }
    return paramGoogleApiClient.d(paramL);
  }
  
  public void create(GoogleApiClient paramGoogleApiClient, RoomConfig paramRoomConfig)
  {
    d locald1 = paramGoogleApiClient.d(paramRoomConfig.getRoomUpdateListener());
    d locald2 = a(paramGoogleApiClient, paramRoomConfig.getRoomStatusUpdateListener());
    d locald3 = a(paramGoogleApiClient, paramRoomConfig.getMessageReceivedListener());
    Games.d(paramGoogleApiClient).a(locald1, locald2, locald3, paramRoomConfig);
  }
  
  public void declineInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    Games.d(paramGoogleApiClient).q(paramString, 0);
  }
  
  public void dismissInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    Games.d(paramGoogleApiClient).p(paramString, 0);
  }
  
  public Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2)
  {
    return Games.d(paramGoogleApiClient).b(paramInt1, paramInt2, true);
  }
  
  public Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return Games.d(paramGoogleApiClient).b(paramInt1, paramInt2, paramBoolean);
  }
  
  public RealTimeSocket getSocketForParticipant(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2)
  {
    return Games.d(paramGoogleApiClient).s(paramString1, paramString2);
  }
  
  public Intent getWaitingRoomIntent(GoogleApiClient paramGoogleApiClient, Room paramRoom, int paramInt)
  {
    return Games.d(paramGoogleApiClient).a(paramRoom, paramInt);
  }
  
  public void join(GoogleApiClient paramGoogleApiClient, RoomConfig paramRoomConfig)
  {
    d locald1 = paramGoogleApiClient.d(paramRoomConfig.getRoomUpdateListener());
    d locald2 = a(paramGoogleApiClient, paramRoomConfig.getRoomStatusUpdateListener());
    d locald3 = a(paramGoogleApiClient, paramRoomConfig.getMessageReceivedListener());
    Games.d(paramGoogleApiClient).b(locald1, locald2, locald3, paramRoomConfig);
  }
  
  public void leave(GoogleApiClient paramGoogleApiClient, RoomUpdateListener paramRoomUpdateListener, String paramString)
  {
    d locald = paramGoogleApiClient.d(paramRoomUpdateListener);
    Games.d(paramGoogleApiClient).a(locald, paramString);
  }
  
  public int sendReliableMessage(GoogleApiClient paramGoogleApiClient, RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    d locald = a(paramGoogleApiClient, paramReliableMessageSentCallback);
    return Games.d(paramGoogleApiClient).a(locald, paramArrayOfByte, paramString1, paramString2);
  }
  
  public int sendUnreliableMessage(GoogleApiClient paramGoogleApiClient, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    return Games.d(paramGoogleApiClient).a(paramArrayOfByte, paramString1, new String[] { paramString2 });
  }
  
  public int sendUnreliableMessage(GoogleApiClient paramGoogleApiClient, byte[] paramArrayOfByte, String paramString, List<String> paramList)
  {
    String[] arrayOfString = (String[])paramList.toArray(new String[paramList.size()]);
    return Games.d(paramGoogleApiClient).a(paramArrayOfByte, paramString, arrayOfString);
  }
  
  public int sendUnreliableMessageToOthers(GoogleApiClient paramGoogleApiClient, byte[] paramArrayOfByte, String paramString)
  {
    return Games.d(paramGoogleApiClient).d(paramArrayOfByte, paramString);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl
 * JD-Core Version:    0.7.0.1
 */