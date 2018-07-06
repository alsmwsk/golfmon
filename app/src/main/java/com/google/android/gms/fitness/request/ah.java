package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ah
  implements SafeParcelable
{
  public static final Parcelable.Creator<ah> CREATOR = new ai();
  private final int CK;
  private final String VF;
  
  ah(int paramInt, String paramString)
  {
    this.CK = paramInt;
    this.VF = paramString;
  }
  
  public ah(String paramString)
  {
    this(3, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDeviceAddress()
  {
    return this.VF;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.VF;
    return String.format("UnclaimBleDeviceRequest{%s}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ai.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.ah
 * JD-Core Version:    0.7.0.1
 */