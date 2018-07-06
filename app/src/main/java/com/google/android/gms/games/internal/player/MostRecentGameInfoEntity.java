package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class MostRecentGameInfoEntity
  implements SafeParcelable, MostRecentGameInfo
{
  public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
  private final int CK;
  private final String acF;
  private final String acG;
  private final long acH;
  private final Uri acI;
  private final Uri acJ;
  private final Uri acK;
  
  MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    this.CK = paramInt;
    this.acF = paramString1;
    this.acG = paramString2;
    this.acH = paramLong;
    this.acI = paramUri1;
    this.acJ = paramUri2;
    this.acK = paramUri3;
  }
  
  public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo)
  {
    this.CK = 2;
    this.acF = paramMostRecentGameInfo.mw();
    this.acG = paramMostRecentGameInfo.mx();
    this.acH = paramMostRecentGameInfo.my();
    this.acI = paramMostRecentGameInfo.mz();
    this.acJ = paramMostRecentGameInfo.mA();
    this.acK = paramMostRecentGameInfo.mB();
  }
  
  static int a(MostRecentGameInfo paramMostRecentGameInfo)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = paramMostRecentGameInfo.mw();
    arrayOfObject[1] = paramMostRecentGameInfo.mx();
    arrayOfObject[2] = Long.valueOf(paramMostRecentGameInfo.my());
    arrayOfObject[3] = paramMostRecentGameInfo.mz();
    arrayOfObject[4] = paramMostRecentGameInfo.mA();
    arrayOfObject[5] = paramMostRecentGameInfo.mB();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(MostRecentGameInfo paramMostRecentGameInfo, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof MostRecentGameInfo)) {
      bool = false;
    }
    MostRecentGameInfo localMostRecentGameInfo;
    do
    {
      do
      {
        return bool;
      } while (paramMostRecentGameInfo == paramObject);
      localMostRecentGameInfo = (MostRecentGameInfo)paramObject;
    } while ((jv.equal(localMostRecentGameInfo.mw(), paramMostRecentGameInfo.mw())) && (jv.equal(localMostRecentGameInfo.mx(), paramMostRecentGameInfo.mx())) && (jv.equal(Long.valueOf(localMostRecentGameInfo.my()), Long.valueOf(paramMostRecentGameInfo.my()))) && (jv.equal(localMostRecentGameInfo.mz(), paramMostRecentGameInfo.mz())) && (jv.equal(localMostRecentGameInfo.mA(), paramMostRecentGameInfo.mA())) && (jv.equal(localMostRecentGameInfo.mB(), paramMostRecentGameInfo.mB())));
    return false;
  }
  
  static String b(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return jv.h(paramMostRecentGameInfo).a("GameId", paramMostRecentGameInfo.mw()).a("GameName", paramMostRecentGameInfo.mx()).a("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.my())).a("GameIconUri", paramMostRecentGameInfo.mz()).a("GameHiResUri", paramMostRecentGameInfo.mA()).a("GameFeaturedUri", paramMostRecentGameInfo.mB()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
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
  
  public Uri mA()
  {
    return this.acJ;
  }
  
  public Uri mB()
  {
    return this.acK;
  }
  
  public MostRecentGameInfo mC()
  {
    return this;
  }
  
  public String mw()
  {
    return this.acF;
  }
  
  public String mx()
  {
    return this.acG;
  }
  
  public long my()
  {
    return this.acH;
  }
  
  public Uri mz()
  {
    return this.acI;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    MostRecentGameInfoEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
 * JD-Core Version:    0.7.0.1
 */