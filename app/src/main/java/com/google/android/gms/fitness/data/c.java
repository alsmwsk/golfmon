package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class c
  implements Parcelable.Creator<BleDevice>
{
  static void a(BleDevice paramBleDevice, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramBleDevice.getAddress(), false);
    b.c(paramParcel, 1000, paramBleDevice.getVersionCode());
    b.a(paramParcel, 2, paramBleDevice.getName(), false);
    b.b(paramParcel, 3, paramBleDevice.getSupportedProfiles(), false);
    b.c(paramParcel, 4, paramBleDevice.getDataTypes(), false);
    b.H(paramParcel, i);
  }
  
  public BleDevice br(Parcel paramParcel)
  {
    ArrayList localArrayList1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    ArrayList localArrayList2 = null;
    String str1 = null;
    String str2 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str2 = a.o(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        localArrayList2 = a.C(paramParcel, k);
        break;
      case 4: 
        localArrayList1 = a.c(paramParcel, k, DataType.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new BleDevice(j, str2, str1, localArrayList2, localArrayList1);
  }
  
  public BleDevice[] cI(int paramInt)
  {
    return new BleDevice[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.c
 * JD-Core Version:    0.7.0.1
 */