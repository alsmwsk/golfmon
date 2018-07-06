package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class b
  implements SafeParcelable
{
  public static final Parcelable.Creator<b> CREATOR = new c();
  final int CK;
  public final ae axv;
  public final IntentFilter[] axw;
  
  b(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.CK = paramInt;
    if (paramIBinder != null) {}
    for (this.axv = ae.a.bY(paramIBinder);; this.axv = null)
    {
      this.axw = paramArrayOfIntentFilter;
      return;
    }
  }
  
  public b(bb parambb)
  {
    this.CK = 1;
    this.axv = parambb;
    this.axw = parambb.rs();
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
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.b
 * JD-Core Version:    0.7.0.1
 */