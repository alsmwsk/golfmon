package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValueChangedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValueChangedDetails> CREATOR = new g();
  final int CK;
  final int Tj;
  
  ValueChangedDetails(int paramInt1, int paramInt2)
  {
    this.CK = paramInt1;
    this.Tj = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails
 * JD-Core Version:    0.7.0.1
 */