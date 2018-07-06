package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class ZInvitationCluster
  implements SafeParcelable, Invitation
{
  public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
  private final int CK;
  private final ArrayList<InvitationEntity> acE;
  
  ZInvitationCluster(int paramInt, ArrayList<InvitationEntity> paramArrayList)
  {
    this.CK = paramInt;
    this.acE = paramArrayList;
    mp();
  }
  
  private void mp()
  {
    if (!this.acE.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      je.K(bool);
      Invitation localInvitation1 = (Invitation)this.acE.get(0);
      int i = this.acE.size();
      for (int j = 1; j < i; j++)
      {
        Invitation localInvitation2 = (Invitation)this.acE.get(j);
        je.a(localInvitation1.getInviter().equals(localInvitation2.getInviter()), "All the invitations must be from the same inviter");
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ZInvitationCluster)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    ZInvitationCluster localZInvitationCluster = (ZInvitationCluster)paramObject;
    if (localZInvitationCluster.acE.size() != this.acE.size()) {
      return false;
    }
    int i = this.acE.size();
    for (int j = 0; j < i; j++) {
      if (!((Invitation)this.acE.get(j)).equals((Invitation)localZInvitationCluster.acE.get(j))) {
        return false;
      }
    }
    return true;
  }
  
  public Invitation freeze()
  {
    return this;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public long getCreationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Game getGame()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String getInvitationId()
  {
    return ((InvitationEntity)this.acE.get(0)).getInvitationId();
  }
  
  public int getInvitationType()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Participant getInviter()
  {
    return ((InvitationEntity)this.acE.get(0)).getInviter();
  }
  
  public ArrayList<Participant> getParticipants()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getVariant()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return jv.hashCode(this.acE.toArray());
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public ArrayList<Invitation> mq()
  {
    return new ArrayList(this.acE);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    InvitationClusterCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.multiplayer.ZInvitationCluster
 * JD-Core Version:    0.7.0.1
 */