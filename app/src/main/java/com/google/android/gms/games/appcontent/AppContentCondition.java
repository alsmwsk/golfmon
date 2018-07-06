package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface AppContentCondition
  extends Parcelable, Freezable<AppContentCondition>
{
  public abstract String kT();
  
  public abstract String kU();
  
  public abstract String kV();
  
  public abstract Bundle kW();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentCondition
 * JD-Core Version:    0.7.0.1
 */