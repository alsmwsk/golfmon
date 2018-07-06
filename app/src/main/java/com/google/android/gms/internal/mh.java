package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.request.b;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class mh
  implements BleApi
{
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, final BleDevice paramBleDevice)
  {
    paramGoogleApiClient.b(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(new b(paramBleDevice), localb, str);
      }
    });
  }
  
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(new b(paramString), localb, str);
      }
    });
  }
  
  public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.a(new lu.a(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        mh.a locala = new mh.a(this, null);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(locala, str);
      }
      
      protected BleDevicesResult v(Status paramAnonymousStatus)
      {
        return BleDevicesResult.C(paramAnonymousStatus);
      }
    });
  }
  
  public PendingResult<Status> startBleScan(GoogleApiClient paramGoogleApiClient, final StartBleScanRequest paramStartBleScanRequest)
  {
    paramGoogleApiClient.a(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(paramStartBleScanRequest, localb, str);
      }
    });
  }
  
  public PendingResult<Status> stopBleScan(GoogleApiClient paramGoogleApiClient, final BleScanCallback paramBleScanCallback)
  {
    paramGoogleApiClient.a(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        ad localad = new ad(paramBleScanCallback);
        paramAnonymouslu.jM().a(localad, localb, str);
      }
    });
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return unclaimBleDevice(paramGoogleApiClient, paramBleDevice.getAddress());
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(new ah(paramString), localb, str);
      }
    });
  }
  
  private static class a
    extends mp.a
  {
    private final BaseImplementation.b<BleDevicesResult> Ea;
    
    private a(BaseImplementation.b<BleDevicesResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(BleDevicesResult paramBleDevicesResult)
    {
      this.Ea.b(paramBleDevicesResult);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mh
 * JD-Core Version:    0.7.0.1
 */