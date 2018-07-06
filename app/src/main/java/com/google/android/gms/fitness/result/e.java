package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;

public class e
  implements Parcelable.Creator<ListSubscriptionsResult>
{
  static void a(ListSubscriptionsResult paramListSubscriptionsResult, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramListSubscriptionsResult.getSubscriptions(), false);
    b.c(paramParcel, 1000, paramListSubscriptionsResult.getVersionCode());
    b.a(paramParcel, 2, paramListSubscriptionsResult.getStatus(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public ListSubscriptionsResult ch(Parcel paramParcel)
  {
    Status localStatus = null;
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
        localArrayList = a.c(paramParcel, k, Subscription.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localStatus = (Status)a.a(paramParcel, k, Status.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new ListSubscriptionsResult(j, localArrayList, localStatus);
  }
  
  public ListSubscriptionsResult[] dC(int paramInt)
  {
    return new ListSubscriptionsResult[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.e
 * JD-Core Version:    0.7.0.1
 */