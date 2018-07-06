package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface Snapshot
  extends Parcelable, Freezable<Snapshot>
{
  public abstract SnapshotMetadata getMetadata();
  
  public abstract SnapshotContents getSnapshotContents();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.Snapshot
 * JD-Core Version:    0.7.0.1
 */