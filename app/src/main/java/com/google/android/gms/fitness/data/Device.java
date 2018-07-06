package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

public final class Device
  implements SafeParcelable
{
  public static final Parcelable.Creator<Device> CREATOR = new i();
  public static final int TYPE_CHEST_STRAP = 4;
  public static final int TYPE_PHONE = 1;
  public static final int TYPE_SCALE = 5;
  public static final int TYPE_TABLET = 2;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_WATCH = 3;
  private final int CK;
  private final int Gt;
  private final String TU;
  private final String Uw;
  private final String Ux;
  private final String Uy;
  private final int Uz;
  
  Device(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    this.CK = paramInt1;
    this.Uw = ((String)jx.i(paramString1));
    this.Ux = ((String)jx.i(paramString2));
    this.TU = "";
    this.Uy = ((String)jx.i(paramString4));
    this.Gt = paramInt2;
    this.Uz = paramInt3;
  }
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, "", paramString3, paramInt, 0);
  }
  
  public Device(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this(paramString1, paramString2, paramString4, paramInt);
  }
  
  public Device(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this(1, paramString1, paramString2, "", paramString4, paramInt1, paramInt2);
  }
  
  private static String M(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  private static int N(Context paramContext)
  {
    int i = P(paramContext);
    int j = 0;
    switch (i)
    {
    default: 
      if (R(paramContext)) {
        j = 1;
      }
      break;
    case 8: 
    case 9: 
    case 10: 
      boolean bool;
      do
      {
        return j;
        bool = O(paramContext);
        j = 0;
      } while (!bool);
      return 3;
    }
    return 2;
  }
  
  public static boolean O(Context paramContext)
  {
    return (0xF & paramContext.getResources().getConfiguration().uiMode) == 6;
  }
  
  private static int P(Context paramContext)
  {
    return 5 + Q(paramContext) % 1000 / 100;
  }
  
  private static int Q(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.w("Fitness", "Could not find package info for Google Play Services");
    }
    return -1;
  }
  
  private static boolean R(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType() != 0;
  }
  
  private boolean a(Device paramDevice)
  {
    return (jv.equal(this.Uw, paramDevice.Uw)) && (jv.equal(this.Ux, paramDevice.Ux)) && (jv.equal(this.TU, paramDevice.TU)) && (jv.equal(this.Uy, paramDevice.Uy)) && (this.Gt == paramDevice.Gt) && (this.Uz == paramDevice.Uz);
  }
  
  public static Device getLocalDevice(Context paramContext)
  {
    int i = N(paramContext);
    String str = M(paramContext);
    return new Device(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, str, i, 2);
  }
  
  private boolean jD()
  {
    return jC() == 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Device)) && (a((Device)paramObject)));
  }
  
  public String getManufacturer()
  {
    return this.Uw;
  }
  
  public String getModel()
  {
    return this.Ux;
  }
  
  String getStreamIdentifier()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.Uw;
    arrayOfObject[1] = this.Ux;
    arrayOfObject[2] = this.Uy;
    return String.format("%s:%s:%s", arrayOfObject);
  }
  
  public int getType()
  {
    return this.Gt;
  }
  
  public String getUid()
  {
    return this.Uy;
  }
  
  public String getVersion()
  {
    return this.TU;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.Uw;
    arrayOfObject[1] = this.Ux;
    arrayOfObject[2] = this.TU;
    arrayOfObject[3] = this.Uy;
    arrayOfObject[4] = Integer.valueOf(this.Gt);
    return jv.hashCode(arrayOfObject);
  }
  
  public int jC()
  {
    return this.Uz;
  }
  
  Device jE()
  {
    return new Device(mg.bw(this.Uw), mg.bw(this.Ux), mg.bw(this.TU), this.Uy, this.Gt);
  }
  
  public String jF()
  {
    if ((mg.jN()) || (jD())) {
      return this.Uy;
    }
    return mg.bw(this.Uy);
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = getStreamIdentifier();
    arrayOfObject[1] = this.TU;
    arrayOfObject[2] = Integer.valueOf(this.Gt);
    arrayOfObject[3] = Integer.valueOf(this.Uz);
    return String.format("Device{%s:%s:%s:%s}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.Device
 * JD-Core Version:    0.7.0.1
 */