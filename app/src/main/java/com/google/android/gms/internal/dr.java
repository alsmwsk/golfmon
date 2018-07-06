package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.dynamic.e;

@ey
public final class dr
  implements SafeParcelable
{
  public static final dq CREATOR = new dq();
  public final gs lO;
  public final int orientation;
  public final String rH;
  public final do sb;
  public final t sc;
  public final ds sd;
  public final gu se;
  public final cb sf;
  public final String sg;
  public final boolean sh;
  public final String si;
  public final dv sj;
  public final int sk;
  public final ce sl;
  public final String sm;
  public final y sn;
  public final int versionCode;
  
  dr(int paramInt1, do paramdo, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, gs paramgs, IBinder paramIBinder6, String paramString4, y paramy)
  {
    this.versionCode = paramInt1;
    this.sb = paramdo;
    this.sc = ((t)e.f(d.a.ap(paramIBinder1)));
    this.sd = ((ds)e.f(d.a.ap(paramIBinder2)));
    this.se = ((gu)e.f(d.a.ap(paramIBinder3)));
    this.sf = ((cb)e.f(d.a.ap(paramIBinder4)));
    this.sg = paramString1;
    this.sh = paramBoolean;
    this.si = paramString2;
    this.sj = ((dv)e.f(d.a.ap(paramIBinder5)));
    this.orientation = paramInt2;
    this.sk = paramInt3;
    this.rH = paramString3;
    this.lO = paramgs;
    this.sl = ((ce)e.f(d.a.ap(paramIBinder6)));
    this.sm = paramString4;
    this.sn = paramy;
  }
  
  public dr(do paramdo, t paramt, ds paramds, dv paramdv, gs paramgs)
  {
    this.versionCode = 4;
    this.sb = paramdo;
    this.sc = paramt;
    this.sd = paramds;
    this.se = null;
    this.sf = null;
    this.sg = null;
    this.sh = false;
    this.si = null;
    this.sj = paramdv;
    this.orientation = -1;
    this.sk = 4;
    this.rH = null;
    this.lO = paramgs;
    this.sl = null;
    this.sm = null;
    this.sn = null;
  }
  
  public dr(t paramt, ds paramds, cb paramcb, dv paramdv, gu paramgu, boolean paramBoolean, int paramInt, String paramString, gs paramgs, ce paramce)
  {
    this.versionCode = 4;
    this.sb = null;
    this.sc = paramt;
    this.sd = paramds;
    this.se = paramgu;
    this.sf = paramcb;
    this.sg = null;
    this.sh = paramBoolean;
    this.si = null;
    this.sj = paramdv;
    this.orientation = paramInt;
    this.sk = 3;
    this.rH = paramString;
    this.lO = paramgs;
    this.sl = paramce;
    this.sm = null;
    this.sn = null;
  }
  
  public dr(t paramt, ds paramds, cb paramcb, dv paramdv, gu paramgu, boolean paramBoolean, int paramInt, String paramString1, String paramString2, gs paramgs, ce paramce)
  {
    this.versionCode = 4;
    this.sb = null;
    this.sc = paramt;
    this.sd = paramds;
    this.se = paramgu;
    this.sf = paramcb;
    this.sg = paramString2;
    this.sh = paramBoolean;
    this.si = paramString1;
    this.sj = paramdv;
    this.orientation = paramInt;
    this.sk = 3;
    this.rH = null;
    this.lO = paramgs;
    this.sl = paramce;
    this.sm = null;
    this.sn = null;
  }
  
  public dr(t paramt, ds paramds, dv paramdv, gu paramgu, int paramInt, gs paramgs, String paramString, y paramy)
  {
    this.versionCode = 4;
    this.sb = null;
    this.sc = paramt;
    this.sd = paramds;
    this.se = paramgu;
    this.sf = null;
    this.sg = null;
    this.sh = false;
    this.si = null;
    this.sj = paramdv;
    this.orientation = paramInt;
    this.sk = 1;
    this.rH = null;
    this.lO = paramgs;
    this.sl = null;
    this.sm = paramString;
    this.sn = paramy;
  }
  
  public dr(t paramt, ds paramds, dv paramdv, gu paramgu, boolean paramBoolean, int paramInt, gs paramgs)
  {
    this.versionCode = 4;
    this.sb = null;
    this.sc = paramt;
    this.sd = paramds;
    this.se = paramgu;
    this.sf = null;
    this.sg = null;
    this.sh = paramBoolean;
    this.si = null;
    this.sj = paramdv;
    this.orientation = paramInt;
    this.sk = 2;
    this.rH = null;
    this.lO = paramgs;
    this.sl = null;
    this.sm = null;
    this.sn = null;
  }
  
  public static void a(Intent paramIntent, dr paramdr)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramdr);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  public static dr b(Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      localBundle.setClassLoader(dr.class.getClassLoader());
      dr localdr = (dr)localBundle.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return localdr;
    }
    catch (Exception localException) {}
    return null;
  }
  
  IBinder ck()
  {
    return e.k(this.sc).asBinder();
  }
  
  IBinder cl()
  {
    return e.k(this.sd).asBinder();
  }
  
  IBinder cm()
  {
    return e.k(this.se).asBinder();
  }
  
  IBinder cn()
  {
    return e.k(this.sf).asBinder();
  }
  
  IBinder co()
  {
    return e.k(this.sl).asBinder();
  }
  
  IBinder cp()
  {
    return e.k(this.sj).asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dq.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dr
 * JD-Core Version:    0.7.0.1
 */