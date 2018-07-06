package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class e
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  private final int CK;
  private a amM;
  
  public e()
  {
    this.CK = 1;
  }
  
  e(int paramInt, a parama)
  {
    this.CK = paramInt;
    this.amM = parama;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public a oj()
  {
    return this.amM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.e
 * JD-Core Version:    0.7.0.1
 */