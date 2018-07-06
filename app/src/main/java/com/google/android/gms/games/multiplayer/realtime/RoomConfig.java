package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomConfig
{
  public static Builder builder(RoomUpdateListener paramRoomUpdateListener)
  {
    return new Builder(paramRoomUpdateListener, null);
  }
  
  public static Bundle createAutoMatchCriteria(int paramInt1, int paramInt2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("min_automatch_players", paramInt1);
    localBundle.putInt("max_automatch_players", paramInt2);
    localBundle.putLong("exclusive_bit_mask", paramLong);
    return localBundle;
  }
  
  public abstract Bundle getAutoMatchCriteria();
  
  public abstract String getInvitationId();
  
  public abstract String[] getInvitedPlayerIds();
  
  public abstract RealTimeMessageReceivedListener getMessageReceivedListener();
  
  public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();
  
  public abstract RoomUpdateListener getRoomUpdateListener();
  
  public abstract int getVariant();
  
  @Deprecated
  public abstract boolean isSocketEnabled();
  
  public static final class Builder
  {
    int adW = -1;
    final RoomUpdateListener aeh;
    RoomStatusUpdateListener aei;
    RealTimeMessageReceivedListener aej;
    String aek = null;
    ArrayList<String> ael = new ArrayList();
    Bundle aem;
    boolean aen = false;
    
    private Builder(RoomUpdateListener paramRoomUpdateListener)
    {
      this.aeh = ((RoomUpdateListener)jx.b(paramRoomUpdateListener, "Must provide a RoomUpdateListener"));
    }
    
    public Builder addPlayersToInvite(ArrayList<String> paramArrayList)
    {
      jx.i(paramArrayList);
      this.ael.addAll(paramArrayList);
      return this;
    }
    
    public Builder addPlayersToInvite(String... paramVarArgs)
    {
      jx.i(paramVarArgs);
      this.ael.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public RoomConfig build()
    {
      return new RoomConfigImpl(this);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.aem = paramBundle;
      return this;
    }
    
    public Builder setInvitationIdToAccept(String paramString)
    {
      jx.i(paramString);
      this.aek = paramString;
      return this;
    }
    
    public Builder setMessageReceivedListener(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      this.aej = paramRealTimeMessageReceivedListener;
      return this;
    }
    
    public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      this.aei = paramRoomStatusUpdateListener;
      return this;
    }
    
    @Deprecated
    public Builder setSocketCommunicationEnabled(boolean paramBoolean)
    {
      this.aen = paramBoolean;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
        this.adW = paramInt;
        return this;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomConfig
 * JD-Core Version:    0.7.0.1
 */