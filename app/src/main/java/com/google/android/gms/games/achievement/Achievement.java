package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public abstract interface Achievement
  extends Parcelable, Freezable<Achievement>
{
  public static final int STATE_HIDDEN = 2;
  public static final int STATE_REVEALED = 1;
  public static final int STATE_UNLOCKED = 0;
  public static final int TYPE_INCREMENTAL = 1;
  public static final int TYPE_STANDARD;
  
  public abstract String getAchievementId();
  
  public abstract int getCurrentSteps();
  
  public abstract String getDescription();
  
  public abstract void getDescription(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract String getFormattedCurrentSteps();
  
  public abstract void getFormattedCurrentSteps(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract String getFormattedTotalSteps();
  
  public abstract void getFormattedTotalSteps(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract long getLastUpdatedTimestamp();
  
  public abstract String getName();
  
  public abstract void getName(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract Player getPlayer();
  
  public abstract Uri getRevealedImageUri();
  
  @Deprecated
  public abstract String getRevealedImageUrl();
  
  public abstract int getState();
  
  public abstract int getTotalSteps();
  
  public abstract int getType();
  
  public abstract Uri getUnlockedImageUri();
  
  @Deprecated
  public abstract String getUnlockedImageUrl();
  
  public abstract long getXpValue();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.achievement.Achievement
 * JD-Core Version:    0.7.0.1
 */