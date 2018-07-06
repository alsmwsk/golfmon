package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats
  implements SafeParcelable
{
  public static final Parcelable.Creator<StorageStats> CREATOR = new g();
  final int CK;
  final long OM;
  final long ON;
  final long OO;
  final long OP;
  final int OQ;
  
  StorageStats(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    this.CK = paramInt1;
    this.OM = paramLong1;
    this.ON = paramLong2;
    this.OO = paramLong3;
    this.OP = paramLong4;
    this.OQ = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.StorageStats
 * JD-Core Version:    0.7.0.1
 */