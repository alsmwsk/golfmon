package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class GameBadgeEntity
  extends GamesDowngradeableSafeParcel
  implements GameBadge
{
  public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
  private final int CK;
  private int Gt;
  private String OH;
  private String UO;
  private Uri WD;
  
  GameBadgeEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, Uri paramUri)
  {
    this.CK = paramInt1;
    this.Gt = paramInt2;
    this.OH = paramString1;
    this.UO = paramString2;
    this.WD = paramUri;
  }
  
  public GameBadgeEntity(GameBadge paramGameBadge)
  {
    this.CK = 1;
    this.Gt = paramGameBadge.getType();
    this.OH = paramGameBadge.getTitle();
    this.UO = paramGameBadge.getDescription();
    this.WD = paramGameBadge.getIconImageUri();
  }
  
  static int a(GameBadge paramGameBadge)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(paramGameBadge.getType());
    arrayOfObject[1] = paramGameBadge.getTitle();
    arrayOfObject[2] = paramGameBadge.getDescription();
    arrayOfObject[3] = paramGameBadge.getIconImageUri();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(GameBadge paramGameBadge, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof GameBadge)) {
      bool = false;
    }
    GameBadge localGameBadge;
    do
    {
      do
      {
        return bool;
      } while (paramGameBadge == paramObject);
      localGameBadge = (GameBadge)paramObject;
    } while ((jv.equal(Integer.valueOf(localGameBadge.getType()), paramGameBadge.getTitle())) && (jv.equal(localGameBadge.getDescription(), paramGameBadge.getIconImageUri())));
    return false;
  }
  
  static String b(GameBadge paramGameBadge)
  {
    return jv.h(paramGameBadge).a("Type", Integer.valueOf(paramGameBadge.getType())).a("Title", paramGameBadge.getTitle()).a("Description", paramGameBadge.getDescription()).a("IconImageUri", paramGameBadge.getIconImageUri()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public Uri getIconImageUri()
  {
    return this.WD;
  }
  
  public String getTitle()
  {
    return this.OH;
  }
  
  public int getType()
  {
    return this.Gt;
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
  
  public GameBadge mk()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!hu())
    {
      GameBadgeEntityCreator.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(this.Gt);
    paramParcel.writeString(this.OH);
    paramParcel.writeString(this.UO);
    if (this.WD == null) {}
    for (String str = null;; str = this.WD.toString())
    {
      paramParcel.writeString(str);
      return;
    }
  }
  
  static final class GameBadgeEntityCreatorCompat
    extends GameBadgeEntityCreator
  {
    public GameBadgeEntity cv(Parcel paramParcel)
    {
      if ((GameBadgeEntity.b(GameBadgeEntity.kD())) || (GameBadgeEntity.bz(GameBadgeEntity.class.getCanonicalName()))) {
        return super.cv(paramParcel);
      }
      int i = paramParcel.readInt();
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      if (str3 == null) {}
      for (Uri localUri = null;; localUri = Uri.parse(str3)) {
        return new GameBadgeEntity(1, i, str1, str2, localUri);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameBadgeEntity
 * JD-Core Version:    0.7.0.1
 */