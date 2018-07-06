package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface qe
  extends IInterface
{
  public abstract void b(int paramInt1, int paramInt2, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements qe
  {
    public static qe bT(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof qe))) {
        return (qe)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
      int i = paramParcel1.readInt();
      int j = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle = null)
      {
        b(i, j, localBundle);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    private static class a
      implements qe
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
      
      /* Error */
      public void b(int paramInt1, int paramInt2, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: iload_1
        //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   23: aload 4
        //   25: iload_2
        //   26: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   29: aload_3
        //   30: ifnull +48 -> 78
        //   33: aload 4
        //   35: iconst_1
        //   36: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: aload 4
        //   42: iconst_0
        //   43: invokevirtual 43	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 15	com/google/android/gms/internal/qe$a$a:le	Landroid/os/IBinder;
        //   50: iconst_1
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 49 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 52	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 55	android/os/Parcel:recycle	()V
        //   72: aload 4
        //   74: invokevirtual 55	android/os/Parcel:recycle	()V
        //   77: return
        //   78: aload 4
        //   80: iconst_0
        //   81: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   84: goto -38 -> 46
        //   87: astore 6
        //   89: aload 5
        //   91: invokevirtual 55	android/os/Parcel:recycle	()V
        //   94: aload 4
        //   96: invokevirtual 55	android/os/Parcel:recycle	()V
        //   99: aload 6
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	a
        //   0	102	1	paramInt1	int
        //   0	102	2	paramInt2	int
        //   0	102	3	paramBundle	Bundle
        //   3	92	4	localParcel1	Parcel
        //   8	82	5	localParcel2	Parcel
        //   87	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	29	87	finally
        //   33	46	87	finally
        //   46	67	87	finally
        //   78	84	87	finally
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qe
 * JD-Core Version:    0.7.0.1
 */