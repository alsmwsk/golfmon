package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.ls;
import java.util.Collections;
import java.util.List;

public class BleDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<BleDevice> CREATOR = new c();
  private final int CK;
  private final String TW;
  private final List<String> TX;
  private final List<DataType> TY;
  private final String mName;
  
  BleDevice(int paramInt, String paramString1, String paramString2, List<String> paramList, List<DataType> paramList1)
  {
    this.CK = paramInt;
    this.TW = paramString1;
    this.mName = paramString2;
    this.TX = Collections.unmodifiableList(paramList);
    this.TY = Collections.unmodifiableList(paramList1);
  }
  
  private boolean a(BleDevice paramBleDevice)
  {
    return (this.mName.equals(paramBleDevice.mName)) && (this.TW.equals(paramBleDevice.TW)) && (ls.a(paramBleDevice.TX, this.TX)) && (ls.a(this.TY, paramBleDevice.TY));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof BleDevice)) && (a((BleDevice)paramObject)));
  }
  
  public String getAddress()
  {
    return this.TW;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.TY;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public List<String> getSupportedProfiles()
  {
    return this.TX;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.mName;
    arrayOfObject[1] = this.TW;
    arrayOfObject[2] = this.TX;
    arrayOfObject[3] = this.TY;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("name", this.mName).a("address", this.TW).a("dataTypes", this.TY).a("supportedProfiles", this.TX).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.BleDevice
 * JD-Core Version:    0.7.0.1
 */