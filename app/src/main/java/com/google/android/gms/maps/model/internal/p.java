package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class p
  implements SafeParcelable
{
  public static final q CREATOR = new q();
  private final int CK;
  private a amN;
  
  public p()
  {
    this.CK = 1;
  }
  
  p(int paramInt, a parama)
  {
    this.CK = paramInt;
    this.amN = parama;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public a ol()
  {
    return this.amN;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.p
 * JD-Core Version:    0.7.0.1
 */