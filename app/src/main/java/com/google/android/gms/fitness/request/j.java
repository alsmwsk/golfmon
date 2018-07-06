package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public class j
  implements SafeParcelable
{
  public static final Parcelable.Creator<j> CREATOR = new k();
  private final int CK;
  private final String mName;
  
  j(int paramInt, String paramString)
  {
    this.CK = paramInt;
    this.mName = paramString;
  }
  
  public j(String paramString)
  {
    this.CK = 1;
    this.mName = paramString;
  }
  
  private boolean a(j paramj)
  {
    return jv.equal(this.mName, paramj.mName);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof j)) && (a((j)paramObject)));
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mName;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("name", this.mName).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.j
 * JD-Core Version:    0.7.0.1
 */