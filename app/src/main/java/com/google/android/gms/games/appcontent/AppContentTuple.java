package com.google.android.gms.games.appcontent;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface AppContentTuple
  extends Parcelable, Freezable<AppContentTuple>
{
  public abstract String getName();
  
  public abstract String getValue();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentTuple
 * JD-Core Version:    0.7.0.1
 */