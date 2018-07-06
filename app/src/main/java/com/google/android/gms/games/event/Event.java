package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public abstract interface Event
  extends Parcelable, Freezable<Event>
{
  public abstract String getDescription();
  
  public abstract void getDescription(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract String getEventId();
  
  public abstract String getFormattedValue();
  
  public abstract void getFormattedValue(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract Uri getIconImageUri();
  
  @Deprecated
  public abstract String getIconImageUrl();
  
  public abstract String getName();
  
  public abstract void getName(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract Player getPlayer();
  
  public abstract long getValue();
  
  public abstract boolean isVisible();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.event.Event
 * JD-Core Version:    0.7.0.1
 */