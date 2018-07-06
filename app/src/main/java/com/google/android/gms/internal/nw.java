package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nw
  implements SafeParcelable
{
  public static final nx CREATOR = new nx();
  final int CK;
  private final String ahx;
  private final String ahy;
  private final String mTag;
  
  nw(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.CK = paramInt;
    this.ahx = paramString1;
    this.mTag = paramString2;
    this.ahy = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof nw)) {}
    nw localnw;
    do
    {
      return false;
      localnw = (nw)paramObject;
    } while ((!jv.equal(this.ahx, localnw.ahx)) || (!jv.equal(this.mTag, localnw.mTag)) || (!jv.equal(this.ahy, localnw.ahy)));
    return true;
  }
  
  public String getSource()
  {
    return this.ahy;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.ahx;
    arrayOfObject[1] = this.mTag;
    arrayOfObject[2] = this.ahy;
    return jv.hashCode(arrayOfObject);
  }
  
  public String nw()
  {
    return this.ahx;
  }
  
  public String toString()
  {
    return jv.h(this).a("mPlaceId", this.ahx).a("mTag", this.mTag).a("mSource", this.ahy).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nx.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nw
 * JD-Core Version:    0.7.0.1
 */