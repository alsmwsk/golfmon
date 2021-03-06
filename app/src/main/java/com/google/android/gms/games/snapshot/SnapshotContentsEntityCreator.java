package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class SnapshotContentsEntityCreator
  implements Parcelable.Creator<SnapshotContentsEntity>
{
  static void a(SnapshotContentsEntity paramSnapshotContentsEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramSnapshotContentsEntity.ir(), paramInt, false);
    b.c(paramParcel, 1000, paramSnapshotContentsEntity.getVersionCode());
    b.H(paramParcel, i);
  }
  
  public SnapshotContentsEntity cD(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    Contents localContents = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new SnapshotContentsEntity(j, localContents);
  }
  
  public SnapshotContentsEntity[] eq(int paramInt)
  {
    return new SnapshotContentsEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotContentsEntityCreator
 * JD-Core Version:    0.7.0.1
 */