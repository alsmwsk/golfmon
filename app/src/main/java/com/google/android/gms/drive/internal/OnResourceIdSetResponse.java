package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnResourceIdSetResponse> CREATOR = new av();
  private final int CK;
  private final List<String> Po;
  
  OnResourceIdSetResponse(int paramInt, List<String> paramList)
  {
    this.CK = paramInt;
    this.Po = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public List<String> iF()
  {
    return this.Po;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    av.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnResourceIdSetResponse
 * JD-Core Version:    0.7.0.1
 */