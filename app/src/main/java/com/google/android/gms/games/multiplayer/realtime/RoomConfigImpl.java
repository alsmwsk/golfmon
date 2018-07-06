package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class RoomConfigImpl
  extends RoomConfig
{
  private final String YG;
  private final int adW;
  private final RoomUpdateListener aeh;
  private final RoomStatusUpdateListener aei;
  private final RealTimeMessageReceivedListener aej;
  private final Bundle aem;
  private final boolean aen;
  private final String[] aeo;
  
  RoomConfigImpl(RoomConfig.Builder paramBuilder)
  {
    this.aeh = paramBuilder.aeh;
    this.aei = paramBuilder.aei;
    this.aej = paramBuilder.aej;
    this.YG = paramBuilder.aek;
    this.adW = paramBuilder.adW;
    this.aem = paramBuilder.aem;
    this.aen = paramBuilder.aen;
    int i = paramBuilder.ael.size();
    this.aeo = ((String[])paramBuilder.ael.toArray(new String[i]));
    if (this.aej == null) {
      jx.a(this.aen, "Must either enable sockets OR specify a message listener");
    }
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.aem;
  }
  
  public String getInvitationId()
  {
    return this.YG;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.aeo;
  }
  
  public RealTimeMessageReceivedListener getMessageReceivedListener()
  {
    return this.aej;
  }
  
  public RoomStatusUpdateListener getRoomStatusUpdateListener()
  {
    return this.aei;
  }
  
  public RoomUpdateListener getRoomUpdateListener()
  {
    return this.aeh;
  }
  
  public int getVariant()
  {
    return this.adW;
  }
  
  public boolean isSocketEnabled()
  {
    return this.aen;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomConfigImpl
 * JD-Core Version:    0.7.0.1
 */