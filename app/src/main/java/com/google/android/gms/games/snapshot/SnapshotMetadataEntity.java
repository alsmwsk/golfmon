package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;

public final class SnapshotMetadataEntity
  implements SafeParcelable, SnapshotMetadata
{
  public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
  private final int CK;
  private final String OH;
  private final String UO;
  private final String YB;
  private final GameEntity acs;
  private final Uri afd;
  private final PlayerEntity afg;
  private final String afh;
  private final long afi;
  private final long afj;
  private final float afk;
  private final String afl;
  private final boolean afm;
  
  SnapshotMetadataEntity(int paramInt, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, float paramFloat, String paramString5, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.acs = paramGameEntity;
    this.afg = paramPlayerEntity;
    this.YB = paramString1;
    this.afd = paramUri;
    this.afh = paramString2;
    this.afk = paramFloat;
    this.OH = paramString3;
    this.UO = paramString4;
    this.afi = paramLong1;
    this.afj = paramLong2;
    this.afl = paramString5;
    this.afm = paramBoolean;
  }
  
  public SnapshotMetadataEntity(SnapshotMetadata paramSnapshotMetadata)
  {
    this.CK = 4;
    this.acs = new GameEntity(paramSnapshotMetadata.getGame());
    this.afg = new PlayerEntity(paramSnapshotMetadata.getOwner());
    this.YB = paramSnapshotMetadata.getSnapshotId();
    this.afd = paramSnapshotMetadata.getCoverImageUri();
    this.afh = paramSnapshotMetadata.getCoverImageUrl();
    this.afk = paramSnapshotMetadata.getCoverImageAspectRatio();
    this.OH = paramSnapshotMetadata.getTitle();
    this.UO = paramSnapshotMetadata.getDescription();
    this.afi = paramSnapshotMetadata.getLastModifiedTimestamp();
    this.afj = paramSnapshotMetadata.getPlayedTime();
    this.afl = paramSnapshotMetadata.getUniqueName();
    this.afm = paramSnapshotMetadata.hasChangePending();
  }
  
  static int a(SnapshotMetadata paramSnapshotMetadata)
  {
    Object[] arrayOfObject = new Object[11];
    arrayOfObject[0] = paramSnapshotMetadata.getGame();
    arrayOfObject[1] = paramSnapshotMetadata.getOwner();
    arrayOfObject[2] = paramSnapshotMetadata.getSnapshotId();
    arrayOfObject[3] = paramSnapshotMetadata.getCoverImageUri();
    arrayOfObject[4] = Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio());
    arrayOfObject[5] = paramSnapshotMetadata.getTitle();
    arrayOfObject[6] = paramSnapshotMetadata.getDescription();
    arrayOfObject[7] = Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp());
    arrayOfObject[8] = Long.valueOf(paramSnapshotMetadata.getPlayedTime());
    arrayOfObject[9] = paramSnapshotMetadata.getUniqueName();
    arrayOfObject[10] = Boolean.valueOf(paramSnapshotMetadata.hasChangePending());
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(SnapshotMetadata paramSnapshotMetadata, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof SnapshotMetadata)) {
      bool = false;
    }
    SnapshotMetadata localSnapshotMetadata;
    do
    {
      do
      {
        return bool;
      } while (paramSnapshotMetadata == paramObject);
      localSnapshotMetadata = (SnapshotMetadata)paramObject;
    } while ((jv.equal(localSnapshotMetadata.getGame(), paramSnapshotMetadata.getGame())) && (jv.equal(localSnapshotMetadata.getOwner(), paramSnapshotMetadata.getOwner())) && (jv.equal(localSnapshotMetadata.getSnapshotId(), paramSnapshotMetadata.getSnapshotId())) && (jv.equal(localSnapshotMetadata.getCoverImageUri(), paramSnapshotMetadata.getCoverImageUri())) && (jv.equal(Float.valueOf(localSnapshotMetadata.getCoverImageAspectRatio()), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()))) && (jv.equal(localSnapshotMetadata.getTitle(), paramSnapshotMetadata.getTitle())) && (jv.equal(localSnapshotMetadata.getDescription(), paramSnapshotMetadata.getDescription())) && (jv.equal(Long.valueOf(localSnapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()))) && (jv.equal(Long.valueOf(localSnapshotMetadata.getPlayedTime()), Long.valueOf(paramSnapshotMetadata.getPlayedTime()))) && (jv.equal(localSnapshotMetadata.getUniqueName(), paramSnapshotMetadata.getUniqueName())) && (jv.equal(Boolean.valueOf(localSnapshotMetadata.hasChangePending()), Boolean.valueOf(paramSnapshotMetadata.hasChangePending()))));
    return false;
  }
  
  static String b(SnapshotMetadata paramSnapshotMetadata)
  {
    return jv.h(paramSnapshotMetadata).a("Game", paramSnapshotMetadata.getGame()).a("Owner", paramSnapshotMetadata.getOwner()).a("SnapshotId", paramSnapshotMetadata.getSnapshotId()).a("CoverImageUri", paramSnapshotMetadata.getCoverImageUri()).a("CoverImageUrl", paramSnapshotMetadata.getCoverImageUrl()).a("CoverImageAspectRatio", Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio())).a("Description", paramSnapshotMetadata.getDescription()).a("LastModifiedTimestamp", Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp())).a("PlayedTime", Long.valueOf(paramSnapshotMetadata.getPlayedTime())).a("UniqueName", paramSnapshotMetadata.getUniqueName()).a("ChangePending", Boolean.valueOf(paramSnapshotMetadata.hasChangePending())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public SnapshotMetadata freeze()
  {
    return this;
  }
  
  public float getCoverImageAspectRatio()
  {
    return this.afk;
  }
  
  public Uri getCoverImageUri()
  {
    return this.afd;
  }
  
  public String getCoverImageUrl()
  {
    return this.afh;
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.UO, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.acs;
  }
  
  public long getLastModifiedTimestamp()
  {
    return this.afi;
  }
  
  public Player getOwner()
  {
    return this.afg;
  }
  
  public long getPlayedTime()
  {
    return this.afj;
  }
  
  public String getSnapshotId()
  {
    return this.YB;
  }
  
  public String getTitle()
  {
    return this.OH;
  }
  
  public String getUniqueName()
  {
    return this.afl;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public boolean hasChangePending()
  {
    return this.afm;
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
    SnapshotMetadataEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataEntity
 * JD-Core Version:    0.7.0.1
 */