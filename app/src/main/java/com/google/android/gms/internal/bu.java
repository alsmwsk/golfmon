package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

@ey
public class bu
  extends bx.a
  implements bv.a
{
  private final Object mH = new Object();
  private final String pB;
  private final Drawable pC;
  private final String pD;
  private final String pF;
  private bv pJ;
  private final Drawable pK;
  private final String pL;
  
  public bu(String paramString1, Drawable paramDrawable1, String paramString2, Drawable paramDrawable2, String paramString3, String paramString4)
  {
    this.pB = paramString1;
    this.pC = paramDrawable1;
    this.pD = paramString2;
    this.pK = paramDrawable2;
    this.pF = paramString3;
    this.pL = paramString4;
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
        gr.T("Attempt to record impression before content ad initialized.");
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
  
  public String bE()
  {
    return this.pF;
  }
  
  public d bI()
  {
    return e.k(this.pK);
  }
  
  public String bJ()
  {
    return this.pL;
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
        gr.T("Attempt to perform click before content ad initialized.");
        return;
      }
      this.pJ.b("1", paramInt);
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bu
 * JD-Core Version:    0.7.0.1
 */