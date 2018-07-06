package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator<PutDataRequest>
{
  static void a(PutDataRequest paramPutDataRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramPutDataRequest.CK);
    b.a(paramParcel, 2, paramPutDataRequest.getUri(), paramInt, false);
    b.a(paramParcel, 4, paramPutDataRequest.rk(), false);
    b.a(paramParcel, 5, paramPutDataRequest.getData(), false);
    b.H(paramParcel, i);
  }
  
  public PutDataRequest en(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      Object localObject4;
      Object localObject5;
      Object localObject6;
      int m;
      switch (a.aH(k))
      {
      case 3: 
      default: 
        a.b(paramParcel, k);
        localObject4 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = j;
      }
      for (;;)
      {
        j = m;
        localObject3 = localObject6;
        localObject2 = localObject5;
        localObject1 = localObject4;
        break;
        int n = a.g(paramParcel, k);
        Object localObject9 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = n;
        localObject4 = localObject9;
        continue;
        Uri localUri = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        m = j;
        Object localObject8 = localObject2;
        localObject6 = localUri;
        localObject4 = localObject1;
        localObject5 = localObject8;
        continue;
        Bundle localBundle = a.q(paramParcel, k);
        localObject6 = localObject3;
        m = j;
        Object localObject7 = localObject1;
        localObject5 = localBundle;
        localObject4 = localObject7;
        continue;
        localObject4 = a.r(paramParcel, k);
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new PutDataRequest(j, localObject3, localObject2, localObject1);
  }
  
  public PutDataRequest[] gw(int paramInt)
  {
    return new PutDataRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.e
 * JD-Core Version:    0.7.0.1
 */