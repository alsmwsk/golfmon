package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.l;
import com.google.android.gms.maps.model.internal.l.a;

public abstract interface e
  extends IInterface
{
  public abstract Bitmap a(l paraml, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements e
  {
    public static e aV(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
      if ((localIInterface != null) && ((localIInterface instanceof e))) {
        return (e)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.IInfoWindowRenderer");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
      Bitmap localBitmap = a(l.a.bA(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (localBitmap != null)
      {
        paramParcel2.writeInt(1);
        localBitmap.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    
    private static class a
      implements e
    {
      private IBinder le;
      
      a(IBinder paramIBinder)
      {
        this.le = paramIBinder;
      }
      
      /* Error */
      public Bitmap a(l paraml, int paramInt1, int paramInt2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 27
        //   14: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +94 -> 112
        //   21: aload_1
        //   22: invokeinterface 37 1 0
        //   27: astore 7
        //   29: aload 4
        //   31: aload 7
        //   33: invokevirtual 40	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: iload_2
        //   39: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   42: aload 4
        //   44: iload_3
        //   45: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   48: aload_0
        //   49: getfield 15	com/google/android/gms/maps/internal/e$a$a:le	Landroid/os/IBinder;
        //   52: iconst_1
        //   53: aload 4
        //   55: aload 5
        //   57: iconst_0
        //   58: invokeinterface 50 5 0
        //   63: pop
        //   64: aload 5
        //   66: invokevirtual 53	android/os/Parcel:readException	()V
        //   69: aload 5
        //   71: invokevirtual 57	android/os/Parcel:readInt	()I
        //   74: istore 9
        //   76: aconst_null
        //   77: astore 10
        //   79: iload 9
        //   81: ifeq +18 -> 99
        //   84: getstatic 63	android/graphics/Bitmap:CREATOR	Landroid/os/Parcelable$Creator;
        //   87: aload 5
        //   89: invokeinterface 69 2 0
        //   94: checkcast 59	android/graphics/Bitmap
        //   97: astore 10
        //   99: aload 5
        //   101: invokevirtual 72	android/os/Parcel:recycle	()V
        //   104: aload 4
        //   106: invokevirtual 72	android/os/Parcel:recycle	()V
        //   109: aload 10
        //   111: areturn
        //   112: aconst_null
        //   113: astore 7
        //   115: goto -86 -> 29
        //   118: astore 6
        //   120: aload 5
        //   122: invokevirtual 72	android/os/Parcel:recycle	()V
        //   125: aload 4
        //   127: invokevirtual 72	android/os/Parcel:recycle	()V
        //   130: aload 6
        //   132: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	133	0	this	a
        //   0	133	1	paraml	l
        //   0	133	2	paramInt1	int
        //   0	133	3	paramInt2	int
        //   3	123	4	localParcel1	Parcel
        //   8	113	5	localParcel2	Parcel
        //   118	13	6	localObject	Object
        //   27	87	7	localIBinder	IBinder
        //   74	6	9	i	int
        //   77	33	10	localBitmap	Bitmap
        // Exception table:
        //   from	to	target	type
        //   10	17	118	finally
        //   21	29	118	finally
        //   29	76	118	finally
        //   84	99	118	finally
      }
      
      public IBinder asBinder()
      {
        return this.le;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.e
 * JD-Core Version:    0.7.0.1
 */