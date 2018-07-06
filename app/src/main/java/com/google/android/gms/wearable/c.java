package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class c
  implements SafeParcelable
{
  public static final Parcelable.Creator<c> CREATOR = new d();
  final int CK;
  private final int Gt;
  private final String TW;
  private final int axc;
  private final boolean axd;
  private boolean axe;
  private String axf;
  private final String mName;
  
  c(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    this.CK = paramInt1;
    this.mName = paramString1;
    this.TW = paramString2;
    this.Gt = paramInt2;
    this.axc = paramInt3;
    this.axd = paramBoolean1;
    this.axe = paramBoolean2;
    this.axf = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {}
    c localc;
    do
    {
      return false;
      localc = (c)paramObject;
    } while ((!jv.equal(Integer.valueOf(this.CK), Integer.valueOf(localc.CK))) || (!jv.equal(this.mName, localc.mName)) || (!jv.equal(this.TW, localc.TW)) || (!jv.equal(Integer.valueOf(this.Gt), Integer.valueOf(localc.Gt))) || (!jv.equal(Integer.valueOf(this.axc), Integer.valueOf(localc.axc))) || (!jv.equal(Boolean.valueOf(this.axd), Boolean.valueOf(localc.axd))));
    return true;
  }
  
  public String getAddress()
  {
    return this.TW;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getRole()
  {
    return this.axc;
  }
  
  public int getType()
  {
    return this.Gt;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(this.CK);
    arrayOfObject[1] = this.mName;
    arrayOfObject[2] = this.TW;
    arrayOfObject[3] = Integer.valueOf(this.Gt);
    arrayOfObject[4] = Integer.valueOf(this.axc);
    arrayOfObject[5] = Boolean.valueOf(this.axd);
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean isConnected()
  {
    return this.axe;
  }
  
  public boolean isEnabled()
  {
    return this.axd;
  }
  
  public String rj()
  {
    return this.axf;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + this.mName);
    localStringBuilder.append(", mAddress=" + this.TW);
    localStringBuilder.append(", mType=" + this.Gt);
    localStringBuilder.append(", mRole=" + this.axc);
    localStringBuilder.append(", mEnabled=" + this.axd);
    localStringBuilder.append(", mIsConnected=" + this.axe);
    localStringBuilder.append(", mEnabled=" + this.axf);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.c
 * JD-Core Version:    0.7.0.1
 */