package com.kakao.helper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.kakao.exception.KakaoException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Set;

public final class Utility
{
  private static final String TAG = Utility.class.getCanonicalName();
  
  public static Uri buildUri(String paramString1, String paramString2)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.authority(paramString1);
    localBuilder.path(paramString2);
    return localBuilder.build();
  }
  
  public static Uri buildUri(String paramString1, String paramString2, Bundle paramBundle)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.authority(paramString1);
    localBuilder.path(paramString2);
    Iterator localIterator = paramBundle.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localBuilder.build();
      }
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if ((localObject instanceof String)) {
        localBuilder.appendQueryParameter(str, (String)localObject);
      }
    }
  }
  
  public static String getAppPackageName(Context paramContext)
  {
    return getPackageInfo(paramContext).packageName;
  }
  
  public static int getAppVersion(Context paramContext)
  {
    return getPackageInfo(paramContext).versionCode;
  }
  
  public static String getKeyHash(Context paramContext)
  {
    PackageInfo localPackageInfo = getPackageInfo(paramContext, 64);
    if (localPackageInfo == null) {}
    for (;;)
    {
      return null;
      Signature[] arrayOfSignature = localPackageInfo.signatures;
      int i = arrayOfSignature.length;
      int j = 0;
      while (j < i)
      {
        Signature localSignature = arrayOfSignature[j];
        try
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
          localMessageDigest.update(localSignature.toByteArray());
          String str = Base64.encodeToString(localMessageDigest.digest(), 2);
          return str;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          Log.w(TAG, "Unable to get MessageDigest. signature=" + localSignature, localNoSuchAlgorithmException);
          j++;
        }
      }
    }
  }
  
  public static String getMetadata(Context paramContext, String paramString)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo == null) {
        return null;
      }
      if (localApplicationInfo.metaData != null)
      {
        String str = localApplicationInfo.metaData.getString(paramString);
        return str;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext)
  {
    return getPackageInfo(paramContext, 0);
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, int paramInt)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), paramInt);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.w(TAG, "Unable to get PackageInfo", localNameNotFoundException);
    }
    return null;
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static void notNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException("Argument '" + paramString + "' cannot be null");
    }
  }
  
  public static void putObjectInBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Parcelable))
    {
      paramBundle.putParcelable(paramString, (Parcelable)paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramBundle.putByteArray(paramString, (byte[])paramObject);
      return;
    }
    throw new KakaoException("attempted to add unsupported type to Bundle");
  }
  
  public static ResolveInfo resolveIntent(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().resolveActivity(paramIntent, 0);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.helper.Utility
 * JD-Core Version:    0.7.0.1
 */