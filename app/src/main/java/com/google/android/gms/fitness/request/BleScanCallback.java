package com.google.android.gms.fitness.request;

import com.google.android.gms.fitness.data.BleDevice;

public abstract class BleScanCallback
{
  public abstract void onDeviceFound(BleDevice paramBleDevice);
  
  public abstract void onScanStopped();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.BleScanCallback
 * JD-Core Version:    0.7.0.1
 */