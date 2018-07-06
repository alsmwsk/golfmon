package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator
  implements Parcelable.Creator<GameRequestCluster>
{
  static void a(GameRequestCluster paramGameRequestCluster, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramGameRequestCluster.mD(), false);
    b.c(paramParcel, 1000, paramGameRequestCluster.getVersionCode());
    b.H(paramParcel, i);
  }
  
  public GameRequestCluster cy(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, k, GameRequestEntity.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new GameRequestCluster(j, localArrayList);
  }
  
  public GameRequestCluster[] ej(int paramInt)
  {
    return new GameRequestCluster[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.GameRequestClusterCreator
 * JD-Core Version:    0.7.0.1
 */