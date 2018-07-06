package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;

public final class ParticipantEntity
  extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
  private final int CK;
  private final int FO;
  private final int FP;
  private final String OS;
  private final Uri WD;
  private final Uri WE;
  private final String WO;
  private final String WP;
  private final PlayerEntity XE;
  private final String Yi;
  private final String Zk;
  private final boolean adZ;
  private final ParticipantResult aea;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.CK = paramInt1;
    this.Zk = paramString1;
    this.OS = paramString2;
    this.WD = paramUri1;
    this.WE = paramUri2;
    this.FP = paramInt2;
    this.Yi = paramString3;
    this.adZ = paramBoolean;
    this.XE = paramPlayerEntity;
    this.FO = paramInt3;
    this.aea = paramParticipantResult;
    this.WO = paramString4;
    this.WP = paramString5;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.CK = 3;
    this.Zk = paramParticipant.getParticipantId();
    this.OS = paramParticipant.getDisplayName();
    this.WD = paramParticipant.getIconImageUri();
    this.WE = paramParticipant.getHiResImageUri();
    this.FP = paramParticipant.getStatus();
    this.Yi = paramParticipant.le();
    this.adZ = paramParticipant.isConnectedToRoom();
    Player localPlayer = paramParticipant.getPlayer();
    if (localPlayer == null) {}
    for (PlayerEntity localPlayerEntity = null;; localPlayerEntity = new PlayerEntity(localPlayer))
    {
      this.XE = localPlayerEntity;
      this.FO = paramParticipant.getCapabilities();
      this.aea = paramParticipant.getResult();
      this.WO = paramParticipant.getIconImageUrl();
      this.WP = paramParticipant.getHiResImageUrl();
      return;
    }
  }
  
  static int a(Participant paramParticipant)
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = paramParticipant.getPlayer();
    arrayOfObject[1] = Integer.valueOf(paramParticipant.getStatus());
    arrayOfObject[2] = paramParticipant.le();
    arrayOfObject[3] = Boolean.valueOf(paramParticipant.isConnectedToRoom());
    arrayOfObject[4] = paramParticipant.getDisplayName();
    arrayOfObject[5] = paramParticipant.getIconImageUri();
    arrayOfObject[6] = paramParticipant.getHiResImageUri();
    arrayOfObject[7] = Integer.valueOf(paramParticipant.getCapabilities());
    arrayOfObject[8] = paramParticipant.getResult();
    arrayOfObject[9] = paramParticipant.getParticipantId();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(Participant paramParticipant, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof Participant)) {
      bool = false;
    }
    Participant localParticipant;
    do
    {
      do
      {
        return bool;
      } while (paramParticipant == paramObject);
      localParticipant = (Participant)paramObject;
    } while ((jv.equal(localParticipant.getPlayer(), paramParticipant.getPlayer())) && (jv.equal(Integer.valueOf(localParticipant.getStatus()), Integer.valueOf(paramParticipant.getStatus()))) && (jv.equal(localParticipant.le(), paramParticipant.le())) && (jv.equal(Boolean.valueOf(localParticipant.isConnectedToRoom()), Boolean.valueOf(paramParticipant.isConnectedToRoom()))) && (jv.equal(localParticipant.getDisplayName(), paramParticipant.getDisplayName())) && (jv.equal(localParticipant.getIconImageUri(), paramParticipant.getIconImageUri())) && (jv.equal(localParticipant.getHiResImageUri(), paramParticipant.getHiResImageUri())) && (jv.equal(Integer.valueOf(localParticipant.getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities()))) && (jv.equal(localParticipant.getResult(), paramParticipant.getResult())) && (jv.equal(localParticipant.getParticipantId(), paramParticipant.getParticipantId())));
    return false;
  }
  
  static String b(Participant paramParticipant)
  {
    return jv.h(paramParticipant).a("ParticipantId", paramParticipant.getParticipantId()).a("Player", paramParticipant.getPlayer()).a("Status", Integer.valueOf(paramParticipant.getStatus())).a("ClientAddress", paramParticipant.le()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.isConnectedToRoom())).a("DisplayName", paramParticipant.getDisplayName()).a("IconImage", paramParticipant.getIconImageUri()).a("IconImageUrl", paramParticipant.getIconImageUrl()).a("HiResImage", paramParticipant.getHiResImageUri()).a("HiResImageUrl", paramParticipant.getHiResImageUrl()).a("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).a("Result", paramParticipant.getResult()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Participant freeze()
  {
    return this;
  }
  
  public int getCapabilities()
  {
    return this.FO;
  }
  
  public String getDisplayName()
  {
    if (this.XE == null) {
      return this.OS;
    }
    return this.XE.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.XE == null)
    {
      le.b(this.OS, paramCharArrayBuffer);
      return;
    }
    this.XE.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (this.XE == null) {
      return this.WE;
    }
    return this.XE.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (this.XE == null) {
      return this.WP;
    }
    return this.XE.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (this.XE == null) {
      return this.WD;
    }
    return this.XE.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (this.XE == null) {
      return this.WO;
    }
    return this.XE.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return this.Zk;
  }
  
  public Player getPlayer()
  {
    return this.XE;
  }
  
  public ParticipantResult getResult()
  {
    return this.aea;
  }
  
  public int getStatus()
  {
    return this.FP;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return this.adZ;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String le()
  {
    return this.Yi;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!hu())
    {
      ParticipantEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.Zk);
    paramParcel.writeString(this.OS);
    String str1;
    label39:
    String str2;
    label58:
    int i;
    label90:
    int j;
    if (this.WD == null)
    {
      str1 = null;
      paramParcel.writeString(str1);
      Uri localUri = this.WE;
      str2 = null;
      if (localUri != null) {
        break label144;
      }
      paramParcel.writeString(str2);
      paramParcel.writeInt(this.FP);
      paramParcel.writeString(this.Yi);
      if (!this.adZ) {
        break label156;
      }
      i = 1;
      paramParcel.writeInt(i);
      PlayerEntity localPlayerEntity = this.XE;
      j = 0;
      if (localPlayerEntity != null) {
        break label162;
      }
    }
    for (;;)
    {
      paramParcel.writeInt(j);
      if (this.XE == null) {
        break;
      }
      this.XE.writeToParcel(paramParcel, paramInt);
      return;
      str1 = this.WD.toString();
      break label39;
      label144:
      str2 = this.WE.toString();
      break label58;
      label156:
      i = 0;
      break label90;
      label162:
      j = 1;
    }
  }
  
  static final class ParticipantEntityCreatorCompat
    extends ParticipantEntityCreator
  {
    public ParticipantEntity cA(Parcel paramParcel)
    {
      boolean bool1 = true;
      if ((ParticipantEntity.b(ParticipantEntity.kD())) || (ParticipantEntity.bz(ParticipantEntity.class.getCanonicalName()))) {
        return super.cA(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      Uri localUri1;
      String str4;
      Uri localUri2;
      label67:
      int i;
      String str5;
      boolean bool2;
      if (str3 == null)
      {
        localUri1 = null;
        str4 = paramParcel.readString();
        if (str4 != null) {
          break label153;
        }
        localUri2 = null;
        i = paramParcel.readInt();
        str5 = paramParcel.readString();
        if (paramParcel.readInt() <= 0) {
          break label163;
        }
        bool2 = bool1;
        label89:
        if (paramParcel.readInt() <= 0) {
          break label169;
        }
        label96:
        if (!bool1) {
          break label174;
        }
      }
      label153:
      label163:
      label169:
      label174:
      for (PlayerEntity localPlayerEntity = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel);; localPlayerEntity = null)
      {
        return new ParticipantEntity(3, str1, str2, localUri1, localUri2, i, str5, bool2, localPlayerEntity, 7, null, null, null);
        localUri1 = Uri.parse(str3);
        break;
        localUri2 = Uri.parse(str4);
        break label67;
        bool2 = false;
        break label89;
        bool1 = false;
        break label96;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantEntity
 * JD-Core Version:    0.7.0.1
 */