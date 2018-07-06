package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hn
  implements Parcelable.Creator<hl.b>
{
  static void a(hl.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1000, paramb.CK);
    b.a(paramParcel, 1, paramb.Dd, paramInt, false);
    b.c(paramParcel, 2, paramb.De, false);
    b.H(paramParcel, i);
  }
  
  public hl.b[] O(int paramInt)
  {
    return new hl.b[paramInt];
  }
  
  public hl.b q(Parcel paramParcel)
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
        int n = a.g(paramParcel, k);
        Object localObject5 = localObject1;
        localObject4 = localObject2;
        m = n;
        localObject3 = localObject5;
        continue;
        Status localStatus = (Status)a.a(paramParcel, k, Status.CREATOR);
        m = j;
        localObject3 = localObject1;
        localObject4 = localStatus;
        continue;
        localObject3 = a.c(paramParcel, k, hr.CREATOR);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new hl.b(j, localObject2, localObject1);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hn
 * JD-Core Version:    0.7.0.1
 */