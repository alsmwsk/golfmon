package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.ld;

class bf
  implements cg
{
  private final long BF;
  private final int BG;
  private double BH;
  private long BI;
  private final Object BJ = new Object();
  private final String BK;
  private final long arU;
  private final ld wb;
  
  public bf(int paramInt, long paramLong1, long paramLong2, String paramString, ld paramld)
  {
    this.BG = paramInt;
    this.BH = this.BG;
    this.BF = paramLong1;
    this.arU = paramLong2;
    this.BK = paramString;
    this.wb = paramld;
  }
  
  public boolean fe()
  {
    synchronized (this.BJ)
    {
      long l = this.wb.currentTimeMillis();
      if (l - this.BI < this.arU)
      {
        bh.W("Excessive " + this.BK + " detected; call ignored.");
        return false;
      }
      if (this.BH < this.BG)
      {
        double d = (l - this.BI) / this.BF;
        if (d > 0.0D) {
          this.BH = Math.min(this.BG, d + this.BH);
        }
      }
      this.BI = l;
      if (this.BH >= 1.0D)
      {
        this.BH -= 1.0D;
        return true;
      }
    }
    bh.W("Excessive " + this.BK + " detected; call ignored.");
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bf
 * JD-Core Version:    0.7.0.1
 */