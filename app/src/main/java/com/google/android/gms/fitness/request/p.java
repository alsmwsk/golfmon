package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

public class p
  implements Parcelable.Creator<o>
{
  static void a(o paramo, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramo.getDataSource(), paramInt, false);
    b.c(paramParcel, 1000, paramo.getVersionCode());
    b.a(paramParcel, 2, paramo.getDataType(), paramInt, false);
    b.a(paramParcel, 3, paramo.kg(), false);
    b.c(paramParcel, 4, paramo.VX);
    b.c(paramParcel, 5, paramo.VY);
    b.a(paramParcel, 6, paramo.jI());
    b.a(paramParcel, 7, paramo.kd());
    b.a(paramParcel, 8, paramo.kb(), paramInt, false);
    b.a(paramParcel, 9, paramo.kc());
    b.c(paramParcel, 10, paramo.getAccuracyMode());
    b.c(paramParcel, 11, paramo.ke(), false);
    b.a(paramParcel, 12, paramo.kf());
    b.H(paramParcel, i);
  }
  
  public o bQ(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    DataSource localDataSource = null;
    DataType localDataType = null;
    IBinder localIBinder = null;
    int k = 0;
    int m = 0;
    long l1 = 0L;
    long l2 = 0L;
    PendingIntent localPendingIntent = null;
    long l3 = 0L;
    int n = 0;
    ArrayList localArrayList = null;
    long l4 = 0L;
    while (paramParcel.dataPosition() < i)
    {
      int i1 = a.F(paramParcel);
      switch (a.aH(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        localDataSource = (DataSource)a.a(paramParcel, i1, DataSource.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, i1);
        break;
      case 2: 
        localDataType = (DataType)a.a(paramParcel, i1, DataType.CREATOR);
        break;
      case 3: 
        localIBinder = a.p(paramParcel, i1);
        break;
      case 4: 
        k = a.g(paramParcel, i1);
        break;
      case 5: 
        m = a.g(paramParcel, i1);
        break;
      case 6: 
        l1 = a.i(paramParcel, i1);
        break;
      case 7: 
        l2 = a.i(paramParcel, i1);
        break;
      case 8: 
        localPendingIntent = (PendingIntent)a.a(paramParcel, i1, PendingIntent.CREATOR);
        break;
      case 9: 
        l3 = a.i(paramParcel, i1);
        break;
      case 10: 
        n = a.g(paramParcel, i1);
        break;
      case 11: 
        localArrayList = a.c(paramParcel, i1, LocationRequest.CREATOR);
        break;
      case 12: 
        l4 = a.i(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new o(j, localDataSource, localDataType, localIBinder, k, m, l1, l2, localPendingIntent, l3, n, localArrayList, l4);
  }
  
  public o[] dk(int paramInt)
  {
    return new o[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.p
 * JD-Core Version:    0.7.0.1
 */