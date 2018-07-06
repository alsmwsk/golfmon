package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class e
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  private final int CK;
  int agw;
  int agx;
  long agy;
  
  public e(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.CK = paramInt1;
    this.agw = paramInt2;
    this.agx = paramInt3;
    this.agy = paramLong;
  }
  
  private String eB(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return "STATUS_UNKNOWN";
    case 0: 
      return "STATUS_SUCCESSFUL";
    case 2: 
      return "STATUS_TIMED_OUT_ON_SCAN";
    case 3: 
      return "STATUS_NO_INFO_IN_DATABASE";
    case 4: 
      return "STATUS_INVALID_SCAN";
    case 5: 
      return "STATUS_UNABLE_TO_QUERY_DATABASE";
    case 6: 
      return "STATUS_SCANS_DISABLED_IN_SETTINGS";
    case 7: 
      return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
    }
    return "STATUS_IN_PROGRESS";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof e)) {}
    e locale;
    do
    {
      return false;
      locale = (e)paramObject;
    } while ((this.agw != locale.agw) || (this.agx != locale.agx) || (this.agy != locale.agy));
    return true;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.agw);
    arrayOfObject[1] = Integer.valueOf(this.agx);
    arrayOfObject[2] = Long.valueOf(this.agy);
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationStatus[cell status: ").append(eB(this.agw));
    localStringBuilder.append(", wifi status: ").append(eB(this.agx));
    localStringBuilder.append(", elapsed realtime ns: ").append(this.agy);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.e
 * JD-Core Version:    0.7.0.1
 */