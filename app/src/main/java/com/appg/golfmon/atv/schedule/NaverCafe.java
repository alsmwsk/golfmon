package com.appg.golfmon.atv.schedule;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.ArrayList;
import java.util.Iterator;

public class NaverCafe
{
  public static final String APP_NAVER_APPSTORE = "com.nhn.android.appstore";
  public static final String AUTHORITY_CAFE = "cafe";
  public static final String AUTHORITY_READ = "read";
  public static final String AUTHORITY_WRITE = "write";
  public static final String CAFE_INSTALL_URL = "market://details?id=com.nhn.android.navercafe";
  public static final String CAFE_INSTALL_URL_NAVER = "appstore://store?version=7&action=view&packageName=com.nhn.android.navercafe";
  public static final String QUERY_APPID = "appId";
  public static final String QUERY_ARTICLEID = "articleId";
  public static final String QUERY_ATTACHMENT = "attachment";
  public static final String QUERY_CAFEURL = "cafeUrl";
  public static final String QUERY_CONTENTS = "contents";
  public static final String QUERY_MENUID = "menuId";
  public static final String QUERY_SUBJECT = "subject";
  public static final String SCHEME_NAVERCAFE = "navercafe";
  private String appId;
  private Context context;
  
  public NaverCafe(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.appId = paramString;
  }
  
  public void cafe(String paramString)
  {
    Uri localUri = CafeUriBuilder.cafe(this.appId, paramString);
    Intent localIntent = new Intent();
    localIntent.setData(localUri);
    try
    {
      this.context.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      gotoMarket();
    }
  }
  
  public void gotoMarket()
  {
    if (!gotoNaverAppStore()) {
      gotoPlayStore();
    }
  }
  
  public boolean gotoNaverAppStore()
  {
    if (isAppInstalled("com.nhn.android.appstore"))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse("appstore://store?version=7&action=view&packageName=com.nhn.android.navercafe"));
      this.context.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public void gotoPlayStore()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("market://details?id=com.nhn.android.navercafe"));
    this.context.startActivity(localIntent);
  }
  
  public boolean isAppInstalled(String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = this.context.getPackageManager().getPackageInfo(paramString, 0);
      boolean bool = false;
      if (localPackageInfo != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public void read(String paramString1, String paramString2)
  {
    Uri localUri = CafeUriBuilder.read(this.appId, paramString1, paramString2);
    Intent localIntent = new Intent();
    localIntent.setData(localUri);
    try
    {
      this.context.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      gotoMarket();
    }
  }
  
  public void write(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Uri localUri = CafeUriBuilder.write(this.appId, paramString1, paramString2, paramString3, paramString4, null);
    Intent localIntent = new Intent();
    localIntent.setData(localUri);
    try
    {
      this.context.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      gotoMarket();
    }
  }
  
  public void write(String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList)
  {
    Uri localUri = CafeUriBuilder.write(this.appId, paramString1, paramString2, paramString3, paramString4, paramArrayList);
    Intent localIntent = new Intent();
    localIntent.setData(localUri);
    try
    {
      this.context.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      gotoMarket();
    }
  }
  
  public static class CafeUriBuilder
  {
    public static Uri cafe(String paramString1, String paramString2)
    {
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("navercafe");
      localBuilder.authority("cafe");
      localBuilder.appendQueryParameter("cafeUrl", paramString2);
      localBuilder.appendQueryParameter("appId", paramString1);
      return localBuilder.build();
    }
    
    public static Uri read(String paramString1, String paramString2, String paramString3)
    {
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("navercafe");
      localBuilder.authority("read");
      localBuilder.appendQueryParameter("cafeUrl", paramString2);
      localBuilder.appendQueryParameter("articleId", paramString3);
      localBuilder.appendQueryParameter("appId", paramString1);
      return localBuilder.build();
    }
    
    public static Uri write(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArrayList<String> paramArrayList)
    {
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("navercafe");
      localBuilder.authority("write");
      localBuilder.appendQueryParameter("cafeUrl", paramString2);
      localBuilder.appendQueryParameter("menuId", paramString3);
      localBuilder.appendQueryParameter("subject", paramString4);
      localBuilder.appendQueryParameter("contents", paramString5);
      StringBuilder localStringBuilder;
      Iterator localIterator;
      if (paramArrayList != null)
      {
        localStringBuilder = new StringBuilder();
        localIterator = paramArrayList.iterator();
        if (localIterator.hasNext()) {
          break label141;
        }
        if (localStringBuilder.length() <= 0) {
          break label168;
        }
      }
      label141:
      label168:
      for (String str = localStringBuilder.substring(0, -1 + localStringBuilder.length());; str = "")
      {
        localBuilder.appendQueryParameter("attachment", str);
        localBuilder.appendQueryParameter("appId", paramString1);
        return localBuilder.build();
        localStringBuilder.append((String)localIterator.next());
        localStringBuilder.append(';');
        break;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.NaverCafe
 * JD-Core Version:    0.7.0.1
 */