package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

public class SnapshotMetadataEntityCreator
  implements Parcelable.Creator<SnapshotMetadataEntity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(SnapshotMetadataEntity paramSnapshotMetadataEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramSnapshotMetadataEntity.getGame(), paramInt, false);
    b.c(paramParcel, 1000, paramSnapshotMetadataEntity.getVersionCode());
    b.a(paramParcel, 2, paramSnapshotMetadataEntity.getOwner(), paramInt, false);
    b.a(paramParcel, 3, paramSnapshotMetadataEntity.getSnapshotId(), false);
    b.a(paramParcel, 5, paramSnapshotMetadataEntity.getCoverImageUri(), paramInt, false);
    b.a(paramParcel, 6, paramSnapshotMetadataEntity.getCoverImageUrl(), false);
    b.a(paramParcel, 7, paramSnapshotMetadataEntity.getTitle(), false);
    b.a(paramParcel, 8, paramSnapshotMetadataEntity.getDescription(), false);
    b.a(paramParcel, 9, paramSnapshotMetadataEntity.getLastModifiedTimestamp());
    b.a(paramParcel, 10, paramSnapshotMetadataEntity.getPlayedTime());
    b.a(paramParcel, 11, paramSnapshotMetadataEntity.getCoverImageAspectRatio());
    b.a(paramParcel, 12, paramSnapshotMetadataEntity.getUniqueName(), false);
    b.a(paramParcel, 13, paramSnapshotMetadataEntity.hasChangePending());
    b.H(paramParcel, i);
  }
  
  public SnapshotMetadataEntity createFromParcel(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    GameEntity localGameEntity = null;
    PlayerEntity localPlayerEntity = null;
    String str1 = null;
    Uri localUri = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    long l1 = 0L;
    long l2 = 0L;
    float f = 0.0F;
    String str5 = null;
    boolean bool = false;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localGameEntity = (GameEntity)a.a(paramParcel, k, GameEntity.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localPlayerEntity = (PlayerEntity)a.a(paramParcel, k, PlayerEntity.CREATOR);
        break;
      case 3: 
        str1 = a.o(paramParcel, k);
        break;
      case 5: 
        localUri = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 6: 
        str2 = a.o(paramParcel, k);
        break;
      case 7: 
        str3 = a.o(paramParcel, k);
        break;
      case 8: 
        str4 = a.o(paramParcel, k);
        break;
      case 9: 
        l1 = a.i(paramParcel, k);
        break;
      case 10: 
        l2 = a.i(paramParcel, k);
        break;
      case 11: 
        f = a.l(paramParcel, k);
        break;
      case 12: 
        str5 = a.o(paramParcel, k);
        break;
      case 13: 
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new SnapshotMetadataEntity(j, localGameEntity, localPlayerEntity, str1, localUri, str2, str3, str4, l1, l2, f, str5, bool);
  }
  
  public SnapshotMetadataEntity[] newArray(int paramInt)
  {
    return new SnapshotMetadataEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataEntityCreator
 * JD-Core Version:    0.7.0.1
 */