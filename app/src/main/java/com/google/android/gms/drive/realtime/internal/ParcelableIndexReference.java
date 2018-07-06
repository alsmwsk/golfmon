package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new q();
  final int CK;
  final String SM;
  final boolean SN;
  final int mIndex;
  
  ParcelableIndexReference(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.CK = paramInt1;
    this.SM = paramString;
    this.mIndex = paramInt2;
    this.SN = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.ParcelableIndexReference
 * JD-Core Version:    0.7.0.1
 */