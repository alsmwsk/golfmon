package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;

@ey
public class v
{
  private a mk;
  private boolean ml;
  private boolean mm;
  
  public v()
  {
    Bundle localBundle = ga.bN();
    boolean bool1 = false;
    if (localBundle != null)
    {
      boolean bool2 = localBundle.getBoolean("gads:block_autoclicks", false);
      bool1 = false;
      if (bool2) {
        bool1 = true;
      }
    }
    this.mm = bool1;
  }
  
  public v(boolean paramBoolean)
  {
    this.mm = paramBoolean;
  }
  
  public void a(a parama)
  {
    this.mk = parama;
  }
  
  public void av()
  {
    this.ml = true;
  }
  
  public boolean az()
  {
    return (!this.mm) || (this.ml);
  }
  
  public void d(String paramString)
  {
    gr.S("Action was blocked because no click was detected.");
    if (this.mk != null) {
      this.mk.e(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(String paramString);
  }
  
  @ey
  public static class b
    implements v.a
  {
    private final fy.a mn;
    private final gu mo;
    
    public b(fy.a parama, gu paramgu)
    {
      this.mn = parama;
      this.mo = paramgu;
    }
    
    public void e(String paramString)
    {
      gr.S("An auto-clicking creative is blocked");
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("https");
      localBuilder.path("//pagead2.googlesyndication.com/pagead/gen_204");
      localBuilder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
      if (!TextUtils.isEmpty(paramString)) {
        localBuilder.appendQueryParameter("navigationURL", paramString);
      }
      if ((this.mn != null) && (this.mn.vK != null) && (!TextUtils.isEmpty(this.mn.vK.ub))) {
        localBuilder.appendQueryParameter("debugDialog", this.mn.vK.ub);
      }
      gi.c(this.mo.getContext(), this.mo.dG().wS, localBuilder.toString());
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.v
 * JD-Core Version:    0.7.0.1
 */