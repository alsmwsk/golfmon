package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<Device>
{
  static void a(Device paramDevice, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramDevice.getManufacturer(), false);
    b.c(paramParcel, 1000, paramDevice.getVersionCode());
    b.a(paramParcel, 2, paramDevice.getModel(), false);
    b.a(paramParcel, 3, paramDevice.getVersion(), false);
    b.a(paramParcel, 4, paramDevice.jF(), false);
    b.c(paramParcel, 5, paramDevice.getType());
    b.c(paramParcel, 6, paramDevice.jC());
    b.H(paramParcel, i);
  }
  
  public Device bx(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int j = a.G(paramParcel);
    int k = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        str4 = a.o(paramParcel, n);
        break;
      case 1000: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        str3 = a.o(paramParcel, n);
        break;
      case 3: 
        str2 = a.o(paramParcel, n);
        break;
      case 4: 
        str1 = a.o(paramParcel, n);
        break;
      case 5: 
        k = a.g(paramParcel, n);
        break;
      case 6: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new Device(m, str4, str3, str2, str1, k, i);
  }
  
  public Device[] cQ(int paramInt)
  {
    return new Device[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.i
 * JD-Core Version:    0.7.0.1
 */