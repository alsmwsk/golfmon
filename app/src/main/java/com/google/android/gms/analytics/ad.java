package com.google.android.gms.analytics;

class ad
  implements ah
{
  private final long BF;
  private final int BG;
  private double BH;
  private long BI;
  private final Object BJ = new Object();
  private final String BK;
  
  public ad(int paramInt, long paramLong, String paramString)
  {
    this.BG = paramInt;
    this.BH = this.BG;
    this.BF = paramLong;
    this.BK = paramString;
  }
  
  public ad(String paramString)
  {
    this(60, 2000L, paramString);
  }
  
  public boolean fe()
  {
    synchronized (this.BJ)
    {
      long l = System.currentTimeMillis();
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
      ae.W("Excessive " + this.BK + " detected; call ignored.");
      return false;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ad
 * JD-Core Version:    0.7.0.1
 */