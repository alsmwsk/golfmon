package com.google.android.gms.internal;

public class qn
{
  private final byte[] ayJ = new byte[256];
  private int ayK;
  private int ayL;
  
  public qn(byte[] paramArrayOfByte)
  {
    for (int i = 0; i < 256; i++) {
      this.ayJ[i] = ((byte)i);
    }
    int j = 0;
    for (int k = 0; k < 256; k++)
    {
      j = 0xFF & j + this.ayJ[k] + paramArrayOfByte[(k % paramArrayOfByte.length)];
      int m = this.ayJ[k];
      this.ayJ[k] = this.ayJ[j];
      this.ayJ[j] = m;
    }
    this.ayK = 0;
    this.ayL = 0;
  }
  
  public void o(byte[] paramArrayOfByte)
  {
    int i = this.ayK;
    int j = this.ayL;
    for (int k = 0; k < paramArrayOfByte.length; k++)
    {
      i = 0xFF & i + 1;
      j = 0xFF & j + this.ayJ[i];
      int m = this.ayJ[i];
      this.ayJ[i] = this.ayJ[j];
      this.ayJ[j] = m;
      paramArrayOfByte[k] = ((byte)(paramArrayOfByte[k] ^ this.ayJ[(0xFF & this.ayJ[i] + this.ayJ[j])]));
    }
    this.ayK = i;
    this.ayL = j;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qn
 * JD-Core Version:    0.7.0.1
 */