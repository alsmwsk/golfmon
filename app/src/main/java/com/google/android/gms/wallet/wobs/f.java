package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class f
  implements SafeParcelable
{
  public static final Parcelable.Creator<f> CREATOR = new i();
  private final int CK;
  l avm;
  g awM;
  String label;
  String type;
  
  f()
  {
    this.CK = 1;
  }
  
  f(int paramInt, String paramString1, g paramg, String paramString2, l paraml)
  {
    this.CK = paramInt;
    this.label = paramString1;
    this.awM = paramg;
    this.type = paramString2;
    this.avm = paraml;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.f
 * JD-Core Version:    0.7.0.1
 */