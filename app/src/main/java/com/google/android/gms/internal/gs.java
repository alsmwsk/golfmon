package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
public final class gs
  implements SafeParcelable
{
  public static final gt CREATOR = new gt();
  public final int versionCode;
  public String wS;
  public int wT;
  public int wU;
  public boolean wV;
  
  public gs(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  gs(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.wS = paramString;
    this.wT = paramInt2;
    this.wU = paramInt3;
    this.wV = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gt.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gs
 * JD-Core Version:    0.7.0.1
 */