package com.google.android.gms.games.multiplayer;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;

public abstract interface Invitation
  extends Parcelable, Freezable<Invitation>, Participatable
{
  public static final int INVITATION_TYPE_REAL_TIME = 0;
  public static final int INVITATION_TYPE_TURN_BASED = 1;
  
  public abstract int getAvailableAutoMatchSlots();
  
  public abstract long getCreationTimestamp();
  
  public abstract Game getGame();
  
  public abstract String getInvitationId();
  
  public abstract int getInvitationType();
  
  public abstract Participant getInviter();
  
  public abstract int getVariant();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.Invitation
 * JD-Core Version:    0.7.0.1
 */