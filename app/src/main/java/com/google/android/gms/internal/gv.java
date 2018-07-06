package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ey
public class gv
  extends WebViewClient
{
  private final Object mH = new Object();
  protected final gu mo;
  private cb pP;
  private cg qa;
  private ce qc;
  private v qd;
  private a tu;
  private final HashMap<String, cd> xe = new HashMap();
  private t xf;
  private ds xg;
  private boolean xh = false;
  private boolean xi;
  private dv xj;
  private final dl xk;
  
  public gv(gu paramgu, boolean paramBoolean)
  {
    this(paramgu, paramBoolean, new dl(paramgu, paramgu.getContext(), new bl(paramgu.getContext())));
  }
  
  gv(gu paramgu, boolean paramBoolean, dl paramdl)
  {
    this.mo = paramgu;
    this.xi = paramBoolean;
    this.xk = paramdl;
  }
  
  private static boolean d(Uri paramUri)
  {
    String str = paramUri.getScheme();
    return ("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str));
  }
  
  private void e(Uri paramUri)
  {
    String str1 = paramUri.getPath();
    cd localcd = (cd)this.xe.get(str1);
    if (localcd != null)
    {
      Map localMap = gi.c(paramUri);
      if (gr.v(2))
      {
        gr.V("Received GMSG: " + str1);
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          gr.V("  " + str2 + ": " + (String)localMap.get(str2));
        }
      }
      localcd.a(this.mo, localMap);
      return;
    }
    gr.V("No GMSG handler found for GMSG: " + paramUri);
  }
  
  public final void A(boolean paramBoolean)
  {
    this.xh = paramBoolean;
  }
  
  public final void a(do paramdo)
  {
    boolean bool = this.mo.dH();
    t localt;
    ds localds;
    if ((bool) && (!this.mo.ac().oq))
    {
      localt = null;
      localds = null;
      if (!bool) {
        break label69;
      }
    }
    for (;;)
    {
      a(new dr(paramdo, localt, localds, this.xj, this.mo.dG()));
      return;
      localt = this.xf;
      break;
      label69:
      localds = this.xg;
    }
  }
  
  protected void a(dr paramdr)
  {
    dp.a(this.mo.getContext(), paramdr);
  }
  
  public final void a(a parama)
  {
    this.tu = parama;
  }
  
  public void a(t paramt, ds paramds, cb paramcb, dv paramdv, boolean paramBoolean, ce paramce, cg paramcg, v paramv)
  {
    a(paramt, paramds, paramcb, paramdv, paramBoolean, paramce, paramv);
    a("/setInterstitialProperties", new cf(paramcg));
    this.qa = paramcg;
  }
  
  public void a(t paramt, ds paramds, cb paramcb, dv paramdv, boolean paramBoolean, ce paramce, v paramv)
  {
    if (paramv == null) {
      paramv = new v(false);
    }
    a("/appEvent", new ca(paramcb));
    a("/canOpenURLs", cc.pR);
    a("/canOpenIntents", cc.pS);
    a("/click", cc.pT);
    a("/close", cc.pU);
    a("/customClose", cc.pV);
    a("/httpTrack", cc.pW);
    a("/log", cc.pX);
    a("/open", new ci(paramce, paramv));
    a("/touch", cc.pY);
    a("/video", cc.pZ);
    a("/mraid", new ch());
    this.xf = paramt;
    this.xg = paramds;
    this.pP = paramcb;
    this.qc = paramce;
    this.xj = paramdv;
    this.qd = paramv;
    A(paramBoolean);
  }
  
  public final void a(String paramString, cd paramcd)
  {
    this.xe.put(paramString, paramcd);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if ((this.mo.dH()) && (!this.mo.ac().oq)) {}
    for (t localt = null;; localt = this.xf)
    {
      a(new dr(localt, this.xg, this.xj, this.mo, paramBoolean, paramInt, this.mo.dG()));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    boolean bool = this.mo.dH();
    t localt;
    ds localds;
    if ((bool) && (!this.mo.ac().oq))
    {
      localt = null;
      localds = null;
      if (!bool) {
        break label89;
      }
    }
    for (;;)
    {
      a(new dr(localt, localds, this.pP, this.xj, this.mo, paramBoolean, paramInt, paramString, this.mo.dG(), this.qc));
      return;
      localt = this.xf;
      break;
      label89:
      localds = this.xg;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = this.mo.dH();
    t localt;
    if ((bool) && (!this.mo.ac().oq))
    {
      localt = null;
      if (!bool) {
        break label91;
      }
    }
    label91:
    for (ds localds = null;; localds = this.xg)
    {
      a(new dr(localt, localds, this.pP, this.xj, this.mo, paramBoolean, paramInt, paramString1, paramString2, this.mo.dG(), this.qc));
      return;
      localt = this.xf;
      break;
    }
  }
  
  public final void cg()
  {
    synchronized (this.mH)
    {
      this.xh = false;
      this.xi = true;
      final dp localdp = this.mo.dC();
      if (localdp != null)
      {
        if (!gq.dB()) {
          gq.wR.post(new Runnable()
          {
            public void run()
            {
              localdp.cg();
            }
          });
        }
      }
      else {
        return;
      }
      localdp.cg();
    }
  }
  
  public v dM()
  {
    return this.qd;
  }
  
  public boolean dN()
  {
    synchronized (this.mH)
    {
      boolean bool = this.xi;
      return bool;
    }
  }
  
  public void dO()
  {
    if (dN()) {
      this.xk.bY();
    }
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    gr.V("Loading resource: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
      e(localUri);
    }
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.tu != null)
    {
      this.tu.a(this.mo);
      this.tu = null;
    }
  }
  
  public final void reset()
  {
    synchronized (this.mH)
    {
      this.xe.clear();
      this.xf = null;
      this.xg = null;
      this.tu = null;
      this.pP = null;
      this.xh = false;
      this.xi = false;
      this.qc = null;
      this.xj = null;
      return;
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    gr.V("AdWebView shouldOverrideUrlLoading: " + paramString);
    Object localObject1 = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(((Uri)localObject1).getScheme())) && ("mobileads.google.com".equalsIgnoreCase(((Uri)localObject1).getHost()))) {
      e((Uri)localObject1);
    }
    for (;;)
    {
      return true;
      if ((this.xh) && (paramWebView == this.mo) && (d((Uri)localObject1))) {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (!this.mo.willNotDraw())
      {
        try
        {
          k localk = this.mo.dF();
          if ((localk != null) && (localk.b((Uri)localObject1)))
          {
            Uri localUri = localk.a((Uri)localObject1, this.mo.getContext());
            localObject1 = localUri;
          }
          localObject2 = localObject1;
        }
        catch (l locall)
        {
          for (;;)
          {
            gr.W("Unable to append parameter to URL: " + paramString);
            Object localObject2 = localObject1;
          }
          this.qd.d(paramString);
        }
        if ((this.qd == null) || (this.qd.az())) {
          a(new do("android.intent.action.VIEW", localObject2.toString(), null, null, null, null, null));
        }
      }
      else
      {
        gr.W("AdWebView unable to handle URL: " + paramString);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(gu paramgu);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gv
 * JD-Core Version:    0.7.0.1
 */