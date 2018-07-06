package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public class CreateContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateContentsRequest> CREATOR = new h();
  final int CK;
  final int Oi;
  
  public CreateContentsRequest(int paramInt)
  {
    this(1, paramInt);
  }
  
  CreateContentsRequest(int paramInt1, int paramInt2)
  {
    this.CK = paramInt1;
    if ((paramInt2 == 536870912) || (paramInt2 == 805306368)) {}
    for (boolean bool = true;; bool = false)
    {
      jx.b(bool, "Cannot create a new read-only contents!");
      this.Oi = paramInt2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CreateContentsRequest
 * JD-Core Version:    0.7.0.1
 */