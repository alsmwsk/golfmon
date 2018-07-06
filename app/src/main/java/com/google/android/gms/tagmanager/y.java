package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class y
  implements aq
{
  private static y arl;
  private static final Object xO = new Object();
  private cg aqC;
  private String arm;
  private String arn;
  private ar aro;
  
  private y(Context paramContext)
  {
    this(as.Z(paramContext), new cw());
  }
  
  y(ar paramar, cg paramcg)
  {
    this.aro = paramar;
    this.aqC = paramcg;
  }
  
  public static aq X(Context paramContext)
  {
    synchronized (xO)
    {
      if (arl == null) {
        arl = new y(paramContext);
      }
      y localy = arl;
      return localy;
    }
  }
  
  public boolean cB(String paramString)
  {
    if (!this.aqC.fe())
    {
      bh.W("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
      return false;
    }
    if ((this.arm != null) && (this.arn != null)) {}
    try
    {
      paramString = this.arm + "?" + this.arn + "=" + URLEncoder.encode(paramString, "UTF-8");
      bh.V("Sending wrapped url hit: " + paramString);
      this.aro.cE(paramString);
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      bh.d("Error wrapping URL for testing.", localUnsupportedEncodingException);
    }
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.y
 * JD-Core Version:    0.7.0.1
 */