package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;
import java.util.Set;

public class or
  implements SafeParcelable
{
  public static final ot CREATOR = new ot();
  public final long amW;
  public final byte[] amX;
  public final Bundle amY;
  public final String tag;
  public final int versionCode;
  
  or(int paramInt, long paramLong, String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.versionCode = paramInt;
    this.amW = paramLong;
    this.tag = paramString;
    this.amX = paramArrayOfByte;
    this.amY = paramBundle;
  }
  
  public or(long paramLong, String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    this.versionCode = 1;
    this.amW = paramLong;
    this.tag = paramString;
    this.amX = paramArrayOfByte;
    this.amY = g(paramVarArgs);
  }
  
  private static Bundle g(String... paramVarArgs)
  {
    Bundle localBundle = null;
    if (paramVarArgs == null) {}
    for (;;)
    {
      return localBundle;
      if (paramVarArgs.length % 2 != 0) {
        throw new IllegalArgumentException("extras must have an even number of elements");
      }
      int i = paramVarArgs.length / 2;
      localBundle = null;
      if (i != 0)
      {
        localBundle = new Bundle(i);
        for (int j = 0; j < i; j++) {
          localBundle.putString(paramVarArgs[(j * 2)], paramVarArgs[(1 + j * 2)]);
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag=").append(this.tag).append(",");
    localStringBuilder.append("eventTime=").append(this.amW).append(",");
    if ((this.amY != null) && (!this.amY.isEmpty()))
    {
      localStringBuilder.append("keyValues=");
      Iterator localIterator = this.amY.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("(").append(str).append(",");
        localStringBuilder.append(this.amY.getString(str)).append(")");
        localStringBuilder.append(" ");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ot.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.or
 * JD-Core Version:    0.7.0.1
 */