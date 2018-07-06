package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ConnectionInfoCreator
  implements Parcelable.Creator<ConnectionInfo>
{
  static void a(ConnectionInfo paramConnectionInfo, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramConnectionInfo.le(), false);
    b.c(paramParcel, 1000, paramConnectionInfo.getVersionCode());
    b.c(paramParcel, 2, paramConnectionInfo.lf());
    b.H(paramParcel, i);
  }
  
  public ConnectionInfo ct(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    String str = null;
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
        str = a.o(paramParcel, m);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ConnectionInfo(k, str, i);
  }
  
  public ConnectionInfo[] dR(int paramInt)
  {
    return new ConnectionInfo[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.ConnectionInfoCreator
 * JD-Core Version:    0.7.0.1
 */