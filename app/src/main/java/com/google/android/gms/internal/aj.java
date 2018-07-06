package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import org.json.JSONObject;

@ey
public class aj
  implements ah
{
  private final gu mo;
  
  public aj(Context paramContext, gs paramgs)
  {
    this.mo = gu.a(paramContext, new ay(), false, false, null, paramgs);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    if (gq.dB())
    {
      paramRunnable.run();
      return;
    }
    gq.wR.post(paramRunnable);
  }
  
  public void a(final ah.a parama)
  {
    this.mo.dD().a(new gv.a()
    {
      public void a(gu paramAnonymousgu)
      {
        parama.aR();
      }
    });
  }
  
  public void a(t paramt, ds paramds, cb paramcb, dv paramdv, boolean paramBoolean, ce paramce)
  {
    this.mo.dD().a(paramt, paramds, paramcb, paramdv, paramBoolean, paramce, new v(false));
  }
  
  public void a(String paramString, cd paramcd)
  {
    this.mo.dD().a(paramString, paramcd);
  }
  
  public void a(final String paramString, final JSONObject paramJSONObject)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        aj.a(aj.this).a(paramString, paramJSONObject);
      }
    });
  }
  
  public void destroy()
  {
    this.mo.destroy();
  }
  
  public void f(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        aj.a(aj.this).loadUrl(paramString);
      }
    });
  }
  
  public void g(String paramString)
  {
    this.mo.dD().a(paramString, null);
  }
  
  public void pause()
  {
    gi.a(this.mo);
  }
  
  public void resume()
  {
    gi.b(this.mo);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.aj
 * JD-Core Version:    0.7.0.1
 */