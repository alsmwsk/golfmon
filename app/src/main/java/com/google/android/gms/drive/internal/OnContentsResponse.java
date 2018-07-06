package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnContentsResponse> CREATOR = new al();
  final int CK;
  final Contents PW;
  final boolean QJ;
  
  OnContentsResponse(int paramInt, Contents paramContents, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.PW = paramContents;
    this.QJ = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Contents iL()
  {
    return this.PW;
  }
  
  public boolean iM()
  {
    return this.QJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    al.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnContentsResponse
 * JD-Core Version:    0.7.0.1
 */