package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
public final class bj
  implements SafeParcelable
{
  public static final bk CREATOR = new bk();
  public final int backgroundColor;
  public final int oQ;
  public final int oR;
  public final int oS;
  public final int oT;
  public final int oU;
  public final int oV;
  public final int oW;
  public final String oX;
  public final int oY;
  public final String oZ;
  public final int pa;
  public final int pb;
  public final String pc;
  public final int versionCode;
  
  bj(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    this.versionCode = paramInt1;
    this.oQ = paramInt2;
    this.backgroundColor = paramInt3;
    this.oR = paramInt4;
    this.oS = paramInt5;
    this.oT = paramInt6;
    this.oU = paramInt7;
    this.oV = paramInt8;
    this.oW = paramInt9;
    this.oX = paramString1;
    this.oY = paramInt10;
    this.oZ = paramString2;
    this.pa = paramInt11;
    this.pb = paramInt12;
    this.pc = paramString3;
  }
  
  public bj(SearchAdRequest paramSearchAdRequest)
  {
    this.versionCode = 1;
    this.oQ = paramSearchAdRequest.getAnchorTextColor();
    this.backgroundColor = paramSearchAdRequest.getBackgroundColor();
    this.oR = paramSearchAdRequest.getBackgroundGradientBottom();
    this.oS = paramSearchAdRequest.getBackgroundGradientTop();
    this.oT = paramSearchAdRequest.getBorderColor();
    this.oU = paramSearchAdRequest.getBorderThickness();
    this.oV = paramSearchAdRequest.getBorderType();
    this.oW = paramSearchAdRequest.getCallButtonColor();
    this.oX = paramSearchAdRequest.getCustomChannels();
    this.oY = paramSearchAdRequest.getDescriptionTextColor();
    this.oZ = paramSearchAdRequest.getFontFace();
    this.pa = paramSearchAdRequest.getHeaderTextColor();
    this.pb = paramSearchAdRequest.getHeaderTextSize();
    this.pc = paramSearchAdRequest.getQuery();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bk.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bj
 * JD-Core Version:    0.7.0.1
 */