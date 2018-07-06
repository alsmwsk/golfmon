package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.internal.jx;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWallet> CREATOR = new k();
  private final int CK;
  String auL;
  String auM;
  String auO;
  Address auP;
  Address auQ;
  String[] auR;
  UserAddress auS;
  UserAddress auT;
  InstrumentInfo[] auU;
  LoyaltyWalletObject[] avw;
  OfferWalletObject[] avx;
  
  private MaskedWallet()
  {
    this.CK = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.CK = paramInt;
    this.auL = paramString1;
    this.auM = paramString2;
    this.auR = paramArrayOfString;
    this.auO = paramString3;
    this.auP = paramAddress1;
    this.auQ = paramAddress2;
    this.avw = paramArrayOfLoyaltyWalletObject;
    this.avx = paramArrayOfOfferWalletObject;
    this.auS = paramUserAddress1;
    this.auT = paramUserAddress2;
    this.auU = paramArrayOfInstrumentInfo;
  }
  
  public static Builder newBuilderFrom(MaskedWallet paramMaskedWallet)
  {
    jx.i(paramMaskedWallet);
    return rd().setGoogleTransactionId(paramMaskedWallet.getGoogleTransactionId()).setMerchantTransactionId(paramMaskedWallet.getMerchantTransactionId()).setPaymentDescriptions(paramMaskedWallet.getPaymentDescriptions()).setInstrumentInfos(paramMaskedWallet.getInstrumentInfos()).setEmail(paramMaskedWallet.getEmail()).setLoyaltyWalletObjects(paramMaskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(paramMaskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(paramMaskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(paramMaskedWallet.getBuyerShippingAddress());
  }
  
  public static Builder rd()
  {
    MaskedWallet localMaskedWallet = new MaskedWallet();
    localMaskedWallet.getClass();
    return new Builder(null);
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
  
  public LoyaltyWalletObject[] getLoyaltyWalletObjects()
  {
    return this.avw;
  }
  
  public String getMerchantTransactionId()
  {
    return this.auM;
  }
  
  public OfferWalletObject[] getOfferWalletObjects()
  {
    return this.avx;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.auR;
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
    k.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public MaskedWallet build()
    {
      return MaskedWallet.this;
    }
    
    public Builder setBillingAddress(Address paramAddress)
    {
      MaskedWallet.this.auP = paramAddress;
      return this;
    }
    
    public Builder setBuyerBillingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.auS = paramUserAddress;
      return this;
    }
    
    public Builder setBuyerShippingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.auT = paramUserAddress;
      return this;
    }
    
    public Builder setEmail(String paramString)
    {
      MaskedWallet.this.auO = paramString;
      return this;
    }
    
    public Builder setGoogleTransactionId(String paramString)
    {
      MaskedWallet.this.auL = paramString;
      return this;
    }
    
    public Builder setInstrumentInfos(InstrumentInfo[] paramArrayOfInstrumentInfo)
    {
      MaskedWallet.this.auU = paramArrayOfInstrumentInfo;
      return this;
    }
    
    public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject)
    {
      MaskedWallet.this.avw = paramArrayOfLoyaltyWalletObject;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWallet.this.auM = paramString;
      return this;
    }
    
    public Builder setOfferWalletObjects(OfferWalletObject[] paramArrayOfOfferWalletObject)
    {
      MaskedWallet.this.avx = paramArrayOfOfferWalletObject;
      return this;
    }
    
    public Builder setPaymentDescriptions(String[] paramArrayOfString)
    {
      MaskedWallet.this.auR = paramArrayOfString;
      return this;
    }
    
    public Builder setShippingAddress(Address paramAddress)
    {
      MaskedWallet.this.auQ = paramAddress;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.MaskedWallet
 * JD-Core Version:    0.7.0.1
 */