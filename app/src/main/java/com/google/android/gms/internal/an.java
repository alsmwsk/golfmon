package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class an
  extends Thread
{
  private final Object mH;
  private boolean mStarted = false;
  private boolean nC = false;
  private boolean nD = false;
  private final am nE;
  private final al nF;
  private final ex nG;
  private final int nH;
  private final int nI;
  private final int nJ;
  private final int np;
  private final int nr;
  
  public an(am paramam, al paramal, Bundle paramBundle, ex paramex)
  {
    this.nE = paramam;
    this.nF = paramal;
    this.nG = paramex;
    this.mH = new Object();
    this.np = paramBundle.getInt(bn.pq.getKey());
    this.nI = paramBundle.getInt(bn.pr.getKey());
    this.nr = paramBundle.getInt(bn.ps.getKey());
    this.nJ = paramBundle.getInt(bn.pt.getKey());
    this.nH = paramBundle.getInt(bn.pu.getKey(), 10);
    setName("ContentFetchTask");
  }
  
  private void a(Activity paramActivity)
  {
    if (paramActivity == null) {}
    View localView1;
    do
    {
      return;
      Window localWindow = paramActivity.getWindow();
      localView1 = null;
      if (localWindow != null)
      {
        View localView2 = paramActivity.getWindow().getDecorView();
        localView1 = null;
        if (localView2 != null) {
          localView1 = paramActivity.getWindow().getDecorView().findViewById(16908290);
        }
      }
    } while (localView1 == null);
    g(localView1);
  }
  
  private boolean a(final WebView paramWebView, final ak paramak)
  {
    if (!ll.im()) {
      return false;
    }
    paramak.aW();
    paramWebView.post(new Runnable()
    {
      ValueCallback<String> nM = new ValueCallback()
      {
        public void k(String paramAnonymous2String)
        {
          an.this.a(an.2.this.nN, an.2.this.nO, paramAnonymous2String);
        }
      };
      
      public void run()
      {
        if (paramWebView.getSettings().getJavaScriptEnabled()) {
          paramWebView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.nM);
        }
      }
    });
    return true;
  }
  
  private boolean bb()
  {
    try
    {
      Context localContext = this.nE.getContext();
      if (localContext == null) {
        return false;
      }
      ActivityManager localActivityManager = (ActivityManager)localContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
      PowerManager localPowerManager = (PowerManager)localContext.getSystemService("power");
      if ((localActivityManager != null) && (localKeyguardManager != null) && (localPowerManager != null))
      {
        List localList = localActivityManager.getRunningAppProcesses();
        if (localList == null) {
          return false;
        }
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (Process.myPid() == localRunningAppProcessInfo.pid) {
            if ((localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = localPowerManager.isScreenOn();
              if (bool) {
                return true;
              }
            }
          }
        }
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    return false;
  }
  
  a a(View paramView, ak paramak)
  {
    int i = 0;
    if (paramView == null) {
      return new a(0, 0);
    }
    if (((paramView instanceof TextView)) && (!(paramView instanceof EditText)))
    {
      paramak.i(((TextView)paramView).getText().toString());
      return new a(1, 0);
    }
    if (((paramView instanceof WebView)) && (!(paramView instanceof gu)))
    {
      paramak.aW();
      if (a((WebView)paramView, paramak)) {
        return new a(0, 1);
      }
      return new a(0, 0);
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = 0;
      int k = 0;
      while (i < localViewGroup.getChildCount())
      {
        a locala = a(localViewGroup.getChildAt(i), paramak);
        k += locala.nQ;
        j += locala.nR;
        i++;
      }
      return new a(k, j);
    }
    return new a(0, 0);
  }
  
  void a(ak paramak, WebView paramWebView, String paramString)
  {
    paramak.aV();
    try
    {
      String str;
      if (!TextUtils.isEmpty(paramString))
      {
        str = new JSONObject(paramString).optString("text");
        if (TextUtils.isEmpty(paramWebView.getTitle())) {
          break label86;
        }
        paramak.h(paramWebView.getTitle() + "\n" + str);
      }
      while (paramak.aS())
      {
        this.nF.b(paramak);
        return;
        label86:
        paramak.h(str);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      gr.S("Json string may be malformed.");
      return;
    }
    catch (Throwable localThrowable)
    {
      gr.a("Failed to get webview content.", localThrowable);
      this.nG.b(localThrowable);
    }
  }
  
  public void ba()
  {
    synchronized (this.mH)
    {
      if (this.mStarted)
      {
        gr.S("Content hash thread already started, quiting...");
        return;
      }
      this.mStarted = true;
      start();
      return;
    }
  }
  
  public ak bc()
  {
    return this.nF.aZ();
  }
  
  public void bd()
  {
    synchronized (this.mH)
    {
      this.nC = true;
      gr.S("ContentFetchThread: paused, mPause = " + this.nC);
      return;
    }
  }
  
  public boolean be()
  {
    return this.nC;
  }
  
  boolean g(final View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView.post(new Runnable()
    {
      public void run()
      {
        an.this.h(paramView);
      }
    });
    return true;
  }
  
  void h(View paramView)
  {
    try
    {
      ak localak = new ak(this.np, this.nI, this.nr, this.nJ);
      a locala = a(paramView, localak);
      localak.aX();
      if ((locala.nQ == 0) && (locala.nR == 0)) {
        return;
      }
      if (((locala.nR != 0) || (localak.aY() != 0)) && ((locala.nR != 0) || (!this.nF.a(localak))))
      {
        this.nF.c(localak);
        return;
      }
    }
    catch (Exception localException)
    {
      gr.b("Exception in fetchContentOnUIThread", localException);
      this.nG.b(localException);
    }
  }
  
  public void run()
  {
    while (!this.nD) {
      try
      {
        if (bb())
        {
          localActivity = this.nE.getActivity();
          if (localActivity == null) {
            gr.S("ContentFetchThread: no activity");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Activity localActivity;
        gr.b("Error in ContentFetchTask", localThrowable);
        this.nG.b(localThrowable);
        synchronized (this.mH)
        {
          for (;;)
          {
            boolean bool = this.nC;
            if (!bool) {
              break;
            }
            try
            {
              gr.S("ContentFetchTask: waiting");
              this.mH.wait();
            }
            catch (InterruptedException localInterruptedException) {}
          }
          a(localActivity);
          for (;;)
          {
            Thread.sleep(1000 * this.nH);
            break;
            gr.S("ContentFetchTask: sleeping");
            bd();
          }
        }
      }
    }
  }
  
  public void wakeup()
  {
    synchronized (this.mH)
    {
      this.nC = false;
      this.mH.notifyAll();
      gr.S("ContentFetchThread: wakeup");
      return;
    }
  }
  
  @ey
  class a
  {
    final int nQ;
    final int nR;
    
    a(int paramInt1, int paramInt2)
    {
      this.nQ = paramInt1;
      this.nR = paramInt2;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.an
 * JD-Core Version:    0.7.0.1
 */