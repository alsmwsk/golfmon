package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class an
  implements Parcelable.Creator<OnDownloadProgressResponse>
{
  static void a(OnDownloadProgressResponse paramOnDownloadProgressResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramOnDownloadProgressResponse.CK);
    b.a(paramParcel, 2, paramOnDownloadProgressResponse.QL);
    b.a(paramParcel, 3, paramOnDownloadProgressResponse.QM);
    b.H(paramParcel, i);
  }
  
  public OnDownloadProgressResponse as(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = a.G(paramParcel);
    int j = 0;
    long l2 = l1;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        l2 = a.i(paramParcel, k);
        break;
      case 3: 
        l1 = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new OnDownloadProgressResponse(j, l2, l1);
  }
  
  public OnDownloadProgressResponse[] bH(int paramInt)
  {
    return new OnDownloadProgressResponse[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.an
 * JD-Core Version:    0.7.0.1
 */