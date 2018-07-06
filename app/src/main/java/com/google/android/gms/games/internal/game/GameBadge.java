package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface GameBadge
  extends Parcelable, Freezable<GameBadge>
{
  public abstract String getDescription();
  
  public abstract Uri getIconImageUri();
  
  public abstract String getTitle();
  
  public abstract int getType();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameBadge
 * JD-Core Version:    0.7.0.1
 */