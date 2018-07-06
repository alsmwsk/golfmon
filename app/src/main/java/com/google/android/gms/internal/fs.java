package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@ey
public final class fs
{
  private final Object mH = new Object();
  gu mo;
  private String uE;
  private gj<fu> uF = new gj();
  public final cd uG = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      synchronized (fs.a(fs.this))
      {
        if (fs.b(fs.this).isDone()) {
          return;
        }
        fu localfu = new fu(1, paramAnonymousMap);
        gr.W("Invalid " + localfu.getType() + " request error: " + localfu.cT());
        fs.b(fs.this).a(localfu);
        return;
      }
    }
  };
  public final cd uH = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      fu localfu;
      String str1;
      synchronized (fs.a(fs.this))
      {
        if (fs.b(fs.this).isDone()) {
          return;
        }
        localfu = new fu(-2, paramAnonymousMap);
        str1 = localfu.getUrl();
        if (str1 == null)
        {
          gr.W("URL missing in loadAdUrl GMSG.");
          return;
        }
      }
      if (str1.contains("%40mediation_adapters%40"))
      {
        String str2 = str1.replaceAll("%40mediation_adapters%40", ge.a(paramAnonymousgu.getContext(), (String)paramAnonymousMap.get("check_adapters"), fs.c(fs.this)));
        localfu.setUrl(str2);
        gr.V("Ad request URL modified to " + str2);
      }
      fs.b(fs.this).a(localfu);
    }
  };
  
  public fs(String paramString)
  {
    this.uE = paramString;
  }
  
  public void b(gu paramgu)
  {
    jx.aU("setAdWebView must be called on the main thread.");
    this.mo = paramgu;
  }
  
  public Future<fu> cR()
  {
    return this.uF;
  }
  
  public void cS()
  {
    jx.aU("destroyAdWebView must be called on the main thread.");
    if (this.mo != null)
    {
      this.mo.destroy();
      this.mo = null;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fs
 * JD-Core Version:    0.7.0.1
 */