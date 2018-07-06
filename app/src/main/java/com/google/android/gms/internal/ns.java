package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ns
  implements SafeParcelable
{
  public static final nt CREATOR = new nt();
  private final int CK;
  private final int agd;
  private final int ahp;
  private final nu ahq;
  
  ns(int paramInt1, int paramInt2, int paramInt3, nu paramnu)
  {
    this.CK = paramInt1;
    this.agd = paramInt2;
    this.ahp = paramInt3;
    this.ahq = paramnu;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    ns localns;
    do
    {
      return true;
      if (!(paramObject instanceof ns)) {
        return false;
      }
      localns = (ns)paramObject;
    } while ((this.agd == localns.agd) && (this.ahp == localns.ahp) && (this.ahq.equals(localns.ahq)));
    return false;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.agd);
    arrayOfObject[1] = Integer.valueOf(this.ahp);
    return jv.hashCode(arrayOfObject);
  }
  
  public int np()
  {
    return this.agd;
  }
  
  public int ns()
  {
    return this.ahp;
  }
  
  public nu nt()
  {
    return this.ahq;
  }
  
  public String toString()
  {
    return jv.h(this).a("transitionTypes", Integer.valueOf(this.agd)).a("loiteringTimeMillis", Integer.valueOf(this.ahp)).a("placeFilter", this.ahq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nt.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ns
 * JD-Core Version:    0.7.0.1
 */