package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dm
{
  private static bz<d.a> a(bz<d.a> parambz)
  {
    try
    {
      bz localbz = new bz(di.u(dg(di.j((d.a)parambz.getObject()))), parambz.pX());
      return localbz;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      bh.b("Escape URI: unsupported encoding", localUnsupportedEncodingException);
    }
    return parambz;
  }
  
  private static bz<d.a> a(bz<d.a> parambz, int paramInt)
  {
    if (!q((d.a)parambz.getObject()))
    {
      bh.T("Escaping can only be applied to strings.");
      return parambz;
    }
    switch (paramInt)
    {
    default: 
      bh.T("Unsupported Value Escaping: " + paramInt);
      return parambz;
    }
    return a(parambz);
  }
  
  static bz<d.a> a(bz<d.a> parambz, int... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      parambz = a(parambz, paramVarArgs[j]);
    }
    return parambz;
  }
  
  static String dg(String paramString)
    throws UnsupportedEncodingException
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
  
  private static boolean q(d.a parama)
  {
    return di.o(parama) instanceof String;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.dm
 * JD-Core Version:    0.7.0.1
 */