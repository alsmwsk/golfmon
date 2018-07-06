package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class ce
{
  private static ce asm;
  private volatile String aqm;
  private volatile a asn;
  private volatile String aso;
  private volatile String asp;
  
  ce()
  {
    clear();
  }
  
  private String cK(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String j(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  static ce qa()
  {
    try
    {
      if (asm == null) {
        asm = new ce();
      }
      ce localce = asm;
      return localce;
    }
    finally {}
  }
  
  void clear()
  {
    this.asn = a.asq;
    this.aso = null;
    this.aqm = null;
    this.asp = null;
  }
  
  String getContainerId()
  {
    return this.aqm;
  }
  
  boolean i(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label158;
      }
      bh.V("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label143;
      }
      this.asn = a.ass;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.asn = a.asr;
      }
    }
    finally {}
    this.asp = j(paramUri);
    if ((this.asn == a.asr) || (this.asn == a.ass)) {
      this.aso = ("/r?" + this.asp);
    }
    this.aqm = cK(this.asp);
    for (;;)
    {
      return bool;
      label143:
      label158:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (cK(paramUri.getQuery()).equals(this.aqm))
        {
          bh.V("Exit preview mode for container: " + this.aqm);
          this.asn = a.asq;
          this.aso = null;
        }
      }
      else
      {
        bh.W("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  a qb()
  {
    return this.asn;
  }
  
  String qc()
  {
    return this.aso;
  }
  
  static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = asq;
      arrayOfa[1] = asr;
      arrayOfa[2] = ass;
      ast = arrayOfa;
    }
    
    private a() {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ce
 * JD-Core Version:    0.7.0.1
 */