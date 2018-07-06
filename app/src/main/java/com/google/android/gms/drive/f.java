package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class f
  implements Parcelable.Creator<RealtimeDocumentSyncRequest>
{
  static void a(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramRealtimeDocumentSyncRequest.CK);
    b.b(paramParcel, 2, paramRealtimeDocumentSyncRequest.OK, false);
    b.b(paramParcel, 3, paramRealtimeDocumentSyncRequest.OL, false);
    b.H(paramParcel, i);
  }
  
  public RealtimeDocumentSyncRequest U(Parcel paramParcel)
  {
    ArrayList localArrayList1 = null;
    int i = a.G(paramParcel);
    int j = 0;
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
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList2 = a.C(paramParcel, k);
        break;
      case 3: 
        localArrayList1 = a.C(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new RealtimeDocumentSyncRequest(j, localArrayList2, localArrayList1);
  }
  
  public RealtimeDocumentSyncRequest[] bc(int paramInt)
  {
    return new RealtimeDocumentSyncRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.f
 * JD-Core Version:    0.7.0.1
 */