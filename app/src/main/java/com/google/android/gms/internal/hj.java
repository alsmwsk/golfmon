package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hj
  implements SafeParcelable
{
  public static final hk CREATOR = new hk();
  final int CK;
  final Bundle Db;
  public final int id;
  
  hj(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.CK = paramInt1;
    this.id = paramInt2;
    this.Db = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hk.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hj
 * JD-Core Version:    0.7.0.1
 */