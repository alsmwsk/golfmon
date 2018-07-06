package com.google.android.gms.analytics;

public class ae
{
  private static GoogleAnalytics BL;
  private static volatile boolean BM = false;
  private static Logger BN;
  
  public static void T(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.error(paramString);
    }
  }
  
  public static void U(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.info(paramString);
    }
  }
  
  public static void V(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.verbose(paramString);
    }
  }
  
  public static void W(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.warn(paramString);
    }
  }
  
  public static boolean ff()
  {
    Logger localLogger = getLogger();
    boolean bool = false;
    if (localLogger != null)
    {
      int i = getLogger().getLogLevel();
      bool = false;
      if (i == 0) {
        bool = true;
      }
    }
    return bool;
  }
  
  static Logger getLogger()
  {
    try
    {
      if (BM)
      {
        if (BN == null) {
          BN = new p();
        }
        Logger localLogger2 = BN;
        return localLogger2;
      }
      if (BL == null) {
        BL = GoogleAnalytics.eY();
      }
      if (BL != null)
      {
        Logger localLogger1 = BL.getLogger();
        return localLogger1;
      }
    }
    finally {}
    return null;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ae
 * JD-Core Version:    0.7.0.1
 */