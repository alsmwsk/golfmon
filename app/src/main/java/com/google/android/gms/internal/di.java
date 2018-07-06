package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdSize;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class di
{
  static final Set<String> rk = new HashSet(Arrays.asList(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" }));
  private int li = -1;
  private int lj = -1;
  private final Context mContext;
  private final gu mo;
  private final Map<String, String> rd;
  private int rl = 0;
  private int rm = 0;
  private boolean rn = true;
  private String ro = "top-right";
  
  public di(gu paramgu, Map<String, String> paramMap)
  {
    this.mo = paramgu;
    this.rd = paramMap;
    this.mContext = paramgu.dI();
  }
  
  private void bQ()
  {
    int[] arrayOfInt = gi.t(this.mContext);
    if (!TextUtils.isEmpty((CharSequence)this.rd.get("width")))
    {
      int j = gi.M((String)this.rd.get("width"));
      if (b(j, arrayOfInt[0])) {
        this.li = j;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)this.rd.get("height")))
    {
      int i = gi.M((String)this.rd.get("height"));
      if (c(i, arrayOfInt[1])) {
        this.lj = i;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)this.rd.get("offsetX"))) {
      this.rl = gi.M((String)this.rd.get("offsetX"));
    }
    if (!TextUtils.isEmpty((CharSequence)this.rd.get("offsetY"))) {
      this.rm = gi.M((String)this.rd.get("offsetY"));
    }
    if (!TextUtils.isEmpty((CharSequence)this.rd.get("allowOffscreen"))) {
      this.rn = Boolean.parseBoolean((String)this.rd.get("allowOffscreen"));
    }
    String str = (String)this.rd.get("customClosePosition");
    if ((!TextUtils.isEmpty(str)) && (rk.contains(str))) {
      this.ro = str;
    }
  }
  
  boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 50) && (paramInt1 < paramInt2);
  }
  
  boolean bR()
  {
    return (this.li > -1) && (this.lj > -1);
  }
  
  void bS()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", this.rl).put("y", this.rm).put("width", this.li).put("height", this.lj);
      this.mo.b("onSizeChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      gr.b("Error occured while dispatching size change.", localJSONException);
    }
  }
  
  void bT()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("state", "resized");
      this.mo.b("onStateChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      gr.b("Error occured while dispatching state change.", localJSONException);
    }
  }
  
  boolean c(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 50) && (paramInt1 < paramInt2);
  }
  
  public void execute()
  {
    gr.U("PLEASE IMPLEMENT mraid.resize()");
    if (this.mContext == null)
    {
      gr.W("Not an activity context. Cannot resize.");
      return;
    }
    if (this.mo.ac().oq)
    {
      gr.W("Is interstitial. Cannot resize an interstitial.");
      return;
    }
    if (this.mo.dH())
    {
      gr.W("Is expanded. Cannot resize an expanded banner.");
      return;
    }
    bQ();
    if (!bR())
    {
      gr.W("Invalid width and height options. Cannot resize.");
      return;
    }
    WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = 16 + gq.a(localDisplayMetrics, this.li);
    int j = 16 + gq.a(localDisplayMetrics, this.lj);
    ViewParent localViewParent = this.mo.getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
      ((ViewGroup)localViewParent).removeView(this.mo);
    }
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setBackgroundColor(0);
    PopupWindow localPopupWindow = new PopupWindow(this.mContext);
    localPopupWindow.setHeight(j);
    localPopupWindow.setWidth(i);
    if (!this.rn) {}
    for (boolean bool = true;; bool = false)
    {
      localPopupWindow.setClippingEnabled(bool);
      localPopupWindow.setContentView(localLinearLayout);
      localLinearLayout.addView(this.mo, -1, -1);
      localPopupWindow.showAtLocation(((Activity)this.mContext).getWindow().getDecorView(), 0, this.rl, this.rm);
      this.mo.a(new ay(this.mContext, new AdSize(this.li, this.lj)));
      bS();
      bT();
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.di
 * JD-Core Version:    0.7.0.1
 */