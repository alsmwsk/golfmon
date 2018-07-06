package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class if
  implements SafeParcelable
{
  public static final ig CREATOR = new ig();
  final Bundle Ep;
  final byte[] Eq;
  final int responseCode;
  final int versionCode;
  
  public if(int paramInt1, int paramInt2, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.versionCode = paramInt1;
    this.responseCode = paramInt2;
    this.Ep = paramBundle;
    this.Eq = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ig.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.if
 * JD-Core Version:    0.7.0.1
 */