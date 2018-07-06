package com.google.android.gms.internal;

import java.security.MessageDigest;

public class ar
  extends ao
{
  private MessageDigest nZ;
  
  byte[] a(String[] paramArrayOfString)
  {
    byte[] arrayOfByte = new byte[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++) {
      arrayOfByte[i] = e(aq.o(paramArrayOfString[i]));
    }
    return arrayOfByte;
  }
  
  byte e(int paramInt)
  {
    return (byte)(paramInt & 0xFF ^ (0xFF00 & paramInt) >> 8 ^ (0xFF0000 & paramInt) >> 16 ^ (0xFF000000 & paramInt) >> 24);
  }
  
  public byte[] l(String paramString)
  {
    byte[] arrayOfByte1 = a(paramString.split(" "));
    this.nZ = bf();
    for (;;)
    {
      byte[] arrayOfByte3;
      synchronized (this.mH)
      {
        if (this.nZ == null)
        {
          byte[] arrayOfByte2 = new byte[0];
          return arrayOfByte2;
        }
        this.nZ.reset();
        this.nZ.update(arrayOfByte1);
        arrayOfByte3 = this.nZ.digest();
        i = 4;
        if (arrayOfByte3.length > i)
        {
          byte[] arrayOfByte4 = new byte[i];
          System.arraycopy(arrayOfByte3, 0, arrayOfByte4, 0, arrayOfByte4.length);
          return arrayOfByte4;
        }
      }
      int i = arrayOfByte3.length;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ar
 * JD-Core Version:    0.7.0.1
 */