package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class TurnBasedMatchEntity
  implements SafeParcelable, TurnBasedMatch
{
  public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
  private final int CK;
  private final int Ef;
  private final String UO;
  private final long XH;
  private final String Zb;
  private final GameEntity acs;
  private final long adS;
  private final ArrayList<ParticipantEntity> adV;
  private final int adW;
  private final byte[] aeA;
  private final String aeB;
  private final byte[] aeC;
  private final int aeD;
  private final int aeE;
  private final boolean aeF;
  private final String aeG;
  private final Bundle aem;
  private final String aep;
  private final String aex;
  private final String aey;
  private final int aez;
  
  TurnBasedMatchEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, String paramString4, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, ArrayList<ParticipantEntity> paramArrayList, String paramString5, byte[] paramArrayOfByte2, int paramInt5, Bundle paramBundle, int paramInt6, boolean paramBoolean, String paramString6, String paramString7)
  {
    this.CK = paramInt1;
    this.acs = paramGameEntity;
    this.Zb = paramString1;
    this.aep = paramString2;
    this.adS = paramLong1;
    this.aex = paramString3;
    this.XH = paramLong2;
    this.aey = paramString4;
    this.aez = paramInt2;
    this.aeE = paramInt6;
    this.adW = paramInt3;
    this.Ef = paramInt4;
    this.aeA = paramArrayOfByte1;
    this.adV = paramArrayList;
    this.aeB = paramString5;
    this.aeC = paramArrayOfByte2;
    this.aeD = paramInt5;
    this.aem = paramBundle;
    this.aeF = paramBoolean;
    this.UO = paramString6;
    this.aeG = paramString7;
  }
  
  public TurnBasedMatchEntity(TurnBasedMatch paramTurnBasedMatch)
  {
    this.CK = 2;
    this.acs = new GameEntity(paramTurnBasedMatch.getGame());
    this.Zb = paramTurnBasedMatch.getMatchId();
    this.aep = paramTurnBasedMatch.getCreatorId();
    this.adS = paramTurnBasedMatch.getCreationTimestamp();
    this.aex = paramTurnBasedMatch.getLastUpdaterId();
    this.XH = paramTurnBasedMatch.getLastUpdatedTimestamp();
    this.aey = paramTurnBasedMatch.getPendingParticipantId();
    this.aez = paramTurnBasedMatch.getStatus();
    this.aeE = paramTurnBasedMatch.getTurnStatus();
    this.adW = paramTurnBasedMatch.getVariant();
    this.Ef = paramTurnBasedMatch.getVersion();
    this.aeB = paramTurnBasedMatch.getRematchId();
    this.aeD = paramTurnBasedMatch.getMatchNumber();
    this.aem = paramTurnBasedMatch.getAutoMatchCriteria();
    this.aeF = paramTurnBasedMatch.isLocallyModified();
    this.UO = paramTurnBasedMatch.getDescription();
    this.aeG = paramTurnBasedMatch.getDescriptionParticipantId();
    byte[] arrayOfByte1 = paramTurnBasedMatch.getData();
    byte[] arrayOfByte2;
    if (arrayOfByte1 == null)
    {
      this.aeA = null;
      arrayOfByte2 = paramTurnBasedMatch.getPreviousMatchData();
      if (arrayOfByte2 != null) {
        break label314;
      }
      this.aeC = null;
    }
    for (;;)
    {
      ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
      int i = localArrayList.size();
      this.adV = new ArrayList(i);
      for (int j = 0; j < i; j++) {
        this.adV.add((ParticipantEntity)((Participant)localArrayList.get(j)).freeze());
      }
      this.aeA = new byte[arrayOfByte1.length];
      System.arraycopy(arrayOfByte1, 0, this.aeA, 0, arrayOfByte1.length);
      break;
      label314:
      this.aeC = new byte[arrayOfByte2.length];
      System.arraycopy(arrayOfByte2, 0, this.aeC, 0, arrayOfByte2.length);
    }
  }
  
  static int a(TurnBasedMatch paramTurnBasedMatch)
  {
    Object[] arrayOfObject = new Object[18];
    arrayOfObject[0] = paramTurnBasedMatch.getGame();
    arrayOfObject[1] = paramTurnBasedMatch.getMatchId();
    arrayOfObject[2] = paramTurnBasedMatch.getCreatorId();
    arrayOfObject[3] = Long.valueOf(paramTurnBasedMatch.getCreationTimestamp());
    arrayOfObject[4] = paramTurnBasedMatch.getLastUpdaterId();
    arrayOfObject[5] = Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp());
    arrayOfObject[6] = paramTurnBasedMatch.getPendingParticipantId();
    arrayOfObject[7] = Integer.valueOf(paramTurnBasedMatch.getStatus());
    arrayOfObject[8] = Integer.valueOf(paramTurnBasedMatch.getTurnStatus());
    arrayOfObject[9] = paramTurnBasedMatch.getDescription();
    arrayOfObject[10] = Integer.valueOf(paramTurnBasedMatch.getVariant());
    arrayOfObject[11] = Integer.valueOf(paramTurnBasedMatch.getVersion());
    arrayOfObject[12] = paramTurnBasedMatch.getParticipants();
    arrayOfObject[13] = paramTurnBasedMatch.getRematchId();
    arrayOfObject[14] = Integer.valueOf(paramTurnBasedMatch.getMatchNumber());
    arrayOfObject[15] = paramTurnBasedMatch.getAutoMatchCriteria();
    arrayOfObject[16] = Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots());
    arrayOfObject[17] = Boolean.valueOf(paramTurnBasedMatch.isLocallyModified());
    return jv.hashCode(arrayOfObject);
  }
  
  static int a(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      Participant localParticipant = (Participant)localArrayList.get(j);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant.getStatus();
      }
    }
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramTurnBasedMatch.getMatchId());
  }
  
  static boolean a(TurnBasedMatch paramTurnBasedMatch, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof TurnBasedMatch)) {
      bool = false;
    }
    TurnBasedMatch localTurnBasedMatch;
    do
    {
      do
      {
        return bool;
      } while (paramTurnBasedMatch == paramObject);
      localTurnBasedMatch = (TurnBasedMatch)paramObject;
    } while ((jv.equal(localTurnBasedMatch.getGame(), paramTurnBasedMatch.getGame())) && (jv.equal(localTurnBasedMatch.getMatchId(), paramTurnBasedMatch.getMatchId())) && (jv.equal(localTurnBasedMatch.getCreatorId(), paramTurnBasedMatch.getCreatorId())) && (jv.equal(Long.valueOf(localTurnBasedMatch.getCreationTimestamp()), Long.valueOf(paramTurnBasedMatch.getCreationTimestamp()))) && (jv.equal(localTurnBasedMatch.getLastUpdaterId(), paramTurnBasedMatch.getLastUpdaterId())) && (jv.equal(Long.valueOf(localTurnBasedMatch.getLastUpdatedTimestamp()), Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp()))) && (jv.equal(localTurnBasedMatch.getPendingParticipantId(), paramTurnBasedMatch.getPendingParticipantId())) && (jv.equal(Integer.valueOf(localTurnBasedMatch.getStatus()), Integer.valueOf(paramTurnBasedMatch.getStatus()))) && (jv.equal(Integer.valueOf(localTurnBasedMatch.getTurnStatus()), Integer.valueOf(paramTurnBasedMatch.getTurnStatus()))) && (jv.equal(localTurnBasedMatch.getDescription(), paramTurnBasedMatch.getDescription())) && (jv.equal(Integer.valueOf(localTurnBasedMatch.getVariant()), Integer.valueOf(paramTurnBasedMatch.getVariant()))) && (jv.equal(Integer.valueOf(localTurnBasedMatch.getVersion()), Integer.valueOf(paramTurnBasedMatch.getVersion()))) && (jv.equal(localTurnBasedMatch.getParticipants(), paramTurnBasedMatch.getParticipants())) && (jv.equal(localTurnBasedMatch.getRematchId(), paramTurnBasedMatch.getRematchId())) && (jv.equal(Integer.valueOf(localTurnBasedMatch.getMatchNumber()), Integer.valueOf(paramTurnBasedMatch.getMatchNumber()))) && (jv.equal(localTurnBasedMatch.getAutoMatchCriteria(), paramTurnBasedMatch.getAutoMatchCriteria())) && (jv.equal(Integer.valueOf(localTurnBasedMatch.getAvailableAutoMatchSlots()), Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots()))) && (jv.equal(Boolean.valueOf(localTurnBasedMatch.isLocallyModified()), Boolean.valueOf(paramTurnBasedMatch.isLocallyModified()))));
    return false;
  }
  
  static String b(TurnBasedMatch paramTurnBasedMatch)
  {
    return jv.h(paramTurnBasedMatch).a("Game", paramTurnBasedMatch.getGame()).a("MatchId", paramTurnBasedMatch.getMatchId()).a("CreatorId", paramTurnBasedMatch.getCreatorId()).a("CreationTimestamp", Long.valueOf(paramTurnBasedMatch.getCreationTimestamp())).a("LastUpdaterId", paramTurnBasedMatch.getLastUpdaterId()).a("LastUpdatedTimestamp", Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp())).a("PendingParticipantId", paramTurnBasedMatch.getPendingParticipantId()).a("MatchStatus", Integer.valueOf(paramTurnBasedMatch.getStatus())).a("TurnStatus", Integer.valueOf(paramTurnBasedMatch.getTurnStatus())).a("Description", paramTurnBasedMatch.getDescription()).a("Variant", Integer.valueOf(paramTurnBasedMatch.getVariant())).a("Data", paramTurnBasedMatch.getData()).a("Version", Integer.valueOf(paramTurnBasedMatch.getVersion())).a("Participants", paramTurnBasedMatch.getParticipants()).a("RematchId", paramTurnBasedMatch.getRematchId()).a("PreviousData", paramTurnBasedMatch.getPreviousMatchData()).a("MatchNumber", Integer.valueOf(paramTurnBasedMatch.getMatchNumber())).a("AutoMatchCriteria", paramTurnBasedMatch.getAutoMatchCriteria()).a("AvailableAutoMatchSlots", Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots())).a("LocallyModified", Boolean.valueOf(paramTurnBasedMatch.isLocallyModified())).a("DescriptionParticipantId", paramTurnBasedMatch.getDescriptionParticipantId()).toString();
  }
  
  static String b(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
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
  
  static Participant c(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      Participant localParticipant = (Participant)localArrayList.get(j);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant;
      }
    }
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramTurnBasedMatch.getMatchId());
  }
  
  static ArrayList<String> c(TurnBasedMatch paramTurnBasedMatch)
  {
    ArrayList localArrayList1 = paramTurnBasedMatch.getParticipants();
    int i = localArrayList1.size();
    ArrayList localArrayList2 = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList2.add(((Participant)localArrayList1.get(j)).getParticipantId());
    }
    return localArrayList2;
  }
  
  public boolean canRematch()
  {
    return (this.aez == 2) && (this.aeB == null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public TurnBasedMatch freeze()
  {
    return this;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.aem;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    if (this.aem == null) {
      return 0;
    }
    return this.aem.getInt("max_automatch_players");
  }
  
  public long getCreationTimestamp()
  {
    return this.adS;
  }
  
  public String getCreatorId()
  {
    return this.aep;
  }
  
  public byte[] getData()
  {
    return this.aeA;
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.UO, paramCharArrayBuffer);
  }
  
  public Participant getDescriptionParticipant()
  {
    String str = getDescriptionParticipantId();
    if (str == null) {
      return null;
    }
    return getParticipant(str);
  }
  
  public String getDescriptionParticipantId()
  {
    return this.aeG;
  }
  
  public Game getGame()
  {
    return this.acs;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.XH;
  }
  
  public String getLastUpdaterId()
  {
    return this.aex;
  }
  
  public String getMatchId()
  {
    return this.Zb;
  }
  
  public int getMatchNumber()
  {
    return this.aeD;
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
  
  public String getPendingParticipantId()
  {
    return this.aey;
  }
  
  public byte[] getPreviousMatchData()
  {
    return this.aeC;
  }
  
  public String getRematchId()
  {
    return this.aeB;
  }
  
  public int getStatus()
  {
    return this.aez;
  }
  
  public int getTurnStatus()
  {
    return this.aeE;
  }
  
  public int getVariant()
  {
    return this.adW;
  }
  
  public int getVersion()
  {
    return this.Ef;
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
  
  public boolean isLocallyModified()
  {
    return this.aeF;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    TurnBasedMatchEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity
 * JD-Core Version:    0.7.0.1
 */