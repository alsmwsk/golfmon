package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  private final int CK;
  private Boolean akG;
  private Boolean akM = Boolean.valueOf(true);
  private StreetViewPanoramaCamera alr;
  private String als;
  private LatLng alt;
  private Integer alu;
  private Boolean alv = Boolean.valueOf(true);
  private Boolean alw = Boolean.valueOf(true);
  private Boolean alx = Boolean.valueOf(true);
  
  public StreetViewPanoramaOptions()
  {
    this.CK = 1;
  }
  
  StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.CK = paramInt;
    this.alr = paramStreetViewPanoramaCamera;
    this.alt = paramLatLng;
    this.alu = paramInteger;
    this.als = paramString;
    this.alv = a.a(paramByte1);
    this.akM = a.a(paramByte2);
    this.alw = a.a(paramByte3);
    this.alx = a.a(paramByte4);
    this.akG = a.a(paramByte5);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Boolean getPanningGesturesEnabled()
  {
    return this.alw;
  }
  
  public String getPanoramaId()
  {
    return this.als;
  }
  
  public LatLng getPosition()
  {
    return this.alt;
  }
  
  public Integer getRadius()
  {
    return this.alu;
  }
  
  public Boolean getStreetNamesEnabled()
  {
    return this.alx;
  }
  
  public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
  {
    return this.alr;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.akG;
  }
  
  public Boolean getUserNavigationEnabled()
  {
    return this.alv;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.akM;
  }
  
  byte nE()
  {
    return a.c(this.akG);
  }
  
  byte nI()
  {
    return a.c(this.akM);
  }
  
  byte nS()
  {
    return a.c(this.alv);
  }
  
  byte nT()
  {
    return a.c(this.alw);
  }
  
  byte nU()
  {
    return a.c(this.alx);
  }
  
  public StreetViewPanoramaOptions panningGesturesEnabled(boolean paramBoolean)
  {
    this.alw = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    this.alr = paramStreetViewPanoramaCamera;
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaId(String paramString)
  {
    this.als = paramString;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng)
  {
    this.alt = paramLatLng;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger)
  {
    this.alt = paramLatLng;
    this.alu = paramInteger;
    return this;
  }
  
  public StreetViewPanoramaOptions streetNamesEnabled(boolean paramBoolean)
  {
    this.alx = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.akG = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions userNavigationEnabled(boolean paramBoolean)
  {
    this.alv = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
  
  public StreetViewPanoramaOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.akM = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaOptions
 * JD-Core Version:    0.7.0.1
 */