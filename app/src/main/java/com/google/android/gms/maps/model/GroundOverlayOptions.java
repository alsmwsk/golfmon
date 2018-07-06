package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final e CREATOR = new e();
  public static final float NO_DIMENSION = -1.0F;
  private final int CK;
  private float alQ;
  private float alX;
  private boolean alY = true;
  private BitmapDescriptor ama;
  private LatLng amb;
  private float amc;
  private float amd;
  private LatLngBounds ame;
  private float amf = 0.0F;
  private float amg = 0.5F;
  private float amh = 0.5F;
  
  public GroundOverlayOptions()
  {
    this.CK = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.CK = paramInt;
    this.ama = new BitmapDescriptor(d.a.ap(paramIBinder));
    this.amb = paramLatLng;
    this.amc = paramFloat1;
    this.amd = paramFloat2;
    this.ame = paramLatLngBounds;
    this.alQ = paramFloat3;
    this.alX = paramFloat4;
    this.alY = paramBoolean;
    this.amf = paramFloat5;
    this.amg = paramFloat6;
    this.amh = paramFloat7;
  }
  
  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.amb = paramLatLng;
    this.amc = paramFloat1;
    this.amd = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.amg = paramFloat1;
    this.amh = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.alQ = ((360.0F + paramFloat % 360.0F) % 360.0F);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.amg;
  }
  
  public float getAnchorV()
  {
    return this.amh;
  }
  
  public float getBearing()
  {
    return this.alQ;
  }
  
  public LatLngBounds getBounds()
  {
    return this.ame;
  }
  
  public float getHeight()
  {
    return this.amd;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.ama;
  }
  
  public LatLng getLocation()
  {
    return this.amb;
  }
  
  public float getTransparency()
  {
    return this.amf;
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
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.ama = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.alY;
  }
  
  IBinder od()
  {
    return this.ama.nA().asBinder();
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (this.ame == null)
    {
      bool2 = bool1;
      jx.a(bool2, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label60;
      }
      bool3 = bool1;
      label26:
      jx.b(bool3, "Location must be specified");
      if (paramFloat < 0.0F) {
        break label66;
      }
    }
    for (;;)
    {
      jx.b(bool1, "Width must be non-negative");
      return a(paramLatLng, paramFloat, -1.0F);
      bool2 = false;
      break;
      label60:
      bool3 = false;
      break label26;
      label66:
      bool1 = false;
    }
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    label29:
    boolean bool4;
    if (this.ame == null)
    {
      bool2 = bool1;
      jx.a(bool2, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label80;
      }
      bool3 = bool1;
      jx.b(bool3, "Location must be specified");
      if (paramFloat1 < 0.0F) {
        break label86;
      }
      bool4 = bool1;
      label46:
      jx.b(bool4, "Width must be non-negative");
      if (paramFloat2 < 0.0F) {
        break label92;
      }
    }
    for (;;)
    {
      jx.b(bool1, "Height must be non-negative");
      return a(paramLatLng, paramFloat1, paramFloat2);
      bool2 = false;
      break;
      label80:
      bool3 = false;
      break label29;
      label86:
      bool4 = false;
      break label46;
      label92:
      bool1 = false;
    }
  }
  
  public GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (this.amb == null) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Position has already been set using position: " + this.amb);
      this.ame = paramLatLngBounds;
      return this;
    }
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      jx.b(bool, "Transparency must be in the range [0..1]");
      this.amf = paramFloat;
      return this;
    }
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.alY = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (aa.ob())
    {
      f.a(this, paramParcel, paramInt);
      return;
    }
    e.a(this, paramParcel, paramInt);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.alX = paramFloat;
    return this;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.GroundOverlayOptions
 * JD-Core Version:    0.7.0.1
 */