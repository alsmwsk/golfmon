package org.apache.commons.httpclient.params;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpVersion;

public class DefaultHttpParamsFactory
  implements HttpParamsFactory
{
  static Class class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
  private HttpParams httpParams;
  
  static Class class$(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }
  
  protected HttpParams createParams()
  {
    HttpClientParams localHttpClientParams = new HttpClientParams(null);
    localHttpClientParams.setParameter("http.useragent", "Jakarta Commons-HttpClient/3.0.1");
    localHttpClientParams.setVersion(HttpVersion.HTTP_1_1);
    Class localClass;
    if (class$org$apache$commons$httpclient$SimpleHttpConnectionManager == null)
    {
      localClass = class$("org.apache.commons.httpclient.SimpleHttpConnectionManager");
      class$org$apache$commons$httpclient$SimpleHttpConnectionManager = localClass;
      localHttpClientParams.setConnectionManagerClass(localClass);
      localHttpClientParams.setCookiePolicy("rfc2109");
      localHttpClientParams.setHttpElementCharset("US-ASCII");
      localHttpClientParams.setContentCharset("ISO-8859-1");
      localHttpClientParams.setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler());
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(Arrays.asList(new String[] { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z" }));
      localHttpClientParams.setParameter("http.dateparser.patterns", localArrayList);
    }
    try
    {
      String str7 = System.getProperty("httpclient.useragent");
      str1 = str7;
    }
    catch (SecurityException localSecurityException1)
    {
      for (;;)
      {
        String str1 = null;
      }
    }
    if (str1 != null) {
      localHttpClientParams.setParameter("http.useragent", str1);
    }
    try
    {
      String str6 = System.getProperty("httpclient.authentication.preemptive");
      str2 = str6;
    }
    catch (SecurityException localSecurityException2)
    {
      for (;;)
      {
        String str5;
        String str2 = null;
      }
    }
    if (str2 != null)
    {
      str5 = str2.trim().toLowerCase();
      if (!str5.equals("true")) {
        break label292;
      }
      localHttpClientParams.setParameter("http.authentication.preemptive", Boolean.TRUE);
    }
    try
    {
      label251:
      String str4 = System.getProperty("apache.commons.httpclient.cookiespec");
      str3 = str4;
    }
    catch (SecurityException localSecurityException3)
    {
      for (;;)
      {
        String str3 = null;
      }
    }
    if (str3 != null)
    {
      if (!"COMPATIBILITY".equalsIgnoreCase(str3)) {
        break label314;
      }
      localHttpClientParams.setCookiePolicy("compatibility");
    }
    label292:
    label314:
    do
    {
      return localHttpClientParams;
      localClass = class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
      break;
      if (!str5.equals("false")) {
        break label251;
      }
      localHttpClientParams.setParameter("http.authentication.preemptive", Boolean.FALSE);
      break label251;
      if ("NETSCAPE_DRAFT".equalsIgnoreCase(str3))
      {
        localHttpClientParams.setCookiePolicy("netscape");
        return localHttpClientParams;
      }
    } while (!"RFC2109".equalsIgnoreCase(str3));
    localHttpClientParams.setCookiePolicy("rfc2109");
    return localHttpClientParams;
  }
  
  public HttpParams getDefaultParams()
  {
    try
    {
      if (this.httpParams == null) {
        this.httpParams = createParams();
      }
      HttpParams localHttpParams = this.httpParams;
      return localHttpParams;
    }
    finally {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.params.DefaultHttpParamsFactory
 * JD-Core Version:    0.7.0.1
 */