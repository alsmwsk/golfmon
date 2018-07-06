package com.google.android.gms.internal;

import android.os.Bundle;

@ey
public class gd
{
  private final Object mH = new Object();
  private final ga vL;
  private final String vO;
  private int wr;
  private int ws;
  
  gd(ga paramga, String paramString)
  {
    this.vL = paramga;
    this.vO = paramString;
  }
  
  public gd(String paramString)
  {
    this(ga.dc(), paramString);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    synchronized (this.mH)
    {
      this.wr = paramInt1;
      this.ws = paramInt2;
      this.vL.a(this.vO, this);
      return;
    }
  }
  
  public Bundle toBundle()
  {
    synchronized (this.mH)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", this.wr);
      localBundle.putInt("pmnll", this.ws);
      return localBundle;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gd
 * JD-Core Version:    0.7.0.1
 */