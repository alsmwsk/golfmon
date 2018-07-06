package com.google.android.gms.appstate;

import com.google.android.gms.common.data.Freezable;

@Deprecated
public abstract interface AppState
  extends Freezable<AppState>
{
  public abstract byte[] getConflictData();
  
  public abstract String getConflictVersion();
  
  public abstract int getKey();
  
  public abstract byte[] getLocalData();
  
  public abstract String getLocalVersion();
  
  public abstract boolean hasConflict();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appstate.AppState
 * JD-Core Version:    0.7.0.1
 */