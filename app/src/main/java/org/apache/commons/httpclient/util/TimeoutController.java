package org.apache.commons.httpclient.util;

public final class TimeoutController
{
  public static void execute(Runnable paramRunnable, long paramLong)
    throws TimeoutController.TimeoutException
  {
    Thread localThread = new Thread(paramRunnable, "Timeout guard");
    localThread.setDaemon(true);
    execute(localThread, paramLong);
  }
  
  public static void execute(Thread paramThread, long paramLong)
    throws TimeoutController.TimeoutException
  {
    paramThread.start();
    try
    {
      paramThread.join(paramLong);
      label9:
      if (paramThread.isAlive())
      {
        paramThread.interrupt();
        throw new TimeoutException();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label9;
    }
  }
  
  public static class TimeoutException
    extends Exception
  {}
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.util.TimeoutController
 * JD-Core Version:    0.7.0.1
 */