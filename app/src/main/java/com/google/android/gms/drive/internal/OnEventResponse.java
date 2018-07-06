package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnEventResponse> CREATOR = new aq();
  final int CK;
  final int Pm;
  final ChangeEvent QO;
  final CompletionEvent QP;
  
  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, CompletionEvent paramCompletionEvent)
  {
    this.CK = paramInt1;
    this.Pm = paramInt2;
    this.QO = paramChangeEvent;
    this.QP = paramCompletionEvent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveEvent iQ()
  {
    switch (this.Pm)
    {
    default: 
      throw new IllegalStateException("Unexpected event type " + this.Pm);
    case 1: 
      return this.QO;
    }
    return this.QP;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aq.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnEventResponse
 * JD-Core Version:    0.7.0.1
 */