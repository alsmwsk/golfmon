package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jj
  implements SafeParcelable
{
  public static final Parcelable.Creator<jj> CREATOR = new jk();
  final int MD;
  int ME;
  String MF;
  IBinder MG;
  Scope[] MH;
  Bundle MI;
  final int version;
  
  public jj(int paramInt)
  {
    this.version = 1;
    this.ME = 6587000;
    this.MD = paramInt;
  }
  
  jj(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle)
  {
    this.version = paramInt1;
    this.MD = paramInt2;
    this.ME = paramInt3;
    this.MF = paramString;
    this.MG = paramIBinder;
    this.MH = paramArrayOfScope;
    this.MI = paramBundle;
  }
  
  public jj a(jq paramjq)
  {
    if (paramjq != null) {
      this.MG = paramjq.asBinder();
    }
    return this;
  }
  
  public jj a(Scope[] paramArrayOfScope)
  {
    this.MH = paramArrayOfScope;
    return this;
  }
  
  public jj aX(String paramString)
  {
    this.MF = paramString;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public jj e(Bundle paramBundle)
  {
    this.MI = paramBundle;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jk.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jj
 * JD-Core Version:    0.7.0.1
 */