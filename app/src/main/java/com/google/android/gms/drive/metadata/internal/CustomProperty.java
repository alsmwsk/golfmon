package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.internal.jx;

public class CustomProperty
  implements SafeParcelable
{
  public static final Parcelable.Creator<CustomProperty> CREATOR = new c();
  final int CK;
  final CustomPropertyKey Rg;
  final String mValue;
  
  CustomProperty(int paramInt, CustomPropertyKey paramCustomPropertyKey, String paramString)
  {
    this.CK = paramInt;
    jx.b(paramCustomPropertyKey, "key");
    this.Rg = paramCustomPropertyKey;
    this.mValue = paramString;
  }
  
  public CustomProperty(CustomPropertyKey paramCustomPropertyKey, String paramString)
  {
    this(1, paramCustomPropertyKey, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  public CustomPropertyKey iX()
  {
    return this.Rg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.CustomProperty
 * JD-Core Version:    0.7.0.1
 */