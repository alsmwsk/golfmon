package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.dynamic.e;

@ey
public final class ea
  implements SafeParcelable
{
  public static final dz CREATOR = new dz();
  public final ek md;
  public final Context sA;
  public final ej sB;
  public final em sz;
  public final int versionCode;
  
  ea(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4)
  {
    this.versionCode = paramInt;
    this.md = ((ek)e.f(d.a.ap(paramIBinder1)));
    this.sz = ((em)e.f(d.a.ap(paramIBinder2)));
    this.sA = ((Context)e.f(d.a.ap(paramIBinder3)));
    this.sB = ((ej)e.f(d.a.ap(paramIBinder4)));
  }
  
  public ea(Context paramContext, ek paramek, em paramem, ej paramej)
  {
    this.versionCode = 2;
    this.sA = paramContext;
    this.md = paramek;
    this.sz = paramem;
    this.sB = paramej;
  }
  
  public static void a(Intent paramIntent, ea paramea)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramea);
    paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
  }
  
  public static ea c(Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      localBundle.setClassLoader(ea.class.getClassLoader());
      ea localea = (ea)localBundle.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      return localea;
    }
    catch (Exception localException) {}
    return null;
  }
  
  IBinder ct()
  {
    return e.k(this.sB).asBinder();
  }
  
  IBinder cu()
  {
    return e.k(this.md).asBinder();
  }
  
  IBinder cv()
  {
    return e.k(this.sz).asBinder();
  }
  
  IBinder cw()
  {
    return e.k(this.sA).asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dz.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ea
 * JD-Core Version:    0.7.0.1
 */