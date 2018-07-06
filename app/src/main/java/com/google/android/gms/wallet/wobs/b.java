package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class b
  implements SafeParcelable
{
  public static final Parcelable.Creator<b> CREATOR = new c();
  private final int CK;
  String label;
  String value;
  
  b()
  {
    this.CK = 1;
  }
  
  b(int paramInt, String paramString1, String paramString2)
  {
    this.CK = paramInt;
    this.label = paramString1;
    this.value = paramString2;
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
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.b
 * JD-Core Version:    0.7.0.1
 */