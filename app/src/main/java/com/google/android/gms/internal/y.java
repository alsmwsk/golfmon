package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
public final class y
  implements SafeParcelable
{
  public static final z CREATOR = new z();
  public final boolean mi;
  public final boolean ms;
  public final int versionCode;
  
  y(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = paramInt;
    this.mi = paramBoolean1;
    this.ms = paramBoolean2;
  }
  
  public y(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = 1;
    this.mi = paramBoolean1;
    this.ms = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    z.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.y
 * JD-Core Version:    0.7.0.1
 */