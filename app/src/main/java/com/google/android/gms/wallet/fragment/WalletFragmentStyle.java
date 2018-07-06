package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R.style;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new c();
  final int CK;
  Bundle awy;
  int awz;
  
  public WalletFragmentStyle()
  {
    this.CK = 1;
    this.awy = new Bundle();
  }
  
  WalletFragmentStyle(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.CK = paramInt1;
    this.awy = paramBundle;
    this.awz = paramInt2;
  }
  
  private void a(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (this.awy.containsKey(paramString)) {}
    TypedValue localTypedValue;
    do
    {
      return;
      localTypedValue = paramTypedArray.peekValue(paramInt);
    } while (localTypedValue == null);
    this.awy.putLong(paramString, Dimension.a(localTypedValue));
  }
  
  private void a(TypedArray paramTypedArray, int paramInt, String paramString1, String paramString2)
  {
    if ((this.awy.containsKey(paramString1)) || (this.awy.containsKey(paramString2))) {}
    TypedValue localTypedValue;
    do
    {
      return;
      localTypedValue = paramTypedArray.peekValue(paramInt);
    } while (localTypedValue == null);
    if ((localTypedValue.type >= 28) && (localTypedValue.type <= 31))
    {
      this.awy.putInt(paramString1, localTypedValue.data);
      return;
    }
    this.awy.putInt(paramString2, localTypedValue.resourceId);
  }
  
  private void b(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (this.awy.containsKey(paramString)) {}
    TypedValue localTypedValue;
    do
    {
      return;
      localTypedValue = paramTypedArray.peekValue(paramInt);
    } while (localTypedValue == null);
    this.awy.putInt(paramString, localTypedValue.data);
  }
  
  public int a(String paramString, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    if (this.awy.containsKey(paramString)) {
      paramInt = Dimension.a(this.awy.getLong(paramString), paramDisplayMetrics);
    }
    return paramInt;
  }
  
  public void ab(Context paramContext)
  {
    if (this.awz <= 0) {}
    for (int i = R.style.WalletFragmentDefaultStyle;; i = this.awz)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(i, R.styleable.WalletFragmentStyle);
      a(localTypedArray, R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
      a(localTypedArray, R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
      b(localTypedArray, R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
      b(localTypedArray, R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
      a(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
      a(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
      localTypedArray.recycle();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public WalletFragmentStyle setBuyButtonAppearance(int paramInt)
  {
    this.awy.putInt("buyButtonAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonHeight(int paramInt)
  {
    this.awy.putLong("buyButtonHeight", Dimension.gg(paramInt));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonHeight(int paramInt, float paramFloat)
  {
    this.awy.putLong("buyButtonHeight", Dimension.a(paramInt, paramFloat));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonText(int paramInt)
  {
    this.awy.putInt("buyButtonText", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonWidth(int paramInt)
  {
    this.awy.putLong("buyButtonWidth", Dimension.gg(paramInt));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonWidth(int paramInt, float paramFloat)
  {
    this.awy.putLong("buyButtonWidth", Dimension.a(paramInt, paramFloat));
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int paramInt)
  {
    this.awy.remove("maskedWalletDetailsBackgroundResource");
    this.awy.putInt("maskedWalletDetailsBackgroundColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int paramInt)
  {
    this.awy.remove("maskedWalletDetailsBackgroundColor");
    this.awy.putInt("maskedWalletDetailsBackgroundResource", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int paramInt)
  {
    this.awy.remove("maskedWalletDetailsButtonBackgroundResource");
    this.awy.putInt("maskedWalletDetailsButtonBackgroundColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int paramInt)
  {
    this.awy.remove("maskedWalletDetailsButtonBackgroundColor");
    this.awy.putInt("maskedWalletDetailsButtonBackgroundResource", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int paramInt)
  {
    this.awy.putInt("maskedWalletDetailsButtonTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int paramInt)
  {
    this.awy.putInt("maskedWalletDetailsHeaderTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int paramInt)
  {
    this.awy.putInt("maskedWalletDetailsLogoImageType", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int paramInt)
  {
    this.awy.putInt("maskedWalletDetailsLogoTextColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int paramInt)
  {
    this.awy.putInt("maskedWalletDetailsTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setStyleResourceId(int paramInt)
  {
    this.awz = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentStyle
 * JD-Core Version:    0.7.0.1
 */