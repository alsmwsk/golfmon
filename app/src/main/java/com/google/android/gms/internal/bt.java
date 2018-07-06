package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

@ey
public class bt
  extends bw.a
  implements bv.a
{
  private final Object mH = new Object();
  private final String pB;
  private final Drawable pC;
  private final String pD;
  private final Drawable pE;
  private final String pF;
  private final double pG;
  private final String pH;
  private final String pI;
  private bv pJ;
  
  public bt(String paramString1, Drawable paramDrawable1, String paramString2, Drawable paramDrawable2, String paramString3, double paramDouble, String paramString4, String paramString5)
  {
    this.pB = paramString1;
    this.pC = paramDrawable1;
    this.pD = paramString2;
    this.pE = paramDrawable2;
    this.pF = paramString3;
    this.pG = paramDouble;
    this.pH = paramString4;
    this.pI = paramString5;
  }
  
  public void a(bv parambv)
  {
    synchronized (this.mH)
    {
      this.pJ = parambv;
      return;
    }
  }
  
  public void aw()
  {
    synchronized (this.mH)
    {
      if (this.pJ == null)
      {
        gr.T("Attempt to record impression before app install ad initialized.");
        return;
      }
      this.pJ.aw();
      return;
    }
  }
  
  public String bB()
  {
    return this.pB;
  }
  
  public d bC()
  {
    return e.k(this.pC);
  }
  
  public d bD()
  {
    return e.k(this.pE);
  }
  
  public String bE()
  {
    return this.pF;
  }
  
  public double bF()
  {
    return this.pG;
  }
  
  public String bG()
  {
    return this.pH;
  }
  
  public String bH()
  {
    return this.pI;
  }
  
  public String getBody()
  {
    return this.pD;
  }
  
  public void j(int paramInt)
  {
    synchronized (this.mH)
    {
      if (this.pJ == null)
      {
        gr.T("Attempt to perform click before app install ad initialized.");
        return;
      }
      this.pJ.b("2", paramInt);
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bt
 * JD-Core Version:    0.7.0.1
 */