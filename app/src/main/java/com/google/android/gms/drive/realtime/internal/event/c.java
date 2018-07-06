package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class c
  implements Parcelable.Creator<ParcelableEventList>
{
  static void a(ParcelableEventList paramParcelableEventList, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramParcelableEventList.CK);
    b.c(paramParcel, 2, paramParcelableEventList.mp, false);
    b.a(paramParcel, 3, paramParcelableEventList.Tb, paramInt, false);
    b.a(paramParcel, 4, paramParcelableEventList.Tc);
    b.b(paramParcel, 5, paramParcelableEventList.Td, false);
    b.H(paramParcel, i);
  }
  
  public ParcelableEventList bi(Parcel paramParcel)
  {
    boolean bool = false;
    ArrayList localArrayList1 = null;
    int i = a.G(paramParcel);
    DataHolder localDataHolder = null;
    ArrayList localArrayList2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList2 = a.c(paramParcel, k, ParcelableEvent.CREATOR);
        break;
      case 3: 
        localDataHolder = (DataHolder)a.a(paramParcel, k, DataHolder.CREATOR);
        break;
      case 4: 
        bool = a.c(paramParcel, k);
        break;
      case 5: 
        localArrayList1 = a.C(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new ParcelableEventList(j, localArrayList2, localDataHolder, bool, localArrayList1);
  }
  
  public ParcelableEventList[] cy(int paramInt)
  {
    return new ParcelableEventList[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.c
 * JD-Core Version:    0.7.0.1
 */