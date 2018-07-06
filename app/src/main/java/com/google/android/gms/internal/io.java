package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class io
  implements SafeParcelable
{
  public static final Parcelable.Creator<io> CREATOR = new ip();
  private final int CK;
  private double Gp;
  private boolean Gq;
  private ApplicationMetadata HD;
  private int Hr;
  private int Hs;
  
  public io()
  {
    this(3, (0.0D / 0.0D), false, -1, null, -1);
  }
  
  io(int paramInt1, double paramDouble, boolean paramBoolean, int paramInt2, ApplicationMetadata paramApplicationMetadata, int paramInt3)
  {
    this.CK = paramInt1;
    this.Gp = paramDouble;
    this.Gq = paramBoolean;
    this.Hr = paramInt2;
    this.HD = paramApplicationMetadata;
    this.Hs = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    io localio;
    do
    {
      return true;
      if (!(paramObject instanceof io)) {
        return false;
      }
      localio = (io)paramObject;
    } while ((this.Gp == localio.Gp) && (this.Gq == localio.Gq) && (this.Hr == localio.Hr) && (in.a(this.HD, localio.HD)) && (this.Hs == localio.Hs));
    return false;
  }
  
  public double fZ()
  {
    return this.Gp;
  }
  
  public ApplicationMetadata getApplicationMetadata()
  {
    return this.HD;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public boolean gi()
  {
    return this.Gq;
  }
  
  public int gj()
  {
    return this.Hr;
  }
  
  public int gk()
  {
    return this.Hs;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Double.valueOf(this.Gp);
    arrayOfObject[1] = Boolean.valueOf(this.Gq);
    arrayOfObject[2] = Integer.valueOf(this.Hr);
    arrayOfObject[3] = this.HD;
    arrayOfObject[4] = Integer.valueOf(this.Hs);
    return jv.hashCode(arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ip.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.io
 * JD-Core Version:    0.7.0.1
 */