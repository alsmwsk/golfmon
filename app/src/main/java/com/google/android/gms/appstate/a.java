package com.google.android.gms.appstate;

import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class a
  implements AppState
{
  private final int DK;
  private final String DL;
  private final byte[] DM;
  private final boolean DN;
  private final String DO;
  private final byte[] DP;
  
  public a(AppState paramAppState)
  {
    this.DK = paramAppState.getKey();
    this.DL = paramAppState.getLocalVersion();
    this.DM = paramAppState.getLocalData();
    this.DN = paramAppState.hasConflict();
    this.DO = paramAppState.getConflictVersion();
    this.DP = paramAppState.getConflictData();
  }
  
  static int a(AppState paramAppState)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(paramAppState.getKey());
    arrayOfObject[1] = paramAppState.getLocalVersion();
    arrayOfObject[2] = paramAppState.getLocalData();
    arrayOfObject[3] = Boolean.valueOf(paramAppState.hasConflict());
    arrayOfObject[4] = paramAppState.getConflictVersion();
    arrayOfObject[5] = paramAppState.getConflictData();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(AppState paramAppState, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof AppState)) {
      bool = false;
    }
    AppState localAppState;
    do
    {
      do
      {
        return bool;
      } while (paramAppState == paramObject);
      localAppState = (AppState)paramObject;
    } while ((jv.equal(Integer.valueOf(localAppState.getKey()), Integer.valueOf(paramAppState.getKey()))) && (jv.equal(localAppState.getLocalVersion(), paramAppState.getLocalVersion())) && (jv.equal(localAppState.getLocalData(), paramAppState.getLocalData())) && (jv.equal(Boolean.valueOf(localAppState.hasConflict()), Boolean.valueOf(paramAppState.hasConflict()))) && (jv.equal(localAppState.getConflictVersion(), paramAppState.getConflictVersion())) && (jv.equal(localAppState.getConflictData(), paramAppState.getConflictData())));
    return false;
  }
  
  static String b(AppState paramAppState)
  {
    return jv.h(paramAppState).a("Key", Integer.valueOf(paramAppState.getKey())).a("LocalVersion", paramAppState.getLocalVersion()).a("LocalData", paramAppState.getLocalData()).a("HasConflict", Boolean.valueOf(paramAppState.hasConflict())).a("ConflictVersion", paramAppState.getConflictVersion()).a("ConflictData", paramAppState.getConflictData()).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public AppState fJ()
  {
    return this;
  }
  
  public byte[] getConflictData()
  {
    return this.DP;
  }
  
  public String getConflictVersion()
  {
    return this.DO;
  }
  
  public int getKey()
  {
    return this.DK;
  }
  
  public byte[] getLocalData()
  {
    return this.DM;
  }
  
  public String getLocalVersion()
  {
    return this.DL;
  }
  
  public boolean hasConflict()
  {
    return this.DN;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appstate.a
 * JD-Core Version:    0.7.0.1
 */