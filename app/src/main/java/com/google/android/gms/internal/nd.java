package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nd
  implements SafeParcelable
{
  public static final ne CREATOR = new ne();
  private final int CK;
  public final String packageName;
  public final int uid;
  
  nd(int paramInt1, int paramInt2, String paramString)
  {
    this.CK = paramInt1;
    this.uid = paramInt2;
    this.packageName = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof nd)) {}
    nd localnd;
    do
    {
      return false;
      localnd = (nd)paramObject;
    } while ((localnd.uid != this.uid) || (!jv.equal(localnd.packageName, this.packageName)));
    return true;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return this.uid;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.uid);
    arrayOfObject[1] = this.packageName;
    return String.format("%d:%s", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ne.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nd
 * JD-Core Version:    0.7.0.1
 */