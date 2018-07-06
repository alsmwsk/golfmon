package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IUiSettingsDelegate
  extends IInterface
{
  public abstract boolean isCompassEnabled()
    throws RemoteException;
  
  public abstract boolean isIndoorLevelPickerEnabled()
    throws RemoteException;
  
  public abstract boolean isMapToolbarEnabled()
    throws RemoteException;
  
  public abstract boolean isMyLocationButtonEnabled()
    throws RemoteException;
  
  public abstract boolean isRotateGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isScrollGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isTiltGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isZoomControlsEnabled()
    throws RemoteException;
  
  public abstract boolean isZoomGesturesEnabled()
    throws RemoteException;
  
  public abstract void setAllGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setCompassEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setIndoorLevelPickerEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setMapToolbarEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setMyLocationButtonEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setRotateGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setScrollGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setTiltGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZoomControlsEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZoomGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements IUiSettingsDelegate
  {
    public static IUiSettingsDelegate bu(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof IUiSettingsDelegate))) {
        return (IUiSettingsDelegate)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int i14 = paramParcel1.readInt();
        boolean bool19 = false;
        if (i14 != 0) {
          bool19 = true;
        }
        setZoomControlsEnabled(bool19);
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int i13 = paramParcel1.readInt();
        boolean bool18 = false;
        if (i13 != 0) {
          bool18 = true;
        }
        setCompassEnabled(bool18);
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int i12 = paramParcel1.readInt();
        boolean bool17 = false;
        if (i12 != 0) {
          bool17 = true;
        }
        setMyLocationButtonEnabled(bool17);
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int i11 = paramParcel1.readInt();
        boolean bool16 = false;
        if (i11 != 0) {
          bool16 = true;
        }
        setScrollGesturesEnabled(bool16);
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int i10 = paramParcel1.readInt();
        boolean bool15 = false;
        if (i10 != 0) {
          bool15 = true;
        }
        setZoomGesturesEnabled(bool15);
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int i9 = paramParcel1.readInt();
        boolean bool14 = false;
        if (i9 != 0) {
          bool14 = true;
        }
        setTiltGesturesEnabled(bool14);
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int i8 = paramParcel1.readInt();
        boolean bool13 = false;
        if (i8 != 0) {
          bool13 = true;
        }
        setRotateGesturesEnabled(bool13);
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int i7 = paramParcel1.readInt();
        boolean bool12 = false;
        if (i7 != 0) {
          bool12 = true;
        }
        setAllGesturesEnabled(bool12);
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        boolean bool11 = isZoomControlsEnabled();
        paramParcel2.writeNoException();
        int i6 = 0;
        if (bool11) {
          i6 = 1;
        }
        paramParcel2.writeInt(i6);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        boolean bool10 = isCompassEnabled();
        paramParcel2.writeNoException();
        int i5 = 0;
        if (bool10) {
          i5 = 1;
        }
        paramParcel2.writeInt(i5);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        boolean bool9 = isMyLocationButtonEnabled();
        paramParcel2.writeNoException();
        int i4 = 0;
        if (bool9) {
          i4 = 1;
        }
        paramParcel2.writeInt(i4);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        boolean bool8 = isScrollGesturesEnabled();
        paramParcel2.writeNoException();
        int i3 = 0;
        if (bool8) {
          i3 = 1;
        }
        paramParcel2.writeInt(i3);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        boolean bool7 = isZoomGesturesEnabled();
        paramParcel2.writeNoException();
        int i2 = 0;
        if (bool7) {
          i2 = 1;
        }
        paramParcel2.writeInt(i2);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        boolean bool6 = isTiltGesturesEnabled();
        paramParcel2.writeNoException();
        int i1 = 0;
        if (bool6) {
          i1 = 1;
        }
        paramParcel2.writeInt(i1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        boolean bool5 = isRotateGesturesEnabled();
        paramParcel2.writeNoException();
        int n = 0;
        if (bool5) {
          n = 1;
        }
        paramParcel2.writeInt(n);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int m = paramParcel1.readInt();
        boolean bool4 = false;
        if (m != 0) {
          bool4 = true;
        }
        setIndoorLevelPickerEnabled(bool4);
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        boolean bool3 = isIndoorLevelPickerEnabled();
        paramParcel2.writeNoException();
        int k = 0;
        if (bool3) {
          k = 1;
        }
        paramParcel2.writeInt(k);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        int j = paramParcel1.readInt();
        boolean bool2 = false;
        if (j != 0) {
          bool2 = true;
        }
        setMapToolbarEnabled(bool2);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool1 = isMapToolbarEnabled();
      paramParcel2.writeNoException();
      int i = 0;
      if (bool1) {
        i = 1;
      }
      paramParcel2.writeInt(i);
      return true;
    }
    
    private static class a
      implements IUiSettingsDelegate
    {
      private IBinder le;
      
      a(IBinder paramIBinder)
      {
        this.le = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.le;
      }
      
      public boolean isCompassEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.le.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isIndoorLevelPickerEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.le.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isMapToolbarEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.le.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isMyLocationButtonEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.le.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isRotateGesturesEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.le.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isScrollGesturesEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.le.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isTiltGesturesEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.le.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isZoomControlsEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.le.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isZoomGesturesEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.le.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setAllGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setCompassEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setIndoorLevelPickerEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setMapToolbarEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setMyLocationButtonEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setRotateGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setScrollGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setTiltGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void setZoomControlsEnabled(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +38 -> 56
        //   21: aload_3
        //   22: iload_2
        //   23: invokevirtual 63	android/os/Parcel:writeInt	(I)V
        //   26: aload_0
        //   27: getfield 15	com/google/android/gms/maps/internal/IUiSettingsDelegate$a$a:le	Landroid/os/IBinder;
        //   30: iconst_1
        //   31: aload_3
        //   32: aload 4
        //   34: iconst_0
        //   35: invokeinterface 39 5 0
        //   40: pop
        //   41: aload 4
        //   43: invokevirtual 42	android/os/Parcel:readException	()V
        //   46: aload 4
        //   48: invokevirtual 49	android/os/Parcel:recycle	()V
        //   51: aload_3
        //   52: invokevirtual 49	android/os/Parcel:recycle	()V
        //   55: return
        //   56: iconst_0
        //   57: istore_2
        //   58: goto -37 -> 21
        //   61: astore 5
        //   63: aload 4
        //   65: invokevirtual 49	android/os/Parcel:recycle	()V
        //   68: aload_3
        //   69: invokevirtual 49	android/os/Parcel:recycle	()V
        //   72: aload 5
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   0	75	1	paramBoolean	boolean
        //   1	57	2	i	int
        //   5	64	3	localParcel1	Parcel
        //   9	55	4	localParcel2	Parcel
        //   61	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	17	61	finally
        //   21	46	61	finally
      }
      
      public void setZoomGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.IUiSettingsDelegate
 * JD-Core Version:    0.7.0.1
 */