package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;

public class aq
  implements Parcelable.Creator<OnEventResponse>
{
  static void a(OnEventResponse paramOnEventResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOnEventResponse.CK);
    b.c(paramParcel, 2, paramOnEventResponse.Pm);
    b.a(paramParcel, 3, paramOnEventResponse.QO, paramInt, false);
    b.a(paramParcel, 5, paramOnEventResponse.QP, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public OnEventResponse av(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = 0;
    int j = a.G(paramParcel);
    Object localObject2 = null;
    int k = 0;
    if (paramParcel.dataPosition() < j)
    {
      int m = a.F(paramParcel);
      Object localObject3;
      Object localObject4;
      int n;
      int i1;
      switch (a.aH(m))
      {
      case 4: 
      default: 
        a.b(paramParcel, m);
        localObject3 = localObject1;
        localObject4 = localObject2;
        n = i;
        i1 = k;
      }
      for (;;)
      {
        k = i1;
        i = n;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        int i3 = a.g(paramParcel, m);
        Object localObject7 = localObject1;
        localObject4 = localObject2;
        n = i;
        i1 = i3;
        localObject3 = localObject7;
        continue;
        int i2 = a.g(paramParcel, m);
        i1 = k;
        Object localObject6 = localObject2;
        n = i2;
        localObject3 = localObject1;
        localObject4 = localObject6;
        continue;
        ChangeEvent localChangeEvent = (ChangeEvent)a.a(paramParcel, m, ChangeEvent.CREATOR);
        n = i;
        i1 = k;
        Object localObject5 = localObject1;
        localObject4 = localChangeEvent;
        localObject3 = localObject5;
        continue;
        localObject3 = (CompletionEvent)a.a(paramParcel, m, CompletionEvent.CREATOR);
        localObject4 = localObject2;
        n = i;
        i1 = k;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OnEventResponse(k, i, localObject2, localObject1);
  }
  
  public OnEventResponse[] bK(int paramInt)
  {
    return new OnEventResponse[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.aq
 * JD-Core Version:    0.7.0.1
 */