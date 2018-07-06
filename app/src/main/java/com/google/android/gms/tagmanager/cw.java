package com.google.android.gms.tagmanager;

class cw
  implements cg
{
  private final long BF;
  private final int BG;
  private double BH;
  private final Object BJ = new Object();
  private long aty;
  
  public cw()
  {
    this(60, 2000L);
  }
  
  public cw(int paramInt, long paramLong)
  {
    this.BG = paramInt;
    this.BH = this.BG;
    this.BF = paramLong;
  }
  
  public boolean fe()
  {
    synchronized (this.BJ)
    {
      long l = System.currentTimeMillis();
      if (this.BH < this.BG)
      {
        double d = (l - this.aty) / this.BF;
        if (d > 0.0D) {
          this.BH = Math.min(this.BG, d + this.BH);
        }
      }
      this.aty = l;
      if (this.BH >= 1.0D)
      {
        this.BH -= 1.0D;
        return true;
      }
      bh.W("No more tokens available.");
      return false;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cw
 * JD-Core Version:    0.7.0.1
 */