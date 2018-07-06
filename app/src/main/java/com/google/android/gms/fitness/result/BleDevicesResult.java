package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BleDevicesResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<BleDevicesResult> CREATOR = new a();
  private final int CK;
  private final Status Eb;
  private final List<BleDevice> Wq;
  
  BleDevicesResult(int paramInt, List<BleDevice> paramList, Status paramStatus)
  {
    this.CK = paramInt;
    this.Wq = Collections.unmodifiableList(paramList);
    this.Eb = paramStatus;
  }
  
  public BleDevicesResult(List<BleDevice> paramList, Status paramStatus)
  {
    this.CK = 3;
    this.Wq = Collections.unmodifiableList(paramList);
    this.Eb = paramStatus;
  }
  
  public static BleDevicesResult C(Status paramStatus)
  {
    return new BleDevicesResult(Collections.emptyList(), paramStatus);
  }
  
  private boolean b(BleDevicesResult paramBleDevicesResult)
  {
    return (this.Eb.equals(paramBleDevicesResult.Eb)) && (jv.equal(this.Wq, paramBleDevicesResult.Wq));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof BleDevicesResult)) && (b((BleDevicesResult)paramObject)));
  }
  
  public List<BleDevice> getClaimedBleDevices()
  {
    return this.Wq;
  }
  
  public List<BleDevice> getClaimedBleDevices(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Wq.iterator();
    while (localIterator.hasNext())
    {
      BleDevice localBleDevice = (BleDevice)localIterator.next();
      if (localBleDevice.getDataTypes().contains(paramDataType)) {
        localArrayList.add(localBleDevice);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Status getStatus()
  {
    return this.Eb;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.Eb;
    arrayOfObject[1] = this.Wq;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("status", this.Eb).a("bleDevices", this.Wq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.BleDevicesResult
 * JD-Core Version:    0.7.0.1
 */