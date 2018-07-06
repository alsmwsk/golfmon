package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart
  implements SafeParcelable
{
  public static final Parcelable.Creator<Cart> CREATOR = new b();
  private final int CK;
  String auF;
  String auG;
  ArrayList<LineItem> auH;
  
  Cart()
  {
    this.CK = 1;
    this.auH = new ArrayList();
  }
  
  Cart(int paramInt, String paramString1, String paramString2, ArrayList<LineItem> paramArrayList)
  {
    this.CK = paramInt;
    this.auF = paramString1;
    this.auG = paramString2;
    this.auH = paramArrayList;
  }
  
  public static Builder newBuilder()
  {
    Cart localCart = new Cart();
    localCart.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCurrencyCode()
  {
    return this.auG;
  }
  
  public ArrayList<LineItem> getLineItems()
  {
    return this.auH;
  }
  
  public String getTotalPrice()
  {
    return this.auF;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addLineItem(LineItem paramLineItem)
    {
      Cart.this.auH.add(paramLineItem);
      return this;
    }
    
    public Cart build()
    {
      return Cart.this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      Cart.this.auG = paramString;
      return this;
    }
    
    public Builder setLineItems(List<LineItem> paramList)
    {
      Cart.this.auH.clear();
      Cart.this.auH.addAll(paramList);
      return this;
    }
    
    public Builder setTotalPrice(String paramString)
    {
      Cart.this.auF = paramString;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.Cart
 * JD-Core Version:    0.7.0.1
 */