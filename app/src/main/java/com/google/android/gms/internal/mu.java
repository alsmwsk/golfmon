package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public abstract interface mu
  extends IInterface
{
  public abstract void a(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, md parammd)
    throws RemoteException;
  
  public abstract void a(mq parammq, lx paramlx)
    throws RemoteException;
  
  public abstract void a(ms paramms, md parammd)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements mu
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        int k = paramParcel1.readInt();
        mq localmq = null;
        if (k != 0) {
          localmq = (mq)mq.CREATOR.createFromParcel(paramParcel1);
        }
        a(localmq, lx.a.at(paramParcel1.readStrongBinder()));
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        int j = paramParcel1.readInt();
        FitnessSensorServiceRequest localFitnessSensorServiceRequest = null;
        if (j != 0) {
          localFitnessSensorServiceRequest = (FitnessSensorServiceRequest)FitnessSensorServiceRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localFitnessSensorServiceRequest, md.a.az(paramParcel1.readStrongBinder()));
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
      int i = paramParcel1.readInt();
      ms localms = null;
      if (i != 0) {
        localms = (ms)ms.CREATOR.createFromParcel(paramParcel1);
      }
      a(localms, md.a.az(paramParcel1.readStrongBinder()));
      return true;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mu
 * JD-Core Version:    0.7.0.1
 */