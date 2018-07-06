package com.appg.golfmon.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KakaoLink
{
  private static String KakaoLinkApiVersion;
  private static Charset KakaoLinkCharset = Charset.forName("UTF-8");
  private static String KakaoLinkEncoding = KakaoLinkCharset.name();
  private static String KakaoLinkURLBaseString;
  private static KakaoLink kakaoLink = null;
  private Context context;
  private String params;
  
  static
  {
    KakaoLinkApiVersion = "2.0";
    KakaoLinkURLBaseString = "kakaolink://sendurl";
  }
  
  private KakaoLink(Context paramContext)
  {
    this.context = paramContext;
    this.params = getBaseKakaoLinkUrl();
  }
  
  private void appendMetaInfo(ArrayList<Map<String, String>> paramArrayList)
  {
    this.params += "metainfo=";
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      try
      {
        localIterator1 = paramArrayList.iterator();
        if (!localIterator1.hasNext()) {
          localJSONObject1.put("metainfo", localJSONArray);
        }
      }
      catch (JSONException localJSONException)
      {
        Iterator localIterator1;
        String str1;
        Map localMap;
        JSONObject localJSONObject2;
        Iterator localIterator2;
        localJSONException.printStackTrace();
        continue;
        String str2 = (String)localIterator2.next();
        localJSONObject2.put(str2, localMap.get(str2));
        continue;
      }
      try
      {
        str1 = URLEncoder.encode(localJSONObject1.toString(), KakaoLinkEncoding);
        this.params += str1;
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      localMap = (Map)localIterator1.next();
      localJSONObject2 = new JSONObject();
      localIterator2 = localMap.keySet().iterator();
      if (localIterator2.hasNext()) {
        continue;
      }
      localJSONArray.put(localJSONObject2);
    }
  }
  
  private void appendParam(String paramString1, String paramString2)
  {
    try
    {
      String str = URLEncoder.encode(paramString2, KakaoLinkEncoding);
      this.params = (this.params + paramString1 + "=" + str + "&");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  private String getBaseKakaoLinkUrl()
  {
    return KakaoLinkURLBaseString + "?";
  }
  
  public static KakaoLink getLink(Context paramContext)
  {
    if (kakaoLink != null) {
      return kakaoLink;
    }
    return new KakaoLink(paramContext);
  }
  
  private boolean isEmptyString(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  private void openKakaoLink(Activity paramActivity, String paramString)
  {
    paramActivity.startActivity(new Intent("android.intent.action.SEND", Uri.parse(paramString)));
  }
  
  public boolean isAvailableIntent()
  {
    Intent localIntent = new Intent("android.intent.action.SEND", Uri.parse(KakaoLinkURLBaseString));
    List localList = this.context.getPackageManager().queryIntentActivities(localIntent, 65536);
    if (localList == null) {}
    while (localList.size() <= 0) {
      return false;
    }
    return true;
  }
  
  public void openKakaoAppLink(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ArrayList<Map<String, String>> paramArrayList)
  {
    if ((isEmptyString(paramString1)) || (isEmptyString(paramString2)) || (isEmptyString(paramString3)) || (isEmptyString(paramString4)) || (isEmptyString(paramString5)) || (isEmptyString(paramString6))) {
      throw new IllegalArgumentException();
    }
    try
    {
      if (KakaoLinkCharset.equals(Charset.forName(paramString6)))
      {
        String str = new String(paramString2.getBytes(paramString6), KakaoLinkEncoding);
        paramString2 = str;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    this.params = getBaseKakaoLinkUrl();
    appendParam("url", paramString1);
    appendParam("msg", paramString2);
    appendParam("apiver", KakaoLinkApiVersion);
    appendParam("appid", paramString3);
    appendParam("appver", paramString4);
    appendParam("appname", paramString5);
    appendParam("type", "app");
    appendMetaInfo(paramArrayList);
    openKakaoLink(paramActivity, this.params);
  }
  
  public void openKakaoLink(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((isEmptyString(paramString1)) || (isEmptyString(paramString2)) || (isEmptyString(paramString3)) || (isEmptyString(paramString4)) || (isEmptyString(paramString5)) || (isEmptyString(paramString6))) {
      throw new IllegalArgumentException();
    }
    try
    {
      if (KakaoLinkCharset.equals(Charset.forName(paramString6)))
      {
        String str = new String(paramString2.getBytes(paramString6), KakaoLinkEncoding);
        paramString2 = str;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    this.params = getBaseKakaoLinkUrl();
    appendParam("url", paramString1);
    appendParam("msg", paramString2);
    appendParam("apiver", KakaoLinkApiVersion);
    appendParam("appid", paramString3);
    appendParam("appver", paramString4);
    appendParam("appname", paramString5);
    appendParam("type", "link");
    openKakaoLink(paramActivity, this.params);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.KakaoLink
 * JD-Core Version:    0.7.0.1
 */