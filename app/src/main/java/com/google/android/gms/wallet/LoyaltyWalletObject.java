package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public final class LoyaltyWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new j();
  private final int CK;
  String aki;
  String avd;
  String ave;
  String avf;
  String avg;
  String avh;
  String avi;
  String avj;
  String avk;
  ArrayList<p> avl;
  l avm;
  ArrayList<LatLng> avn;
  String avo;
  String avp;
  ArrayList<d> avq;
  boolean avr;
  ArrayList<n> avs;
  ArrayList<com.google.android.gms.wallet.wobs.j> avt;
  ArrayList<n> avu;
  f avv;
  String fl;
  int state;
  
  LoyaltyWalletObject()
  {
    this.CK = 4;
    this.avl = la.ie();
    this.avn = la.ie();
    this.avq = la.ie();
    this.avs = la.ie();
    this.avt = la.ie();
    this.avu = la.ie();
  }
  
  LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<com.google.android.gms.wallet.wobs.j> paramArrayList4, ArrayList<n> paramArrayList5, f paramf)
  {
    this.CK = paramInt1;
    this.fl = paramString1;
    this.avd = paramString2;
    this.ave = paramString3;
    this.avf = paramString4;
    this.aki = paramString5;
    this.avg = paramString6;
    this.avh = paramString7;
    this.avi = paramString8;
    this.avj = paramString9;
    this.avk = paramString10;
    this.state = paramInt2;
    this.avl = paramArrayList;
    this.avm = paraml;
    this.avn = paramArrayList1;
    this.avo = paramString11;
    this.avp = paramString12;
    this.avq = paramArrayList2;
    this.avr = paramBoolean;
    this.avs = paramArrayList3;
    this.avt = paramArrayList4;
    this.avu = paramArrayList5;
    this.avv = paramf;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountId()
  {
    return this.avd;
  }
  
  public String getAccountName()
  {
    return this.aki;
  }
  
  public String getBarcodeAlternateText()
  {
    return this.avg;
  }
  
  public String getBarcodeType()
  {
    return this.avh;
  }
  
  public String getBarcodeValue()
  {
    return this.avi;
  }
  
  public String getId()
  {
    return this.fl;
  }
  
  public String getIssuerName()
  {
    return this.ave;
  }
  
  public String getProgramName()
  {
    return this.avf;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.LoyaltyWalletObject
 * JD-Core Version:    0.7.0.1
 */