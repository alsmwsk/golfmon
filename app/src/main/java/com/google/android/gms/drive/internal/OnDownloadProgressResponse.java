package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new an();
  final int CK;
  final long QL;
  final long QM;
  
  OnDownloadProgressResponse(int paramInt, long paramLong1, long paramLong2)
  {
    this.CK = paramInt;
    this.QL = paramLong1;
    this.QM = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long iO()
  {
    return this.QL;
  }
  
  public long iP()
  {
    return this.QM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    an.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnDownloadProgressResponse
 * JD-Core Version:    0.7.0.1
 */