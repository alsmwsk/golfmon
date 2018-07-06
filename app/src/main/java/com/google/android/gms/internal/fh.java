package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@ey
public final class fh
  implements SafeParcelable
{
  public static final fi CREATOR = new fi();
  public final ApplicationInfo applicationInfo;
  public final String lL;
  public final gs lO;
  public final ay lS;
  public final List<String> mc;
  public final Bundle tK;
  public final av tL;
  public final PackageInfo tM;
  public final String tN;
  public final String tO;
  public final String tP;
  public final Bundle tQ;
  public final int tR;
  public final Bundle tS;
  public final boolean tT;
  public final int versionCode;
  
  fh(int paramInt1, Bundle paramBundle1, av paramav, ay paramay, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, gs paramgs, Bundle paramBundle2, int paramInt2, List<String> paramList, Bundle paramBundle3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.tK = paramBundle1;
    this.tL = paramav;
    this.lS = paramay;
    this.lL = paramString1;
    this.applicationInfo = paramApplicationInfo;
    this.tM = paramPackageInfo;
    this.tN = paramString2;
    this.tO = paramString3;
    this.tP = paramString4;
    this.lO = paramgs;
    this.tQ = paramBundle2;
    this.tR = paramInt2;
    this.mc = paramList;
    this.tS = paramBundle3;
    this.tT = paramBoolean;
  }
  
  public fh(Bundle paramBundle1, av paramav, ay paramay, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, gs paramgs, Bundle paramBundle2, int paramInt, List<String> paramList, Bundle paramBundle3, boolean paramBoolean)
  {
    this(4, paramBundle1, paramav, paramay, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramgs, paramBundle2, paramInt, paramList, paramBundle3, paramBoolean);
  }
  
  public fh(a parama, String paramString)
  {
    this(parama.tK, parama.tL, parama.lS, parama.lL, parama.applicationInfo, parama.tM, paramString, parama.tO, parama.tP, parama.lO, parama.tQ, parama.tR, parama.mc, parama.tS, parama.tT);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fi.a(this, paramParcel, paramInt);
  }
  
  @ey
  public static final class a
  {
    public final ApplicationInfo applicationInfo;
    public final String lL;
    public final gs lO;
    public final ay lS;
    public final List<String> mc;
    public final Bundle tK;
    public final av tL;
    public final PackageInfo tM;
    public final String tO;
    public final String tP;
    public final Bundle tQ;
    public final int tR;
    public final Bundle tS;
    public final boolean tT;
    
    public a(Bundle paramBundle1, av paramav, ay paramay, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, gs paramgs, Bundle paramBundle2, List<String> paramList, Bundle paramBundle3, boolean paramBoolean)
    {
      this.tK = paramBundle1;
      this.tL = paramav;
      this.lS = paramay;
      this.lL = paramString1;
      this.applicationInfo = paramApplicationInfo;
      this.tM = paramPackageInfo;
      this.tO = paramString2;
      this.tP = paramString3;
      this.lO = paramgs;
      this.tQ = paramBundle2;
      this.tT = paramBoolean;
      if ((paramList != null) && (paramList.size() > 0)) {
        this.tR = 2;
      }
      for (this.mc = paramList;; this.mc = null)
      {
        this.tS = paramBundle3;
        return;
        this.tR = 0;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fh
 * JD-Core Version:    0.7.0.1
 */