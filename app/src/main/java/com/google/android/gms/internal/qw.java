package com.google.android.gms.internal;

import java.io.IOException;

public abstract class qw
{
  protected volatile int azh = -1;
  
  public static final <T extends qw> T a(T paramT, byte[] paramArrayOfByte)
    throws qv
  {
    return b(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void a(qw paramqw, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      qp localqp = qp.b(paramArrayOfByte, paramInt1, paramInt2);
      paramqw.a(localqp);
      localqp.rP();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
  
  public static final <T extends qw> T b(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws qv
  {
    try
    {
      qo localqo = qo.a(paramArrayOfByte, paramInt1, paramInt2);
      paramT.b(localqo);
      localqo.gP(0);
      return paramT;
    }
    catch (qv localqv)
    {
      throw localqv;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] f(qw paramqw)
  {
    byte[] arrayOfByte = new byte[paramqw.rZ()];
    a(paramqw, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void a(qp paramqp)
    throws IOException
  {}
  
  public abstract qw b(qo paramqo)
    throws IOException;
  
  protected int c()
  {
    return 0;
  }
  
  public int rY()
  {
    if (this.azh < 0) {
      rZ();
    }
    return this.azh;
  }
  
  public int rZ()
  {
    int i = c();
    this.azh = i;
    return i;
  }
  
  public String toString()
  {
    return qx.g(this);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qw
 * JD-Core Version:    0.7.0.1
 */