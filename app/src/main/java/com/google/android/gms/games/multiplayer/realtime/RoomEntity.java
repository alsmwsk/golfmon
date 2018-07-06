package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class RoomEntity
  extends GamesDowngradeableSafeParcel
  implements Room
{
  public static final Parcelable.Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
  private final int CK;
  private final String UO;
  private final String YI;
  private final long adS;
  private final ArrayList<ParticipantEntity> adV;
  private final int adW;
  private final Bundle aem;
  private final String aep;
  private final int aeq;
  private final int aer;
  
  RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList<ParticipantEntity> paramArrayList, int paramInt4)
  {
    this.CK = paramInt1;
    this.YI = paramString1;
    this.aep = paramString2;
    this.adS = paramLong;
    this.aeq = paramInt2;
    this.UO = paramString3;
    this.adW = paramInt3;
    this.aem = paramBundle;
    this.adV = paramArrayList;
    this.aer = paramInt4;
  }
  
  public RoomEntity(Room paramRoom)
  {
    this.CK = 2;
    this.YI = paramRoom.getRoomId();
    this.aep = paramRoom.getCreatorId();
    this.adS = paramRoom.getCreationTimestamp();
    this.aeq = paramRoom.getStatus();
    this.UO = paramRoom.getDescription();
    this.adW = paramRoom.getVariant();
    this.aem = paramRoom.getAutoMatchCriteria();
    ArrayList localArrayList = paramRoom.getParticipants();
    int i = localArrayList.size();
    this.adV = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      this.adV.add((ParticipantEntity)((Participant)localArrayList.get(j)).freeze());
    }
    this.aer = paramRoom.getAutoMatchWaitEstimateSeconds();
  }
  
  static int a(Room paramRoom)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = paramRoom.getRoomId();
    arrayOfObject[1] = paramRoom.getCreatorId();
    arrayOfObject[2] = Long.valueOf(paramRoom.getCreationTimestamp());
    arrayOfObject[3] = Integer.valueOf(paramRoom.getStatus());
    arrayOfObject[4] = paramRoom.getDescription();
    arrayOfObject[5] = Integer.valueOf(paramRoom.getVariant());
    arrayOfObject[6] = paramRoom.getAutoMatchCriteria();
    arrayOfObject[7] = paramRoom.getParticipants();
    arrayOfObject[8] = Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds());
    return jv.hashCode(arrayOfObject);
  }
  
  static int a(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      Participant localParticipant = (Participant)localArrayList.get(j);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant.getStatus();
      }
    }
    throw new IllegalStateException("Participant " + paramString + " is not in room " + paramRoom.getRoomId());
  }
  
  static boolean a(Room paramRoom, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof Room)) {
      bool = false;
    }
    Room localRoom;
    do
    {
      do
      {
        return bool;
      } while (paramRoom == paramObject);
      localRoom = (Room)paramObject;
    } while ((jv.equal(localRoom.getRoomId(), paramRoom.getRoomId())) && (jv.equal(localRoom.getCreatorId(), paramRoom.getCreatorId())) && (jv.equal(Long.valueOf(localRoom.getCreationTimestamp()), Long.valueOf(paramRoom.getCreationTimestamp()))) && (jv.equal(Integer.valueOf(localRoom.getStatus()), Integer.valueOf(paramRoom.getStatus()))) && (jv.equal(localRoom.getDescription(), paramRoom.getDescription())) && (jv.equal(Integer.valueOf(localRoom.getVariant()), Integer.valueOf(paramRoom.getVariant()))) && (jv.equal(localRoom.getAutoMatchCriteria(), paramRoom.getAutoMatchCriteria())) && (jv.equal(localRoom.getParticipants(), paramRoom.getParticipants())) && (jv.equal(Integer.valueOf(localRoom.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds()))));
    return false;
  }
  
  static String b(Room paramRoom)
  {
    return jv.h(paramRoom).a("RoomId", paramRoom.getRoomId()).a("CreatorId", paramRoom.getCreatorId()).a("CreationTimestamp", Long.valueOf(paramRoom.getCreationTimestamp())).a("RoomStatus", Integer.valueOf(paramRoom.getStatus())).a("Description", paramRoom.getDescription()).a("Variant", Integer.valueOf(paramRoom.getVariant())).a("AutoMatchCriteria", paramRoom.getAutoMatchCriteria()).a("Participants", paramRoom.getParticipants()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())).toString();
  }
  
  static String b(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      Participant localParticipant = (Participant)localArrayList.get(j);
      Player localPlayer = localParticipant.getPlayer();
      if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
        return localParticipant.getParticipantId();
      }
    }
    return null;
  }
  
  static Participant c(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      Participant localParticipant = (Participant)localArrayList.get(j);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant;
      }
    }
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramRoom.getRoomId());
  }
  
  static ArrayList<String> c(Room paramRoom)
  {
    ArrayList localArrayList1 = paramRoom.getParticipants();
    int i = localArrayList1.size();
    ArrayList localArrayList2 = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList2.add(((Participant)localArrayList1.get(j)).getParticipantId());
    }
    return localArrayList2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Room freeze()
  {
    return this;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.aem;
  }
  
  public int getAutoMatchWaitEstimateSeconds()
  {
    return this.aer;
  }
  
  public long getCreationTimestamp()
  {
    return this.adS;
  }
  
  public String getCreatorId()
  {
    return this.aep;
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.UO, paramCharArrayBuffer);
  }
  
  public Participant getParticipant(String paramString)
  {
    return c(this, paramString);
  }
  
  public String getParticipantId(String paramString)
  {
    return b(this, paramString);
  }
  
  public ArrayList<String> getParticipantIds()
  {
    return c(this);
  }
  
  public int getParticipantStatus(String paramString)
  {
    return a(this, paramString);
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.adV);
  }
  
  public String getRoomId()
  {
    return this.YI;
  }
  
  public int getStatus()
  {
    return this.aeq;
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
      RoomEntityCreator.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      paramParcel.writeString(this.YI);
      paramParcel.writeString(this.aep);
      paramParcel.writeLong(this.adS);
      paramParcel.writeInt(this.aeq);
      paramParcel.writeString(this.UO);
      paramParcel.writeInt(this.adW);
      paramParcel.writeBundle(this.aem);
      int i = this.adV.size();
      paramParcel.writeInt(i);
      for (int j = 0; j < i; j++) {
        ((ParticipantEntity)this.adV.get(j)).writeToParcel(paramParcel, paramInt);
      }
    }
  }
  
  static final class RoomEntityCreatorCompat
    extends RoomEntityCreator
  {
    public RoomEntity cC(Parcel paramParcel)
    {
      if ((RoomEntity.b(RoomEntity.kD())) || (RoomEntity.bz(RoomEntity.class.getCanonicalName()))) {
        return super.cC(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      long l = paramParcel.readLong();
      int i = paramParcel.readInt();
      String str3 = paramParcel.readString();
      int j = paramParcel.readInt();
      Bundle localBundle = paramParcel.readBundle();
      int k = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(k);
      for (int m = 0; m < k; m++) {
        localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
      }
      return new RoomEntity(2, str1, str2, l, i, str3, j, localBundle, localArrayList, -1);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomEntity
 * JD-Core Version:    0.7.0.1
 */