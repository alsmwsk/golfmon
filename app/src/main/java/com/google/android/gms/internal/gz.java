package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

@ey
public class gz
  extends WebViewClient
{
  private final gu mo;
  private final String xr = Z(paramString);
  private boolean xs = false;
  private final fb xt;
  
  public gz(fb paramfb, gu paramgu, String paramString)
  {
    this.mo = paramgu;
    this.xt = paramfb;
  }
  
  private String Z(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.endsWith("/"))
        {
          String str = paramString.substring(0, -1 + paramString.length());
          return str;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        gr.T(localIndexOutOfBoundsException.getMessage());
      }
    }
    return paramString;
  }
  
  protected boolean Y(String paramString)
  {
    String str1 = Z(paramString);
    if (TextUtils.isEmpty(str1)) {}
    for (;;)
    {
      return false;
      try
      {
        URI localURI1 = new URI(str1);
        if ("passback".equals(localURI1.getScheme()))
        {
          gr.S("Passback received");
          this.xt.cG();
          return true;
        }
        if (!TextUtils.isEmpty(this.xr))
        {
          URI localURI2 = new URI(this.xr);
          String str2 = localURI2.getHost();
          String str3 = localURI1.getHost();
          String str4 = localURI2.getPath();
          String str5 = localURI1.getPath();
          if ((jv.equal(str2, str3)) && (jv.equal(str4, str5)))
          {
            gr.S("Passback received");
            this.xt.cG();
            return true;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        gr.T(localURISyntaxException.getMessage());
      }
    }
    return false;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    gr.S("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!Y(paramString)) {
      this.mo.dD().onLoadResource(this.mo, paramString);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    gr.S("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.xs)
    {
      this.xt.cF();
      this.xs = true;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    gr.S("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    if (Y(paramString))
    {
      gr.S("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return this.mo.dD().shouldOverrideUrlLoading(this.mo, paramString);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gz
 * JD-Core Version:    0.7.0.1
 */