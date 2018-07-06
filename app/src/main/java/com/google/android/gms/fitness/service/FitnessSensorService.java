package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.ll;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.mq;
import com.google.android.gms.internal.ms;
import com.google.android.gms.internal.mu.a;
import java.util.List;

public abstract class FitnessSensorService
  extends Service
{
  public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
  private a Ww;
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.fitness.service.FitnessSensorService".equals(paramIntent.getAction()))
    {
      if (Log.isLoggable("FitnessSensorService", 3)) {
        Log.d("FitnessSensorService", "Intent " + paramIntent + " received by " + getClass().getName());
      }
      return this.Ww.asBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.Ww = new a(this, null);
  }
  
  public abstract List<DataSource> onFindDataSources(List<DataType> paramList);
  
  public abstract boolean onRegister(FitnessSensorServiceRequest paramFitnessSensorServiceRequest);
  
  public abstract boolean onUnregister(DataSource paramDataSource);
  
  private static class a
    extends mu.a
  {
    private final FitnessSensorService Wx;
    
    private a(FitnessSensorService paramFitnessSensorService)
    {
      this.Wx = paramFitnessSensorService;
    }
    
    private void kw()
      throws SecurityException
    {
      int i = Binder.getCallingUid();
      if (ll.im())
      {
        ((AppOpsManager)this.Wx.getSystemService("appops")).checkPackage(i, "com.google.android.gms");
        return;
      }
      String[] arrayOfString = this.Wx.getPackageManager().getPackagesForUid(i);
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        for (int k = 0;; k++)
        {
          if (k >= j) {
            break label75;
          }
          if (arrayOfString[k].equals("com.google.android.gms")) {
            break;
          }
        }
      }
      label75:
      throw new SecurityException("Unauthorized caller");
    }
    
    public void a(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, md parammd)
      throws RemoteException
    {
      kw();
      if (this.Wx.onRegister(paramFitnessSensorServiceRequest))
      {
        parammd.j(Status.Kw);
        return;
      }
      parammd.j(new Status(13));
    }
    
    public void a(mq parammq, lx paramlx)
      throws RemoteException
    {
      kw();
      paramlx.a(new DataSourcesResult(this.Wx.onFindDataSources(parammq.getDataTypes()), Status.Kw));
    }
    
    public void a(ms paramms, md parammd)
      throws RemoteException
    {
      kw();
      if (this.Wx.onUnregister(paramms.getDataSource()))
      {
        parammd.j(Status.Kw);
        return;
      }
      parammd.j(new Status(13));
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.service.FitnessSensorService
 * JD-Core Version:    0.7.0.1
 */