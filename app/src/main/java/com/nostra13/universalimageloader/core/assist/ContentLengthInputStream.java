package com.nostra13.universalimageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;

public class ContentLengthInputStream
  extends InputStream
{
  private final long length;
  private long pos;
  private final InputStream stream;
  
  public ContentLengthInputStream(InputStream paramInputStream, long paramLong)
  {
    this.stream = paramInputStream;
    this.length = paramLong;
  }
  
  public int available()
  {
    try
    {
      long l1 = this.length;
      long l2 = this.pos;
      int i = (int)(l1 - l2);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void close()
    throws IOException
  {
    this.stream.close();
  }
  
  public void mark(int paramInt)
  {
    this.pos = paramInt;
    this.stream.mark(paramInt);
  }
  
  public int read()
    throws IOException
  {
    this.pos = (1L + this.pos);
    return this.stream.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.pos += paramInt2;
    return this.stream.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      this.pos = 0L;
      this.stream.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    this.pos = (paramLong + this.pos);
    return this.stream.skip(paramLong);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ContentLengthInputStream
 * JD-Core Version:    0.7.0.1
 */