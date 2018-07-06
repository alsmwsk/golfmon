package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class l
  implements SafeParcelable
{
  public static final Parcelable.Creator<l> CREATOR = new m();
  private final int CK;
  long awU;
  long awV;
  
  l()
  {
    this.CK = 1;
  }
  
  l(int paramInt, long paramLong1, long paramLong2)
  {
    this.CK = paramInt;
    this.awU = paramLong1;
    this.awV = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.l
 * JD-Core Version:    0.7.0.1
 */