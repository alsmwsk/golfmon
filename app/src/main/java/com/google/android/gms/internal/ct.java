package com.google.android.gms.internal;

@ey
public final class ct
  extends da.a
{
  private final Object mH = new Object();
  private cv.a qD;
  private cs qE;
  
  public void a(cs paramcs)
  {
    synchronized (this.mH)
    {
      this.qE = paramcs;
      return;
    }
  }
  
  public void a(cv.a parama)
  {
    synchronized (this.mH)
    {
      this.qD = parama;
      return;
    }
  }
  
  public void onAdClicked()
  {
    synchronized (this.mH)
    {
      if (this.qE != null) {
        this.qE.ai();
      }
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (this.mH)
    {
      if (this.qE != null) {
        this.qE.aj();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (this.mH)
      {
        if (this.qD != null)
        {
          if (paramInt == 3)
          {
            i = 1;
            this.qD.k(i);
            this.qD = null;
          }
        }
        else {
          return;
        }
      }
      int i = 2;
    }
  }
  
  public void onAdLeftApplication()
  {
    synchronized (this.mH)
    {
      if (this.qE != null) {
        this.qE.ak();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (this.mH)
    {
      if (this.qD != null)
      {
        this.qD.k(0);
        this.qD = null;
        return;
      }
      if (this.qE != null) {
        this.qE.am();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (this.mH)
    {
      if (this.qE != null) {
        this.qE.al();
      }
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ct
 * JD-Core Version:    0.7.0.1
 */