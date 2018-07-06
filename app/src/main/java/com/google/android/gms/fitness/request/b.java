package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;

public class b
  implements SafeParcelable
{
  public static final Parcelable.Creator<b> CREATOR = new c();
  private final int CK;
  private final String VF;
  private final BleDevice VG;
  
  b(int paramInt, String paramString, BleDevice paramBleDevice)
  {
    this.CK = paramInt;
    this.VF = paramString;
    this.VG = paramBleDevice;
  }
  
  public b(BleDevice paramBleDevice)
  {
    this(2, paramBleDevice.getAddress(), paramBleDevice);
  }
  
  public b(String paramString)
  {
    this(2, paramString, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDeviceAddress()
  {
    return this.VF;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public BleDevice jQ()
  {
    return this.VG;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.VF;
    arrayOfObject[1] = this.VG;
    return String.format("ClaimBleDeviceRequest{%s %s}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.b
 * JD-Core Version:    0.7.0.1
 */