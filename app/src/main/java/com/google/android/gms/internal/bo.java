package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

@ey
public final class bo
  extends bq.a
{
  private final w px;
  private final String py;
  private final String pz;
  
  public bo(w paramw, String paramString1, String paramString2)
  {
    this.px = paramw;
    this.py = paramString1;
    this.pz = paramString2;
  }
  
  public void a(d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.px.b((View)e.f(paramd));
  }
  
  public void av()
  {
    this.px.av();
  }
  
  public void aw()
  {
    this.px.aw();
  }
  
  public String bA()
  {
    return this.pz;
  }
  
  public String bz()
  {
    return this.py;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bo
 * JD-Core Version:    0.7.0.1
 */