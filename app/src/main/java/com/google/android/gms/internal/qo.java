package com.google.android.gms.internal;

import java.io.IOException;

public final class qo
{
  private int ayM;
  private int ayN;
  private int ayO;
  private int ayP;
  private int ayQ;
  private int ayR = 2147483647;
  private int ayS;
  private int ayT = 64;
  private int ayU = 67108864;
  private final byte[] buffer;
  
  private qo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.ayM = paramInt1;
    this.ayN = (paramInt1 + paramInt2);
    this.ayP = paramInt1;
  }
  
  public static long A(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static qo a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new qo(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int gR(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public static qo p(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void rK()
  {
    this.ayN += this.ayO;
    int i = this.ayN;
    if (i > this.ayR)
    {
      this.ayO = (i - this.ayR);
      this.ayN -= this.ayO;
      return;
    }
    this.ayO = 0;
  }
  
  public void a(qw paramqw)
    throws IOException
  {
    int i = rG();
    if (this.ayS >= this.ayT) {
      throw qv.rX();
    }
    int j = gS(i);
    this.ayS = (1 + this.ayS);
    paramqw.b(this);
    gP(0);
    this.ayS = (-1 + this.ayS);
    gT(j);
  }
  
  public void a(qw paramqw, int paramInt)
    throws IOException
  {
    if (this.ayS >= this.ayT) {
      throw qv.rX();
    }
    this.ayS = (1 + this.ayS);
    paramqw.b(this);
    gP(qz.y(paramInt, 4));
    this.ayS = (-1 + this.ayS);
  }
  
  public void gP(int paramInt)
    throws qv
  {
    if (this.ayQ != paramInt) {
      throw qv.rV();
    }
  }
  
  public boolean gQ(int paramInt)
    throws IOException
  {
    switch (qz.hk(paramInt))
    {
    default: 
      throw qv.rW();
    case 0: 
      rC();
      return true;
    case 1: 
      rJ();
      return true;
    case 2: 
      gW(rG());
      return true;
    case 3: 
      rA();
      gP(qz.y(qz.hl(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    rI();
    return true;
  }
  
  public int gS(int paramInt)
    throws qv
  {
    if (paramInt < 0) {
      throw qv.rS();
    }
    int i = paramInt + this.ayP;
    int j = this.ayR;
    if (i > j) {
      throw qv.rR();
    }
    this.ayR = i;
    rK();
    return j;
  }
  
  public void gT(int paramInt)
  {
    this.ayR = paramInt;
    rK();
  }
  
  public void gU(int paramInt)
  {
    if (paramInt > this.ayP - this.ayM) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.ayP - this.ayM));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.ayP = (paramInt + this.ayM);
  }
  
  public byte[] gV(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw qv.rS();
    }
    if (paramInt + this.ayP > this.ayR)
    {
      gW(this.ayR - this.ayP);
      throw qv.rR();
    }
    if (paramInt <= this.ayN - this.ayP)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.ayP, arrayOfByte, 0, paramInt);
      this.ayP = (paramInt + this.ayP);
      return arrayOfByte;
    }
    throw qv.rR();
  }
  
  public void gW(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw qv.rS();
    }
    if (paramInt + this.ayP > this.ayR)
    {
      gW(this.ayR - this.ayP);
      throw qv.rR();
    }
    if (paramInt <= this.ayN - this.ayP)
    {
      this.ayP = (paramInt + this.ayP);
      return;
    }
    throw qv.rR();
  }
  
  public int getPosition()
  {
    return this.ayP - this.ayM;
  }
  
  public void rA()
    throws IOException
  {
    int i;
    do
    {
      i = rz();
    } while ((i != 0) && (gQ(i)));
  }
  
  public long rB()
    throws IOException
  {
    return rH();
  }
  
  public int rC()
    throws IOException
  {
    return rG();
  }
  
  public boolean rD()
    throws IOException
  {
    return rG() != 0;
  }
  
  public int rE()
    throws IOException
  {
    return gR(rG());
  }
  
  public long rF()
    throws IOException
  {
    return A(rH());
  }
  
  public int rG()
    throws IOException
  {
    int i = rN();
    if (i >= 0) {}
    int i4;
    do
    {
      return i;
      int j = i & 0x7F;
      int k = rN();
      if (k >= 0) {
        return j | k << 7;
      }
      int m = j | (k & 0x7F) << 7;
      int n = rN();
      if (n >= 0) {
        return m | n << 14;
      }
      int i1 = m | (n & 0x7F) << 14;
      int i2 = rN();
      if (i2 >= 0) {
        return i1 | i2 << 21;
      }
      int i3 = i1 | (i2 & 0x7F) << 21;
      i4 = rN();
      i = i3 | i4 << 28;
    } while (i4 >= 0);
    for (int i5 = 0;; i5++)
    {
      if (i5 >= 5) {
        break label151;
      }
      if (rN() >= 0) {
        break;
      }
    }
    label151:
    throw qv.rT();
  }
  
  public long rH()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = rN();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw qv.rT();
  }
  
  public int rI()
    throws IOException
  {
    int i = rN();
    int j = rN();
    int k = rN();
    int m = rN();
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public long rJ()
    throws IOException
  {
    int i = rN();
    int j = rN();
    int k = rN();
    int m = rN();
    int n = rN();
    int i1 = rN();
    int i2 = rN();
    int i3 = rN();
    return 0xFF & i | (0xFF & j) << 8 | (0xFF & k) << 16 | (0xFF & m) << 24 | (0xFF & n) << 32 | (0xFF & i1) << 40 | (0xFF & i2) << 48 | (0xFF & i3) << 56;
  }
  
  public int rL()
  {
    if (this.ayR == 2147483647) {
      return -1;
    }
    int i = this.ayP;
    return this.ayR - i;
  }
  
  public boolean rM()
  {
    return this.ayP == this.ayN;
  }
  
  public byte rN()
    throws IOException
  {
    if (this.ayP == this.ayN) {
      throw qv.rR();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.ayP;
    this.ayP = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] readBytes()
    throws IOException
  {
    int i = rG();
    if ((i <= this.ayN - this.ayP) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.ayP, arrayOfByte, 0, i);
      this.ayP = (i + this.ayP);
      return arrayOfByte;
    }
    return gV(i);
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(rJ());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(rI());
  }
  
  public String readString()
    throws IOException
  {
    int i = rG();
    if ((i <= this.ayN - this.ayP) && (i > 0))
    {
      String str = new String(this.buffer, this.ayP, i, "UTF-8");
      this.ayP = (i + this.ayP);
      return str;
    }
    return new String(gV(i), "UTF-8");
  }
  
  public int rz()
    throws IOException
  {
    if (rM())
    {
      this.ayQ = 0;
      return 0;
    }
    this.ayQ = rG();
    if (this.ayQ == 0) {
      throw qv.rU();
    }
    return this.ayQ;
  }
  
  public byte[] s(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return qz.azq;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = paramInt1 + this.ayM;
    System.arraycopy(this.buffer, i, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qo
 * JD-Core Version:    0.7.0.1
 */