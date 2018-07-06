package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

public class hr
  implements SafeParcelable
{
  public static final hs CREATOR = new hs();
  final int CK;
  final hf Dw;
  final long Dx;
  final int Dy;
  final hd Dz;
  public final String pc;
  
  hr(int paramInt1, hf paramhf, long paramLong, int paramInt2, String paramString, hd paramhd)
  {
    this.CK = paramInt1;
    this.Dw = paramhf;
    this.Dx = paramLong;
    this.Dy = paramInt2;
    this.pc = paramString;
    this.Dz = paramhd;
  }
  
  public hr(hf paramhf, long paramLong, int paramInt)
  {
    this(1, paramhf, paramLong, paramInt, null, null);
  }
  
  public hr(hf paramhf, long paramLong, int paramInt, String paramString, hd paramhd)
  {
    this(1, paramhf, paramLong, paramInt, paramString, paramhd);
  }
  
  public hr(String paramString1, Intent paramIntent, String paramString2, Uri paramUri, String paramString3, List<AppIndexApi.AppIndexingLink> paramList)
  {
    this(1, a(paramString1, paramIntent), System.currentTimeMillis(), 0, null, a(paramIntent, paramString2, paramUri, paramString3, paramList).fD());
  }
  
  public static hd.a a(Intent paramIntent, String paramString1, Uri paramUri, String paramString2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    hd.a locala = new hd.a();
    locala.a(av(paramString1));
    if (paramUri != null) {
      locala.a(f(paramUri));
    }
    if (paramList != null) {
      locala.a(b(paramList));
    }
    String str1 = paramIntent.getAction();
    if (str1 != null) {
      locala.a(i("intent_action", str1));
    }
    String str2 = paramIntent.getDataString();
    if (str2 != null) {
      locala.a(i("intent_data", str2));
    }
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      locala.a(i("intent_activity", localComponentName.getClassName()));
    }
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle != null)
    {
      String str3 = localBundle.getString("intent_extra_data_key");
      if (str3 != null) {
        locala.a(i("intent_extra_data", str3));
      }
    }
    return locala.ar(paramString2).F(true);
  }
  
  public static hf a(String paramString, Intent paramIntent)
  {
    return h(paramString, g(paramIntent));
  }
  
  private static hh av(String paramString)
  {
    return new hh(paramString, new hp.a("title").Q(1).H(true).au("name").fG(), "text1");
  }
  
  private static hh b(List<AppIndexApi.AppIndexingLink> paramList)
  {
    mv.a locala = new mv.a();
    mv.a.a[] arrayOfa = new mv.a.a[paramList.size()];
    for (int i = 0; i < arrayOfa.length; i++)
    {
      arrayOfa[i] = new mv.a.a();
      AppIndexApi.AppIndexingLink localAppIndexingLink = (AppIndexApi.AppIndexingLink)paramList.get(i);
      arrayOfa[i].afw = localAppIndexingLink.appIndexingUrl.toString();
      arrayOfa[i].viewId = localAppIndexingLink.viewId;
      if (localAppIndexingLink.webUrl != null) {
        arrayOfa[i].afx = localAppIndexingLink.webUrl.toString();
      }
    }
    locala.afu = arrayOfa;
    return new hh(qw.f(locala), new hp.a("outlinks").G(true).au(".private:outLinks").at("blob").fG());
  }
  
  private static hh f(Uri paramUri)
  {
    return new hh(paramUri.toString(), new hp.a("web_url").Q(4).G(true).au("url").fG());
  }
  
  private static String g(Intent paramIntent)
  {
    String str = paramIntent.toUri(1);
    CRC32 localCRC32 = new CRC32();
    try
    {
      localCRC32.update(str.getBytes("UTF-8"));
      return Long.toHexString(localCRC32.getValue());
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException(localUnsupportedEncodingException);
    }
  }
  
  private static hf h(String paramString1, String paramString2)
  {
    return new hf(paramString1, "", paramString2);
  }
  
  private static hh i(String paramString1, String paramString2)
  {
    return new hh(paramString2, new hp.a(paramString1).G(true).fG(), paramString1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.Dw;
    arrayOfObject[1] = Long.valueOf(this.Dx);
    arrayOfObject[2] = Integer.valueOf(this.Dy);
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hs.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hr
 * JD-Core Version:    0.7.0.1
 */