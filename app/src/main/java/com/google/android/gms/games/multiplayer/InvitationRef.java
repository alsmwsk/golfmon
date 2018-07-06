package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class InvitationRef
  extends d
  implements Invitation
{
  private final ArrayList<Participant> adV;
  private final ParticipantRef adY;
  private final Game adq;
  
  InvitationRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.adq = new GameRef(paramDataHolder, paramInt1);
    this.adV = new ArrayList(paramInt2);
    String str = getString("external_inviter_id");
    int i = 0;
    Object localObject = null;
    while (i < paramInt2)
    {
      ParticipantRef localParticipantRef = new ParticipantRef(this.JG, i + this.KZ);
      if (localParticipantRef.getParticipantId().equals(str)) {
        localObject = localParticipantRef;
      }
      this.adV.add(localParticipantRef);
      i++;
    }
    this.adY = ((ParticipantRef)jx.b(localObject, "Must have a valid inviter!"));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return InvitationEntity.a(this, paramObject);
  }
  
  public Invitation freeze()
  {
    return new InvitationEntity(this);
  }
  
  public int getAvailableAutoMatchSlots()
  {
    if (!getBoolean("has_automatch_criteria")) {
      return 0;
    }
    return getInteger("automatch_max_players");
  }
  
  public long getCreationTimestamp()
  {
    return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
  }
  
  public Game getGame()
  {
    return this.adq;
  }
  
  public String getInvitationId()
  {
    return getString("external_invitation_id");
  }
  
  public int getInvitationType()
  {
    return getInteger("type");
  }
  
  public Participant getInviter()
  {
    return this.adY;
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return this.adV;
  }
  
  public int getVariant()
  {
    return getInteger("variant");
  }
  
  public int hashCode()
  {
    return InvitationEntity.a(this);
  }
  
  public String toString()
  {
    return InvitationEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((InvitationEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.InvitationRef
 * JD-Core Version:    0.7.0.1
 */