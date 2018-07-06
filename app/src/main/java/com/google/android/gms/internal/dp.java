package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

@ey
public class dp
  extends dx.a
{
  private static final int rL = Color.argb(0, 0, 0, 0);
  private gu mo;
  private final Activity nB;
  private dr rM;
  private dt rN;
  private c rO;
  private du rP;
  private boolean rQ;
  private boolean rR = false;
  private FrameLayout rS;
  private WebChromeClient.CustomViewCallback rT;
  private boolean rU = false;
  private boolean rV = false;
  private boolean rW = false;
  private RelativeLayout rX;
  
  public dp(Activity paramActivity)
  {
    this.nB = paramActivity;
  }
  
  private static RelativeLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    return localLayoutParams;
  }
  
  public static void a(Context paramContext, dr paramdr)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramdr.lO.wV);
    dr.a(localIntent, paramdr);
    if (!ll.in()) {
      localIntent.addFlags(524288);
    }
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void X()
  {
    this.rQ = true;
  }
  
  public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.rS = new FrameLayout(this.nB);
    this.rS.setBackgroundColor(-16777216);
    this.rS.addView(paramView, -1, -1);
    this.nB.setContentView(this.rS);
    X();
    this.rT = paramCustomViewCallback;
    this.rR = true;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.rN != null) {
      this.rN.setLayoutParams(a(paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.rN == null)
    {
      this.rN = new dt(this.nB, this.mo);
      this.rX.addView(this.rN, 0, a(paramInt1, paramInt2, paramInt3, paramInt4));
      this.mo.dD().A(false);
    }
  }
  
  public dt ce()
  {
    return this.rN;
  }
  
  public void cf()
  {
    if ((this.rM != null) && (this.rR)) {
      setRequestedOrientation(this.rM.orientation);
    }
    if (this.rS != null)
    {
      this.nB.setContentView(this.rX);
      X();
      this.rS.removeAllViews();
      this.rS = null;
    }
    if (this.rT != null)
    {
      this.rT.onCustomViewHidden();
      this.rT = null;
    }
    this.rR = false;
  }
  
  public void cg()
  {
    this.rX.removeView(this.rP);
    p(true);
  }
  
  void ch()
  {
    if ((!this.nB.isFinishing()) || (this.rV)) {}
    do
    {
      do
      {
        return;
        this.rV = true;
      } while (!this.nB.isFinishing());
      if (this.mo != null)
      {
        cj();
        this.rX.removeView(this.mo);
        if (this.rO != null)
        {
          this.mo.z(false);
          this.rO.sa.addView(this.mo, this.rO.index, this.rO.rZ);
        }
      }
    } while ((this.rM == null) || (this.rM.sd == null));
    this.rM.sd.ag();
  }
  
  void ci()
  {
    this.mo.ci();
  }
  
  void cj()
  {
    this.mo.cj();
  }
  
  public void close()
  {
    this.nB.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    this.rU = bool;
    do
    {
      try
      {
        this.rM = dr.b(this.nB.getIntent());
        if (this.rM == null) {
          throw new a("Could not get info for ad overlay.");
        }
      }
      catch (a locala)
      {
        gr.W(locala.getMessage());
        this.nB.finish();
        return;
      }
      if (this.rM.sn != null) {}
      for (this.rW = this.rM.sn.mi;; this.rW = false)
      {
        if (paramBundle == null)
        {
          if (this.rM.sd != null) {
            this.rM.sd.ah();
          }
          if ((this.rM.sk != 1) && (this.rM.sc != null)) {
            this.rM.sc.onAdClicked();
          }
        }
        switch (this.rM.sk)
        {
        default: 
          throw new a("Could not determine ad overlay type.");
        }
      }
      r(false);
      return;
      this.rO = new c(this.rM.se);
      r(false);
      return;
      r(true);
      return;
      if (this.rU)
      {
        this.nB.finish();
        return;
      }
    } while (dm.a(this.nB, this.rM.sb, this.rM.sj));
    this.nB.finish();
  }
  
  public void onDestroy()
  {
    if (this.rN != null) {
      this.rN.destroy();
    }
    if (this.mo != null) {
      this.rX.removeView(this.mo);
    }
    ch();
  }
  
  public void onPause()
  {
    if (this.rN != null) {
      this.rN.pause();
    }
    cf();
    if ((this.mo != null) && ((!this.nB.isFinishing()) || (this.rO == null))) {
      gi.a(this.mo);
    }
    ch();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((this.rM != null) && (this.rM.sk == 4))
    {
      if (!this.rU) {
        break label47;
      }
      this.nB.finish();
    }
    for (;;)
    {
      if (this.mo != null) {
        gi.b(this.mo);
      }
      return;
      label47:
      this.rU = true;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.rU);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    ch();
  }
  
  public void p(boolean paramBoolean)
  {
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      this.rP = new du(this.nB, i);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (int j = 11;; j = 9)
    {
      localLayoutParams.addRule(j);
      this.rP.q(this.rM.sh);
      this.rX.addView(this.rP, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  public void q(boolean paramBoolean)
  {
    if (this.rP != null) {
      this.rP.q(paramBoolean);
    }
  }
  
  void r(boolean paramBoolean)
    throws dp.a
  {
    if (!this.rQ) {
      this.nB.requestWindowFeature(1);
    }
    Window localWindow = this.nB.getWindow();
    if ((!this.rW) || (this.rM.sn.ms)) {
      localWindow.setFlags(1024, 1024);
    }
    setRequestedOrientation(this.rM.orientation);
    if (Build.VERSION.SDK_INT >= 11)
    {
      gr.S("Enabling hardware acceleration on the AdActivity window.");
      gm.a(localWindow);
    }
    this.rX = new b(this.nB, this.rM.sm);
    boolean bool;
    if (!this.rW)
    {
      this.rX.setBackgroundColor(-16777216);
      this.nB.setContentView(this.rX);
      X();
      bool = this.rM.se.dD().dN();
      if (!paramBoolean) {
        break label440;
      }
      this.mo = gu.a(this.nB, this.rM.se.ac(), true, bool, null, this.rM.lO);
      this.mo.dD().a(null, null, this.rM.sf, this.rM.sj, true, this.rM.sl, this.rM.se.dD().dM());
      this.mo.dD().a(new gv.a()
      {
        public void a(gu paramAnonymousgu)
        {
          paramAnonymousgu.ci();
        }
      });
      if (this.rM.rH == null) {
        break label388;
      }
      this.mo.loadUrl(this.rM.rH);
    }
    for (;;)
    {
      this.mo.a(this);
      ViewParent localViewParent = this.mo.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(this.mo);
      }
      if (this.rW) {
        this.mo.setBackgroundColor(rL);
      }
      this.rX.addView(this.mo, -1, -1);
      if (!paramBoolean) {
        ci();
      }
      p(bool);
      if (this.mo.dE()) {
        q(true);
      }
      return;
      this.rX.setBackgroundColor(rL);
      break;
      label388:
      if (this.rM.si != null)
      {
        this.mo.loadDataWithBaseURL(this.rM.sg, this.rM.si, "text/html", "UTF-8", null);
      }
      else
      {
        throw new a("No URL or HTML to display in ad overlay.");
        label440:
        this.mo = this.rM.se;
        this.mo.setContext(this.nB);
      }
    }
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.nB.setRequestedOrientation(paramInt);
  }
  
  @ey
  private static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  @ey
  private static final class b
    extends RelativeLayout
  {
    private final gl lJ;
    
    public b(Context paramContext, String paramString)
    {
      super();
      this.lJ = new gl(paramContext, paramString);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.lJ.c(paramMotionEvent);
      return false;
    }
  }
  
  @ey
  private static final class c
  {
    public final int index;
    public final ViewGroup.LayoutParams rZ;
    public final ViewGroup sa;
    
    public c(gu paramgu)
      throws dp.a
    {
      this.rZ = paramgu.getLayoutParams();
      ViewParent localViewParent = paramgu.getParent();
      if ((localViewParent instanceof ViewGroup))
      {
        this.sa = ((ViewGroup)localViewParent);
        this.index = this.sa.indexOfChild(paramgu);
        this.sa.removeView(paramgu);
        paramgu.z(true);
        return;
      }
      throw new dp.a("Could not get the parent of the WebView for an overlay.");
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dp
 * JD-Core Version:    0.7.0.1
 */