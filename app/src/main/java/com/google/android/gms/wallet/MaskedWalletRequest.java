package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new l();
  private final int CK;
  String auG;
  String auM;
  Cart auV;
  boolean avA;
  boolean avB;
  String avC;
  String avD;
  boolean avE;
  boolean avF;
  CountrySpecification[] avG;
  boolean avH;
  boolean avI;
  ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> avJ;
  boolean avz;
  
  MaskedWalletRequest()
  {
    this.CK = 3;
    this.avH = true;
    this.avI = true;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList)
  {
    this.CK = paramInt;
    this.auM = paramString1;
    this.avz = paramBoolean1;
    this.avA = paramBoolean2;
    this.avB = paramBoolean3;
    this.avC = paramString2;
    this.auG = paramString3;
    this.avD = paramString4;
    this.auV = paramCart;
    this.avE = paramBoolean4;
    this.avF = paramBoolean5;
    this.avG = paramArrayOfCountrySpecification;
    this.avH = paramBoolean6;
    this.avI = paramBoolean7;
    this.avJ = paramArrayList;
  }
  
  public static Builder newBuilder()
  {
    MaskedWalletRequest localMaskedWalletRequest = new MaskedWalletRequest();
    localMaskedWalletRequest.getClass();
    return new Builder(null);
  }
  
  public boolean allowDebitCard()
  {
    return this.avI;
  }
  
  public boolean allowPrepaidCard()
  {
    return this.avH;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping()
  {
    return this.avJ;
  }
  
  public CountrySpecification[] getAllowedShippingCountrySpecifications()
  {
    return this.avG;
  }
  
  public Cart getCart()
  {
    return this.auV;
  }
  
  public String getCurrencyCode()
  {
    return this.auG;
  }
  
  public String getEstimatedTotalPrice()
  {
    return this.avC;
  }
  
  public String getMerchantName()
  {
    return this.avD;
  }
  
  public String getMerchantTransactionId()
  {
    return this.auM;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public boolean isBillingAgreement()
  {
    return this.avF;
  }
  
  public boolean isPhoneNumberRequired()
  {
    return this.avz;
  }
  
  public boolean isShippingAddressRequired()
  {
    return this.avA;
  }
  
  public boolean shouldRetrieveWalletObjects()
  {
    return this.avE;
  }
  
  public boolean useMinimalBillingAddress()
  {
    return this.avB;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification paramCountrySpecification)
    {
      if (MaskedWalletRequest.this.avJ == null) {
        MaskedWalletRequest.this.avJ = new ArrayList();
      }
      MaskedWalletRequest.this.avJ.add(paramCountrySpecification);
      return this;
    }
    
    public Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> paramCollection)
    {
      if (paramCollection != null)
      {
        if (MaskedWalletRequest.this.avJ == null) {
          MaskedWalletRequest.this.avJ = new ArrayList();
        }
        MaskedWalletRequest.this.avJ.addAll(paramCollection);
      }
      return this;
    }
    
    public MaskedWalletRequest build()
    {
      return MaskedWalletRequest.this;
    }
    
    public Builder setAllowDebitCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.avI = paramBoolean;
      return this;
    }
    
    public Builder setAllowPrepaidCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.avH = paramBoolean;
      return this;
    }
    
    public Builder setCart(Cart paramCart)
    {
      MaskedWalletRequest.this.auV = paramCart;
      return this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      MaskedWalletRequest.this.auG = paramString;
      return this;
    }
    
    public Builder setEstimatedTotalPrice(String paramString)
    {
      MaskedWalletRequest.this.avC = paramString;
      return this;
    }
    
    public Builder setIsBillingAgreement(boolean paramBoolean)
    {
      MaskedWalletRequest.this.avF = paramBoolean;
      return this;
    }
    
    public Builder setMerchantName(String paramString)
    {
      MaskedWalletRequest.this.avD = paramString;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWalletRequest.this.auM = paramString;
      return this;
    }
    
    public Builder setPhoneNumberRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.avz = paramBoolean;
      return this;
    }
    
    public Builder setShippingAddressRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.avA = paramBoolean;
      return this;
    }
    
    public Builder setShouldRetrieveWalletObjects(boolean paramBoolean)
    {
      MaskedWalletRequest.this.avE = paramBoolean;
      return this;
    }
    
    public Builder setUseMinimalBillingAddress(boolean paramBoolean)
    {
      MaskedWalletRequest.this.avB = paramBoolean;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.MaskedWalletRequest
 * JD-Core Version:    0.7.0.1
 */