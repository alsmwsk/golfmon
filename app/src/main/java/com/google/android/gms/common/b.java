package com.google.android.gms.common;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class b
{
  static final byte[][] IA;
  static final byte[][] IB;
  static final byte[][] IC;
  static final byte[][] IE;
  static final byte[][] IF;
  static final byte[][] IG;
  static final byte[][] IH;
  static final byte[][] II;
  static final byte[][] IJ;
  static final byte[][] IK;
  static final byte[][] IL;
  static final byte[][] IM;
  static final byte[][] IN;
  static final byte[][] IO;
  static final byte[][] IP;
  static final byte[][] IQ;
  static final byte[][] IR;
  static final byte[][] IS;
  static final byte[][] IT;
  static final byte[][] IU;
  static final byte[][] IV;
  static final byte[][] IW;
  static final byte[][] IX;
  static final byte[][] IY;
  static final byte[][] IZ;
  static final byte[][] Ix;
  static final byte[][] Iy;
  static final byte[][] Iz;
  static final byte[][] Ja;
  static final byte[][] Jb;
  static final byte[][] Jc;
  private static Set<byte[]> Jd;
  private static Set<byte[]> Je;
  public static final Comparator Jf = new Comparator()
  {
    public int c(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
    {
      int i = Math.min(paramAnonymousArrayOfByte1.length, paramAnonymousArrayOfByte2.length);
      for (int j = 0; j < i; j++)
      {
        int k = 0xFF & paramAnonymousArrayOfByte1[j];
        int m = 0xFF & paramAnonymousArrayOfByte2[j];
        if (k != m) {
          return k - m;
        }
      }
      return paramAnonymousArrayOfByte1.length - paramAnonymousArrayOfByte2.length;
    }
  };
  
  static
  {
    byte[][] arrayOfByte1 = new byte[2][];
    arrayOfByte1[0] = aP("");
    arrayOfByte1[1] = aP("");
    Ix = arrayOfByte1;
    byte[][] arrayOfByte2 = new byte[2][];
    arrayOfByte2[0] = aP("");
    arrayOfByte2[1] = aP("");
    Iy = arrayOfByte2;
    byte[][] arrayOfByte3 = new byte[1][];
    arrayOfByte3[0] = aP("");
    Iz = arrayOfByte3;
    byte[][] arrayOfByte4 = new byte[2][];
    arrayOfByte4[0] = aP("");
    arrayOfByte4[1] = aP("");
    IA = arrayOfByte4;
    byte[][] arrayOfByte5 = new byte[2][];
    arrayOfByte5[0] = aP("");
    arrayOfByte5[1] = aP("");
    IB = arrayOfByte5;
    byte[][] arrayOfByte6 = new byte[2][];
    arrayOfByte6[0] = aP("");
    arrayOfByte6[1] = aP("");
    IC = arrayOfByte6;
    byte[][] arrayOfByte7 = new byte[2][];
    arrayOfByte7[0] = aP("");
    arrayOfByte7[1] = aP("");
    IE = arrayOfByte7;
    byte[][] arrayOfByte8 = new byte[2][];
    arrayOfByte8[0] = aP("");
    arrayOfByte8[1] = aP("");
    IF = arrayOfByte8;
    byte[][] arrayOfByte9 = new byte[2][];
    arrayOfByte9[0] = aP("");
    arrayOfByte9[1] = aP("");
    IG = arrayOfByte9;
    byte[][] arrayOfByte10 = new byte[2][];
    arrayOfByte10[0] = aP("");
    arrayOfByte10[1] = aP("");
    IH = arrayOfByte10;
    byte[][] arrayOfByte11 = new byte[2][];
    arrayOfByte11[0] = aP("");
    arrayOfByte11[1] = aP("");
    II = arrayOfByte11;
    byte[][] arrayOfByte12 = new byte[2][];
    arrayOfByte12[0] = aP("");
    arrayOfByte12[1] = aP("");
    IJ = arrayOfByte12;
    byte[][] arrayOfByte13 = new byte[2][];
    arrayOfByte13[0] = aP("");
    arrayOfByte13[1] = aP("");
    IK = arrayOfByte13;
    byte[][] arrayOfByte14 = new byte[2][];
    arrayOfByte14[0] = aP("");
    arrayOfByte14[1] = aP("");
    IL = arrayOfByte14;
    byte[][] arrayOfByte15 = new byte[1][];
    arrayOfByte15[0] = aP("");
    IM = arrayOfByte15;
    byte[][] arrayOfByte16 = new byte[2][];
    arrayOfByte16[0] = aP("");
    arrayOfByte16[1] = aP("");
    IN = arrayOfByte16;
    byte[][] arrayOfByte17 = new byte[2][];
    arrayOfByte17[0] = aP("");
    arrayOfByte17[1] = aP("");
    IO = arrayOfByte17;
    byte[][] arrayOfByte18 = new byte[2][];
    arrayOfByte18[0] = aP("");
    arrayOfByte18[1] = aP("");
    IP = arrayOfByte18;
    byte[][] arrayOfByte19 = new byte[2][];
    arrayOfByte19[0] = aP("");
    arrayOfByte19[1] = aP("");
    IQ = arrayOfByte19;
    byte[][] arrayOfByte20 = new byte[2][];
    arrayOfByte20[0] = aP("");
    arrayOfByte20[1] = aP("");
    IR = arrayOfByte20;
    byte[][] arrayOfByte21 = new byte[2][];
    arrayOfByte21[0] = aP("");
    arrayOfByte21[1] = aP("");
    IS = arrayOfByte21;
    byte[][] arrayOfByte22 = new byte[2][];
    arrayOfByte22[0] = aP("");
    arrayOfByte22[1] = aP("");
    IT = arrayOfByte22;
    byte[][] arrayOfByte23 = new byte[2][];
    arrayOfByte23[0] = aP("");
    arrayOfByte23[1] = aP("");
    IU = arrayOfByte23;
    byte[][] arrayOfByte24 = new byte[2][];
    arrayOfByte24[0] = aP("");
    arrayOfByte24[1] = aP("");
    IV = arrayOfByte24;
    byte[][] arrayOfByte25 = new byte[2][];
    arrayOfByte25[0] = aP("");
    arrayOfByte25[1] = aP("");
    IW = arrayOfByte25;
    byte[][] arrayOfByte26 = new byte[2][];
    arrayOfByte26[0] = aP("");
    arrayOfByte26[1] = aP("");
    IX = arrayOfByte26;
    byte[][] arrayOfByte27 = new byte[2][];
    arrayOfByte27[0] = aP("");
    arrayOfByte27[1] = aP("");
    IY = arrayOfByte27;
    byte[][] arrayOfByte28 = new byte[2][];
    arrayOfByte28[0] = aP("");
    arrayOfByte28[1] = aP("");
    IZ = arrayOfByte28;
    byte[][] arrayOfByte29 = new byte[2][];
    arrayOfByte29[0] = aP("");
    arrayOfByte29[1] = aP("");
    Ja = arrayOfByte29;
    byte[][] arrayOfByte30 = new byte[28][];
    arrayOfByte30[0] = Ix[0];
    arrayOfByte30[1] = Iy[0];
    arrayOfByte30[2] = IA[0];
    arrayOfByte30[3] = IB[0];
    arrayOfByte30[4] = IC[0];
    arrayOfByte30[5] = IE[0];
    arrayOfByte30[6] = IF[0];
    arrayOfByte30[7] = IG[0];
    arrayOfByte30[8] = IH[0];
    arrayOfByte30[9] = II[0];
    arrayOfByte30[10] = IJ[0];
    arrayOfByte30[11] = IK[0];
    arrayOfByte30[12] = IL[0];
    arrayOfByte30[13] = IM[0];
    arrayOfByte30[14] = IN[0];
    arrayOfByte30[15] = IO[0];
    arrayOfByte30[16] = IP[0];
    arrayOfByte30[17] = IQ[0];
    arrayOfByte30[18] = IR[0];
    arrayOfByte30[19] = IS[0];
    arrayOfByte30[20] = IT[0];
    arrayOfByte30[21] = IU[0];
    arrayOfByte30[22] = IV[0];
    arrayOfByte30[23] = IW[0];
    arrayOfByte30[24] = IX[0];
    arrayOfByte30[25] = IY[0];
    arrayOfByte30[26] = IZ[0];
    arrayOfByte30[27] = Ja[0];
    Jb = arrayOfByte30;
    byte[][][] arrayOfByte = new byte[29][][];
    arrayOfByte[0] = Ix;
    arrayOfByte[1] = Iy;
    arrayOfByte[2] = Iz;
    arrayOfByte[3] = IA;
    arrayOfByte[4] = IB;
    arrayOfByte[5] = IC;
    arrayOfByte[6] = IE;
    arrayOfByte[7] = IF;
    arrayOfByte[8] = IG;
    arrayOfByte[9] = IH;
    arrayOfByte[10] = II;
    arrayOfByte[11] = IJ;
    arrayOfByte[12] = IK;
    arrayOfByte[13] = IL;
    arrayOfByte[14] = IM;
    arrayOfByte[15] = IN;
    arrayOfByte[16] = IO;
    arrayOfByte[17] = IP;
    arrayOfByte[18] = IQ;
    arrayOfByte[19] = IR;
    arrayOfByte[20] = IS;
    arrayOfByte[21] = IT;
    arrayOfByte[22] = IU;
    arrayOfByte[23] = IV;
    arrayOfByte[24] = IW;
    arrayOfByte[25] = IX;
    arrayOfByte[26] = IY;
    arrayOfByte[27] = IZ;
    arrayOfByte[28] = Ja;
    Jc = a(arrayOfByte);
  }
  
  private static Set<byte[]> a(byte[][] paramArrayOfByte)
  {
    TreeSet localTreeSet = new TreeSet(Jf);
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++) {
      localTreeSet.add(paramArrayOfByte[j]);
    }
    return localTreeSet;
  }
  
  static byte[][] a(byte[][]... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += paramVarArgs[j].length;
      j++;
    }
    byte[][] arrayOfByte = new byte[k][];
    int m = paramVarArgs.length;
    int n = 0;
    int i2;
    for (int i1 = 0; n < m; i1 = i2)
    {
      byte[][] arrayOfByte1 = paramVarArgs[n];
      i2 = i1;
      int i3 = 0;
      while (i3 < arrayOfByte1.length)
      {
        int i4 = i2 + 1;
        arrayOfByte[i2] = arrayOfByte1[i3];
        i3++;
        i2 = i4;
      }
      n++;
    }
    return arrayOfByte;
  }
  
  private static byte[] aP(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }
  
  static Set<byte[]> gu()
  {
    if (Jd == null) {
      Jd = a(Jc);
    }
    return Jd;
  }
  
  static Set<byte[]> gv()
  {
    if (Je == null) {
      Je = a(Jb);
    }
    return Je;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.b
 * JD-Core Version:    0.7.0.1
 */