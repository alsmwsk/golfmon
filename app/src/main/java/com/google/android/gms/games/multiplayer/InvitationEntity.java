package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class InvitationEntity
  extends GamesDowngradeableSafeParcel
  implements Invitation
{
  public static final Parcelable.Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
  private final int CK;
  private final String YG;
  private final GameEntity acs;
  private final long adS;
  private final int adT;
  private final ParticipantEntity adU;
  private final ArrayList<ParticipantEntity> adV;
  private final int adW;
  private final int adX;
  
  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4)
  {
    this.CK = paramInt1;
    this.acs = paramGameEntity;
    this.YG = paramString;
    this.adS = paramLong;
    this.adT = paramInt2;
    this.adU = paramParticipantEntity;
    this.adV = paramArrayList;
    this.adW = paramInt3;
    this.adX = paramInt4;
  }
  
  InvitationEntity(Invitation paramInvitation)
  {
    this.CK = 2;
    this.acs = new GameEntity(paramInvitation.getGame());
    this.YG = paramInvitation.getInvitationId();
    this.adS = paramInvitation.getCreationTimestamp();
    this.adT = paramInvitation.getInvitationType();
    this.adW = paramInvitation.getVariant();
    this.adX = paramInvitation.getAvailableAutoMatchSlots();
    String str = paramInvitation.getInviter().getParticipantId();
    Object localObject = null;
    ArrayList localArrayList = paramInvitation.getParticipants();
    int i = localArrayList.size();
    this.adV = new ArrayList(i);
    for (int j = 0; j < i; j++)
    {
      Participant localParticipant = (Participant)localArrayList.get(j);
      if (localParticipant.getParticipantId().equals(str)) {
        localObject = localParticipant;
      }
      this.adV.add((ParticipantEntity)localParticipant.freeze());
    }
    jx.b(localObject, "Must have a valid inviter!");
    this.adU = ((ParticipantEntity)localObject.freeze());
  }
  
  static int a(Invitation paramInvitation)
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = paramInvitation.getGame();
    arrayOfObject[1] = paramInvitation.getInvitationId();
    arrayOfObject[2] = Long.valueOf(paramInvitation.getCreationTimestamp());
    arrayOfObject[3] = Integer.valueOf(paramInvitation.getInvitationType());
    arrayOfObject[4] = paramInvitation.getInviter();
    arrayOfObject[5] = paramInvitation.getParticipants();
    arrayOfObject[6] = Integer.valueOf(paramInvitation.getVariant());
    arrayOfObject[7] = Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots());
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(Invitation paramInvitation, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof Invitation)) {
      bool = false;
    }
    Invitation localInvitation;
    do
    {
      do
      {
        return bool;
      } while (paramInvitation == paramObject);
      localInvitation = (Invitation)paramObject;
    } while ((jv.equal(localInvitation.getGame(), paramInvitation.getGame())) && (jv.equal(localInvitation.getInvitationId(), paramInvitation.getInvitationId())) && (jv.equal(Long.valueOf(localInvitation.getCreationTimestamp()), Long.valueOf(paramInvitation.getCreationTimestamp()))) && (jv.equal(Integer.valueOf(localInvitation.getInvitationType()), Integer.valueOf(paramInvitation.getInvitationType()))) && (jv.equal(localInvitation.getInviter(), paramInvitation.getInviter())) && (jv.equal(localInvitation.getParticipants(), paramInvitation.getParticipants())) && (jv.equal(Integer.valueOf(localInvitation.getVariant()), Integer.valueOf(paramInvitation.getVariant()))) && (jv.equal(Integer.valueOf(localInvitation.getAvailableAutoMatchSlots()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots()))));
    return false;
  }
  
  static String b(Invitation paramInvitation)
  {
    return jv.h(paramInvitation).a("Game", paramInvitation.getGame()).a("InvitationId", paramInvitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(paramInvitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(paramInvitation.getInvitationType())).a("Inviter", paramInvitation.getInviter()).a("Participants", paramInvitation.getParticipants()).a("Variant", Integer.valueOf(paramInvitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Invitation freeze()
  {
    return this;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    return this.adX;
  }
  
  public long getCreationTimestamp()
  {
    return this.adS;
  }
  
  public Game getGame()
  {
    return this.acs;
  }
  
  public String getInvitationId()
  {
    return this.YG;
  }
  
  public int getInvitationType()
  {
    return this.adT;
  }
  
  public Participant getInviter()
  {
    return this.adU;
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.adV);
  }
  
  public int getVariant()
  {
    return this.adW;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!hu()) {
      InvitationEntityCreator.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      this.acs.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.YG);
      paramParcel.writeLong(this.adS);
      paramParcel.writeInt(this.adT);
      this.adU.writeToParcel(paramParcel, paramInt);
      int i = this.adV.size();
      paramParcel.writeInt(i);
      for (int j = 0; j < i; j++) {
        ((ParticipantEntity)this.adV.get(j)).writeToParcel(paramParcel, paramInt);
      }
    }
  }
  
  static final class InvitationEntityCreatorCompat
    extends InvitationEntityCreator
  {
    public InvitationEntity cz(Parcel paramParcel)
    {
      if ((InvitationEntity.b(InvitationEntity.kD())) || (InvitationEntity.bz(InvitationEntity.class.getCanonicalName()))) {
        return super.cz(paramParcel);
      }
      GameEntity localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
      String str = paramParcel.readString();
      long l = paramParcel.readLong();
      int i = paramParcel.readInt();
      ParticipantEntity localParticipantEntity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(paramParcel);
      int j = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(j);
      for (int k = 0; k < j; k++) {
        localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
      }
      return new InvitationEntity(2, localGameEntity, str, l, i, localParticipantEntity, localArrayList, -1, 0);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.InvitationEntity
 * JD-Core Version:    0.7.0.1
 */