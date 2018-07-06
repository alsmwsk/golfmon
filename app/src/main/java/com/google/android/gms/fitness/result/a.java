package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<BleDevicesResult>
{
  static void a(BleDevicesResult paramBleDevicesResult, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramBleDevicesResult.getClaimedBleDevices(), false);
    b.c(paramParcel, 1000, paramBleDevicesResult.getVersionCode());
    b.a(paramParcel, 2, paramBleDevicesResult.getStatus(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public BleDevicesResult cd(Parcel paramParcel)
  {
    Status localStatus = null;
    int i = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, BleDevice.CREATOR);
        break;
      case 1000: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        localStatus = (Status)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Status.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new BleDevicesResult(j, localArrayList, localStatus);
  }
  
  public BleDevicesResult[] dy(int paramInt)
  {
    return new BleDevicesResult[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.a
 * JD-Core Version:    0.7.0.1
 */