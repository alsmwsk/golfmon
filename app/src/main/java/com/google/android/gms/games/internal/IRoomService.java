package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract interface IRoomService
  extends IInterface
{
  public abstract void R(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IBinder paramIBinder, IRoomServiceCallbacks paramIRoomServiceCallbacks)
    throws RemoteException;
  
  public abstract void a(DataHolder paramDataHolder, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(byte[] paramArrayOfByte, String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void a(byte[] paramArrayOfByte, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void bQ(String paramString)
    throws RemoteException;
  
  public abstract void bR(String paramString)
    throws RemoteException;
  
  public abstract void c(String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract void lN()
    throws RemoteException;
  
  public abstract void lO()
    throws RemoteException;
  
  public abstract void lP()
    throws RemoteException;
  
  public abstract void lQ()
    throws RemoteException;
  
  public abstract void v(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void w(String paramString, int paramInt)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IRoomService
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.games.internal.IRoomService");
        return true;
      case 1001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        a(paramParcel1.readStrongBinder(), IRoomServiceCallbacks.Stub.aH(paramParcel1.readStrongBinder()));
        return true;
      case 1002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        lN();
        return true;
      case 1003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        lO();
        return true;
      case 1004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        c(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        return true;
      case 1005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        lP();
        return true;
      case 1006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        if (paramParcel1.readInt() != 0) {}
        for (DataHolder localDataHolder = DataHolder.CREATOR.B(paramParcel1);; localDataHolder = null)
        {
          int j = paramParcel1.readInt();
          boolean bool2 = false;
          if (j != 0) {
            bool2 = true;
          }
          a(localDataHolder, bool2);
          return true;
        }
      case 1007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        lQ();
        return true;
      case 1008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        int i = paramParcel1.readInt();
        boolean bool1 = false;
        if (i != 0) {
          bool1 = true;
        }
        R(bool1);
        return true;
      case 1009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        a(paramParcel1.createByteArray(), paramParcel1.readString(), paramParcel1.readInt());
        return true;
      case 1010: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        a(paramParcel1.createByteArray(), paramParcel1.createStringArray());
        return true;
      case 1011: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        v(paramParcel1.readString(), paramParcel1.readInt());
        return true;
      case 1012: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        w(paramParcel1.readString(), paramParcel1.readInt());
        return true;
      case 1013: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        bQ(paramParcel1.readString());
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      bR(paramParcel1.readString());
      return true;
    }
    
    private static class Proxy
      implements IRoomService
    {
      private IBinder le;
      
      /* Error */
      public void R(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 18	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: aload_3
        //   7: ldc 20
        //   9: invokevirtual 24	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: iload_1
        //   13: ifeq +29 -> 42
        //   16: aload_3
        //   17: iload_2
        //   18: invokevirtual 28	android/os/Parcel:writeInt	(I)V
        //   21: aload_0
        //   22: getfield 30	com/google/android/gms/games/internal/IRoomService$Stub$Proxy:le	Landroid/os/IBinder;
        //   25: sipush 1008
        //   28: aload_3
        //   29: aconst_null
        //   30: iconst_1
        //   31: invokeinterface 36 5 0
        //   36: pop
        //   37: aload_3
        //   38: invokevirtual 40	android/os/Parcel:recycle	()V
        //   41: return
        //   42: iconst_0
        //   43: istore_2
        //   44: goto -28 -> 16
        //   47: astore 4
        //   49: aload_3
        //   50: invokevirtual 40	android/os/Parcel:recycle	()V
        //   53: aload 4
        //   55: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	56	0	this	Proxy
        //   0	56	1	paramBoolean	boolean
        //   1	43	2	i	int
        //   5	45	3	localParcel	Parcel
        //   47	7	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   6	12	47	finally
        //   16	37	47	finally
      }
      
      public void a(IBinder paramIBinder, IRoomServiceCallbacks paramIRoomServiceCallbacks)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeStrongBinder(paramIBinder);
          IBinder localIBinder = null;
          if (paramIRoomServiceCallbacks != null) {
            localIBinder = paramIRoomServiceCallbacks.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.le.transact(1001, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(DataHolder paramDataHolder, boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            if (paramDataHolder != null)
            {
              localParcel.writeInt(1);
              paramDataHolder.writeToParcel(localParcel, 0);
              break label87;
              localParcel.writeInt(i);
              this.le.transact(1006, localParcel, null, 1);
            }
            else
            {
              localParcel.writeInt(0);
            }
          }
          finally
          {
            localParcel.recycle();
          }
          label87:
          while (!paramBoolean)
          {
            i = 0;
            break;
          }
        }
      }
      
      public void a(byte[] paramArrayOfByte, String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeByteArray(paramArrayOfByte);
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.le.transact(1009, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(byte[] paramArrayOfByte, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeByteArray(paramArrayOfByte);
          localParcel.writeStringArray(paramArrayOfString);
          this.le.transact(1010, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.le;
      }
      
      public void bQ(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString);
          this.le.transact(1013, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void bR(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString);
          this.le.transact(1014, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void c(String paramString1, String paramString2, String paramString3)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          localParcel.writeString(paramString3);
          this.le.transact(1004, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void lN()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          this.le.transact(1002, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void lO()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          this.le.transact(1003, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void lP()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          this.le.transact(1005, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void lQ()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          this.le.transact(1007, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void v(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.le.transact(1011, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void w(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.le.transact(1012, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.IRoomService
 * JD-Core Version:    0.7.0.1
 */