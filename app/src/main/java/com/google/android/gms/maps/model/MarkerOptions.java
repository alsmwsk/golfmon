package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.internal.aa;

public final class MarkerOptions
  implements SafeParcelable
{
  public static final k CREATOR = new k();
  private final int CK;
  private String OH;
  private boolean alY = true;
  private LatLng alt;
  private float amg = 0.5F;
  private float amh = 1.0F;
  private String amp;
  private BitmapDescriptor amq;
  private boolean amr;
  private boolean ams = false;
  private float amt = 0.0F;
  private float amu = 0.5F;
  private float amv = 0.0F;
  private float mAlpha = 1.0F;
  
  public MarkerOptions()
  {
    this.CK = 1;
  }
  
  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.CK = paramInt;
    this.alt = paramLatLng;
    this.OH = paramString1;
    this.amp = paramString2;
    if (paramIBinder == null) {}
    for (BitmapDescriptor localBitmapDescriptor = null;; localBitmapDescriptor = new BitmapDescriptor(d.a.ap(paramIBinder)))
    {
      this.amq = localBitmapDescriptor;
      this.amg = paramFloat1;
      this.amh = paramFloat2;
      this.amr = paramBoolean1;
      this.alY = paramBoolean2;
      this.ams = paramBoolean3;
      this.amt = paramFloat3;
      this.amu = paramFloat4;
      this.amv = paramFloat5;
      this.mAlpha = paramFloat6;
      return;
    }
  }
  
  public MarkerOptions alpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
    return this;
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.amg = paramFloat1;
    this.amh = paramFloat2;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.amr = paramBoolean;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.ams = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getAnchorU()
  {
    return this.amg;
  }
  
  public float getAnchorV()
  {
    return this.amh;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.amq;
  }
  
  public float getInfoWindowAnchorU()
  {
    return this.amu;
  }
  
  public float getInfoWindowAnchorV()
  {
    return this.amv;
  }
  
  public LatLng getPosition()
  {
    return this.alt;
  }
  
  public float getRotation()
  {
    return this.amt;
  }
  
  public String getSnippet()
  {
    return this.amp;
  }
  
  public String getTitle()
  {
    return this.OH;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.amq = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.amu = paramFloat1;
    this.amv = paramFloat2;
    return this;
  }
  
  public boolean isDraggable()
  {
    return this.amr;
  }
  
  public boolean isFlat()
  {
    return this.ams;
  }
  
  public boolean isVisible()
  {
    return this.alY;
  }
  
  IBinder oe()
  {
    if (this.amq == null) {
      return null;
    }
    return this.amq.nA().asBinder();
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.alt = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    this.amt = paramFloat;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.amp = paramString;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.OH = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.alY = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (aa.ob())
    {
      l.a(this, paramParcel, paramInt);
      return;
    }
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.MarkerOptions
 * JD-Core Version:    0.7.0.1
 */