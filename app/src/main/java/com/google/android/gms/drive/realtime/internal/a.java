package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<BeginCompoundOperationRequest>
{
  static void a(BeginCompoundOperationRequest paramBeginCompoundOperationRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramBeginCompoundOperationRequest.CK);
    b.a(paramParcel, 2, paramBeginCompoundOperationRequest.SF);
    b.a(paramParcel, 3, paramBeginCompoundOperationRequest.mName, false);
    b.a(paramParcel, 4, paramBeginCompoundOperationRequest.SG);
    b.H(paramParcel, i);
  }
  
  public BeginCompoundOperationRequest bc(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    String str = null;
    boolean bool2 = true;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        bool1 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
        break;
      case 3: 
        str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 4: 
        bool2 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new BeginCompoundOperationRequest(j, bool1, str, bool2);
  }
  
  public BeginCompoundOperationRequest[] cr(int paramInt)
  {
    return new BeginCompoundOperationRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.a
 * JD-Core Version:    0.7.0.1
 */