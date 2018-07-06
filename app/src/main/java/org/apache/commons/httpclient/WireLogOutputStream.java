package org.apache.commons.httpclient;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class WireLogOutputStream
  extends FilterOutputStream
{
  private OutputStream out;
  private Wire wire;
  
  public WireLogOutputStream(OutputStream paramOutputStream, Wire paramWire)
  {
    super(paramOutputStream);
    this.out = paramOutputStream;
    this.wire = paramWire;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.out.write(paramInt);
    this.wire.output(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.out.write(paramArrayOfByte);
    this.wire.output(paramArrayOfByte);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.wire.output(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.WireLogOutputStream
 * JD-Core Version:    0.7.0.1
 */