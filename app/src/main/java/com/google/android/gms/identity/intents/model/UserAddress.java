package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddress> CREATOR = new b();
  private final int CK;
  String afK;
  String afL;
  String afM;
  String afN;
  String afO;
  String afP;
  String afQ;
  String afR;
  String afS;
  String afT;
  boolean afU;
  String afV;
  String afW;
  String name;
  String vk;
  
  UserAddress()
  {
    this.CK = 1;
  }
  
  UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14)
  {
    this.CK = paramInt;
    this.name = paramString1;
    this.afK = paramString2;
    this.afL = paramString3;
    this.afM = paramString4;
    this.afN = paramString5;
    this.afO = paramString6;
    this.afP = paramString7;
    this.afQ = paramString8;
    this.vk = paramString9;
    this.afR = paramString10;
    this.afS = paramString11;
    this.afT = paramString12;
    this.afU = paramBoolean;
    this.afV = paramString13;
    this.afW = paramString14;
  }
  
  public static UserAddress fromIntent(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"))) {
      return null;
    }
    return (UserAddress)paramIntent.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress1()
  {
    return this.afK;
  }
  
  public String getAddress2()
  {
    return this.afL;
  }
  
  public String getAddress3()
  {
    return this.afM;
  }
  
  public String getAddress4()
  {
    return this.afN;
  }
  
  public String getAddress5()
  {
    return this.afO;
  }
  
  public String getAdministrativeArea()
  {
    return this.afP;
  }
  
  public String getCompanyName()
  {
    return this.afV;
  }
  
  public String getCountryCode()
  {
    return this.vk;
  }
  
  public String getEmailAddress()
  {
    return this.afW;
  }
  
  public String getLocality()
  {
    return this.afQ;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhoneNumber()
  {
    return this.afT;
  }
  
  public String getPostalCode()
  {
    return this.afR;
  }
  
  public String getSortingCode()
  {
    return this.afS;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public boolean isPostBox()
  {
    return this.afU;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.model.UserAddress
 * JD-Core Version:    0.7.0.1
 */