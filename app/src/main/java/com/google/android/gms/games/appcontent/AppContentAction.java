package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public abstract interface AppContentAction
  extends Parcelable, Freezable<AppContentAction>
{
  public abstract Bundle getExtras();
  
  public abstract String getLabel();
  
  public abstract String getType();
  
  public abstract List<AppContentCondition> kH();
  
  public abstract String kI();
  
  public abstract String kJ();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentAction
 * JD-Core Version:    0.7.0.1
 */