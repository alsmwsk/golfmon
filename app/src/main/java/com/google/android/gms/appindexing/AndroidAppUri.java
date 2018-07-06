package com.google.android.gms.appindexing;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.internal.jv;
import java.util.Iterator;
import java.util.List;

public final class AndroidAppUri
{
  private final Uri mUri;
  
  private AndroidAppUri(Uri paramUri)
  {
    this.mUri = paramUri;
  }
  
  private static boolean a(AndroidAppUri paramAndroidAppUri)
  {
    if (!"android-app".equals(paramAndroidAppUri.mUri.getScheme())) {
      throw new IllegalArgumentException("android-app scheme is required.");
    }
    if (TextUtils.isEmpty(paramAndroidAppUri.getPackageName())) {
      throw new IllegalArgumentException("Package name is empty.");
    }
    Uri localUri = newAndroidAppUri(paramAndroidAppUri.getPackageName(), paramAndroidAppUri.getDeepLinkUri()).toUri();
    if (!paramAndroidAppUri.mUri.equals(localUri)) {
      throw new IllegalArgumentException("URI is not canonical.");
    }
    return true;
  }
  
  public static AndroidAppUri newAndroidAppUri(Uri paramUri)
  {
    AndroidAppUri localAndroidAppUri = new AndroidAppUri(paramUri);
    if (a(localAndroidAppUri)) {
      return localAndroidAppUri;
    }
    throw new IllegalArgumentException("AndroidAppUri validation failed.");
  }
  
  public static AndroidAppUri newAndroidAppUri(String paramString, Uri paramUri)
  {
    Uri.Builder localBuilder = new Uri.Builder().scheme("android-app").authority(paramString);
    if (paramUri != null)
    {
      localBuilder.appendPath(paramUri.getScheme());
      if (paramUri.getAuthority() != null) {
        localBuilder.appendPath(paramUri.getAuthority());
      }
      Iterator localIterator = paramUri.getPathSegments().iterator();
      while (localIterator.hasNext()) {
        localBuilder.appendPath((String)localIterator.next());
      }
      localBuilder.encodedQuery(paramUri.getEncodedQuery()).encodedFragment(paramUri.getEncodedFragment());
    }
    return new AndroidAppUri(localBuilder.build());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof AndroidAppUri)) {
      return this.mUri.equals(((AndroidAppUri)paramObject).mUri);
    }
    return false;
  }
  
  public Uri getDeepLinkUri()
  {
    List localList = this.mUri.getPathSegments();
    if (localList.size() > 0)
    {
      String str = (String)localList.get(0);
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme(str);
      if (localList.size() > 1)
      {
        localBuilder.authority((String)localList.get(1));
        for (int i = 2; i < localList.size(); i++) {
          localBuilder.appendPath((String)localList.get(i));
        }
      }
      localBuilder.encodedQuery(this.mUri.getEncodedQuery());
      localBuilder.encodedFragment(this.mUri.getEncodedFragment());
      return localBuilder.build();
    }
    return null;
  }
  
  public String getPackageName()
  {
    return this.mUri.getAuthority();
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mUri;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return this.mUri.toString();
  }
  
  public Uri toUri()
  {
    return this.mUri;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appindexing.AndroidAppUri
 * JD-Core Version:    0.7.0.1
 */