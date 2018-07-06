package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;
import java.util.ArrayList;

public class f
  implements Parcelable.Creator<SessionReadResult>
{
  static void a(SessionReadResult paramSessionReadResult, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramSessionReadResult.getSessions(), false);
    b.c(paramParcel, 1000, paramSessionReadResult.getVersionCode());
    b.c(paramParcel, 2, paramSessionReadResult.kv(), false);
    b.a(paramParcel, 3, paramSessionReadResult.getStatus(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public SessionReadResult ci(Parcel paramParcel)
  {
    Status localStatus = null;
    int i = a.G(paramParcel);
    int j = 0;
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList2 = a.c(paramParcel, k, Session.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList1 = a.c(paramParcel, k, q.CREATOR);
        break;
      case 3: 
        localStatus = (Status)a.a(paramParcel, k, Status.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new SessionReadResult(j, localArrayList2, localArrayList1, localStatus);
  }
  
  public SessionReadResult[] dD(int paramInt)
  {
    return new SessionReadResult[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.f
 * JD-Core Version:    0.7.0.1
 */