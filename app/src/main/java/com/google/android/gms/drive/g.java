package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g
  implements Parcelable.Creator<StorageStats>
{
  static void a(StorageStats paramStorageStats, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramStorageStats.CK);
    b.a(paramParcel, 2, paramStorageStats.OM);
    b.a(paramParcel, 3, paramStorageStats.ON);
    b.a(paramParcel, 4, paramStorageStats.OO);
    b.a(paramParcel, 5, paramStorageStats.OP);
    b.c(paramParcel, 6, paramStorageStats.OQ);
    b.H(paramParcel, i);
  }
  
  public StorageStats V(Parcel paramParcel)
  {
    int i = 0;
    long l1 = 0L;
    int j = a.G(paramParcel);
    long l2 = l1;
    long l3 = l1;
    long l4 = l1;
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
        k = a.g(paramParcel, m);
        break;
      case 2: 
        l4 = a.i(paramParcel, m);
        break;
      case 3: 
        l3 = a.i(paramParcel, m);
        break;
      case 4: 
        l2 = a.i(paramParcel, m);
        break;
      case 5: 
        l1 = a.i(paramParcel, m);
        break;
      case 6: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new StorageStats(k, l4, l3, l2, l1, i);
  }
  
  public StorageStats[] bd(int paramInt)
  {
    return new StorageStats[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.g
 * JD-Core Version:    0.7.0.1
 */