package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class MostRecentGameInfoRef
  extends d
  implements MostRecentGameInfo
{
  private final PlayerColumnNames Xv;
  
  public MostRecentGameInfoRef(DataHolder paramDataHolder, int paramInt, PlayerColumnNames paramPlayerColumnNames)
  {
    super(paramDataHolder, paramInt);
    this.Xv = paramPlayerColumnNames;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return MostRecentGameInfoEntity.a(this, paramObject);
  }
  
  public int hashCode()
  {
    return MostRecentGameInfoEntity.a(this);
  }
  
  public Uri mA()
  {
    return aR(this.Xv.adi);
  }
  
  public Uri mB()
  {
    return aR(this.Xv.adj);
  }
  
  public MostRecentGameInfo mC()
  {
    return new MostRecentGameInfoEntity(this);
  }
  
  public String mw()
  {
    return getString(this.Xv.ade);
  }
  
  public String mx()
  {
    return getString(this.Xv.adf);
  }
  
  public long my()
  {
    return getLong(this.Xv.adg);
  }
  
  public Uri mz()
  {
    return aR(this.Xv.adh);
  }
  
  public String toString()
  {
    return MostRecentGameInfoEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MostRecentGameInfoEntity)mC()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfoRef
 * JD-Core Version:    0.7.0.1
 */