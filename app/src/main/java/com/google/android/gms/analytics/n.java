package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class n<T extends m>
{
  Context mContext;
  a<T> yL;
  
  public n(Context paramContext, a<T> parama)
  {
    this.mContext = paramContext;
    this.yL = parama;
  }
  
  private T a(XmlResourceParser paramXmlResourceParser)
  {
    for (;;)
    {
      try
      {
        paramXmlResourceParser.next();
        i = paramXmlResourceParser.getEventType();
        if (i == 1) {
          continue;
        }
        if (paramXmlResourceParser.getEventType() == 2)
        {
          str1 = paramXmlResourceParser.getName().toLowerCase();
          if (!str1.equals("screenname")) {
            continue;
          }
          String str8 = paramXmlResourceParser.getAttributeValue(null, "name");
          String str9 = paramXmlResourceParser.nextText().trim();
          if ((!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9))) {
            this.yL.e(str8, str9);
          }
        }
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        int i;
        String str6;
        String str7;
        ae.T("Error parsing tracker configuration file: " + localXmlPullParserException);
        return this.yL.er();
        if (!str1.equals("bool")) {
          continue;
        }
        String str4 = paramXmlResourceParser.getAttributeValue(null, "name");
        String str5 = paramXmlResourceParser.nextText().trim();
        if (TextUtils.isEmpty(str4)) {
          continue;
        }
        boolean bool2 = TextUtils.isEmpty(str5);
        if (bool2) {
          continue;
        }
        try
        {
          boolean bool3 = Boolean.parseBoolean(str5);
          this.yL.e(str4, bool3);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          ae.T("Error parsing bool configuration value: " + str5);
        }
        continue;
      }
      catch (IOException localIOException)
      {
        String str1;
        ae.T("Error parsing tracker configuration file: " + localIOException);
        continue;
        if (!str1.equals("integer")) {
          continue;
        }
        String str2 = paramXmlResourceParser.getAttributeValue(null, "name");
        String str3 = paramXmlResourceParser.nextText().trim();
        if (TextUtils.isEmpty(str2)) {
          continue;
        }
        boolean bool1 = TextUtils.isEmpty(str3);
        if (bool1) {
          continue;
        }
        try
        {
          int j = Integer.parseInt(str3);
          this.yL.c(str2, j);
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          ae.T("Error parsing int configuration value: " + str3);
        }
        continue;
      }
      i = paramXmlResourceParser.next();
      continue;
      if (!str1.equals("string")) {
        continue;
      }
      str6 = paramXmlResourceParser.getAttributeValue(null, "name");
      str7 = paramXmlResourceParser.nextText().trim();
      if ((!TextUtils.isEmpty(str6)) && (str7 != null)) {
        this.yL.f(str6, str7);
      }
    }
  }
  
  public T x(int paramInt)
  {
    try
    {
      m localm = a(this.mContext.getResources().getXml(paramInt));
      return localm;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      ae.W("inflate() called with unknown resourceId: " + localNotFoundException);
    }
    return null;
  }
  
  public static abstract interface a<U extends m>
  {
    public abstract void c(String paramString, int paramInt);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void e(String paramString, boolean paramBoolean);
    
    public abstract U er();
    
    public abstract void f(String paramString1, String paramString2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.n
 * JD-Core Version:    0.7.0.1
 */