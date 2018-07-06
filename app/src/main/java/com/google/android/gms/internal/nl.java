package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class nl
  implements SafeParcelable
{
  public static final nm CREATOR = new nm();
  static final List<nd> ahg = ;
  private final int CK;
  LocationRequest We;
  boolean ahh;
  boolean ahi;
  boolean ahj;
  List<nd> ahk;
  final String mTag;
  
  nl(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<nd> paramList, String paramString)
  {
    this.CK = paramInt;
    this.We = paramLocationRequest;
    this.ahh = paramBoolean1;
    this.ahi = paramBoolean2;
    this.ahj = paramBoolean3;
    this.ahk = paramList;
    this.mTag = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof nl)) {}
    nl localnl;
    do
    {
      return false;
      localnl = (nl)paramObject;
    } while ((!jv.equal(this.We, localnl.We)) || (this.ahh != localnl.ahh) || (this.ahi != localnl.ahi) || (this.ahj != localnl.ahj) || (!jv.equal(this.ahk, localnl.ahk)));
    return true;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return this.We.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.We.toString());
    localStringBuilder.append(" requestNlpDebugInfo=");
    localStringBuilder.append(this.ahh);
    localStringBuilder.append(" restorePendingIntentListeners=");
    localStringBuilder.append(this.ahi);
    localStringBuilder.append(" triggerUpdate=");
    localStringBuilder.append(this.ahj);
    localStringBuilder.append(" clients=");
    localStringBuilder.append(this.ahk);
    if (this.mTag != null)
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(this.mTag);
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nm.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nl
 * JD-Core Version:    0.7.0.1
 */