package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl
  implements RealTimeSocket
{
  private ParcelFileDescriptor LG;
  private final LocalSocket ZV;
  private final String Zk;
  
  RealTimeSocketImpl(LocalSocket paramLocalSocket, String paramString)
  {
    this.ZV = paramLocalSocket;
    this.Zk = paramString;
  }
  
  public void close()
    throws IOException
  {
    this.ZV.close();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.ZV.getInputStream();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.ZV.getOutputStream();
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
    throws IOException
  {
    if ((this.LG == null) && (!isClosed()))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.writeFileDescriptor(this.ZV.getFileDescriptor());
      localParcel.setDataPosition(0);
      this.LG = localParcel.readFileDescriptor();
    }
    return this.LG;
  }
  
  public boolean isClosed()
  {
    return (!this.ZV.isConnected()) && (!this.ZV.isBound());
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.RealTimeSocketImpl
 * JD-Core Version:    0.7.0.1
 */