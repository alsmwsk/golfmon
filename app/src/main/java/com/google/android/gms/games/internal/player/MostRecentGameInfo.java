package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface MostRecentGameInfo
  extends Parcelable, Freezable<MostRecentGameInfo>
{
  public abstract Uri mA();
  
  public abstract Uri mB();
  
  public abstract String mw();
  
  public abstract String mx();
  
  public abstract long my();
  
  public abstract Uri mz();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfo
 * JD-Core Version:    0.7.0.1
 */