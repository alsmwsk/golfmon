package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class bf
  implements Parcelable.Creator<SetResourceParentsRequest>
{
  static void a(SetResourceParentsRequest paramSetResourceParentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramSetResourceParentsRequest.CK);
    b.a(paramParcel, 2, paramSetResourceParentsRequest.QW, paramInt, false);
    b.c(paramParcel, 3, paramSetResourceParentsRequest.QX, false);
    b.H(paramParcel, i);
  }
  
  public SetResourceParentsRequest aJ(Parcel paramParcel)
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
        DriveId localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
        m = j;
        localObject3 = localObject1;
        localObject4 = localDriveId;
        continue;
        localObject3 = a.c(paramParcel, k, DriveId.CREATOR);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new SetResourceParentsRequest(j, localObject2, localObject1);
  }
  
  public SetResourceParentsRequest[] bY(int paramInt)
  {
    return new SetResourceParentsRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.bf
 * JD-Core Version:    0.7.0.1
 */