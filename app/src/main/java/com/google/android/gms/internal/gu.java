package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class gu
  extends WebView
  implements DownloadListener
{
  private final Object mH = new Object();
  private final WindowManager mR;
  private ay qI;
  private final gs qJ;
  private final k tl;
  private final gv wW;
  private final a wX;
  private dp wY;
  private boolean wZ;
  private boolean xa;
  private boolean xb;
  private boolean xc;
  
  protected gu(a parama, ay paramay, boolean paramBoolean1, boolean paramBoolean2, k paramk, gs paramgs)
  {
    super(parama);
    this.wX = parama;
    this.qI = paramay;
    this.wZ = paramBoolean1;
    this.tl = paramk;
    this.qJ = paramgs;
    this.mR = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSavePassword(false);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    gi.a(parama, paramgs.wS, localWebSettings);
    if (Build.VERSION.SDK_INT >= 17)
    {
      go.a(getContext(), localWebSettings);
      setDownloadListener(this);
      if (Build.VERSION.SDK_INT < 11) {
        break label202;
      }
      this.wW = new gx(this, paramBoolean2);
      label149:
      setWebViewClient(this.wW);
      if (Build.VERSION.SDK_INT < 14) {
        break label219;
      }
      setWebChromeClient(new gy(this));
    }
    for (;;)
    {
      dJ();
      return;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      gm.a(getContext(), localWebSettings);
      break;
      label202:
      this.wW = new gv(this, paramBoolean2);
      break label149;
      label219:
      if (Build.VERSION.SDK_INT >= 11) {
        setWebChromeClient(new gw(this));
      }
    }
  }
  
  public static gu a(Context paramContext, ay paramay, boolean paramBoolean1, boolean paramBoolean2, k paramk, gs paramgs)
  {
    return new gu(new a(paramContext), paramay, paramBoolean1, paramBoolean2, paramk, paramgs);
  }
  
  private void dJ()
  {
    for (;;)
    {
      synchronized (this.mH)
      {
        if ((this.wZ) || (this.qI.oq))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            gr.S("Disabling hardware acceleration on an overlay.");
            dK();
            return;
          }
          gr.S("Enabling hardware acceleration on an overlay.");
          dL();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        gr.S("Disabling hardware acceleration on an AdView.");
        dK();
      }
      else
      {
        gr.S("Enabling hardware acceleration on an AdView.");
        dL();
      }
    }
  }
  
  private void dK()
  {
    synchronized (this.mH)
    {
      if ((!this.xa) && (Build.VERSION.SDK_INT >= 11)) {
        gm.i(this);
      }
      this.xa = true;
      return;
    }
  }
  
  private void dL()
  {
    synchronized (this.mH)
    {
      if ((this.xa) && (Build.VERSION.SDK_INT >= 11)) {
        gm.j(this);
      }
      this.xa = false;
      return;
    }
  }
  
  protected void X(String paramString)
  {
    synchronized (this.mH)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      gr.W("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void a(Context paramContext, ay paramay)
  {
    synchronized (this.mH)
    {
      this.wX.setBaseContext(paramContext);
      this.wY = null;
      this.qI = paramay;
      this.wZ = false;
      this.xc = false;
      gi.b(this);
      loadUrl("about:blank");
      this.wW.reset();
      setOnTouchListener(null);
      setOnClickListener(null);
      return;
    }
  }
  
  public void a(ay paramay)
  {
    synchronized (this.mH)
    {
      this.qI = paramay;
      requestLayout();
      return;
    }
  }
  
  public void a(dp paramdp)
  {
    synchronized (this.mH)
    {
      this.wY = paramdp;
      return;
    }
  }
  
  public void a(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      JSONObject localJSONObject = gi.t(paramMap);
      b(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      gr.W("Could not convert parameters to JSON.");
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    String str = paramJSONObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:" + paramString + "(");
    localStringBuilder.append(str);
    localStringBuilder.append(");");
    X(localStringBuilder.toString());
  }
  
  public ay ac()
  {
    synchronized (this.mH)
    {
      ay localay = this.qI;
      return localay;
    }
  }
  
  public void b(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    String str = paramJSONObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:AFMA_ReceiveMessage('");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    localStringBuilder.append(",");
    localStringBuilder.append(str);
    localStringBuilder.append(");");
    gr.V("Dispatching AFMA event: " + localStringBuilder);
    X(localStringBuilder.toString());
  }
  
  public void cb()
  {
    if (!dD().dN()) {
      return;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Display localDisplay = this.mR.getDefaultDisplay();
    localDisplay.getMetrics(localDisplayMetrics);
    int i = gi.s(getContext());
    float f = 160.0F / localDisplayMetrics.densityDpi;
    int j = Math.round(f * localDisplayMetrics.widthPixels);
    int k = Math.round(f * (localDisplayMetrics.heightPixels - i));
    try
    {
      b("onScreenInfoChanged", new JSONObject().put("width", j).put("height", k).put("density", localDisplayMetrics.density).put("rotation", localDisplay.getRotation()));
      return;
    }
    catch (JSONException localJSONException)
    {
      gr.b("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public void ci()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.qJ.wS);
    a("onshow", localHashMap);
  }
  
  public void cj()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.qJ.wS);
    a("onhide", localHashMap);
  }
  
  public dp dC()
  {
    synchronized (this.mH)
    {
      dp localdp = this.wY;
      return localdp;
    }
  }
  
  public gv dD()
  {
    return this.wW;
  }
  
  public boolean dE()
  {
    return this.xc;
  }
  
  public k dF()
  {
    return this.tl;
  }
  
  public gs dG()
  {
    return this.qJ;
  }
  
  public boolean dH()
  {
    synchronized (this.mH)
    {
      boolean bool = this.wZ;
      return bool;
    }
  }
  
  public Context dI()
  {
    return this.wX.dI();
  }
  
  public void destroy()
  {
    synchronized (this.mH)
    {
      if (this.wY != null) {
        this.wY.close();
      }
      this.xb = true;
      super.destroy();
      return;
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (this.mH)
    {
      if (isDestroyed())
      {
        gr.W("The webview is destroyed. Ignoring action.");
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(null);
        }
        return;
      }
      super.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  public boolean isDestroyed()
  {
    synchronized (this.mH)
    {
      boolean bool = this.xb;
      return bool;
    }
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.parse(paramString1), paramString4);
      getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      gr.S("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n;
    for (int i = 2147483647;; i = n)
    {
      int m;
      label284:
      do
      {
        int k;
        for (;;)
        {
          synchronized (this.mH)
          {
            if ((isInEditMode()) || (this.wZ))
            {
              super.onMeasure(paramInt1, paramInt2);
              return;
            }
            int j = View.MeasureSpec.getMode(paramInt1);
            k = View.MeasureSpec.getSize(paramInt1);
            m = View.MeasureSpec.getMode(paramInt2);
            n = View.MeasureSpec.getSize(paramInt2);
            if (j == -2147483648) {
              break label284;
            }
            if (j != 1073741824) {
              break;
            }
            break label284;
            if ((this.qI.widthPixels > i1) || (this.qI.heightPixels > i))
            {
              float f = this.wX.getResources().getDisplayMetrics().density;
              gr.W("Not enough space to show ad. Needs " + (int)(this.qI.widthPixels / f) + "x" + (int)(this.qI.heightPixels / f) + " dp, but only has " + (int)(k / f) + "x" + (int)(n / f) + " dp.");
              if (getVisibility() != 8) {
                setVisibility(4);
              }
              setMeasuredDimension(0, 0);
              return;
            }
          }
          if (getVisibility() != 8) {
            setVisibility(0);
          }
          setMeasuredDimension(this.qI.widthPixels, this.qI.heightPixels);
        }
        int i1 = i;
        continue;
        i1 = k;
      } while ((m != -2147483648) && (m != 1073741824));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.tl != null) {
      this.tl.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void q(boolean paramBoolean)
  {
    synchronized (this.mH)
    {
      if (this.wY != null)
      {
        this.wY.q(paramBoolean);
        return;
      }
      this.xc = paramBoolean;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.wX.setBaseContext(paramContext);
  }
  
  public void z(boolean paramBoolean)
  {
    synchronized (this.mH)
    {
      this.wZ = paramBoolean;
      dJ();
      return;
    }
  }
  
  @ey
  protected static class a
    extends MutableContextWrapper
  {
    private Context mO;
    private Activity xd;
    
    public a(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public Context dI()
    {
      return this.xd;
    }
    
    public void setBaseContext(Context paramContext)
    {
      this.mO = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (Activity localActivity = (Activity)paramContext;; localActivity = null)
      {
        this.xd = localActivity;
        super.setBaseContext(this.mO);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if (this.xd != null)
      {
        this.xd.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      this.mO.startActivity(paramIntent);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gu
 * JD-Core Version:    0.7.0.1
 */