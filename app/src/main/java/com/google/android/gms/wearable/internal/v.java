package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class v
  implements SafeParcelable
{
  public static final Parcelable.Creator<v> CREATOR = new w();
  public final List<al> axL;
  public final int statusCode;
  public final int versionCode;
  
  v(int paramInt1, int paramInt2, List<al> paramList)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.axL = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    w.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.v
 * JD-Core Version:    0.7.0.1
 */