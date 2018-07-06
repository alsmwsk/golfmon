package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class dl
{
  private final Context mContext;
  private final WindowManager mR;
  private final gu mo;
  int rA = -1;
  int rB = -1;
  private int rC;
  private int rD = -1;
  private int rE = -1;
  private int[] rF = new int[2];
  private final bl rx;
  DisplayMetrics ry;
  private float rz;
  
  public dl(gu paramgu, Context paramContext, bl parambl)
  {
    this.mo = paramgu;
    this.mContext = paramContext;
    this.rx = parambl;
    this.mR = ((WindowManager)paramContext.getSystemService("window"));
    bV();
    bW();
    bX();
  }
  
  private void bV()
  {
    this.ry = new DisplayMetrics();
    Display localDisplay = this.mR.getDefaultDisplay();
    localDisplay.getMetrics(this.ry);
    this.rz = this.ry.density;
    this.rC = localDisplay.getRotation();
  }
  
  private void bX()
  {
    this.mo.getLocationOnScreen(this.rF);
    this.mo.measure(0, 0);
    float f = 160.0F / this.ry.densityDpi;
    this.rD = Math.round(f * this.mo.getMeasuredWidth());
    this.rE = Math.round(f * this.mo.getMeasuredHeight());
  }
  
  private dk cd()
  {
    return new dk.a().l(this.rx.bo()).k(this.rx.bp()).m(this.rx.bt()).n(this.rx.bq()).o(this.rx.br()).bU();
  }
  
  void bW()
  {
    int i = gi.s(this.mContext);
    float f = 160.0F / this.ry.densityDpi;
    this.rA = Math.round(f * this.ry.widthPixels);
    this.rB = Math.round(f * (this.ry.heightPixels - i));
  }
  
  public void bY()
  {
    cb();
    cc();
    ca();
    bZ();
  }
  
  public void bZ()
  {
    if (gr.v(2)) {
      gr.U("Dispatching Ready Event.");
    }
    this.mo.b("onReadyEventReceived", new JSONObject());
  }
  
  public void ca()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", this.rF[0]).put("y", this.rF[1]).put("width", this.rD).put("height", this.rE);
      this.mo.b("onDefaultPositionReceived", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      gr.b("Error occured while dispatching default position.", localJSONException);
    }
  }
  
  public void cb()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("width", this.rA).put("height", this.rB).put("density", this.rz).put("rotation", this.rC);
      this.mo.b("onScreenInfoChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      gr.b("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public void cc()
  {
    dk localdk = cd();
    this.mo.b("onDeviceFeaturesReceived", localdk.toJson());
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dl
 * JD-Core Version:    0.7.0.1
 */