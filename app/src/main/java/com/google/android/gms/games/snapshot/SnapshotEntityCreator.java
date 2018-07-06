package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class SnapshotEntityCreator
  implements Parcelable.Creator<SnapshotEntity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(SnapshotEntity paramSnapshotEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramSnapshotEntity.getMetadata(), paramInt, false);
    b.c(paramParcel, 1000, paramSnapshotEntity.getVersionCode());
    b.a(paramParcel, 3, paramSnapshotEntity.getSnapshotContents(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public SnapshotEntity createFromParcel(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    Object localObject2 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      Object localObject3;
      Object localObject4;
      int m;
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        localObject3 = localObject1;
        localObject4 = localObject2;
        m = j;
      }
      for (;;)
      {
        j = m;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        SnapshotMetadataEntity localSnapshotMetadataEntity = (SnapshotMetadataEntity)a.a(paramParcel, k, SnapshotMetadataEntity.CREATOR);
        m = j;
        localObject3 = localObject1;
        localObject4 = localSnapshotMetadataEntity;
        continue;
        int n = a.g(paramParcel, k);
        Object localObject5 = localObject1;
        localObject4 = localObject2;
        m = n;
        localObject3 = localObject5;
        continue;
        localObject3 = (SnapshotContentsEntity)a.a(paramParcel, k, SnapshotContentsEntity.CREATOR);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new SnapshotEntity(j, localObject2, localObject1);
  }
  
  public SnapshotEntity[] newArray(int paramInt)
  {
    return new SnapshotEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotEntityCreator
 * JD-Core Version:    0.7.0.1
 */