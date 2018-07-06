package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWallet> CREATOR = new f();
  private final int CK;
  String auL;
  String auM;
  ProxyCard auN;
  String auO;
  Address auP;
  Address auQ;
  String[] auR;
  UserAddress auS;
  UserAddress auT;
  InstrumentInfo[] auU;
  
  private FullWallet()
  {
    this.CK = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.CK = paramInt;
    this.auL = paramString1;
    this.auM = paramString2;
    this.auN = paramProxyCard;
    this.auO = paramString3;
    this.auP = paramAddress1;
    this.auQ = paramAddress2;
    this.auR = paramArrayOfString;
    this.auS = paramUserAddress1;
    this.auT = paramUserAddress2;
    this.auU = paramArrayOfInstrumentInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public Address getBillingAddress()
  {
    return this.auP;
  }
  
  public UserAddress getBuyerBillingAddress()
  {
    return this.auS;
  }
  
  public UserAddress getBuyerShippingAddress()
  {
    return this.auT;
  }
  
  public String getEmail()
  {
    return this.auO;
  }
  
  public String getGoogleTransactionId()
  {
    return this.auL;
  }
  
  public InstrumentInfo[] getInstrumentInfos()
  {
    return this.auU;
  }
  
  public String getMerchantTransactionId()
  {
    return this.auM;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.auR;
  }
  
  public ProxyCard getProxyCard()
  {
    return this.auN;
  }
  
  @Deprecated
  public Address getShippingAddress()
  {
    return this.auQ;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.FullWallet
 * JD-Core Version:    0.7.0.1
 */