package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class g
  implements Parcelable.Creator<CloseContentsRequest>
{
  static void a(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramCloseContentsRequest.CK);
    b.a(paramParcel, 2, paramCloseContentsRequest.Pr, paramInt, false);
    b.a(paramParcel, 3, paramCloseContentsRequest.Pt, false);
    b.H(paramParcel, i);
  }
  
  public CloseContentsRequest ae(Parcel paramParcel)
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
        Contents localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
        m = j;
        localObject3 = localObject1;
        localObject4 = localContents;
        continue;
        localObject3 = a.d(paramParcel, k);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new CloseContentsRequest(j, localObject2, localObject1);
  }
  
  public CloseContentsRequest[] bo(int paramInt)
  {
    return new CloseContentsRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.g
 * JD-Core Version:    0.7.0.1
 */