package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lh;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotContentsEntity
  implements SafeParcelable, SnapshotContents
{
  public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();
  private static final Object aeY = new Object();
  private final int CK;
  private Contents PW;
  
  SnapshotContentsEntity(int paramInt, Contents paramContents)
  {
    this.CK = paramInt;
    this.PW = paramContents;
  }
  
  public SnapshotContentsEntity(Contents paramContents)
  {
    this(1, paramContents);
  }
  
  private boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Must provide a previously opened SnapshotContents");
      synchronized (aeY)
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(this.PW.getParcelFileDescriptor().getFileDescriptor());
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localFileOutputStream);
        try
        {
          FileChannel localFileChannel = localFileOutputStream.getChannel();
          localFileChannel.position(paramInt1);
          localBufferedOutputStream.write(paramArrayOfByte, paramInt2, paramInt3);
          if (paramBoolean) {
            localFileChannel.truncate(paramArrayOfByte.length);
          }
          localBufferedOutputStream.flush();
          return true;
        }
        catch (IOException localIOException)
        {
          GamesLog.a("SnapshotContentsEntity", "Failed to write snapshot data", localIOException);
          return false;
        }
      }
    }
  }
  
  public void close()
  {
    this.PW = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if (!isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Cannot mutate closed contents!");
      return this.PW.getParcelFileDescriptor();
    }
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public Contents ir()
  {
    return this.PW;
  }
  
  public boolean isClosed()
  {
    return this.PW == null;
  }
  
  public boolean modifyBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramArrayOfByte, paramInt2, paramArrayOfByte.length, false);
  }
  
  public byte[] readFully()
    throws IOException
  {
    boolean bool1 = isClosed();
    boolean bool2 = false;
    if (!bool1) {
      bool2 = true;
    }
    jx.a(bool2, "Must provide a previously opened Snapshot");
    synchronized (aeY)
    {
      FileInputStream localFileInputStream = new FileInputStream(this.PW.getParcelFileDescriptor().getFileDescriptor());
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(localFileInputStream);
      try
      {
        localFileInputStream.getChannel().position(0L);
        byte[] arrayOfByte = lh.a(localBufferedInputStream, false);
        localFileInputStream.getChannel().position(0L);
        return arrayOfByte;
      }
      catch (IOException localIOException)
      {
        GamesLog.b("SnapshotContentsEntity", "Failed to read snapshot data", localIOException);
        throw localIOException;
      }
    }
  }
  
  public boolean writeBytes(byte[] paramArrayOfByte)
  {
    return a(0, paramArrayOfByte, 0, paramArrayOfByte.length, true);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotContentsEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotContentsEntity
 * JD-Core Version:    0.7.0.1
 */