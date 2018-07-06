package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  public static String TAG = "PlusCommonExtras";
  private final int CK;
  private String anN;
  private String anO;
  
  public PlusCommonExtras()
  {
    this.CK = 1;
    this.anN = "";
    this.anO = "";
  }
  
  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.CK = paramInt;
    this.anN = paramString1;
    this.anO = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlusCommonExtras)) {}
    PlusCommonExtras localPlusCommonExtras;
    do
    {
      return false;
      localPlusCommonExtras = (PlusCommonExtras)paramObject;
    } while ((this.CK != localPlusCommonExtras.CK) || (!jv.equal(this.anN, localPlusCommonExtras.anN)) || (!jv.equal(this.anO, localPlusCommonExtras.anO)));
    return true;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.CK);
    arrayOfObject[1] = this.anN;
    arrayOfObject[2] = this.anO;
    return jv.hashCode(arrayOfObject);
  }
  
  public String ox()
  {
    return this.anN;
  }
  
  public String oy()
  {
    return this.anO;
  }
  
  public void q(Bundle paramBundle)
  {
    paramBundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", c.a(this));
  }
  
  public String toString()
  {
    return jv.h(this).a("versionCode", Integer.valueOf(this.CK)).a("Gpsrc", this.anN).a("ClientCallingPackage", this.anO).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.PlusCommonExtras
 * JD-Core Version:    0.7.0.1
 */