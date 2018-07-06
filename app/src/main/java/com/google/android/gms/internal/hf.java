package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hf
  implements SafeParcelable
{
  public static final hg CREATOR = new hg();
  final int CK;
  final String CS;
  final String CT;
  final String CU;
  
  hf(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.CK = paramInt;
    this.CS = paramString1;
    this.CT = paramString2;
    this.CU = paramString3;
  }
  
  public hf(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, paramString2, paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.CS;
    arrayOfObject[1] = this.CT;
    arrayOfObject[2] = this.CU;
    return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hg.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hf
 * JD-Core Version:    0.7.0.1
 */