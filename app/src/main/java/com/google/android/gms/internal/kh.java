package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface kh
  extends IInterface
{
  public abstract void aI(int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements kh
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
    }
    
    public static kh U(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof kh))) {
        return (kh)localIInterface;
      }
      return new a(paramIBinder);
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
        paramParcel2.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
      aI(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements kh
    {
      private IBinder le;
      
      a(IBinder paramIBinder)
      {
        this.le = paramIBinder;
      }
      
      public void aI(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
          localParcel1.writeInt(paramInt);
          this.le.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.le;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kh
 * JD-Core Version:    0.7.0.1
 */