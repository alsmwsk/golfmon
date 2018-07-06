package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;

public class EventEntityCreator
  implements Parcelable.Creator<EventEntity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(EventEntity paramEventEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramEventEntity.getEventId(), false);
    b.c(paramParcel, 1000, paramEventEntity.getVersionCode());
    b.a(paramParcel, 2, paramEventEntity.getName(), false);
    b.a(paramParcel, 3, paramEventEntity.getDescription(), false);
    b.a(paramParcel, 4, paramEventEntity.getIconImageUri(), paramInt, false);
    b.a(paramParcel, 5, paramEventEntity.getIconImageUrl(), false);
    b.a(paramParcel, 6, paramEventEntity.getPlayer(), paramInt, false);
    b.a(paramParcel, 7, paramEventEntity.getValue());
    b.a(paramParcel, 8, paramEventEntity.getFormattedValue(), false);
    b.a(paramParcel, 9, paramEventEntity.isVisible());
    b.H(paramParcel, i);
  }
  
  public EventEntity createFromParcel(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int i = a.G(paramParcel);
    long l = 0L;
    PlayerEntity localPlayerEntity = null;
    String str2 = null;
    Uri localUri = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
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
        str5 = a.o(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str4 = a.o(paramParcel, k);
        break;
      case 3: 
        str3 = a.o(paramParcel, k);
        break;
      case 4: 
        localUri = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 5: 
        str2 = a.o(paramParcel, k);
        break;
      case 6: 
        localPlayerEntity = (PlayerEntity)a.a(paramParcel, k, PlayerEntity.CREATOR);
        break;
      case 7: 
        l = a.i(paramParcel, k);
        break;
      case 8: 
        str1 = a.o(paramParcel, k);
        break;
      case 9: 
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new EventEntity(j, str5, str4, str3, localUri, str2, localPlayerEntity, l, str1, bool);
  }
  
  public EventEntity[] newArray(int paramInt)
  {
    return new EventEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.event.EventEntityCreator
 * JD-Core Version:    0.7.0.1
 */