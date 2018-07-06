package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;

public final class CircleOptions
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  private final int CK;
  private LatLng alS = null;
  private double alT = 0.0D;
  private float alU = 10.0F;
  private int alV = -16777216;
  private int alW = 0;
  private float alX = 0.0F;
  private boolean alY = true;
  
  public CircleOptions()
  {
    this.CK = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.CK = paramInt1;
    this.alS = paramLatLng;
    this.alT = paramDouble;
    this.alU = paramFloat1;
    this.alV = paramInt2;
    this.alW = paramInt3;
    this.alX = paramFloat2;
    this.alY = paramBoolean;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.alS = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.alW = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.alS;
  }
  
  public int getFillColor()
  {
    return this.alW;
  }
  
  public double getRadius()
  {
    return this.alT;
  }
  
  public int getStrokeColor()
  {
    return this.alV;
  }
  
  public float getStrokeWidth()
  {
    return this.alU;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public float getZIndex()
  {
    return this.alX;
  }
  
  public boolean isVisible()
  {
    return this.alY;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.alT = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.alV = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    this.alU = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.alY = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (aa.ob())
    {
      d.a(this, paramParcel, paramInt);
      return;
    }
    c.a(this, paramParcel, paramInt);
  }
  
  public CircleOptions zIndex(float paramFloat)
  {
    this.alX = paramFloat;
    return this;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CircleOptions
 * JD-Core Version:    0.7.0.1
 */