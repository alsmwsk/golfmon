package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics
  extends TrackerHandler
{
  private static boolean Bm;
  private static GoogleAnalytics Bs;
  private aj Bn;
  private volatile Boolean Bo = Boolean.valueOf(false);
  private Logger Bp;
  private Set<a> Bq;
  private boolean Br = false;
  private Context mContext;
  private f yV;
  private String ya;
  private String yb;
  private boolean yt;
  
  protected GoogleAnalytics(Context paramContext)
  {
    this(paramContext, x.A(paramContext), v.eu());
  }
  
  private GoogleAnalytics(Context paramContext, f paramf, aj paramaj)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.yV = paramf;
    this.Bn = paramaj;
    g.y(this.mContext);
    ai.y(this.mContext);
    k.y(this.mContext);
    this.Bp = new p();
    this.Bq = new HashSet();
    eZ();
  }
  
  private Tracker a(Tracker paramTracker)
  {
    if (this.ya != null) {
      paramTracker.set("&an", this.ya);
    }
    if (this.yb != null) {
      paramTracker.set("&av", this.yb);
    }
    return paramTracker;
  }
  
  private int ai(String paramString)
  {
    String str = paramString.toLowerCase();
    if ("verbose".equals(str)) {
      return 0;
    }
    if ("info".equals(str)) {
      return 1;
    }
    if ("warning".equals(str)) {
      return 2;
    }
    if ("error".equals(str)) {
      return 3;
    }
    return -1;
  }
  
  static GoogleAnalytics eY()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = Bs;
      return localGoogleAnalytics;
    }
    finally {}
  }
  
  private void eZ()
  {
    if (Bm) {}
    aa localaa;
    do
    {
      int i;
      do
      {
        Bundle localBundle;
        do
        {
          return;
          try
          {
            ApplicationInfo localApplicationInfo2 = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            localApplicationInfo1 = localApplicationInfo2;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            ApplicationInfo localApplicationInfo1;
            for (;;)
            {
              ae.V("PackageManager doesn't know about package: " + localNameNotFoundException);
              localApplicationInfo1 = null;
            }
            localBundle = localApplicationInfo1.metaData;
          }
          if (localApplicationInfo1 == null)
          {
            ae.W("Couldn't get ApplicationInfo to load gloabl config.");
            return;
          }
        } while (localBundle == null);
        i = localBundle.getInt("com.google.android.gms.analytics.globalConfigResource");
      } while (i <= 0);
      localaa = (aa)new z(this.mContext).x(i);
    } while (localaa == null);
    a(localaa);
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (Bs == null) {
        Bs = new GoogleAnalytics(paramContext);
      }
      GoogleAnalytics localGoogleAnalytics = Bs;
      return localGoogleAnalytics;
    }
    finally {}
  }
  
  void a(a parama)
  {
    this.Bq.add(parama);
    if ((this.mContext instanceof Application)) {
      enableAutoActivityReports((Application)this.mContext);
    }
  }
  
  void a(aa paramaa)
  {
    ae.V("Loading global config values.");
    if (paramaa.eO())
    {
      this.ya = paramaa.eP();
      ae.V("app name loaded: " + this.ya);
    }
    if (paramaa.eQ())
    {
      this.yb = paramaa.eR();
      ae.V("app version loaded: " + this.yb);
    }
    if (paramaa.eS())
    {
      int i = ai(paramaa.eT());
      if (i >= 0)
      {
        ae.V("log level loaded: " + i);
        getLogger().setLogLevel(i);
      }
    }
    if (paramaa.eU()) {
      this.Bn.setLocalDispatchPeriod(paramaa.eV());
    }
    if (paramaa.eW()) {
      setDryRun(paramaa.eX());
    }
  }
  
  void b(a parama)
  {
    this.Bq.remove(parama);
  }
  
  void dY()
  {
    this.yV.dY();
  }
  
  @Deprecated
  public void dispatchLocalHits()
  {
    this.Bn.dispatchLocalHits();
  }
  
  public void enableAutoActivityReports(Application paramApplication)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (!this.Br))
    {
      paramApplication.registerActivityLifecycleCallbacks(new b());
      this.Br = true;
    }
  }
  
  void g(Activity paramActivity)
  {
    Iterator localIterator = this.Bq.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).i(paramActivity);
    }
  }
  
  public boolean getAppOptOut()
  {
    y.eK().a(y.a.AN);
    return this.Bo.booleanValue();
  }
  
  public Logger getLogger()
  {
    return this.Bp;
  }
  
  void h(Activity paramActivity)
  {
    Iterator localIterator = this.Bq.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).j(paramActivity);
    }
  }
  
  public boolean isDryRunEnabled()
  {
    y.eK().a(y.a.AZ);
    return this.yt;
  }
  
  public Tracker newTracker(int paramInt)
  {
    try
    {
      y.eK().a(y.a.AJ);
      Tracker localTracker1 = new Tracker(null, this, this.mContext);
      if (paramInt > 0)
      {
        am localam = (am)new al(this.mContext).x(paramInt);
        if (localam != null) {
          localTracker1.a(localam);
        }
      }
      Tracker localTracker2 = a(localTracker1);
      return localTracker2;
    }
    finally {}
  }
  
  public Tracker newTracker(String paramString)
  {
    try
    {
      y.eK().a(y.a.AJ);
      Tracker localTracker = a(new Tracker(paramString, this, this.mContext));
      return localTracker;
    }
    finally {}
  }
  
  public void reportActivityStart(Activity paramActivity)
  {
    if (!this.Br) {
      g(paramActivity);
    }
  }
  
  public void reportActivityStop(Activity paramActivity)
  {
    if (!this.Br) {
      h(paramActivity);
    }
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    y.eK().a(y.a.AM);
    this.Bo = Boolean.valueOf(paramBoolean);
    if (this.Bo.booleanValue()) {
      this.yV.dQ();
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    y.eK().a(y.a.AY);
    this.yt = paramBoolean;
  }
  
  @Deprecated
  public void setLocalDispatchPeriod(int paramInt)
  {
    this.Bn.setLocalDispatchPeriod(paramInt);
  }
  
  public void setLogger(Logger paramLogger)
  {
    y.eK().a(y.a.Ba);
    this.Bp = paramLogger;
  }
  
  void u(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally {}
    }
    an.a(paramMap, "&ul", an.a(Locale.getDefault()));
    an.a(paramMap, "&sr", ai.fl());
    paramMap.put("&_u", y.eK().eM());
    y.eK().eL();
    this.yV.u(paramMap);
  }
  
  static abstract interface a
  {
    public abstract void i(Activity paramActivity);
    
    public abstract void j(Activity paramActivity);
  }
  
  class b
    implements Application.ActivityLifecycleCallbacks
  {
    b() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      GoogleAnalytics.this.g(paramActivity);
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      GoogleAnalytics.this.h(paramActivity);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.GoogleAnalytics
 * JD-Core Version:    0.7.0.1
 */