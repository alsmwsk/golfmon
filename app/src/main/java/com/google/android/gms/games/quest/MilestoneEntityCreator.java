package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class MilestoneEntityCreator
  implements Parcelable.Creator<MilestoneEntity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(MilestoneEntity paramMilestoneEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramMilestoneEntity.getMilestoneId(), false);
    b.c(paramParcel, 1000, paramMilestoneEntity.getVersionCode());
    b.a(paramParcel, 2, paramMilestoneEntity.getCurrentProgress());
    b.a(paramParcel, 3, paramMilestoneEntity.getTargetProgress());
    b.a(paramParcel, 4, paramMilestoneEntity.getCompletionRewardData(), false);
    b.c(paramParcel, 5, paramMilestoneEntity.getState());
    b.a(paramParcel, 6, paramMilestoneEntity.getEventId(), false);
    b.H(paramParcel, i);
  }
  
  public MilestoneEntity createFromParcel(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    String str1 = null;
    int j = a.G(paramParcel);
    byte[] arrayOfByte = null;
    long l2 = l1;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str2 = a.o(paramParcel, m);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        l2 = a.i(paramParcel, m);
        break;
      case 3: 
        l1 = a.i(paramParcel, m);
        break;
      case 4: 
        arrayOfByte = a.r(paramParcel, m);
        break;
      case 5: 
        i = a.g(paramParcel, m);
        break;
      case 6: 
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new MilestoneEntity(k, str2, l2, l1, arrayOfByte, i, str1);
  }
  
  public MilestoneEntity[] newArray(int paramInt)
  {
    return new MilestoneEntity[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.MilestoneEntityCreator
 * JD-Core Version:    0.7.0.1
 */