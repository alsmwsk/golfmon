package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class pw
  implements SafeParcelable
{
  public static final Parcelable.Creator<pw> CREATOR = new px();
  private final int CK;
  int[] avX;
  
  pw()
  {
    this(1, null);
  }
  
  pw(int paramInt, int[] paramArrayOfInt)
  {
    this.CK = paramInt;
    this.avX = paramArrayOfInt;
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
    px.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pw
 * JD-Core Version:    0.7.0.1
 */