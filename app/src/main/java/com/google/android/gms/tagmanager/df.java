package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class df
{
  private Context mContext;
  private Tracker yO;
  private GoogleAnalytics yQ;
  
  df(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void cX(String paramString)
  {
    try
    {
      if (this.yQ == null)
      {
        this.yQ = GoogleAnalytics.getInstance(this.mContext);
        this.yQ.setLogger(new a());
        this.yO = this.yQ.newTracker(paramString);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Tracker cW(String paramString)
  {
    cX(paramString);
    return this.yO;
  }
  
  static class a
    implements Logger
  {
    private static int fP(int paramInt)
    {
      switch (paramInt)
      {
      case 6: 
      default: 
        return 3;
      case 5: 
        return 2;
      case 3: 
      case 4: 
        return 1;
      }
      return 0;
    }
    
    public void error(Exception paramException)
    {
      bh.b("", paramException);
    }
    
    public void error(String paramString)
    {
      bh.T(paramString);
    }
    
    public int getLogLevel()
    {
      return fP(bh.getLogLevel());
    }
    
    public void info(String paramString)
    {
      bh.U(paramString);
    }
    
    public void setLogLevel(int paramInt)
    {
      bh.W("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }
    
    public void verbose(String paramString)
    {
      bh.V(paramString);
    }
    
    public void warn(String paramString)
    {
      bh.W(paramString);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.df
 * JD-Core Version:    0.7.0.1
 */