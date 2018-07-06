package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import java.util.ArrayList;

public final class d
  implements SafeParcelable
{
  public static final Parcelable.Creator<d> CREATOR = new e();
  private final int CK;
  String awJ;
  String awK;
  ArrayList<b> awL;
  
  d()
  {
    this.CK = 1;
    this.awL = la.ie();
  }
  
  d(int paramInt, String paramString1, String paramString2, ArrayList<b> paramArrayList)
  {
    this.CK = paramInt;
    this.awJ = paramString1;
    this.awK = paramString2;
    this.awL = paramArrayList;
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
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.d
 * JD-Core Version:    0.7.0.1
 */