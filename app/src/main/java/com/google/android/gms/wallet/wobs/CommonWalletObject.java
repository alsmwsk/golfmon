package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<CommonWalletObject> CREATOR = new a();
  private final int CK;
  String ave;
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
  ArrayList<j> avt;
  ArrayList<n> avu;
  String fl;
  String name;
  int state;
  
  CommonWalletObject()
  {
    this.CK = 1;
    this.avl = la.ie();
    this.avn = la.ie();
    this.avq = la.ie();
    this.avs = la.ie();
    this.avt = la.ie();
    this.avu = la.ie();
  }
  
  CommonWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString9, String paramString10, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<j> paramArrayList4, ArrayList<n> paramArrayList5)
  {
    this.CK = paramInt1;
    this.fl = paramString1;
    this.avk = paramString2;
    this.name = paramString3;
    this.ave = paramString4;
    this.avg = paramString5;
    this.avh = paramString6;
    this.avi = paramString7;
    this.avj = paramString8;
    this.state = paramInt2;
    this.avl = paramArrayList;
    this.avm = paraml;
    this.avn = paramArrayList1;
    this.avo = paramString9;
    this.avp = paramString10;
    this.avq = paramArrayList2;
    this.avr = paramBoolean;
    this.avs = paramArrayList3;
    this.avt = paramArrayList4;
    this.avu = paramArrayList5;
  }
  
  public static a rh()
  {
    CommonWalletObject localCommonWalletObject = new CommonWalletObject();
    localCommonWalletObject.getClass();
    return new a(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.fl;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public final class a
  {
    private a() {}
    
    public a dh(String paramString)
    {
      CommonWalletObject.this.fl = paramString;
      return this;
    }
    
    public CommonWalletObject ri()
    {
      return CommonWalletObject.this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.CommonWalletObject
 * JD-Core Version:    0.7.0.1
 */