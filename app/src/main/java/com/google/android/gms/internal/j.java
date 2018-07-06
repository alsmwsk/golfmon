package com.google.android.gms.internal;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class j
  extends i
{
  private static AdvertisingIdClient kO;
  private static CountDownLatch kP = new CountDownLatch(1);
  private static boolean kQ;
  
  protected j(Context paramContext, m paramm, n paramn)
  {
    super(paramContext, paramm, paramn);
  }
  
  public static j a(String paramString, Context paramContext)
  {
    e locale = new e();
    a(paramString, paramContext, locale);
    try
    {
      if (kO == null)
      {
        kO = new AdvertisingIdClient(paramContext);
        new AsyncTask()
        {
          protected Void a(Void... paramAnonymousVarArgs)
          {
            try
            {
              j.A().start();
              j.B().countDown();
              return null;
            }
            catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
            {
              for (;;)
              {
                j.a(true);
                j.a(null);
              }
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                j.a(null);
              }
            }
            catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
            {
              for (;;)
              {
                j.a(null);
              }
            }
          }
        }.execute(new Void[0]);
      }
      return new j(paramContext, locale, new p(239));
    }
    finally {}
  }
  
  protected void b(Context paramContext)
  {
    super.b(paramContext);
    try
    {
      if (kQ)
      {
        a(24, d(paramContext));
        return;
      }
      locala1 = z();
      if (!locala1.isLimitAdTrackingEnabled()) {
        break label79;
      }
      l = 1L;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        a locala1;
        String str;
        return;
        long l = 0L;
      }
    }
    catch (i.a locala) {}
    a(28, l);
    str = locala1.getId();
    if (str != null)
    {
      a(26, 5L);
      a(24, str);
      return;
    }
    label79:
  }
  
  a z()
    throws IOException
  {
    int i = 0;
    try
    {
      if (!kP.await(2L, TimeUnit.SECONDS))
      {
        a locala2 = new a(null, false);
        return locala2;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      a locala1 = new a(null, false);
      return locala1;
    }
    finally {}
    if (kO == null)
    {
      a locala3 = new a(null, false);
      return locala3;
    }
    AdvertisingIdClient.Info localInfo = kO.getInfo();
    String str1 = localInfo.getId();
    byte[] arrayOfByte;
    if ((str1 != null) && (str1.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")))
    {
      arrayOfByte = new byte[16];
      int j = 0;
      while (i < str1.length())
      {
        if ((i == 8) || (i == 13) || (i == 18) || (i == 23)) {
          i++;
        }
        arrayOfByte[j] = ((byte)((Character.digit(str1.charAt(i), 16) << 4) + Character.digit(str1.charAt(i + 1), 16)));
        j++;
        i += 2;
      }
    }
    for (String str2 = this.ky.a(arrayOfByte, true);; str2 = str1) {
      return new a(str2, localInfo.isLimitAdTrackingEnabled());
    }
  }
  
  class a
  {
    private String kR;
    private boolean kS;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.kR = paramString;
      this.kS = paramBoolean;
    }
    
    public String getId()
    {
      return this.kR;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return this.kS;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.j
 * JD-Core Version:    0.7.0.1
 */