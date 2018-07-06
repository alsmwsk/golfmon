package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class g
  implements SafeParcelable
{
  public static final Parcelable.Creator<g> CREATOR = new h();
  private final int CK;
  int awN;
  String awO;
  double awP;
  String awQ;
  long awR;
  int awS;
  
  g()
  {
    this.CK = 1;
    this.awS = -1;
    this.awN = -1;
    this.awP = -1.0D;
  }
  
  g(int paramInt1, int paramInt2, String paramString1, double paramDouble, String paramString2, long paramLong, int paramInt3)
  {
    this.CK = paramInt1;
    this.awN = paramInt2;
    this.awO = paramString1;
    this.awP = paramDouble;
    this.awQ = paramString2;
    this.awR = paramLong;
    this.awS = paramInt3;
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
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.g
 * JD-Core Version:    0.7.0.1
 */