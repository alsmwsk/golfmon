package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@ey
public class u
  extends bd.a
  implements cb, ce, cg, cs, ds, dv, ej, ez.a, fc.a, gc, t, w
{
  private final cy lA;
  private final b lB;
  private final ab lC;
  private final ae lD;
  private boolean lE;
  private final ComponentCallbacks lF = new ComponentCallbacks()
  {
    public void onConfigurationChanged(Configuration paramAnonymousConfiguration)
    {
      if ((u.a(u.this) != null) && (u.a(u.this).lT != null) && (u.a(u.this).lT.se != null)) {
        u.a(u.this).lT.se.cb();
      }
    }
    
    public void onLowMemory() {}
  };
  private av lz;
  
  public u(Context paramContext, ay paramay, String paramString, cy paramcy, gs paramgs)
  {
    this(new b(paramContext, paramay, paramString, paramgs), paramcy, null);
  }
  
  u(b paramb, cy paramcy, ab paramab)
  {
    this.lB = paramb;
    this.lA = paramcy;
    if (paramab != null) {}
    for (;;)
    {
      this.lC = paramab;
      this.lD = new ae();
      gi.q(this.lB.lM);
      ga.a(this.lB.lM, this.lB.lO);
      ad();
      return;
      paramab = new ab(this);
    }
  }
  
  private fh.a a(av paramav, Bundle paramBundle)
  {
    ApplicationInfo localApplicationInfo = this.lB.lM.getApplicationInfo();
    try
    {
      PackageInfo localPackageInfo2 = this.lB.lM.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      localPackageInfo1 = localPackageInfo2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        boolean bool1;
        Bundle localBundle1;
        ViewParent localViewParent;
        int[] arrayOfInt;
        int i;
        int j;
        DisplayMetrics localDisplayMetrics;
        int k;
        int m;
        boolean bool2;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        String str;
        Bundle localBundle2;
        PackageInfo localPackageInfo1 = null;
      }
    }
    bool1 = this.lB.lS.oq;
    localBundle1 = null;
    if (!bool1)
    {
      localViewParent = this.lB.lK.getParent();
      localBundle1 = null;
      if (localViewParent != null)
      {
        arrayOfInt = new int[2];
        this.lB.lK.getLocationOnScreen(arrayOfInt);
        i = arrayOfInt[0];
        j = arrayOfInt[1];
        localDisplayMetrics = this.lB.lM.getResources().getDisplayMetrics();
        k = this.lB.lK.getWidth();
        m = this.lB.lK.getHeight();
        bool2 = this.lB.lK.isShown();
        n = 0;
        if (bool2)
        {
          i1 = i + k;
          n = 0;
          if (i1 > 0)
          {
            i2 = j + m;
            n = 0;
            if (i2 > 0)
            {
              i3 = localDisplayMetrics.widthPixels;
              n = 0;
              if (i <= i3)
              {
                i4 = localDisplayMetrics.heightPixels;
                n = 0;
                if (j <= i4) {
                  n = 1;
                }
              }
            }
          }
        }
        localBundle1 = new Bundle(5);
        localBundle1.putInt("x", i);
        localBundle1.putInt("y", j);
        localBundle1.putInt("width", k);
        localBundle1.putInt("height", m);
        localBundle1.putInt("visible", n);
      }
    }
    str = ga.df();
    this.lB.lV = new fz(str, this.lB.lL);
    this.lB.lV.e(paramav);
    localBundle2 = ga.a(this.lB.lM, this, str);
    return new fh.a(localBundle1, paramav, this.lB.lS, this.lB.lL, localApplicationInfo, localPackageInfo1, str, ga.vY, this.lB.lO, localBundle2, this.lB.mc, paramBundle, ga.dl());
  }
  
  private gu a(v paramv)
  {
    if (this.lB.lS.oq)
    {
      gu localgu2 = gu.a(this.lB.lM, this.lB.lS, false, false, this.lB.lN, this.lB.lO);
      localgu2.dD().a(this, null, this, this, true, this, this, paramv);
      return localgu2;
    }
    View localView = this.lB.lK.getNextView();
    gu localgu1;
    if ((localView instanceof gu))
    {
      localgu1 = (gu)localView;
      localgu1.a(this.lB.lM, this.lB.lS);
    }
    for (;;)
    {
      localgu1.dD().a(this, this, this, this, false, this, paramv);
      return localgu1;
      if (localView != null) {
        this.lB.lK.removeView(localView);
      }
      localgu1 = gu.a(this.lB.lM, this.lB.lS, false, false, this.lB.lN, this.lB.lO);
      if (this.lB.lS.or == null) {
        c(localgu1);
      }
    }
  }
  
  private void a(int paramInt)
  {
    gr.W("Failed to load ad: " + paramInt);
    if (this.lB.lP != null) {}
    try
    {
      this.lB.lP.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
  }
  
  private void ad()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.lB != null) && (this.lB.lM != null)) {
      this.lB.lM.registerComponentCallbacks(this.lF);
    }
  }
  
  private void ae()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.lB != null) && (this.lB.lM != null)) {
      this.lB.lM.unregisterComponentCallbacks(this.lF);
    }
  }
  
  private void ao()
  {
    gr.U("Ad closing.");
    if (this.lB.lP != null) {}
    try
    {
      this.lB.lP.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call AdListener.onAdClosed().", localRemoteException);
    }
  }
  
  private void ap()
  {
    gr.U("Ad leaving application.");
    if (this.lB.lP != null) {}
    try
    {
      this.lB.lP.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  private void aq()
  {
    gr.U("Ad opening.");
    if (this.lB.lP != null) {}
    try
    {
      this.lB.lP.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call AdListener.onAdOpened().", localRemoteException);
    }
  }
  
  private void ar()
  {
    gr.U("Ad finished loading.");
    if (this.lB.lP != null) {}
    try
    {
      this.lB.lP.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
  }
  
  private void as()
  {
    try
    {
      if (((this.lB.lT.vI instanceof bt)) && (this.lB.lZ != null)) {
        this.lB.lZ.a((bt)this.lB.lT.vI);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", localRemoteException);
    }
  }
  
  private void at()
  {
    try
    {
      if (((this.lB.lT.vI instanceof bu)) && (this.lB.ma != null)) {
        this.lB.ma.a((bu)this.lB.lT.vI);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", localRemoteException);
    }
  }
  
  private void ax()
  {
    if (this.lB.lT != null)
    {
      if (this.lB.mg == 0) {
        this.lB.lT.se.destroy();
      }
      this.lB.lT = null;
      this.lB.mi = false;
    }
  }
  
  /* Error */
  private boolean b(fy paramfy)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 421	com/google/android/gms/internal/fy:tW	Z
    //   4: ifeq +193 -> 197
    //   7: aload_1
    //   8: getfield 425	com/google/android/gms/internal/fy:qQ	Lcom/google/android/gms/internal/cz;
    //   11: invokeinterface 431 1 0
    //   16: invokestatic 437	com/google/android/gms/dynamic/e:f	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   19: checkcast 439	android/view/View
    //   22: astore 5
    //   24: aload_0
    //   25: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   28: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   31: invokevirtual 258	com/google/android/gms/internal/u$a:getNextView	()Landroid/view/View;
    //   34: astore 6
    //   36: aload 6
    //   38: ifnull +15 -> 53
    //   41: aload_0
    //   42: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   45: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   48: aload 6
    //   50: invokevirtual 268	com/google/android/gms/internal/u$a:removeView	(Landroid/view/View;)V
    //   53: aload_0
    //   54: aload 5
    //   56: invokespecial 275	com/google/android/gms/internal/u:c	(Landroid/view/View;)V
    //   59: aload_0
    //   60: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   63: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   66: invokevirtual 442	com/google/android/gms/internal/u$a:getChildCount	()I
    //   69: iconst_1
    //   70: if_icmple +13 -> 83
    //   73: aload_0
    //   74: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   77: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   80: invokevirtual 445	com/google/android/gms/internal/u$a:showNext	()V
    //   83: aload_0
    //   84: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   87: getfield 367	com/google/android/gms/internal/u$b:lT	Lcom/google/android/gms/internal/fy;
    //   90: ifnull +70 -> 160
    //   93: aload_0
    //   94: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   97: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   100: invokevirtual 258	com/google/android/gms/internal/u$a:getNextView	()Landroid/view/View;
    //   103: astore_2
    //   104: aload_2
    //   105: instanceof 242
    //   108: ifeq +162 -> 270
    //   111: aload_2
    //   112: checkcast 242	com/google/android/gms/internal/gu
    //   115: aload_0
    //   116: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   119: getfield 78	com/google/android/gms/internal/u$b:lM	Landroid/content/Context;
    //   122: aload_0
    //   123: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   126: getfield 129	com/google/android/gms/internal/u$b:lS	Lcom/google/android/gms/internal/ay;
    //   129: invokevirtual 261	com/google/android/gms/internal/gu:a	(Landroid/content/Context;Lcom/google/android/gms/internal/ay;)V
    //   132: aload_0
    //   133: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   136: getfield 367	com/google/android/gms/internal/u$b:lT	Lcom/google/android/gms/internal/fy;
    //   139: getfield 425	com/google/android/gms/internal/fy:qQ	Lcom/google/android/gms/internal/cz;
    //   142: ifnull +18 -> 160
    //   145: aload_0
    //   146: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   149: getfield 367	com/google/android/gms/internal/u$b:lT	Lcom/google/android/gms/internal/fy;
    //   152: getfield 425	com/google/android/gms/internal/fy:qQ	Lcom/google/android/gms/internal/cz;
    //   155: invokeinterface 446 1 0
    //   160: aload_0
    //   161: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   164: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   167: iconst_0
    //   168: invokevirtual 449	com/google/android/gms/internal/u$a:setVisibility	(I)V
    //   171: iconst_1
    //   172: ireturn
    //   173: astore 4
    //   175: ldc_w 451
    //   178: aload 4
    //   180: invokestatic 314	com/google/android/gms/internal/gr:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 7
    //   187: ldc_w 453
    //   190: aload 7
    //   192: invokestatic 314	com/google/android/gms/internal/gr:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: iconst_0
    //   196: ireturn
    //   197: aload_1
    //   198: getfield 456	com/google/android/gms/internal/fy:vF	Lcom/google/android/gms/internal/ay;
    //   201: ifnull -142 -> 59
    //   204: aload_1
    //   205: getfield 408	com/google/android/gms/internal/fy:se	Lcom/google/android/gms/internal/gu;
    //   208: aload_1
    //   209: getfield 456	com/google/android/gms/internal/fy:vF	Lcom/google/android/gms/internal/ay;
    //   212: invokevirtual 459	com/google/android/gms/internal/gu:a	(Lcom/google/android/gms/internal/ay;)V
    //   215: aload_0
    //   216: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   219: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   222: invokevirtual 462	com/google/android/gms/internal/u$a:removeAllViews	()V
    //   225: aload_0
    //   226: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   229: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   232: aload_1
    //   233: getfield 456	com/google/android/gms/internal/fy:vF	Lcom/google/android/gms/internal/ay;
    //   236: getfield 463	com/google/android/gms/internal/ay:widthPixels	I
    //   239: invokevirtual 466	com/google/android/gms/internal/u$a:setMinimumWidth	(I)V
    //   242: aload_0
    //   243: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   246: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   249: aload_1
    //   250: getfield 456	com/google/android/gms/internal/fy:vF	Lcom/google/android/gms/internal/ay;
    //   253: getfield 467	com/google/android/gms/internal/ay:heightPixels	I
    //   256: invokevirtual 470	com/google/android/gms/internal/u$a:setMinimumHeight	(I)V
    //   259: aload_0
    //   260: aload_1
    //   261: getfield 408	com/google/android/gms/internal/fy:se	Lcom/google/android/gms/internal/gu;
    //   264: invokespecial 275	com/google/android/gms/internal/u:c	(Landroid/view/View;)V
    //   267: goto -208 -> 59
    //   270: aload_2
    //   271: ifnull -139 -> 132
    //   274: aload_0
    //   275: getfield 65	com/google/android/gms/internal/u:lB	Lcom/google/android/gms/internal/u$b;
    //   278: getfield 138	com/google/android/gms/internal/u$b:lK	Lcom/google/android/gms/internal/u$a;
    //   281: aload_2
    //   282: invokevirtual 268	com/google/android/gms/internal/u$a:removeView	(Landroid/view/View;)V
    //   285: goto -153 -> 132
    //   288: astore_3
    //   289: ldc_w 472
    //   292: invokestatic 299	com/google/android/gms/internal/gr:W	(Ljava/lang/String;)V
    //   295: goto -135 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	u
    //   0	298	1	paramfy	fy
    //   103	179	2	localView1	View
    //   288	1	3	localRemoteException1	RemoteException
    //   173	6	4	localRemoteException2	RemoteException
    //   22	33	5	localView2	View
    //   34	15	6	localView3	View
    //   185	6	7	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   7	24	173	android/os/RemoteException
    //   53	59	185	java/lang/Throwable
    //   145	160	288	android/os/RemoteException
  }
  
  private void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.lB.lK.addView(paramView, localLayoutParams);
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.lB.lT == null) {
      gr.W("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      gr.S("Pinging Impression URLs.");
      this.lB.lV.cW();
      if (this.lB.lT.qx != null) {
        gi.a(this.lB.lM, this.lB.lO.wS, this.lB.lT.qx);
      }
      if ((this.lB.lT.vE != null) && (this.lB.lT.vE.qx != null)) {
        cw.a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, paramBoolean, this.lB.lT.vE.qx);
      }
    } while ((this.lB.lT.qP == null) || (this.lB.lT.qP.qs == null));
    cw.a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, paramBoolean, this.lB.lT.qP.qs);
  }
  
  Bundle a(an paraman)
  {
    if (paraman == null) {}
    for (;;)
    {
      return null;
      if (paraman.be()) {
        paraman.wakeup();
      }
      ak localak = paraman.bc();
      String str;
      if (localak != null)
      {
        str = localak.aT();
        gr.S("In AdManger: loadAd, " + localak.toString());
      }
      while (str != null)
      {
        Bundle localBundle = new Bundle(1);
        localBundle.putString("fingerprint", str);
        localBundle.putInt("v", 1);
        return localBundle;
        str = null;
      }
    }
  }
  
  public void a(ay paramay)
  {
    jx.aU("setAdSize must be called on the main UI thread.");
    this.lB.lS = paramay;
    if ((this.lB.lT != null) && (this.lB.mg == 0)) {
      this.lB.lT.se.a(paramay);
    }
    if (this.lB.lK.getChildCount() > 1) {
      this.lB.lK.removeView(this.lB.lK.getNextView());
    }
    this.lB.lK.setMinimumWidth(paramay.widthPixels);
    this.lB.lK.setMinimumHeight(paramay.heightPixels);
    this.lB.lK.requestLayout();
  }
  
  public void a(bc parambc)
  {
    jx.aU("setAdListener must be called on the main UI thread.");
    this.lB.lP = parambc;
  }
  
  public void a(bf parambf)
  {
    jx.aU("setAppEventListener must be called on the main UI thread.");
    this.lB.lW = parambf;
  }
  
  public void a(br parambr)
  {
    jx.aU("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
    this.lB.mb = parambr;
  }
  
  public void a(en paramen)
  {
    jx.aU("setInAppPurchaseListener must be called on the main UI thread.");
    this.lB.lY = paramen;
  }
  
  public void a(er paramer, String paramString)
  {
    jx.aU("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.lB.md = new ek(paramString);
    this.lB.lX = paramer;
    if ((!ga.dj()) && (paramer != null)) {
      new ec(this.lB.lM, this.lB.lX, this.lB.md).start();
    }
  }
  
  public void a(fy.a parama)
  {
    this.lB.lQ = null;
    this.lB.lU = parama;
    a(null);
    gu localgu;
    if (!parama.vK.ug)
    {
      final v localv = new v();
      localgu = a(localv);
      localv.a(new v.b(parama, localgu));
      localgu.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          localv.av();
          return false;
        }
      });
      localgu.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localv.av();
        }
      });
    }
    for (;;)
    {
      if (parama.lS != null) {
        this.lB.lS = parama.lS;
      }
      if (parama.errorCode != -2)
      {
        a(new fy(parama, localgu, null, null, null, null, null));
        return;
      }
      if ((!parama.vK.tW) && (parama.vK.uf))
      {
        String str1 = parama.vK.sg;
        String str2 = null;
        if (str1 != null) {
          str2 = Uri.parse(parama.vK.sg).buildUpon().query(null).build().toString();
        }
        bo localbo = new bo(this, str2, parama.vK.tU);
        try
        {
          if (this.lB.mb != null)
          {
            this.lB.mg = 1;
            this.lB.mb.a(localbo);
            return;
          }
        }
        catch (RemoteException localRemoteException)
        {
          gr.d("Could not call the onCustomRenderedAdLoadedListener.", localRemoteException);
        }
      }
      this.lB.mg = 0;
      b localb = this.lB;
      Context localContext = this.lB.lM;
      cy localcy = this.lA;
      localb.lR = fc.a(localContext, this, parama, localgu, localcy, this);
      return;
      localgu = null;
    }
  }
  
  public void a(fy paramfy)
  {
    this.lB.lR = null;
    if (paramfy.vI != null) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramfy.errorCode != -2) && (paramfy.errorCode != 3)) {
        ga.b(this.lB.ay());
      }
      if (paramfy.errorCode != -1) {
        break;
      }
      return;
    }
    if (a(paramfy, bool)) {
      gr.S("Ad refresh scheduled.");
    }
    if ((paramfy.errorCode == 3) && (paramfy.vE != null) && (paramfy.vE.qy != null))
    {
      gr.S("Pinging no fill URLs.");
      cw.a(this.lB.lM, this.lB.lO.wS, paramfy, this.lB.lL, false, paramfy.vE.qy);
    }
    if (paramfy.errorCode != -2)
    {
      a(paramfy.errorCode);
      return;
    }
    if ((!this.lB.lS.oq) && (!bool) && (this.lB.mg == 0))
    {
      if (!b(paramfy))
      {
        a(0);
        return;
      }
      if (this.lB.lK != null) {
        a.a(this.lB.lK).Q(paramfy.ub);
      }
    }
    if ((this.lB.lT != null) && (this.lB.lT.qS != null)) {
      this.lB.lT.qS.a(null);
    }
    if (paramfy.qS != null) {
      paramfy.qS.a(this);
    }
    this.lD.d(this.lB.lT);
    this.lB.lT = paramfy;
    this.lB.lV.j(paramfy.vG);
    this.lB.lV.k(paramfy.vH);
    this.lB.lV.v(this.lB.lS.oq);
    this.lB.lV.w(paramfy.tW);
    if ((!this.lB.lS.oq) && (!bool) && (this.lB.mg == 0)) {
      e(false);
    }
    if (this.lB.me == null) {
      this.lB.me = new gd(this.lB.lL);
    }
    int j;
    int i;
    if (paramfy.vE != null)
    {
      j = paramfy.vE.qB;
      i = paramfy.vE.qC;
    }
    for (;;)
    {
      this.lB.me.d(j, i);
      if (this.lB.mg == 0)
      {
        if ((!this.lB.lS.oq) && (paramfy.se != null) && ((paramfy.se.dD().dN()) || (paramfy.vD != null)))
        {
          af localaf = this.lD.a(this.lB.lS, this.lB.lT);
          if ((paramfy.se.dD().dN()) && (localaf != null)) {
            localaf.a(new aa(paramfy.se));
          }
        }
        if (this.lB.lT.se != null)
        {
          this.lB.lT.se.cb();
          this.lB.lT.se.dD().dO();
        }
        bv.a locala;
        if (bool)
        {
          locala = paramfy.vI;
          if ((!(locala instanceof bu)) || (this.lB.ma == null)) {
            break label648;
          }
          at();
        }
        for (;;)
        {
          ar();
          return;
          label648:
          if ((!(locala instanceof bt)) || (this.lB.lZ == null)) {
            break;
          }
          as();
        }
        gr.W("No matching listener for retrieved native ad template.");
        a(0);
        return;
      }
      if ((this.lB.mf == null) || (paramfy.vD == null)) {
        break;
      }
      this.lD.a(this.lB.lM, this.lB.lS, this.lB.lT, this.lB.mf, this.lB.lO);
      return;
      i = 0;
      j = 0;
    }
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    ed localed = new ed(paramString, paramArrayList, this.lB.lM, this.lB.lO.wS);
    if (this.lB.lY == null)
    {
      gr.W("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.lB.lM) != 0)
      {
        gr.W("Google Play Service unavailable, cannot launch default purchase flow.");
        return;
      }
      if (this.lB.lX == null)
      {
        gr.W("PlayStorePurchaseListener is not set.");
        return;
      }
      if (this.lB.md == null)
      {
        gr.W("PlayStorePurchaseVerifier is not initialized.");
        return;
      }
      if (this.lB.mh)
      {
        gr.W("An in-app purchase request is already in progress, abort");
        return;
      }
      this.lB.mh = true;
      try
      {
        if (!this.lB.lX.isValidPurchase(paramString))
        {
          this.lB.mh = false;
          return;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        gr.W("Could not start In-App purchase.");
        this.lB.mh = false;
        return;
      }
      ee.a(this.lB.lM, this.lB.lO.wV, new ea(this.lB.lM, this.lB.md, localed, this));
      return;
    }
    try
    {
      this.lB.lY.a(localed);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      gr.W("Could not start In-App purchase.");
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, final Intent paramIntent, ef paramef)
  {
    try
    {
      if (this.lB.lX != null) {
        this.lB.lX.a(new eg(this.lB.lM, paramString, paramBoolean, paramInt, paramIntent, paramef));
      }
      gq.wR.postDelayed(new Runnable()
      {
        public void run()
        {
          if ((ei.d(paramIntent) == 0) && (u.a(u.this).lT != null) && (u.a(u.this).lT.se != null) && (u.a(u.this).lT.se.dC() != null)) {
            u.a(u.this).lT.se.dC().close();
          }
          u.a(u.this).mh = false;
        }
      }, 500L);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.W("Fail to invoke PlayStorePurchaseListener.");
      }
    }
  }
  
  public void a(HashSet<fz> paramHashSet)
  {
    this.lB.a(paramHashSet);
  }
  
  public void a(List<String> paramList)
  {
    jx.aU("setNativeTemplates must be called on the main UI thread.");
    this.lB.mc = paramList;
  }
  
  public boolean a(av paramav)
  {
    jx.aU("loadAd must be called on the main UI thread.");
    if ((this.lB.lQ != null) || (this.lB.lR != null))
    {
      if (this.lz != null) {
        gr.W("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
      }
      this.lz = paramav;
    }
    do
    {
      return false;
      if ((this.lB.lS.oq) && (this.lB.lT != null))
      {
        gr.W("An interstitial is already loading. Aborting.");
        return false;
      }
    } while (!au());
    gr.U("Starting ad request.");
    if (!paramav.og) {
      gr.U("Use AdRequest.Builder.addTestDevice(\"" + gq.v(this.lB.lM) + "\") to get test ads on this device.");
    }
    Bundle localBundle = a(ga.dc().l(this.lB.lM));
    this.lC.cancel();
    this.lB.mg = 0;
    fh.a locala = a(paramav, localBundle);
    this.lB.lQ = ez.a(this.lB.lM, locala, this.lB.lN, this);
    return true;
  }
  
  boolean a(fy paramfy, boolean paramBoolean)
  {
    boolean bool1 = false;
    av localav;
    boolean bool2;
    if (this.lz != null)
    {
      localav = this.lz;
      this.lz = null;
      bool2 = bool1 | paramBoolean;
      if (!this.lB.lS.oq) {
        break label99;
      }
      if (this.lB.mg == 0) {
        gi.a(paramfy.se);
      }
    }
    for (;;)
    {
      return this.lC.aD();
      localav = paramfy.tL;
      Bundle localBundle = localav.extras;
      bool1 = false;
      if (localBundle == null) {
        break;
      }
      bool1 = localav.extras.getBoolean("_noRefresh", false);
      break;
      label99:
      if ((!bool2) && (this.lB.mg == 0)) {
        if (paramfy.qA > 0L) {
          this.lC.a(localav, paramfy.qA);
        } else if ((paramfy.vE != null) && (paramfy.vE.qA > 0L)) {
          this.lC.a(localav, paramfy.vE.qA);
        } else if ((!paramfy.tW) && (paramfy.errorCode == 2)) {
          this.lC.c(localav);
        }
      }
    }
  }
  
  public d ab()
  {
    jx.aU("getAdFrame must be called on the main UI thread.");
    return e.k(this.lB.lK);
  }
  
  public ay ac()
  {
    jx.aU("getAdSize must be called on the main UI thread.");
    return this.lB.lS;
  }
  
  public void af()
  {
    ap();
  }
  
  public void ag()
  {
    this.lD.d(this.lB.lT);
    if (this.lB.lS.oq) {
      ax();
    }
    this.lE = false;
    ao();
    this.lB.lV.cY();
  }
  
  public void ah()
  {
    if (this.lB.lS.oq) {
      e(false);
    }
    this.lE = true;
    aq();
  }
  
  public void ai()
  {
    onAdClicked();
  }
  
  public void aj()
  {
    ag();
  }
  
  public void ak()
  {
    af();
  }
  
  public void al()
  {
    ah();
  }
  
  public void am()
  {
    if (this.lB.lT != null) {
      gr.W("Mediation adapter " + this.lB.lT.qR + " refreshed, but mediation adapters should never refresh.");
    }
    e(true);
    ar();
  }
  
  public void an()
  {
    jx.aU("recordManualImpression must be called on the main UI thread.");
    if (this.lB.lT == null) {
      gr.W("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      gr.S("Pinging manual tracking URLs.");
    } while (this.lB.lT.tY == null);
    gi.a(this.lB.lM, this.lB.lO.wS, this.lB.lT.tY);
  }
  
  public boolean au()
  {
    boolean bool = true;
    if (!gi.a(this.lB.lM.getPackageManager(), this.lB.lM.getPackageName(), "android.permission.INTERNET"))
    {
      if (!this.lB.lS.oq) {
        gq.a(this.lB.lK, this.lB.lS, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      }
      bool = false;
    }
    if (!gi.p(this.lB.lM))
    {
      if (!this.lB.lS.oq) {
        gq.a(this.lB.lK, this.lB.lS, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      }
      bool = false;
    }
    if ((!bool) && (!this.lB.lS.oq)) {
      this.lB.lK.setVisibility(0);
    }
    return bool;
  }
  
  public void av()
  {
    if (this.lB.lT == null) {
      gr.W("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      gr.S("Pinging click URLs.");
      this.lB.lV.cX();
      if (this.lB.lT.qw != null) {
        gi.a(this.lB.lM, this.lB.lO.wS, this.lB.lT.qw);
      }
    } while ((this.lB.lT.vE == null) || (this.lB.lT.vE.qw == null));
    cw.a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, false, this.lB.lT.vE.qw);
  }
  
  public void aw()
  {
    e(false);
  }
  
  public void b(View paramView)
  {
    this.lB.mf = paramView;
    a(new fy(this.lB.lU, null, null, null, null, null, null));
  }
  
  public void b(av paramav)
  {
    ViewParent localViewParent = this.lB.lK.getParent();
    if (((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (gi.dt()) && (!this.lE))
    {
      a(paramav);
      return;
    }
    gr.U("Ad is not visible. Not refreshing ad.");
    this.lC.c(paramav);
  }
  
  public void d(boolean paramBoolean)
  {
    this.lB.mi = paramBoolean;
  }
  
  public void destroy()
  {
    jx.aU("destroy must be called on the main UI thread.");
    ae();
    this.lB.lP = null;
    this.lB.lW = null;
    this.lB.lX = null;
    this.lB.lY = null;
    this.lB.mb = null;
    this.lC.cancel();
    this.lD.stop();
    stopLoading();
    if (this.lB.lK != null) {
      this.lB.lK.removeAllViews();
    }
    if ((this.lB.lT != null) && (this.lB.lT.se != null)) {
      this.lB.lT.se.destroy();
    }
    if ((this.lB.lT != null) && (this.lB.lT.qQ != null)) {}
    try
    {
      this.lB.lT.qQ.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.W("Could not destroy mediation adapter.");
    }
  }
  
  public String getMediationAdapterClassName()
  {
    if (this.lB.lT != null) {
      return this.lB.lT.qR;
    }
    return null;
  }
  
  public boolean isReady()
  {
    jx.aU("isLoaded must be called on the main UI thread.");
    return (this.lB.lQ == null) && (this.lB.lR == null) && (this.lB.lT != null);
  }
  
  public void onAdClicked()
  {
    av();
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (this.lB.lW != null) {}
    try
    {
      this.lB.lW.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not call the AppEventListener.", localRemoteException);
    }
  }
  
  public void pause()
  {
    jx.aU("pause must be called on the main UI thread.");
    if ((this.lB.lT != null) && (this.lB.mg == 0)) {
      gi.a(this.lB.lT.se);
    }
    if ((this.lB.lT != null) && (this.lB.lT.qQ != null)) {}
    try
    {
      this.lB.lT.qQ.pause();
      this.lD.pause();
      this.lC.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.W("Could not pause mediation adapter.");
      }
    }
  }
  
  public void resume()
  {
    jx.aU("resume must be called on the main UI thread.");
    if ((this.lB.lT != null) && (this.lB.mg == 0)) {
      gi.b(this.lB.lT.se);
    }
    if ((this.lB.lT != null) && (this.lB.lT.qQ != null)) {}
    try
    {
      this.lB.lT.qQ.resume();
      this.lC.resume();
      this.lD.resume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        gr.W("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    jx.aU("showInterstitial must be called on the main UI thread.");
    if (!this.lB.lS.oq) {
      gr.W("Cannot call showInterstitial on a banner ad.");
    }
    do
    {
      return;
      if (this.lB.lT == null)
      {
        gr.W("The interstitial has not loaded.");
        return;
      }
    } while (this.lB.mg == 1);
    if (this.lB.lT.se.dH())
    {
      gr.W("The interstitial is already showing.");
      return;
    }
    this.lB.lT.se.z(true);
    if ((this.lB.lT.se.dD().dN()) || (this.lB.lT.vD != null))
    {
      af localaf = this.lD.a(this.lB.lS, this.lB.lT);
      if ((this.lB.lT.se.dD().dN()) && (localaf != null)) {
        localaf.a(new aa(this.lB.lT.se));
      }
    }
    if (this.lB.lT.tW) {
      try
      {
        this.lB.lT.qQ.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        gr.d("Could not show interstitial.", localRemoteException);
        ax();
        return;
      }
    }
    y localy = new y(this.lB.mi, false);
    boolean bool1;
    if ((this.lB.lM instanceof Activity))
    {
      Window localWindow = ((Activity)this.lB.lM).getWindow();
      Rect localRect1 = new Rect();
      Rect localRect2 = new Rect();
      localWindow.getDecorView().getGlobalVisibleRect(localRect1);
      localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
      if ((localRect1.bottom != 0) && (localRect2.bottom != 0))
      {
        bool1 = this.lB.mi;
        if (localRect1.top != localRect2.top) {
          break label430;
        }
      }
    }
    label430:
    for (boolean bool2 = true;; bool2 = false)
    {
      localy = new y(bool1, bool2);
      dr localdr = new dr(this, this, this, this.lB.lT.se, this.lB.lT.orientation, this.lB.lO, this.lB.lT.ub, localy);
      dp.a(this.lB.lM, localdr);
      return;
    }
  }
  
  public void stopLoading()
  {
    jx.aU("stopLoading must be called on the main UI thread.");
    if ((this.lB.lT != null) && (this.lB.mg == 0))
    {
      this.lB.lT.se.stopLoading();
      this.lB.lT = null;
    }
    if (this.lB.lQ != null) {
      this.lB.lQ.cancel();
    }
    if (this.lB.lR != null) {
      this.lB.lR.cancel();
    }
  }
  
  @ey
  private static final class a
    extends ViewSwitcher
  {
    private final gl lJ;
    
    public a(Context paramContext)
    {
      super();
      this.lJ = new gl(paramContext);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.lJ.c(paramMotionEvent);
      return false;
    }
  }
  
  @ey
  static class b
  {
    public final u.a lK;
    public final String lL;
    public final Context lM;
    public final k lN;
    public final gs lO;
    public bc lP;
    public gf lQ;
    public gf lR;
    public ay lS;
    public fy lT;
    public fy.a lU;
    public fz lV;
    public bf lW;
    public er lX;
    public en lY;
    public by lZ;
    public bz ma;
    public br mb;
    public List<String> mc;
    public ek md;
    public gd me = null;
    public View mf = null;
    public int mg = 0;
    public boolean mh = false;
    public boolean mi = false;
    private HashSet<fz> mj = null;
    
    public b(Context paramContext, ay paramay, String paramString, gs paramgs)
    {
      if (paramay.oq) {
        this.lK = null;
      }
      for (;;)
      {
        this.lS = paramay;
        this.lL = paramString;
        this.lM = paramContext;
        this.lO = paramgs;
        this.lN = new k(new x(this));
        return;
        this.lK = new u.a(paramContext);
        this.lK.setMinimumWidth(paramay.widthPixels);
        this.lK.setMinimumHeight(paramay.heightPixels);
        this.lK.setVisibility(4);
      }
    }
    
    public void a(HashSet<fz> paramHashSet)
    {
      this.mj = paramHashSet;
    }
    
    public HashSet<fz> ay()
    {
      return this.mj;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.u
 * JD-Core Version:    0.7.0.1
 */