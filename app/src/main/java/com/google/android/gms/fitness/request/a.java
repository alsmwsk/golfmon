package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

public class a
  extends l.a
{
  private final BleScanCallback VC;
  
  private a(BleScanCallback paramBleScanCallback)
  {
    this.VC = ((BleScanCallback)jx.i(paramBleScanCallback));
  }
  
  public void onDeviceFound(BleDevice paramBleDevice)
    throws RemoteException
  {
    this.VC.onDeviceFound(paramBleDevice);
  }
  
  public void onScanStopped()
    throws RemoteException
  {
    this.VC.onScanStopped();
  }
  
  public static class a
  {
    private static final a VD = new a();
    private final Map<BleScanCallback, a> VE = new HashMap();
    
    public static a jP()
    {
      return VD;
    }
    
    public a a(BleScanCallback paramBleScanCallback)
    {
      synchronized (this.VE)
      {
        a locala = (a)this.VE.get(paramBleScanCallback);
        if (locala == null)
        {
          locala = new a(paramBleScanCallback, null);
          this.VE.put(paramBleScanCallback, locala);
        }
        return locala;
      }
    }
    
    public a b(BleScanCallback paramBleScanCallback)
    {
      synchronized (this.VE)
      {
        a locala1 = (a)this.VE.get(paramBleScanCallback);
        if (locala1 != null) {
          return locala1;
        }
        a locala2 = new a(paramBleScanCallback, null);
        return locala2;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.a
 * JD-Core Version:    0.7.0.1
 */