package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Subscription;

public class ag
  implements Parcelable.Creator<af>
{
  static void a(af paramaf, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramaf.kn(), paramInt, false);
    b.c(paramParcel, 1000, paramaf.getVersionCode());
    b.a(paramParcel, 2, paramaf.ko());
    b.H(paramParcel, i);
  }
  
  public af ca(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = a.G(paramParcel);
    Object localObject1 = null;
    int j = 0;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      boolean bool2;
      Object localObject2;
      int m;
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        bool2 = bool1;
        localObject2 = localObject1;
        m = j;
      }
      for (;;)
      {
        j = m;
        localObject1 = localObject2;
        bool1 = bool2;
        break;
        Subscription localSubscription = (Subscription)a.a(paramParcel, k, Subscription.CREATOR);
        m = j;
        bool2 = bool1;
        localObject2 = localSubscription;
        continue;
        int n = a.g(paramParcel, k);
        boolean bool3 = bool1;
        localObject2 = localObject1;
        m = n;
        bool2 = bool3;
        continue;
        bool2 = a.c(paramParcel, k);
        localObject2 = localObject1;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new af(j, localObject1, bool1);
  }
  
  public af[] dv(int paramInt)
  {
    return new af[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.ag
 * JD-Core Version:    0.7.0.1
 */