package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator
  implements Parcelable.Creator<RoomEntity>
{
  static void a(RoomEntity paramRoomEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramRoomEntity.getRoomId(), false);
    b.c(paramParcel, 1000, paramRoomEntity.getVersionCode());
    b.a(paramParcel, 2, paramRoomEntity.getCreatorId(), false);
    b.a(paramParcel, 3, paramRoomEntity.getCreationTimestamp());
    b.c(paramParcel, 4, paramRoomEntity.getStatus());
    b.a(paramParcel, 5, paramRoomEntity.getDescription(), false);
    b.c(paramParcel, 6, paramRoomEntity.getVariant());
    b.a(paramParcel, 7, paramRoomEntity.getAutoMatchCriteria(), false);
    b.c(paramParcel, 8, paramRoomEntity.getParticipants(), false);
    b.c(paramParcel, 9, paramRoomEntity.getAutoMatchWaitEstimateSeconds());
    b.H(paramParcel, i);
  }
  
  public RoomEntity cC(Parcel paramParcel)
  {
    int i = 0;
    ArrayList localArrayList = null;
    int j = a.G(paramParcel);
    long l = 0L;
    Bundle localBundle = null;
    int k = 0;
    String str1 = null;
    int m = 0;
    String str2 = null;
    String str3 = null;
    int n = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i1 = a.F(paramParcel);
      switch (a.aH(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        str3 = a.o(paramParcel, i1);
        break;
      case 1000: 
        n = a.g(paramParcel, i1);
        break;
      case 2: 
        str2 = a.o(paramParcel, i1);
        break;
      case 3: 
        l = a.i(paramParcel, i1);
        break;
      case 4: 
        m = a.g(paramParcel, i1);
        break;
      case 5: 
        str1 = a.o(paramParcel, i1);
        break;
      case 6: 
        k = a.g(paramParcel, i1);
        break;
      case 7: 
        localBundle = a.q(paramParcel, i1);
        break;
      case 8: 
        localArrayList = a.c(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 9: 
        i = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new RoomEntity(n, str3, str2, l, m, str1, k, localBundle, localArrayList, i);
  }
  
  public RoomEntity[] eo(int paramInt)
  {
    return new RoomEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomEntityCreator
 * JD-Core Version:    0.7.0.1
 */