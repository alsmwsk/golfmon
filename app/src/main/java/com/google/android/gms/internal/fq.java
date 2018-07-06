package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ey
public final class fq
  extends fl.a
{
  private static final Object ut = new Object();
  private static fq uu;
  private final Context mContext;
  private final fw uv;
  private final cn uw;
  private final bm ux;
  
  fq(Context paramContext, bm parambm, cn paramcn, fw paramfw)
  {
    this.mContext = paramContext;
    this.uv = paramfw;
    this.uw = paramcn;
    this.ux = parambm;
  }
  
  private static gv.a I(String paramString)
  {
    new gv.a()
    {
      public void a(gu paramAnonymousgu)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "AFMA_buildAdURL";
        arrayOfObject[1] = this.uC;
        String str = String.format("javascript:%s(%s);", arrayOfObject);
        gr.V("About to execute: " + str);
        paramAnonymousgu.loadUrl(str);
      }
    };
  }
  
  private static fj a(Context paramContext, bm parambm, cn paramcn, fw paramfw, final fh paramfh)
  {
    gr.S("Starting ad request from service.");
    paramcn.init();
    fv localfv = new fv(paramContext);
    if (localfv.vr == -1)
    {
      gr.S("Device is offline.");
      return new fj(2);
    }
    final fs localfs = new fs(paramfh.applicationInfo.packageName);
    if (paramfh.tL.extras != null)
    {
      String str4 = paramfh.tL.extras.getString("_ad");
      if (str4 != null) {
        return fr.a(paramContext, paramfh, str4);
      }
    }
    Location localLocation = paramcn.a(250L);
    final String str1 = parambm.bu();
    String str2 = fr.a(paramfh, localfv, localLocation, parambm.bv(), parambm.bw(), parambm.bx());
    if (str2 == null) {
      return new fj(0);
    }
    final gv.a locala = I(str2);
    gq.wR.post(new Runnable()
    {
      public void run()
      {
        gu localgu = gu.a(this.nf, new ay(), false, false, null, paramfh.lO);
        localgu.setWillNotDraw(true);
        localfs.b(localgu);
        gv localgv = localgu.dD();
        localgv.a("/invalidRequest", localfs.uG);
        localgv.a("/loadAdURL", localfs.uH);
        localgv.a("/log", cc.pX);
        localgv.a(locala);
        gr.S("Loading the JS library.");
        localgu.loadUrl(str1);
      }
    });
    try
    {
      localfu = (fu)localfs.cR().get(10L, TimeUnit.SECONDS);
      if (localfu == null)
      {
        fj localfj4 = new fj(0);
        return localfj4;
      }
    }
    catch (Exception localException)
    {
      fu localfu;
      fj localfj1 = new fj(0);
      return localfj1;
      if (localfu.getErrorCode() != -2)
      {
        fj localfj2 = new fj(localfu.getErrorCode());
        return localfj2;
      }
      boolean bool = localfu.cV();
      String str3 = null;
      if (bool) {
        str3 = paramfw.K(paramfh.tM.packageName);
      }
      fj localfj3 = a(paramContext, paramfh.lO.wS, localfu.getUrl(), str3, localfu);
      return localfj3;
    }
    finally
    {
      gq.wR.post(new Runnable()
      {
        public void run()
        {
          this.uz.cS();
        }
      });
    }
  }
  
  public static fj a(Context paramContext, String paramString1, String paramString2, String paramString3, fu paramfu)
  {
    try
    {
      localft = new ft();
      gr.S("AdRequestServiceImpl: Sending request: " + paramString2);
      URL localURL1 = new URL(paramString2);
      l = SystemClock.elapsedRealtime();
      localURL2 = localURL1;
      i = 0;
    }
    catch (IOException localIOException)
    {
      try
      {
        for (;;)
        {
          ft localft;
          long l;
          URL localURL2;
          int i;
          gi.a(paramContext, paramString1, false, localHttpURLConnection);
          if (!TextUtils.isEmpty(paramString3)) {
            localHttpURLConnection.addRequestProperty("x-afma-drt-cookie", paramString3);
          }
          if ((paramfu != null) && (!TextUtils.isEmpty(paramfu.cU())))
          {
            localHttpURLConnection.setDoOutput(true);
            byte[] arrayOfByte = paramfu.cU().getBytes();
            localHttpURLConnection.setFixedLengthStreamingMode(arrayOfByte.length);
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
            localBufferedOutputStream.write(arrayOfByte);
            localBufferedOutputStream.close();
          }
          int j = localHttpURLConnection.getResponseCode();
          Map localMap = localHttpURLConnection.getHeaderFields();
          if ((j >= 200) && (j < 300))
          {
            String str2 = localURL2.toString();
            String str3 = gi.a(new InputStreamReader(localHttpURLConnection.getInputStream()));
            a(str2, localMap, str3, j);
            localft.a(str2, localMap, str3);
            fj localfj4 = localft.i(l);
            return localfj4;
          }
          a(localURL2.toString(), localMap, null, j);
          if ((j >= 300) && (j < 400))
          {
            String str1 = localHttpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(str1))
            {
              gr.W("No location header to follow redirect.");
              fj localfj3 = new fj(0);
              return localfj3;
            }
            localURL2 = new URL(str1);
            i++;
            if (i > 5)
            {
              gr.W("Too many redirects.");
              fj localfj2 = new fj(0);
              return localfj2;
            }
          }
          else
          {
            gr.W("Received error HTTP response code: " + j);
            fj localfj1 = new fj(0);
            return localfj1;
          }
          localft.e(localMap);
          localHttpURLConnection.disconnect();
        }
      }
      finally
      {
        HttpURLConnection localHttpURLConnection;
        localHttpURLConnection.disconnect();
      }
      localIOException = localIOException;
      gr.W("Error while connecting to ad server: " + localIOException.getMessage());
      return new fj(2);
    }
    localHttpURLConnection = (HttpURLConnection)localURL2.openConnection();
  }
  
  public static fq a(Context paramContext, bm parambm, cn paramcn, fw paramfw)
  {
    synchronized (ut)
    {
      if (uu == null) {
        uu = new fq(paramContext.getApplicationContext(), parambm, paramcn, paramfw);
      }
      fq localfq = uu;
      return localfq;
    }
  }
  
  private static void a(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (gr.v(2))
    {
      gr.V("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str1 = (String)localIterator1.next();
          gr.V("    " + str1 + ":");
          Iterator localIterator2 = ((List)paramMap.get(str1)).iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            gr.V("      " + str2);
          }
        }
      }
      gr.V("  Body:");
      if (paramString2 != null) {
        for (int i = 0; i < Math.min(paramString2.length(), 100000); i += 1000) {
          gr.V(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
        }
      }
      gr.V("    null");
      gr.V("  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  public fj b(fh paramfh)
  {
    return a(this.mContext, this.ux, this.uw, this.uv, paramfh);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fq
 * JD-Core Version:    0.7.0.1
 */