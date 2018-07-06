package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@ey
public final class ed
  extends em.a
{
  private Context mContext;
  private String mG;
  private String sM;
  private ArrayList<String> sN;
  
  public ed(String paramString1, ArrayList<String> paramArrayList, Context paramContext, String paramString2)
  {
    this.sM = paramString1;
    this.sN = paramArrayList;
    this.mG = paramString2;
    this.mContext = paramContext;
  }
  
  private void cz()
  {
    try
    {
      Class localClass = this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter");
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Context.class;
      arrayOfClass[1] = String.class;
      arrayOfClass[2] = String.class;
      arrayOfClass[3] = Boolean.TYPE;
      Method localMethod = localClass.getDeclaredMethod("reportWithProductId", arrayOfClass);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = this.mContext;
      arrayOfObject[1] = this.sM;
      arrayOfObject[2] = "";
      arrayOfObject[3] = Boolean.valueOf(true);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      gr.W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      gr.W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (Exception localException)
    {
      gr.d("Fail to report a conversion.", localException);
    }
  }
  
  protected String a(String paramString, HashMap<String, String> paramHashMap)
  {
    str1 = this.mContext.getPackageName();
    try
    {
      String str12 = this.mContext.getPackageManager().getPackageInfo(str1, 0).versionName;
      str2 = str12;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      String str2;
      long l;
      for (;;)
      {
        Iterator localIterator;
        gr.d("Error to retrieve app version", localNameNotFoundException);
        str2 = "";
      }
      String str3 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "sessionid" });
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = ga.vY;
      String str4 = paramString.replaceAll(str3, String.format("$1%s$2", arrayOfObject1)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "appid" }), String.format("$1%s$2", new Object[] { str1 }));
      String str5 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "osversion" });
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = String.valueOf(Build.VERSION.SDK_INT);
      String str6 = str4.replaceAll(str5, String.format("$1%s$2", arrayOfObject2));
      String str7 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "sdkversion" });
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this.mG;
      String str8 = str6.replaceAll(str7, String.format("$1%s$2", arrayOfObject3)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "appversion" }), String.format("$1%s$2", new Object[] { str2 }));
      String str9 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "timestamp" });
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = String.valueOf(l);
      return str8.replaceAll(str9, String.format("$1%s$2", arrayOfObject4)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "[^@]+" }), String.format("$1%s$2", new Object[] { "" })).replaceAll("@@", "@");
    }
    l = SystemClock.elapsedRealtime() - ga.dh().dq();
    localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str10 = (String)localIterator.next();
      String str11 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { str10 });
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = paramHashMap.get(str10);
      paramString = paramString.replaceAll(str11, String.format("$1%s$2", arrayOfObject5));
    }
  }
  
  public String getProductId()
  {
    return this.sM;
  }
  
  protected int p(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 4) {
      return 3;
    }
    return 0;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    if (paramInt == 0) {
      cz();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("google_play_status", String.valueOf(paramInt));
    localHashMap.put("sku", this.sM);
    localHashMap.put("status", String.valueOf(p(paramInt)));
    Iterator localIterator = this.sN.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new gp(this.mContext, this.mG, a(str, localHashMap)).start();
    }
  }
  
  public void recordResolution(int paramInt)
  {
    if (paramInt == 1) {
      cz();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", String.valueOf(paramInt));
    localHashMap.put("sku", this.sM);
    Iterator localIterator = this.sN.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new gp(this.mContext, this.mG, a(str, localHashMap)).start();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ed
 * JD-Core Version:    0.7.0.1
 */