package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class af
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private final Object mH = new Object();
  private final WeakReference<fy> mK;
  private WeakReference<ViewTreeObserver> mL;
  private final WeakReference<View> mM;
  private final ad mN;
  private final Context mO;
  private final ah mP;
  private boolean mQ;
  private final WindowManager mR;
  private final PowerManager mS;
  private final KeyguardManager mT;
  private ag mU;
  private boolean mV = false;
  private final BlockingQueue<Runnable> mW = new ArrayBlockingQueue(2);
  private long mX = -9223372036854775808L;
  private boolean mY;
  private boolean mZ;
  private boolean my = false;
  private BroadcastReceiver na;
  private final HashSet<ac> nb = new HashSet();
  
  public af(Context paramContext, ay paramay, fy paramfy, View paramView, gs paramgs)
  {
    this(paramay, paramfy, paramgs, paramView, new aj(paramContext, paramgs));
  }
  
  public af(ay paramay, fy paramfy, gs paramgs, final View paramView, ah paramah)
  {
    this.mK = new WeakReference(paramfy);
    this.mM = new WeakReference(paramView);
    this.mL = new WeakReference(null);
    this.mY = true;
    this.mN = new ad(UUID.randomUUID().toString(), paramgs, paramay.op, paramfy.vD);
    this.mP = paramah;
    this.mR = ((WindowManager)paramView.getContext().getSystemService("window"));
    this.mS = ((PowerManager)paramView.getContext().getApplicationContext().getSystemService("power"));
    this.mT = ((KeyguardManager)paramView.getContext().getSystemService("keyguard"));
    this.mO = paramView.getContext().getApplicationContext();
    a(paramah);
    this.mP.a(new ah.a()
    {
      public void aR()
      {
        af.b(af.this, true);
        af.this.d(paramView);
        af.this.aI();
      }
    });
    b(this.mP);
    try
    {
      final JSONObject localJSONObject = e(paramView);
      this.mW.add(new Runnable()
      {
        public void run()
        {
          af.this.a(localJSONObject);
        }
      });
      label256:
      this.mW.add(new Runnable()
      {
        public void run()
        {
          af.this.g(false);
        }
      });
      gr.S("Tracking ad unit: " + this.mN.aH());
      return;
    }
    catch (Throwable localThrowable)
    {
      break label256;
    }
  }
  
  protected int a(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    float f = paramDisplayMetrics.density;
    return (int)(paramInt / f);
  }
  
  protected void a(View paramView, Map<String, String> paramMap)
  {
    g(false);
  }
  
  public void a(ac paramac)
  {
    this.nb.add(paramac);
  }
  
  public void a(ag paramag)
  {
    synchronized (this.mH)
    {
      this.mU = paramag;
      return;
    }
  }
  
  protected void a(ah paramah)
  {
    paramah.f("https://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONArray.put(paramJSONObject);
      localJSONObject.put("units", localJSONArray);
      this.mP.a("AFMA_updateActiveView", localJSONObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      gr.b("Skipping active view message.", localThrowable);
    }
  }
  
  protected boolean a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    String str = (String)paramMap.get("hashCode");
    if ((!TextUtils.isEmpty(str)) && (str.equals(this.mN.aH()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void aI()
  {
    synchronized (this.mH)
    {
      if (this.na != null) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      this.na = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          af.this.g(false);
        }
      };
      this.mO.registerReceiver(this.na, localIntentFilter);
      return;
    }
  }
  
  protected void aJ()
  {
    synchronized (this.mH)
    {
      if (this.na != null)
      {
        this.mO.unregisterReceiver(this.na);
        this.na = null;
      }
      return;
    }
  }
  
  public void aK()
  {
    synchronized (this.mH)
    {
      if (this.mY) {
        this.mZ = true;
      }
      try
      {
        a(aQ());
        gr.S("Untracking ad unit: " + this.mN.aH());
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          gr.b("JSON Failure while processing active view data.", localJSONException);
        }
      }
    }
  }
  
  protected void aL()
  {
    if (this.mU != null) {
      this.mU.a(this);
    }
  }
  
  public boolean aM()
  {
    synchronized (this.mH)
    {
      boolean bool = this.mY;
      return bool;
    }
  }
  
  protected void aN()
  {
    View localView = (View)this.mM.get();
    if (localView == null) {}
    ViewTreeObserver localViewTreeObserver1;
    ViewTreeObserver localViewTreeObserver2;
    do
    {
      return;
      localViewTreeObserver1 = (ViewTreeObserver)this.mL.get();
      localViewTreeObserver2 = localView.getViewTreeObserver();
    } while (localViewTreeObserver2 == localViewTreeObserver1);
    this.mL = new WeakReference(localViewTreeObserver2);
    localViewTreeObserver2.addOnScrollChangedListener(this);
    localViewTreeObserver2.addOnGlobalLayoutListener(this);
  }
  
  protected void aO()
  {
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)this.mL.get();
    if ((localViewTreeObserver == null) || (!localViewTreeObserver.isAlive())) {
      return;
    }
    localViewTreeObserver.removeOnScrollChangedListener(this);
    localViewTreeObserver.removeGlobalOnLayoutListener(this);
  }
  
  protected JSONObject aP()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", this.mN.aF()).put("activeViewJSON", this.mN.aG()).put("timestamp", ga.dc().dd().elapsedRealtime()).put("adFormat", this.mN.aE()).put("hashCode", this.mN.aH());
    return localJSONObject;
  }
  
  protected JSONObject aQ()
    throws JSONException
  {
    JSONObject localJSONObject = aP();
    localJSONObject.put("doneReasonCode", "u");
    return localJSONObject;
  }
  
  protected void b(ah paramah)
  {
    paramah.a("/updateActiveView", new cd()
    {
      public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
      {
        if (!af.this.a(paramAnonymousMap)) {
          return;
        }
        af.this.a(paramAnonymousgu, paramAnonymousMap);
      }
    });
    paramah.a("/untrackActiveViewUnit", new cd()
    {
      public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
      {
        if (!af.this.a(paramAnonymousMap)) {
          return;
        }
        gr.S("Received request to untrack: " + af.b(af.this).aH());
        af.this.destroy();
      }
    });
    paramah.a("/visibilityChanged", new cd()
    {
      public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
      {
        if (!af.this.a(paramAnonymousMap)) {}
        while (!paramAnonymousMap.containsKey("isVisible")) {
          return;
        }
        if (("1".equals(paramAnonymousMap.get("isVisible"))) || ("true".equals(paramAnonymousMap.get("isVisible")))) {}
        for (boolean bool = true;; bool = false)
        {
          Boolean localBoolean = Boolean.valueOf(bool);
          af.this.f(localBoolean.booleanValue());
          return;
        }
      }
    });
    paramah.a("/viewabilityChanged", cc.pQ);
  }
  
  protected void d(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    this.mW.drainTo(localArrayList);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
  }
  
  protected void destroy()
  {
    synchronized (this.mH)
    {
      aO();
      aJ();
      this.mY = false;
    }
    try
    {
      this.mP.destroy();
      label29:
      aL();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Throwable localThrowable)
    {
      break label29;
    }
  }
  
  protected JSONObject e(View paramView)
    throws JSONException
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    paramView.getLocationOnScreen(arrayOfInt1);
    paramView.getLocationInWindow(arrayOfInt2);
    JSONObject localJSONObject = aP();
    DisplayMetrics localDisplayMetrics = paramView.getContext().getResources().getDisplayMetrics();
    Rect localRect1 = new Rect();
    localRect1.left = arrayOfInt1[0];
    localRect1.top = arrayOfInt1[1];
    localRect1.right = (localRect1.left + paramView.getWidth());
    localRect1.bottom = (localRect1.top + paramView.getHeight());
    Rect localRect2 = new Rect();
    localRect2.right = this.mR.getDefaultDisplay().getWidth();
    localRect2.bottom = this.mR.getDefaultDisplay().getHeight();
    Rect localRect3 = new Rect();
    boolean bool1 = paramView.getGlobalVisibleRect(localRect3, null);
    Rect localRect4 = new Rect();
    boolean bool2 = paramView.getLocalVisibleRect(localRect4);
    Rect localRect5 = new Rect();
    paramView.getHitRect(localRect5);
    localJSONObject.put("viewBox", new JSONObject().put("top", a(localRect2.top, localDisplayMetrics)).put("bottom", a(localRect2.bottom, localDisplayMetrics)).put("left", a(localRect2.left, localDisplayMetrics)).put("right", a(localRect2.right, localDisplayMetrics))).put("adBox", new JSONObject().put("top", a(localRect1.top, localDisplayMetrics)).put("bottom", a(localRect1.bottom, localDisplayMetrics)).put("left", a(localRect1.left, localDisplayMetrics)).put("right", a(localRect1.right, localDisplayMetrics))).put("globalVisibleBox", new JSONObject().put("top", a(localRect3.top, localDisplayMetrics)).put("bottom", a(localRect3.bottom, localDisplayMetrics)).put("left", a(localRect3.left, localDisplayMetrics)).put("right", a(localRect3.right, localDisplayMetrics))).put("globalVisibleBoxVisible", bool1).put("localVisibleBox", new JSONObject().put("top", a(localRect4.top, localDisplayMetrics)).put("bottom", a(localRect4.bottom, localDisplayMetrics)).put("left", a(localRect4.left, localDisplayMetrics)).put("right", a(localRect4.right, localDisplayMetrics))).put("localVisibleBoxVisible", bool2).put("hitBox", new JSONObject().put("top", a(localRect5.top, localDisplayMetrics)).put("bottom", a(localRect5.bottom, localDisplayMetrics)).put("left", a(localRect5.left, localDisplayMetrics)).put("right", a(localRect5.right, localDisplayMetrics))).put("windowVisibility", paramView.getWindowVisibility()).put("screenDensity", localDisplayMetrics.density).put("isVisible", f(paramView)).put("isStopped", this.mV).put("isPaused", this.my);
    if (ll.im()) {
      localJSONObject.put("isAttachedToWindow", paramView.isAttachedToWindow());
    }
    return localJSONObject;
  }
  
  protected void f(boolean paramBoolean)
  {
    Iterator localIterator = this.nb.iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).a(this, paramBoolean);
    }
  }
  
  protected boolean f(View paramView)
  {
    return (paramView.getVisibility() == 0) && (paramView.isShown()) && (this.mS.isScreenOn()) && (!this.mT.inKeyguardRestrictedInputMode());
  }
  
  protected void g(boolean paramBoolean)
  {
    long l;
    synchronized (this.mH)
    {
      if ((!this.mQ) || (!this.mY)) {
        return;
      }
      l = ga.dc().dd().elapsedRealtime();
      if ((paramBoolean) && (200L + this.mX > l)) {
        return;
      }
    }
    this.mX = l;
    fy localfy = (fy)this.mK.get();
    View localView = (View)this.mM.get();
    if (localView != null) {
      if (localfy == null) {
        break label158;
      }
    }
    for (;;)
    {
      int i;
      if (i != 0)
      {
        aK();
        return;
        i = 0;
      }
      else
      {
        try
        {
          a(e(localView));
          aN();
          aL();
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            gr.a("Active view update failed.", localJSONException);
          }
        }
        label158:
        i = 1;
      }
    }
  }
  
  public void onGlobalLayout()
  {
    g(false);
  }
  
  public void onScrollChanged()
  {
    g(true);
  }
  
  public void pause()
  {
    synchronized (this.mH)
    {
      this.my = true;
      g(false);
      this.mP.pause();
      return;
    }
  }
  
  public void resume()
  {
    synchronized (this.mH)
    {
      this.mP.resume();
      this.my = false;
      g(false);
      return;
    }
  }
  
  public void stop()
  {
    synchronized (this.mH)
    {
      this.mV = true;
      g(false);
      this.mP.pause();
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.af
 * JD-Core Version:    0.7.0.1
 */