package org.apache.commons.httpclient;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class WireLogInputStream
  extends FilterInputStream
{
  private InputStream in;
  private Wire wire;
  
  public WireLogInputStream(InputStream paramInputStream, Wire paramWire)
  {
    super(paramInputStream);
    this.in = paramInputStream;
    this.wire = paramWire;
  }
  
  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i > 0) {
      this.wire.input(i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte);
    if (i > 0) {
      this.wire.input(paramArrayOfByte, 0, i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i > 0) {
      this.wire.input(paramArrayOfByte, paramInt1, i);
    }
    return i;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.WireLogInputStream
 * JD-Core Version:    0.7.0.1
 */