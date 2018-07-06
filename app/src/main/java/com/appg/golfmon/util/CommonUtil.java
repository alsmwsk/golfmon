package com.appg.golfmon.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.Iterator;
import java.util.List;

public class CommonUtil
{
  public static ActivityManager.RunningTaskInfo getAtv(Context paramContext, ComponentName paramComponentName)
  {
    return getAtv("APPG_LOG", paramContext, paramComponentName);
  }
  
  public static ActivityManager.RunningTaskInfo getAtv(String paramString, Context paramContext, ComponentName paramComponentName)
  {
    LogUtil.e("pkageName----->" + paramComponentName.getPackageName());
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    List localList = localActivityManager.getRunningTasks(100);
    Iterator localIterator = localList.iterator();
    boolean bool = localIterator.hasNext();
    Object localObject = null;
    if (!bool) {}
    for (;;)
    {
      if (localList != null) {
        localList.clear();
      }
      if (localActivityManager != null) {}
      return localObject;
      ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)localIterator.next();
      String str1 = localRunningTaskInfo.baseActivity.getClassName().toString();
      String str2 = localRunningTaskInfo.topActivity.getClassName().toString();
      LogUtil.e("topActivity----->" + str2);
      LogUtil.e("baseActivity----->" + str1);
      if (!str1.contains(paramComponentName.getPackageName())) {
        break;
      }
      localObject = localRunningTaskInfo;
    }
  }
  
  public static TextWatcher getAutoNextMoveTextWatcher(int paramInt, final View paramView)
  {
    new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (this.val$limit == paramAnonymousEditable.length()) {
          paramView.requestFocus();
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
  }
  
  public static String getCurrentVersion(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public static String getDeviceKey(Context paramContext)
  {
    return getDeviceKey(paramContext, (TelephonyManager)paramContext.getSystemService("phone"));
  }
  
  public static String getDeviceKey(Context paramContext, TelephonyManager paramTelephonyManager)
  {
    String str = paramTelephonyManager.getDeviceId();
    if (str == null) {
      str = "";
    }
    return str;
  }
  
  public static String getPhoneNumber(Context paramContext)
  {
    return getPhoneNumber(paramContext, (TelephonyManager)paramContext.getSystemService("phone"));
  }
  
  public static String getPhoneNumber(Context paramContext, TelephonyManager paramTelephonyManager)
  {
    String str = paramTelephonyManager.getLine1Number();
    if (!FormatUtil.isNullorEmpty(str)) {
      return str.replace("+82", "0").replaceAll("-", "");
    }
    return "";
  }
  
  public static String getTelecomCode(Context paramContext)
  {
    return getTelecomCode(paramContext, (TelephonyManager)paramContext.getSystemService("phone"));
  }
  
  public static String getTelecomCode(Context paramContext, TelephonyManager paramTelephonyManager)
  {
    String str = paramTelephonyManager.getSimOperatorName();
    if (!FormatUtil.isNullorEmpty(str)) {
      return str.replaceAll(" ", "");
    }
    return "";
  }
  
  public static void hideKeyPad(View paramView, boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
    if (paramBoolean)
    {
      localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      return;
    }
    localInputMethodManager.showSoftInput(paramView, 0);
  }
  
  public static boolean isPackageInstalled(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.CommonUtil
 * JD-Core Version:    0.7.0.1
 */