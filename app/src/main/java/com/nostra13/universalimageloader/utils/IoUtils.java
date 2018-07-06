package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils
{
  public static final int CONTINUE_LOADING_PERCENTAGE = 75;
  public static final int DEFAULT_BUFFER_SIZE = 32768;
  
  public static void closeSilently(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static boolean copyStream(InputStream paramInputStream, OutputStream paramOutputStream, CopyListener paramCopyListener)
    throws IOException
  {
    return copyStream(paramInputStream, paramOutputStream, paramCopyListener, 32768);
  }
  
  public static boolean copyStream(InputStream paramInputStream, OutputStream paramOutputStream, CopyListener paramCopyListener, int paramInt)
    throws IOException
  {
    int i = paramInputStream.available();
    byte[] arrayOfByte = new byte[paramInt];
    boolean bool = shouldStopLoading(paramCopyListener, 0, i);
    int j = 0;
    if (bool) {
      return false;
    }
    do
    {
      int k = paramInputStream.read(arrayOfByte, 0, paramInt);
      if (k == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, k);
      j += k;
    } while (!shouldStopLoading(paramCopyListener, j, i));
    return false;
    return true;
  }
  
  private static boolean shouldStopLoading(CopyListener paramCopyListener, int paramInt1, int paramInt2)
  {
    return (paramCopyListener != null) && (!paramCopyListener.onBytesCopied(paramInt1, paramInt2)) && (paramInt1 * 100 / paramInt2 < 75);
  }
  
  public static abstract interface CopyListener
  {
    public abstract boolean onBytesCopied(int paramInt1, int paramInt2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.IoUtils
 * JD-Core Version:    0.7.0.1
 */