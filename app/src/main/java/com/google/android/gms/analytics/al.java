package com.google.android.gms.analytics;

import android.content.Context;
import java.util.Map;

class al
  extends n<am>
{
  public al(Context paramContext)
  {
    super(paramContext, new a());
  }
  
  private static class a
    implements n.a<am>
  {
    private final am Cu = new am();
    
    public void c(String paramString, int paramInt)
    {
      if ("ga_sessionTimeout".equals(paramString))
      {
        this.Cu.Cx = paramInt;
        return;
      }
      ae.W("int configuration name not recognized:  " + paramString);
    }
    
    public void e(String paramString1, String paramString2)
    {
      this.Cu.CB.put(paramString1, paramString2);
    }
    
    public void e(String paramString, boolean paramBoolean)
    {
      int i = 1;
      if ("ga_autoActivityTracking".equals(paramString))
      {
        am localam3 = this.Cu;
        if (paramBoolean) {}
        for (;;)
        {
          localam3.Cy = i;
          return;
          i = 0;
        }
      }
      if ("ga_anonymizeIp".equals(paramString))
      {
        am localam2 = this.Cu;
        if (paramBoolean) {}
        for (;;)
        {
          localam2.Cz = i;
          return;
          i = 0;
        }
      }
      if ("ga_reportUncaughtExceptions".equals(paramString))
      {
        am localam1 = this.Cu;
        if (paramBoolean) {}
        for (;;)
        {
          localam1.CA = i;
          return;
          i = 0;
        }
      }
      ae.W("bool configuration name not recognized:  " + paramString);
    }
    
    public void f(String paramString1, String paramString2)
    {
      if ("ga_trackingId".equals(paramString1))
      {
        this.Cu.Cv = paramString2;
        return;
      }
      if ("ga_sampleFrequency".equals(paramString1)) {
        try
        {
          this.Cu.Cw = Double.parseDouble(paramString2);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          ae.T("Error parsing ga_sampleFrequency value: " + paramString2);
          return;
        }
      }
      ae.W("string configuration name not recognized:  " + paramString1);
    }
    
    public am fs()
    {
      return this.Cu;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.al
 * JD-Core Version:    0.7.0.1
 */