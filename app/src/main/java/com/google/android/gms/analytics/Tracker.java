package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Tracker
{
  private final TrackerHandler Ce;
  private final Map<String, String> Cf = new HashMap();
  private ah Cg;
  private final k Ch;
  private final ai Ci;
  private final g Cj;
  private boolean Ck;
  private a Cl;
  private am Cm;
  private ExceptionReporter Cn;
  private Context mContext;
  private final Map<String, String> rd = new HashMap();
  
  Tracker(String paramString, TrackerHandler paramTrackerHandler, Context paramContext)
  {
    this(paramString, paramTrackerHandler, k.el(), ai.fl(), g.dZ(), new ad("tracking"), paramContext);
  }
  
  Tracker(String paramString, TrackerHandler paramTrackerHandler, k paramk, ai paramai, g paramg, ah paramah, Context paramContext)
  {
    this.Ce = paramTrackerHandler;
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    if (paramString != null) {
      this.rd.put("&tid", paramString);
    }
    this.rd.put("useSecure", "1");
    this.Ch = paramk;
    this.Ci = paramai;
    this.Cj = paramg;
    this.rd.put("&a", Integer.toString(1 + new Random().nextInt(2147483647)));
    this.Cg = paramah;
    this.Cl = new a();
    enableAdvertisingIdCollection(false);
  }
  
  void a(am paramam)
  {
    ae.V("Loading Tracker config values.");
    this.Cm = paramam;
    if (this.Cm.ft())
    {
      String str2 = this.Cm.fu();
      set("&tid", str2);
      ae.V("[Tracker] trackingId loaded: " + str2);
    }
    if (this.Cm.fv())
    {
      String str1 = Double.toString(this.Cm.fw());
      set("&sf", str1);
      ae.V("[Tracker] sample frequency loaded: " + str1);
    }
    if (this.Cm.fx())
    {
      setSessionTimeout(this.Cm.getSessionTimeout());
      ae.V("[Tracker] session timeout loaded: " + fn());
    }
    if (this.Cm.fy())
    {
      enableAutoActivityTracking(this.Cm.fz());
      ae.V("[Tracker] auto activity tracking loaded: " + fo());
    }
    if (this.Cm.fA())
    {
      if (this.Cm.fB())
      {
        set("&aip", "1");
        ae.V("[Tracker] anonymize ip loaded: true");
      }
      ae.V("[Tracker] anonymize ip loaded: false");
    }
    enableExceptionReporting(this.Cm.fC());
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.rd.put("&ate", null);
      this.rd.put("&adid", null);
    }
    do
    {
      return;
      if (this.rd.containsKey("&ate")) {
        this.rd.remove("&ate");
      }
    } while (!this.rd.containsKey("&adid"));
    this.rd.remove("&adid");
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.Cl.enableAutoActivityTracking(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    if (this.Ck == paramBoolean) {
      return;
    }
    this.Ck = paramBoolean;
    if (paramBoolean)
    {
      this.Cn = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
      Thread.setDefaultUncaughtExceptionHandler(this.Cn);
      ae.V("Uncaught exceptions will be reported to Google Analytics.");
      return;
    }
    if (this.Cn != null) {
      Thread.setDefaultUncaughtExceptionHandler(this.Cn.et());
    }
    for (;;)
    {
      ae.V("Uncaught exceptions will not be reported to Google Analytics.");
      return;
      Thread.setDefaultUncaughtExceptionHandler(null);
    }
  }
  
  long fn()
  {
    return this.Cl.fn();
  }
  
  boolean fo()
  {
    return this.Cl.fo();
  }
  
  public String get(String paramString)
  {
    y.eK().a(y.a.Af);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.rd.containsKey(paramString)) {
        return (String)this.rd.get(paramString);
      }
      if (paramString.equals("&ul")) {
        return an.a(Locale.getDefault());
      }
      if ((this.Ch != null) && (this.Ch.ac(paramString))) {
        return this.Ch.getValue(paramString);
      }
      if ((this.Ci != null) && (this.Ci.ac(paramString))) {
        return this.Ci.getValue(paramString);
      }
    } while ((this.Cj == null) || (!this.Cj.ac(paramString)));
    return this.Cj.getValue(paramString);
  }
  
  public void send(Map<String, String> paramMap)
  {
    y.eK().a(y.a.Ah);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.rd);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    Iterator localIterator = this.Cf.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      if (!localHashMap.containsKey(str3)) {
        localHashMap.put(str3, this.Cf.get(str3));
      }
    }
    this.Cf.clear();
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid"))) {
      ae.W(String.format("Missing tracking id (%s) parameter.", new Object[] { "&tid" }));
    }
    String str1 = (String)localHashMap.get("&t");
    if (TextUtils.isEmpty(str1))
    {
      ae.W(String.format("Missing hit type (%s) parameter.", new Object[] { "&t" }));
      str1 = "";
    }
    if (this.Cl.fp()) {
      localHashMap.put("&sc", "start");
    }
    String str2 = str1.toLowerCase();
    if (("screenview".equals(str2)) || ("pageview".equals(str2)) || ("appview".equals(str2)) || (TextUtils.isEmpty(str2)))
    {
      int i = 1 + Integer.parseInt((String)this.rd.get("&a"));
      if (i >= 2147483647) {
        i = 1;
      }
      this.rd.put("&a", Integer.toString(i));
    }
    if ((!str2.equals("transaction")) && (!str2.equals("item")) && (!this.Cg.fe()))
    {
      ae.W("Too many hits sent too quickly, rate limiting invoked.");
      return;
    }
    this.Ce.u(localHashMap);
  }
  
  public void set(String paramString1, String paramString2)
  {
    jx.b(paramString1, "Key should be non-null");
    y.eK().a(y.a.Ag);
    this.rd.put(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    set("&aip", an.E(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    set("&aid", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    set("&aiid", paramString);
  }
  
  public void setAppName(String paramString)
  {
    set("&an", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    set("&av", paramString);
  }
  
  public void setCampaignParamsOnNextHit(Uri paramUri)
  {
    if (paramUri == null) {}
    String str9;
    do
    {
      String str1;
      do
      {
        return;
        str1 = paramUri.getQueryParameter("referrer");
      } while (TextUtils.isEmpty(str1));
      Uri localUri = Uri.parse("http://hostname/?" + str1);
      String str2 = localUri.getQueryParameter("utm_id");
      if (str2 != null) {
        this.Cf.put("&ci", str2);
      }
      String str3 = localUri.getQueryParameter("utm_campaign");
      if (str3 != null) {
        this.Cf.put("&cn", str3);
      }
      String str4 = localUri.getQueryParameter("utm_content");
      if (str4 != null) {
        this.Cf.put("&cc", str4);
      }
      String str5 = localUri.getQueryParameter("utm_medium");
      if (str5 != null) {
        this.Cf.put("&cm", str5);
      }
      String str6 = localUri.getQueryParameter("utm_source");
      if (str6 != null) {
        this.Cf.put("&cs", str6);
      }
      String str7 = localUri.getQueryParameter("utm_term");
      if (str7 != null) {
        this.Cf.put("&ck", str7);
      }
      String str8 = localUri.getQueryParameter("dclid");
      if (str8 != null) {
        this.Cf.put("&dclid", str8);
      }
      str9 = localUri.getQueryParameter("gclid");
    } while (str9 == null);
    this.Cf.put("&gclid", str9);
  }
  
  public void setClientId(String paramString)
  {
    set("&cid", paramString);
  }
  
  public void setEncoding(String paramString)
  {
    set("&de", paramString);
  }
  
  public void setHostname(String paramString)
  {
    set("&dh", paramString);
  }
  
  public void setLanguage(String paramString)
  {
    set("&ul", paramString);
  }
  
  public void setLocation(String paramString)
  {
    set("&dl", paramString);
  }
  
  public void setPage(String paramString)
  {
    set("&dp", paramString);
  }
  
  public void setReferrer(String paramString)
  {
    set("&dr", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    set("&sf", Double.toHexString(paramDouble));
  }
  
  public void setScreenColors(String paramString)
  {
    set("&sd", paramString);
  }
  
  public void setScreenName(String paramString)
  {
    set("&cd", paramString);
  }
  
  public void setScreenResolution(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) && (paramInt2 < 0))
    {
      ae.W("Invalid width or height. The values should be non-negative.");
      return;
    }
    set("&sr", paramInt1 + "x" + paramInt2);
  }
  
  public void setSessionTimeout(long paramLong)
  {
    this.Cl.setSessionTimeout(1000L * paramLong);
  }
  
  public void setTitle(String paramString)
  {
    set("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    set("useSecure", an.E(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    set("&vp", paramString);
  }
  
  private class a
    implements GoogleAnalytics.a
  {
    private boolean Co = false;
    private int Cp = 0;
    private long Cq = -1L;
    private boolean Cr = false;
    private long Cs;
    private ld wb = lf.jdMethod_if();
    
    public a() {}
    
    private void fq()
    {
      GoogleAnalytics localGoogleAnalytics = GoogleAnalytics.eY();
      if (localGoogleAnalytics == null)
      {
        ae.T("GoogleAnalytics isn't initialized for the Tracker!");
        return;
      }
      if ((this.Cq >= 0L) || (this.Co))
      {
        localGoogleAnalytics.a(Tracker.b(Tracker.this));
        return;
      }
      localGoogleAnalytics.b(Tracker.b(Tracker.this));
    }
    
    public void enableAutoActivityTracking(boolean paramBoolean)
    {
      this.Co = paramBoolean;
      fq();
    }
    
    public long fn()
    {
      return this.Cq;
    }
    
    public boolean fo()
    {
      return this.Co;
    }
    
    public boolean fp()
    {
      boolean bool = this.Cr;
      this.Cr = false;
      return bool;
    }
    
    boolean fr()
    {
      return this.wb.elapsedRealtime() >= this.Cs + Math.max(1000L, this.Cq);
    }
    
    public void i(Activity paramActivity)
    {
      y.eK().a(y.a.Be);
      if ((this.Cp == 0) && (fr())) {
        this.Cr = true;
      }
      this.Cp = (1 + this.Cp);
      HashMap localHashMap;
      Tracker localTracker;
      if (this.Co)
      {
        Intent localIntent = paramActivity.getIntent();
        if (localIntent != null) {
          Tracker.this.setCampaignParamsOnNextHit(localIntent.getData());
        }
        localHashMap = new HashMap();
        localHashMap.put("&t", "screenview");
        y.eK().D(true);
        localTracker = Tracker.this;
        if (Tracker.c(Tracker.this) == null) {
          break label145;
        }
      }
      label145:
      for (String str = Tracker.c(Tracker.this).k(paramActivity);; str = paramActivity.getClass().getCanonicalName())
      {
        localTracker.set("&cd", str);
        Tracker.this.send(localHashMap);
        y.eK().D(false);
        return;
      }
    }
    
    public void j(Activity paramActivity)
    {
      y.eK().a(y.a.Bf);
      this.Cp = (-1 + this.Cp);
      this.Cp = Math.max(0, this.Cp);
      if (this.Cp == 0) {
        this.Cs = this.wb.elapsedRealtime();
      }
    }
    
    public void setSessionTimeout(long paramLong)
    {
      this.Cq = paramLong;
      fq();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.Tracker
 * JD-Core Version:    0.7.0.1
 */