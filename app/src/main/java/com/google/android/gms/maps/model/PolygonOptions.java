package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final m CREATOR = new m();
  private final int CK;
  private float alU = 10.0F;
  private int alV = -16777216;
  private int alW = 0;
  private float alX = 0.0F;
  private boolean alY = true;
  private final List<LatLng> amx;
  private final List<List<LatLng>> amy;
  private boolean amz = false;
  
  public PolygonOptions()
  {
    this.CK = 1;
    this.amx = new ArrayList();
    this.amy = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.CK = paramInt1;
    this.amx = paramList;
    this.amy = paramList1;
    this.alU = paramFloat1;
    this.alV = paramInt2;
    this.alW = paramInt3;
    this.alX = paramFloat2;
    this.alY = paramBoolean1;
    this.amz = paramBoolean2;
  }
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    this.amx.add(paramLatLng);
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    this.amx.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      LatLng localLatLng = (LatLng)localIterator.next();
      this.amx.add(localLatLng);
    }
    return this;
  }
  
  public PolygonOptions addHole(Iterable<LatLng> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((LatLng)localIterator.next());
    }
    this.amy.add(localArrayList);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.alW = paramInt;
    return this;
  }
  
  public PolygonOptions geodesic(boolean paramBoolean)
  {
    this.amz = paramBoolean;
    return this;
  }
  
  public int getFillColor()
  {
    return this.alW;
  }
  
  public List<List<LatLng>> getHoles()
  {
    return this.amy;
  }
  
  public List<LatLng> getPoints()
  {
    return this.amx;
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
  
  public boolean isGeodesic()
  {
    return this.amz;
  }
  
  public boolean isVisible()
  {
    return this.alY;
  }
  
  List of()
  {
    return this.amy;
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.alV = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    this.alU = paramFloat;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.alY = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (aa.ob())
    {
      n.a(this, paramParcel, paramInt);
      return;
    }
    m.a(this, paramParcel, paramInt);
  }
  
  public PolygonOptions zIndex(float paramFloat)
  {
    this.alX = paramFloat;
    return this;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolygonOptions
 * JD-Core Version:    0.7.0.1
 */