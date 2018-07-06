package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class ai
  implements SafeParcelable, MessageEvent
{
  public static final Parcelable.Creator<ai> CREATOR = new aj();
  final int CK;
  private final byte[] aeA;
  private final String ahy;
  private final String axW;
  private final int ve;
  
  ai(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.CK = paramInt1;
    this.ve = paramInt2;
    this.axW = paramString1;
    this.aeA = paramArrayOfByte;
    this.ahy = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getData()
  {
    return this.aeA;
  }
  
  public String getPath()
  {
    return this.axW;
  }
  
  public int getRequestId()
  {
    return this.ve;
  }
  
  public String getSourceNodeId()
  {
    return this.ahy;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MessageEventParcelable[").append(this.ve).append(",").append(this.axW).append(", size=");
    if (this.aeA == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.aeA.length)) {
      return localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ai
 * JD-Core Version:    0.7.0.1
 */