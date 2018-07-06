package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.i;

public class OnListParentsResponse
  extends i
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new as();
  final int CK;
  final DataHolder QR;
  
  OnListParentsResponse(int paramInt, DataHolder paramDataHolder)
  {
    this.CK = paramInt;
    this.QR = paramDataHolder;
  }
  
  protected void I(Parcel paramParcel, int paramInt)
  {
    as.a(this, paramParcel, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataHolder iT()
  {
    return this.QR;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnListParentsResponse
 * JD-Core Version:    0.7.0.1
 */