package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class p
  implements SafeParcelable
{
  public static final Parcelable.Creator<p> CREATOR = new q();
  private final int CK;
  String awT;
  l awX;
  n awY;
  n awZ;
  String tU;
  
  p()
  {
    this.CK = 1;
  }
  
  p(int paramInt, String paramString1, String paramString2, l paraml, n paramn1, n paramn2)
  {
    this.CK = paramInt;
    this.awT = paramString1;
    this.tU = paramString2;
    this.awX = paraml;
    this.awY = paramn1;
    this.awZ = paramn2;
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
    q.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.p
 * JD-Core Version:    0.7.0.1
 */