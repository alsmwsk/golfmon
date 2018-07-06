package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.DataBuffer;

public class DeviceFeatureBuffer
  extends DataBuffer<DeviceFeature>
{
  public DeviceFeature get(int paramInt)
  {
    return new a(this.JG, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.deviceconnection.features.DeviceFeatureBuffer
 * JD-Core Version:    0.7.0.1
 */