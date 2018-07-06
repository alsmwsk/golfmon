package com.nhn.android.naverlogin.connection.gen;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CommonLoginQuery
{
  protected final String kUrlRequestLoginKey = "https://nid.naver.com/nidlogin.login?";
  protected final String kUrlRequestLogout = "https://nid.naver.com/nidlogin.logout?";
  
  private static String percentEncode(String paramString)
    throws UnsupportedEncodingException
  {
    if (paramString == null) {
      return "";
    }
    return URLEncoder.encode(paramString, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
  }
  
  protected String getQueryParameter(Map<String, String> paramMap)
  {
    Set localSet = paramMap.keySet();
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = localSet.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localStringBuilder.toString();
      }
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      if ((str1 != null) && (str2 != null))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        try
        {
          localStringBuilder.append(percentEncode(str2));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localStringBuilder.append(str2);
        }
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.connection.gen.CommonLoginQuery
 * JD-Core Version:    0.7.0.1
 */