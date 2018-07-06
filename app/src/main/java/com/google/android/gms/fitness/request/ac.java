package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class ac
  implements Parcelable.Creator<StartBleScanRequest>
{
  static void a(StartBleScanRequest paramStartBleScanRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramStartBleScanRequest.getDataTypes(), false);
    b.c(paramParcel, 1000, paramStartBleScanRequest.getVersionCode());
    b.a(paramParcel, 2, paramStartBleScanRequest.km(), false);
    b.c(paramParcel, 3, paramStartBleScanRequest.getTimeoutSecs());
    b.H(paramParcel, i);
  }
  
  public StartBleScanRequest bY(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int i = 0;
    int j = a.G(paramParcel);
    ArrayList localArrayList = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, m, DataType.CREATOR);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        localIBinder = a.p(paramParcel, m);
        break;
      case 3: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new StartBleScanRequest(k, localArrayList, localIBinder, i);
  }
  
  public StartBleScanRequest[] dt(int paramInt)
  {
    return new StartBleScanRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.ac
 * JD-Core Version:    0.7.0.1
 */