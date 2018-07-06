package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Future;

@ey
public class ai
{
  protected ah a(Context paramContext, gs paramgs, final gj<ah> paramgj)
  {
    final aj localaj = new aj(paramContext, paramgs);
    localaj.a(new ah.a()
    {
      public void aR()
      {
        paramgj.a(localaj);
      }
    });
    return localaj;
  }
  
  public Future<ah> a(final Context paramContext, final gs paramgs, final String paramString)
  {
    final gj localgj = new gj();
    gq.wR.post(new Runnable()
    {
      public void run()
      {
        ai.this.a(paramContext, paramgs, localgj).f(paramString);
      }
    });
    return localgj;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ai
 * JD-Core Version:    0.7.0.1
 */