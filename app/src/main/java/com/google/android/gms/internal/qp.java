package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class qp
{
  private final int ayV;
  private final byte[] buffer;
  private int position;
  
  private qp(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.ayV = (paramInt1 + paramInt2);
  }
  
  public static int D(long paramLong)
  {
    return G(paramLong);
  }
  
  public static int E(long paramLong)
  {
    return G(I(paramLong));
  }
  
  public static int G(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((0x0 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static long I(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int X(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int b(int paramInt, double paramDouble)
  {
    return hc(paramInt) + f(paramDouble);
  }
  
  public static int b(int paramInt, qw paramqw)
  {
    return 2 * hc(paramInt) + d(paramqw);
  }
  
  public static int b(int paramInt, byte[] paramArrayOfByte)
  {
    return hc(paramInt) + s(paramArrayOfByte);
  }
  
  public static qp b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new qp(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int c(int paramInt, float paramFloat)
  {
    return hc(paramInt) + e(paramFloat);
  }
  
  public static int c(int paramInt, qw paramqw)
  {
    return hc(paramInt) + e(paramqw);
  }
  
  public static int c(int paramInt, boolean paramBoolean)
  {
    return hc(paramInt) + X(paramBoolean);
  }
  
  public static int d(int paramInt, long paramLong)
  {
    return hc(paramInt) + D(paramLong);
  }
  
  public static int d(qw paramqw)
  {
    return paramqw.rZ();
  }
  
  public static int dk(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      int i = he(arrayOfByte.length);
      int j = arrayOfByte.length;
      return j + i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int e(float paramFloat)
  {
    return 4;
  }
  
  public static int e(int paramInt, long paramLong)
  {
    return hc(paramInt) + E(paramLong);
  }
  
  public static int e(qw paramqw)
  {
    int i = paramqw.rZ();
    return i + he(i);
  }
  
  public static int f(double paramDouble)
  {
    return 8;
  }
  
  public static int gZ(int paramInt)
  {
    if (paramInt >= 0) {
      return he(paramInt);
    }
    return 10;
  }
  
  public static int ha(int paramInt)
  {
    return he(hg(paramInt));
  }
  
  public static int hc(int paramInt)
  {
    return he(qz.y(paramInt, 0));
  }
  
  public static int he(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int hg(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int j(int paramInt, String paramString)
  {
    return hc(paramInt) + dk(paramString);
  }
  
  public static qp q(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int s(byte[] paramArrayOfByte)
  {
    return he(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static int v(int paramInt1, int paramInt2)
  {
    return hc(paramInt1) + gZ(paramInt2);
  }
  
  public static int w(int paramInt1, int paramInt2)
  {
    return hc(paramInt1) + ha(paramInt2);
  }
  
  public void B(long paramLong)
    throws IOException
  {
    F(paramLong);
  }
  
  public void C(long paramLong)
    throws IOException
  {
    F(I(paramLong));
  }
  
  public void F(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        hb((int)paramLong);
        return;
      }
      hb(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }
  
  public void H(long paramLong)
    throws IOException
  {
    hb(0xFF & (int)paramLong);
    hb(0xFF & (int)(paramLong >> 8));
    hb(0xFF & (int)(paramLong >> 16));
    hb(0xFF & (int)(paramLong >> 24));
    hb(0xFF & (int)(paramLong >> 32));
    hb(0xFF & (int)(paramLong >> 40));
    hb(0xFF & (int)(paramLong >> 48));
    hb(0xFF & (int)(paramLong >> 56));
  }
  
  public void W(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      hb(i);
      return;
    }
  }
  
  public void a(int paramInt, double paramDouble)
    throws IOException
  {
    x(paramInt, 1);
    e(paramDouble);
  }
  
  public void a(int paramInt, qw paramqw)
    throws IOException
  {
    x(paramInt, 2);
    c(paramqw);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    x(paramInt, 2);
    r(paramArrayOfByte);
  }
  
  public void b(byte paramByte)
    throws IOException
  {
    if (this.position == this.ayV) {
      throw new a(this.position, this.ayV);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void b(int paramInt, float paramFloat)
    throws IOException
  {
    x(paramInt, 5);
    d(paramFloat);
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    x(paramInt, 0);
    B(paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    x(paramInt, 2);
    dj(paramString);
  }
  
  public void b(int paramInt, boolean paramBoolean)
    throws IOException
  {
    x(paramInt, 0);
    W(paramBoolean);
  }
  
  public void b(qw paramqw)
    throws IOException
  {
    paramqw.a(this);
  }
  
  public void c(int paramInt, long paramLong)
    throws IOException
  {
    x(paramInt, 0);
    C(paramLong);
  }
  
  public void c(qw paramqw)
    throws IOException
  {
    hd(paramqw.rY());
    paramqw.a(this);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.ayV - this.position >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
      this.position = (paramInt2 + this.position);
      return;
    }
    throw new a(this.position, this.ayV);
  }
  
  public void d(float paramFloat)
    throws IOException
  {
    hf(Float.floatToIntBits(paramFloat));
  }
  
  public void dj(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    hd(arrayOfByte.length);
    t(arrayOfByte);
  }
  
  public void e(double paramDouble)
    throws IOException
  {
    H(Double.doubleToLongBits(paramDouble));
  }
  
  public void gX(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      hd(paramInt);
      return;
    }
    F(paramInt);
  }
  
  public void gY(int paramInt)
    throws IOException
  {
    hd(hg(paramInt));
  }
  
  public void hb(int paramInt)
    throws IOException
  {
    b((byte)paramInt);
  }
  
  public void hd(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        hb(paramInt);
        return;
      }
      hb(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }
  
  public void hf(int paramInt)
    throws IOException
  {
    hb(paramInt & 0xFF);
    hb(0xFF & paramInt >> 8);
    hb(0xFF & paramInt >> 16);
    hb(0xFF & paramInt >> 24);
  }
  
  public void r(byte[] paramArrayOfByte)
    throws IOException
  {
    hd(paramArrayOfByte.length);
    t(paramArrayOfByte);
  }
  
  public int rO()
  {
    return this.ayV - this.position;
  }
  
  public void rP()
  {
    if (rO() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void t(int paramInt1, int paramInt2)
    throws IOException
  {
    x(paramInt1, 0);
    gX(paramInt2);
  }
  
  public void t(byte[] paramArrayOfByte)
    throws IOException
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void u(int paramInt1, int paramInt2)
    throws IOException
  {
    x(paramInt1, 0);
    gY(paramInt2);
  }
  
  public void x(int paramInt1, int paramInt2)
    throws IOException
  {
    hd(qz.y(paramInt1, paramInt2));
  }
  
  public static class a
    extends IOException
  {
    a(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qp
 * JD-Core Version:    0.7.0.1
 */