package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

class a
  implements q
{
  private static Object xO = new Object();
  private static a xP;
  private Context mContext;
  private AdvertisingIdClient.Info xQ;
  private long xR;
  private String xS;
  private boolean xT = false;
  private Object xU = new Object();
  
  a(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  private boolean a(AdvertisingIdClient.Info paramInfo1, AdvertisingIdClient.Info paramInfo2)
  {
    if (paramInfo2 == null) {}
    for (Object localObject1 = null; TextUtils.isEmpty((CharSequence)localObject1); localObject1 = paramInfo2.getId()) {
      return true;
    }
    k.y(this.mContext);
    k localk = k.el();
    String str1 = localk.getValue("&cid");
    String str3;
    for (;;)
    {
      synchronized (this.xU)
      {
        if (!this.xT)
        {
          this.xS = x(this.mContext);
          this.xT = true;
          str3 = aa((String)localObject1 + str1);
          if (!TextUtils.isEmpty(str3)) {
            break;
          }
          return false;
        }
      }
      if (TextUtils.isEmpty(this.xS))
      {
        String str2 = null;
        if (paramInfo1 == null) {}
        while (str2 == null)
        {
          boolean bool1 = ab((String)localObject1 + str1);
          return bool1;
          str2 = paramInfo1.getId();
        }
        this.xS = aa(str2 + str1);
      }
    }
    if (str3.equals(this.xS)) {
      return true;
    }
    String str4;
    if (!TextUtils.isEmpty(this.xS))
    {
      ae.V("Resetting the client id because Advertising Id changed.");
      str4 = localk.em();
      ae.V("New client Id: " + str4);
    }
    for (;;)
    {
      boolean bool2 = ab((String)localObject1 + str4);
      return bool2;
      str4 = str1;
    }
  }
  
  static String aa(String paramString)
  {
    MessageDigest localMessageDigest = an.ap("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new BigInteger(1, localMessageDigest.digest(paramString.getBytes()));
    return String.format(localLocale, "%032X", arrayOfObject);
  }
  
  private boolean ab(String paramString)
  {
    try
    {
      String str = aa(paramString);
      ae.V("Storing hashed adid.");
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientIdData", 0);
      localFileOutputStream.write(str.getBytes());
      localFileOutputStream.close();
      this.xS = str;
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      ae.T("Error creating hash file.");
      return false;
    }
    catch (IOException localIOException)
    {
      ae.T("Error writing to hash file.");
    }
    return false;
  }
  
  public static q w(Context paramContext)
  {
    if (xP == null) {}
    synchronized (xO)
    {
      if (xP == null) {
        xP = new a(paramContext);
      }
      return xP;
    }
  }
  
  static String x(Context paramContext)
  {
    Object localObject = null;
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput("gaClientIdData");
      byte[] arrayOfByte = new byte[''];
      int i = localFileInputStream.read(arrayOfByte, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        ae.W("Hash file seems corrupted, deleting it.");
        localFileInputStream.close();
        paramContext.deleteFile("gaClientIdData");
        return null;
      }
      if (i <= 0)
      {
        ae.U("Hash file is empty.");
        localFileInputStream.close();
        return null;
      }
      String str = new String(arrayOfByte, 0, i);
      return null;
    }
    catch (IOException localIOException1)
    {
      try
      {
        localFileInputStream.close();
        return str;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localObject = str;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        return str;
      }
      localIOException1 = localIOException1;
      ae.W("Error reading Hash file, deleting it.");
      paramContext.deleteFile("gaClientIdData");
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException1) {}
  }
  
  AdvertisingIdClient.Info dP()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
      return localInfo;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ae.W("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
      return null;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      ae.W("GooglePlayServicesRepairableException getting Ad Id Info");
      return null;
    }
    catch (IOException localIOException)
    {
      ae.W("IOException getting Ad Id Info");
      return null;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      ae.W("GooglePlayServicesNotAvailableException getting Ad Id Info");
      return null;
    }
    catch (Throwable localThrowable)
    {
      ae.W("Unknown exception. Could not get the ad Id.");
    }
    return null;
  }
  
  public String getValue(String paramString)
  {
    long l = System.currentTimeMillis();
    AdvertisingIdClient.Info localInfo;
    if (l - this.xR > 1000L)
    {
      localInfo = dP();
      if (!a(this.xQ, localInfo)) {
        break label72;
      }
    }
    label72:
    for (this.xQ = localInfo;; this.xQ = new AdvertisingIdClient.Info("", false))
    {
      this.xR = l;
      if (this.xQ == null) {
        break label118;
      }
      if (!"&adid".equals(paramString)) {
        break;
      }
      return this.xQ.getId();
    }
    if ("&ate".equals(paramString))
    {
      if (this.xQ.isLimitAdTrackingEnabled()) {
        return "0";
      }
      return "1";
    }
    label118:
    return null;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.a
 * JD-Core Version:    0.7.0.1
 */