package com.google.android.gms.analytics;

import android.content.Context;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler yN;
  private final Tracker yO;
  private ExceptionParser yP;
  private GoogleAnalytics yQ;
  
  public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.yN = paramUncaughtExceptionHandler;
    this.yO = paramTracker;
    this.yP = new StandardExceptionParser(paramContext, new ArrayList());
    this.mContext = paramContext.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (String str = "null";; str = paramUncaughtExceptionHandler.getClass().getName())
    {
      ae.V(str);
      return;
    }
  }
  
  GoogleAnalytics es()
  {
    if (this.yQ == null) {
      this.yQ = GoogleAnalytics.getInstance(this.mContext);
    }
    return this.yQ;
  }
  
  Thread.UncaughtExceptionHandler et()
  {
    return this.yN;
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.yP;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.yP = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str1 = "UncaughtException";
    if (this.yP != null) {
      if (paramThread == null) {
        break label120;
      }
    }
    label120:
    for (String str2 = paramThread.getName();; str2 = null)
    {
      str1 = this.yP.getDescription(str2, paramThrowable);
      ae.V("Tracking Exception: " + str1);
      this.yO.send(new HitBuilders.ExceptionBuilder().setDescription(str1).setFatal(true).build());
      GoogleAnalytics localGoogleAnalytics = es();
      localGoogleAnalytics.dispatchLocalHits();
      localGoogleAnalytics.dY();
      if (this.yN != null)
      {
        ae.V("Passing exception to original handler.");
        this.yN.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ExceptionReporter
 * JD-Core Version:    0.7.0.1
 */