package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ar
  implements SafeParcelable
{
  public static final Parcelable.Creator<ar> CREATOR = new as();
  final int CK;
  public final ae axv;
  
  ar(int paramInt, IBinder paramIBinder)
  {
    this.CK = paramInt;
    if (paramIBinder != null)
    {
      this.axv = ae.a.bY(paramIBinder);
      return;
    }
    this.axv = null;
  }
  
  public ar(ae paramae)
  {
    this.CK = 1;
    this.axv = paramae;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  IBinder rm()
  {
    if (this.axv == null) {
      return null;
    }
    return this.axv.asBinder();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    as.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ar
 * JD-Core Version:    0.7.0.1
 */