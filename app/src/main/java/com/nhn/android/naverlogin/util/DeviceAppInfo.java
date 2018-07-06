package com.nhn.android.naverlogin.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class DeviceAppInfo
{
  private static final String TAG = "NaverLoginOAuth|DeviceAppInfo";
  private static final DeviceAppInfo mInstance = new DeviceAppInfo();
  
  public static String getApplicationName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      String str = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getApplicationInfo().packageName, 0));
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "NAVER";
  }
  
  public static DeviceAppInfo getBaseInstance()
  {
    return mInstance;
  }
  
  public static String getPrimaryNaverOAuth2ndAppPackageName(Context paramContext)
  {
    int i = 0;
    try
    {
      String[] arrayOfString = { "com.nhn.android.appstore" };
      List localList = paramContext.getPackageManager().queryIntentActivities(new Intent("com.naver.android.action.OAUTH2_LOGIN"), 128);
      int j = arrayOfString.length;
      if (i >= j)
      {
        if (OAuthLoginDefine.DEVELOPER_VERSION) {
          Log.d("NaverLoginOAuth|DeviceAppInfo", "no app assinged in order-list. package name:" + ((ResolveInfo)localList.get(0)).activityInfo.packageName + ", " + ((ResolveInfo)localList.get(0)).activityInfo.name);
        }
      }
      else
      {
        String str1 = arrayOfString[i];
        Iterator localIterator = localList.iterator();
        ResolveInfo localResolveInfo;
        do
        {
          if (!localIterator.hasNext())
          {
            i++;
            break;
          }
          localResolveInfo = (ResolveInfo)localIterator.next();
          if (OAuthLoginDefine.DEVELOPER_VERSION) {
            Log.d("NaverLoginOAuth|DeviceAppInfo", "package name:" + localResolveInfo.activityInfo.packageName + ", " + localResolveInfo.activityInfo.name);
          }
        } while (!localResolveInfo.activityInfo.packageName.equals(str1));
        String str2 = localResolveInfo.activityInfo.packageName;
        return str2;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean isAppExist(Context paramContext, String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (paramContext.getPackageManager().getLaunchIntentForPackage(paramString) == null)
      {
        Log.i("NaverLoginOAuth|DeviceAppInfo", paramString + " is not installed.");
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    return true;
  }
  
  public static boolean isIntentFilterExist(Context paramContext, String paramString)
  {
    Iterator localIterator = paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 128).iterator();
    if (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if (OAuthLoginDefine.DEVELOPER_VERSION)
      {
        Log.d("NaverLoginOAuth|DeviceAppInfo", "intent filter name:" + paramString);
        Log.d("NaverLoginOAuth|DeviceAppInfo", "package name:" + localResolveInfo.activityInfo.packageName + ", " + localResolveInfo.activityInfo.name);
      }
      return true;
    }
    return false;
  }
  
  public String getLocaleString(Context paramContext)
  {
    String str = "ko_KR";
    try
    {
      str = paramContext.getResources().getConfiguration().locale.toString();
      boolean bool = TextUtils.isEmpty(str);
      if (bool) {
        return "ko_KR";
      }
    }
    catch (Exception localException) {}
    return str;
  }
  
  public String getUserAgent(Context paramContext)
  {
    String str1 = "Android/" + Build.VERSION.RELEASE;
    String str2 = "Model/" + Build.MODEL;
    String str3 = str1.replaceAll("\\s", "") + " " + str2.replaceAll("\\s", "");
    String str4 = "";
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      str4 = paramContext.getPackageName();
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(str4, 448);
      String str5 = "";
      if (localPackageInfo.applicationInfo.loadDescription(localPackageManager) != null) {
        str5 = ",appId:" + localPackageInfo.applicationInfo.loadDescription(localPackageManager);
      }
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = str4;
      arrayOfObject[1] = localPackageInfo.versionName;
      arrayOfObject[2] = Integer.valueOf(localPackageInfo.versionCode);
      arrayOfObject[3] = Integer.valueOf(localPackageInfo.applicationInfo.uid);
      arrayOfObject[4] = str5;
      String str6 = String.format("%s/%s(%d,uid:%d%s)", arrayOfObject);
      String str7 = "OAuthLoginMod/" + OAuthLogin.getVersion();
      String str8 = str3 + " " + str6.replaceAll("\\s", "") + " " + str7.replaceAll("\\s", "");
      return str8;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("NaverLoginOAuth|DeviceAppInfo", "not installed app : " + str4);
      return str3;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str3;
  }
  
  public boolean isKorean(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.getLanguage().startsWith("ko");
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.util.DeviceAppInfo
 * JD-Core Version:    0.7.0.1
 */