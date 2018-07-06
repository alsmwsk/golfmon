package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification
  implements SafeParcelable
{
  public static final Parcelable.Creator<CountrySpecification> CREATOR = new a();
  private final int CK;
  String vk;
  
  CountrySpecification(int paramInt, String paramString)
  {
    this.CK = paramInt;
    this.vk = paramString;
  }
  
  public CountrySpecification(String paramString)
  {
    this.CK = 1;
    this.vk = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCountryCode()
  {
    return this.vk;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.model.CountrySpecification
 * JD-Core Version:    0.7.0.1
 */