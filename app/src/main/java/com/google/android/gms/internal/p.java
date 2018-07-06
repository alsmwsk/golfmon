package com.google.android.gms.internal;

import java.io.IOException;

class p
  implements n
{
  private qp lb;
  private byte[] lc;
  private final int ld;
  
  public p(int paramInt)
  {
    this.ld = paramInt;
    reset();
  }
  
  public byte[] D()
    throws IOException
  {
    int i = this.lb.rO();
    if (i < 0) {
      throw new IOException();
    }
    if (i == 0) {
      return this.lc;
    }
    byte[] arrayOfByte = new byte[this.lc.length - i];
    System.arraycopy(this.lc, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    this.lb.b(paramInt, paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    this.lb.b(paramInt, paramString);
  }
  
  public void reset()
  {
    this.lc = new byte[this.ld];
    this.lb = qp.q(this.lc);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.p
 * JD-Core Version:    0.7.0.1
 */