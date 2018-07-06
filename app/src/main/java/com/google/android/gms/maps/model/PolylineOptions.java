package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final o CREATOR = new o();
  private final int CK;
  private float alX = 0.0F;
  private boolean alY = true;
  private float amc = 10.0F;
  private final List<LatLng> amx;
  private boolean amz = false;
  private int mColor = -16777216;
  
  public PolylineOptions()
  {
    this.CK = 1;
    this.amx = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.CK = paramInt1;
    this.amx = paramList;
    this.amc = paramFloat1;
    this.mColor = paramInt2;
    this.alX = paramFloat2;
    this.alY = paramBoolean1;
    this.amz = paramBoolean2;
  }
  
  public PolylineOptions add(LatLng paramLatLng)
  {
    this.amx.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions add(LatLng... paramVarArgs)
  {
    this.amx.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      LatLng localLatLng = (LatLng)localIterator.next();
      this.amx.add(localLatLng);
    }
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolylineOptions geodesic(boolean paramBoolean)
  {
    this.amz = paramBoolean;
    return this;
  }
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public List<LatLng> getPoints()
  {
    return this.amx;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public float getWidth()
  {
    return this.amc;
  }
  
  public float getZIndex()
  {
    return this.alX;
  }
  
  public boolean isGeodesic()
  {
    return this.amz;
  }
  
  public boolean isVisible()
  {
    return this.alY;
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.alY = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    this.amc = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (aa.ob())
    {
      p.a(this, paramParcel, paramInt);
      return;
    }
    o.a(this, paramParcel, paramInt);
  }
  
  public PolylineOptions zIndex(float paramFloat)
  {
    this.alX = paramFloat;
    return this;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolylineOptions
 * JD-Core Version:    0.7.0.1
 */