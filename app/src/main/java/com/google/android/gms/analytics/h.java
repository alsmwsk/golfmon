package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

public class h
  implements r
{
  private final Context mContext;
  private final String wl;
  private final HttpClient yf;
  private URL yg;
  private int yh;
  private int yi;
  private int yj;
  private String yk;
  private String yl;
  private i ym;
  private l yn;
  private Set<Integer> yo = new HashSet();
  private boolean yp = false;
  private long yq;
  private long yr;
  private o ys;
  private volatile boolean yt = false;
  
  h(HttpClient paramHttpClient, Context paramContext, o paramo)
  {
    this.mContext = paramContext.getApplicationContext();
    this.ys = paramo;
    this.wl = a("GoogleAnalytics", "4.0", Build.VERSION.RELEASE, an.a(Locale.getDefault()), Build.MODEL, Build.ID);
    this.yf = paramHttpClient;
  }
  
  private String a(ab paramab, List<String> paramList, i parami)
  {
    if (parami == i.yw)
    {
      if ((paramab.fa() == null) || (paramab.fa().length() == 0)) {}
      long l;
      for (String str3 = "";; str3 = paramab.fa())
      {
        l = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str3)) {
          break;
        }
        return "";
      }
      return ac.a(paramab, l);
    }
    String str1 = "";
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (str2.length() != 0)
      {
        if (str1.length() != 0) {
          str1 = str1 + "\n";
        }
        str1 = str1 + str2;
      }
    }
    return str1;
  }
  
  private URL a(ab paramab)
  {
    if (this.yg != null) {
      return this.yg;
    }
    String str1 = paramab.fd();
    for (;;)
    {
      try
      {
        if ("http:".equals(str1))
        {
          str2 = "http://www.google-analytics.com/collect";
          URL localURL = new URL(str2);
          return localURL;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        ae.T("Error trying to parse the hardcoded host url. This really shouldn't happen.");
        return null;
      }
      String str2 = "https://ssl.google-analytics.com/collect";
    }
  }
  
  private void a(af paramaf, HttpHost paramHttpHost, i parami, l paraml)
  {
    paramaf.g("_bs", parami.toString());
    paramaf.g("_cs", paraml.toString());
    String str = paramaf.fg();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (paramHttpHost == null) {}
    for (;;)
    {
      try
      {
        URL localURL = new URL("https://ssl.google-analytics.com");
        localHttpHost = new HttpHost(localURL.getHost(), localURL.getPort(), localURL.getProtocol());
        a(str, localHttpHost, 1, paramaf, l.yI);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        return;
      }
      HttpHost localHttpHost = paramHttpHost;
    }
  }
  
  private void a(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Header[] arrayOfHeader = paramHttpEntityEnclosingRequest.getAllHeaders();
    int i = arrayOfHeader.length;
    for (int j = 0; j < i; j++) {
      localStringBuffer.append(arrayOfHeader[j].toString()).append("\n");
    }
    localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
    if (paramHttpEntityEnclosingRequest.getEntity() != null) {}
    try
    {
      InputStream localInputStream = paramHttpEntityEnclosingRequest.getEntity().getContent();
      if (localInputStream != null)
      {
        int k = localInputStream.available();
        if (k > 0)
        {
          byte[] arrayOfByte = new byte[k];
          localInputStream.read(arrayOfByte);
          localStringBuffer.append("POST:\n");
          localStringBuffer.append(new String(arrayOfByte)).append("\n");
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.W("Error Writing hit to log...");
      }
    }
    ae.U(localStringBuffer.toString());
  }
  
  private boolean a(String paramString, HttpHost paramHttpHost, int paramInt, af paramaf, l paraml)
  {
    boolean bool;
    if (paramInt > 1)
    {
      bool = true;
      if ((paramString.getBytes().length <= this.yj) && (paramString.getBytes().length <= this.yi)) {
        break label79;
      }
      ae.W("Request too long (> " + Math.min(this.yi, this.yj) + " bytes)--not sent");
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label79:
      if (this.yt)
      {
        ae.U("Dry run enabled. Hit not actually sent.");
        return true;
      }
      HttpEntityEnclosingRequest localHttpEntityEnclosingRequest = d(paramString, bool);
      if (localHttpEntityEnclosingRequest != null)
      {
        int j;
        int i;
        if (localHttpEntityEnclosingRequest.getRequestLine().getMethod().equals("GET"))
        {
          j = paramString.getBytes().length;
          i = paramString.getBytes().length;
          localHttpEntityEnclosingRequest.addHeader("Host", paramHttpHost.toHostString());
          if (ae.ff()) {
            a(localHttpEntityEnclosingRequest);
          }
        }
        try
        {
          HttpResponse localHttpResponse;
          for (;;)
          {
            localHttpResponse = this.yf.execute(paramHttpHost, localHttpEntityEnclosingRequest);
            paramaf.e("_td", j);
            paramaf.e("_cd", i);
            int k = localHttpResponse.getStatusLine().getStatusCode();
            HttpEntity localHttpEntity = localHttpResponse.getEntity();
            if (localHttpEntity != null) {
              localHttpEntity.consumeContent();
            }
            if (k == 200) {
              break;
            }
            if ((bool) && (this.yo.contains(Integer.valueOf(k))))
            {
              ae.U("Falling back to single hit per request mode.");
              this.yp = true;
              this.yq = System.currentTimeMillis();
              return false;
              try
              {
                switch (1.yu[paraml.ordinal()])
                {
                default: 
                  i = paramString.getBytes().length;
                  localHttpEntityEnclosingRequest.setEntity(new StringEntity(paramString));
                }
                for (;;)
                {
                  j = paramString.getBytes().length;
                  break;
                  ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                  GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
                  localGZIPOutputStream.write(paramString.getBytes());
                  localGZIPOutputStream.close();
                  byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
                  i = 0 + arrayOfByte.length;
                  localHttpEntityEnclosingRequest.setEntity(new ByteArrayEntity(arrayOfByte));
                  localHttpEntityEnclosingRequest.addHeader("Content-Encoding", "gzip");
                }
                ae.W("Bad response: " + localHttpResponse.getStatusLine().getStatusCode());
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                ae.T("Encoding error, hit will be discarded");
                return true;
              }
              catch (IOException localIOException1)
              {
                ae.T("Unexpected IOException: " + localIOException1.getMessage());
                ae.T("Request will be discarded");
                return true;
              }
            }
          }
          return true;
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          ae.W("ClientProtocolException sending hit; discarding hit...");
          return true;
        }
        catch (IOException localIOException2)
        {
          ae.W("Exception sending hit: " + localIOException2.getClass().getSimpleName());
          ae.W(localIOException2.getMessage());
        }
      }
    }
    return false;
  }
  
  private HttpEntityEnclosingRequest d(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      System.out.println("Empty hit, discarding.");
      return null;
    }
    String str = this.yk + "?" + paramString;
    BasicHttpEntityEnclosingRequest localBasicHttpEntityEnclosingRequest;
    if ((str.length() < this.yh) && (!paramBoolean)) {
      localBasicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str);
    }
    for (;;)
    {
      localBasicHttpEntityEnclosingRequest.addHeader("User-Agent", this.wl);
      return localBasicHttpEntityEnclosingRequest;
      if (paramBoolean) {
        localBasicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", this.yl);
      } else {
        localBasicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", this.yk);
      }
    }
  }
  
  int a(List<ab> paramList, int paramInt)
  {
    if (paramList.isEmpty())
    {
      j = 0;
      return j;
    }
    if (paramInt > paramList.size()) {
      paramInt = paramList.size();
    }
    int i = paramInt - 1;
    long l1 = 0L;
    int j = paramInt;
    label42:
    long l4;
    if (i > 0)
    {
      ab localab1 = (ab)paramList.get(i - 1);
      ab localab2 = (ab)paramList.get(i);
      long l2 = localab1.fc();
      long l3 = localab2.fc();
      if ((l2 == 0L) || (l3 == 0L) || (l3 - l2 <= l1)) {
        break label135;
      }
      l4 = l3 - l2;
    }
    for (int k = i;; k = j)
    {
      i--;
      j = k;
      l1 = l4;
      break label42;
      break;
      label135:
      l4 = l1;
    }
  }
  
  public int a(List<ab> paramList, af paramaf, boolean paramBoolean)
  {
    this.yh = this.ys.eb();
    this.yi = this.ys.ec();
    this.yj = this.ys.ed();
    int i = this.ys.ee();
    this.yk = this.ys.eg();
    this.yl = this.ys.eh();
    this.ym = this.ys.ei();
    this.yn = this.ys.ej();
    this.yo.clear();
    this.yo.addAll(this.ys.ek());
    this.yr = this.ys.ef();
    if ((!this.yp) && (this.yo.isEmpty()))
    {
      this.yp = true;
      this.yq = System.currentTimeMillis();
    }
    if ((this.yp) && (System.currentTimeMillis() - this.yq > 1000L * this.yr)) {
      this.yp = false;
    }
    l locall;
    Object localObject1;
    int j;
    int k;
    long l1;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    long l2;
    int n;
    label301:
    ab localab2;
    String str2;
    label338:
    int i11;
    label389:
    int i9;
    label430:
    int m;
    if (this.yp)
    {
      i locali2 = i.yw;
      locall = l.yI;
      localObject1 = locali2;
      j = 0;
      k = Math.min(paramList.size(), i);
      paramaf.e("_hr", paramList.size());
      l1 = System.currentTimeMillis();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      l2 = 0L;
      if (localObject1 == i.yw) {
        break label1083;
      }
      Iterator localIterator2 = paramList.iterator();
      n = 0;
      if (!localIterator2.hasNext()) {
        break label1077;
      }
      localab2 = (ab)localIterator2.next();
      if (!TextUtils.isEmpty(localab2.fa())) {
        break label501;
      }
      str2 = "";
      if (str2.getBytes().length > this.yi) {
        str2 = "";
      }
      localArrayList1.add(str2);
      if (!TextUtils.isEmpty(str2))
      {
        int i10 = str2.getBytes().length;
        if (n != 0) {
          break label513;
        }
        i11 = 0;
        l2 += i11 + i10;
      }
      localArrayList2.add(Long.valueOf(l2));
      if (l2 > this.yj) {
        break label1070;
      }
      i9 = n + 1;
      if (i9 != k) {
        break label519;
      }
      n = i9;
      m = 1;
    }
    for (;;)
    {
      if ((n > 1) && (((Long)localArrayList2.get(n - 1)).longValue() > this.yj))
      {
        n--;
        continue;
        i locali1 = this.ym;
        locall = this.yn;
        localObject1 = locali1;
        break;
        label501:
        str2 = ac.a(localab2, l1);
        break label338;
        label513:
        i11 = 1;
        break label389;
        label519:
        n = i9;
        break label301;
      }
      int i7;
      if (l2 > this.yj) {
        switch (1.yv[localObject1.ordinal()])
        {
        default: 
          ae.W("Unexpected batching strategy encountered; sending a single hit.");
          String str1 = (String)localArrayList1.get(0);
          localArrayList1.clear();
          localArrayList1.add(str1);
          i7 = 1;
          if (i7 >= localArrayList1.size()) {
            break;
          }
        }
      }
      for (Object localObject2 = localArrayList1.subList(0, i7);; localObject2 = localArrayList1)
      {
        int i1 = 0;
        HttpHost localHttpHost = null;
        int i2 = 0;
        int i3;
        int i4;
        int i5;
        for (;;)
        {
          if (i2 < m)
          {
            ab localab1 = (ab)paramList.get(i2);
            URL localURL = a(localab1);
            i3 = Math.max(1, ((List)localObject2).size());
            if (localURL == null)
            {
              ae.W("No destination: discarding hit.");
              i4 = i1 + i3;
              i5 = j + i3;
              i2++;
              i1 = i4;
              j = i5;
              continue;
              i7 = localArrayList1.size() / 2;
              if (n > i7) {
                break;
              }
              i7 = n;
              break;
              i7 = a(paramList, n);
              break;
              i7 = b(paramList, n);
              break;
              if (l2 < 2 * this.yj)
              {
                for (int i8 = -1 + localArrayList2.size(); (i8 > 0) && (((Long)localArrayList2.get(i8)).longValue() > l2 / 2L); i8--) {}
                i7 = i8;
                break;
              }
              i7 = n;
              break;
              i7 = n;
              break;
            }
            localHttpHost = new HttpHost(localURL.getHost(), localURL.getPort(), localURL.getProtocol());
            if (!a(a(localab1, (List)localObject2, (i)localObject1), localHttpHost, i3, paramaf, locall))
            {
              paramaf.e("_de", 1);
              paramaf.e("_hd", i1);
              paramaf.e("_hs", j);
              a(paramaf, localHttpHost, (i)localObject1, locall);
              return j;
            }
            Iterator localIterator1 = ((List)localObject2).iterator();
            i4 = i1;
            label963:
            if (localIterator1.hasNext()) {
              if (!TextUtils.isEmpty((String)localIterator1.next())) {
                break label1056;
              }
            }
          }
        }
        label1056:
        for (int i6 = i4 + 1;; i6 = i4)
        {
          i4 = i6;
          break label963;
          paramaf.e("_rs", 1);
          i5 = j + i3;
          break;
          paramaf.e("_hd", i1);
          paramaf.e("_hs", j);
          if (paramBoolean) {
            a(paramaf, localHttpHost, (i)localObject1, locall);
          }
          return j;
        }
      }
      label1070:
      i9 = n;
      break label430;
      label1077:
      m = 1;
      continue;
      label1083:
      m = k;
      n = 0;
    }
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  public void ad(String paramString)
  {
    try
    {
      this.yg = new URL(paramString);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.yg = null;
    }
  }
  
  int b(List<ab> paramList, int paramInt)
  {
    if (paramList.isEmpty()) {
      paramInt = 0;
    }
    for (;;)
    {
      return paramInt;
      for (int i = paramInt - 1; i > 0; i--)
      {
        String str = ((ab)paramList.get(i)).fa();
        if (!TextUtils.isEmpty(str))
        {
          if (str.contains("sc=start")) {
            return i;
          }
          if (str.contains("sc=end")) {
            return i + 1;
          }
        }
      }
    }
  }
  
  public boolean ea()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      ae.V("...no network connectivity");
      return false;
    }
    return true;
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    this.yt = paramBoolean;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.h
 * JD-Core Version:    0.7.0.1
 */