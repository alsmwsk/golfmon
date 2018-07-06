package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.Arrays;

public class h
  implements SafeParcelable
{
  public static final i CREATOR = new i();
  private final int CK;
  private final String DZ;
  private final String[] anQ;
  private final String[] anR;
  private final String[] anS;
  private final String anT;
  private final String anU;
  private final String anV;
  private final String anW;
  private final PlusCommonExtras anX;
  
  h(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.CK = paramInt;
    this.DZ = paramString1;
    this.anQ = paramArrayOfString1;
    this.anR = paramArrayOfString2;
    this.anS = paramArrayOfString3;
    this.anT = paramString2;
    this.anU = paramString3;
    this.anV = paramString4;
    this.anW = paramString5;
    this.anX = paramPlusCommonExtras;
  }
  
  public h(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras)
  {
    this.CK = 1;
    this.DZ = paramString1;
    this.anQ = paramArrayOfString1;
    this.anR = paramArrayOfString2;
    this.anS = paramArrayOfString3;
    this.anT = paramString2;
    this.anU = paramString3;
    this.anV = paramString4;
    this.anW = null;
    this.anX = paramPlusCommonExtras;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof h)) {}
    h localh;
    do
    {
      return false;
      localh = (h)paramObject;
    } while ((this.CK != localh.CK) || (!jv.equal(this.DZ, localh.DZ)) || (!Arrays.equals(this.anQ, localh.anQ)) || (!Arrays.equals(this.anR, localh.anR)) || (!Arrays.equals(this.anS, localh.anS)) || (!jv.equal(this.anT, localh.anT)) || (!jv.equal(this.anU, localh.anU)) || (!jv.equal(this.anV, localh.anV)) || (!jv.equal(this.anW, localh.anW)) || (!jv.equal(this.anX, localh.anX)));
    return true;
  }
  
  public String getAccountName()
  {
    return this.DZ;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = Integer.valueOf(this.CK);
    arrayOfObject[1] = this.DZ;
    arrayOfObject[2] = this.anQ;
    arrayOfObject[3] = this.anR;
    arrayOfObject[4] = this.anS;
    arrayOfObject[5] = this.anT;
    arrayOfObject[6] = this.anU;
    arrayOfObject[7] = this.anV;
    arrayOfObject[8] = this.anW;
    arrayOfObject[9] = this.anX;
    return jv.hashCode(arrayOfObject);
  }
  
  public String[] oA()
  {
    return this.anR;
  }
  
  public String[] oB()
  {
    return this.anS;
  }
  
  public String oC()
  {
    return this.anT;
  }
  
  public String oD()
  {
    return this.anU;
  }
  
  public String oE()
  {
    return this.anV;
  }
  
  public String oF()
  {
    return this.anW;
  }
  
  public PlusCommonExtras oG()
  {
    return this.anX;
  }
  
  public Bundle oH()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
    this.anX.q(localBundle);
    return localBundle;
  }
  
  public String[] oz()
  {
    return this.anQ;
  }
  
  public String toString()
  {
    return jv.h(this).a("versionCode", Integer.valueOf(this.CK)).a("accountName", this.DZ).a("requestedScopes", this.anQ).a("visibleActivities", this.anR).a("requiredFeatures", this.anS).a("packageNameForAuth", this.anT).a("callingPackageName", this.anU).a("applicationName", this.anV).a("extra", this.anX.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.h
 * JD-Core Version:    0.7.0.1
 */